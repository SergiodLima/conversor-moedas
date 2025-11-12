package com.example.conversor.model;

public class Moeda extends Conversao {
    private String nome;
    private String simbolo;

    public Moeda(String nome, String simbolo) {
        this.nome = nome;
        this.simbolo = simbolo;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String getSimbolo() {
        return simbolo;
    }
}