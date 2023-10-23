package org.example;

import org.example.system.controller.SystemController;
import org.example.system.title.controller.TitleController;
import org.example.system.title.entity.Title;

public class App {
    public void run(){
        TitleController titleController = new TitleController();
        SystemController systemController = new SystemController();

        System.out.println("== 프로그램 시작 ==");

        while (true){
            System.out.print("명령어)");
            String command = Container.getSc().nextLine().trim();
            Request request = new Request(command);

            if (command.equals("종료")){
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
            }
        }
    }
}
