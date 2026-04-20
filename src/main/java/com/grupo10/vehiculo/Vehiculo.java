package com.grupo10.vehiculo;

public class Vehiculo {

    private String marca;
    private String modelo;
    private int velocidadActual;
    private int velocidadMaxima;

    public Vehiculo(String marca, String modelo, int velocidadMaxima) {
        if (velocidadMaxima <= 0) {
            throw new IllegalArgumentException("La velocidad máxima debe ser mayor que 0");
        }
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadMaxima = velocidadMaxima;
        this.velocidadActual = 0;
    }

    public void acelerar(int incremento) {
        if (incremento <= 0) return;
        velocidadActual = Math.min(velocidadActual + incremento, velocidadMaxima);
    }

    public void frenar(int decremento) {
        if (decremento <= 0) return;
        velocidadActual = Math.max(velocidadActual - decremento, 0);
    }

    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getVelocidadActual() { return velocidadActual; }
    public int getVelocidadMaxima() { return velocidadMaxima; }

    @Override
    public String toString() {
        return marca + " " + modelo + " | Velocidad: " + velocidadActual + "/" + velocidadMaxima + " km/h";
    }
}
