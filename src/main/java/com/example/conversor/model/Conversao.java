package com.example.conversor.model;

public abstract class Conversao {
    private double taxaDeCambio;

    public double getTaxaDeCambio() {
        return taxaDeCambio;
    }

    public void setTaxaDeCambio(double taxaDeCambio) {
        this.taxaDeCambio = taxaDeCambio;
    }

    public abstract String getSimbolo();
}