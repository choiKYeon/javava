package org.example.system.title.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Title {

    private long id;
    private String titleName;
    private String content;
    private String userId;

    public Title(long id, String titleName, String content, String userId){
        this.id = id;
        this.titleName = titleName;
        this.content = content;
        this.userId = userId;
    }

}
