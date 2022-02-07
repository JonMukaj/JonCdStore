package com.example.joncdstore.view;

import com.example.joncdstore.controller.BillController;
import com.example.joncdstore.controller.LogisticsController;
import com.example.joncdstore.model.CD;
import com.example.joncdstore.model.CdManager;
import com.example.joncdstore.model.User;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SupplyView  {

    private final AnchorPane anchorPane;
    private final ScrollPane scrollPane;
    private final TableView<CD> cdBillTable;
    private final TableColumn<CD,String > titleC;
    private final TableColumn<CD,String > genreC;
    private final TableColumn<CD,String > authorC;
    private final TableColumn<CD,Double > priceC;
    private final TableColumn<CD,Integer > quantityC;
    private final Button returnBt;
    private final Button findBt;
    private final Button removeBt;
    private final Button createBillBt;
    private final Text generateText;
    private final Label priceLabel;
    private final Text priceText;

    private static double price;



    public SupplyView(User u, Stage stage,Scene oldScene) {


        anchorPane = new AnchorPane();
        scrollPane = new ScrollPane();
        cdBillTable = new TableView();
        titleC = new TableColumn();
        genreC = new TableColumn();
        authorC = new TableColumn();
        priceC = new TableColumn();
        quantityC = new TableColumn();
        returnBt = new Button();
        findBt = new Button();
        removeBt = new Button();
        createBillBt = new Button();
        priceLabel = new Label();
        priceText = new Text();
        generateText = new Text();


        anchorPane.getStylesheets().add(this.getClass().getResource("/Menu.css").toExternalForm());


        scrollPane.setLayoutY(51.0);
        scrollPane.setPrefHeight(469.0);
        scrollPane.setPrefWidth(793.0);

        cdBillTable.setPrefHeight(469.0);
        cdBillTable.setPrefWidth(778.0);

        titleC.setPrefWidth(275.0);
        titleC.setText("Title");

        genreC.setPrefWidth(148.0);
        genreC.setText("Genre");

        authorC.setPrefWidth(168.0);
        authorC.setText("Author");

        priceC.setPrefWidth(86.0);
        priceC.setText("Price");

        quantityC.setPrefWidth(99.0);
        quantityC.setText("Quantity");


        returnBt.setLayoutX(14.0);
        returnBt.setLayoutY(15.0);
        returnBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LogisticsController.getTmpCDlist().clear();
                BillController.returnBill(u,stage,oldScene);
                price = 0;
                priceText.setText(String.valueOf(price));
            }
        });
        returnBt.setPrefHeight(25.0);
        returnBt.setPrefWidth(66.0);
        returnBt.getStyleClass().add("edit");
        returnBt.setText("Return");



        findBt.setLayoutX(689.0);
        findBt.setLayoutY(15.0);
        findBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LogisticsController.findCD(cdBillTable);
                if (LogisticsController.getTmpCDlist().size() > 0) {
                    removeBt.setVisible(true);
                    createBillBt.setVisible(true);
                    priceLabel.setVisible(true);
                    priceText.setVisible(true);

                    price += LogisticsController.getC().getPurchasedPrice() * LogisticsController.getC().getTotalQuantity();
                    priceText.setText(String.format("%.2f",price));
                }
            }
        });



        findBt.setPrefHeight(25.0);
        findBt.setPrefWidth(66.0);
        findBt.getStyleClass().add("edit");
        findBt.setText("Find");


        removeBt.setLayoutX(279.0);
        removeBt.setLayoutY(534.0);
        removeBt.setPrefHeight(25.0);
        removeBt.setPrefWidth(66.0);
        removeBt.getStyleClass().add("remove");
        removeBt.setText("Remove");
        removeBt.setVisible(false);
        removeBt.disableProperty().bind(Bindings.isEmpty(cdBillTable.getSelectionModel().getSelectedItems()));
        removeBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                CD c = cdBillTable.getSelectionModel().getSelectedItem();

                price  -= c.getPurchasedPrice() * c.getTotalQuantity();

                LogisticsController.removeFromTable(cdBillTable,priceText);
                cdBillTable.getSelectionModel().clearSelection();
            }
        });


        createBillBt.setLayoutX(657.0);
        createBillBt.setLayoutY(527.0);
        createBillBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LogisticsController.generateBillPurchase(u);
                price = 0;
                priceText.setText(String.valueOf(price));
                generateText.setVisible(true);
                generateText.setText("Sucess!");
                cdBillTable.getItems().clear();
                LogisticsController.getTmpCDlist().clear();
            }
        });

        createBillBt.setPrefHeight(35.0);
        createBillBt.setPrefWidth(114.0);
        createBillBt.getStyleClass().add("modify");
        createBillBt.setText("Create Bill");
        createBillBt.setVisible(false);


        generateText.setLayoutX(602.0);
        generateText.setLayoutY(551.0);
        generateText.setStyle("-fx-fill: green;");
        generateText.setVisible(false);


        priceLabel.setLayoutX(418.0);
        priceLabel.setLayoutY(528.0);
        priceLabel.setPrefHeight(36.0);
        priceLabel.setPrefWidth(66.0);
        priceLabel.setStyle("-fx-font-size: 20;");
        priceLabel.setText("Price:");
        priceLabel.setVisible(false);

        priceText.setLayoutX(485.0);
        priceText.setLayoutY(555.0);
        priceText.setStyle("-fx-font-size: 20;");
        priceText.setText("0.0");
        priceText.setWrappingWidth(149);
        priceText.setVisible(false);


        scrollPane.setContent(cdBillTable);

        cdBillTable.getColumns().add(titleC);
        cdBillTable.getColumns().add(genreC);
        cdBillTable.getColumns().add(authorC);
        cdBillTable.getColumns().add(priceC);
        cdBillTable.getColumns().add(quantityC);

        titleC.setCellValueFactory(new PropertyValueFactory<>("titleOfCd"));
        genreC.setCellValueFactory(new PropertyValueFactory<>("genre"));
        authorC.setCellValueFactory(new PropertyValueFactory<>("author"));
        priceC.setCellValueFactory(new PropertyValueFactory<>("purchasedPrice"));
        quantityC.setCellValueFactory(new PropertyValueFactory<>("totalQuantity"));

        anchorPane.setPrefHeight(573.0);
        anchorPane.setPrefWidth(793.0);

        anchorPane.getChildren().add(scrollPane);
        anchorPane.getChildren().add(returnBt);
        anchorPane.getChildren().add(findBt);

        anchorPane.getChildren().add(removeBt);
        anchorPane.getChildren().add(createBillBt);
        anchorPane.getChildren().add(priceLabel);
        anchorPane.getChildren().add(priceText);
        anchorPane.getChildren().add(generateText);

    }

    public Scene generateBillViewScene () {
        return new Scene(anchorPane, 793, 573);
    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    public static double getPrice() {
        return price;
    }

    public static void setPrice(double price) {
        SupplyView.price = price;
    }


}

