package com.example.joncdstore.controller;

import com.example.joncdstore.model.Statistics;
import com.example.joncdstore.model.User;
import com.example.joncdstore.model.UserManager;
import com.example.joncdstore.view.SupplyView;
import com.example.joncdstore.view.graphs;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

public class StatisticsController {
    private StatisticsController() {

    }

    public static void deleteStatistics() {
        File f1 = new File("statistics.txt");
        f1.delete();
        Statistics.setRevenue(0.0);
        Statistics.setCost(0.0);
        Statistics.setTotalNrOfCdSold(0);
        Statistics.setTotalNrOfCdBought(0);
        Statistics.setTotalNrOfBillSold(0);
        Statistics.setTotalNrOfBillBought(0);
    }

    public static void deleteUser() {
        File f1 = new File("user.ser");
        f1.delete();
    }

    public static void deleteCD() {
        File f1 = new File("cd.ser");
        f1.delete();
    }

    public static void createGraphScene(User u, Stage stage) {
        stage.setTitle("Statistics");
        Scene oldScene = stage.getScene();
        stage.setScene(new graphs(u,stage,oldScene).generateGraphsScene());
    }

    public static double getSalaryByPrivilege(int privilege) {
        UserManager userManager = new UserManager();
        userManager.readUser();
        double salary = 0;
        for(User u: userManager.getUserList()) {
            if (u.getPrivilege() == privilege) {
                salary += u.getSalary();
            }
        }

        return salary;
    }

    public static double getTotalSalary() {
        UserManager userManager = new UserManager();
        userManager.readUser();
        double salary = 0;
        for(User u: userManager.getUserList()) {
            salary += u.getSalary();
        }

        return salary;
    }

    public static void returnStatistics(User u, Stage stage,Scene oldScene) {
        stage.setTitle("CD WORLD");
        stage.setScene(oldScene);

    }


}
