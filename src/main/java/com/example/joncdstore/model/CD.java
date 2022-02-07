package com.example.joncdstore.model;

import java.io.*;

public class CD implements Serializable {

    private static final long serialVersionUID = -8845236125637035006L;

    private final String titleOfCd;
    private final String genre;
    private final String author;
    private double purchasedPrice;
    private double sellingPrice;
    private int totalQuantity;
    private int tmpQuantity;

    public CD(String titleOfCd, String genre, String author,double purchasedPrice,double sellingPrice,int quantity) {
        String tmp;
        this.titleOfCd = titleOfCd;
        this.genre = genre;
        this.author = author;
        tmp = String.format("%.2f",purchasedPrice);
        this.purchasedPrice = Double.parseDouble(tmp);

        tmp = String.format("%.2f",sellingPrice);
        this.sellingPrice = Double.parseDouble(tmp);
        this.totalQuantity = quantity;
    }

    //getters
    public String getTitleOfCd() {
        return titleOfCd;
    }

    public String getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }

    public double getPurchasedPrice() {
        return purchasedPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public int getTmpQuantity() {
        return tmpQuantity;
    }
//setters
    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public void setTmpQuantity(int tmpQuantity) {
        this.tmpQuantity = tmpQuantity;
    }

    public void setPurchasedPrice(double purchasedPrice) {
        this.purchasedPrice = purchasedPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String toString(String type) {
        if (type.equals("Purchase")) {
            return titleOfCd + " " + genre + " " + author + " " + Math.abs(purchasedPrice) + " x " + totalQuantity + "\n";
        }
        else if (type.equals("Sell")){
            return titleOfCd + " " + genre + " " + author + " " + sellingPrice + " x " + tmpQuantity + "\n";
        }
        return "";
    }
}
