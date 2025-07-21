package model;

public class Gato extends Animal {
    private boolean conviveComOutrosGatos;

    public Gato(String nome, int idade, String condicaoSaude, String temperamento, boolean conviveComOutrosGatos) {
        super(nome, "Gato", idade, condicaoSaude, temperamento);
        this.conviveComOutrosGatos = conviveComOutrosGatos;
    }

    @Override
    public String getDescricaoDetalhada() {
        return String.format("ID: %s | Gato: %s | Idade: %d | Saúde: %s | Temperamento: %s | Convive com outros gatos: %s | Status: %s",
                getId(), getNome(), getIdade(), getCondicaoSaude(), getTemperamento(),
                (conviveComOutrosGatos ? "Sim" : "Não"), getStatus());
    }
}