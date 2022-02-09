package com.example.joncdstore.controller;

import com.example.joncdstore.model.Statistics;
import com.example.joncdstore.model.User;
import com.example.joncdstore.model.UserManager;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FinancesController {

    private FinancesController() {
    }

    public static double getTotalSalary() {
        double salary = 0;
        UserManager userManager = new UserManager();
        userManager.readUser();
        for(User i: userManager.getUserList()) {
            salary += i.getSalary();
        }
        return salary;
    }

    public static double showMessage(double salary) {
        return Statistics.getRevenue() - (Statistics.getCost()+salary);
    }

    public static void returnMenu(Stage stage, Scene oldScene) {
        stage.setTitle("CD WORLD");
        stage.setScene(oldScene);

    }

}
