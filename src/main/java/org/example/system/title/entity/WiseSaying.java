package org.example.system.title.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WiseSaying {
    private long id;
    private String content;
    private String author;
    public WiseSaying(long id, String author, String content){
        this.id = id;
        this.author = author;
        this.content = content;
    }

}
