package org.example.system.title.entity;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Member;


@Getter
@Setter
public class Title {

    private long id;
    private String titleName;
    private String content;

    public Title(long id, String titleName, String content){
        this.id = id;
        this.titleName = titleName;
        this.content = content;
    }

}
