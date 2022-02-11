package com.example.joncdstore.view;

import com.example.joncdstore.controller.BillController;
import com.example.joncdstore.controller.PerformanceController;
import com.example.joncdstore.controller.StatisticsController;
import com.example.joncdstore.model.Statistics;
import com.example.joncdstore.model.User;
import com.example.joncdstore.model.UserManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class graphs {

    private final AnchorPane anchorPane;
    private final TabPane tabPane;
    private final Tab salaryTab;
    private final AnchorPane anchor1;
    private final PieChart salaryChart;
    private final Tab operationTab;
    private final AnchorPane anchor2;
    private final CategoryAxis categoryAxis;
    private final NumberAxis numberAxis;
    private final BarChart<String,Number> operationsChart;
    private final Button returnBt;

    public graphs(User u, Stage stage, Scene oldScene) {
        Statistics.popStatistics();

        anchorPane = new AnchorPane();
        tabPane = new TabPane();
        salaryTab = new Tab();
        anchor1 = new AnchorPane();
        salaryChart = new PieChart();
        operationTab = new Tab();
        anchor2 = new AnchorPane();
        categoryAxis = new CategoryAxis();
        numberAxis = new NumberAxis();
        operationsChart = new BarChart<String,Number>(categoryAxis, numberAxis);
        returnBt = new Button();

        anchorPane.getStylesheets().add(this.getClass().getResource("/Menu.css").toExternalForm());

        tabPane.setPrefHeight(400.0);
        tabPane.setPrefWidth(600.0);
        tabPane.setTabClosingPolicy(javafx.scene.control.TabPane.TabClosingPolicy.UNAVAILABLE);

        salaryTab.setText("Salary");

        anchor1.setMinHeight(0.0);
        anchor1.setMinWidth(0.0);
        anchor1.setPrefHeight(180.0);
        anchor1.setPrefWidth(200.0);

        salaryChart.setLayoutX(38.0);
        salaryChart.setLayoutY(20.0);
        salaryChart.setPrefHeight(317.0);
        salaryChart.setPrefWidth(505.0);
        salaryTab.setContent(anchor1);

        ObservableList<PieChart.Data> dataSalary = FXCollections.observableArrayList(new PieChart.Data("Admin", StatisticsController.getSalaryByPrivilege(1)),
                new PieChart.Data("Manager",StatisticsController.getSalaryByPrivilege(2)),new PieChart.Data("Cashier", StatisticsController.getSalaryByPrivilege(3)));


        salaryChart.setData(dataSalary);

        salaryChart.getData().forEach(data -> {
            Tooltip tooltip = new Tooltip(String.format("%.2f%%",data.getPieValue() / StatisticsController.getTotalSalary() * 100));
            Tooltip.install(data.getNode(),tooltip);
        });


        operationTab.setText("Operations");

        anchor2.setMinHeight(0.0);
        anchor2.setMinWidth(0.0);
        anchor2.setPrefHeight(180.0);
        anchor2.setPrefWidth(200.0);

        categoryAxis.setSide(Side.BOTTOM);
        numberAxis.setSide(Side.LEFT);

        operationsChart.setLayoutX(104.0);
        operationsChart.setLayoutY(39.0);
        operationsChart.setPrefHeight(294.0);
        operationsChart.setPrefWidth(363.0);


        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Bills");
        series1.getData().add(new XYChart.Data<>("Bought", Statistics.getTotalNrOfBillBought()));
        series1.getData().add(new XYChart.Data<>("Sold", Statistics.getTotalNrOfBillSold()));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("CDs");
        series2.getData().add(new XYChart.Data<>("Bought",Statistics.getTotalNrOfCdBought()));
        series2.getData().add((new XYChart.Data<>("Sold", Statistics.getTotalNrOfCdSold())));

        operationsChart.getData().add(series1);
        operationsChart.getData().add(series2);
        operationTab.setContent(anchor2);

        returnBt.setLayoutX(20.0);
        returnBt.setLayoutY(370.0);
        returnBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                StatisticsController.returnStatistics(u,stage,oldScene);
            }
        });
        returnBt.setPrefHeight(25.0);
        returnBt.setPrefWidth(66.0);
        returnBt.getStyleClass().add("edit");
        returnBt.setText("Return");

        anchor1.getChildren().add(salaryChart);
        tabPane.getTabs().add(salaryTab);
        anchor2.getChildren().add(operationsChart);
        tabPane.getTabs().add(operationTab);

        anchorPane.setPrefHeight(400.0);
        anchorPane.setPrefWidth(600.0);
        anchorPane.getChildren().add(tabPane);
        anchorPane.getChildren().add(returnBt);
    }

    public Scene generateGraphsScene () {
        return new Scene(anchorPane, 600, 400);
    }
}
