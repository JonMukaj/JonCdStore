package com.example.joncdstore.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WarningStock {

    private final AnchorPane anchorPane;
    private final Text genreText;
    private final Button okBt;
    private final Text sizeText;

    public WarningStock(Stage window, String genre, int size) {

        anchorPane = new AnchorPane();
        genreText = new Text();
        okBt = new Button();
        sizeText = new Text();


        anchorPane.getStylesheets().add(this.getClass().getResource("/Menu.css").toExternalForm());

        genreText.setLayoutX(21.0);
        genreText.setLayoutY(48.0);
        genreText.setStyle("-fx-fill: red; -fx-font-size: 20;");
        //genreText.setText("Genre: Comedy will soon be out of stock!");
        genreText.setText("Genre: " + genre + " will soon be out of stock!");


        okBt.setLayoutX(154.0);
        okBt.setLayoutY(90);
        okBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.close();
            }
        });
        okBt.setPrefHeight(25.0);
        okBt.setPrefWidth(97.0);
        okBt.setText("Later");
        okBt.getStyleClass().add("exit-but");

        sizeText.setLayoutX(161.0);
        sizeText.setLayoutY(73.0);
        sizeText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        sizeText.setStrokeWidth(0.0);
        sizeText.setStyle("-fx-fill: red;");
        sizeText.setText("(Stock Left: " + size + ")" );
        //sizeText.setText("(Stock Left: 2)");

        anchorPane.setPrefHeight(136.0);
        anchorPane.setPrefWidth(404.0);

        anchorPane.getChildren().add(genreText);
        anchorPane.getChildren().add(okBt);
        anchorPane.getChildren().add(sizeText);

    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }


}
