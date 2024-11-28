package models;

public class CursoInsert {
    private int id;
    private String nome;
    private String sigla;
    private int idDisciplina; // Associado à tabela de disciplinas

    public CursoInsert(String nome, String sigla, int idDisciplina) {
        this.nome = nome;
        this.sigla = sigla;
        this.idDisciplina = idDisciplina;
    }

    // Construtor com ID (caso precise recuperar do banco)
    public CursoInsert(int id, String nome, String sigla, int idDisciplina) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.idDisciplina = idDisciplina;
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

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    @Override
    public String toString() {
        return nome + " (" + sigla + ")";
    }
}
