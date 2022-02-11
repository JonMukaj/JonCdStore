package com.example.joncdstore.view;

import com.example.joncdstore.controller.StatisticsController;
import com.example.joncdstore.model.Statistics;
import com.example.joncdstore.model.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StatisticsView {

    private final ScrollPane scrollPane;
    private final AnchorPane anchorPane;
    private final Label cdSellLabel;
    private final Text cdSellText;
    private final Label cdPurchaseLabel;
    private final Label billSellLabel;
    private final Label billPurchaseLabel;
    private final Text cdPurchaseText;
    private final Text billSellText;
    private final Text billPurchaseText;
    private final Label turnoverLabel;
    private final Text turnoverText;
    private final Label label;
    private final Text costText;
    private final Separator sep5;
    private final Separator sep4;
    private final Separator sep3;
    private final Separator sep2;
    private final Separator sep6;
    private final Button statisticsBt;
    private final Button userBt;
    private final Button cdBt;
    private final Separator sep1;
    private final Text confirmText;
    private final Button graphBt;

    public StatisticsView(User u, Stage stage) {

        Statistics.popStatistics();

        scrollPane = new ScrollPane();
        anchorPane = new AnchorPane();
        cdSellLabel = new Label();
        cdSellText = new Text();
        cdPurchaseLabel = new Label();
        billSellLabel = new Label();
        billPurchaseLabel = new Label();
        cdPurchaseText = new Text();
        billSellText = new Text();
        billPurchaseText = new Text();
        turnoverLabel = new Label();
        turnoverText = new Text();
        label = new Label();
        costText = new Text();
        confirmText = new Text();
        graphBt = new Button();

        sep1 = new Separator();
        sep2 = new Separator();
        sep3 = new Separator();
        sep4 = new Separator();
        sep5 = new Separator();
        sep6 = new Separator();

        statisticsBt = new Button();
        userBt = new Button();
        cdBt = new Button();

        confirmText.setVisible(false);

        scrollPane.getStylesheets().add(this.getClass().getResource("/Menu.css").toExternalForm());

        cdSellLabel.setLayoutX(131.0);
        cdSellLabel.setLayoutY(119.0);
        cdSellLabel.setStyle("-fx-font-size: 28;");
        cdSellLabel.setText("Total Nr. Of Sold CDs:");


        cdPurchaseLabel.setLayoutX(104.0);
        cdPurchaseLabel.setLayoutY(186.0);
        cdPurchaseLabel.setStyle("-fx-font-size: 28;");
        cdPurchaseLabel.setText("Total Nr. Of Supplied CDs:");

        billSellLabel.setLayoutX(153.0);
        billSellLabel.setLayoutY(255.0);
        billSellLabel.setStyle("-fx-font-size: 28;");
        billSellLabel.setText("Total Of Sell Bills:");

        billPurchaseLabel.setLayoutX(113.0);
        billPurchaseLabel.setLayoutY(325.0);
        billPurchaseLabel.setStyle("-fx-font-size: 28;");
        billPurchaseLabel.setText("Total Of Purchase Bills:");

        cdSellText.setLayoutX(481.0);
        cdSellText.setLayoutY(151.0);
        cdSellText.setStyle("-fx-font-size: 28;");
        cdSellText.setText(String.valueOf(Statistics.getTotalNrOfCdSold()));
        cdSellText.setWrappingWidth(200.0);

        cdPurchaseText.setLayoutX(481.0);
        cdPurchaseText.setLayoutY(217.0);
        cdPurchaseText.setStyle("-fx-font-size: 28;");
        cdPurchaseText.setText(String.valueOf(Statistics.getTotalNrOfCdBought()));
        cdPurchaseText.setWrappingWidth(200.0);

        billSellText.setLayoutX(481.0);
        billSellText.setLayoutY(287.0);
        billSellText.setStyle("-fx-font-size: 28;");
        billSellText.setText(String.valueOf(Statistics.getTotalNrOfBillSold()));
        billSellText.setWrappingWidth(200.0);

        billPurchaseText.setLayoutX(481.0);
        billPurchaseText.setLayoutY(358.0);
        billPurchaseText.setStyle("-fx-font-size: 28;");
        billPurchaseText.setText(String.valueOf(Statistics.getTotalNrOfBillBought()));
        billPurchaseText.setWrappingWidth(200.0);

        turnoverLabel.setLayoutX(195.0);
        turnoverLabel.setLayoutY(426.0);
        turnoverLabel.setStyle("-fx-text-fill: green;-fx-font-size: 28;");
        turnoverLabel.setText("Turnover:");

        turnoverText.setLayoutX(481.0);
        turnoverText.setLayoutY(455.0);
        turnoverText.setStyle("-fx-fill: green;-fx-font-size: 28;");
        turnoverText.setText(String.valueOf(Statistics.getRevenue()));
        turnoverText.setWrappingWidth(200.0);

        label.setLayoutX(169.0);
        label.setLayoutY(493.0);
        label.setStyle("-fx-text-fill: red;-fx-font-size: 28;");
        label.setText("Cost Of Sales:");

        costText.setLayoutX(481.0);
        costText.setLayoutY(523.0);
        costText.setStyle("-fx-fill: red;-fx-font-size: 28;");
        costText.setText(String.valueOf(Statistics.getCost()));
        costText.setWrappingWidth(200.0);

        sep1.setLayoutY(96.0);
        sep1.setPrefHeight(14.0);
        sep1.setPrefWidth(729.0);

        sep2.setLayoutY(172.0);
        sep2.setPrefHeight(14.0);
        sep2.setPrefWidth(729.0);

        sep3.setLayoutY(235.0);
        sep3.setPrefHeight(14.0);
        sep3.setPrefWidth(729.0);

        sep4.setLayoutY(307.0);
        sep4.setPrefHeight(14.0);
        sep4.setPrefWidth(729.0);

        sep5.setLayoutY(382.0);
        sep5.setPrefHeight(14.0);
        sep5.setPrefWidth(729.0);

        sep6.setLayoutX(1.0);
        sep6.setLayoutY(470.0);
        sep6.setPrefHeight(14.0);
        sep6.setPrefWidth(729.0);

        if(u.getPrivilege() != 0) {
            statisticsBt.setDisable(true);
            userBt.setDisable(true);
            cdBt.setDisable(true);
        }


        statisticsBt.setLayoutX(26.0);
        statisticsBt.setLayoutY(14.0);
        statisticsBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                StatisticsController.deleteStatistics();
                costText.setText("0.0");
                cdPurchaseText.setText("0");
                cdSellText.setText("0");
                turnoverText.setText("0.0");
                billPurchaseText.setText("0");
                billSellText.setText("0");
            }
        });
        statisticsBt.setPrefHeight(37.0);
        statisticsBt.setPrefWidth(95.0);
        statisticsBt.setText("Reset Statistics");
        statisticsBt.getStyleClass().add("remove");

        graphBt.setLayoutX(600.0);
        graphBt.setLayoutY(14.0);
        graphBt.setPrefHeight(37.0);
        graphBt.setPrefWidth(95.0);
        graphBt.getStyleClass().add("edit");
        graphBt.setText("Show Graph");
        graphBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                StatisticsController.createGraphScene(u,stage);
            }
        });

        userBt.setLayoutX(150.0);
        userBt.setLayoutY(14.0);
        userBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                StatisticsController.deleteUser();
                confirmText.setLayoutX(177.0);
                confirmText.setLayoutY(66.0);
                confirmText.setStyle("-fx-fill: red;-fx-font-size: 18;");
                confirmText.setText("Done!");
                confirmText.setVisible(true);
            }
        });
        userBt.setPrefHeight(37.0);
        userBt.setPrefWidth(102.0);
        userBt.setText("Delete User Info");
        userBt.getStyleClass().add("remove");

        cdBt.setLayoutX(281.0);
        cdBt.setLayoutY(14.0);
        cdBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                StatisticsController.deleteCD();
                confirmText.setLayoutX(304.0);
                confirmText.setLayoutY(66.0);
                confirmText.setStyle("-fx-fill: red;-fx-font-size: 18;");
                confirmText.setText("Done!");
                confirmText.setVisible(true);
            }
        });
        cdBt.setPrefHeight(37.0);
        cdBt.setPrefWidth(94.0);
        cdBt.setText("Delete CD Info");
        cdBt.getStyleClass().add("remove");


        scrollPane.setPrefHeight(573.0);
        scrollPane.setPrefWidth(729.0);
        scrollPane.setLayoutX(233);
        scrollPane.setLayoutY(110);

        anchorPane.getChildren().add(cdSellLabel);
        anchorPane.getChildren().add(cdSellText);
        anchorPane.getChildren().add(cdPurchaseLabel);
        anchorPane.getChildren().add(billSellLabel);
        anchorPane.getChildren().add(billPurchaseLabel);
        anchorPane.getChildren().add(cdPurchaseText);
        anchorPane.getChildren().add(billSellText);
        anchorPane.getChildren().add(billPurchaseText);
        anchorPane.getChildren().add(turnoverLabel);
        anchorPane.getChildren().add(turnoverText);
        anchorPane.getChildren().add(label);
        anchorPane.getChildren().add(costText);

        anchorPane.getChildren().add(sep1);
        anchorPane.getChildren().add(sep2);
        anchorPane.getChildren().add(sep3);
        anchorPane.getChildren().add(sep4);
        anchorPane.getChildren().add(sep5);
        anchorPane.getChildren().add(sep6);

        anchorPane.getChildren().add(statisticsBt);
        anchorPane.getChildren().add(userBt);
        anchorPane.getChildren().add(cdBt);
        anchorPane.getChildren().add(graphBt);
        anchorPane.getChildren().add(confirmText);

        scrollPane.setContent(anchorPane);



    }

    public ScrollPane getScrollPane() {
        return scrollPane;
    }


}
