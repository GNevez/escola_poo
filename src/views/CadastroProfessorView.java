package views;

import controllers.ProfessorController;
import models.Professor;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CadastroProfessorView extends JFrame {

    private final ProfessorController controller;
    private JComboBox<String> comboDisciplinas; // ComboBox para as disciplinas

    public CadastroProfessorView() {
        controller = new ProfessorController(); // Inicializa o controller

        // Configurações iniciais da janela
        setTitle("Cadastro de Professor");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criando um painel com GroupLayout
        JPanel painelPrincipal = new JPanel();
        GroupLayout layout = new GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(layout);

        // Definindo os rótulos e campos de texto
        JLabel labelNome = new JLabel("Nome:");
        labelNome.setFont(new Font("Arial", Font.BOLD, 14));
        JTextField campoNome = new JTextField(20);
        campoNome.setFont(new Font("Arial", Font.PLAIN, 14));

        JLabel labelFormacao = new JLabel("Formação:");
        labelFormacao.setFont(new Font("Arial", Font.BOLD, 14));
        JTextField campoFormacao = new JTextField(20);
        campoFormacao.setFont(new Font("Arial", Font.PLAIN, 14));

        JLabel labelEndereco = new JLabel("Endereço:");
        labelEndereco.setFont(new Font("Arial", Font.BOLD, 14));
        JTextField campoEndereco = new JTextField(20);
        campoEndereco.setFont(new Font("Arial", Font.PLAIN, 14));

        JLabel labelTelefone = new JLabel("Telefone:");
        labelTelefone.setFont(new Font("Arial", Font.BOLD, 14));
        JTextField campoTelefone = new JTextField(15);
        campoTelefone.setFont(new Font("Arial", Font.PLAIN, 14));

        JLabel labelDisciplina = new JLabel("Disciplina:");
        labelDisciplina.setFont(new Font("Arial", Font.BOLD, 14));
        comboDisciplinas = new JComboBox<>(getDisciplinasFromDatabase().toArray(new String[0]));
        comboDisciplinas.setFont(new Font("Arial", Font.PLAIN, 14));

        // Botão de Salvar
        JButton botaoSalvar = new JButton("Salvar");
        botaoSalvar.setFont(new Font("Arial", Font.BOLD, 14));
        botaoSalvar.setBackground(new Color(34, 139, 34)); // Verde mais bonito
        botaoSalvar.setForeground(Color.WHITE);
        botaoSalvar.setBorderPainted(false);
        botaoSalvar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        botaoSalvar.setPreferredSize(new Dimension(120, 40));

        botaoSalvar.addActionListener(e -> {
            // Criando o objeto Professor a partir dos campos
            Professor professor = new Professor(
                    campoNome.getText(),
                    campoFormacao.getText(),
                    campoEndereco.getText(),
                    campoTelefone.getText(),
                    (String) comboDisciplinas.getSelectedItem() // Obtém a disciplina selecionada
            );

            // Chamando o método do controller para salvar
            boolean sucesso = controller.salvarProfessor(professor);

            if (sucesso) {
                JOptionPane.showMessageDialog(this, "Professor cadastrado com sucesso!");
                dispose(); // Fecha a tela
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar professor.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Definindo as conexões do GroupLayout para os componentes
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(labelNome)
                                        .addComponent(labelFormacao)
                                        .addComponent(labelEndereco)
                                        .addComponent(labelTelefone)
                                        .addComponent(labelDisciplina))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(campoNome)
                                        .addComponent(campoFormacao)
                                        .addComponent(campoEndereco)
                                        .addComponent(campoTelefone)
                                        .addComponent(comboDisciplinas)
                                        .addComponent(botaoSalvar))
                        )
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelNome)
                                .addComponent(campoNome))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelFormacao)
                                .addComponent(campoFormacao))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelEndereco)
                                .addComponent(campoEndereco))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelTelefone)
                                .addComponent(campoTelefone))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelDisciplina)
                                .addComponent(comboDisciplinas))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(botaoSalvar)
                        )
        );

        // Adicionando o painel principal à janela
        add(painelPrincipal);
        setVisible(true);
    }

    private List<String> getDisciplinasFromDatabase() {
        return controller.getDisciplinas(); // Obtém as disciplinas do banco por meio do controller
    }
}
