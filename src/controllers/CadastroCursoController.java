package controllers;

import views.CadastroCursoView;
import models.CursoInsert;
import models.Disciplina;
import dao.CursoDAO;
import dao.DisciplinaDAO;

import javax.swing.*;
import java.util.List;

public class CadastroCursoController {
    private CadastroCursoView view;
    private CursoDAO cursoDAO;
    private DisciplinaDAO disciplinaDAO;

    public CadastroCursoController(CadastroCursoView view) {
        this.view = view;
        this.cursoDAO = new CursoDAO();
        this.disciplinaDAO = new DisciplinaDAO();
        carregarDisciplinas();
    }

    // Carrega as disciplinas do banco e adiciona no comboBox
    public void carregarDisciplinas() {
        List<Disciplina> disciplinas = disciplinaDAO.buscarTodasDisciplinas();
        JComboBox<Disciplina> comboBoxDisciplinas = view.getComboBoxDisciplinas();
        comboBoxDisciplinas.removeAllItems();  // Limpa antes de adicionar

        for (Disciplina disciplina : disciplinas) {
            comboBoxDisciplinas.addItem(disciplina);
        }
    }

    public List<Disciplina> buscarDisciplinas() {
        DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        return disciplinaDAO.buscarTodasDisciplinas();
    }

    // Método para cadastrar curso no banco
    public void cadastrarCurso() {
        String nome = view.getCampoNome().getText();
        String sigla = view.getCampoSigla().getText();
        Disciplina disciplinaSelecionada = (Disciplina) view.getComboBoxDisciplinas().getSelectedItem();

        if (nome.isEmpty() || sigla.isEmpty() || disciplinaSelecionada == null) {
            JOptionPane.showMessageDialog(view, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        CursoInsert curso = new CursoInsert(nome, sigla, disciplinaSelecionada.getId());

        if (cursoDAO.inserirCurso(curso)) {
            JOptionPane.showMessageDialog(view, "Curso cadastrado com sucesso!");
            view.dispose();
        } else {
            JOptionPane.showMessageDialog(view, "Erro ao cadastrar curso.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}

