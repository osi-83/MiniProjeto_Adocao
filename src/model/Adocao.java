package model;

import java.util.Date;

public class Adocao {
    private Adotante adotante;
    private Animal animalAdotado;
    private Date data;
    private boolean termoAssinado;

    public Adocao(Adotante adotante, Animal animalAdotado, boolean termoAssinado) {
        this.adotante = adotante;
        this.animalAdotado = animalAdotado;
        this.termoAssinado = termoAssinado;
        this.data = new Date(); // Define a data atual
    }

    public Adotante getAdotante() {
        return adotante;
    }

    public Animal getAnimalAdotado() {
        return animalAdotado;
    }

    public Date getData() {
        return data;
    }

    public boolean isTermoAssinado() {
        return termoAssinado;
    }

    public void setTermoAssinado(boolean termoAssinado) {
        this.termoAssinado = termoAssinado;
    }

    @Override
    public String toString() {
        return "Adoção {" +
                "Adotante = " + adotante.getNome() +
                ", Animal = " + animalAdotado.getNome() +
                ", Data = " + data +
                ", Termo Assinado = " + (termoAssinado ? "Sim" : "Não") +
                '}';
    }
}