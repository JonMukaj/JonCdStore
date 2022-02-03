package com.example.joncdstore.model;

import com.example.joncdstore.model.CD;
import com.example.joncdstore.model.User;

import java.util.ArrayList;

public class test {
    public static void main(String [] args)  {

        /*ArrayList<CD> cdArrayList = new ArrayList<>();

        CD cdTest1 = new CD("COD Vanguard","Action","Activision",59.9,2);
        CD cdTest2 = new CD("American Pie","Comedy","SHpetim",59.9,6);
        CD cdTest3 = new CD("COD Vanguard","Action","Activision",59.9,2);

        cdArrayList.add(cdTest1);
        cdArrayList.add(cdTest2);
        cdArrayList.add(cdTest3);

        CdManager cdManager = new CdManager();
        cdManager.addCd(cdArrayList);
        cdManager.readCD();

        cdManager.checkQuantity();*/

        ArrayList<User> userArrayList = new ArrayList<>();
        User user1 = new User("jmukaj","jonushi",1,"jon","mukaj","11/02/2002",GENDER.MALE,
                "0682070864","jmukaj20@epoka.edu.al",2520);
        User user2 = new User("fmarku","fabio2020",2,"fabio","marku","29/11/2001",GENDER.MALE,
                "0682070864","fmarku20@epoka.edu.al",3000);
        User user3 = new User("ktenolli","kevin2021",3,"kevin","tenolli","06/04/2003",GENDER.MALE,
                "0682070864","ktenolli20@epoka.edu.al",5000);

        userArrayList.add(user1);
        userArrayList.add(user2);
        userArrayList.add(user3);

        UserManager userManager = new UserManager();
        userManager.addUser(userArrayList);
        userManager.readUser();
    }


}
