package org.example;

import org.example.system.controller.SystemController;
import org.example.system.title.controller.TitleController;

public class App {
    SystemController systemController = new SystemController();
    TitleController titleController = new TitleController();
    public void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령)");
            String command = Container.getSc().nextLine().trim();
            Request request = new Request(command);

            switch (request.getActioncode()){
                case "종료":
                    systemController.exit();
                    return;
                case "등록":
                    titleController.write();
                    break;
                case "목록":
                    titleController.list();
                    break;
                case "삭제":
                    titleController.remove(request);
                    break;
                case "수정":
                    titleController.modify(request);
                    break;
                case "회원가입":
                    titleController.member();
                    break;
                case "로그인":
                    titleController.login();
                    break;
                case "로그아웃":
                    titleController.logout();
                    break;
            }
        }
    }
}
