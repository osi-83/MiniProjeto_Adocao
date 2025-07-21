package model;

public class Adotante extends Pessoa implements interfaces.Validavel, interfaces.Relatorio {
    private String cpf;
    private String endereco;
    private String preferencias;
    private boolean ativo = true;

    // Construtor principal do perfil adotante
    public Adotante(String nome, int idade, String telefone, String cpf, String endereco, String preferencias) {
        super(nome, idade, telefone);
        this.cpf = cpf;
        this.endereco = endereco;
        this.preferencias = preferencias;
    }

    public Adotante(String nome, String cpf, String endereco, String preferencias) {
        super(nome, 0, "");
        this.cpf = cpf;
        this.endereco = endereco;
        this.preferencias = preferencias;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getPreferencias() {
        return preferencias;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setPreferencias(String preferencias) {
        this.preferencias = preferencias;
    }

    public boolean isAtivo()  {
        return ativo;
    }

    public void setAtivo(boolean ativo)  {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Adotante: {" +
                " Nome = '" + nome + '\'' +
                ", idade = " + idade +
                " anos, telefone ='"+ telefone+'\'' +
                ", cpf = '" + cpf + '\'' +
                ",\n endereço = '" + endereco + '\'' +
                ", preferencias = '" + preferencias + '\'' +
                ", ativo = " + ativo +
                '}';
    }

    public void add(Adotante adotante) {
    }

    @Override
    public boolean validar() {
        return nome != null && !nome.isEmpty() && idade >= 18 && telefone != null && !telefone.isEmpty();
    }

    @Override
    public String gerarRelatorio() {
        return  String.format("Adotante: %s\nIdade: %d\nTelefone: %s", nome, idade, telefone);
    }
}