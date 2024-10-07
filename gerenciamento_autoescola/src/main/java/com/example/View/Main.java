package com.example.View;

import com.example.View.VeiculoView;
import com.example.View.CursoView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Cria e exibe a janela de Veículos
            VeiculoView veiculoView = new VeiculoView();
            veiculoView.setVisible(true);
            veiculoView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas a janela de veículos

            // Cria e exibe a janela de Cursos
            CursoView cursoView = new CursoView();
            cursoView.setVisible(true);
            cursoView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas a janela de cursos

            AlunoView alunoView = new AlunoView();
            alunoView.setVisible(true);
            alunoView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            InstrutorView instrutorView = new InstrutorView();
            instrutorView.setVisible(true);
            instrutorView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        });
    }
}
