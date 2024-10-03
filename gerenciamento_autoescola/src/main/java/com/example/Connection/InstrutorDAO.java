package com.example.Connection;

import com.example.Model.Instrutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InstrutorDAO {
    private Connection connection;

    private String url = "jdbc:postgresql://localhost:5432/autoescola";
    private String user = "postgres";
    private String password = "postgres";

    public InstrutorDAO() {
        this.connection = ConnectionFactory.getConnection();
    }
     
     //criar Tabela
    public void criaTabela() {

        String sql = "CREATE TABLE IF NOT EXISTS instrutores ( id SERIAL PRIMARY KEY, nome VARCHAR(255), cpf VARCHAR(14),  telefone VARCHAR(15),    disponibilidade VARCHAR(50));";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    public void save(Instrutor instrutor) {
        String sql = "INSERT INTO instrutores (nome, cpf, telefone, disponibilidade) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, instrutor.getNome());
            stmt.setString(2, instrutor.getCpf());
            stmt.setString(3, instrutor.getTelefone());
            stmt.setString(4, instrutor.getDisponibilidade());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Instrutor getById(int id) {
        String sql = "SELECT * FROM instrutores WHERE id = ?";
        Instrutor instrutor = null;

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                instrutor = new Instrutor(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("telefone"),
                    rs.getString("disponibilidade")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return instrutor;
    }

    public List<Instrutor> getAll() {
        String sql = "SELECT * FROM instrutores";
        List<Instrutor> instrutores = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
             
            while (rs.next()) {
                Instrutor instrutor = new Instrutor(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("telefone"),
                    rs.getString("disponibilidade")
                );
                instrutores.add(instrutor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return instrutores;
    }

    public void update(Instrutor instrutor) {
        String sql = "UPDATE instrutores SET nome = ?, cpf = ?, telefone = ?, disponibilidade = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, instrutor.getNome());
            stmt.setString(2, instrutor.getCpf());
            stmt.setString(3, instrutor.getTelefone());
            stmt.setString(4, instrutor.getDisponibilidade());
            stmt.setInt(5, instrutor.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM instrutores WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
