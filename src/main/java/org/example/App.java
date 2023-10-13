package org.example;

import org.example.controller.SystemController;
import org.example.wisesayingcontroller.WiseSayingController;

public class App {
    public void run() {
        SystemController systemController = new SystemController();
        WiseSayingController wiseSayingController = new WiseSayingController();
        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령) ");
            String command = Container.getSc().nextLine().trim();

            // 삭제?id=1
            Request request = new Request(command);

            switch (request.getActionCode()) {
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
            }
        }
    }
}