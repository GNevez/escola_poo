package controllers;

import dao.ConexaoDB;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.sql.*;

import views.CadastroProfessorView;
import views.CadastroAlunoView;

public class EscolaController {

    // Método para carregar dados da tabela
    public DefaultTableModel carregarDados(String query) {
        DefaultTableModel modeloTabela = new DefaultTableModel();

        try (Connection conexao = ConexaoDB.getConnection();
             Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            ResultSetMetaData metaData = rs.getMetaData();
            int colunas = metaData.getColumnCount();

            // Adiciona colunas
            for (int i = 1; i <= colunas; i++) {
                modeloTabela.addColumn(metaData.getColumnName(i));
            }

            // Adiciona linhas
            while (rs.next()) {
                Object[] linha = new Object[colunas];
                for (int i = 1; i <= colunas; i++) {
                    linha[i - 1] = rs.getObject(i);
                }
                modeloTabela.addRow(linha);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar dados: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }

        return modeloTabela;
    }

    // Método para aplicar filtro nas tabelas
    public void aplicarFiltro(JTabbedPane abas, String textoPesquisa) {
        int abaSelecionada = abas.getSelectedIndex();
        JScrollPane scrollPane = (JScrollPane) abas.getComponentAt(abaSelecionada);
        JTable tabelaAtual = (JTable) ((JViewport) scrollPane.getViewport()).getView();

        if (tabelaAtual != null) {
            TableRowSorter<DefaultTableModel> sorter = (TableRowSorter<DefaultTableModel>) tabelaAtual.getRowSorter();
            if (textoPesquisa.trim().isEmpty()) {
                sorter.setRowFilter(null);
            } else {
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + textoPesquisa));
            }
        }
    }

    // Método para abrir a tela de cadastro de Professor
    public void abrirTelaCadastroProfessor() {
        new CadastroProfessorView();
    }

    // Método para abrir a tela de cadastro de Aluno
    public void abrirTelaCadastroAluno() {
        new CadastroAlunoView();
    }
}

