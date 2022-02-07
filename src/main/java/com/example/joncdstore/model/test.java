package com.example.joncdstore.model;

import com.example.joncdstore.model.CD;
import com.example.joncdstore.model.User;

import java.util.ArrayList;

public class test {
    public static void main(String [] args)  {

        /*CD cdTest1 = new CD("COD Vanguard","Action","Activision",59.9,65.5,5);
        CD cdTest2 = new CD("American Pie","Comedy","Blizzard",35,40,10);
        CD cdTest3 = new CD("BF4","Drama","EA",89,92,20);*/

        CdManager cdManager = new CdManager("Purchase");
        /*cdManager.getCdList().add(cdTest1);
        cdManager.getCdList().add(cdTest2);
        cdManager.getCdList().add(cdTest3);*/

        //cdManager.addCd();
        cdManager.readCD();

        double [] randomValue = new double[5];
        for(int i = 0; i < 5; i++) {
            randomValue[i] = (Math.random() * 100) + 30;
            System.out.println(String.format("%.2f",randomValue[i]));
        }

        System.out.println("\n");
        for(int i = 0; i < 5; i++) {
            randomValue[i] *= 1.1;
            System.out.println(String.format("%.2f",randomValue[i]));
        }


        /*
        double price = 0;

        for(CD i: cdManager.getCdList())
        {
            price += i.getPurchasedPrice();
        }
        //System.out.println(cdManager.showCD());
        Bill b = new BillPurchase(price,cdManager.getCdList());
        BillManager bManager = new BillManager();
        //bManager.createBill(b,"Jon Mukaj");

        CdManager cdManager1 = new CdManager("Purchase");
        cdManager.readCD();*/

/*

        ArrayList<User> userArrayList = new ArrayList<>();
        User user1 = new User("jmukaj","JonMukaj2002",1,"Jon","Mukaj","11/02/2002",GENDER.MALE,
                "0682070864","jmukaj20@epoka.edu.al",2520);
        User user2 = new User("fmarku","FabioMarku2020",2,"Fabio","Marku","29/11/2001",GENDER.MALE,
                "0682070864","fmarku20@epoka.edu.al",3000);
        User user3 = new User("ktenolli","KevinTenolli2020",3,"Kevin","Tenolli","06/04/2003",GENDER.MALE,
                "0682070864","ktenolli20@epoka.edu.al",5000);

        userArrayList.add(user1);
        userArrayList.add(user2);
        userArrayList.add(user3);

        UserManager userManager = new UserManager();
        userManager.addUser(userArrayList);
        userManager.readUser();*/
    }


}
