package com.example.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Veiculo {
    private int id;
    private String modelo;
    private String ano;
    private String placa;
    private String tipo;
    //Métodos
    public Veiculo(int id, String modelo, String ano, String placa, String tipo) {
        this.id = id;
        this.modelo = modelo;
        this.ano = ano;
        this.tipo = tipo;
        this.placa = placa;
    }
}
