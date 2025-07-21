package model;

public class Cao extends Animal {
    private String porte;
    private boolean necessitaPasseio;

    public Cao(String nome, int idade, String condicaoSaude, String temperamento, String porte, boolean necessitaPasseio) {
        super(nome, "Cão", idade, condicaoSaude, temperamento);
        this.porte = porte;
        this.necessitaPasseio = necessitaPasseio;
    }

    @Override
    public String getDescricaoDetalhada() {
        return String.format("ID: %s | Cão: %s | Idade: %d | Saúde: %s | Temperamento: %s | Porte: %s | Passeio: %s | Status: %s",
                getId(), getNome(), getIdade(), getCondicaoSaude(), getTemperamento(), porte,
                (necessitaPasseio ? "Sim" : "Não"), getStatus());
    }
}