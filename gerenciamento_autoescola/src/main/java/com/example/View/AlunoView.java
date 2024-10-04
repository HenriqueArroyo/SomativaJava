package com.example.View;

import com.example.Controller.AlunoController;
import com.example.Model.Aluno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AlunoView extends JFrame {
    private AlunoController alunoController;

    private JTextField txtNome;
    private JTextField txtCpf;
    private JTextField txtTelefone;
    private JTextField txtHabilitacao;
    private JTextField txtId;

    public AlunoView() {
        alunoController = new AlunoController();
        initComponents();
    }

    private void initComponents() {
        setTitle("Cadastro de Alunos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 5));

        txtId = new JTextField();
        txtNome = new JTextField();
        txtCpf = new JTextField();
        txtTelefone = new JTextField();
        txtHabilitacao = new JTextField();

        
        add(new JLabel("Nome:"));
        add(txtNome);
        add(new JLabel("CPF:"));
        add(txtCpf);
        add(new JLabel("Telefone:"));
        add(txtTelefone);
        add(new JLabel("Habilitação:"));
        add(txtHabilitacao);

        JButton btnSave = new JButton("Salvar");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alunoController.saveAluno(txtNome.getText(), txtCpf.getText(), txtTelefone.getText(), txtHabilitacao.getText());
                clearFields();
            }
        });
        add(new JLabel("ID (Edição/Remoção):"));
        add(txtId);
        
        JButton btnUpdate = new JButton("Atualizar");
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(txtId.getText());
                alunoController.updateAluno(id, txtNome.getText(), txtCpf.getText(), txtTelefone.getText(), txtHabilitacao.getText());
                clearFields();
            }
        });
        
        JButton btnDelete = new JButton("Deletar");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(txtId.getText());
                alunoController.deleteAluno(id);
                clearFields();
            }
        });
        
        JButton btnList = new JButton("Listar");
        btnList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Aluno> alunos = alunoController.listAlunos();
                StringBuilder sb = new StringBuilder();
                for (Aluno aluno : alunos) {
                    sb.append("ID: ").append(aluno.getId()).append(", Nome: ").append(aluno.getNome()).append(", Habilitacão: ").append(aluno.getHabilitacao()).append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString());
            }
        });

        add(btnSave);
        add(btnUpdate);
        add(btnDelete);
        add(btnList);

        setVisible(true);
    }

    private void clearFields() {
        txtId.setText("");
        txtNome.setText("");
        txtCpf.setText("");
        txtTelefone.setText("");
        txtHabilitacao.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AlunoView::new);
    }
}
