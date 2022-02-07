package com.example.joncdstore.view;

import com.example.joncdstore.model.CdManager;
import com.example.joncdstore.model.User;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainMenuManager extends MainMenu{
    public MainMenuManager(User u,Stage stage) {
        super(u,stage);

        mainMenu.getStyleClass().add("menuManager");

        billBt.getStyleClass().add("buttonManager");
        billBt.setTextFill(Color.valueOf("#0022ff"));
        billBt.setDisable(true);

        performanceBt.getStyleClass().add("buttonManager");
        performanceBt.setTextFill(Color.valueOf("#0022ff"));

        statisticsBt.getStyleClass().add("buttonManager");
        statisticsBt.setTextFill(Color.valueOf("#0022ff"));

        employeesBt.getStyleClass().add("buttonManager");
        employeesBt.setTextFill(Color.valueOf("#0022ff"));
        employeesBt.setDisable(true);

        financesBt.getStyleClass().add("buttonManager");
        financesBt.setTextFill(Color.valueOf("#0022ff"));
        financesBt.setDisable(true);

        logisticsBt.getStyleClass().add("buttonManager");
        logisticsBt.setTextFill(Color.valueOf("#0022ff"));

        accountBt.getStyleClass().add("buttonManager");
        accountBt.setTextFill(Color.valueOf("#0022ff"));

        logoutBt.getStyleClass().add("buttonManager");
        logoutBt.setTextFill(Color.valueOf("#0022ff"));


        UserType.setStyle("-fx-font-family: 'Brush Script MT'; -fx-fill: #0022ff; -fx-font-size: 50;");
        UserType.setText("MANAGER");


        Name.setStyle("-fx-font-family: 'Brush Script MT'; -fx-fill: #00f5fd; -fx-font-size: 50;");

        smallMenu.setStyle("-fx-background-color: #85C9F0;");

        mainMenu.getChildren().add(Name);
        mainMenu.getChildren().add(smallMenu);
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

    public Scene createManagerScene () {
        Scene scene = new Scene(mainMenu, 1000, 700);
        return scene;
    }


}
