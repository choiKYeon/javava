package org.example.wisesayingcontroller;

import org.example.Container;
import org.example.Request;
import org.example.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingController {
    long lastWiseSayingId = 0;
    List<WiseSaying> wiseSayings = new ArrayList<>();
    public void write() {
        long id = lastWiseSayingId + 1;
        System.out.print("명언 : ");
        String content = Container.getSc().nextLine().trim();
        System.out.print("작가 : ");
        String author = Container.getSc().nextLine().trim();
        System.out.printf("%d번 명언이 등록 되었습니다.\n", id);
        WiseSaying wiseSaying = new WiseSaying(id, author, content);
        wiseSayings.add(wiseSaying);
        lastWiseSayingId = id;
    }
    public void list() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-".repeat(30));
        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying = wiseSayings.get(i);
            System.out.printf("%d, %s, %s\n", wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent());
        }
    }
    public void remove(Request request) {
            int id = -1;
            try {
                id = Integer.parseInt(request.getParam("id"));
            } catch (NumberFormatException e) {
                System.out.println("id 정수 값을 입력하세요.");
                return;
            }
            System.out.println(id + "번 명언이 삭제 되었습니다.");
    }
}