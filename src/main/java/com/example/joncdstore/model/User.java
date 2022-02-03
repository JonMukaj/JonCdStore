package com.example.joncdstore.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class User implements Serializable {
    private static final long serialVersionUID = -9219894574363813548L;

    private String username;
    private String password;
    private int privilege;
    private String name;
    private String surname;
    private String birthday;
    private GENDER gender;
    private String phone;
    private String email;
    private double salary;
    private Date employmentDate;

    public User(String username,String password, int privilege) {
        this.username = username;
        this.password = password;
        this.privilege = privilege;
    }

    //user constructor
    public User(String username,String password, int privilege,String name, String surname,String birthday,GENDER gender,String phone,String email,double salary) {
        this.username = username;
        this.password = password;
        this.privilege = privilege;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.salary = salary;
        this.employmentDate = new Date();
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getPrivilege() {
        return privilege;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthday() {
        return birthday;
    }

    public GENDER getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public double getSalary() {
        return salary;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", privilege=" + privilege +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", employmentDate=" + employmentDate +
                '}';
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setGender(GENDER gender) {
        this.gender = gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
