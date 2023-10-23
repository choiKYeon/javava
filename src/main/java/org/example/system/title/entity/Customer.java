package org.example.system.title.entity;

public class Customer {
    private long id;
    private String userId;
    private long password;
    public Customer(long id, String userId, long password){
        this.id = id;
        this.userId = userId;
        this.password = password;
    }
    public long getId() {
        return id;
    }
    public String getUserId() {
        return userId;
    }
    public long getPassword() {
        return password;
    }
}
