package com.example.cryptoanalizer.cryptoanalizer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private static  Stage stg;
    @Override
    public void start(Stage stage) throws IOException {

        stg = stage;
        stage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("Hello-Controller.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("CryptoAnylizer");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}