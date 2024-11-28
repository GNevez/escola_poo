package views;

import javax.swing.*;
import java.awt.*;
import controllers.CadastroCursoController;
import models.Disciplina;
import java.util.List;

public class CadastroCursoView extends JFrame {

    private JTextField campoNome;
    private JTextField campoSigla;
    private JComboBox<Disciplina> comboBoxDisciplinas; // Substituição
    private JButton botaoSalvar;

    public CadastroCursoView() {
        setTitle("Cadastro de Curso");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 1;
        gbc.gridwidth = 1;

        // Componentes da interface
        JLabel labelNome = new JLabel("Denominação Curso:");
        campoNome = new JTextField(20);
        addComponent(labelNome, campoNome, 0, gbc);

        JLabel labelSigla = new JLabel("Sigla:");
        campoSigla = new JTextField(20);
        addComponent(labelSigla, campoSigla, 1, gbc);

        JLabel labelDisciplina = new JLabel("Disciplina:");
        comboBoxDisciplinas = new JComboBox<>(); // Novo JComboBox
        addComponent(labelDisciplina, comboBoxDisciplinas, 2, gbc);

        botaoSalvar = new JButton("Salvar");
        botaoSalvar.setBackground(new Color(34, 139, 34));
        botaoSalvar.setForeground(Color.WHITE);
        botaoSalvar.setFocusPainted(false);
        botaoSalvar.setFont(new Font("Arial", Font.BOLD, 14));

        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(botaoSalvar, gbc);

        carregarDisciplinas(); // Carrega disciplinas no comboBox

        botaoSalvar.addActionListener(e -> {
            CadastroCursoController controller = new CadastroCursoController(this);
            controller.cadastrarCurso();
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

    // Método para carregar as disciplinas no combo box
    private void carregarDisciplinas() {
        CadastroCursoController controller = new CadastroCursoController(this);
        List<Disciplina> disciplinas = controller.buscarDisciplinas();
        for (Disciplina disciplina : disciplinas) {
            comboBoxDisciplinas.addItem(disciplina);
        }
    }

    // Métodos para interagir com o controller
    public JTextField getCampoNome() {
        return campoNome;
    }

    public JTextField getCampoSigla() {
        return campoSigla;
    }

    public JComboBox<Disciplina> getComboBoxDisciplinas() { // Ajuste
        return comboBoxDisciplinas;
    }

    public JButton getBotaoSalvar() {
        return botaoSalvar;
    }
}
