package com.example.View;

import com.example.View.VeiculoView;
import com.example.View.CursoView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame mainFrame = new JFrame("Gerenciador de Veículos e Cursos");
            mainFrame.setSize(600, 400);
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JTabbedPane tabbedPane = new JTabbedPane();

            // Cria e adiciona o painel de Veículos
            VeiculoView veiculoView = new VeiculoView();
            tabbedPane.addTab("Veículos", veiculoView);

            // Cria e adiciona o painel de Cursos
            CursoView cursoView = new CursoView();
            tabbedPane.addTab("Cursos", cursoView);



            // Adiciona o JTabbedPane ao frame principal
            mainFrame.add(tabbedPane);
            mainFrame.setVisible(true);
        });
    }
}


