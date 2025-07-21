package model;

public abstract class Animal implements interfaces.Validavel, interfaces.Relatorio {
    private static int contadorId = 1;
    private String id;

    protected String nome;
    protected String especie;
    protected int idade;
    protected String condicaoSaude;
    protected String temperamento;
    protected String status;

    public Animal(String nome, String especie, int idade, String condicaoSaude, String temperamento) {
        this.id = gerarIdUnico();
        this.nome = nome;
        this.especie = especie;
        this.idade = idade;
        this.condicaoSaude = condicaoSaude;
        this.temperamento = temperamento;
        this.status = "disponível";
    }

    private String gerarIdUnico() {
        return "A" + contadorId++;
    }

    public abstract String getDescricaoDetalhada();

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCondicaoSaude() {
        return condicaoSaude;
    }

    public String getTemperamento() {
        return temperamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String novoStatus) {
        this.status = novoStatus;
    }

    @Override
    public boolean validar() {
        return nome != null && !nome.isEmpty() && idade >= 0;
    }

    @Override
    public String gerarRelatorio() {
        return String.format("Animal ID: %s\nNome: %s \nEspécie: %s\nIdade: %d\nSaúde: %s\nTemperamento: %s\nStatus: %s",
                id, nome, especie, idade, condicaoSaude, temperamento, status);
    }
}