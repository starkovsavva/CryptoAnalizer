package com.example.cryptoanalizer.cryptoanalizer.controller;

import com.example.cryptoanalizer.cryptoanalizer.service.CryptoService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    private static final CryptoService CRYPTO_SERVICE = new CryptoService();
//
//
//    string decodebutton(file sd, key){
//         File = decode.service.decode()
//    }

}