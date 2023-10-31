package org.example.system.title.controller;


import org.example.Container;
import org.example.Request;
import org.example.system.title.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingController {
    List<WiseSaying> wiseSayings = new ArrayList<>();
    long wiseSayingLast = 0;
    public void write(){
        long id = wiseSayingLast + 1;
        System.out.print("명언 :");
        String content = Container.getSc().nextLine().trim();
        System.out.print("작가 :");
        String author = Container.getSc().nextLine().trim();

        System.out.println(id + "번 명언이 등록되었습니다.");
        WiseSaying wiseSaying = new WiseSaying(id, author, content);
        wiseSayings.add(wiseSaying);

        wiseSayingLast++;

    }
    public void list(){
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-".repeat(17));
        for (int i = wiseSayings.size() - 1; i >= 0; i--){
            WiseSaying wiseSaying = wiseSayings.get(i);
            System.out.printf("%d, %s, %s\n",wiseSaying.getId(),wiseSaying.getAuthor(),wiseSaying.getContent());
        }
        System.out.println("명언이 출력되었습니다.");
    }
    public void remove(Request request){
        int id = request.DefaultValue("id", -1);

        if (id == -1){
            System.out.println("정수를 입력해주세요.");
            return;
        }

        WiseSaying wiseSaying = findById(id);

        if (wiseSaying == null){
            System.out.println("다시 입력해주세요.");
            return;
        }

        wiseSayings.remove(wiseSaying);

        System.out.println(id + "번 목록이 삭제되었습니다.");
    }
    public void modify(Request request){
        int id = request.DefaultValue("id", -1);

        if (id == -1){
            System.out.println("정수를 입력해주세요.");
            return;
        }

        WiseSaying wiseSaying = findById(id);

        if (wiseSaying == null){
            System.out.println("다시 입력해주세요.");
            return;
        }
        System.out.printf("기존 명언 :%s\n",wiseSaying.getContent());
        System.out.print("명언 :");
        String content = Container.getSc().nextLine().trim();
        System.out.printf("기존 작가 :%s\n",wiseSaying.getContent());
        System.out.print("작가 :");
        String author = Container.getSc().nextLine().trim();

        wiseSaying.setContent(content);
        wiseSaying.setAuthor(author);

        System.out.println(id + "번 명언이 수정되었습니다.");
    }
    public WiseSaying findById(int id){
        for (WiseSaying wiseSaying : wiseSayings){
            if (wiseSaying.getId() == id){
                return wiseSaying;
            }
        }
        return null;
    }
}
