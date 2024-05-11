package com.example.cryptoanalizer.cryptoanalizer.service;

import com.example.cryptoanalizer.cryptoanalizer.util.CryptoUtil;
import javafx.scene.control.TextArea;

import java.io.*;

public class CryptoService {


    private final static FileService fileService = new FileService();
    private static final String checkText = fileService.readFile(new File("src/main/resources/russian.txt")).toString();

    public String processFile(File file, int key, boolean isDecode) {
        String string = fileService.readFile(file).toString();

        StringBuilder builder = new StringBuilder();


        try {

            for(char c : string.toCharArray()){

                if (c == ' '){
                    builder.append(c);
                    continue;
                }
                int index = CryptoUtil.CryptoAlphabet.ALPHABET.indexOf(c);
                if(index != -1){
                    if(isDecode){
                        index = index - (key % CryptoUtil.CryptoAlphabet.ALPHABET.length());
                        if(index < 0){
                            index = index + CryptoUtil.CryptoAlphabet.ALPHABET.length();
                        }
                        if (index > 66){
                            index = index % CryptoUtil.CryptoAlphabet.ALPHABET.length();
                        }
                        builder.append(CryptoUtil.CryptoAlphabet.ALPHABET.charAt(index));
                    }
                    else{

                        index = index + (key % CryptoUtil.CryptoAlphabet.ALPHABET.length()) ;
                        if(index > 66){
                            index = index % CryptoUtil.CryptoAlphabet.ALPHABET.length();
                        }
                        CryptoUtil.CryptoAlphabet.ALPHABET.charAt(index);
                        builder.append(CryptoUtil.CryptoAlphabet.ALPHABET.charAt(index));
                    }


                } else{
                    builder.append(c);
                }

            }

        } catch (Exception e) {
            ;
        }
        fileService.writeFile(builder.toString());
        return builder.toString();


    }
    public String processFile(String string, int key, boolean isDecode) {

        StringBuilder builder = new StringBuilder();

        try {

            for(char c : string.toCharArray()){

                if (c == ' '){
                    builder.append(c);
                    continue;
                }
                int index = CryptoUtil.CryptoAlphabet.ALPHABET.indexOf(c);
                if(index != -1){
                    if(isDecode){
                        index = index - (key % CryptoUtil.CryptoAlphabet.ALPHABET.length());
                        if(index < 0){
                            index = index + CryptoUtil.CryptoAlphabet.ALPHABET.length();
                        }
                        if (index >= 66){
                            index = index % CryptoUtil.CryptoAlphabet.ALPHABET.length();
                        }
                        builder.append(CryptoUtil.CryptoAlphabet.ALPHABET.charAt(index));
                    }
                    else{

                        index = index + (key % CryptoUtil.CryptoAlphabet.ALPHABET.length()) ;
                        if(index >= 66){
                            index = index % CryptoUtil.CryptoAlphabet.ALPHABET.length();
                        }
                        CryptoUtil.CryptoAlphabet.ALPHABET.charAt(index);
                        builder.append(CryptoUtil.CryptoAlphabet.ALPHABET.charAt(index));
                    }


                } else{
                    builder.append(c);
                }

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

                if (occurrences > 1) {
                    fileService.writeFile(string);
                    break;
                }


            }

        } catch (Exception e) {
            ;
        }
    }


    public String BruteForce(String string1) {

        try {
            for (int i = 0; i < CryptoUtil.CryptoAlphabet.ALPHABET.length(); i++) {
                int key = i;
                int occurrences = 0;
                String string = processFile(string1, key, true);
                for (var word : string.split(" ")) {
                    if (checkText.contains(word)) {
                        occurrences++;
                    }


                }

                if (occurrences > 1) {
                    return string;
                }


            }

        } catch (Exception e) {
            ;
        }
        return null;
    }

//    public int keyParse (TextArea keArea){
;
//    };


}







