package com.example.joncdstore.view;

import com.example.joncdstore.controller.BillController;
import com.example.joncdstore.model.CD;
import com.example.joncdstore.model.CdManager;
import com.example.joncdstore.model.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BillView  {

    private final AnchorPane anchorPane;
    private final ScrollPane scrollPane;
    private final TableView<CD> cdBillTable;
    private final TableColumn<CD,String > titleC;
    private final TableColumn<CD,String > genreC;
    private final TableColumn<CD,String > authorC;
    private final TableColumn<CD,Double > priceC;
    private final TableColumn<CD,Integer > quantityC;
    private final Button returnBt;
    private final TextField searchField;
    private final Button searchBt;
    private final Button addBt;
    private final Button removeBt;
    private final Button createBillBt;
    private final Text errText;
    private final Label priceLabel;
    private final Text priceText;
    private final Spinner<Integer> spinner;
    private final Label quantityLabel;

    private static double price;



    public BillView(User u, Stage stage,Scene oldScene) {


        anchorPane = new AnchorPane();
        scrollPane = new ScrollPane();
        cdBillTable = new TableView();
        titleC = new TableColumn();
        genreC = new TableColumn();
        authorC = new TableColumn();
        priceC = new TableColumn();
        quantityC = new TableColumn();
        returnBt = new Button();
        searchField = new TextField();
        searchBt = new Button();
        addBt = new Button();
        removeBt = new Button();
        createBillBt = new Button();
        errText = new Text();
        priceLabel = new Label();
        priceText = new Text();
        spinner = new Spinner<>();
        quantityLabel = new Label();


        anchorPane.getStylesheets().add(this.getClass().getResource("/Menu.css").toExternalForm());

        spinner.setVisible(false);

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
                BillController.getTmpCDlist().clear();
                BillController.returnBill(u,stage,oldScene);
                price = 0;
            }
        });
        returnBt.setPrefHeight(25.0);
        returnBt.setPrefWidth(66.0);
        returnBt.getStyleClass().add("edit");
        returnBt.setText("Return");



        searchBt.setLayoutX(641.0);
        searchBt.setLayoutY(15.0);

        searchBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                CdManager cdManager = new CdManager("Sell");
                cdManager.readCD();

                int idx = cdManager.checkCD(searchField.getText());
                if (idx != -1) {
                    if(cdManager.searchCD(idx)) {
                        quantityLabel.setVisible(true);
                        spinner.setEditable(true);
                        spinner.setVisible(true);
                        spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,cdManager.getCdList().get(idx).getTotalQuantity(),1,1));
                        errText.setText("Found!");
                        errText.setVisible(true);
                        if (cdManager.getCdList().get(idx) != null) {
                            addBt.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    CD c = cdManager.getCdList().get(idx);

                                    c.setTotalQuantity(c.getTotalQuantity() - spinner.getValue());

                                    c.setTmpQuantity(spinner.getValue());

                                    BillController.addToTable(cdBillTable,c);

                                    price  += c.getSellingPrice() * c.getTmpQuantity();

                                    priceText.setText(String.valueOf(price));

                                }
                            });

                        }
                        else {
                            addBt.setOnAction(null);
                        }

                        removeBt.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                BillController.removeFromTable(cdBillTable,priceText);
                            }
                        });

                    }
                    else {
                        errText.setText("Out of Stock!");
                        errText.setVisible(true);
                    }
                }
                else {
                    errText.setText("Not Found!");
                    errText.setVisible(true);
                }
            }
        });






        searchBt.setPrefHeight(25.0);
        searchBt.setPrefWidth(66.0);
        searchBt.getStyleClass().add("edit");
        searchBt.setText("Search");

        searchField.setLayoutX(484.0);
        searchField.setLayoutY(15.0);
        searchField.setOnKeyPressed(null);//this::searchCD

        addBt.setLayoutX(195.0);
        addBt.setLayoutY(534.0);
        addBt.setPrefHeight(25.0);
        addBt.setPrefWidth(66.0);
        addBt.getStyleClass().add("add");
        addBt.setText("Add");

        removeBt.setLayoutX(279.0);
        removeBt.setLayoutY(534.0);
        removeBt.setPrefHeight(25.0);
        removeBt.setPrefWidth(66.0);
        removeBt.getStyleClass().add("remove");
        removeBt.setText("Remove");

        createBillBt.setLayoutX(639.0);
        createBillBt.setLayoutY(529.0);
        createBillBt.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            System.out.println("LOL");
            BillController.generateBillSell();
        }
        });

        createBillBt.setPrefHeight(35.0);
        createBillBt.setPrefWidth(114.0);
        createBillBt.getStyleClass().add("edit");
        createBillBt.setText("Create Bill");

        errText.setLayoutX(714.0);
        errText.setLayoutY(32.0);
        errText.setStyle("-fx-fill: red;");
        errText.setVisible(false);


        priceLabel.setLayoutX(458.0);
        priceLabel.setLayoutY(528.0);
        priceLabel.setPrefHeight(36.0);
        priceLabel.setPrefWidth(66.0);
        priceLabel.setStyle("-fx-font-size: 20;");
        priceLabel.setText("Price:");

        priceText.setLayoutX(526.0);
        priceText.setLayoutY(555.0);
        priceText.setStyle("-fx-font-size: 20;");
        priceText.setText("0.0");
        priceText.setWrappingWidth(200);

        spinner.setLayoutX(111.0);
        spinner.setLayoutY(534.0);
        spinner.setPrefHeight(25.0);
        spinner.setPrefWidth(66.0);

        quantityLabel.setLayoutX(20.0);
        quantityLabel.setLayoutY(528.0);
        quantityLabel.setPrefHeight(36.0);
        quantityLabel.setPrefWidth(91.0);
        quantityLabel.setStyle("-fx-font-size: 20;");
        quantityLabel.setText("Quantity:");
        quantityLabel.setVisible(false);

        scrollPane.setContent(cdBillTable);

        cdBillTable.getColumns().add(titleC);
        cdBillTable.getColumns().add(genreC);
        cdBillTable.getColumns().add(authorC);
        cdBillTable.getColumns().add(priceC);
        cdBillTable.getColumns().add(quantityC);

        titleC.setCellValueFactory(new PropertyValueFactory<>("titleOfCd"));
        genreC.setCellValueFactory(new PropertyValueFactory<>("genre"));
        authorC.setCellValueFactory(new PropertyValueFactory<>("author"));
        priceC.setCellValueFactory(new PropertyValueFactory<>("sellingPrice"));
        quantityC.setCellValueFactory(new PropertyValueFactory<>("tmpQuantity"));

        anchorPane.setPrefHeight(573.0);
        anchorPane.setPrefWidth(793.0);

        anchorPane.getChildren().add(scrollPane);
        anchorPane.getChildren().add(returnBt);
        anchorPane.getChildren().add(searchBt);
        anchorPane.getChildren().add(searchField);
        anchorPane.getChildren().add(addBt);
        anchorPane.getChildren().add(removeBt);
        anchorPane.getChildren().add(createBillBt);
        anchorPane.getChildren().add(errText);
        anchorPane.getChildren().add(priceLabel);
        anchorPane.getChildren().add(priceText);
        anchorPane.getChildren().add(quantityLabel);
        anchorPane.getChildren().add(spinner);

    }

    public Scene generateBillViewScene () {
        //EmployeeController.updateTable(employTable);
        return new Scene(anchorPane, 793, 573);
    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    public static double getPrice() {
        return price;
    }

    public static void setPrice(double price) {
        BillView.price = price;
    }


}
