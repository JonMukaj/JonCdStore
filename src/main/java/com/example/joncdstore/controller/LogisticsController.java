package com.example.joncdstore.controller;

import com.example.joncdstore.App;
import com.example.joncdstore.model.*;
import com.example.joncdstore.view.BillView;
import com.example.joncdstore.view.ChangePassword;
import com.example.joncdstore.view.FindCD;
import com.example.joncdstore.view.SupplyView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Iterator;

public class LogisticsController {

    private static ArrayList<CD> tmpCDlist = new ArrayList<>();
    private static CD c;

    public LogisticsController() {}


    public static void addToCart(TableView<CD> t,CD c) {
        LogisticsController.c = c;
        tmpCDlist.add(c);
        ObservableList<CD> cdList = FXCollections.observableArrayList(tmpCDlist);
        t.setItems(cdList);
    }

    public static void createSupplyViewScene(User u, Stage stage) {
        stage.setTitle("Buy");
        Scene oldScene = stage.getScene();
        stage.setScene(new SupplyView(u,stage,oldScene).generateBillViewScene());
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

    public static void generateBillPurchase(User u) {
        CdManager cdManager = new CdManager("Purchase");
        cdManager.readCD();

        for(CD i : cdManager.getCdList()) {
            for(CD j : tmpCDlist) {
                if(i.getTitleOfCd().matches(j.getTitleOfCd())) {
                    i.setTotalQuantity(j.getTotalQuantity());
                    u.setNrOfCdBought(u.getNrOfCdBought() + j.getTmpQuantity());
                }
            }
        }
        cdManager.addCd();
        Bill b = new BillPurchase(SupplyView.getPrice(),tmpCDlist);
        BillManager billManager = new BillManager();
        billManager.createBill(b,u);
    }

    public static ArrayList<CD> getTmpCDlist() {
        return tmpCDlist;
    }

    public static CD getC() {
        return c;
    }

    public static void findCD(TableView<CD> t) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Find CD");
        window.setResizable(false);
        window.getIcons().add(new Image(App.class.getResourceAsStream("img/icon.jpg")));
        Scene scene = new Scene(new FindCD(t,window).getAnchorPane(),272,323);
        window.setScene(scene);
        window.showAndWait();
    }
}
