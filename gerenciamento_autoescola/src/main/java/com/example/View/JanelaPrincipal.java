package com.example.View;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class JanelaPrincipal extends JFrame {
    public JanelaPrincipal(){
        super("Autoescola");
        setDefaultCloseOperation(2);
        JTabbedPane abas = new JTabbedPane();
        abas.add("Alunos", new JanelaAlunos());
        
        abas.add("Instrutores", new JanelaInstrutores());
        
        abas.add("Veiculos", new JanelaVeiculos());

        abas.add("Cursos", new JanelaCurso());
        this.add(abas);
        setBounds(300, 250, 1400, 600);
        setResizable(false);
    }

    public void run(){
        setVisible(true);
    }
    
}