package com.example.cryptoanalizer.cryptoanalizer.controller;

import com.example.cryptoanalizer.cryptoanalizer.service.CryptoService;
import javafx.event.ActionEvent;

import java.io.*;


import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Pane.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class HelloController {


    @FXML
    private Pane textFlow;
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
    private boolean isopen = false;

    private static boolean isDecode;
    private static final CryptoService CRYPTO_SERVICE = new CryptoService();



    @FXML
    public void choose(ActionEvent event) {

        if(!isopen){
            isopen = true;
            File file = fileChooser.showOpenDialog(new Stage());
            textFlow.setVisible(true);
            if(file != null){
                this.file = file;
            }
            isopen = false;

        }
        if(file == null){
            textFlow.setVisible(false);
        }



//        CRYPTO_SERVICE.
    }



    public void processCode(){
        try{
            keyValidator();
        }
        catch (Exception e){
            return;
        }

        if (!this.file.exists()) {
            String toDecode = entryText.getText();
            this.processedstring = CRYPTO_SERVICE.processFile(toDecode,key,isDecode);
            processedText.setText(processedstring);


        }
        if(this.file.exists()){
            CRYPTO_SERVICE.processFile(this.file,key,isDecode);

        }

    }
    public void keyValidator() throws Exception {
        if(keyEnter.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Key must be non-empty!");
            alert.setHeaderText("KeyValue Error");
            alert.setTitle("Title");
            alert.showAndWait();
            throw new Exception();
        }
        try{

            this.key = Integer.parseInt(keyEnter.getText());
        }
        catch (NumberFormatException e ){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Wrong key!");
            alert.showAndWait();
            throw new Exception();
        }



    }

    @FXML
    public void decode(ActionEvent event) {
        isDecode = true;
        processCode();


    }


    @FXML
    public void encode(ActionEvent event){
        isDecode = false;
        processCode();


        ;
    }
    @FXML
    public void bruteForceAction(ActionEvent event){

        isDecode = true;
        if (!this.file.exists() ) {
            String toDecode = entryText.getText();
            this.processedstring = CRYPTO_SERVICE.BruteForce(toDecode);
            processedText.setText(processedstring);


        }else if(this.file.exists()){
            CRYPTO_SERVICE.processFile(this.file,key,isDecode);

        }

        ;


    }


}