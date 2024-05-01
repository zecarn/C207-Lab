package org.example.Classes;

public class Aluno {
    private int matricula;
    private String nome;
    private String endereco;
    private String data_de_nascimento;
    private int Curso_sigla;
    private int Responsavel_id;
    private String bolsa;

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getData_de_nascimento() {
        return data_de_nascimento;
    }

    public int getCurso_sigla() {
        return Curso_sigla;
    }

    public int getResponsavel_id() {
        return Responsavel_id;
    }

    public String getBolsa() {
        return bolsa;
    }

    public Aluno(int matricula, String nome, String endereco, String data, int curso_sigla, int responsavel_id, String bolsa){
        this.matricula = matricula;
        this.nome = nome;
        this.endereco = endereco;
        this.data_de_nascimento = data;
        this.Curso_sigla = curso_sigla;
        this.Responsavel_id = responsavel_id;
        this.bolsa = bolsa;
    }

}
