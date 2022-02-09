package com.example.joncdstore.view;

import com.example.joncdstore.controller.PerformanceController;
import com.example.joncdstore.model.User;
import com.example.joncdstore.model.UserManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class Performance {

    private final AnchorPane anchorPane;

    private final TabPane tabPane;

    private final Tab tabCashier;
    private final AnchorPane anchorPane1;
    private final ScrollPane scrollCashier;
    private final AnchorPane anchorCashier;
    private final TableView<User> tableCashier;
    private final TableColumn<User,String> usernameCashierC;
    private final TableColumn<User,String> nameCashierC;
    private final TableColumn<User,String> surnameCashierC;
    private final TableColumn<User,Integer> billSold;
    private final TableColumn<User,Integer> cdSold;

    private final Tab tabManager;
    private final AnchorPane anchorPane2;
    private final ScrollPane scrollManager;
    private final AnchorPane anchorManager;
    private final TableView<User> tableManager;
    private final TableColumn<User,String> usernameManager;
    private final TableColumn<User,String> nameManager;
    private final TableColumn<User,String> surnameManager;
    private final TableColumn<User,Integer> billBought;
    private final TableColumn<User,Integer> cdBought;

    public Performance() {

        anchorPane = new AnchorPane();
        tabPane = new TabPane();
        tabCashier = new Tab();
        anchorPane1 = new AnchorPane();
        scrollCashier = new ScrollPane();
        anchorCashier = new AnchorPane();
        tableCashier = new TableView();
        usernameCashierC = new TableColumn();
        nameCashierC = new TableColumn();
        surnameCashierC = new TableColumn();
        billSold = new TableColumn();
        cdSold = new TableColumn();
        tabManager = new Tab();
        anchorPane2 = new AnchorPane();
        scrollManager = new ScrollPane();
        anchorManager = new AnchorPane();
        tableManager = new TableView();
        usernameManager = new TableColumn();
        nameManager = new TableColumn();
        surnameManager = new TableColumn();
        billBought = new TableColumn();
        cdBought = new TableColumn();

        tabPane.setLayoutX(0.0);
        tabPane.setLayoutY(0.0);
        tabPane.setPrefHeight(579.0);
        tabPane.setPrefWidth(735.0);

        tabCashier.setText("Cashiers");
        tabManager.setText("Managers");

        tabCashier.setClosable(false);
        tabManager.setClosable(false);

        anchorPane1.setMinHeight(0.0);
        anchorPane1.setMinWidth(0.0);
        anchorPane1.setPrefHeight(171.0);
        anchorPane1.setPrefWidth(382.0);

        scrollCashier.setLayoutX(6.0);
        scrollCashier.setLayoutY(0.0);
        scrollCashier.setPrefHeight(548.0);
        scrollCashier.setPrefWidth(729.0);

        anchorCashier.setMinHeight(0.0);
        anchorCashier.setMinWidth(0.0);
        anchorCashier.setPrefHeight(534.0);
        anchorCashier.setPrefWidth(734.0);
        anchorCashier.setLayoutX(0.0);
        anchorCashier.setLayoutY(0.0);

        tableCashier.setLayoutY(1.0);
        tableCashier.setPrefHeight(532.0);
        tableCashier.setPrefWidth(714.0);

        usernameCashierC.setPrefWidth(135.0);
        usernameCashierC.setText("Username");

        nameCashierC.setPrefWidth(153.0);
        nameCashierC.setText("Name");

        surnameCashierC.setPrefWidth(180.0);
        surnameCashierC.setText("Surname");

        billSold.setPrefWidth(116.0);
        billSold.setText("Bills Sold");

        cdSold.setPrefWidth(127.0);
        cdSold.setText("CDs Sold");

        scrollCashier.setContent(anchorCashier);
        tabCashier.setContent(anchorPane1);
        anchorCashier.getChildren().add(tableCashier);
        anchorPane1.getChildren().add(scrollCashier);

        tableCashier.getColumns().add(usernameCashierC);
        tableCashier.getColumns().add(nameCashierC);
        tableCashier.getColumns().add(surnameCashierC);
        tableCashier.getColumns().add(billSold);
        tableCashier.getColumns().add(cdSold);

        PerformanceController.createCashierTable(tableCashier);
        usernameCashierC.setCellValueFactory(new PropertyValueFactory<>("username"));
        nameCashierC.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnameCashierC.setCellValueFactory(new PropertyValueFactory<>("surname"));
        cdSold.setCellValueFactory(new PropertyValueFactory<>("CdSold"));
        billSold.setCellValueFactory(new PropertyValueFactory<>("BillSold"));


        tabPane.getTabs().add(tabCashier);

        anchorPane2.setMinHeight(0.0);
        anchorPane2.setMinWidth(0.0);
        anchorPane2.setPrefHeight(180.0);
        anchorPane2.setPrefWidth(200.0);

        scrollManager.setPrefHeight(548.0);
        scrollManager.setPrefWidth(735.0);

        anchorManager.setMinHeight(0.0);
        anchorManager.setMinWidth(0.0);
        anchorManager.setPrefHeight(534.0);
        anchorManager.setPrefWidth(734.0);

        tableManager.setPrefHeight(532.0);
        tableManager.setPrefWidth(714.0);

        usernameManager.setPrefWidth(135.0);
        usernameManager.setText("Username");

        nameManager.setPrefWidth(153.0);
        nameManager.setText("Name");

        surnameManager.setPrefWidth(180.0);
        surnameManager.setText("Surname");

        billBought.setPrefWidth(116.0);
        billBought.setText("Bills Bought");

        cdBought.setPrefWidth(127.0);
        cdBought.setText("CDs Bought");



        scrollManager.setContent(anchorManager);
        tabManager.setContent(anchorPane2);


        tableManager.getColumns().add(usernameManager);
        tableManager.getColumns().add(nameManager);
        tableManager.getColumns().add(surnameManager);
        tableManager.getColumns().add(billBought);
        tableManager.getColumns().add(cdBought);

        PerformanceController.createManagerTable(tableManager);
        usernameManager.setCellValueFactory(new PropertyValueFactory<>("username"));
        nameManager.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnameManager.setCellValueFactory(new PropertyValueFactory<>("surname"));
        billBought.setCellValueFactory(new PropertyValueFactory<>("BillBought"));
        cdBought.setCellValueFactory(new PropertyValueFactory<>("CdBought"));

        anchorManager.getChildren().add(tableManager);
        anchorPane2.getChildren().add(scrollManager);

        tabPane.getTabs().add(tabManager);

        anchorPane.setPrefHeight(573.0);
        anchorPane.setPrefWidth(729.0);
        anchorPane.setLayoutX(233);
        anchorPane.setLayoutY(110);
        anchorPane.setStyle("-fx-background-color: white");
        anchorPane.getChildren().add(tabPane);

    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }
}
