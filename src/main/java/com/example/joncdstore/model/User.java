package com.example.joncdstore.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class User implements Serializable,Cloneable,CustomDate {
    private static final long serialVersionUID = -9219894574363813548L;

    private final UUID id;
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
    private String employmentDate;
    private String profession;

    public User() {
        this.id = UUID.randomUUID();
        this.employmentDate = formatDate(new Date());
    }
    public User(String username,String password, int privilege,String name, String surname,String birthday,GENDER gender,String phone,String email,double salary) {
        this.id = UUID.randomUUID();
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
        this.employmentDate = formatDate(new Date());
        this.profession = formatPrivilege(this.privilege);
    }

    public UUID getId() {
        return id;
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

    public String getEmploymentDate() {
        return employmentDate;
    }

    public String getProfession() {
        return profession;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", privilege=" + privilege +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", employmentDate='" + employmentDate + '\'' +
                ", profession='" + profession + '\'' +
                '}';
    }


    public String formatPrivilege(int p) {
        if (p == 1) return "Admin";
        else if (p == 2) return "Manager";
        else return "Cashier";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {

        return super.clone();
    }

    @Override
    public String formatDate(Date date) {
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        return DateFor.format(date);
        //u.setBirthday(DateFor.format(formatedDate));
    }

    public String checkPrivilege() {
        if(privilege == 1) return "Admin";
        else if (privilege == 2) return "Manager";
        else return "Cashier";
    }

    public void setUsername(String username) {
        this.username = username;
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

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
