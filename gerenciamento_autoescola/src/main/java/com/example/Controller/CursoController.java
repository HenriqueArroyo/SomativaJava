package com.example.Controller;

import com.example.Connection.CursoDAO;
import com.example.Model.Curso;

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
}
