package models;

public class Professor {
    private String nome;
    private String formacao;
    private String endereco;
    private String telefone;
    private String disciplina;

    // Construtor
    public Professor(String nome, String formacao, String endereco, String telefone, String disciplina) {
        this.nome = nome;
        this.formacao = formacao;
        this.endereco = endereco;
        this.telefone = telefone;
        this.disciplina = disciplina;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    // Getters e Setters
    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "nome='" + nome + '\'' +
                ", formacao='" + formacao + '\'' +
                ", endereco='" + endereco + '\'' +
                ", telefone='" + telefone + '\'' +
                ", disciplina='" + disciplina + '\'' +
                '}';
    }
}
