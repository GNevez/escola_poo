package dao;

import models.Curso;
import models.CursoInsert;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

    public List<Curso> listarCursos() {
        List<Curso> cursos = new ArrayList<>();

        String sql = "SELECT * FROM cursos"; 

        try (Connection conexao = ConexaoDB.getConnection();
             Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Curso curso = new Curso(
                        rs.getInt("codigo"),
                        rs.getString("nome"),
                        rs.getString("sigla")
                );
                cursos.add(curso);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cursos;
    }

    public boolean inserirCurso(CursoInsert curso) {
        String sql = "INSERT INTO cursos (nome, sigla) VALUES (?, ?)";

        try (Connection conexao = ConexaoDB.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getSigla());
//            stmt.setInt(3, curso.getIdDisciplina());

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
