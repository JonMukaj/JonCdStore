package com.example.joncdstore.controller;


import com.example.joncdstore.App;
import com.example.joncdstore.model.User;
import com.example.joncdstore.model.UserManager;
import com.example.joncdstore.view.Account;
import com.example.joncdstore.view.AddEmployee;
import com.example.joncdstore.view.Employee;
import com.example.joncdstore.view.ModifyUser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class EmployeeController {
    public static void returnMain(User u, Stage stage) {
        stage.setTitle("CD WORLD");
        stage.setScene(LoginController.createMainMenu(u,stage));
    }

    public static void updateTable(TableView<User> t) {
        UserManager userManager = new UserManager();
        userManager.readUser();
        ObservableList<User> userList = FXCollections.observableArrayList(userManager.getUserList());

        t.setItems(userList);
    }

    public static void modifyUser(Stage stage,User u,User modifiedUser) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Modify Employee");
        window.setResizable(false);
        window.getIcons().add(new Image(App.class.getResourceAsStream("img/icon.jpg")));
        Scene scene = new Scene(new ModifyUser(stage,u,modifiedUser,window).getAnchorPane(),330,199);
        window.setScene(scene);
        window.showAndWait();
    }

    public static void addUser(Stage stage,User u) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Add Employee");
        window.setResizable(false);
        window.getIcons().add(new Image(App.class.getResourceAsStream("img/icon.jpg")));
        Scene scene = new Scene(new AddEmployee(stage,u,window).getAnchorPane(),395,438);
        window.setScene(scene);
        window.showAndWait();
    }

    public static void saveModifyChanges(User u) {
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
            userManager.addUser();
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }

        /*System.out.println("Cloned object");
        for (User i : userManager.getUserList()) {
            System.out.println(i.toString());
        }*/
    }

    public static boolean checkDuplicateUsername(String username) {
        UserManager userManager = new UserManager();
        userManager.readUser();

        for (User i : userManager.getUserList()) {
            if (username.compareTo(i.getUsername()) == 0) {
                return true;
            }
        }
        return false;
    }

    public static void confirmAddUser(User u) {
        UserManager userManager = new UserManager();
        userManager.readUser();
        userManager.getUserList().add(u);
        userManager.addUser();
    }

    public static void removeUser(Stage stage,User u,User removedUser) {
        UserManager userManager = new UserManager();
        userManager.readUser();

        int idx = 0;
        for (User i : userManager.getUserList()) {

            if (removedUser.getId().compareTo(i.getId()) == 0) {
                break;
            }
            idx++;
        }

        try {
            userManager.getUserList().remove(idx);
            userManager.addUser();
            stage.setScene(new Employee(u,stage).generateEmployeeScene());
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }

    }

}
