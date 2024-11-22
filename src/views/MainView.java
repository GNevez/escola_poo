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

    public MainView() {
        controller = new EscolaController();

        setTitle("Sistema de Gerenciamento Escolar");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel de pesquisa
        JPanel painelPesquisa = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelPesquisa = new JLabel("Pesquisar:");
        campoPesquisa = new JTextField(20);
        painelPesquisa.add(labelPesquisa);
        painelPesquisa.add(campoPesquisa);

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

        painelBotoes.add(botaoCadastrarProfessor);
        painelBotoes.add(botaoCadastrarAluno);

        add(painelPesquisa, BorderLayout.NORTH);
        add(abas, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);

        // Eventos de pesquisa
        campoPesquisa.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void insertUpdate(javax.swing.event.DocumentEvent e) { aplicarFiltro(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { aplicarFiltro(); }
            public void changedUpdate(javax.swing.event.DocumentEvent e) { aplicarFiltro(); }
        });

        // Ações dos botões
        botaoCadastrarProfessor.addActionListener(e -> controller.abrirTelaCadastroProfessor());
        botaoCadastrarAluno.addActionListener(e -> controller.abrirTelaCadastroAluno());

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
}
