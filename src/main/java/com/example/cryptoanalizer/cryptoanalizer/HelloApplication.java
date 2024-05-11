package com.example.cryptoanalizer.cryptoanalizer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private static  Stage stg;
    @Override
    public void start(Stage stage) throws IOException {

        stg = stage;
        stage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/cryptoanalizer/cryptoanalizer/Hello-Controller.fxml"));

        Scene scene = new Scene(root);
        stage.getIcons().add(new Image("icon.png"));
        stage.setTitle("CryptoAnylizer");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}