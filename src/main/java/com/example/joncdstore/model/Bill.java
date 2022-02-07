package com.example.joncdstore.model;

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


    public String writetoBill() {
        String text = "Bill Nr." + getBillNr() + "\n" +
                        "Date: " + date + "\n" +
                        "Type: " + type + "\n" +
                        "---------------------List of items---------------------" + "\n";
        CdManager cdManager = new CdManager(type);
        cdManager.setCdList(items);

        String price = "Total: " + Math.abs(priceOfTransaction) + "\n";

        if (type.equals("Purchase"))
            Statistics.setTotalNrOfBillBought(Statistics.getTotalNrOfBillBought() + 1);
        else
            Statistics.setTotalNrOfBillSold(Statistics.getTotalNrOfBillSold() + 1);
        return text + cdManager.showCD() + price;
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
