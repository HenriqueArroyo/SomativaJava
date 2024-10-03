package com.example.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Curso {
    private int id;
    private String periodo;
    private int aluno_id;
    private int instrutor_id;
    private int veiculo_id;

    public Curso(int id, String periodo, int aluno_id, int instrutor_id, int veiculo_id) {
        this.id = id;
        this.periodo = periodo;
        this.aluno_id = aluno_id;
        this.instrutor_id = instrutor_id;
        this.veiculo_id = veiculo_id;
    }
}
