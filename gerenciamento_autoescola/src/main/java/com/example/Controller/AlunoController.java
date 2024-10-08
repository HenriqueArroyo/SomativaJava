package com.example.Controller;

import com.example.Model.Aluno;
import com.example.Connection.AlunosDAO;

import javax.swing.*;
import java.util.List;

public class AlunoController {

    private AlunosDAO alunosDAO;

    public AlunoController() {
        this.alunosDAO = new AlunosDAO();
    }

    // Método para salvar um aluno
    public void saveAluno(String nome, String cpf, String telefone, String habilitacao) {
        Aluno aluno = new Aluno(0, nome, cpf, telefone, habilitacao); // id será gerado pelo banco
        alunosDAO.save(aluno);
        JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");
    }

    // Método para listar todos os alunos
    public List<Aluno> listAlunos() {
        return alunosDAO.getAll();
    }

    // Método para atualizar um aluno
    public void updateAluno(int id, String nome, String cpf, String telefone, String habilitacao) {
        Aluno aluno = new Aluno(id, nome, cpf, telefone, habilitacao);
        alunosDAO.update(aluno);
        JOptionPane.showMessageDialog(null, "Aluno atualizado com sucesso!");
    }

    // Método para deletar um aluno
    public void deleteAluno(int id) {
        alunosDAO.delete(id);
        JOptionPane.showMessageDialog(null, "Aluno deletado com sucesso!");
    }

    public Aluno getAlunoById(int id) {
        Aluno aluno = alunosDAO.getById(id);
        if (aluno == null) {
            JOptionPane.showMessageDialog(null, "Aluno não encontrado!");
        }
        return aluno;
    }
}
