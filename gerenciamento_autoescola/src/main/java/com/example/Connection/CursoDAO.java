package com.example.Connection;

import com.example.Model.Curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {
    private Connection connection;

    private String url = "jdbc:postgresql://localhost:5432/autoescola";
    private String user = "postgres";
    private String password = "postgres";

    public CursoDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    //criar Tabela
    public void criaTabela() {

        String sql = "CREATE TABLE IF NOT EXISTS cursos ( id SERIAL PRIMARY KEY,\n" + //
                        "    periodo VARCHAR(50),\n" + //
                        "    aluno_id INT REFERENCES alunos(id),\n" + //
                        "    instrutor_id INT REFERENCES instrutores(id),\n" + //
                        "    veiculo_id INT REFERENCES veiculos(id)";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    public void save(Curso curso) {
        String sql = "INSERT INTO cursos (periodo, aluno_id, instrutor_id, veiculo_id) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, curso.getPeriodo());
            stmt.setInt(2, curso.getAluno_id());
            stmt.setInt(3, curso.getInstrutor_id());
            stmt.setInt(4, curso.getVeiculo_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Curso getById(int id) {
        String sql = "SELECT * FROM cursos WHERE id = ?";
        Curso curso = null;

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                curso = new Curso(
                    rs.getInt("id"),
                    rs.getString("periodo"),
                    rs.getInt("aluno_id"),
                    rs.getInt("instrutor_id"),
                    rs.getInt("veiculo_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return curso;
    }

    public List<Curso> getAll() {
        String sql = "SELECT * FROM cursos";
        List<Curso> cursos = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
             
            while (rs.next()) {
                Curso curso = new Curso(
                    rs.getInt("id"),
                    rs.getString("periodo"),
                    rs.getInt("aluno_id"),
                    rs.getInt("instrutor_id"),
                    rs.getInt("veiculo_id")
                );
                cursos.add(curso);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cursos;
    }

    public void update(Curso curso) {
        String sql = "UPDATE cursos SET periodo = ?, aluno_id = ?, instrutor_id = ?, veiculo_id = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, curso.getPeriodo());
            stmt.setInt(2, curso.getAluno_id());
            stmt.setInt(3, curso.getInstrutor_id());
            stmt.setInt(4, curso.getVeiculo_id());
            stmt.setInt(5, curso.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM cursos WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
