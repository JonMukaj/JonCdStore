package com.example.joncdstore.view;

import com.example.joncdstore.controller.BillController;
import com.example.joncdstore.controller.FinancesController;
import com.example.joncdstore.model.Statistics;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Finances {

    private final AnchorPane anchorPane;
    private final Label turnoverLabel;
    private final Text turnoverText;
    private final Label costLabel;
    private final Text costText;
    private final Button profitBt;
    private final Label salaryLabel;
    private final Text salaryText;
    private final Separator separator;
    private final Separator separator0;
    private final Separator separator1;
    private final Text profitText;
    private final Text profitLabel;
    private final Button returnBt;

    public Finances(Stage stage, Scene oldscene) {

        Statistics.popStatistics();

        returnBt = new Button();
        profitLabel = new Text();
        profitText = new Text();
        anchorPane = new AnchorPane();
        turnoverLabel = new Label();
        turnoverText = new Text();
        costLabel = new Label();
        costText = new Text();
        profitBt = new Button();
        salaryLabel = new Label();
        salaryText = new Text();
        separator = new Separator();
        separator0 = new Separator();
        separator1 = new Separator();

        anchorPane.getStylesheets().add(this.getClass().getResource("/Menu.css").toExternalForm());

        turnoverLabel.setLayoutX(116.0);
        turnoverLabel.setLayoutY(56.0);
        turnoverLabel.setStyle("-fx-font-size: 28;");
        turnoverLabel.setText("Turnover:");

        turnoverText.setLayoutX(327.0);
        turnoverText.setLayoutY(87.0);
        turnoverText.setStyle("-fx-font-size: 28;");
        turnoverText.setText(String.valueOf(Statistics.getRevenue()));
        turnoverText.setWrappingWidth(200.0);

        costLabel.setLayoutX(84.0);
        costLabel.setLayoutY(125.0);
        costLabel.setStyle("-fx-font-size: 28;");
        costLabel.setText("Cost Of Sales:");

        costText.setLayoutX(327.0);
        costText.setLayoutY(156.0);
        costText.setStyle("-fx-font-size: 28;");
        costText.setText(String.valueOf(Statistics.getCost()));
        costText.setWrappingWidth(200.0);

        profitBt.setLayoutX(210.0);
        profitBt.setLayoutY(262.0);
        profitBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                double profit = FinancesController.showMessage(FinancesController.getTotalSalary());

                profitBt.setVisible(false);
                if (profit >=0) {
                    profitText.setText(String.format("%.2f",profit));
                    profitText.setStyle("-fx-fill: green;-fx-font-size: 28;");
                    profitLabel.setText("Profit:");
                    profitLabel.setStyle("-fx-fill: green;-fx-font-size: 28;");
                }
                else {
                    profitText.setStyle("-fx-fill: red;-fx-font-size: 28;");
                    profitText.setText(String.format("%.2f",Math.abs(profit)));
                    profitLabel.setStyle("-fx-fill: red;-fx-font-size: 28;");
                    profitLabel.setText("Loss:");

                }

            }
        });
        profitBt.setPrefHeight(50.0);
        profitBt.setPrefWidth(108.0);
        profitBt.setText("ANALYZE");
        profitBt.getStyleClass().add("edit");

        returnBt.setLayoutX(14.0);
        returnBt.setLayoutY(15.0);
        returnBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FinancesController.returnMenu(stage,oldscene);
            }
        });
        returnBt.setPrefHeight(25.0);
        returnBt.setPrefWidth(66.0);
        returnBt.getStyleClass().add("remove");
        returnBt.setText("Return");

        profitText.setLayoutX(325.0);
        profitText.setLayoutY(290.0);
        profitText.setWrappingWidth(150);

        profitLabel.setLayoutX(145.0);
        profitLabel.setLayoutY(290.0);



        salaryLabel.setLayoutX(119.0);
        salaryLabel.setLayoutY(194.0);
        salaryLabel.setStyle("-fx-font-size: 28;");
        salaryLabel.setText("Salaries:");

        salaryText.setLayoutX(327.0);
        salaryText.setLayoutY(226.0);
        salaryText.setStyle("-fx-font-size: 28;");
        salaryText.setText(String.valueOf(FinancesController.getTotalSalary()));
        salaryText.setWrappingWidth(200.0);

        separator.setLayoutX(9.0);
        separator.setLayoutY(109.0);
        separator.setPrefHeight(3.0);
        separator.setPrefWidth(538.0);

        separator0.setLayoutX(6.0);
        separator0.setLayoutY(175.0);
        separator0.setPrefHeight(3.0);
        separator0.setPrefWidth(538.0);

        separator1.setLayoutX(11.0);
        separator1.setLayoutY(248.0);
        separator1.setPrefHeight(3.0);
        separator1.setPrefWidth(531.0);

        anchorPane.setPrefHeight(367.0);
        anchorPane.setPrefWidth(551.0);

        anchorPane.getChildren().add(turnoverLabel);
        anchorPane.getChildren().add(turnoverText);
        anchorPane.getChildren().add(costLabel);
        anchorPane.getChildren().add(costText);
        anchorPane.getChildren().add(profitBt);
        anchorPane.getChildren().add(salaryLabel);
        anchorPane.getChildren().add(salaryText);
        anchorPane.getChildren().add(separator);
        anchorPane.getChildren().add(separator0);
        anchorPane.getChildren().add(separator1);
        anchorPane.getChildren().add(profitText);
        anchorPane.getChildren().add(profitLabel);
        anchorPane.getChildren().add(returnBt);

    }

    public Scene generateFinanceScene () {
        return new Scene(anchorPane, 520, 340);
    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }
}
