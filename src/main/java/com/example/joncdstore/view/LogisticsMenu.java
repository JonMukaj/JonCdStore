package com.example.joncdstore.view;

import com.example.joncdstore.controller.BillController;
import com.example.joncdstore.controller.LogisticsController;
import com.example.joncdstore.model.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LogisticsMenu{

    private final AnchorPane anchorPane;
    private final Button buyBt;
    private final Button supplyBt;


    public LogisticsMenu(User u, Stage stage) {

        anchorPane = new AnchorPane();
        buyBt = new Button();
        supplyBt = new Button();

        anchorPane.getStylesheets().add(this.getClass().getResource("/Menu.css").toExternalForm());

        anchorPane.setPrefHeight(575.0);
        anchorPane.setPrefWidth(730.0);

        buyBt.setLayoutX(221.0);
        buyBt.setLayoutY(161.0);
        buyBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LogisticsController.createSupplyViewScene(u,stage);
            }
        });
        buyBt.setPrefHeight(84.0);
        buyBt.setPrefWidth(289.0);
        buyBt.setStyle("-fx-font-size: 40;");
        buyBt.setText("BUY");


        supplyBt.setLayoutX(221.0);
        supplyBt.setLayoutY(326.0);
        supplyBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                BillController.createCatalogueScene(u,stage,event);
            }
        });
        supplyBt.setPrefHeight(84.0);
        supplyBt.setPrefWidth(289.0);
        supplyBt.setStyle("-fx-font-size: 40;");
        supplyBt.setText("SUPPLY");


        if (u.getPrivilege() == 2){
            anchorPane.setStyle("-fx-background-color: #85C9F0;");
            buyBt.getStyleClass().add("buttonManager");
            supplyBt.getStyleClass().add("buttonManager");
            buyBt.setTextFill(Color.BLUE);
            supplyBt.setTextFill(Color.BLUE);
        }
        else {
            anchorPane.setStyle("-fx-background-color: #DB8C89;");
            supplyBt.getStyleClass().add("buttonAdmin");
            supplyBt.setTextFill(Color.valueOf("#5C0000"));
            buyBt.setDisable(true);
            buyBt.getStyleClass().add("buttonAdmin");
        }
        anchorPane.setLayoutX(233);
        anchorPane.setLayoutY(110);
        anchorPane.getChildren().add(buyBt);
        anchorPane.getChildren().add(supplyBt);

    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

}
