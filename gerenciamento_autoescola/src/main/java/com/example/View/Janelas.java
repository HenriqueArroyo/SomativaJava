package com.example.View;

import com.example.View.VeiculoView;
import com.example.View.CursoView;

import javax.swing.*;

public class Janelas {
  public void run() {
      // Cria e exibe a janela de Veículos
      VeiculoView veiculoView = new VeiculoView();
      veiculoView.setVisible(true);
      veiculoView.setBounds(100, 350,500, 300);
      veiculoView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas a janela de veículos

      // Cria e exibe a janela de Cursos
      CursoView cursoView = new CursoView();
      cursoView.setVisible(true);
      cursoView.setBounds(600, 350,500, 300); // Define a posição da janela de cursos abaixo da janela de veículos
      cursoView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas a janela de cursos

      AlunoView alunoView = new AlunoView();
      alunoView.setVisible(true);
      alunoView.setBounds(100, 50,500, 300); // Define a posição da janela de alunos abaixo das janelas de veículos e cursos
      alunoView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

      InstrutorView instrutorView = new InstrutorView();
      instrutorView.setVisible(true);
      instrutorView.setBounds(600, 50,500, 300); // Define a posição da janela de instrutores abaixo das janelas de veículos, cursos e alunos
      instrutorView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }
          
        
    }

