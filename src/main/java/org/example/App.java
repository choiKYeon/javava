package org.example;


import org.example.system.controller.DefaultCommand;
import org.example.system.controller.SystemController;
import org.example.system.title.controller.CustomerController;
import org.example.system.title.controller.WiseSayingController;
import org.example.db.DBConnection;

public class App {
    public App () {
        DBConnection.DB_NAME = "proj1";
        DBConnection.DB_USER = "root";
        DBConnection.DB_PASSWORD = "";
        DBConnection.DB_PORT = 3306;

        Container.getDBconnection().connect();
//        Container.getDBconnection().insert(
//                "INSERT INTO article\n" +
//                "SET id = 4,\n" +
//                "author = \"test1\",\n" +
//                "content = \"test1\",\n" +
//                "regDate = NOW();");
//        Container.getDBconnection().delete(
//                "DELETE * FROM article"
//        );
    }
SystemController systemController = new SystemController();
WiseSayingController wiseSayingController = new WiseSayingController();
CustomerController customerController = new CustomerController();
DefaultCommand defaultCommand = new DefaultCommand();
    public void run() {

        while (true) {
            System.out.println("\n== 명언 앱 ==");
            System.out.print("명령 :");
            String command = Container.getSc().nextLine().trim();
            Request request = new Request(command);

            switch (Request.getActioncode()){
                case "종료":
                    systemController.exit();
                    return;
                case "등록":
                    wiseSayingController.write();
                    break;
                case "목록":
                    wiseSayingController.list();
                    break;
                case "삭제":
                    wiseSayingController.remove(request);
                    break;
                case "수정":
                    wiseSayingController.modify(request);
                    break;
                case "회원가입":
                    customerController.sign();
                    break;
                case "로그인":
                    customerController.login();
                    break;
                case "로그아웃":
                    customerController.logout();
                    break;
                default:
                    defaultCommand.falseCommand();
                    break;
            }
        }
    }
}
