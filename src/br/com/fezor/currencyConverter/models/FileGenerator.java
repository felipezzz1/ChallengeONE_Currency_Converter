package br.com.fezor.currencyConverter.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class FileGenerator {
    public void saveJsonFile(Currency currency) throws IOException{
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        FileWriter writer = new FileWriter("conversion.json");
        writer.write(gson.toJson(currency));
        writer.close();
    }
}
