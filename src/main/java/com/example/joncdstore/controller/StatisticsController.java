package com.example.joncdstore.controller;

import com.example.joncdstore.model.Statistics;

import java.io.File;

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
}
