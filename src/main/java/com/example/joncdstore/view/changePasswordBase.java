package com.example.joncdstore.view;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public abstract class changePasswordBase extends AnchorPane {

    protected final PasswordField oldPassField;
    protected final TextField oldTextField;
    protected final PasswordField newPassField;
    protected final PasswordField confirmPassField;
    protected final TextField newTextField;
    protected final TextField confirmTextField;
    protected final TextFlow textFlow;
    protected final Text text;
    protected final Label label;
    protected final Button confirmPassChangeBt;
    protected final Button cancelPassChangesBt;
    protected final CheckBox showOldPassCheck;
    protected final CheckBox showNewPassCheck;

    public changePasswordBase() {

        oldPassField = new PasswordField();
        oldTextField = new TextField();
        newPassField = new PasswordField();
        confirmPassField = new PasswordField();
        newTextField = new TextField();
        confirmTextField = new TextField();
        textFlow = new TextFlow();
        text = new Text();
        label = new Label();
        confirmPassChangeBt = new Button();
        cancelPassChangesBt = new Button();
        showOldPassCheck = new CheckBox();
        showNewPassCheck = new CheckBox();

        setPrefHeight(327.0);
        setPrefWidth(326.0);

        oldPassField.setLayoutX(36.0);
        oldPassField.setLayoutY(32.0);
        oldPassField.setPrefHeight(25.0);
        oldPassField.setPrefWidth(257.0);
        oldPassField.setPromptText("Old Password");

        oldTextField.setLayoutX(35.0);
        oldTextField.setLayoutY(32.0);
        oldTextField.setPrefHeight(25.0);
        oldTextField.setPrefWidth(258.0);

        newPassField.setLayoutX(35.0);
        newPassField.setLayoutY(179.0);
        newPassField.setPrefHeight(25.0);
        newPassField.setPrefWidth(255.0);
        newPassField.setPromptText("New Password");

        confirmPassField.setLayoutX(35.0);
        confirmPassField.setLayoutY(219.0);
        confirmPassField.setPrefHeight(25.0);
        confirmPassField.setPrefWidth(255.0);
        confirmPassField.setPromptText("Confirm new Password");

        newTextField.setLayoutX(34.0);
        newTextField.setLayoutY(179.0);
        newTextField.setPrefHeight(25.0);
        newTextField.setPrefWidth(256.0);

        confirmTextField.setLayoutX(36.0);
        confirmTextField.setLayoutY(219.0);
        confirmTextField.setPrefHeight(25.0);
        confirmTextField.setPrefWidth(256.0);

        textFlow.setLayoutX(34.0);
        textFlow.setLayoutY(115.0);
        textFlow.setPrefHeight(49.0);
        textFlow.setPrefWidth(265.0);

        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Use at least 10 characters, only letters and digits, at least one uppercase letter, and at least two digits.");
        text.setWrappingWidth(202.03125);

        label.setLayoutX(34.0);
        label.setLayoutY(94.0);
        label.setStyle("-fx-text-fill: #3274D2; -fx-font-size: 15;");
        label.setText("Password strength:");

        confirmPassChangeBt.setLayoutX(173.0);
        confirmPassChangeBt.setLayoutY(281.0);
        confirmPassChangeBt.setMnemonicParsing(false);
        confirmPassChangeBt.setOnAction(this::confirmPassChange);
        confirmPassChangeBt.setPrefHeight(32.0);
        confirmPassChangeBt.setPrefWidth(120.0);
        confirmPassChangeBt.setStyle("-fx-background-color: #3274D2; -fx-text-fill: #FFFFFF;");
        confirmPassChangeBt.setText("Change password");

        cancelPassChangesBt.setLayoutX(80.0);
        cancelPassChangesBt.setLayoutY(281.0);
        cancelPassChangesBt.setMnemonicParsing(false);
        cancelPassChangesBt.setOnAction(this::cancelPassChange);
        cancelPassChangesBt.setPrefHeight(32.0);
        cancelPassChangesBt.setPrefWidth(74.0);
        cancelPassChangesBt.setStyle("-fx-background-color: transparent; -fx-text-fill: #3274D2;");
        cancelPassChangesBt.setText("Cancel");

        showOldPassCheck.setLayoutX(189.0);
        showOldPassCheck.setLayoutY(66.0);
        showOldPassCheck.setMnemonicParsing(false);
        showOldPassCheck.setText("Show Password");

        showNewPassCheck.setLayoutX(189.0);
        showNewPassCheck.setLayoutY(252.0);
        showNewPassCheck.setMnemonicParsing(false);
        showNewPassCheck.setText("Show Password");

        getChildren().add(oldPassField);
        getChildren().add(oldTextField);
        getChildren().add(newPassField);
        getChildren().add(confirmPassField);
        getChildren().add(newTextField);
        getChildren().add(confirmTextField);
        textFlow.getChildren().add(text);
        getChildren().add(textFlow);
        getChildren().add(label);
        getChildren().add(confirmPassChangeBt);
        getChildren().add(cancelPassChangesBt);
        getChildren().add(showOldPassCheck);
        getChildren().add(showNewPassCheck);

    }

    protected abstract void confirmPassChange(javafx.event.ActionEvent actionEvent);

    protected abstract void cancelPassChange(javafx.event.ActionEvent actionEvent);

}
