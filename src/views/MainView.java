package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import controllers.EscolaController;

public class MainView extends JFrame {

    private JTextField campoPesquisa;
    private JTabbedPane abas;
    private EscolaController controller;
    private JButton botaoRecarregar;

    public MainView() {
        controller = new EscolaController();

        setTitle("Sistema de Gerenciamento Escolar");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel de pesquisa com botão de recarregar
        JPanel painelPesquisa = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelPesquisa = new JLabel("Pesquisar:");
        campoPesquisa = new JTextField(20);
        botaoRecarregar = new JButton("Recarregar");

        painelPesquisa.add(labelPesquisa);
        painelPesquisa.add(campoPesquisa);
        painelPesquisa.add(botaoRecarregar);

        // Painel principal com abas
        abas = new JTabbedPane();

        abas.addTab("Alunos", criarTabelaTab("SELECT * FROM alunos"));
        abas.addTab("Professores", criarTabelaTab("SELECT * FROM professores"));
        abas.addTab("Cursos", criarTabelaTab("SELECT * FROM cursos"));
        abas.addTab("Disciplinas", criarTabelaTab("SELECT * FROM disciplinas"));

        // Botões de cadastro
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton botaoCadastrarProfessor = new JButton("Cadastrar Professor");
        JButton botaoCadastrarAluno = new JButton("Cadastrar Aluno");
        JButton botaoCadastrarCurso = new JButton("Cadastrar Curso");  // Novo botão

        painelBotoes.add(botaoCadastrarProfessor);
        painelBotoes.add(botaoCadastrarAluno);
        painelBotoes.add(botaoCadastrarCurso);  // Adiciona o botão ao painel

        add(painelPesquisa, BorderLayout.NORTH);
        add(abas, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);

        // Evento do botão de recarregar
        botaoRecarregar.addActionListener(e -> recarregarDados());

        // Eventos de pesquisa
        campoPesquisa.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void insertUpdate(javax.swing.event.DocumentEvent e) { aplicarFiltro(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { aplicarFiltro(); }
            public void changedUpdate(javax.swing.event.DocumentEvent e) { aplicarFiltro(); }
        });

        // Ações dos botões de cadastro
        botaoCadastrarProfessor.addActionListener(e -> controller.abrirTelaCadastroProfessor());
        botaoCadastrarAluno.addActionListener(e -> controller.abrirTelaCadastroAluno());
        botaoCadastrarCurso.addActionListener(e -> controller.abrirTelaCadastroCurso());  // Nova ação

        setVisible(true);
    }

    private JScrollPane criarTabelaTab(String query) {
        DefaultTableModel modelo = controller.carregarDados(query);
        JTable tabela = new JTable(modelo);
        tabela.setRowSorter(new TableRowSorter<>(modelo));
        return new JScrollPane(tabela);
    }

    private void aplicarFiltro() {
        String textoPesquisa = campoPesquisa.getText();
        controller.aplicarFiltro(abas, textoPesquisa);
    }

    private void recarregarDados() {
        // Recarrega os dados de todas as abas
        abas.setComponentAt(0, criarTabelaTab("SELECT * FROM alunos"));
        abas.setComponentAt(1, criarTabelaTab("SELECT * FROM professores"));
        abas.setComponentAt(2, criarTabelaTab("SELECT * FROM cursos"));
        abas.setComponentAt(3, criarTabelaTab("SELECT * FROM disciplinas"));
    }
}
