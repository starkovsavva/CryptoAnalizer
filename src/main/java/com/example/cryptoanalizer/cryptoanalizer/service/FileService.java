package com.example.cryptoanalizer.cryptoanalizer.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileService {
    public StringBuilder readFile(File file){
        StringBuilder builder = new StringBuilder();
        try(FileReader reader = new FileReader(file)){
            while(reader.ready()){
                builder.append(reader.read());
            }


        }
        catch (FileNotFoundException e){;}
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        return  builder;
    }


    public void writeFile(String string){

    }


}

