package com.example.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Aluno {
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String habilitacao;


    public Aluno(int id, String nome, String cpf, String telefone, String habilitacao) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.habilitacao = habilitacao;
    }


    
}
