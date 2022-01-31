package com.example.joncdstore.controller;

import com.example.joncdstore.model.User;
import com.example.joncdstore.model.UserManager;
import com.example.joncdstore.view.Login;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;

public class loginController {

    public static void authenticateUser(TextField usernameField, PasswordField passwordField, Text errorText, Stage stage) {
        //Button button = (Button) e.getSource();
        String username = usernameField.getText();
        String password = passwordField.getText();

        File f = new File("user.ser");
        if (f.exists() && !f.isDirectory()) {
            UserManager userManager = new UserManager();
            User user = userManager.checkUser(username,password);
            if(user != null)
            {
                System.out.println("Logged in");
                stage.close();
                stage.setScene(new Login(stage).createLoginScene());
                stage.show();
            }
        }

        if(username.equals("admin") && password.equals("admin")) {
            System.out.println("Logged in");
            User adminUser = new User("admin","admin",1);
            stage.close();
            stage.setScene(new Login(stage).createLoginScene());
            stage.show();
        }
        else {
            errorText.setVisible(true);
        }
    }

}
