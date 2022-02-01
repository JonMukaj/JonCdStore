package com.example.joncdstore.view;

import com.example.joncdstore.controller.loginController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Login {

    private final AnchorPane anchorPane;
    private final GridPane gridPane;
    private final ColumnConstraints columnConstraints0;
    private final ColumnConstraints columnConstraints1;
    private final RowConstraints rowConstraints0;
    private final RowConstraints rowConstraints1;
    private final Text Title;
    private final Label UsernameLabel;
    private final Label PasswordLabel;
    private final PasswordField passwordField;
    private final TextField usernameField;
    private final Button buttonLogin;
    private final Button buttonCancel;
    private final Text errorText;
    private final Stage stage;

    public Login(Stage stage) {

        this.stage = stage;

        anchorPane = new AnchorPane();
        gridPane = new GridPane();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        Title = new Text();
        UsernameLabel = new Label();
        PasswordLabel = new Label();
        passwordField = new PasswordField();
        usernameField = new TextField();
        buttonLogin = new Button();
        buttonCancel = new Button();
        errorText = new Text("Wrong Username or Password!");

        anchorPane.getStyleClass().add("main");
        anchorPane.getStylesheets().add(this.getClass().getResource("/FXstyleLogin.css").toExternalForm());

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setLayoutX(84.0);
        gridPane.setLayoutY(122.0);
        gridPane.setPrefHeight(189.0);
        gridPane.setPrefWidth(488.0);

        Title.setId("color-text");

        Title.setStyle("-fx-font-family: 'Brush Script MT'; -fx-font-size: 40;");
        Title.setText("C D - W O R L D");
        Title.setTextAlignment(TextAlignment.CENTER);
        Title.setWrappingWidth(487.0);
        Title.setFont(new Font(48.0));

        GridPane.setRowIndex(UsernameLabel, 1);
        UsernameLabel.setAlignment(Pos.TOP_RIGHT);
        UsernameLabel.setId("color-text");
        UsernameLabel.setPrefHeight(29.0);
        UsernameLabel.setPrefWidth(171.0);
        UsernameLabel.setStyle("-fx-font-size: 15; -fx-font-weight: Bold;");
        UsernameLabel.setText("Username");
        UsernameLabel.setTextFill(Color.valueOf("#0d0d0d"));
        UsernameLabel.setFont(new Font("Bold", 14.0));

        GridPane.setRowIndex(PasswordLabel, 2);
        PasswordLabel.setAlignment(Pos.CENTER_RIGHT);
        PasswordLabel.setPrefHeight(30.0);
        PasswordLabel.setPrefWidth(172.0);
        PasswordLabel.setStyle("-fx-font-size: 15; -fx-font-weight: bold;");
        PasswordLabel.setText("Password");
        PasswordLabel.setTextAlignment(TextAlignment.CENTER);
        PasswordLabel.setTextFill(Color.valueOf("#030303"));

        GridPane.setColumnIndex(passwordField, 1);
        GridPane.setRowIndex(passwordField, 2);
        passwordField.setMaxHeight(anchorPane.USE_PREF_SIZE);
        passwordField.setMaxWidth(anchorPane.USE_PREF_SIZE);
        passwordField.setPrefHeight(25.0);
        passwordField.setPrefWidth(184.0);
        passwordField.setPromptText("Enter password");

        GridPane.setColumnIndex(usernameField, 1);
        GridPane.setRowIndex(usernameField, 1);
        usernameField.setMaxHeight(25.0);
        usernameField.setMaxWidth(183.0);
        usernameField.setMinHeight(20.0);
        usernameField.setMinWidth(20.0);
        usernameField.setPrefHeight(25.0);
        usernameField.setPrefWidth(179.0);
        usernameField.setPromptText("Enter username");

        buttonLogin.setStyle("-fx-background-radius: 8;" +
                "-fx-background-insets: 0, 0 1 1 0;");
        buttonLogin.setLayoutX(202.0);
        buttonLogin.setLayoutY(311.0);
        buttonLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loginController.authenticateUser(usernameField,passwordField,errorText,stage);
            }
        });
        buttonLogin.setPrefHeight(25.0);
        buttonLogin.setPrefWidth(95.0);
        buttonLogin.getStyleClass().add("login-but");
        buttonLogin.setText("Login");

        buttonCancel.setStyle("-fx-background-radius: 8;" +
                "-fx-background-insets: 0, 0 1 1 0;");
        buttonCancel.setLayoutX(328.0);
        buttonCancel.setLayoutY(311.0);
        buttonCancel.setOnAction(event -> stage.close());
        buttonCancel.setPrefHeight(25.0);
        buttonCancel.setPrefWidth(95.0);
        buttonCancel.getStyleClass().add("exit-but");
        buttonCancel.setText("Exit");

        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(183.0);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(305.0);

        rowConstraints0.setPrefHeight(107.0);
        rowConstraints1.setPrefHeight(37.0);

        errorText.setFill(Color.valueOf("#FF0000"));
        errorText.setVisible(false);
        errorText.setFont(new Font("Bold", 14.0));
        errorText.setTextAlignment(TextAlignment.CENTER);
        errorText.setLayoutX(225.0);
        errorText.setLayoutY(360.0);

        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getChildren().add(Title);
        gridPane.getChildren().add(UsernameLabel);
        gridPane.getChildren().add(PasswordLabel);
        gridPane.getChildren().add(passwordField);
        gridPane.getChildren().add(usernameField);
        anchorPane.getChildren().add(gridPane);
        anchorPane.getChildren().add(buttonLogin);
        anchorPane.getChildren().add(buttonCancel);
        anchorPane.getChildren().add(errorText);

    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public TextField getUsernameField() {
        return usernameField;
    }

    public Text getErrorText() {
        return errorText;
    }

    public Scene createLoginScene () {
        Scene scene = new Scene(anchorPane,660,480);
        return scene;
    }

}
