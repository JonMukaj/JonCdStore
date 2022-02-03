package com.example.joncdstore.controller;

import com.example.joncdstore.App;
import com.example.joncdstore.model.User;
import com.example.joncdstore.model.UserManager;
import com.example.joncdstore.view.ChangeName;
import javafx.collections.SetChangeListener;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AccountController {
    private ChangeName changeNode;

    public void changeNameDialog(Text nameLabel) {
        String fullName = nameLabel.getText();
        int idx = fullName.lastIndexOf(" ");
        String name = fullName.substring(0,idx);
        String surname = fullName.substring(idx+1);

        System.out.println(name + surname);
        changeNode = new ChangeName(name,surname);
    }

    public void changeNameConfirm(String name,String surname) {
        UserManager userManager = new UserManager();
        userManager.readUser();
        User user = userManager.checkUser(name,surname);
        user.setName(changeNode.getTextField1().getText());
        user.setSurname(changeNode.getTextField2().getText());

        userManager.getUserList().add(user);
        userManager.addUser(userManager.getUserList());
    }


}
