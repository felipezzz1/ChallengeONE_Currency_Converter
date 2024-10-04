package br.com.fezor.currencyConverter.models;

import com.google.gson.Gson;
import io.github.cdimascio.dotenv.Dotenv;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConvertCurrency {
    private static final Dotenv dotenv = Dotenv.load();
    public Currency convert(double value, String actualCurrency, String convertedCurrency){
        URI address = URI.create("https://v6.exchangerate-api.com/v6/" + dotenv.get("API_KEY") + "/pair/" + actualCurrency + "/" + convertedCurrency + "/" + value);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(address)
                .build();

        HttpResponse<String> response = null;

        try{
            response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            Currency currencyData = new Gson().fromJson(response.body(), Currency.class);
            return new Currency(value, currencyData.conversion_result(), currencyData.base_code(), currencyData.target_code());
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
