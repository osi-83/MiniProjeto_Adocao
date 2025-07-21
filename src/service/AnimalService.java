package service;

import model.Animal;

import java.util.ArrayList;
import java.util.List;

public class AnimalService {
    private final List<Animal> animais = new ArrayList<>();

    public void adicionarAnimal(Animal animal) {
        animais.add(animal);
        System.out.println("Animal adicionado com sucesso!");
    }

    public void listarAnimais() {
        if (animais.isEmpty()) {
            System.out.println("Nenhum animal cadastrado.");
            return;
        }
        for (Animal a : animais) {
            System.out.println(a.getDescricaoDetalhada());
        }
    }

    public List<Animal> getLista() {
        return new ArrayList<>(animais);
    }

    public boolean removerAnimalPorId(String id) {
        return animais.removeIf(a -> a.getId().equals(id));
    }

    public Animal buscarPorId(String id) {
        for (Animal a : animais) {
            if (a.getId().equals(id)) return a;
        }
        return null;
    }

    public void alternarStatus(String id) {
        Animal a = buscarPorId(id);
        if (a != null) {
            if (a.getStatus().equalsIgnoreCase("disponível")) {
                a.setStatus("em tratamento");
            } else {
                a.setStatus("disponível");
            }
            System.out.println("Status atualizado.");
        } else {
            System.out.println("Animal não encontrado.");
        }
    }
}