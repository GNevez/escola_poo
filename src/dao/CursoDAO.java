package dao;

import models.Curso;

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
}
