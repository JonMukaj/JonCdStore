package com.example.joncdstore.model;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Statistics {
    private static int totalNrOfCdSold;
    private static int totalNrOfCdBought;
    private static int totalNrOfBillSold;
    private static int totalNrOfBillBought;

    private static double revenue;
    private static double cost;

    private Statistics() {
    }

    public static void popStatistics() {
        try {
            File f1 = new File("statistics.txt");
            if (!f1.exists()) {
                Statistics.pushStatistics();
            }
            else {
                Scanner f2 = new Scanner(f1);
                totalNrOfCdSold = f2.nextInt();
                totalNrOfCdBought = f2.nextInt();
                totalNrOfBillSold = f2.nextInt();
                totalNrOfBillBought = f2.nextInt();
                revenue = f2.nextDouble();
                cost = f2.nextDouble();

                f2.close();
            }

        } catch (IOException e) {
            System.out.println("Pop Statistics unsuccessful!\n" + e);
        }
    }

    public static void pushStatistics() {
        try {
            File f1 = new File("statistics.txt");
            PrintWriter f2 = new PrintWriter(f1);
            String tmp = String.format("%.2f",revenue);
            Statistics.revenue = Double.parseDouble(tmp);

            tmp = String.format("%.2f",cost);
            Statistics.cost = Double.parseDouble(tmp);

            f2.write(totalNrOfCdSold + " ");
            f2.write(totalNrOfCdBought + " ");
            f2.write(totalNrOfBillSold + " ");
            f2.write(totalNrOfBillBought + " ");
            f2.write(revenue + " ");
            f2.write(cost + " ");

            f2.close();

        } catch (IOException e) {
            System.out.println("Push Statistics unsuccessful!\n" + e);
        }
    }


    public static int getTotalNrOfCdSold() {
        return totalNrOfCdSold;
    }

    public static int getTotalNrOfCdBought() {
        return totalNrOfCdBought;
    }

    public static int getTotalNrOfBillSold() {
        return totalNrOfBillSold;
    }

    public static int getTotalNrOfBillBought() {
        return totalNrOfBillBought;
    }

    public static double getRevenue() {
        return revenue;
    }

    public static double getCost() {
        return cost;
    }

    public static void setTotalNrOfCdSold(int totalNrOfCdSold) {
        Statistics.totalNrOfCdSold = totalNrOfCdSold;
    }

    public static void setTotalNrOfCdBought(int totalNrOfCdBought) {
        Statistics.totalNrOfCdBought = totalNrOfCdBought;
    }

    public static void setTotalNrOfBillSold(int totalNrOfBillSold) {
        Statistics.totalNrOfBillSold = totalNrOfBillSold;
    }

    public static void setTotalNrOfBillBought(int totalNrOfBillBought) {
        Statistics.totalNrOfBillBought = totalNrOfBillBought;
    }

    public static void setRevenue(double revenue) {
        Statistics.revenue = revenue;
    }

    public static void setCost(double cost) {
        Statistics.cost = cost;
    }
}
