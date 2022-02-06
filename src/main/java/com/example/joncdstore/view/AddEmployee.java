package com.example.joncdstore.view;

import com.example.joncdstore.controller.EmployeeController;
import com.example.joncdstore.model.GENDER;
import com.example.joncdstore.model.User;
import com.example.joncdstore.model.ValidatePassword;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class AddEmployee implements ValidatePassword {

    private final AnchorPane anchorPane;
    private final Label usernameLabel;
    private final PasswordField passwordPrompt;
    private final TextField usernamePrompt;
    private final Label passwordLabel;
    private final Label nameLabel;
    private final TextField namePrompt;
    private final Label surnameLabel;
    private final TextField surnamePrompt;
    private final Label genderLabel;
    private final SplitMenuButton genderPrompt;
    private final MenuItem maleItem;
    private final MenuItem femaleItem;
    private final MenuItem otherItem;
    private final Label birthdayLabel;
    private final DatePicker datePrompt;
    private final Label phoneLabel;
    private final TextField phonePrompt;
    private final Label emailLabel;
    private final TextField emailPrompt;
    private final Label privilegeLabel;
    private final SplitMenuButton privilegePrompt;
    private final MenuItem adminItem;
    private final MenuItem managerItem;
    private final MenuItem cashierItem;
    private final Label salaryLabel;
    private final TextField salaryPrompt;
    private final Button confirmBt;
    private final Button cancelBt;
    private final Text userNameErr;
    private final Text passwordErr;
    private final Text nameErr;
    private final Text surnameErr;
    private final Text birthdayErr;
    private final Text phoneErr;
    private final Text emailErr;
    private final Text privilegeErr;
    private final Text genderErr;
    private final Text salaryErr;

    public AddEmployee(Stage stage, User u, Stage window) {

        User newUser = new User();
        anchorPane = new AnchorPane();
        usernameLabel = new Label();
        passwordPrompt = new PasswordField();
        usernamePrompt = new TextField();
        passwordLabel = new Label();
        nameLabel = new Label();
        namePrompt = new TextField();
        surnameLabel = new Label();
        surnamePrompt = new TextField();
        genderLabel = new Label();
        genderPrompt = new SplitMenuButton();
        maleItem = new MenuItem();
        femaleItem = new MenuItem();
        otherItem = new MenuItem();
        birthdayLabel = new Label();
        datePrompt = new DatePicker();
        phoneLabel = new Label();
        phonePrompt = new TextField();
        emailLabel = new Label();
        emailPrompt = new TextField();
        privilegeLabel = new Label();
        privilegePrompt = new SplitMenuButton();
        adminItem = new MenuItem();
        managerItem = new MenuItem();
        cashierItem = new MenuItem();
        salaryLabel = new Label();
        salaryPrompt = new TextField();
        confirmBt = new Button();
        cancelBt = new Button();
        userNameErr = new Text();
        passwordErr = new Text();
        nameErr = new Text();
        surnameErr = new Text();
        birthdayErr = new Text();
        phoneErr = new Text();
        emailErr = new Text();
        privilegeErr = new Text();
        genderErr = new Text();
        salaryErr = new Text();


        anchorPane.getStylesheets().add(this.getClass().getResource("/Menu.css").toExternalForm());

        usernameLabel.setLayoutX(62.0);
        usernameLabel.setLayoutY(21.0);
        usernameLabel.setStyle("-fx-font-size: 20;");
        usernameLabel.setText("Username");

        passwordPrompt.setLayoutX(180.0);
        passwordPrompt.setLayoutY(59.0);
        passwordPrompt.setPrefHeight(25.0);
        passwordPrompt.setPrefWidth(149.0);

        usernamePrompt.setLayoutX(180.0);
        usernamePrompt.setLayoutY(24.0);
        usernamePrompt.setPrefHeight(17.0);
        usernamePrompt.setPrefWidth(149.0);

        passwordLabel.setLayoutX(65.0);
        passwordLabel.setLayoutY(57.0);
        passwordLabel.setStyle("-fx-font-size: 20;");
        passwordLabel.setText("Password");

        nameLabel.setLayoutX(96.0);
        nameLabel.setLayoutY(93.0);
        nameLabel.setStyle("-fx-font-size: 20;");
        nameLabel.setText("Name");

        namePrompt.setLayoutX(180.0);
        namePrompt.setLayoutY(96.0);
        namePrompt.setPrefHeight(17.0);
        namePrompt.setPrefWidth(149.0);

        surnameLabel.setLayoutX(72.0);
        surnameLabel.setLayoutY(127.0);
        surnameLabel.setStyle("-fx-font-size: 20;");
        surnameLabel.setText("Surname");

        surnamePrompt.setLayoutX(180.0);
        surnamePrompt.setLayoutY(130.0);
        surnamePrompt.setPrefHeight(17.0);
        surnamePrompt.setPrefWidth(149.0);

        genderLabel.setLayoutX(84.0);
        genderLabel.setLayoutY(163.0);
        genderLabel.setStyle("-fx-font-size: 20;");
        genderLabel.setText("Gender");

        genderPrompt.setLayoutX(180.0);
        genderPrompt.setLayoutY(166.0);
        genderPrompt.setPrefHeight(25.0);
        genderPrompt.setPrefWidth(149.0);
        genderPrompt.setText("Choose Gender");

        maleItem.setText("Male");
        maleItem.setOnAction(event -> {
            newUser.setGender(GENDER.MALE);
            genderPrompt.setText("Male");
        });

        femaleItem.setText("Female");
        femaleItem.setOnAction(event -> {
            newUser.setGender(GENDER.FEMALE);
            genderPrompt.setText("Female");
        });

        otherItem.setText("Not Specified");
        otherItem.setOnAction(event -> {
            newUser.setGender(GENDER.UNSPECIFIED);
            genderPrompt.setText("Other");
        });

        genderPrompt.getItems().add(maleItem);
        genderPrompt.getItems().add(femaleItem);
        genderPrompt.getItems().add(otherItem);

        birthdayLabel.setLayoutX(76.0);
        birthdayLabel.setLayoutY(205.0);
        birthdayLabel.setStyle("-fx-font-size: 20;");
        birthdayLabel.setText("Birthday");

        datePrompt.setLayoutX(180.0);
        datePrompt.setLayoutY(208.0);
        datePrompt.setPrefHeight(25.0);
        datePrompt.setPrefWidth(149.0);
        datePrompt.setPromptText("12/12/2022");
        StringConverter converter = new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        };
        datePrompt.setConverter(converter);

        phoneLabel.setLayoutX(93.0);
        phoneLabel.setLayoutY(243.0);
        phoneLabel.setStyle("-fx-font-size: 20;");
        phoneLabel.setText("Phone");

        phonePrompt.setLayoutX(180.0);
        phonePrompt.setLayoutY(245.0);
        phonePrompt.setPrefHeight(17.0);
        phonePrompt.setPrefWidth(149.0);

        emailLabel.setLayoutX(100.0);
        emailLabel.setLayoutY(277.0);
        emailLabel.setStyle("-fx-font-size: 20;");
        emailLabel.setText("Email");

        emailPrompt.setLayoutX(180.0);
        emailPrompt.setLayoutY(281.0);
        emailPrompt.setPrefHeight(17.0);
        emailPrompt.setPrefWidth(149.0);

        privilegeLabel.setLayoutX(74.0);
        privilegeLabel.setLayoutY(314.0);
        privilegeLabel.setStyle("-fx-font-size: 20;");
        privilegeLabel.setText("Privilege");

        privilegePrompt.setLayoutX(180.0);
        privilegePrompt.setLayoutY(317.0);
        privilegePrompt.setPrefHeight(25.0);
        privilegePrompt.setPrefWidth(149.0);
        privilegePrompt.setText("Choose Profession");

        adminItem.setText("Admin");
        adminItem.setOnAction(event -> {
            newUser.setPrivilege(1);
            privilegePrompt.setText("Admin");
        });

        managerItem.setText("Manager");
        managerItem.setOnAction(event -> {
            newUser.setPrivilege(2);
            privilegePrompt.setText("Manager");
        });

        cashierItem.setText("Cashier");
        cashierItem.setOnAction(event -> {
            newUser.setPrivilege(3);
            privilegePrompt.setText("Cashier");
        });

        privilegePrompt.getItems().add(adminItem);
        privilegePrompt.getItems().add(managerItem);
        privilegePrompt.getItems().add(cashierItem);

        salaryLabel.setLayoutX(95.0);
        salaryLabel.setLayoutY(349.0);
        salaryLabel.setStyle("-fx-font-size: 20;");
        salaryLabel.setText("Salary");

        salaryPrompt.setLayoutX(180.0);
        salaryPrompt.setLayoutY(352.0);
        salaryPrompt.setPrefHeight(17.0);
        salaryPrompt.setPrefWidth(149.0);

        confirmBt.setLayoutX(255.0);
        confirmBt.setLayoutY(390.0);
        confirmBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean fieldsFull = true;

                if (!namePrompt.getText().trim().equals("")) {
                    newUser.setName(namePrompt.getText());
                    nameErr.setVisible(false);
                } else {
                    nameErr.setVisible(true);
                    fieldsFull = false;
                }
                if (!surnamePrompt.getText().trim().equals("")) {
                    newUser.setSurname(surnamePrompt.getText());
                    surnameErr.setVisible(false);
                } else {
                    surnameErr.setVisible(true);
                    fieldsFull = false;
                }

                if (!usernamePrompt.getText().trim().equals("")) {
                    if (!EmployeeController.checkDuplicateUsername(usernamePrompt.getText())) {
                        newUser.setUsername(usernamePrompt.getText());
                        userNameErr.setVisible(false);
                    } else {
                        userNameErr.setVisible(true);
                        userNameErr.setText("Taken!");
                        fieldsFull = false;
                    }
                } else {
                    userNameErr.setVisible(true);
                    fieldsFull = false;
                }

                if (!passwordPrompt.getText().trim().equals("")) {
                    if (checkPassword(passwordPrompt.getText())) {
                        newUser.setPassword(passwordPrompt.getText());
                        passwordErr.setVisible(false);
                    } else {
                        passwordErr.setVisible(true);
                        passwordErr.setText("Weak!");
                        fieldsFull = false;
                    }
                } else {
                    passwordErr.setVisible(true);
                    fieldsFull = false;
                }


                if (datePrompt.getValue() != null) {
                    ZoneId defaultZoneId = ZoneId.systemDefault();
                    Date date = Date.from(datePrompt.getValue().atStartOfDay(defaultZoneId).toInstant());
                    SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
                    newUser.setBirthday(DateFor.format(date));
                    birthdayErr.setVisible(false);
                } else {
                    birthdayErr.setVisible(true);
                    fieldsFull = false;
                }

                if (!emailPrompt.getText().trim().equals("")) {
                    newUser.setEmail(emailPrompt.getText());
                    emailErr.setVisible(false);
                } else {
                    emailErr.setVisible(true);
                    fieldsFull = false;
                }

                if (!phonePrompt.getText().trim().equals("")) {
                    newUser.setPhone(phonePrompt.getText());
                    phoneErr.setVisible(false);
                } else {
                    phoneErr.setVisible(true);
                    fieldsFull = false;
                }

                if (genderPrompt.getText().trim().equals("Choose Gender")) {
                    genderErr.setVisible(true);
                    fieldsFull = false;
                } else {
                    genderErr.setVisible(false);
                }

                if (privilegePrompt.getText().trim().equals("Choose Profession")) {
                    privilegeErr.setVisible(true);
                    fieldsFull = false;
                } else {
                    newUser.setProfession(newUser.checkPrivilege());
                    privilegeErr.setVisible(false);
                }

                if (!salaryPrompt.getText().trim().equals("")) {
                    newUser.setSalary(Double.valueOf(salaryPrompt.getText()));
                    salaryErr.setVisible(false);
                } else {
                    salaryErr.setVisible(true);
                    fieldsFull = false;
                }

                if (fieldsFull) {
                    EmployeeController.confirmAddUser(newUser);
                    stage.setScene(new Employee(u, stage).generateEmployeeScene());
                    window.close();
                } else {
                    fieldsFull = true;
                }

            }
        });
        confirmBt.setPrefHeight(32.0);
        confirmBt.setPrefWidth(74.0);
        confirmBt.getStyleClass().add("edit");
        confirmBt.setText("Confirm");

        cancelBt.setLayoutX(167.0);
        cancelBt.setLayoutY(390.0);
        cancelBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.close();
            }
        });
        cancelBt.setPrefHeight(32.0);
        cancelBt.setPrefWidth(74.0);
        cancelBt.getStyleClass().add("cancel");
        cancelBt.setText("Cancel");


        userNameErr.setLayoutX(343.0);
        userNameErr.setLayoutY(41.0);
        userNameErr.setStyle("-fx-fill: red;");
        userNameErr.setText("Error!");
        userNameErr.setVisible(false);

        passwordErr.setLayoutX(343.0);
        passwordErr.setLayoutY(76.0);
        passwordErr.setStyle("-fx-fill: red;");
        passwordErr.setText("Error!");
        passwordErr.setVisible(false);

        nameErr.setLayoutX(343.0);
        nameErr.setLayoutY(114.0);
        nameErr.setStyle("-fx-fill: red;");
        nameErr.setText("Error!");
        nameErr.setVisible(false);

        surnameErr.setLayoutX(343.0);
        surnameErr.setLayoutY(147.0);
        surnameErr.setStyle("-fx-fill: red;");
        surnameErr.setText("Error!");
        surnameErr.setVisible(false);

        birthdayErr.setLayoutX(343.0);
        birthdayErr.setLayoutY(225.0);
        birthdayErr.setStyle("-fx-fill: red;");
        birthdayErr.setText("Error!");
        birthdayErr.setVisible(false);

        phoneErr.setLayoutX(343.0);
        phoneErr.setLayoutY(262.0);
        phoneErr.setStyle("-fx-fill: red;");
        phoneErr.setText("Error!");
        phoneErr.setVisible(false);

        emailErr.setLayoutX(343.0);
        emailErr.setLayoutY(297.0);
        emailErr.setStyle("-fx-fill: red;");
        emailErr.setText("Error!");
        emailErr.setVisible(false);

        privilegeErr.setLayoutX(343.0);
        privilegeErr.setLayoutY(334.0);
        privilegeErr.setStyle("-fx-fill: red;");
        privilegeErr.setText("Error!");
        privilegeErr.setVisible(false);

        genderErr.setLayoutX(343.0);
        genderErr.setLayoutY(183.0);
        genderErr.setStyle("-fx-fill: red;");
        genderErr.setText("Error!");
        genderErr.setVisible(false);

        salaryErr.setLayoutX(343.0);
        salaryErr.setLayoutY(369.0);
        salaryErr.setStyle("-fx-fill: red;");
        salaryErr.setText("Error!");
        salaryErr.setVisible(false);

        anchorPane.setPrefHeight(438.0);
        anchorPane.setPrefWidth(395.0);

        anchorPane.getChildren().add(usernameLabel);
        anchorPane.getChildren().add(passwordPrompt);
        anchorPane.getChildren().add(usernamePrompt);
        anchorPane.getChildren().add(passwordLabel);
        anchorPane.getChildren().add(nameLabel);
        anchorPane.getChildren().add(namePrompt);
        anchorPane.getChildren().add(surnameLabel);
        anchorPane.getChildren().add(surnamePrompt);
        anchorPane.getChildren().add(genderLabel);
        anchorPane.getChildren().add(genderPrompt);
        anchorPane.getChildren().add(birthdayLabel);
        anchorPane.getChildren().add(datePrompt);
        anchorPane.getChildren().add(phoneLabel);
        anchorPane.getChildren().add(phonePrompt);
        anchorPane.getChildren().add(emailLabel);
        anchorPane.getChildren().add(emailPrompt);
        anchorPane.getChildren().add(privilegeLabel);
        anchorPane.getChildren().add(privilegePrompt);
        anchorPane.getChildren().add(salaryLabel);
        anchorPane.getChildren().add(salaryPrompt);
        anchorPane.getChildren().add(confirmBt);
        anchorPane.getChildren().add(cancelBt);
        anchorPane.getChildren().add(userNameErr);
        anchorPane.getChildren().add(passwordErr);
        anchorPane.getChildren().add(nameErr);
        anchorPane.getChildren().add(surnameErr);
        anchorPane.getChildren().add(birthdayErr);
        anchorPane.getChildren().add(phoneErr);
        anchorPane.getChildren().add(emailErr);
        anchorPane.getChildren().add(privilegeErr);
        anchorPane.getChildren().add(genderErr);
        anchorPane.getChildren().add(salaryErr);

    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    @Override
    public boolean checkPassword(String s) {
        if (s.matches("^(?=(\\D*\\d){2,})(?=.*[A-Z])[a-zA-Z0-9]{10,}$"))
            return true;
        else
            return false;
    }

    @Override
    public boolean matchPassword(String s1, String s2) {
        if (s1.equals(s2))
            return true;
        else
            return false;
    }
}