package org.example.system.title.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
    private long id;
    private String userid;
    private long password;
    public Customer(long id, String userid, long password){
        this.id = id;
        this.userid = userid;
        this.password = password;
    }
}
