package com.example.joncdstore.controller;

import com.example.joncdstore.model.User;
import com.example.joncdstore.model.UserManager;
import com.example.joncdstore.view.*;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;

public class loginController {

    public static void authenticateUser(TextField usernameField, PasswordField passwordField, Text errorText, Stage stage) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        File f = new File("user.ser");
        if (f.exists() && !f.isDirectory()) {
            UserManager userManager = new UserManager();
            userManager.readUser();
            User user = userManager.checkUser(username,password);
            if(user != null)
            {
                System.out.println("Logged in");
                stage.close();
                stage.setScene(createMainMenu(user,stage));
                stage.show();
            }
        }

        if(username.equals("admin") && password.equals("admin")) {
            System.out.println("Logged in");
            User adminUser = new User("admin","admin",1);
            stage.close();
            stage.setScene(new MainMenuAdmin(stage).createAdminScene()); //just for the moment until creating MainMenuAdmin
            stage.show();
        }
        else {
            passwordField.setText("");
            errorText.setVisible(true);
        }
    }

    public static Scene createMainMenu(User u,Stage stage) {
        if (u.getPrivilege() == 3) {
            return new MainMenuCashier(stage).createCashierScene();
        }
        else if (u.getPrivilege() == 2)
            return new MainMenuManager(stage).createManagerScene();
        else
            return new MainMenuAdmin(stage).createAdminScene();
    }

}
