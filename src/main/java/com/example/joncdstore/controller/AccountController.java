package com.example.joncdstore.controller;

import com.example.joncdstore.App;
import com.example.joncdstore.model.User;
import com.example.joncdstore.model.UserManager;
import com.example.joncdstore.view.Account;
import com.example.joncdstore.view.ChangeAccount;
import com.example.joncdstore.view.ChangePassword;
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

    private AccountController() {

    }

    public static void cancelChanges(AnchorPane mainMenu, User u) {
        mainMenu.getChildren().add(new Account(mainMenu,u).getScrollPane());
    }

    public static void saveChanges(AnchorPane mainMenu,User u) {
        UserManager userManager = new UserManager();
        userManager.readUser();

        int idx = 0;
        for (User i : userManager.getUserList()) {

            if (u.getId().compareTo(i.getId()) == 0) {
                break;
            }
            idx++;
        }

        try {
            userManager.getUserList().set(idx,(User) u.clone());
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }

        /*System.out.println("Cloned object");
        for (User i : userManager.getUserList()) {
            System.out.println(i.toString());
        }*/

        userManager.addUser();
        mainMenu.getChildren().add(new Account(mainMenu,u).getScrollPane());
    }

    public static void changePassword(User u) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Change Password");
        window.setResizable(false);
        window.getIcons().add(new Image(App.class.getResourceAsStream("img/icon.jpg")));
        Scene scene = new Scene(new ChangePassword(u,window).getAnchorPane(),330,288);
        window.setScene(scene);
        window.showAndWait();
    }



    public static void cancelPassChanges(AnchorPane mainMenu, User u) {
        mainMenu.getChildren().add(new ChangeAccount(mainMenu,u).getScrollPane());
    }

}
