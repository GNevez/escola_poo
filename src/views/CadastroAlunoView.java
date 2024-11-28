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
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout()); // Usando GridBagLayout para melhor organização

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 1;
        gbc.gridwidth = 1;

        // Adicionando os componentes à interface com GridBagLayout
        JLabel labelNome = new JLabel("Nome:");
        campoNome = new JTextField(20);
        addComponent(labelNome, campoNome, 0, gbc);

        JLabel labelEndereco = new JLabel("Endereço:");
        campoEndereco = new JTextField(20);
        addComponent(labelEndereco, campoEndereco, 1, gbc);

        JLabel labelTelefone = new JLabel("Telefone:");
        campoTelefone = new JTextField(15);
        addComponent(labelTelefone, campoTelefone, 2, gbc);

        JLabel labelFiliacao = new JLabel("Filiação:");
        campoFiliacao = new JTextField(20);
        addComponent(labelFiliacao, campoFiliacao, 3, gbc);

        JLabel labelDataNascimento = new JLabel("Data de Nascimento:");
        campoDataNascimento = new JTextField(10);
        addComponent(labelDataNascimento, campoDataNascimento, 4, gbc);

        JLabel labelCurso = new JLabel("Curso:");
        comboBoxCursos = new JComboBox<>();
        addComponent(labelCurso, comboBoxCursos, 5, gbc);

        // Botão Salvar
        botaoSalvar = new JButton("Salvar");
        botaoSalvar.setBackground(new Color(34, 139, 34));
        botaoSalvar.setForeground(Color.WHITE);
        botaoSalvar.setFocusPainted(false);
        botaoSalvar.setFont(new Font("Arial", Font.BOLD, 14));

        gbc.gridy = 6;
        gbc.gridwidth = 2; // O botão ocupa duas colunas
        gbc.anchor = GridBagConstraints.CENTER;
        add(botaoSalvar, gbc);

        carregarCursos();

        botaoSalvar.addActionListener(e -> {
            CadastroAlunoController cadastroAlunoController = new CadastroAlunoController(this);
            cadastroAlunoController.cadastrarAluno();
        });

        setVisible(true);
    }

    private void addComponent(JLabel label, JComponent component, int y, GridBagConstraints gbc) {
        gbc.gridy = y;
        gbc.gridx = 0;
        add(label, gbc);
        gbc.gridx = 1;
        add(component, gbc);
    }

    public void carregarCursos() {
        CadastroAlunoController cadastroAlunoController = new CadastroAlunoController(this);
        List<Curso> cursos = cadastroAlunoController.buscarCursos();
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
