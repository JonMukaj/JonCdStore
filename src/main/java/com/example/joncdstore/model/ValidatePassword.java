package com.example.joncdstore.model;

public interface ValidatePassword {
    public abstract boolean checkPassword(String s);

    public abstract boolean matchPassword(String s1,String s2);

}

//^(?=(\D*\d){2,})(?=.*[A-Z])(?=.*[a-zA-Z0-9]){10,}$