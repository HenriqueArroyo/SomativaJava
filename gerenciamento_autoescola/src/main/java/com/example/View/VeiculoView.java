package com.example.View;

import com.example.Controller.VeiculoController;
import com.example.Model.Veiculo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VeiculoView extends JFrame {
    private final VeiculoController controller;

    private JTextField modeloField;
    private JTextField anoField;
    private JTextField placaField;
    private JTextField tipoField;
    private JTextField idField;

    public VeiculoView() {
        controller = new VeiculoController();
        initUI();
    }

    private void initUI() {
        setTitle("Gerenciador de Veículos");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 5));

        add(new JLabel("ID:"));
        idField = new JTextField();
        add(idField);

        add(new JLabel("Modelo:"));
        modeloField = new JTextField();
        add(modeloField);

        add(new JLabel("Ano:"));
        anoField = new JTextField();
        add(anoField);

        add(new JLabel("Placa:"));
        placaField = new JTextField();
        add(placaField);

        add(new JLabel("Tipo:"));
        tipoField = new JTextField();
        add(tipoField);

        JButton addButton = new JButton("Adicionar");
        addButton.addActionListener(new AddButtonListener());
        add(addButton);

        JButton updateButton = new JButton("Atualizar");
        updateButton.addActionListener(new UpdateButtonListener());
        add(updateButton);

        JButton deleteButton = new JButton("Excluir");
        deleteButton.addActionListener(new DeleteButtonListener());
        add(deleteButton);

        JButton listButton = new JButton("Listar Veículos");
        listButton.addActionListener(new ListButtonListener());
        add(listButton);
    }

    private void clearFields() {
        idField.setText("");
        modeloField.setText("");
        anoField.setText("");
        placaField.setText("");
        tipoField.setText("");
    }

    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String modelo = modeloField.getText();
            String ano = anoField.getText();
            String placa = placaField.getText();
            String tipo = tipoField.getText();
            Veiculo veiculo = new Veiculo(0, modelo, ano, placa, tipo);
            controller.addVeiculo(veiculo);
            clearFields();
            JOptionPane.showMessageDialog(null, "Veículo adicionado com sucesso!");
        }
    }

    private class UpdateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = Integer.parseInt(idField.getText());
            String modelo = modeloField.getText();
            String ano = anoField.getText();
            String placa = placaField.getText();
            String tipo = tipoField.getText();
            Veiculo veiculo = new Veiculo(id, modelo, ano, placa, tipo);
            controller.updateVeiculo(veiculo);
            clearFields();
            JOptionPane.showMessageDialog(null, "Veículo atualizado com sucesso!");
        }
    }

    private class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = Integer.parseInt(idField.getText());
            controller.deleteVeiculo(id);
            clearFields();
            JOptionPane.showMessageDialog(null, "Veículo excluído com sucesso!");
        }
    }

    private class ListButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<Veiculo> veiculos = controller.getAllVeiculos();
            StringBuilder sb = new StringBuilder("Lista de Veículos:\n");
            for (Veiculo v : veiculos) {
                sb.append(v.getId()).append(" - ").append(v.getModelo()).append(" ").append(v.getAno()).append(" - ").append(v.getPlaca()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VeiculoView view = new VeiculoView();
            view.setVisible(true);
        });
    }
}
