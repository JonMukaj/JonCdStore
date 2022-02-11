package com.example.joncdstore.controller;

import com.example.joncdstore.model.User;
import com.example.joncdstore.model.UserManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import java.util.ArrayList;


public class PerformanceController {
    private PerformanceController() {}

    public static void createCashierTable(TableView<User> t) {
        ArrayList<User> uCashier = new ArrayList<>();
        UserManager userManager = new UserManager();
        userManager.readUser();

        for(User u : userManager.getUserList()) {
            if (u.getPrivilege() == 3) {
                uCashier.add(u);
            }
        }

        ObservableList<User> users = FXCollections.observableArrayList(uCashier);
        t.setItems(users);
    }

    public static void createManagerTable(TableView<User> t) {
        ArrayList<User> uManager = new ArrayList<>();
        UserManager userManager = new UserManager();
        userManager.readUser();

        for(User u : userManager.getUserList()) {
            if (u.getPrivilege() == 2) {
                uManager.add(u);
            }
        }


        ObservableList<User> users = FXCollections.observableArrayList(uManager);
        t.setItems(users);
    }
}
