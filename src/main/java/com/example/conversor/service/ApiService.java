package com.example.conversor.service;

import com.example.conversor.model.Moeda;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {

    public Moeda getTaxaDeCambio(String moedaOrigem, String moedaDestino) throws IOException, InterruptedException {
        String apiKey = "f62276d1869229bbeedbb506";
        String url_str = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + moedaOrigem;


        HttpClient client = HttpClient.newHttpClient();


        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url_str))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                throw new RuntimeException("Falha na comunicação com a API: Código " + response.statusCode());
            }
            JsonParser jp = new JsonParser();
            JsonObject root = jp.parse(response.body()).getAsJsonObject();
            JsonObject conversionRates = root.getAsJsonObject("conversion_rates");

            if (conversionRates.has(moedaDestino)) {
                double taxa = conversionRates.get(moedaDestino).getAsDouble();
                Moeda moeda = new Moeda(moedaDestino, "");
                moeda.setTaxaDeCambio(taxa);
                return moeda;
            } else {
                throw new RuntimeException("Moeda de destino não encontrada na resposta da API.");
            }

        } catch (IOException | InterruptedException e) {
            System.err.println("Erro ao fazer a requisição: " + e.getMessage());
            throw new RuntimeException("Não foi possível fazer a conversão da moeda, programa finalizado.");
        }
    }
}