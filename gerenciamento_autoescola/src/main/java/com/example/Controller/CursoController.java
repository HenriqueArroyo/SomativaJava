package com.example.Controller;

import com.example.Connection.CursoDAO;
import com.example.Model.Aluno;
import com.example.Model.Curso;
import com.example.Model.Instrutor;
import com.example.Model.Veiculo;

import java.util.List;

public class CursoController {
    private final CursoDAO cursoDAO;

    public CursoController() {
        this.cursoDAO = new CursoDAO();
    }

    public void addCurso(Curso curso) {
        cursoDAO.save(curso);
    }

    public Curso getCursoById(int id) {
        return cursoDAO.getById(id);
    }

    public List<Curso> getAllCursos() {
        return cursoDAO.getAll();
    }

    public void updateCurso(Curso curso) {
        cursoDAO.update(curso);
    }

    public void deleteCurso(int id) {
        cursoDAO.delete(id);
    }

    public void createTable() {
        cursoDAO.criaTabela();
    }

     public List<Aluno> listAlunos() {
        return cursoDAO.listarAlunos();
    }

    public List<Instrutor> listInstrutores() {
        return cursoDAO.listarInstrutores(); //;
    }

     public List<Veiculo> listVeiculos() {
       return cursoDAO.listarVeiculos();
     }
}
