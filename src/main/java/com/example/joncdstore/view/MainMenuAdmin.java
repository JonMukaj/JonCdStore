package com.example.joncdstore.view;

import com.example.joncdstore.controller.MenuController;
import com.example.joncdstore.model.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainMenuAdmin extends MainMenu{

    public MainMenuAdmin(User u,Stage stage) {
        super(u,stage);

        mainMenu.getStyleClass().add("menuAdmin");

        billBt.getStyleClass().add("buttonAdmin");
        billBt.setTextFill(Color.valueOf("#730202"));

        performanceBt.getStyleClass().add("buttonAdmin");
        performanceBt.setTextFill(Color.valueOf("#730202"));

        statisticsBt.getStyleClass().add("buttonAdmin");
        statisticsBt.setTextFill(Color.valueOf("#730202"));

        employeesBt.getStyleClass().add("buttonAdmin");
        employeesBt.setTextFill(Color.valueOf("#730202"));

        financesBt.getStyleClass().add("buttonAdmin");
        financesBt.setTextFill(Color.valueOf("#730202"));

        logisticsBt.getStyleClass().add("buttonAdmin");
        logisticsBt.setTextFill(Color.valueOf("#730202"));

        accountBt.getStyleClass().add("buttonAdmin");
        accountBt.setTextFill(Color.valueOf("#730202"));

        logoutBt.getStyleClass().add("buttonAdmin");
        logoutBt.setTextFill(Color.valueOf("#730202"));


        UserType.setStyle("-fx-font-family: 'Brush Script MT'; -fx-fill: #5b0101; -fx-font-size: 50;");
        UserType.setText("ADMIN");

        Name.setStyle("-fx-font-family: 'Brush Script MT'; -fx-fill: #e14352; -fx-font-size: 50;");

        /*if (u.getUsername().matches("admin") && u.getPassword().matches("admin")) {
            billBt.setOnAction(null);
            billBt.getStyleClass().add("inactiveAdmin");
        }*/

        employeesBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MenuController.createEmployeeScene(u,stage);
            }
        });

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

    public Scene createAdminScene () {
        Scene scene = new Scene(mainMenu, 1000, 700);
        return scene;
    }
}
