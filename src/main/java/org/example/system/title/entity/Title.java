package org.example.system.title.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Title {
    private long id;
    private String content;
    private String author;
    public Title(long id, String content, String author){
        this.id = id;
        this.content = content;
        this.author = author;
    }

}
