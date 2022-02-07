package com.example.joncdstore.view;

import com.example.joncdstore.controller.BillController;
import com.example.joncdstore.model.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BillMenu{

    private final AnchorPane anchorPane;
    private final Button sellBt;
    private final Button catalogueBt;

    public BillMenu(User u, Stage stage) {


        anchorPane = new AnchorPane();
        sellBt = new Button();
        catalogueBt = new Button();

        anchorPane.getStylesheets().add(this.getClass().getResource("/Menu.css").toExternalForm());

        anchorPane.setPrefHeight(575.0);
        anchorPane.setPrefWidth(730.0);

        sellBt.setLayoutX(221.0);
        sellBt.setLayoutY(161.0);
        sellBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                BillController.createBillViewScene(u,stage);
            }
        });
        sellBt.setPrefHeight(84.0);
        sellBt.setPrefWidth(289.0);
        sellBt.setStyle("-fx-font-size: 40;");
        sellBt.setText("SELL");


        catalogueBt.setLayoutX(221.0);
        catalogueBt.setLayoutY(326.0);
        catalogueBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                BillController.createCatalogueScene(u,stage,event);
            }
        });
        catalogueBt.setPrefHeight(84.0);
        catalogueBt.setPrefWidth(289.0);
        catalogueBt.setStyle("-fx-font-size: 40;");
        catalogueBt.setText("CATALOGUE");


        if (u.getPrivilege() == 3){
            anchorPane.setStyle("-fx-background-color: #A7EF9F;");
            sellBt.getStyleClass().add("buttonCashier");
            catalogueBt.getStyleClass().add("buttonCashier");
            sellBt.setTextFill(Color.GREEN);
            catalogueBt.setTextFill(Color.GREEN);
        }
        else {
            anchorPane.setStyle("-fx-background-color: #DB8C89;");
            catalogueBt.getStyleClass().add("buttonAdmin");
            catalogueBt.setTextFill(Color.valueOf("#5C0000"));
            sellBt.setDisable(true);
            sellBt.getStyleClass().add("buttonAdmin");
        }
        anchorPane.setLayoutX(233);
        anchorPane.setLayoutY(110);
        anchorPane.getChildren().add(sellBt);
        anchorPane.getChildren().add(catalogueBt);

    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

}
