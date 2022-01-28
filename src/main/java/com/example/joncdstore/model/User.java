package com.example.joncdstore.model;

import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable {
    private final String ID;
    private String username;
    private String password;
    private int privilege;

    //default user
    public User () {
        this(0,"","",3);
    }

    //custom user
    public User(int ID,String username,String password, int privilege) {
        this.ID = UUID.randomUUID().toString();
        this.setUsername(username);
        this.setPassword(password);
        this.setPrivilege(privilege);
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPrivilege() {
        return privilege;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID='" + ID + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", privilege=" + privilege +
                '}';
    }
}
