package com.example.demo.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;



@Component
@Document(collection = "user")
public class UserEntity {
    private String userName;
    private String userEmail;
    private String userPassword;
    private String memberId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
}
