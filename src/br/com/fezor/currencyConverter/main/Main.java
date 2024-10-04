package br.com.fezor.currencyConverter.main;

import br.com.fezor.currencyConverter.models.Conversion;
import br.com.fezor.currencyConverter.models.ConvertCurrency;
import br.com.fezor.currencyConverter.models.Currency;
import br.com.fezor.currencyConverter.models.FileGenerator;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        ConvertCurrency convertCurrency = new ConvertCurrency();
        var option = 0;
        String actualCurrency = "";
        String convertedCurrency = "";
        List<Conversion> conversions = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while(option != 7){
            System.out.println("--------------------------");
            System.out.println("Welcome to Currency Converter");
            System.out.println("\n1) United States Dollar => Argentine Peso");
            System.out.println("2) Argentine Peso => United States Dollar");
            System.out.println("3) United States Dollar => Brazilian Real");
            System.out.println("4) Brazilian Real => United States Dollar");
            System.out.println("5) United States Dollar => Colombian Peso");
            System.out.println("6) Colombian Peso => United States Dollar");
            System.out.println("7) Exit");
            System.out.println("Please choose a valid option:");

            option = input.nextInt();

            try{
                switch (option){
                    case 1:
                        actualCurrency = "USD";
                        convertedCurrency = "ARS";
                        break;
                    case 2:
                        actualCurrency = "ARS";
                        convertedCurrency = "USD";
                        break;
                    case 3:
                        actualCurrency = "USD";
                        convertedCurrency = "BRL";
                        break;
                    case 4:
                        actualCurrency = "BRL";
                        convertedCurrency = "USD";
                        break;
                    case 5:
                        actualCurrency = "USD";
                        convertedCurrency = "COP";
                        break;
                    case 6:
                        actualCurrency = "COP";
                        convertedCurrency = "USD";
                        break;
                    case 7:
                        System.out.println("You choose to exit. Bye :)");
                        continue;
                    default:
                        System.out.println("Please choose a valid option!");
                        continue;
                }

                System.out.println("Please Type the value you want to convert: ");
                double value = input.nextDouble();

                Currency newCurrency = convertCurrency.convert(value, actualCurrency, convertedCurrency);

                Conversion newConversion = new Conversion(newCurrency);
                System.out.println(newConversion);

                conversions.add(newConversion);
            }catch (Exception e){
                System.out.println(e.getMessage());
                System.out.println("Exiting...");
                break;
            }

        }

        FileWriter fileGenerator = new FileWriter("conversions.txt");
        fileGenerator.write(gson.toJson(conversions));
        fileGenerator.close();
    }
}
