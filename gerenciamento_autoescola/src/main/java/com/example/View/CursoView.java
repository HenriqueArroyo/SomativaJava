package com.example.View;

import com.example.Controller.CursoController;
import com.example.Model.Curso;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CursoView extends JFrame {
    private final CursoController controller;

    private JTextField idField;
    private JTextField periodoField;
    private JTextField alunoIdField;
    private JTextField instrutorIdField;
    private JTextField veiculoIdField;

    public CursoView() {
        controller = new CursoController();
        initUI();
    }

    private void initUI() {
        setTitle("Gerenciador de Cursos");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 5));

        add(new JLabel("ID:"));
        idField = new JTextField();
        add(idField);

        add(new JLabel("Período:"));
        periodoField = new JTextField();
        add(periodoField);

        add(new JLabel("ID do Aluno:"));
        alunoIdField = new JTextField();
        add(alunoIdField);

        add(new JLabel("ID do Instrutor:"));
        instrutorIdField = new JTextField();
        add(instrutorIdField);

        add(new JLabel("ID do Veículo:"));
        veiculoIdField = new JTextField();
        add(veiculoIdField);

        JButton addButton = new JButton("Adicionar");
        addButton.addActionListener(new AddButtonListener());
        add(addButton);

        JButton updateButton = new JButton("Atualizar");
        updateButton.addActionListener(new UpdateButtonListener());
        add(updateButton);

        JButton deleteButton = new JButton("Excluir");
        deleteButton.addActionListener(new DeleteButtonListener());
        add(deleteButton);

        JButton listButton = new JButton("Listar Cursos");
        listButton.addActionListener(new ListButtonListener());
        add(listButton);
    }

    private void clearFields() {
        idField.setText("");
        periodoField.setText("");
        alunoIdField.setText("");
        instrutorIdField.setText("");
        veiculoIdField.setText("");
    }

    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String periodo = periodoField.getText();
            int alunoId = Integer.parseInt(alunoIdField.getText());
            int instrutorId = Integer.parseInt(instrutorIdField.getText());
            int veiculoId = Integer.parseInt(veiculoIdField.getText());
            Curso curso = new Curso(0, periodo, alunoId, instrutorId, veiculoId);
            controller.addCurso(curso);
            clearFields();
            JOptionPane.showMessageDialog(null, "Curso adicionado com sucesso!");
        }
    }

    private class UpdateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = Integer.parseInt(idField.getText());
            String periodo = periodoField.getText();
            int alunoId = Integer.parseInt(alunoIdField.getText());
            int instrutorId = Integer.parseInt(instrutorIdField.getText());
            int veiculoId = Integer.parseInt(veiculoIdField.getText());
            Curso curso = new Curso(id, periodo, alunoId, instrutorId, veiculoId);
            controller.updateCurso(curso);
            clearFields();
            JOptionPane.showMessageDialog(null, "Curso atualizado com sucesso!");
        }
    }

    private class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = Integer.parseInt(idField.getText());
            controller.deleteCurso(id);
            clearFields();
            JOptionPane.showMessageDialog(null, "Curso excluído com sucesso!");
        }
    }

    private class ListButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<Curso> cursos = controller.getAllCursos();
            StringBuilder sb = new StringBuilder("Lista de Cursos:\n");
            for (Curso c : cursos) {
                sb.append(c.getId()).append(" - ").append(c.getPeriodo()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CursoView view = new CursoView();
            view.setVisible(true);
        });
    }
}
