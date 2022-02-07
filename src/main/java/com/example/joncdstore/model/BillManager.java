package com.example.joncdstore.model;

import java.io.*;
import java.util.ArrayList;

public class BillManager {

    private static String billName = "bill";

    public BillManager() {

    }

    public void createBill(Bill b,User u) {
        try {
            File f1 = new File(billName + b.getBillNr() + ".txt");
            PrintWriter f2 = new PrintWriter(f1);
            f2.write(b.writetoBill(u));
            f2.close();
            Statistics.pushStatistics();
        } catch (IOException e) {
            System.out.println("Create Bill unsuccessful!\n" + e);
        }
    }


    public void deleteBill(int nr) {
        File f1 = new File(billName + nr + ".txt");
        if (f1.exists())
            f1.delete();
    }
}
