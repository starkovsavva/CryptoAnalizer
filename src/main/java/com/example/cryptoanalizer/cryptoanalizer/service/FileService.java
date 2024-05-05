package com.example.cryptoanalizer.cryptoanalizer.service;

import java.io.*;

public class FileService {
    public StringBuilder readFile(File file){
        StringBuilder builder = new StringBuilder();
        try(FileReader reader = new FileReader(file)){
            while(reader.ready()){
                builder.append(reader.read());
            }


        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        return  builder;
    }


    public void writeFile(String string){
        try(FileWriter writer = new FileWriter("output.txt")){
            writer.write(string);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

