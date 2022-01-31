package com.example.joncdstore;

import com.example.joncdstore.view.Login;
import javafx.application.Application;
import javafx.stage.Stage;


public class App extends Application {
    @Override
    public void start(Stage stage)  {
        stage.setScene(new Login(stage).createLoginScene());
        stage.setResizable(false);
        stage.setTitle("CDWORLD LOGIN");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}