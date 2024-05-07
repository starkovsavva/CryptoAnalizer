package com.example.cryptoanalizer.cryptoanalizer.controller;

import com.example.cryptoanalizer.cryptoanalizer.service.CryptoService;
import javafx.event.ActionEvent;

import java.io.*;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    private Label Cryprosperma;


    @FXML
    private Button BruteForceAction;
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

    private File file = new File("output");

    private int key;
    private String processedstring;

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



    public void keyValidator(){
        if(keyEnter.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Key must be non-empty!");
            alert.showAndWait();
        }
        try{
            this.key = Integer.parseInt(keyEnter.getText());
        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Wrong key!");
            alert.showAndWait();
        }

    }

    @FXML
    public void decode(ActionEvent event) {

        isDecode = true;
        keyValidator();
        if (!this.file.exists() ) {
            String toDecode = entryText.getText();
            this.processedstring = CRYPTO_SERVICE.processFile(toDecode,key,isDecode);
            processedText.setText(processedstring);


        }else if(this.file.exists()){
            CRYPTO_SERVICE.processFile(this.file,key,isDecode);

        }

    }


    @FXML
    public void encode(ActionEvent event){
        isDecode = false;
        keyValidator();
        if (!this.file.exists() ) {
            String toDecode = entryText.getText();
            this.processedstring = CRYPTO_SERVICE.processFile(toDecode,key,isDecode);
            processedText.setText(processedstring);


        }else if(this.file.exists()){
            CRYPTO_SERVICE.processFile(this.file,key,isDecode);

        }


        ;
    }
    @FXML
    public void bruteForceAction(){;}


}