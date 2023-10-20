package org.example.service;

import org.example.WiseSayingRepository.WiseSayingRepository;
import org.example.entity.WiseSaying;

import java.util.List;

public class WiseSayingService { // 데이터 관련된 것들 전부 service로 넘어감 repository에서 정리시킨 값을 정리해주는 클래스 , 요리 메인

    private final WiseSayingRepository wiseSayingRepository;

    public WiseSayingService() {
        wiseSayingRepository = new WiseSayingRepository();
    }

    public long write (String content, String author) {
        long id = wiseSayingRepository.write(content, author);
        return id;
    }

    public void remove (WiseSaying wiseSaying) {
        wiseSayingRepository.remove(wiseSaying);
    }

    public void modify (WiseSaying wiseSaying, String author, String content) {
        wiseSayingRepository.modify(wiseSaying, author, content);
    }

    public WiseSaying findById (int id) {
        return wiseSayingRepository.findById(id);
    }

    public List<WiseSaying> findByAll() {
        List<WiseSaying> wiseSayings = wiseSayingRepository.findByAll();
        return wiseSayings;
        //return wiseSayingRepository.findByAll(); 도 가능
    }
}