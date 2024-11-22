package models;

public class Aluno {
    private String nome;
    private String endereco;
    private String telefone;
    private String filiacao;
    private String dataNascimento;
    private int cursoId; // Novo campo

    // Construtores, getters e setters...

    public Aluno(String nome, String endereco, String telefone, String filiacao, String dataNascimento, int cursoId) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.filiacao = filiacao;
        this.dataNascimento = dataNascimento;
        this.cursoId = cursoId;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFiliacao() {
        return filiacao;
    }

    public void setFiliacao(String filiacao) {
        this.filiacao = filiacao;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getCursoId() {
        return cursoId;
    }

    public void setCursoId(int cursoId) {
        this.cursoId = cursoId;
    }
}
