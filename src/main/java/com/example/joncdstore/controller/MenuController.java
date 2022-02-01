package com.example.joncdstore.controller;

import com.example.joncdstore.App;
import com.example.joncdstore.view.Login;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.BufferedInputStream;

public class MenuController {

    public static void logOut(Stage stage) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Confirm");
        window.setResizable(false);
        window.getIcons().add(new Image(App.class.getResourceAsStream("img/icon.jpg")));
        Label label = new Label();
        label.setText("Do you want to log out?");
        label.setStyle("-fx-font-size: 15; -fx-font-weight: bold;");

        Button yesBt = new Button("Log out");
        Button noBt = new Button("Cancel");

        yesBt.setOnAction(e -> {
            window.close();
            stage.setScene(new Login(stage).createLoginScene());
        });

        noBt.setOnAction(e -> {
            window.close();
        });

        HBox boxBt = new HBox(10);
        boxBt.getChildren().addAll(yesBt,noBt);
        boxBt.setAlignment(Pos.CENTER);

        VBox box = new VBox(10);
        box.setPrefWidth(30);
        box.getChildren().addAll(label,boxBt);
        box.setAlignment(Pos.CENTER);

        Scene scene = new Scene(box,200,60);
        window.setScene(scene);
        window.showAndWait();
    }

}
