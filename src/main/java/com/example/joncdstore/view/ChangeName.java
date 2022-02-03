package com.example.joncdstore.view;

import com.example.joncdstore.App;
import com.example.joncdstore.controller.AccountController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ChangeName{

    private final Stage window;
    private final VBox vBox;
    private final AnchorPane anchorPane;
    private final Text text;
    private final TextField textField1;
    private final Label label1;
    private final Label label2;
    private final TextField textField2;
    private final Button button1;
    private final Button button2;

    public ChangeName(String name,String surname) {

        window = new Stage();
        vBox = new VBox();
        anchorPane = new AnchorPane();
        text = new Text();
        textField1 = new TextField();
        label1 = new Label();
        label2 = new Label();
        textField2 = new TextField();
        button1 = new Button();
        button2 = new Button();

        vBox.setLayoutX(0);
        vBox.setLayoutY(0);
        vBox.setPrefHeight(198.0);
        vBox.setPrefWidth(285.0);
        vBox.setStyle("-fx-background-color: #FFFFFF; -fx-border-radius: 5; -fx-border-width: 1;");

        anchorPane.setPrefHeight(214.0);
        anchorPane.setPrefWidth(283.0);

        text.setLayoutX(29.0);
        text.setLayoutY(41.0);
        text.setStrokeWidth(0.0);
        text.setStyle("-fx-font-size: 15;");
        text.setText("CHANGE NAME");
        text.setWrappingWidth(152);

        textField1.setText(name);
        textField1.setLayoutX(121.0);
        textField1.setLayoutY(67.0);
        textField1.setStyle("-fx-border-style: solid inside; -fx-background-color: #F5F5F5; -fx-border-width: 0.2;");

        label1.setLayoutX(29.0);
        label1.setLayoutY(69.0);
        label1.setStyle("-fx-font-size: 15;");
        label1.setText("First name");

        label2.setLayoutX(30.0);
        label2.setLayoutY(113.0);
        label2.setStyle("-fx-font-size: 15;");
        label2.setText("Last name");

        textField2.setText(surname);
        textField2.setLayoutX(121.0);
        textField2.setLayoutY(111.0);
        textField2.setStyle("-fx-border-style: solid inside; -fx-background-color: #F5F5F5; -fx-border-width: 0.2;");

        button1.setLayoutX(217.0);
        button1.setLayoutY(152.0);
        button1.setPrefHeight(25.0);
        button1.setPrefWidth(52.0);
        button1.setOnAction(event -> {
            confirmChange((Button) event.getSource());
        });
        button1.setStyle("-fx-background-color: #3274D2; -fx-text-fill: #FFFFFF;");
        button1.setText("Save");

        button2.setLayoutX(155.0);
        button2.setLayoutY(152.0);
        button2.setPrefHeight(25.0);
        button2.setPrefWidth(52.0);
        button2.setOnAction(event -> {
            confirmChange((Button) event.getSource());
        });
        button2.setStyle("-fx-background-color: transparent; -fx-text-fill: #3274D2;");
        button2.setText("Cancel");

        anchorPane.getChildren().add(text);
        anchorPane.getChildren().add(textField1);
        anchorPane.getChildren().add(label1);
        anchorPane.getChildren().add(label2);
        anchorPane.getChildren().add(textField2);
        anchorPane.getChildren().add(button1);
        anchorPane.getChildren().add(button2);
        vBox.getChildren().add(anchorPane);

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Edit");
        window.setResizable(false);
        window.getIcons().add(new Image(App.class.getResourceAsStream("img/icon.jpg")));

        Scene scene = new Scene(vBox,285,198);
        window.setScene(scene);
        window.showAndWait();

    }
    public void confirmChange(Button bt) {
        if (bt.getText().matches("Save")) {
            new AccountController().changeNameConfirm(textField1.getText(),textField2.getText());
            window.close();
        }
        else {
            window.close();
        }
    }

    public TextField getTextField1() {
        return textField1;
    }

    public TextField getTextField2() {
        return textField2;
    }
}
