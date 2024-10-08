package com.example.Connection;

import com.example.Model.Veiculo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO {
    private Connection connection;

    private String url = "jdbc:postgresql://localhost:5432/postgres";
    private String user = "postgres";
    private String password = "postgres";

    public VeiculoDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

     public void criaTabela() {

        String sql = "CREATE TABLE IF NOT EXISTS veiculos ( id SERIAL PRIMARY KEY,\n" + //
                        "    modelo VARCHAR(255),\n" + //
                        "    ano VARCHAR(4),\n" + //
                        "    placa VARCHAR(10),\n" + //
                        "    tipo VARCHAR(50))";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    public void save(Veiculo veiculo) {
        String sql = "INSERT INTO veiculos (modelo, ano, placa, tipo) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, veiculo.getModelo());
            stmt.setString(2, veiculo.getAno());
            stmt.setString(3, veiculo.getPlaca());
            stmt.setString(4, veiculo.getTipo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Veiculo getById(int id) {
        String sql = "SELECT * FROM veiculos WHERE id = ?";
        Veiculo veiculo = null;

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                veiculo = new Veiculo(
                    rs.getInt("id"),
                    rs.getString("modelo"),
                    rs.getString("ano"),
                    rs.getString("placa"),
                    rs.getString("tipo")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return veiculo;
    }

    public List<Veiculo> getAll() {
        String sql = "SELECT * FROM veiculos";
        List<Veiculo> veiculos = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
             
            while (rs.next()) {
                Veiculo veiculo = new Veiculo(
                    rs.getInt("id"),
                    rs.getString("modelo"),
                    rs.getString("ano"),
                    rs.getString("placa"),
                    rs.getString("tipo")
                );
                veiculos.add(veiculo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return veiculos;
    }

    public void update(Veiculo veiculo) {
        String sql = "UPDATE veiculos SET modelo = ?, ano = ?, placa = ?, tipo = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, veiculo.getModelo());
            stmt.setString(2, veiculo.getAno());
            stmt.setString(3, veiculo.getPlaca());
            stmt.setString(4, veiculo.getTipo());
            stmt.setInt(5, veiculo.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM veiculos WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}
