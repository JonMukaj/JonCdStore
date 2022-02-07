package com.example.joncdstore.view;

import com.example.joncdstore.controller.LogisticsController;
import com.example.joncdstore.model.CD;
import com.example.joncdstore.model.CdManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FindCD {

    private final AnchorPane anchorPane;
    private final Button addToCartBt;
    private final Button cancelBt;
    private final Label titleLabel;
    private final Label genreLabel;
    private final Label authorLabel;
    private final Button findBt;
    private final Label priceLabel;
    private final Label label;
    private final Spinner<Integer> spinner;
    private final TextField titleField;
    private final TextField genreField;
    private final TextField authorField;
    private final Label errTitle;
    private final Label errGenre;
    private final Label errAuthor;
    private final Text priceField;
    private final Label errQuantity;

    private CD c;

    public FindCD(TableView<CD> t,Stage window) {

        anchorPane = new AnchorPane();
        addToCartBt = new Button();
        cancelBt = new Button();
        titleLabel = new Label();
        genreLabel = new Label();
        authorLabel = new Label();
        findBt = new Button();
        priceLabel = new Label();
        label = new Label();
        spinner = new Spinner<>();
        titleField = new TextField();
        genreField = new TextField();
        authorField = new TextField();
        errTitle = new Label();
        errGenre = new Label();
        errAuthor = new Label();
        priceField = new Text();
        errQuantity = new Label();

        anchorPane.getStylesheets().add(this.getClass().getResource("/Menu.css").toExternalForm());

        spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,0,0,1));

        addToCartBt.setLayoutX(121.0);
        addToCartBt.setLayoutY(276.0);
        addToCartBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (spinner.getValue() > 0) {
                    c.setTotalQuantity(spinner.getValue());
                    LogisticsController.addToCart(t,c);
                    window.close();
                }
                else {
                    errQuantity.setVisible(true);
                }

            }
        });
        addToCartBt.setPrefHeight(32.0);
        addToCartBt.setPrefWidth(120.0);
        addToCartBt.getStyleClass().add("edit");
        addToCartBt.setText("Add To Cart");

        cancelBt.setLayoutX(34.0);
        cancelBt.setLayoutY(276.0);
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

        titleLabel.setLayoutX(36.0);
        titleLabel.setLayoutY(21.0);
        titleLabel.setStyle("-fx-font-size: 20;");
        titleLabel.setText("Title:");

        genreLabel.setLayoutX(20.0);
        genreLabel.setLayoutY(62.0);
        genreLabel.setStyle("-fx-font-size: 20;");
        genreLabel.setText("Genre:");

        authorLabel.setLayoutX(16.0);
        authorLabel.setLayoutY(104.0);
        authorLabel.setStyle("-fx-font-size: 20;");
        authorLabel.setText("Author:");

        findBt.setLayoutX(162.0);
        findBt.setLayoutY(149.0);
        findBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean fieldsFull = true;
                String title = "", genre = "", author = "";
                double sellingPrice,purchasedPrice;

                if (!titleField.getText().trim().equals("")) {
                    title = titleField.getText();
                    errTitle.setVisible(false);
                }
                else {
                    errTitle.setVisible(true);
                    fieldsFull = false;
                }
                if (!genreField.getText().trim().equals("")) {
                    genre = genreField.getText();
                    errGenre.setVisible(false);
                } else {
                    errGenre.setVisible(true);
                    fieldsFull = false;
                }
                if(!authorField.getText().trim().equals("")) {
                    author = authorField.getText();
                    errAuthor.setVisible(false);
                }
                else {
                    errAuthor.setVisible(true);
                    fieldsFull = false;
                }

                if(fieldsFull) {
                    double tmp = (Math.random() * 100) + 30;
                    purchasedPrice = Double.parseDouble(String.format("%.2f",tmp));
                    sellingPrice = 1.1 * purchasedPrice;
                    priceField.setText(String.valueOf(purchasedPrice));

                    spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,20,0,1));
                    c = new CD(title,genre,author,purchasedPrice,sellingPrice,0);
                }

            }
        });
        findBt.setPrefHeight(25.0);
        findBt.setPrefWidth(74.0);
        findBt.setText("Find");

        priceLabel.setLayoutX(33.0);
        priceLabel.setLayoutY(180.0);
        priceLabel.setStyle("-fx-font-size: 20;");
        priceLabel.setText("Price:");

        label.setLayoutX(13.0);
        label.setLayoutY(220.0);
        label.setStyle("-fx-font-size: 20;");
        label.setText("Quantity:");

        spinner.setLayoutX(104.0);
        spinner.setLayoutY(224.0);
        spinner.setPrefHeight(25.0);
        spinner.setPrefWidth(74.0);

        titleField.setLayoutX(86.0);
        titleField.setLayoutY(24.0);

        genreField.setLayoutX(87.0);
        genreField.setLayoutY(66.0);

        authorField.setLayoutX(87.0);
        authorField.setLayoutY(107.0);

        errTitle.setAlignment(javafx.geometry.Pos.CENTER);
        errTitle.setLayoutX(236.0);
        errTitle.setLayoutY(22.0);
        errTitle.setPrefHeight(17.0);
        errTitle.setPrefWidth(26.0);
        errTitle.setStyle("-fx-font-size: 20; -fx-text-fill: red;");
        errTitle.setText("!");
        errTitle.setVisible(false);

        errGenre.setAlignment(javafx.geometry.Pos.CENTER);
        errGenre.setLayoutX(236.0);
        errGenre.setLayoutY(62.0);
        errGenre.setPrefHeight(17.0);
        errGenre.setPrefWidth(26.0);
        errGenre.setStyle("-fx-font-size: 20; -fx-text-fill: red;");
        errGenre.setText("!");
        errGenre.setVisible(false);

        errAuthor.setAlignment(javafx.geometry.Pos.CENTER);
        errAuthor.setLayoutX(236.0);
        errAuthor.setLayoutY(104.0);
        errAuthor.setPrefHeight(17.0);
        errAuthor.setPrefWidth(26.0);
        errAuthor.setStyle("-fx-font-size: 20; -fx-text-fill: red;");
        errAuthor.setText("!");
        errAuthor.setVisible(false);

        priceField.setLayoutX(87.0);
        priceField.setLayoutY(203.0);
        priceField.setStyle("-fx-font-size: 20;");
        priceField.setText("0.0");
        priceField.setWrappingWidth(156.0);

        errQuantity.setAlignment(javafx.geometry.Pos.CENTER);
        errQuantity.setLayoutX(186.0);
        errQuantity.setLayoutY(220.0);
        errQuantity.setPrefHeight(17.0);
        errQuantity.setPrefWidth(26.0);
        errQuantity.setStyle("-fx-font-size: 20; -fx-text-fill: red;");
        errQuantity.setText("!");
        errQuantity.setVisible(false);

        anchorPane.setPrefHeight(323.0);
        anchorPane.setPrefWidth(272.0);
        anchorPane.setPrefHeight(323.0);
        anchorPane.setPrefWidth(272.0);

        anchorPane.getChildren().add(addToCartBt);
        anchorPane.getChildren().add(cancelBt);
        anchorPane.getChildren().add(titleLabel);
        anchorPane.getChildren().add(genreLabel);
        anchorPane.getChildren().add(authorLabel);
        anchorPane.getChildren().add(findBt);
        anchorPane.getChildren().add(priceLabel);
        anchorPane.getChildren().add(label);
        anchorPane.getChildren().add(spinner);
        anchorPane.getChildren().add(titleField);
        anchorPane.getChildren().add(genreField);
        anchorPane.getChildren().add(authorField);
        anchorPane.getChildren().add(errTitle);
        anchorPane.getChildren().add(errGenre);
        anchorPane.getChildren().add(errAuthor);
        anchorPane.getChildren().add(priceField);
        anchorPane.getChildren().add(errQuantity);

    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    /*protected abstract void addToCart(javafx.event.ActionEvent actionEvent);

    protected abstract void cancel(javafx.event.ActionEvent actionEvent);

    protected abstract void createCD(javafx.event.ActionEvent actionEvent);*/

}
