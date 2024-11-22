package models;

public class Curso {

    private int id;           // Identificador do curso
    private String nome;      // Nome do curso
    private String sigla;     // Sigla do curso

    // Construtor
    public Curso(int id, String nome, String sigla) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    // Override do método toString para exibir o nome e a sigla no JComboBox
    @Override
    public String toString() {
        return nome + " (" + sigla + ")";
    }
}
