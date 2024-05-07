package com.example.cryptoanalizer.cryptoanalizer.controller;

import com.example.cryptoanalizer.cryptoanalizer.service.CryptoService;
import javafx.event.ActionEvent;

import java.io.*;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    private Label Cryprosperma;


    @FXML
    private TextArea entryText;
    @FXML
    private TextArea processedText;
    @FXML
    private Button encodeButton;
    @FXML
    private Button decodeButton;
    @FXML
    private Button choserFile;
    @FXML
    private TextArea keyEnter;

    private File file;

    FileChooser fileChooser = new FileChooser();

    private boolean isDecode;
    private static final CryptoService CRYPTO_SERVICE = new CryptoService();
//
//
//    string decodebutton(file sd, key){
//         File = decode.service.decode()
//    }


    @FXML
    public void choose(ActionEvent event) {
        File file = fileChooser.showOpenDialog(new Stage());
        this.file = file;
//        CRYPTO_SERVICE.
    }



    @FXML
    public void decode(ActionEvent event) {

        if (!this.file.exists()) {
//            entryText.getText()
        }

    }


    @FXML
    public void encode(ActionEvent event){
        ;
    }


}