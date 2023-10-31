package org.example.system.title.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
    private long id;
    private String userId;
    private String password;
    public Customer(long id, String userId, String password){
        this.id = id;
        this.userId = userId;
        this.password = password;
    }

}
