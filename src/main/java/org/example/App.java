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

            switch (request.getActioncode()){
                case "종료" :
                    systemController.exit();
                    return;
                case "회원가입" :
                    titleController.member();
                    break;
                case "고객목록" :
                    titleController.customerlist();
                    break;
                case "등록" :
                    titleController.write();
                    break;
                case "목록" :
                    titleController.list();
                    break;
                case "삭제" :
                    titleController.remove(request);
                    break;
                case "수정" :
                    titleController.modify(request);
                    break;
            }
        }
    }
}
