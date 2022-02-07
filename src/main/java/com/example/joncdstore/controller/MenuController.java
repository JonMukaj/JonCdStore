package com.example.joncdstore.controller;

import com.example.joncdstore.App;
import com.example.joncdstore.model.User;
import com.example.joncdstore.view.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MenuController {

    private MenuController() {

    }

    public static void logOut(Stage stage) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Confirm");
        window.setResizable(false);
        window.getIcons().add(new Image(App.class.getResourceAsStream("img/icon.jpg")));
        Label label = new Label();
        label.setText("Do you want to log out?");
        label.setStyle("-fx-font-size: 15; -fx-font-weight: bold;");

        Button yesBt = new Button("Log out");
        Button noBt = new Button("Cancel");

        yesBt.setOnAction(e -> {
            window.close();
            stage.setScene(new Login(stage).createLoginScene());
        });

        noBt.setOnAction(e -> {
            window.close();
        });

        HBox boxBt = new HBox(10);
        boxBt.getChildren().addAll(yesBt,noBt);
        boxBt.setAlignment(Pos.CENTER);

        VBox box = new VBox(10);
        box.setPrefWidth(30);
        box.getChildren().addAll(label,boxBt);

        box.setAlignment(Pos.CENTER);
        box.setStyle("-fx-background-color: #FFFFFF;");

        Scene scene = new Scene(box,200,60);
        window.setScene(scene);
        window.showAndWait();
    }

    public static void createAccountNode(AnchorPane mainMenu, User u) {
        mainMenu.getChildren().add(new Account(mainMenu,u).getScrollPane());
    }

    public static void editAccountNode(AnchorPane mainMenu, User u) {
        mainMenu.getChildren().add(new ChangeAccount(mainMenu,u).getScrollPane());
    }


    public static void createEmployeeScene(User u,Stage stage) {
        stage.setTitle("Employee");
        stage.setScene(new Employee(u,stage).generateEmployeeScene());
    }

    public static void createBillNode(AnchorPane mainMenu, User u, Stage stage) {
        mainMenu.getChildren().add(new BillMenu(u,stage).getAnchorPane());
    }

    public static void createLogisticsNode(AnchorPane mainMenu, User u, Stage stage) {
        mainMenu.getChildren().add(new LogisticsMenu(u,stage).getAnchorPane());
    }


}
