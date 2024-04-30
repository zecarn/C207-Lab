package org.example.Classes;

public class User {
    private String matricula;
    private String nome;
    private int idade;
    private String cidade;

    public User(String matricula, String nome, int idade, String cidade){
        this.matricula = matricula;
        this.nome = nome;
        this.idade = idade;
        this.cidade =cidade;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCidade() {
        return cidade;
    }
}
