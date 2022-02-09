package com.example.joncdstore.view;

import com.example.joncdstore.controller.AccountController;
import com.example.joncdstore.model.GENDER;
import com.example.joncdstore.model.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.util.StringConverter;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ChangeAccount {

    private final ScrollPane scrollPane;
    private final AnchorPane outerAnchor;
    private final Button saveChangesBt;
    private final Label basicLabel;
    private final Label contactLabel;
    private final Label securityLabel;
    private final Label professionLabel;
    private final HBox basicBox;
    private final AnchorPane basicAnchor;
    private final Label nameLabel;
    private final Label birthdayLabel;
    private final Label genderLabel;
    private final Separator sep1;
    private final Separator sep2;
    private final TextField namePrompt;
    private final DatePicker datePrompt;
    private final SplitMenuButton genderPrompt;
    private final MenuItem male;
    private final MenuItem female;
    private final MenuItem n;
    private final HBox contactBox;
    private final AnchorPane contactAnchor;
    private final Label emailLabel;
    private final Label phoneLabel;
    private final Separator sep3;
    private final TextField emailPrompt;
    private final TextField phonePrompt;
    private final HBox securityBox;
    private final AnchorPane securityAnchor;
    private final Label usernameLabel;
    private final Label passwordLabel;
    private final Separator sep4;
    private final Button changePassBt;
    private final Text usernameField;
    private final PasswordField passwordField;
    private final HBox professionBox;
    private final AnchorPane professionAnchor;
    private final Label privilegeLabel;
    private final Label salaryLabel;
    private final Separator sep5;
    private final Separator sep6;
    private final Label employLabel;
    private final Text privilegeField;
    private final Text salaryField;
    private final Text employmentField;
    private final Button cancelChangesBt;

    public ChangeAccount(AnchorPane mainMenu, User u) {

        scrollPane = new ScrollPane();
        outerAnchor = new AnchorPane();
        saveChangesBt = new Button();
        basicLabel = new Label();
        contactLabel = new Label();
        securityLabel = new Label();
        professionLabel = new Label();
        basicBox = new HBox();
        basicAnchor = new AnchorPane();
        nameLabel = new Label();
        birthdayLabel = new Label();
        genderLabel = new Label();
        sep1 = new Separator();
        sep2 = new Separator();
        namePrompt = new TextField();
        datePrompt = new DatePicker();
        genderPrompt = new SplitMenuButton();
        male = new MenuItem();
        female = new MenuItem();
        n = new MenuItem();
        contactBox = new HBox();
        contactAnchor = new AnchorPane();
        emailLabel = new Label();
        phoneLabel = new Label();
        sep3 = new Separator();
        emailPrompt = new TextField();
        phonePrompt = new TextField();
        securityBox = new HBox();
        securityAnchor = new AnchorPane();
        usernameLabel = new Label();
        passwordLabel = new Label();
        sep4 = new Separator();
        changePassBt = new Button();
        usernameField = new Text();
        passwordField = new PasswordField();
        professionBox = new HBox();
        professionAnchor = new AnchorPane();
        privilegeLabel = new Label();
        salaryLabel = new Label();
        sep5 = new Separator();
        sep6 = new Separator();
        employLabel = new Label();
        privilegeField = new Text();
        salaryField = new Text();
        employmentField = new Text();
        cancelChangesBt = new Button();

        scrollPane.getStylesheets().add(this.getClass().getResource("/Menu.css").toExternalForm());

        outerAnchor.setPrefHeight(875.0);
        outerAnchor.setPrefWidth(728.0);

        saveChangesBt.setLayoutX(605.0);
        saveChangesBt.setLayoutY(829.0);
        saveChangesBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (!namePrompt.getText().trim().equals("")) {
                    int idx = namePrompt.getText().lastIndexOf(' ');
                    // TODO Exception when enter only one name
                    String firstName = namePrompt.getText().substring(0,idx);
                    String lastName = namePrompt.getText().substring(idx +1);
                    u.setName(firstName);
                    u.setSurname(lastName);
                }

                if (datePrompt.getValue() != null) {
                    ZoneId defaultZoneId = ZoneId.systemDefault();
                    Date date = Date.from(datePrompt.getValue().atStartOfDay(defaultZoneId).toInstant());
                    SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
                    u.setBirthday(DateFor.format(date));
                }


                if (!emailPrompt.getText().trim().equals("")) {
                    u.setEmail(emailPrompt.getText());
                }

                if (!phonePrompt.getText().trim().equals("")) {
                    u.setPhone(phonePrompt.getText());
                }

                AccountController.saveChanges(mainMenu,u);
            }
        });
        saveChangesBt.setPrefHeight(32.0);
        saveChangesBt.setPrefWidth(74.0);
        saveChangesBt.setText("Save");
        saveChangesBt.getStyleClass().add("edit");

        basicLabel.setLayoutX(45.0);
        basicLabel.setLayoutY(25.0);
        basicLabel.setStyle("-fx-font-size: 30; -fx-text-fill: #3274D2;");
        basicLabel.setText("Basic info");

        contactLabel.setLayoutX(45.0);
        contactLabel.setLayoutY(254.0);
        contactLabel.setStyle("-fx-font-size: 30; -fx-text-fill: #3274D2;");
        contactLabel.setText("Contact info");

        securityLabel.setLayoutX(45.0);
        securityLabel.setLayoutY(435.0);
        securityLabel.setStyle("-fx-font-size: 30; -fx-text-fill: #3274D2;");
        securityLabel.setText("Security");

        professionLabel.setLayoutX(45.0);
        professionLabel.setLayoutY(609.0);
        professionLabel.setStyle("-fx-font-size: 30; -fx-text-fill: #3274D2;");
        professionLabel.setText("Profession");

        basicBox.setLayoutX(45.0);
        basicBox.setLayoutY(70.0);
        basicBox.setPrefHeight(175.0);
        basicBox.setPrefWidth(627.0);
        basicBox.setStyle("-fx-border-style: solid inside; -fx-border-width: 0.5; -fx-border-insets: 2; -fx-border-radius: 5;");

        basicAnchor.setPrefHeight(158.0);
        basicAnchor.setPrefWidth(621.0);

        nameLabel.setLayoutX(14.0);
        nameLabel.setLayoutY(14.0);
        nameLabel.setStyle("-fx-font-size: 20;");
        nameLabel.setText("Name:");

        birthdayLabel.setLayoutX(14.0);
        birthdayLabel.setLayoutY(64.0);
        birthdayLabel.setStyle("-fx-font-size: 20;");
        birthdayLabel.setText("Birthday:");

        genderLabel.setLayoutX(14.0);
        genderLabel.setLayoutY(118.0);
        genderLabel.setStyle("-fx-font-size: 20;");
        genderLabel.setText("Gender:");

        sep1.setLayoutX(14.0);
        sep1.setLayoutY(53.0);
        sep1.setPrefHeight(4.0);
        sep1.setPrefWidth(604.0);

        sep2.setLayoutX(14.0);
        sep2.setLayoutY(106.0);
        sep2.setPrefHeight(4.0);
        sep2.setPrefWidth(604.0);

        namePrompt.setLayoutX(104.0);
        namePrompt.setLayoutY(14.0);
        namePrompt.setStyle("-fx-font-size: 15;");
        namePrompt.setPromptText(u.getName() + " " + u.getSurname());

        datePrompt.setLayoutX(104.0);
        datePrompt.setLayoutY(67.0);
        datePrompt.setPrefHeight(25.0);
        datePrompt.setPrefWidth(171.0);
        datePrompt.setPromptText(u.getBirthday());
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
        genderPrompt.setLayoutX(104.0);
        genderPrompt.setLayoutY(121.0);
        genderPrompt.setText(u.getGender().getText());

        male.setText("Male");
        male.setOnAction(event -> {
            u.setGender(GENDER.MALE);
            genderPrompt.setText("Male");
        });
        female.setText("Female");
        female.setOnAction(event -> {
            u.setGender(GENDER.FEMALE);
            genderPrompt.setText("Female");
        });
        n.setText("Not Specified");
        n.setOnAction(event -> {
            u.setGender(GENDER.UNSPECIFIED);
            genderPrompt.setText("Not Specified");
        });

        contactBox.setLayoutX(45.0);
        contactBox.setLayoutY(299.0);
        contactBox.setPrefHeight(120.0);
        contactBox.setPrefWidth(627.0);
        contactBox.setStyle("-fx-border-style: solid inside; -fx-border-width: 0.5; -fx-border-insets: 2; -fx-border-radius: 5;");

        contactAnchor.setPrefHeight(158.0);
        contactAnchor.setPrefWidth(621.0);

        emailLabel.setLayoutX(14.0);
        emailLabel.setLayoutY(14.0);
        emailLabel.setStyle("-fx-font-size: 20;");
        emailLabel.setText("Email:");

        phoneLabel.setLayoutX(14.0);
        phoneLabel.setLayoutY(64.0);
        phoneLabel.setStyle("-fx-font-size: 20;");
        phoneLabel.setText("Phone:");

        sep3.setLayoutX(14.0);
        sep3.setLayoutY(53.0);
        sep3.setPrefHeight(4.0);
        sep3.setPrefWidth(604.0);

        emailPrompt.setLayoutX(84.0);
        emailPrompt.setLayoutY(14.0);
        emailPrompt.setStyle("-fx-font-size: 15;");
        emailPrompt.setPromptText(u.getEmail());

        phonePrompt.setLayoutX(84.0);
        phonePrompt.setLayoutY(64.0);
        phonePrompt.setStyle("-fx-font-size: 15;");
        String phoneFormat;
        if (u.getPhone().length() < 10) {
            phoneFormat = u.getPhone();
        }
        else
            phoneFormat = u.getPhone().substring(0,3) + " " + u.getPhone().substring(3,5) + " " + u.getPhone().substring(5,7) + " " + u.getPhone().substring(7,10);
        phonePrompt.setPromptText(phoneFormat);

        securityBox.setLayoutX(45.0);
        securityBox.setLayoutY(480.0);
        securityBox.setPrefHeight(113.0);
        securityBox.setPrefWidth(634.0);
        securityBox.setStyle("-fx-border-style: solid inside; -fx-border-width: 0.5; -fx-border-insets: 2; -fx-border-radius: 5;");

        securityAnchor.setPrefHeight(111.0);
        securityAnchor.setPrefWidth(621.0);

        usernameLabel.setLayoutX(14.0);
        usernameLabel.setLayoutY(14.0);
        usernameLabel.setStyle("-fx-font-size: 20;");
        usernameLabel.setText("Username:");

        passwordLabel.setLayoutX(14.0);
        passwordLabel.setLayoutY(64.0);
        passwordLabel.setStyle("-fx-font-size: 20;");
        passwordLabel.setText("Password:");

        sep4.setLayoutX(14.0);
        sep4.setLayoutY(53.0);
        sep4.setPrefHeight(4.0);
        sep4.setPrefWidth(604.0);

        changePassBt.setLayoutX(542.0);
        changePassBt.setLayoutY(67.0);
        changePassBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AccountController.changePassword(u);
            }
        });
        changePassBt.setStyle("-fx-border-radius: 5;");
        changePassBt.setText("Change");

        usernameField.setLayoutX(124.0);
        usernameField.setLayoutY(37.0);
        usernameField.setStyle("-fx-font-size: 20;");
        usernameField.setText(u.getUsername());
        usernameField.setWrappingWidth(200.0);

        passwordField.setLayoutX(124.0);
        passwordField.setLayoutY(67.0);
        passwordField.setPrefHeight(25.0);
        passwordField.setPrefWidth(72.0);
        passwordField.setStyle("-fx-background-color: #F5F5F5;");
        passwordField.setText(u.getPassword());

        professionBox.setLayoutX(45.0);
        professionBox.setLayoutY(654.0);
        professionBox.setPrefHeight(169.0);
        professionBox.setPrefWidth(634.0);
        professionBox.setStyle("-fx-border-style: solid inside; -fx-border-width: 0.5; -fx-border-insets: 2; -fx-border-radius: 5;");

        professionAnchor.setPrefHeight(158.0);
        professionAnchor.setPrefWidth(621.0);

        privilegeLabel.setLayoutX(14.0);
        privilegeLabel.setLayoutY(14.0);
        privilegeLabel.setStyle("-fx-font-size: 20;");
        privilegeLabel.setText("Privilege:");

        salaryLabel.setLayoutX(14.0);
        salaryLabel.setLayoutY(64.0);
        salaryLabel.setStyle("-fx-font-size: 20;");
        salaryLabel.setText("Salary:");

        sep5.setLayoutX(14.0);
        sep5.setLayoutY(53.0);
        sep5.setPrefHeight(4.0);
        sep5.setPrefWidth(604.0);

        sep6.setLayoutX(14.0);
        sep6.setLayoutY(109.0);
        sep6.setPrefHeight(4.0);
        sep6.setPrefWidth(604.0);

        employLabel.setLayoutX(14.0);
        employLabel.setLayoutY(119.0);
        employLabel.setStyle("-fx-font-size: 20;");
        employLabel.setText("Employment Date:");

        privilegeField.setLayoutX(113.0);
        privilegeField.setLayoutY(36.0);
        privilegeField.setStyle("-fx-font-size: 20;");
        privilegeField.setText(u.checkPrivilege());
        privilegeField.setWrappingWidth(81.0);

        salaryField.setLayoutX(113.0);
        salaryField.setLayoutY(86.0);
        salaryField.setStyle("-fx-font-size: 20;");
        salaryField.setText(String.valueOf(u.getSalary()));
        salaryField.setWrappingWidth(81.0);

        employmentField.setLayoutX(194.0);
        employmentField.setLayoutY(141.0);
        employmentField.setStyle("-fx-font-size: 20;");
        employmentField.setText(u.getEmploymentDate());
        employmentField.setWrappingWidth(111.0);

        cancelChangesBt.setLayoutX(517.0);
        cancelChangesBt.setLayoutY(829.0);
        cancelChangesBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AccountController.cancelChanges(mainMenu, u);
            }
        });
        cancelChangesBt.setPrefHeight(32.0);
        cancelChangesBt.setPrefWidth(74.0);
        cancelChangesBt.setText("Cancel");
        cancelChangesBt.getStyleClass().add("cancel");


        outerAnchor.getChildren().add(saveChangesBt);
        outerAnchor.getChildren().add(basicLabel);
        outerAnchor.getChildren().add(contactLabel);
        outerAnchor.getChildren().add(securityLabel);
        outerAnchor.getChildren().add(professionLabel);
        basicAnchor.getChildren().add(nameLabel);
        basicAnchor.getChildren().add(birthdayLabel);
        basicAnchor.getChildren().add(genderLabel);
        basicAnchor.getChildren().add(sep1);
        basicAnchor.getChildren().add(sep2);
        basicAnchor.getChildren().add(namePrompt);
        basicAnchor.getChildren().add(datePrompt);
        genderPrompt.getItems().add(male);
        genderPrompt.getItems().add(female);
        genderPrompt.getItems().add(n);
        basicAnchor.getChildren().add(genderPrompt);
        basicBox.getChildren().add(basicAnchor);
        outerAnchor.getChildren().add(basicBox);
        contactAnchor.getChildren().add(emailLabel);
        contactAnchor.getChildren().add(phoneLabel);
        contactAnchor.getChildren().add(sep3);
        contactAnchor.getChildren().add(emailPrompt);
        contactAnchor.getChildren().add(phonePrompt);
        contactBox.getChildren().add(contactAnchor);
        outerAnchor.getChildren().add(contactBox);
        securityAnchor.getChildren().add(usernameLabel);
        securityAnchor.getChildren().add(passwordLabel);
        securityAnchor.getChildren().add(sep4);
        securityAnchor.getChildren().add(changePassBt);
        securityAnchor.getChildren().add(usernameField);
        securityAnchor.getChildren().add(passwordField);
        securityBox.getChildren().add(securityAnchor);
        outerAnchor.getChildren().add(securityBox);
        professionAnchor.getChildren().add(privilegeLabel);
        professionAnchor.getChildren().add(salaryLabel);
        professionAnchor.getChildren().add(sep5);
        professionAnchor.getChildren().add(sep6);
        professionAnchor.getChildren().add(employLabel);
        professionAnchor.getChildren().add(privilegeField);
        professionAnchor.getChildren().add(salaryField);
        professionAnchor.getChildren().add(employmentField);
        professionBox.getChildren().add(professionAnchor);
        outerAnchor.getChildren().add(professionBox);
        outerAnchor.getChildren().add(cancelChangesBt);

        scrollPane.setContent(outerAnchor);
        scrollPane.setHbarPolicy(javafx.scene.control.ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setLayoutX(235);
        scrollPane.setLayoutY(110);
        scrollPane.setPrefHeight(573);
        scrollPane.setPrefWidth(729);

    }

    public ScrollPane getScrollPane() {
        return scrollPane;
    }

    public TextField getNamePrompt() {
        return namePrompt;
    }

    public DatePicker getDatePrompt() {
        return datePrompt;
    }

    public SplitMenuButton getGenderPrompt() {
        return genderPrompt;
    }

    public MenuItem getMale() {
        return male;
    }

    public MenuItem getFemale() {
        return female;
    }

    public MenuItem getN() {
        return n;
    }

    public TextField getEmailPrompt() {
        return emailPrompt;
    }

    public TextField getPhonePrompt() {
        return phonePrompt;
    }
}
