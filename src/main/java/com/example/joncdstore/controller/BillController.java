package com.example.joncdstore.controller;

import com.example.joncdstore.model.*;
import com.example.joncdstore.view.BillView;
import com.example.joncdstore.view.Catalogue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Iterator;

public class BillController {

    private static ArrayList<CD> tmpCDlist = new ArrayList<>();
    private BillController() {

    }

    public static void createBillViewScene(User u, Stage stage) {
        stage.setTitle("Sell");
        Scene oldScene = stage.getScene();
        stage.setScene(new BillView(u,stage,oldScene).generateBillViewScene());
    }

    public static void createCatalogueScene(User u, Stage stage, ActionEvent e) {
        String t = ((Button)e.getSource()).getText();
        if (t.equals("CATALOGUE")) {
            stage.setTitle("Catalogue");
            Scene oldScene = stage.getScene();
            stage.setScene(new Catalogue(u,stage,"sellingPrice",oldScene).generateCatalogueScene("sellingPrice"));
        }
        else if (t.equals("SUPPLY")) {
            stage.setTitle("Supply");
            Scene oldScene = stage.getScene();
            stage.setScene(new Catalogue(u,stage,"purchasedPrice",oldScene).generateCatalogueScene("purchasedPrice"));
        }

    }

    public static void returnBill(User u, Stage stage,Scene oldScene) {
        stage.setTitle("CD WORLD");
        stage.setScene(oldScene);

    }

    public static void updateTable(TableView<CD> t,String type) {
        CdManager cdManager = new CdManager(type);
        cdManager.readCD();
        ObservableList<CD> cdList = FXCollections.observableArrayList(cdManager.getCdList());
        t.setItems(cdList);
    }

    public static void addToTable(TableView<CD> t,CD c) {
        tmpCDlist.add(c);
        ObservableList<CD> cdList = FXCollections.observableArrayList(tmpCDlist);
        t.setItems(cdList);
    }

    public static void removeFromTable(TableView<CD> t, Text priceText) {
        try {
            double price = 0;
            Iterator<CD> i = tmpCDlist.iterator();
            while(i.hasNext()) {
                CD c = i.next();
                if (c.getTitleOfCd().equals(t.getSelectionModel().getSelectedItem().getTitleOfCd())) {
                    i.remove();
                    price = BillView.getPrice();
                    price -= t.getSelectionModel().getSelectedItem().getSellingPrice() * t.getSelectionModel().getSelectedItem().getTmpQuantity();
                }
            }
            t.getItems().remove(t.getSelectionModel().getSelectedItem());
            BillView.setPrice(price);
            priceText.setText(String.valueOf(price));
        }
        catch (NullPointerException e) {
            //System.out.print(e.toString());
        }

    }

    public static void generateBillSell(User u) {
        CdManager cdManager = new CdManager("Sell");
        cdManager.readCD();
        for(CD i : cdManager.getCdList()) {
            for(CD j : tmpCDlist) {
                if(i.getTitleOfCd().matches(j.getTitleOfCd())) {
                    i.setTotalQuantity(j.getTotalQuantity());
                    u.setNrOfCdSold(u.getNrOfCdSold() + j.getTmpQuantity());
                }
            }
        }
        cdManager.addCd();
        Bill b = new BillSell(BillView.getPrice(),tmpCDlist);
        BillManager billManager = new BillManager();
        billManager.createBill(b,u);

        System.out.println(u.getNrOfBillSold() + " " + u.getNrOfCdSold());
    }


    public static ArrayList<CD> getTmpCDlist() {
        return tmpCDlist;
    }
}
