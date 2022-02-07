package com.example.joncdstore.model;

import java.util.ArrayList;

public class BillSell extends Bill{

    public BillSell(double priceOfTransaction, ArrayList<CD> listOfItems) {

        Statistics.popStatistics();
        setBillNr(Statistics.getTotalNrOfBillBought()+Statistics.getTotalNrOfBillSold() + 1);

        setType("Sell");
        setItems(listOfItems);
        setPriceOfTransaction(priceOfTransaction);
    }
}
