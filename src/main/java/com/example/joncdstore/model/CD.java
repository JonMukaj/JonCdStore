package com.example.joncdstore.model;

import java.io.*;

public class CD implements Serializable {

    private static final long serialVersionUID = -8845236125637035006L;

    private final String titleOfCd;
    private final String genre;
    private final String author;
    private final double purchasedPrice;
    private double sellingPrice;
    private int totalQuantity;
    private int tmpQuantity;

    public CD(String titleOfCd, String genre, String author,double purchasedPrice,double sellingPrice,int quantity) {
        this.titleOfCd = titleOfCd;
        this.genre = genre;
        this.author = author;
        this.purchasedPrice = purchasedPrice;
        this.sellingPrice = sellingPrice;
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

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public void setTmpQuantity(int tmpQuantity) {
        this.tmpQuantity = tmpQuantity;
    }

    public String toString(String type) {
        if (type.equals("Purchase")) {
            return titleOfCd + " " + genre + " " + author + " " + Math.abs(purchasedPrice) + " x " + tmpQuantity + "\n";
        }
        else if (type.equals("Sell")){
            return titleOfCd + " " + genre + " " + author + " " + sellingPrice + " x " + tmpQuantity + "\n";
        }
        return "";
    }
}
