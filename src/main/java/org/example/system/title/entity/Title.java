package org.example.system.title.entity;

public class Title {
    private long id;
    private String titleName;
    private String content;
    public Title(long id, String titleName, String content){
        this.id = id;
        this.titleName = titleName;
        this.content = content;
    }
    public long getId() {
        return id;
    }
    public String getTitleName() {
        return titleName;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }
}
