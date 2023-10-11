package wisesaying.controller;

import wisesaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private Scanner sc;

    public WiseSayingController(Scanner sc) {
        this.sc = sc;
    }

    public void write() {
        List<WiseSaying> wiseSayings = new ArrayList<>();

        System.out.println("등록합니다");

        long id = a + 1;

        System.out.print("명언 : ");
        String content = sc.nextLine().trim();
        System.out.print("작가 : ");
        String author = sc.nextLine().trim();
        System.out.printf("%d번 명언이 등록되었습니다.\n", id);

        WiseSaying wiseSaying = new WiseSaying(id, author, content);
        wiseSayings.add(wiseSaying);

        a++;

    }

    public void list() {
        System.out.println("목록 출력 합니다");
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-----------------");
        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying = wiseSayings.get(i);
            System.out.printf("%d, %s, %s\n", wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent());
        }
    }
}
