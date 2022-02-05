package com.example.joncdstore.view;

import com.example.joncdstore.controller.AccountController;
import com.example.joncdstore.model.User;
import com.example.joncdstore.model.UserManager;
import com.example.joncdstore.model.ValidatePassword;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class ChangePassword implements ValidatePassword {

    private final AnchorPane anchorPane;
    private final PasswordField newPassField;
    private final PasswordField confirmPassField;
    private final TextField newTextField;
    private final TextField confirmTextField;
    private final TextFlow textFlow;
    private final Text text;
    private final Label label;
    private final Button confirmPassChangeBt;
    private final Button cancelPassChangesBt;
    private final CheckBox showNewPassCheck;
    private final Text errorText;

    public ChangePassword(User u, Stage window) {

        anchorPane = new AnchorPane();
        newPassField = new PasswordField();
        confirmPassField = new PasswordField();
        newTextField = new TextField();
        confirmTextField = new TextField();
        textFlow = new TextFlow();
        text = new Text();
        label = new Label();
        confirmPassChangeBt = new Button();
        cancelPassChangesBt = new Button();
        showNewPassCheck = new CheckBox();
        errorText = new Text();

        anchorPane.getStylesheets().add(this.getClass().getResource("/Menu.css").toExternalForm());

        newPassField.setLayoutX(34.0);
        newPassField.setLayoutY(125.0);
        newPassField.setPrefHeight(25.0);
        newPassField.setPrefWidth(255.0);
        newPassField.setPromptText("New Password");

        confirmPassField.setLayoutX(34.0);
        confirmPassField.setLayoutY(166.0);
        confirmPassField.setPrefHeight(25.0);
        confirmPassField.setPrefWidth(255.0);
        confirmPassField.setPromptText("Confirm new Password");

        newTextField.setLayoutX(34.0);
        newTextField.setLayoutY(125.0);
        newTextField.setPrefHeight(25.0);
        newTextField.setPrefWidth(256.0);
        newTextField.setManaged(false);
        newTextField.setVisible(false);

        confirmTextField.setLayoutX(34.0);
        confirmTextField.setLayoutY(166.0);
        confirmTextField.setPrefHeight(25.0);
        confirmTextField.setPrefWidth(256.0);
        confirmTextField.setManaged(false);
        confirmTextField.setVisible(false);

        textFlow.setLayoutX(34.0);
        textFlow.setLayoutY(59.0);
        textFlow.setPrefHeight(49.0);
        textFlow.setPrefWidth(265.0);

        text.setText("Use at least 10 characters, only letters and digits, at least one uppercase letter, and at least two digits.");
        text.setWrappingWidth(200);
        textFlow.getChildren().add(text);

        label.setLayoutX(34.0);
        label.setLayoutY(25.0);
        label.setStyle("-fx-text-fill: #3274D2; -fx-font-size: 15;");
        label.setText("Password strength:");

        confirmPassChangeBt.setLayoutX(173.0);
        confirmPassChangeBt.setLayoutY(238.0);
        confirmPassChangeBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!matchPassword(newPassField.getText(),confirmPassField.getText())) {
                    errorText.setText("Passwords don't match!");
                    errorText.setVisible(true);
                }
                else if (!checkPassword(confirmPassField.getText())) {
                    errorText.setText("Password has low strength!");
                    errorText.setVisible(true);
                }
                else
                {
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
                        userManager.getUserList().get(idx).setPassword(confirmPassField.getText());
                        System.out.println(userManager.getUserList().get(idx).toString());
                    }
                    catch (Exception e) {
                        System.out.println(e.toString());
                    }
                    userManager.addUser(userManager.getUserList());
                    window.close();
                }
            }
        });
        confirmPassChangeBt.setPrefHeight(32.0);
        confirmPassChangeBt.setPrefWidth(120.0);
        confirmPassChangeBt.setText("Change password");
        confirmPassChangeBt.getStyleClass().add("edit");

        cancelPassChangesBt.setLayoutX(80.0);
        cancelPassChangesBt.setLayoutY(238.0);
        cancelPassChangesBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.close();
            }
        });
        cancelPassChangesBt.setPrefHeight(32.0);
        cancelPassChangesBt.setPrefWidth(74.0);
        cancelPassChangesBt.setText("Cancel");
        cancelPassChangesBt.getStyleClass().add("cancel");

        showNewPassCheck.setLayoutX(189.0);
        showNewPassCheck.setLayoutY(204.0);
        showNewPassCheck.setText("Show Password");

        newTextField.managedProperty().bind(showNewPassCheck.selectedProperty());
        newTextField.visibleProperty().bind(showNewPassCheck.selectedProperty());
        newPassField.managedProperty().bind(showNewPassCheck.selectedProperty().not());
        newPassField.visibleProperty().bind(showNewPassCheck.selectedProperty().not());
        newTextField.textProperty().bindBidirectional(newPassField.textProperty());

        confirmTextField.managedProperty().bind(showNewPassCheck.selectedProperty());
        confirmTextField.visibleProperty().bind(showNewPassCheck.selectedProperty());
        confirmPassField.managedProperty().bind(showNewPassCheck.selectedProperty().not());
        confirmPassField.visibleProperty().bind(showNewPassCheck.selectedProperty().not());
        confirmTextField.textProperty().bindBidirectional(confirmPassField.textProperty());

        errorText.setVisible(false);
        errorText.setFill(Paint.valueOf("red"));
        errorText.setLayoutX(34.0);
        errorText.setLayoutY(217.0);

        anchorPane.getChildren().add(newPassField);
        anchorPane.getChildren().add(confirmPassField);
        anchorPane.getChildren().add(newTextField);
        anchorPane.getChildren().add(confirmTextField);
        anchorPane.getChildren().add(textFlow);
        anchorPane.getChildren().add(label);
        anchorPane.getChildren().add(confirmPassChangeBt);
        anchorPane.getChildren().add(cancelPassChangesBt);
        anchorPane. getChildren().add(showNewPassCheck);
        anchorPane.getChildren().add(errorText);

        anchorPane.setPrefHeight(284.0);
        anchorPane.setPrefWidth(320.0);
        anchorPane.setStyle("-fx-background-color: #FFFFFF;");

    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    @Override
    public boolean checkPassword(String s) {
        if(s.matches("^(?=(\\D*\\d){2,})(?=.*[A-Z])[a-zA-Z0-9]{10,}$"))
            return true;
        else
            return false;
    }

    @Override
    public boolean matchPassword(String s1, String s2) {
        if (s1.equals(s2))
            return true;
        else
            return false;
    }


}
