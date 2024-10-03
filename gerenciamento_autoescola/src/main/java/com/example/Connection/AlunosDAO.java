package com.example.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.example.Model.Aluno;


public class AlunosDAO {

    // atributo
    private Connection connection;


    private String url = "jdbc:postgresql://localhost:5432/autoescola";
    private String user = "postgres";
    private String password = "postgres";

    // construtor
    public AlunosDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    //criar Tabela
    public void criaTabela() {

        String sql = "CREATE TABLE IF NOT EXISTS alunos (id SERIAL PRIMARY KEY,\n" + //
                        "    nome VARCHAR(255),\n" + //
                        "    cpf VARCHAR(14),\n" + //
                        "    telefone VARCHAR(15),\n" + //
                        "    habilitacao VARCHAR(50))";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    // Listar todos os valores cadastrados
     public List<Aluno> getAll() {
        String sql = "SELECT * FROM alunos";
        List<Aluno> alunos = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
             
            while (rs.next()) {
                Aluno aluno = new Aluno(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("telefone"),
                    rs.getString("habilitacao")
                );
                alunos.add(aluno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return alunos;
    }

    //Cadastrar Carro no banco
    public void save(Aluno aluno) {
        String sql = "INSERT INTO alunos (nome, cpf, telefone, habilitacao) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setString(3, aluno.getTelefone());
            stmt.setString(4, aluno.getHabilitacao());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Atualizar dados no banco
    public void update(Aluno aluno) {
        String sql = "UPDATE alunos SET nome = ?, cpf = ?, telefone = ?, habilitacao = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setString(3, aluno.getTelefone());
            stmt.setString(4, aluno.getHabilitacao());
            stmt.setInt(5, aluno.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(int id) {
        String sql = "DELETE FROM alunos WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}