package com.example.joncdstore.view;

import com.example.joncdstore.controller.MenuController;
import com.example.joncdstore.model.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class MainMenu  {

    protected AnchorPane mainMenu;
    protected AnchorPane smallMenu;
    protected Text Name;
    protected AnchorPane anchorPane;
    protected Button billBt;
    protected Button performanceBt;
    protected Button statisticsBt;
    protected Button employeesBt;
    protected Button financesBt;
    protected Button logisticsBt;
    protected Button accountBt;
    protected Button logoutBt;
    protected TabPane tabPane;
    protected Stage stage;
    protected Text UserType;

    public MainMenu(User u, Stage stage) {

        this.stage = stage;

        mainMenu = new AnchorPane();
        smallMenu = new AnchorPane();
        Name = new Text();
        anchorPane = new AnchorPane();
        billBt = new Button();
        performanceBt = new Button();
        statisticsBt = new Button();
        employeesBt = new Button();
        financesBt = new Button();
        logisticsBt = new Button();
        accountBt = new Button();
        logoutBt = new Button();
        tabPane = new TabPane();

        mainMenu.setPrefHeight(700.0);
        mainMenu.setPrefWidth(1001.0);
        mainMenu.getStylesheets().add(this.getClass().getResource("/Menu.css").toExternalForm());

        smallMenu.setLayoutX(235.0);
        smallMenu.setLayoutY(110.0);
        smallMenu.setPrefHeight(573);
        smallMenu.setPrefWidth(729);

        Name.setLayoutX(33.0);
        Name.setLayoutY(67.0);
        Name.setText("C D - W O R L D");
        Name.setWrappingWidth(440);

        anchorPane.setLayoutX(14.0);
        anchorPane.setLayoutY(107.0);
        anchorPane.setMinHeight(0.0);
        anchorPane.setMinWidth(0.0);
        anchorPane.setPrefHeight(579.0);
        anchorPane.setPrefWidth(200.0);

        billBt.setLayoutX(0);
        billBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MenuController.createBillNode(mainMenu,u,stage);
            }
        });
        billBt.setPrefHeight(74.0);
        billBt.setPrefWidth(209.0);
        billBt.setStyle("-fx-font-size: 25;");
        billBt.setText("BILL");
        billBt.setTextFill(Color.valueOf("#0d0d0d"));

        performanceBt.setLayoutX(0);
        performanceBt.setLayoutY(142.0);
        performanceBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MenuController.createPerformanceNode(mainMenu);
            }
        });
        performanceBt.setPrefHeight(74.0);
        performanceBt.setPrefWidth(209.0);
        performanceBt.setStyle("-fx-font-size: 25;");
        performanceBt.setText("PERFORMANCE");
        performanceBt.setTextFill(Color.valueOf("#0d0d0d"));

        statisticsBt.setLayoutX(0);
        statisticsBt.setLayoutY(216.0);
        statisticsBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                smallMenu.setStyle("-fx-background-color: #FFFFFF;");
                MenuController.createStatisticsNode(mainMenu,u);
            }
        });
        statisticsBt.setPrefHeight(74.0);
        statisticsBt.setPrefWidth(209.0);
        statisticsBt.setStyle("-fx-font-size: 25;");
        statisticsBt.setText("STATISTICS");
        statisticsBt.setTextFill(Color.valueOf("#0d0d0d"));

        employeesBt.setLayoutX(0);
        employeesBt.setLayoutY(290.0);
        employeesBt.setPrefHeight(74.0);
        employeesBt.setPrefWidth(209.0);
        employeesBt.setStyle("-fx-font-size: 25;");
        employeesBt.setText("EMPLOYEES");
        employeesBt.setTextFill(Color.valueOf("#0d0d0d"));

        financesBt.setLayoutX(0);
        financesBt.setLayoutY(364.0);
        financesBt.setOnAction(null);
        financesBt.setPrefHeight(74.0);
        financesBt.setPrefWidth(209.0);
        financesBt.setStyle("-fx-font-size: 25;");
        financesBt.setText("FINANCES");
        financesBt.setTextFill(Color.valueOf("#0d0d0d"));

        logisticsBt.setLayoutX(0);
        logisticsBt.setLayoutY(74.0);
        logisticsBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MenuController.createLogisticsNode(mainMenu,u,stage);
            }
        });
        logisticsBt.setPrefHeight(68.0);
        logisticsBt.setPrefWidth(209.0);
        logisticsBt.setStyle("-fx-font-size: 25;");
        logisticsBt.setText("LOGISTICS");
        logisticsBt.setTextFill(Color.valueOf("#0d0d0d"));

        accountBt.setLayoutX(0);
        accountBt.setLayoutY(438.0);
        accountBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MenuController.createAccountNode(mainMenu, u);
            }
        });
        accountBt.setPrefHeight(74.0);
        accountBt.setPrefWidth(209.0);
        accountBt.setStyle("-fx-font-size: 25;");
        accountBt.setText("ACCOUNT");
        accountBt.setTextFill(Color.valueOf("#0d0d0d"));

        logoutBt.setLayoutX(0);
        logoutBt.setLayoutY(511.0);
        logoutBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MenuController.logOut(stage);
            }
        });
        logoutBt.setPrefHeight(68.0);
        logoutBt.setPrefWidth(209.0);
        logoutBt.setStyle("-fx-font-size: 25;");
        logoutBt.setText("LOG OUT");
        logoutBt.setTextFill(Color.valueOf("#0d0d0d"));

        UserType = new Text();
        UserType.setLayoutX(703.0);
        UserType.setLayoutY(67.0);
        UserType.setWrappingWidth(430);

    }

    public AnchorPane getMainMenu() {
        return mainMenu;
    }


}
