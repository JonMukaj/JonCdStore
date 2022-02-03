package com.example.joncdstore.model;

import com.example.joncdstore.model.CD;
import com.example.joncdstore.model.User;

import java.io.*;
import java.util.ArrayList;

public class UserManager implements Serializable {
    private static final long serialVersionUID = 552968509826775790L;
    private ArrayList<User> userList;

    public UserManager () {
        //readUser();
    }

    public void addUser(ArrayList<User> u) {
        try {
            userList = u;
            FileOutputStream f1 = new FileOutputStream("user.ser");
            BufferedOutputStream f2 = new BufferedOutputStream(f1);
            ObjectOutputStream outObject = new ObjectOutputStream(f2);

            outObject.writeObject(userList);

            f2.close();
            outObject.close();

        } catch (IOException e) {
            System.out.println("Add users unsuccessful!\n" + e);
        }
    }

    public void readUser() {
        try {
            FileInputStream f1 = new FileInputStream("user.ser");
            BufferedInputStream f2 = new BufferedInputStream(f1);
            ObjectInputStream inObject = new ObjectInputStream(f2);

            userList = (ArrayList<User>) inObject.readObject();

            f1.close();
            f2.close();
            inObject.close();

            /*for (User u : userList) {
                System.out.println(u.toString());
            }*/


        } catch (ClassNotFoundException i) {
            System.out.println("Users cannot be found!\n" + i);
        } catch (IOException e) {
            System.out.println("Reading Users unsuccessful!\n" + e);
        }
    }

    public User checkUser(String username,String password) {
        for (User u : userList) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }
}
