package org.example.entity;

public class WiseSaying {//private로 설정한 변수들을 저장하는 공간 즉, 명언저장공간 , 저장공간
    private long id;
    private String content;
    private String author;

    public WiseSaying(long id, String content, String author){
        this.id = id;
        this.content = content;
        this.author = author;
    }
    public long getId() {
        return id;
    }
    public String getContent() {
        return content;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor (String author) {
        this.author = author;
    }
    public void setContent (String content) {
        this.content = content;
    }
}