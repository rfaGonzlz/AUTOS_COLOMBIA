package edu.iudigital;

public class Vehiculo {

    private String placa;
    private String tipo;
    private String marca;
    private String color;

    // Se crea la clase vehiculo con sus atributos

    public Vehiculo(String placa, String tipo, String marca, String color) {
        this.placa = placa;
        this.tipo = tipo;
        this.marca = marca;
        this.color = color;
    }

    // Se crean los getter

    public String getPlaca() {
        return placa;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMarca() {
        return marca;
    }

    public String getColor() {
        return color;
    }
}
