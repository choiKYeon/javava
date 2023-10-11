package wisesaying;

import systemcontroller.controller.SystemController;
import wisesaying.controller.WiseSayingController;
import wisesaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private final Scanner sc;

    // public App 과 public void setApp 과 같은 의미
    public App(Scanner sc){
        this.sc = sc;
    }

    public void run() {
        SystemController systemController = new SystemController();
        WiseSayingController wiseSayingController =new WiseSayingController(sc);
        System.out.println("== 명언 앱 ==");

        long a = 0;

        long num = 0;

        List<WiseSaying> wiseSayings = new ArrayList<>();
        //wiseSayings에 배열을 선언

        while (true) {
            System.out.print("명령) ");
            String command = sc.nextLine().trim();
            if (command.equals("종료")) {

                systemController.exit();
                break;

            } else if (command.equals("등록")) {
                wiseSayingController.write();
//
//                long id = a+1;
//
//                System.out.print("명언 : ");
//                String content = sc.nextLine().trim();
//                System.out.print("작가 : ");
//                String author = sc.nextLine().trim();
//                System.out.printf("%d번 명언이 등록되었습니다.\n", id);
//
//                WiseSaying wiseSaying = new WiseSaying(id, author, content);
//                wiseSayings.add(wiseSaying);
//
//                a++;

            } else if (command.equals("목록")) {
                wiseSayingController.list();
//                System.out.println("번호 / 작가 / 명언");
//                System.out.println("-----------------");
//                for (int i = wiseSayings.size() - 1; i >= 0; i--){
//                    WiseSaying wiseSaying = wiseSayings.get(i);
//                    System.out.printf("%d, %s, %s\n", wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent());
                }
            }



    }
}

