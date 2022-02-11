package com.example.joncdstore.model;

import com.example.joncdstore.controller.EmployeeController;
import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public abstract class Bill implements CustomDate{
    private ArrayList<CD> items = new ArrayList<>();
    private int billNr;
    private final Date date = new Date();
    private final String dateOfTransaction = formatDate(date);
    private double priceOfTransaction;
    private String type;

    @Override
    public String formatDate(Date date) {
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        return DateFor.format(date);
    }

    public ArrayList<CD> getItems() {
        return items;
    }

    public int getBillNr() {
        return billNr;
    }

    public String getDateOfTransaction() {
        return dateOfTransaction;
    }

    public double getPriceOfTransaction() {
        return priceOfTransaction;
    }

    public String getType() {
        return type;
    }


    public String writetoBill(@NotNull User u) {
        String text = "Bill Nr." + getBillNr() + "\n" +
                        "Date: " + dateOfTransaction + "\n" +
                        "Type: " + type + "\n" +
                        "Operator: " + u.getName() + " " + u.getSurname() + "\n" +
                        "---------------------List of items---------------------" + "\n";
        CdManager cdManager = new CdManager(type);
        cdManager.setCdList(items);

        int nrOfCDsold = 0;
        for(CD i : cdManager.getCdList()) {
            nrOfCDsold += i.getTmpQuantity();
        }

        int nrOfCDbought = 0;
        for(CD i : cdManager.getCdList()) {
            nrOfCDbought += i.getTotalQuantity();
        }

        String price = "Total: " + priceOfTransaction + "\n";

        if (type.equals("Purchase")) {
            u.setBillBought(u.getBillBought() + 1);
            Statistics.setTotalNrOfCdBought(Statistics.getTotalNrOfCdBought() + nrOfCDbought);
            Statistics.setTotalNrOfBillBought(Statistics.getTotalNrOfBillBought() + 1);
            String tmp = String.format("%.2f",priceOfTransaction);
            Statistics.setCost(Statistics.getCost() + Double.parseDouble(tmp));
        }

        else {
            u.setBillSold(u.getBillSold() + 1);
            Statistics.setTotalNrOfCdSold(Statistics.getTotalNrOfCdSold()+ nrOfCDsold);
            Statistics.setTotalNrOfBillSold(Statistics.getTotalNrOfBillSold() + 1);
            String tmp = String.format("%.2f",priceOfTransaction);
            Statistics.setRevenue(Statistics.getRevenue() + Double.parseDouble(tmp));
        }

        EmployeeController.saveModifyChanges(u);

        /*
        System.out.println(u.getCdBought());
        System.out.println(u.getBillBought());
        System.out.println(u.getBillSold());
        System.out.println(u.getCdSold());*/

        return text + cdManager.showCD() + "\n" + price;
    }

    public void setItems(ArrayList<CD> items) {
        this.items = items;
    }

    public void setPriceOfTransaction(double priceOfTransaction) {
        this.priceOfTransaction = priceOfTransaction;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBillNr(int billNr) {
        this.billNr = billNr;
    }
}
