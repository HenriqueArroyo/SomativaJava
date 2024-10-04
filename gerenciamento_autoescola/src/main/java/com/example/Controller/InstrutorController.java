package com.example.Controller;

import com.example.Model.Instrutor;
import com.example.Connection.InstrutorDAO;

import javax.swing.*;
import java.util.List;

public class InstrutorController {

    private InstrutorDAO instrutorDAO;

    public InstrutorController() {
        this.instrutorDAO = new InstrutorDAO();
    }

    // Método para salvar um instrutor
    public void saveInstrutor(String nome, String cpf, String telefone, String disponibilidade) {
        Instrutor instrutor = new Instrutor(0, nome, cpf, telefone, disponibilidade); // ID será gerado pelo banco
        instrutorDAO.save(instrutor);
        JOptionPane.showMessageDialog(null, "Instrutor cadastrado com sucesso!");
    }

    // Método para listar todos os instrutores
    public List<Instrutor> listInstrutores() {
        return instrutorDAO.getAll();
    }

    // Método para atualizar um instrutor
    public void updateInstrutor(int id, String nome, String cpf, String telefone, String disponibilidade) {
        Instrutor instrutor = new Instrutor(id, nome, cpf, telefone, disponibilidade);
        instrutorDAO.update(instrutor);
        JOptionPane.showMessageDialog(null, "Instrutor atualizado com sucesso!");
    }

    // Método para deletar um instrutor
    public void deleteInstrutor(int id) {
        instrutorDAO.delete(id);
        JOptionPane.showMessageDialog(null, "Instrutor deletado com sucesso!");
    }

    // Método para buscar instrutor por ID
    public Instrutor getInstrutorById(int id) {
        return instrutorDAO.getById(id);
    }
}
