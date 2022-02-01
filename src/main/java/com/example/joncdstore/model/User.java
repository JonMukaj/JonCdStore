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
    public User(String username,String password, int privilege,String name, String surname,String birthday,String phone,String email,double salary) {
        this.username = username;
        this.password = password;
        this.privilege = privilege;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
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
