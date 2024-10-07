package com.example.Controller;

import com.example.Connection.VeiculoDAO;
import com.example.Model.Veiculo;

import java.util.List;

public class VeiculoController {
    private final VeiculoDAO veiculoDAO;

    public VeiculoController() {
        this.veiculoDAO = new VeiculoDAO();
    }

    public void addVeiculo(Veiculo veiculo) {
        veiculoDAO.save(veiculo);
    }

    public Veiculo getVeiculoById(int id) {
        return veiculoDAO.getById(id);
    }

    public List<Veiculo> getAllVeiculos() {
        return veiculoDAO.getAll();
    }

    public void updateVeiculo(Veiculo veiculo) {
        veiculoDAO.update(veiculo);
    }

    public void deleteVeiculo(int id) {
        veiculoDAO.delete(id);
    }

    public void createTable() {
        veiculoDAO.criaTabela();
    }
}
