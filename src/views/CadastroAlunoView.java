package views;

import javax.swing.*;
import java.awt.*;
import controllers.CadastroAlunoController;
import java.util.List;
import models.Curso;

public class CadastroAlunoView extends JFrame {

    private JTextField campoNome;
    private JTextField campoEndereco;
    private JTextField campoTelefone;
    private JTextField campoFiliacao;
    private JTextField campoDataNascimento;
    private JComboBox<Curso> comboBoxCursos;
    private JButton botaoSalvar;

    public CadastroAlunoView() {
        setTitle("Cadastro de Aluno");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // Criando os componentes da interface
        JLabel labelNome = new JLabel("Nome:");
        campoNome = new JTextField(20);

        JLabel labelEndereco = new JLabel("Endereço:");
        campoEndereco = new JTextField(20);

        JLabel labelTelefone = new JLabel("Telefone:");
        campoTelefone = new JTextField(15);

        JLabel labelFiliacao = new JLabel("Filiacao:");
        campoFiliacao = new JTextField(20);

        JLabel labelDataNascimento = new JLabel("Data de Nascimento:");
        campoDataNascimento = new JTextField(10);

        JLabel labelCurso = new JLabel("Curso:");
        comboBoxCursos = new JComboBox<>();

        botaoSalvar = new JButton("Salvar");

        // Adicionando os componentes ao layout
        add(labelNome);
        add(campoNome);
        add(labelEndereco);
        add(campoEndereco);
        add(labelTelefone);
        add(campoTelefone);
        add(labelFiliacao);
        add(campoFiliacao);
        add(labelDataNascimento);
        add(campoDataNascimento);
        add(labelCurso);
        add(comboBoxCursos);
        add(botaoSalvar);

        // Carregar os cursos no combo box
        carregarCursos();

        // Evento para salvar os dados do aluno
        botaoSalvar.addActionListener(e -> {
            // Aqui, instanciamos o controller para gerenciar o processo de cadastro
            CadastroAlunoController cadastroAlunoController = new CadastroAlunoController(this);
            cadastroAlunoController.cadastrarAluno();
        });

        setVisible(true);
    }

    // Carrega os cursos no combo box
    public void carregarCursos() {
        // Aqui, vamos chamar o método do controller para pegar os cursos disponíveis no banco
        CadastroAlunoController cadastroAlunoController = new CadastroAlunoController(this);
        List<Curso> cursos = cadastroAlunoController.buscarCursos();

        // Preencher o combo box com os cursos
        for (Curso curso : cursos) {
            comboBoxCursos.addItem(curso);
        }
    }

    // Métodos para interagir com o controller
    public JTextField getCampoNome() {
        return campoNome;
    }

    public JTextField getCampoEndereco() {
        return campoEndereco;
    }

    public JTextField getCampoTelefone() {
        return campoTelefone;
    }

    public JTextField getCampoFiliacao() {
        return campoFiliacao;
    }

    public JTextField getCampoDataNascimento() {
        return campoDataNascimento;
    }

    public JComboBox<Curso> getComboBoxCursos() {
        return comboBoxCursos;
    }

    public JButton getBotaoSalvar() {
        return botaoSalvar;
    }
}
