package com.tubespbo.model;

public class User {
    private String username;
    private String password;


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter untuk userName
    public String getUsername() {
        return this.username;
    }

    // Setter untuk userName
    public void setUsername(String userName) {
        this.username = userName;
    }

    // Getter untuk password
    public String getPassword() {
        return this.password;
    }

    // Setter untuk password
    public void setPassword(String password) {
        this.password = password;
    }
}
