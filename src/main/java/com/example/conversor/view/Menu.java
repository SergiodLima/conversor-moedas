package com.example.conversor.view;

import com.example.conversor.model.Moeda;
import com.example.conversor.service.ApiService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private ApiService apiService = new ApiService();
    private Scanner scanner = new Scanner(System.in);

    public void exibirMenu() {
        int opcao = 0;
        while (opcao != 9) {
            System.out.println("\n***********************************************************************");
            System.out.println("\nDigite a opção para fazer a conversão da moeda:\n");
            System.out.println("1- Dolar para Real.");
            System.out.println("2- Real para Dolar.");
            System.out.println("3- Real para Peso Argentino.");
            System.out.println("4- Peso Argentino para Real.");
            System.out.println("5- Real para Euro.");
            System.out.println("6- Euro para Real.");
            System.out.println("7- Real para Franco Suiço");
            System.out.println("8- Franco Suiço para Real.");
            System.out.println("9- Sair.");
            System.out.println("\n***********************************************************************");

            try {
                opcao = scanner.nextInt();
                processarOpcao(opcao);
            } catch (InputMismatchException e) {
                System.out.println("Selecione uma opção válida ou só aceita valores numéricos.");
                scanner.next(); // Limpa o buffer do scanner
            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }

    private void processarOpcao(int opcao) throws Exception {
        if (opcao >= 1 && opcao <= 8) {
            System.out.print("Digite o valor a ser convertido: ");
            double valor = scanner.nextDouble();
            String moedaOrigem = "";
            String moedaDestino = "";

            switch (opcao) {
                case 1: moedaOrigem = "USD"; moedaDestino = "BRL"; break;
                case 2: moedaOrigem = "BRL"; moedaDestino = "USD"; break;
                case 3: moedaOrigem = "BRL"; moedaDestino = "ARS"; break;
                case 4: moedaOrigem = "ARS"; moedaDestino = "BRL"; break;
                case 5: moedaOrigem = "BRL"; moedaDestino = "EUR"; break;
                case 6: moedaOrigem = "EUR"; moedaDestino = "BRL"; break;
                case 7: moedaOrigem = "BRL"; moedaDestino = "CHF"; break;
                case 8: moedaOrigem = "CHF"; moedaDestino = "BRL"; break;
            }

            Moeda taxa = apiService.getTaxaDeCambio(moedaOrigem, moedaDestino);
            double valorConvertido = valor * taxa.getTaxaDeCambio();

            System.out.printf("O valor convertido é de %.2f %s\n", valorConvertido, moedaDestino);

        } else if (opcao != 9) {
            System.out.println("Selecione uma opção válida.");
        }
    }
}