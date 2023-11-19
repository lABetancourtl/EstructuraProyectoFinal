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
        double screenWidth = 400; //java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double screenHeight =500; //java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        Scene scene = new Scene(fxmlLoader.load(), screenWidth, screenHeight);
        stage.setMaximized(false);
        stage.setResizable(true);
        stage.setTitle("LOGIN");
        stage.setScene(scene);
        stage.show();
    }
    public void cargarVentanaPrincipal() {

        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

            double screenWidth = java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth();
            double screenHeight =java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight();
            Parent root = loader.load();

            Scene scene = new Scene(root, screenHeight, screenWidth );
            Stage stage = new Stage ();
            stage.centerOnScreen();
            stage.setTitle("UQGESTOR");
            stage.setMaximized(true);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }


}