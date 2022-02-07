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


    public String writetoBill(User u) {
        String text = "Bill Nr." + getBillNr() + "\n" +
                        "Date: " + date + "\n" +
                        "Type: " + type + "\n" +
                        "Operator: " + u.getName() + " " + u.getSurname() + "\n" +
                        "---------------------List of items---------------------" + "\n";
        CdManager cdManager = new CdManager(type);
        cdManager.setCdList(items);

        int nrOfCD = 0;
        for(CD i : cdManager.getCdList()) {
            nrOfCD += i.getTmpQuantity();
        }

        String price = "Total: " + priceOfTransaction + "\n";

        if (type.equals("Purchase")) {
            u.setNrOfBillBought(u.getNrOfBillBought() + 1);
            Statistics.setTotalNrOfCdBought(Statistics.getTotalNrOfCdBought() + nrOfCD);
            Statistics.setTotalNrOfBillBought(Statistics.getTotalNrOfBillBought() + 1);
            String tmp = String.format("%.2f",priceOfTransaction);

            Statistics.setCost(Statistics.getCost() + Double.parseDouble(tmp));
        }

        else {
            u.setNrOfBillSold(u.getNrOfBillSold() + 1);
            Statistics.setTotalNrOfCdSold(Statistics.getTotalNrOfCdSold()+ nrOfCD);
            Statistics.setTotalNrOfBillSold(Statistics.getTotalNrOfBillSold() + 1);
            String tmp = String.format("%.2f",priceOfTransaction);
            Statistics.setRevenue(Statistics.getRevenue() + Double.parseDouble(tmp));
        }

        System.out.println(u.getNrOfCdBought());
        System.out.println(u.getNrOfBillBought());
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
