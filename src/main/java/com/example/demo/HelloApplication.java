package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        double screenWidth = 400;
        double screenHeight =500;
        Scene scene = new Scene(fxmlLoader.load(), screenWidth, screenHeight);
        stage.setMaximized(false);
        stage.setResizable(true);
        stage.setTitle("LOGIN");
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }


}