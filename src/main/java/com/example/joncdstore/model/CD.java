package com.example.joncdstore.model;

import java.io.*;

public class CD implements Serializable {
    private static final long serialVersionUID = -5083759422249745403L;

    private String titleOfCd;
    private String genre;
    private String author;
    private double purchasedPrice;
    private int quantityOfCD;

    public CD(String titleOfCd, String genre, String author,double priceOfCD,int quantityOfCD) {
        this.titleOfCd = titleOfCd;
        this.genre = genre;
        this.author = author;
        this.purchasedPrice = priceOfCD;
        this.quantityOfCD = quantityOfCD;
    }

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

    public int getQuantityOfCD() {
        return quantityOfCD;
    }

    @Override
    public String toString() {
        return "CD{" +
                "titleOfCd='" + titleOfCd + '\'' +
                ", genre='" + genre + '\'' +
                ", author='" + author + '\'' +
                ", purchasedPrice=" + purchasedPrice +
                ", quantityOfCD=" + quantityOfCD +
                '}';
    }
}
