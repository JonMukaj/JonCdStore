package com.example.joncdstore.view;

import com.example.joncdstore.controller.EmployeeController;
import com.example.joncdstore.controller.MenuController;
import com.example.joncdstore.model.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ModifyUser{

    private final AnchorPane anchorPane;
    private final Button confirmBt;
    private final Button cancelBt;
    private final SplitMenuButton professionPrompt;
    private final MenuItem adminItem;
    private final MenuItem managerItem;
    private final MenuItem cashierItem;
    private final Label professionLabel;
    private final Label salaryLabel;
    private final TextField salaryField;

    public ModifyUser(Stage stage,User u, User modifiedUser,Stage window) {

        anchorPane = new AnchorPane();
        confirmBt = new Button();
        cancelBt = new Button();
        professionPrompt = new SplitMenuButton();
        adminItem = new MenuItem();
        managerItem = new MenuItem();
        cashierItem = new MenuItem();
        professionLabel = new Label();
        salaryLabel = new Label();
        salaryField = new TextField();

        anchorPane.getStylesheets().add(this.getClass().getResource("/Menu.css").toExternalForm());

        confirmBt.setLayoutX(172.0);
        confirmBt.setLayoutY(141.0);
        confirmBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!salaryField.getText().trim().equals(""))
                    modifiedUser.setSalary(Double.parseDouble(salaryField.getText()));
                EmployeeController.saveModifyChanges(modifiedUser);

                stage.setScene(new Employee(u,stage).generateEmployeeScene());
                window.close();
            }
        });
        confirmBt.setPrefHeight(32.0);
        confirmBt.setPrefWidth(120.0);
        confirmBt.getStyleClass().add("edit");
        confirmBt.setText("Confirm");

        cancelBt.setLayoutX(62.0);
        cancelBt.setLayoutY(139.0);
        cancelBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.close();
            }
        });
        cancelBt.setPrefHeight(32.0);
        cancelBt.setPrefWidth(74.0);
        cancelBt.getStyleClass().add("cancel");
        cancelBt.setText("Cancel");

        professionPrompt.setLayoutX(143.0);
        professionPrompt.setLayoutY(40.0);
        professionPrompt.setPrefHeight(25.0);
        professionPrompt.setPrefWidth(149.0);
        professionPrompt.setText(modifiedUser.getProfession());

        adminItem.setText("Admin");
        adminItem.setOnAction(event -> {
            modifiedUser.setProfession("Admin");
            modifiedUser.setPrivilege(1);
            professionPrompt.setText("Admin");
        });
        managerItem.setText("Manager");
        managerItem.setOnAction(event -> {
            modifiedUser.setProfession("Manager");
            modifiedUser.setPrivilege(2);
            professionPrompt.setText("Manager");
        });

        cashierItem.setText("Cashier");
        cashierItem.setOnAction(event -> {
            modifiedUser.setProfession("Cashier");
            modifiedUser.setPrivilege(3);
            professionPrompt.setText("Cashier");
        });

        professionPrompt.getItems().add(adminItem);
        professionPrompt.getItems().add(managerItem);
        professionPrompt.getItems().add(cashierItem);

        professionLabel.setLayoutX(35.0);
        professionLabel.setLayoutY(37.0);
        professionLabel.setStyle("-fx-font-size: 20;");
        professionLabel.setText("Profession");

        salaryLabel.setLayoutX(71.0);
        salaryLabel.setLayoutY(87.0);
        salaryLabel.setPrefHeight(30.0);
        salaryLabel.setPrefWidth(56.0);
        salaryLabel.setStyle("-fx-font-size: 20;");
        salaryLabel.setText("Salary");

        salaryField.setLayoutX(143.0);
        salaryField.setLayoutY(91.0);
        salaryField.setPromptText("Enter value");

        anchorPane.setPrefHeight(199.0);
        anchorPane.setPrefWidth(330.0);
        anchorPane.setStyle("-fx-background-color: #FFFFFF;");

        anchorPane.getChildren().add(confirmBt);
        anchorPane.getChildren().add(cancelBt);
        anchorPane.getChildren().add(professionPrompt);
        anchorPane.getChildren().add(professionLabel);
        anchorPane. getChildren().add(salaryLabel);
        anchorPane.getChildren().add(salaryField);

    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

}
