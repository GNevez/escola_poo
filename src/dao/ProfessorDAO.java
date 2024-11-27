package dao;

import models.Professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {

    public static boolean salvarProfessor(Professor professor) {
        String sqlProfessor = "INSERT INTO professores (nome, formacao, endereco, telefone, departamento_id) VALUES (?, ?, ?, ?, ?)";
        String sqlRelacao = "INSERT INTO professor_disciplina (professor_id, disciplina_id) VALUES (?, ?)";
        String sqlBuscaDisciplinaId = "SELECT codigo, departamento_id FROM disciplinas WHERE denominacao = ?";

        Connection conn = null;
        PreparedStatement stmtProfessor = null;
        PreparedStatement stmtRelacao = null;
        PreparedStatement stmtBuscaDisciplinaId = null;
        ResultSet rsDisciplinaId = null;

        try {
            conn = ConexaoDB.getConnection();
            conn.setAutoCommit(false); 

            stmtBuscaDisciplinaId = conn.prepareStatement(sqlBuscaDisciplinaId);
            stmtBuscaDisciplinaId.setString(1, professor.getDisciplina());
            rsDisciplinaId = stmtBuscaDisciplinaId.executeQuery();
            if (!rsDisciplinaId.next()) {
                throw new SQLException("Disciplina não encontrada no banco de dados.");
            }
            int disciplinaId = rsDisciplinaId.getInt("codigo");
            int departamentoId = rsDisciplinaId.getInt("departamento_id");

            // Inserção na tabela 'professores'
            stmtProfessor = conn.prepareStatement(sqlProfessor, PreparedStatement.RETURN_GENERATED_KEYS);
            stmtProfessor.setString(1, professor.getNome());
            stmtProfessor.setString(2, professor.getFormacao());
            stmtProfessor.setString(3, professor.getEndereco());
            stmtProfessor.setString(4, professor.getTelefone());
            stmtProfessor.setInt(5, departamentoId);
            stmtProfessor.executeUpdate();

            // Obtém o ID do professor recém-criado
            ResultSet rsProfessorId = stmtProfessor.getGeneratedKeys();
            if (!rsProfessorId.next()) {
                throw new SQLException("Erro ao obter o ID do professor.");
            }
            int professorId = rsProfessorId.getInt(1);



            // Inserção na tabela 'professor_disciplina'
            stmtRelacao = conn.prepareStatement(sqlRelacao);
            stmtRelacao.setInt(1, professorId);
            stmtRelacao.setInt(2, disciplinaId);
            stmtRelacao.executeUpdate();

            // Confirma a transação
            conn.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            if (conn != null) {
                try {
                    conn.rollback(); // Reverte alterações em caso de erro
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            return false;

        } finally {
            // Fechando recursos
            try {
                if (rsDisciplinaId != null) rsDisciplinaId.close();
                if (stmtBuscaDisciplinaId != null) stmtBuscaDisciplinaId.close();
                if (stmtRelacao != null) stmtRelacao.close();
                if (stmtProfessor != null) stmtProfessor.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Método para buscar as disciplinas do banco de dados
    public static List<String> getDisciplinas() {
        List<String> disciplinas = new ArrayList<>();
        String sql = "SELECT denominacao FROM disciplinas";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                disciplinas.add(rs.getString("denominacao"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return disciplinas;
    }
}
