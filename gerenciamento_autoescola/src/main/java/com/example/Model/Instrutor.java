package com.example.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Instrutor {
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String disponibilidade;


    public Instrutor(int id, String nome, String cpf, String telefone, String disponibilidade) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.disponibilidade = disponibilidade;
    }

}
