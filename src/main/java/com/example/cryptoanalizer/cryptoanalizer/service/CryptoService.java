package com.example.cryptoanalizer.cryptoanalizer.service;

import com.example.cryptoanalizer.cryptoanalizer.util.CryptoUtil;
import javafx.scene.control.TextArea;

import java.io.*;

public class CryptoService {


    private final static FileService fileService = new FileService();
    private static final String checkText = fileService.readFile(new File("src/main/resources/russian.txt")).toString();

    public String processFile(File file, int key, boolean isDecode) {
        StringBuilder builder = fileService.readFile(file);


        try {

            int i = 0;
            while (!builder.isEmpty()) {

                if (CryptoUtil.CryptoAlphabet.ALPHABET.indexOf(builder.charAt(i)) != -1) {
                    if (isDecode) {
                        builder.setCharAt(i, CryptoUtil.CryptoAlphabet.ALPHABET.charAt(i - key));
                    } else if (!(isDecode)) {
                        builder.setCharAt(i, CryptoUtil.CryptoAlphabet.ALPHABET.charAt(i + key));
                    }
                }
                i++;
            }

            fileService.writeFile(builder.toString());

        } catch (Exception e) {
            ;
        }
        return builder.toString();

    }
    public String processFile(String string, int key, boolean isDecode) {

        StringBuilder builder = new StringBuilder(string);

        try {

            int i = 0;
            while (!builder.isEmpty()) {

                if (CryptoUtil.CryptoAlphabet.ALPHABET.indexOf(builder.charAt(i)) != -1) {
                    if (isDecode) {
                        builder.setCharAt(i, CryptoUtil.CryptoAlphabet.ALPHABET.charAt(i - key));
                    } else if (!(isDecode)) {
                        builder.setCharAt(i, CryptoUtil.CryptoAlphabet.ALPHABET.charAt(i + key));
                    }
                }
                i++;
            }

        } catch (Exception e) {
            ;
        }
        return builder.toString();

    }

    public void BruteForce(File file, File output) {

        try {
            for (int i = 0; i < CryptoUtil.CryptoAlphabet.ALPHABET.length(); i++) {
                int key = i;
                int occurrences = 0;
                String string = processFile(file, key, true);
                for (var word : string.split(" ")) {
                    if (checkText.contains(word)) {
                        occurrences++;
                    }


                }

                if (occurrences > 3) {
                    fileService.writeFile(string);
                    break;
                }


            }

        } catch (Exception e) {
            ;
        }
    }

//    public int keyParse (TextArea keArea){
;
//    };


}







