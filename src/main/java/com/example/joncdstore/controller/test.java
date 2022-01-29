package com.example.joncdstore.controller;

import com.example.joncdstore.model.CD;
import java.util.ArrayList;

public class test {
    public static void main(String [] args)  {

        ArrayList<CD> cdArrayList = new ArrayList<>();

        CD cdTest1 = new CD("COD Vanguard","Action","Activision",59.9,2);
        CD cdTest2 = new CD("American Pie","Comedy","SHpetim",59.9,6);
        CD cdTest3 = new CD("COD Vanguard","Action","Activision",59.9,2);

        cdArrayList.add(cdTest1);
        cdArrayList.add(cdTest2);
        cdArrayList.add(cdTest3);

        CdManager cdManager = new CdManager();
        cdManager.addCd(cdArrayList);
        cdManager.readCD();

        cdManager.checkQuantity();
    }



}
