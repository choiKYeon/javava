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
            if (command.equals("종료")) {
                systemController.exit();
                break;
            } else if (command.equals("등록")) {
                titleController.write();
            } else if (command.equals("목록")) {
                titleController.list();
            } else if (command.startsWith("삭제")) {
                titleController.remove(request);
            } else if (command.startsWith("수정")) {
                titleController.modify(request);
            } else if (command.equals("회원가입")) {
                titleController.member();
            } else if (command.equals("로그인")) {
                titleController.login();
            }
        }
    }
}
