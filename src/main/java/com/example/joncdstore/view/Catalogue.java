package com.example.joncdstore.view;

import com.example.joncdstore.controller.BillController;
import com.example.joncdstore.controller.LogisticsController;
import com.example.joncdstore.model.CD;
import com.example.joncdstore.model.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Catalogue {

    private final AnchorPane anchorPane;
    private final ScrollPane scrollPane;
    private final TableView<CD> cdTable;
    private final TableColumn<CD,String > titleC;
    private final TableColumn<CD,String > genreC;
    private final TableColumn<CD,String > authorC;
    private final TableColumn<CD,Double > priceC;
    private final TableColumn<CD,Integer > quantityC;
    private final Button returnBt;
    private final Button buyBt;
    private final Button sellBt;
    private final Button refreshBt;

    public Catalogue(User u, Stage stage, String s,Scene oldScene) {

        anchorPane = new AnchorPane();
        scrollPane = new ScrollPane();
        cdTable = new TableView();
        titleC = new TableColumn();
        genreC = new TableColumn();
        authorC = new TableColumn();
        priceC = new TableColumn();
        quantityC = new TableColumn();
        returnBt = new Button();
        buyBt = new Button();
        sellBt = new Button();
        refreshBt = new Button();

        anchorPane.getStylesheets().add(this.getClass().getResource("/Menu.css").toExternalForm());

        scrollPane.setLayoutY(51.0);
        scrollPane.setPrefHeight(522.0);
        scrollPane.setPrefWidth(793.0);

        cdTable.setPrefHeight(523.0);
        cdTable.setPrefWidth(778.0);

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
                BillController.returnBill(u,stage,oldScene);
            }
        });
        returnBt.setPrefHeight(25.0);
        returnBt.setPrefWidth(66.0);
        returnBt.getStyleClass().add("remove");
        returnBt.setText("Return");

        buyBt.setLayoutX(101.0);
        buyBt.setLayoutY(15.0);
        buyBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LogisticsController.createSupplyViewScene(u,stage);
            }
        });
        buyBt.setPrefHeight(25.0);
        buyBt.setPrefWidth(66.0);
        buyBt.getStyleClass().add("add");
        buyBt.setText("Buy");

        refreshBt.setLayoutX(692.0);
        refreshBt.setLayoutY(15.0);
        refreshBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    generateCatalogueScene(s);
                }
                catch (IllegalArgumentException e) {

                }
            }
        });
        refreshBt.setPrefHeight(25.0);
        refreshBt.setPrefWidth(66.0);
        refreshBt.getStyleClass().add("edit");
        refreshBt.setText("Refresh");


        sellBt.setLayoutX(101.0);
        sellBt.setLayoutY(15.0);
        sellBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                BillController.createBillViewScene(u,stage);
            }
        });
        sellBt.setPrefHeight(25.0);
        sellBt.setPrefWidth(66.0);
        sellBt.getStyleClass().add("add");
        sellBt.setText("Sell");

        if (u.getPrivilege() == 1 || u.getPrivilege() == 0){
            buyBt.setVisible(false);
            sellBt.setVisible(false);
            refreshBt.setVisible(false);
        }

        if (s.equals("sellingPrice")) {
            buyBt.setVisible(false);
        }
        else {
            sellBt.setVisible(false);
        }

        scrollPane.setContent(cdTable);

        titleC.setCellValueFactory(new PropertyValueFactory<>("titleOfCd"));
        genreC.setCellValueFactory(new PropertyValueFactory<>("genre"));
        authorC.setCellValueFactory(new PropertyValueFactory<>("author"));


        priceC.setCellValueFactory(new PropertyValueFactory<>(s));

        quantityC.setCellValueFactory(new PropertyValueFactory<>("totalQuantity"));

        cdTable.getColumns().add(titleC);
        cdTable.getColumns().add(genreC);
        cdTable.getColumns().add(authorC);
        cdTable.getColumns().add(priceC);
        cdTable.getColumns().add(quantityC);

        anchorPane.setPrefHeight(573.0);
        anchorPane.setPrefWidth(793.0);
        anchorPane.getChildren().add(scrollPane);
        anchorPane.getChildren().add(returnBt);
        anchorPane.getChildren().add(buyBt);
        anchorPane.getChildren().add(sellBt);
        anchorPane.getChildren().add(refreshBt);

    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    public Scene generateCatalogueScene (String s){

            String type;
            if (s.equals("sellingPrice")) {
                type = "Sell";
            }
            else {
                type = "Purchase";
            }

            BillController.updateTable(cdTable,type);
            return new Scene(anchorPane, 793, 573);

    }

}
