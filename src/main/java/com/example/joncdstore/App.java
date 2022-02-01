package com.example.joncdstore;

import com.example.joncdstore.view.Login;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class App extends Application {
    @Override
    public void start(Stage stage)  {
        stage.setScene(new Login(stage).createLoginScene());
        stage.setResizable(false);
        stage.getIcons().add(new Image(App.class.getResourceAsStream("img/icon.jpg")));
        stage.setTitle("CDWORLD LOGIN");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}