package com.example.joncdstore.model;

import java.io.*;

public class CD implements Serializable {

    private String titleOfCd;
    private String genre;
    private String author;
    private double purchasedPrice;
    private double sellingPrice;
    private static int quantityOfCD;

    public CD(String titleOfCd, String genre, String author,double purchasedPrice,double sellingPrice,int quantityOfCD) {
        this.titleOfCd = titleOfCd;
        this.genre = genre;
        this.author = author;
        this.purchasedPrice = purchasedPrice;
        this.sellingPrice = sellingPrice;
        this.quantityOfCD += quantityOfCD;
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

    public int getQuantityOfCD() {
        return quantityOfCD;
    }

    //setters

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    @Override
    public String toString() {
        return "CD{" +
                "titleOfCd='" + titleOfCd + '\'' +
                ", genre='" + genre + '\'' +
                ", author='" + author + '\'' +
                ", purchasedPrice=" + purchasedPrice +
                ", sellingPrice=" + sellingPrice +
                '}';
    }
}
