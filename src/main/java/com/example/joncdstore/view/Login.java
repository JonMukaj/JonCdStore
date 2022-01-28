package com.example.joncdstore.view;

import com.example.joncdstore.controller.Authenticator;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class Login {

    private final AnchorPane anchorPane;
    private final GridPane gridPane;
    private final ColumnConstraints columnConstraints1;
    private final ColumnConstraints columnConstraints2;
    private final RowConstraints rowConstraints1;
    private final RowConstraints rowConstraints2;
    private final Text title;
    private final Label usernameLabel;
    private final Label passwordLabel;
    private final PasswordField passwordField;
    private final TextField usernameField;
    private final Button loginButton;

    public Login() {

        anchorPane = new AnchorPane();
        gridPane = new GridPane();
        columnConstraints1 = new ColumnConstraints();
        columnConstraints2 = new ColumnConstraints();
        rowConstraints1 = new RowConstraints();
        rowConstraints2 = new RowConstraints();
        title = new Text();
        usernameLabel = new Label();
        usernameField = new TextField();
        passwordLabel = new Label();
        passwordField = new PasswordField();
        loginButton = new Button();

        anchorPane.setPrefHeight(657.0);
        anchorPane.setPrefWidth(877.0);
        anchorPane.getStylesheets().add(this.getClass().getResource("/FXstyle.css").toExternalForm());
        anchorPane.getStyleClass().add("main");

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setLayoutX(234.0);
        gridPane.setLayoutY(31.0);
        gridPane.setPrefHeight(509.0);
        gridPane.setPrefWidth(428.0);

        columnConstraints1.setMaxWidth(400.0);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(180.0);
        columnConstraints2.setPrefWidth(252.0);
        rowConstraints1.setPrefHeight(410.0);
        rowConstraints2.setPrefHeight(56.0);

        title.setId("rainbow-text");
        title.setStyle("-fx-font-family: 'Brush Script MT'; -fx-font-size: 70;");
        title.setText("C D W O R L D");
        title.setTextAlignment(TextAlignment.CENTER);
        title.setWrappingWidth(450.0);

        GridPane.setRowIndex(usernameLabel, 1);
        usernameLabel.setAlignment(Pos.CENTER_RIGHT);
        usernameLabel.setPrefHeight(30.0);
        usernameLabel.setPrefWidth(168.0);
        usernameLabel.setStyle("-fx-font-size: 20; -fx-font-weight: Bold;");
        usernameLabel.setText("Username");
        usernameLabel.setTextFill(Color.BLACK);

        GridPane.setRowIndex(passwordLabel, 2);
        passwordLabel.setAlignment(Pos.CENTER_RIGHT);
        passwordLabel.setPrefHeight(30.0);
        passwordLabel.setPrefWidth(168.0);
        passwordLabel.setStyle("-fx-font-size: 20; -fx-font-weight: bold;");
        passwordLabel.setText("Password");
        passwordLabel.setTextFill(Color.BLACK);

        GridPane.setColumnIndex(usernameField, 1);
        GridPane.setRowIndex(usernameField, 1);
        usernameField.setMaxHeight(25.0);
        usernameField.setMaxWidth(164.0);
        usernameField.setPromptText("Enter username");

        GridPane.setColumnIndex(passwordField, 1);
        GridPane.setRowIndex(passwordField, 2);
        passwordField.setMaxHeight(25.0);
        passwordField.setMaxWidth(164.0);
        passwordField.setPromptText("Enter password");

        loginButton.setLayoutX(412.0);
        loginButton.setLayoutY(551.0);
        loginButton.setOnAction(Authenticator::authenticate);
        loginButton.setPrefHeight(25.0);
        loginButton.setPrefWidth(96.0);
        loginButton.getStyleClass().add("login");
        loginButton.setText("Login");

        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getColumnConstraints().add(columnConstraints2);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getRowConstraints().add(rowConstraints2);
        gridPane.getChildren().add(title);
        gridPane.getChildren().add(usernameLabel);
        gridPane.getChildren().add(passwordLabel);
        gridPane.getChildren().add(passwordField);
        gridPane.getChildren().add(usernameField);
        anchorPane.getChildren().add(gridPane);
        anchorPane.getChildren().add(loginButton);

    }

    public Scene createLoginScene() {
        return new Scene(anchorPane,877,650);
    }

}
