package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
    // Configurações do banco de dados
    private static final String URL = "jdbc:mysql://localhost:3306/escola_bilingue";
    private static final String USUARIO = "root";   // Substitua pelo seu usuário
    private static final String SENHA = ""; // Substitua pela sua senha

    // Método para obter a conexão com o banco de dados
    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            throw new SQLException("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
}
