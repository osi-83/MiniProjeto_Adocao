package service;

import model.Adocao;
import model.Adotante;
import model.Animal;

import java.util.ArrayList;
import java.util.List;

public class AdocaoService {
    private List<Adocao> adocoes = new ArrayList<>();

    public void gerarAdocao(Adotante adotante, Animal animal) {
        if (!adotante.validar() || !animal.validar()) {
            System.out.println("Adotante ou animal não está apto para adoção.");
            return;
        }

        Adocao novaAdocao = new Adocao(adotante, animal, false);
        adocoes.add(novaAdocao);
        System.out.println(" Adoção gerada com sucesso! (Termo ainda não assinado).");
    }

    public void realizarAdocao(String cpf, String idAnimal) {
        for (Adocao adocao : adocoes) {
            if (adocao.getAdotante().getCpf().equals(cpf) &&
            adocao.getAnimalAdotado().getId().equals(idAnimal) &&
            !adocao.isTermoAssinado()) {

                adocao.setTermoAssinado(true);
                adocao.getAnimalAdotado().setStatus("Adotado");
                System.out.println("Adoção concluída com sucesso!");
                return;
            }
        }
        System.out.println("Adoção não encontrada ou já foi realizada.");
    }

    public void listarAdocoesDetalhadas(){
        if (adocoes.isEmpty()) {
            System.out.println("Nenhuma adoção registrada.");
            return;
        }

        for (Adocao adocao : adocoes) {
            System.out.println(" *** Relatório da Adoção *** ");
            System.out.println(adocao.getAdotante().gerarRelatorio());
            System.out.println(adocao.getAnimalAdotado().gerarRelatorio());
            System.out.println("Termo Assinado: " + (adocao.isTermoAssinado() ? "Sim" : "Não"));
            System.out.println("Data: " + adocao.getData());
            System.out.println("________________________________");
        }

        //System.out.println("Registro de adoções: ");
        //for (Adocao adocao : adocoes) {
        //    System.out.println(adocao);
        //}
    }
}