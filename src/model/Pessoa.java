package model;

public abstract class Pessoa {
    protected String nome;
    protected int idade;
    protected String telefone;

    public Pessoa(String nome, int idade, String telefone) {
        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome= " + nome + '\'' +
                ", idade= " + idade +
                ", telefone= '" + telefone + '\'' +
                '}';
    }
}