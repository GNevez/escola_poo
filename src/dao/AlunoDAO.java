package dao;

import models.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlunoDAO {

    // Método para inserir aluno no banco de dados
    public boolean inserirAluno(Aluno aluno) {
        // SQL modificado para incluir o curso_id
        String sql = "INSERT INTO alunos (nome, endereco, telefone, filiacao, data_nascimento, curso_id) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conexao = ConexaoDB.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEndereco());
            stmt.setString(3, aluno.getTelefone());
            stmt.setString(4, aluno.getFiliacao());
            stmt.setString(5, aluno.getDataNascimento());
            stmt.setInt(6, aluno.getCursoId()); // Atribuindo o curso_id aqui

            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Erro ao inserir aluno: " + e.getMessage());
            return false;
        }
    }
}
