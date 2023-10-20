package org.example.WiseSayingRepository;

import org.example.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository { // 처음에 입력받은 값들을 정리해주는 클래스 , 요리 서브
    long lastWiseSayingId = 0;
    List<WiseSaying> wiseSayings = new ArrayList<>();

    public long write (String content, String author) {
        long id = lastWiseSayingId + 1;

        WiseSaying wiseSaying = new WiseSaying(id, author, content);
        wiseSayings.add(wiseSaying);
        lastWiseSayingId = id;

        return id;
    }
    public void remove (WiseSaying wiseSaying) {
        wiseSayings.remove(wiseSaying);
    }
    public void modify (WiseSaying wiseSaying, String author, String content) {
        wiseSaying.setAuthor(author);
        wiseSaying.setContent(content);
    }

    public WiseSaying findById (int id) {
        for (WiseSaying wiseSaying : wiseSayings) {
            if (wiseSaying.getId() == id ) {
                return wiseSaying;
            }
        }
        return null;
    }

    public List<WiseSaying> findByAll() {
        return wiseSayings;
    }
}