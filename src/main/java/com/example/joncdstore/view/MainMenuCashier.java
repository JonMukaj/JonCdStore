package com.example.joncdstore.view;

import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainMenuCashier extends MainMenu{


    public MainMenuCashier(Stage stage) {
        super(stage);

        mainMenu.getStyleClass().add("menuCashier");

        billBt.getStyleClass().add("buttonCashier");
        billBt.setTextFill(Color.GREEN);

        performanceBt.getStyleClass().add("buttonCashier");
        performanceBt.setTextFill(Color.GREEN);

        statisticsBt.getStyleClass().add("buttonCashier");
        statisticsBt.setTextFill(Color.GREEN);

        employeesBt.getStyleClass().add("buttonCashier");
        employeesBt.setTextFill(Color.GREEN);

        financesBt.getStyleClass().add("buttonCashier");
        financesBt.setTextFill(Color.GREEN);

        logisticsBt.getStyleClass().add("buttonCashier");
        logisticsBt.setTextFill(Color.GREEN);

        accountBt.getStyleClass().add("buttonCashier");
        accountBt.setTextFill(Color.GREEN);

        logoutBt.getStyleClass().add("buttonCashier");
        logoutBt.setTextFill(Color.GREEN);


        UserType.setStyle("-fx-font-family: 'Brush Script MT'; -fx-fill: green; -fx-font-size: 50;");
        UserType.setText("CASHIER");


        Name.setStyle("-fx-font-family: 'Brush Script MT'; -fx-fill: #55FD00; -fx-font-size: 50;");

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

    public Scene createCashierScene () {
        Scene scene = new Scene(mainMenu, 1000, 700);
        return scene;
    }
}
