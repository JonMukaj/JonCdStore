package com.example.joncdstore.view;

import com.example.joncdstore.controller.BillController;
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

    public Catalogue(User u, Stage stage, ActionEvent e,Scene oldScene) {

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
        buyBt.setOnAction(null);//this::createBuyPane
        buyBt.setPrefHeight(25.0);
        buyBt.setPrefWidth(66.0);
        buyBt.getStyleClass().add("add");
        buyBt.setText("Buy");


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

        if (u.getUsername().equals("admin")){
            buyBt.setVisible(false);
            sellBt.setVisible(false);
        }

        String text = ((Button)e.getSource()).getText();
        if (text.equals("CATALOGUE")) {
            buyBt.setVisible(false);
        }
        else {
            sellBt.setVisible(false);
        }

        scrollPane.setContent(cdTable);

        titleC.setCellValueFactory(new PropertyValueFactory<>("titleOfCd"));
        genreC.setCellValueFactory(new PropertyValueFactory<>("genre"));
        authorC.setCellValueFactory(new PropertyValueFactory<>("author"));

        String t = ((Button)e.getSource()).getText();
        if (t.equals("CATALOGUE")) {
            priceC.setCellValueFactory(new PropertyValueFactory<>("sellingPrice"));
        }
        else priceC.setCellValueFactory(new PropertyValueFactory<>("purchasedPrice"));

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

    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    public Scene generateCatalogueScene (ActionEvent e) {
        String text = ((Button)e.getSource()).getText();
        String type;
        if (text.equals("CATALOGUE")) {
            type = "Sell";
        }
        else {
            type = "Purchase";
        }

        BillController.updateTable(cdTable,type);
        return new Scene(anchorPane, 793, 573);
    }

}
