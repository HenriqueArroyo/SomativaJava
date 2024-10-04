package com.example.View;

import com.example.Controller.InstrutorController;
import com.example.Model.Instrutor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class InstrutorView extends JFrame {
    private InstrutorController instrutorController;

    private JTextField txtId;
    private JTextField txtNome;
    private JTextField txtCpf;
    private JTextField txtTelefone;
    private JComboBox<String> cmbDisponibilidade; // ComboBox para Disponibilidade

    public InstrutorView() {
        instrutorController = new InstrutorController();
        initComponents();
    }

    private void initComponents() {
        setTitle("Cadastro de Instrutores");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 5));

        txtId = new JTextField();
        txtNome = new JTextField();
        txtCpf = new JTextField();
        txtTelefone = new JTextField();
        
        // Inicializa o JComboBox com as opções
        cmbDisponibilidade = new JComboBox<>(new String[] { "Disponível", "Indisponível" });

        add(new JLabel("ID:"));
        add(txtId);
        add(new JLabel("Nome:"));
        add(txtNome);
        add(new JLabel("CPF:"));
        add(txtCpf);
        add(new JLabel("Telefone:"));
        add(txtTelefone);
        add(new JLabel("Disponibilidade:"));
        add(cmbDisponibilidade); // Adiciona o ComboBox

        JButton btnSave = new JButton("Salvar");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                instrutorController.saveInstrutor(txtNome.getText(), txtCpf.getText(), txtTelefone.getText(), (String) cmbDisponibilidade.getSelectedItem());
                clearFields();
            }
        });

        JButton btnUpdate = new JButton("Atualizar");
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(txtId.getText());
                instrutorController.updateInstrutor(id, txtNome.getText(), txtCpf.getText(), txtTelefone.getText(), (String) cmbDisponibilidade.getSelectedItem());
                clearFields();
            }
        });

        JButton btnDelete = new JButton("Deletar");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(txtId.getText());
                instrutorController.deleteInstrutor(id);
                clearFields();
            }
        });

        JButton btnList = new JButton("Listar");
        btnList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Instrutor> instrutores = instrutorController.listInstrutores();
                StringBuilder sb = new StringBuilder();
                for (Instrutor instrutor : instrutores) {
                    sb.append("ID: ").append(instrutor.getId()).append(", Nome: ").append(instrutor.getNome()).append(", Disponibilidade: ").append(instrutor.getDisponibilidade()).append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString());
            }
        });

        JButton btnSearch = new JButton("Buscar");
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(txtId.getText());
                Instrutor instrutor = instrutorController.getInstrutorById(id);
                if (instrutor != null) {
                    txtNome.setText(instrutor.getNome());
                    txtCpf.setText(instrutor.getCpf());
                    txtTelefone.setText(instrutor.getTelefone());
                    cmbDisponibilidade.setSelectedItem(instrutor.getDisponibilidade()); // Seleciona a opção correta no ComboBox
                } else {
                    JOptionPane.showMessageDialog(null, "Instrutor não encontrado.");
                }
            }
        });

        add(btnSave);
        add(btnUpdate);
        add(btnDelete);
        add(btnList);
        add(btnSearch);

        setVisible(true);
    }

    private void clearFields() {
        txtId.setText("");
        txtNome.setText("");
        txtCpf.setText("");
        txtTelefone.setText("");
        cmbDisponibilidade.setSelectedIndex(0); // Reseta o ComboBox para a primeira opção
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(InstrutorView::new);
    }
}
