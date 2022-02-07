package com.example.joncdstore.model;

import java.util.ArrayList;

public class BillPurchase extends Bill{

    public BillPurchase(double priceOfTransaction, ArrayList<CD> listOfItems) {
        Statistics.popStatistics();
        setBillNr(Statistics.getTotalNrOfBillBought()+Statistics.getTotalNrOfBillSold() + 1);

        setType("Purchase");
        setItems(listOfItems);
        setPriceOfTransaction(priceOfTransaction);
    }



}
