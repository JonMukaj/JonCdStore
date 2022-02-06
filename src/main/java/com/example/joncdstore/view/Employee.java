package com.example.joncdstore.view;

import com.example.joncdstore.controller.EmployeeController;
import com.example.joncdstore.model.User;
import javafx.collections.ObservableList;
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

public class Employee {

    private final AnchorPane anchorPane;
    private final ScrollPane scrollPane;
    private final TableView<User> employTable;
    private final TableColumn<User,String> userNameC;
    private final TableColumn<User,String> nameC;
    private final TableColumn<User,String> surnameC;
    private final TableColumn<User,String> birthdayC;
    private final TableColumn<User,String> genderC;
    private final TableColumn<User,String> phoneC;
    private final TableColumn<User,String> emailC;
    private final TableColumn<User,Double> salaryC;
    private final TableColumn<User,String> employDateC;
    private final TableColumn<User,String> privilegeC;
    private final Button addBt;
    private final Button removeBt;
    private final Button modifyBt;
    private final Button returnBt;

    public Employee(User u,Stage stage) {

        anchorPane = new AnchorPane();
        scrollPane = new ScrollPane();
        employTable = new TableView<>();
        userNameC = new TableColumn<>();
        nameC = new TableColumn<>();
        surnameC = new TableColumn<>();
        birthdayC = new TableColumn<>();
        genderC = new TableColumn<>();
        phoneC = new TableColumn<>();
        emailC = new TableColumn<>();
        salaryC = new TableColumn<>();
        employDateC = new TableColumn<>();
        privilegeC = new TableColumn<>();
        addBt = new Button();
        removeBt = new Button();
        modifyBt = new Button();
        returnBt = new Button();

        anchorPane.getStylesheets().add(this.getClass().getResource("/Menu.css").toExternalForm());

        scrollPane.setLayoutY(51.0);
        scrollPane.setPrefHeight(522.0);
        scrollPane.setPrefWidth(793.0);

        employTable.setPrefHeight(523.0);
        employTable.setPrefWidth(778.0);
        employTable.setEditable(true);

        userNameC.setPrefWidth(65.0);
        userNameC.setText("Username");

        nameC.setPrefWidth(69.0);
        nameC.setStyle("ba: #EB99A0;");
        nameC.setText("Name");

        surnameC.setPrefWidth(81.0);
        surnameC.setStyle("ba: #EB99A0;");
        surnameC.setText("Surname");

        birthdayC.setPrefWidth(79.0);
        birthdayC.setStyle("ba: #EB99A0;");
        birthdayC.setText("Birthday");

        genderC.setPrefWidth(53.0);
        genderC.setStyle("ba: #EB99A0;");
        genderC.setText("Gender");

        phoneC.setPrefWidth(77.0);
        phoneC.setStyle("ba: #EB99A0;");
        phoneC.setText("Phone");

        emailC.setPrefWidth(143.0);
        emailC.setStyle("ba: #EB99A0;");
        emailC.setText("Email Address");

        salaryC.setPrefWidth(48.0);
        salaryC.setStyle("ba: #EB99A0;");
        salaryC.setText("Salary");

        employDateC.setPrefWidth(85.0);
        employDateC.setStyle("ba: #EB99A0;");
        employDateC.setText("RegDate");

        privilegeC.setPrefWidth(77.0);
        privilegeC.setText("Role");
        scrollPane.setContent(employTable);

        addBt.setLayoutX(543.0);
        addBt.setLayoutY(15.0);
        addBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                EmployeeController.addUser(stage,u);
            }
        });
        addBt.setPrefHeight(25.0);
        addBt.setPrefWidth(66.0);
        addBt.setText("Add");
        addBt.getStyleClass().add("add");

        removeBt.setLayoutX(623.0);
        removeBt.setLayoutY(15.0);
        removeBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (employTable.getSelectionModel().getSelectedItem() != null) {
                    User removedUser = employTable.getSelectionModel().getSelectedItem();
                    //System.out.println(removedUser.toString());
                    EmployeeController.removeUser(stage,u,removedUser);
                }
            }
        });
        removeBt.setPrefHeight(25.0);
        removeBt.setPrefWidth(66.0);
        removeBt.setText("Remove");
        removeBt.getStyleClass().add("remove");

        modifyBt.setLayoutX(697.0);
        modifyBt.setLayoutY(15.0);
        modifyBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (employTable.getSelectionModel().getSelectedItem() != null) {
                    User modifiedUser = employTable.getSelectionModel().getSelectedItem();
                    //System.out.println(modifiedUser.toString());
                    EmployeeController.modifyUser(stage,u,modifiedUser);
                }
            }
        });
        modifyBt.setPrefHeight(25.0);
        modifyBt.setPrefWidth(66.0);
        modifyBt.getStyleClass().add("modify");
        modifyBt.setText("Modify");

        returnBt.setLayoutX(29.0);
        returnBt.setLayoutY(15.0);
        returnBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                EmployeeController.returnMain(u,stage);
            }
        });

        returnBt.setPrefHeight(25.0);
        returnBt.setPrefWidth(66.0);
        returnBt.setStyle("-fx-font-size: 12;");
        returnBt.getStyleClass().add("edit");
        returnBt.setText("Return");


        userNameC.setCellValueFactory(new PropertyValueFactory<>("username"));
        nameC.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnameC.setCellValueFactory(new PropertyValueFactory<>("surname"));
        birthdayC.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        genderC.setCellValueFactory(new PropertyValueFactory<>("gender"));
        phoneC.setCellValueFactory(new PropertyValueFactory<>("phone"));
        emailC.setCellValueFactory(new PropertyValueFactory<>("email"));
        salaryC.setCellValueFactory(new PropertyValueFactory<>("salary"));
        employDateC.setCellValueFactory(new PropertyValueFactory<>("employmentDate"));
        privilegeC.setCellValueFactory(new PropertyValueFactory<>("profession"));


        employTable.getColumns().add(userNameC);
        employTable.getColumns().add(nameC);
        employTable.getColumns().add(surnameC);
        employTable.getColumns().add(birthdayC);
        employTable.getColumns().add(genderC);
        employTable.getColumns().add(phoneC);
        employTable.getColumns().add(emailC);
        employTable.getColumns().add(salaryC);
        employTable.getColumns().add(employDateC);
        employTable.getColumns().add(privilegeC);


        anchorPane.setPrefHeight(573.0);
        anchorPane. setPrefWidth(793.0);

        anchorPane.getChildren().add(scrollPane);
        anchorPane.getChildren().add(addBt);
        anchorPane.getChildren().add(removeBt);
        anchorPane.getChildren().add(modifyBt);
        anchorPane.getChildren().add(returnBt);

    }

    public Scene generateEmployeeScene () {
        EmployeeController.updateTable(employTable);
        return new Scene(anchorPane, 793, 573);
    }


    /*protected abstract void addEmployee(javafx.event.ActionEvent actionEvent);

    protected abstract void removeEmployee(javafx.event.ActionEvent actionEvent);*/

}
