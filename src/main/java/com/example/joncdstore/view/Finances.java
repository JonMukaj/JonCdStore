package com.example.joncdstore.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class Finances {

    protected final AnchorPane anchorPane;
    protected final Label turnoverLabel;
    protected final Text turnoverText;
    protected final Label costLabel;
    protected final Text costText;
    protected final Button profitBt;
    protected final Label salaryLabel;
    protected final Text salaryText;
    protected final Separator separator;
    protected final Separator separator0;
    protected final Separator separator1;

    public Finances() {

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

        turnoverLabel.setLayoutX(116.0);
        turnoverLabel.setLayoutY(56.0);
        turnoverLabel.setStyle("-fx-font-size: 28;");
        turnoverLabel.setText("Turnover:");

        turnoverText.setLayoutX(327.0);
        turnoverText.setLayoutY(87.0);
        turnoverText.setStyle("-fx-font-size: 28;");
        turnoverText.setText("2000");
        turnoverText.setWrappingWidth(200.0);

        costLabel.setLayoutX(84.0);
        costLabel.setLayoutY(125.0);
        costLabel.setStyle("-fx-font-size: 28;");
        costLabel.setText("Cost Of Sales:");

        costText.setLayoutX(327.0);
        costText.setLayoutY(156.0);
        costText.setStyle("-fx-font-size: 28;");
        costText.setText("2000");
        costText.setWrappingWidth(200.0);

        profitBt.setLayoutX(208.0);
        profitBt.setLayoutY(262.0);
        profitBt.setOnAction(null);
        profitBt.setPrefHeight(56.0);
        profitBt.setPrefWidth(108.0);
        profitBt.setText("ANALYZE");

        salaryLabel.setLayoutX(119.0);
        salaryLabel.setLayoutY(194.0);
        salaryLabel.setStyle("-fx-font-size: 28;");
        salaryLabel.setText("Salaries:");

        salaryText.setLayoutX(327.0);
        salaryText.setLayoutY(226.0);
        salaryText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        salaryText.setStrokeWidth(0.0);
        salaryText.setStyle("-fx-font-size: 28;");
        salaryText.setText("2000");
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

    }


}
