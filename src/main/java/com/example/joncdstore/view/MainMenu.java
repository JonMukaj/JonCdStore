package com.example.joncdstore.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainMenu  {

    private final AnchorPane mainMenu;
    protected final Text Name;
    protected final AnchorPane anchorPane;
    protected final Button billBt;
    protected final Button performanceBt;
    protected final Button statisticsBt;
    protected final Button employeesBt;
    protected final Button financesBt;
    protected final Button logisticsBt;
    protected final Button accountBt;
    protected final Button logoutBt;
    protected final TabPane tabPane;
    protected final Text UserType;
    private final Stage stage;

    public MainMenu(Stage stage) {
        this.stage = stage;

        mainMenu = new AnchorPane();
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
        UserType = new Text();

        mainMenu.setId("color-text");
        /*mainMenu.setMaxHeight(mainMenu.USE_PREF_SIZE);
        mainMenu.setMaxWidth(mainMenu.USE_PREF_SIZE);
        mainMenu.setMinHeight(mainMenu/USE_PREF_SIZE);
        mainMenu.setMinWidth(USE_PREF_SIZE);*/
        mainMenu.setPrefHeight(700.0);
        mainMenu.setPrefWidth(1000.0);
        mainMenu.getStyleClass().add("menu");
        mainMenu.getStylesheets().add(this.getClass().getResource("/FXstyleMainMenu.css").toExternalForm());

        Name.setId("color-text1");
        Name.setLayoutX(33.0);
        Name.setLayoutY(67.0);
        Name.setStyle("-fx-font-family: 'Brush Script MT'; -fx-fill: red; -fx-font-size: 40;");
        Name.setText("C D - W O R L D");
        Name.setWrappingWidth(335);
        Name.setFont(new Font(48.0));

        anchorPane.setLayoutX(14.0);
        anchorPane.setLayoutY(107.0);
        anchorPane.setMinHeight(0.0);
        anchorPane.setMinWidth(0.0);
        anchorPane.setPrefHeight(579.0);
        anchorPane.setPrefWidth(215.0);
        anchorPane.getStyleClass().add("button");

        billBt.setLayoutX(-1.0);
        billBt.setOnAction(null);
        billBt.setPrefHeight(74.0);
        billBt.setPrefWidth(209.0);
        billBt.setStyle("-fx-font-size: 25;");
        billBt.setText("BILL");
        billBt.setTextFill(Color.valueOf("#0d0d0d"));
        billBt.setFont(new Font("System Bold", 12.0));

        performanceBt.setLayoutX(-1.0);
        performanceBt.setLayoutY(142.0);
        performanceBt.setOnAction(null);
        performanceBt.setPrefHeight(74.0);
        performanceBt.setPrefWidth(209.0);
        performanceBt.setStyle("-fx-font-size: 25;");
        performanceBt.setText("PERFORMANCE");
        performanceBt.setTextFill(Color.valueOf("#0d0d0d"));

        statisticsBt.setLayoutX(-1.0);
        statisticsBt.setLayoutY(216.0);
        statisticsBt.setOnAction(null);
        statisticsBt.setPrefHeight(74.0);
        statisticsBt.setPrefWidth(209.0);
        statisticsBt.setStyle("-fx-font-size: 25;");
        statisticsBt.setText("STATISTICS");
        statisticsBt.setTextFill(Color.valueOf("#0d0d0d"));

        employeesBt.setLayoutX(-1.0);
        employeesBt.setLayoutY(290.0);
        employeesBt.setOnAction(null);
        employeesBt.setPrefHeight(74.0);
        employeesBt.setPrefWidth(209.0);
        employeesBt.setStyle("-fx-font-size: 25;");
        employeesBt.setText("EMPLOYEES");
        employeesBt.setTextFill(Color.valueOf("#0d0d0d"));

        financesBt.setLayoutX(-1.0);
        financesBt.setLayoutY(364.0);
        financesBt.setOnAction(null);
        financesBt.setPrefHeight(74.0);
        financesBt.setPrefWidth(209.0);
        financesBt.setStyle("-fx-font-size: 25;");
        financesBt.setText("FINANCES");
        financesBt.setTextFill(Color.valueOf("#0d0d0d"));

        logisticsBt.setLayoutX(-1.0);
        logisticsBt.setLayoutY(74.0);
        logisticsBt.setOnAction(null);
        logisticsBt.setPrefHeight(68.0);
        logisticsBt.setPrefWidth(209.0);
        logisticsBt.setStyle("-fx-font-size: 25;");
        logisticsBt.setText("LOGISTICS");
        logisticsBt.setTextFill(Color.valueOf("#0d0d0d"));

        accountBt.setLayoutX(-1.0);
        accountBt.setLayoutY(438.0);
        accountBt.setPrefHeight(74.0);
        accountBt.setPrefWidth(209.0);
        accountBt.setStyle("-fx-font-size: 25;");
        accountBt.setText("ACCOUNT");
        accountBt.setTextFill(Color.valueOf("#0d0d0d"));

        logoutBt.setLayoutX(-1.0);
        logoutBt.setLayoutY(511.0);
        logoutBt.setOnAction(null);
        logoutBt.setPrefHeight(68.0);
        logoutBt.setPrefWidth(209.0);
        logoutBt.setStyle("-fx-font-size: 25;");
        logoutBt.setText("LOG OUT");
        logoutBt.setTextFill(Color.valueOf("#0d0d0d"));

        tabPane.setLayoutX(235.0);
        tabPane.setLayoutY(107.0);
        tabPane.setPrefHeight(579.0);
        tabPane.setPrefWidth(729.0);
        //tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        UserType.setId("color-text1");
        UserType.setLayoutX(703.0);
        UserType.setLayoutY(67.0);
        UserType.setStyle("-fx-font-family: 'Brush Script MT'; -fx-fill: red; -fx-font-size: 40;");
        UserType.setText("CASHIER");
        UserType.setWrappingWidth(335);
        UserType.setFont(new Font(48.0));

        mainMenu.getChildren().add(Name);
        anchorPane.getChildren().add(billBt);
        anchorPane.getChildren().add(performanceBt);
        anchorPane.getChildren().add(statisticsBt);
        anchorPane.getChildren().add(employeesBt);
        anchorPane.getChildren().add(financesBt);
        anchorPane.getChildren().add(logisticsBt);
        anchorPane.getChildren().add(accountBt);
        anchorPane.getChildren().add(logoutBt);
        mainMenu.getChildren().add(anchorPane);
        mainMenu.getChildren().add(tabPane);
        mainMenu.getChildren().add(UserType);

    }

    public Scene createMainMenuScene () {
        Scene scene = new Scene(mainMenu,1000,700);
        return scene;
    }

   /* protected void showBill(javafx.event.ActionEvent actionEvent);

    protected void showPerformance(javafx.event.ActionEvent actionEvent);

    protected void showStatistics(javafx.event.ActionEvent actionEvent);

    protected void showEmployees(javafx.event.ActionEvent actionEvent);

    protected void showFinances(javafx.event.ActionEvent actionEvent);

    protected void showLogistics(javafx.event.ActionEvent actionEvent);

    protected void logOut(javafx.event.ActionEvent actionEvent);*/

}
