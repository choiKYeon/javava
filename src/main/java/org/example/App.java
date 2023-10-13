package org.example;

import org.example.controller.SystemController;
import org.example.wisesayingcontroller.WiseSayingController;

import java.util.HashMap;
import java.util.Map;

public class App {
    public void run() {
        SystemController systemController = new SystemController();
        WiseSayingController wiseSayingController = new WiseSayingController();

        System.out.println("== 입력 ==");

        while (true) {
            System.out.printf("명령)");
            String answer = Container.getSc().nextLine().trim();

            if (answer.equals("종료")) {
                systemController.exit();
                break;
            } else if (answer.equals("등록")) {
                wiseSayingController.write();
            } else if (answer.equals("목록")) {
                wiseSayingController.list();
            } else if (answer.startsWith("삭제")) {
                ReQuest request = new ReQuest(answer);
                WiseSayingController.remove();
            }
        }
    }
}