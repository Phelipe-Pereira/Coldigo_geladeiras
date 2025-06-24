package com.example.projetotrilhawebinte.modelo;

public class Produto {
    private int id;
    private String modelo;
    private int capacidade;
    private double valor;
    private byte categoria;
    private int idMarca;

    public Produto() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public int getCapacidade() { return capacidade; }
    public void setCapacidade(int capacidade) { this.capacidade = capacidade; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public byte getCategoria() { return categoria; }
    public void setCategoria(int categoria) { this.categoria = (byte) categoria; }

    public int getIdMarca() { return idMarca; }
    public void setIdMarca(int idMarca) { this.idMarca = idMarca; }
}
