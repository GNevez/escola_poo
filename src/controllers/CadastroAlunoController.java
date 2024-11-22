package controllers;

import dao.AlunoDAO;
import models.Aluno;
import models.Curso;
import views.CadastroAlunoView;
import dao.CursoDAO;

import javax.swing.*;
import java.util.List;

public class CadastroAlunoController {

    private CadastroAlunoView view;

    public CadastroAlunoController(CadastroAlunoView view) {
        this.view = view;
    }

    public void cadastrarAluno() {
        String nome = view.getCampoNome().getText();
        String endereco = view.getCampoEndereco().getText();
        String telefone = view.getCampoTelefone().getText();
        String filiacao = view.getCampoFiliacao().getText();
        String dataNascimento = view.getCampoDataNascimento().getText();
        Curso cursoSelecionado = (Curso) view.getComboBoxCursos().getSelectedItem();

        // Verificar se os campos obrigatórios estão preenchidos
        if (nome.isEmpty() || endereco.isEmpty() || telefone.isEmpty() || filiacao.isEmpty() || dataNascimento.isEmpty() || cursoSelecionado == null) {
            JOptionPane.showMessageDialog(view, "Todos os campos são obrigatórios!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Criar o objeto Aluno
        Aluno aluno = new Aluno(nome, endereco, telefone, filiacao, dataNascimento, cursoSelecionado.getId());

        // Chamar o DAO para salvar o aluno no banco de dados
        AlunoDAO alunoDAO = new AlunoDAO();
        boolean sucesso = alunoDAO.inserirAluno(aluno);

        if (sucesso) {
            JOptionPane.showMessageDialog(view, "Aluno cadastrado com sucesso!");
            view.dispose(); // Fechar a tela de cadastro
        } else {
            JOptionPane.showMessageDialog(view, "Erro ao cadastrar o aluno. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para buscar os cursos disponíveis no banco de dados
    public List<Curso> buscarCursos() {
        CursoDAO cursoDAO = new CursoDAO();
        return cursoDAO.listarCursos(); // Recupera a lista de cursos do banco de dados
    }
}
