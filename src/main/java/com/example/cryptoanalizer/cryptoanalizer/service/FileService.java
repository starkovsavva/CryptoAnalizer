package com.example.cryptoanalizer.cryptoanalizer.service;

import java.io.*;

public class FileService {
    public StringBuilder readFile(File file){
        StringBuilder sb = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
        }
        catch (Exception e){
            ;
        }
        return sb;
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

