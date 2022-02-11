package com.example.joncdstore.model;

import java.io.*;
import java.util.ArrayList;

public class BillManager {

    private static String billName = "bill";

    public BillManager() {

    }

    public void createBill(Bill b,User u) {
        try {
            String folder = System.getProperty("user.home");
            File dir = new File(folder + "\\BillFolder");
            dir.mkdirs();


            String filename = billName + b.getBillNr() + ".txt";
            File f1 = new File(dir.getAbsolutePath() + "\\" + filename);
            PrintWriter f2 = new PrintWriter(f1);
            f2.write(b.writetoBill(u));
            f2.close();
            Statistics.pushStatistics();

            ProcessBuilder p = new ProcessBuilder("Notepad.exe", dir.getAbsolutePath() + "\\" + filename);
            p.start();
        } catch (IOException e) {
            System.out.println("Create Bill unsuccessful!\n" + e);
        }
    }
}
