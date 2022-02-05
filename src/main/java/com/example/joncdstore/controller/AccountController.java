package com.example.joncdstore.controller;

import com.example.joncdstore.App;
import com.example.joncdstore.model.User;
import com.example.joncdstore.model.UserManager;
import com.example.joncdstore.view.Account;
import com.example.joncdstore.view.Login;
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

import java.util.ArrayList;

public class AccountController {

    public static void cancelChanges(AnchorPane mainMenu, User u) {
        mainMenu.getChildren().add(new Account(mainMenu,u).getScrollPane());
    }

    public static void saveChanges(AnchorPane mainMenu,User u) {
        UserManager userManager = new UserManager();
        userManager.readUser();
        for (User i : userManager.getUserList()) {
            if (u.getId().compareTo(i.getId()) == 0) {
                try {
                    i = (User) u.clone();
                }
                catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
        }

        userManager.addUser(userManager.getUserList());
        mainMenu.getChildren().add(new Account(mainMenu,u).getScrollPane());
    }

    public static void changePassword(Stage stage) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Change Password");
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

        Scene scene = new Scene(box,200,60);
        window.setScene(scene);
        window.showAndWait();
    }
}
