package org.example.system.title.entity;

public class Customer {
    private long id;
    private String userid;
    private long password;
    public Customer(long id, String userid, long password){
        this.id = id;
        this.userid = userid;
        this.password = password;
    }
    public long getId() {
        return id;
    }
    public String getUserId() {
        return userid;
    }
    public long getPassword() {
        return password;
    }
}
