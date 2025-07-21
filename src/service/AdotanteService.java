package service;

import model.Adotante;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdotanteService {
    private List<Adotante> adotantes = new ArrayList<>();

    public void adicionarAdotante(Scanner scanner) {
        System.out.println("\n--- Cadastro de Adotante ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = Integer.parseInt(scanner.nextLine());

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Preferências (Ex: Cão pequeno, Gato tranquilo): ");
        String preferencias = scanner.nextLine();

        Adotante adotante = new Adotante(nome, idade, telefone, cpf, endereco, preferencias);
        adotantes.add(adotante);
        System.out.println("Adotante cadastrado com sucesso!");
    }

    public void editarAdotante(Scanner scanner) {
        System.out.print("Digite o CPF do adotante a ser editado: ");
        String cpf = scanner.nextLine();

        Adotante adotante = buscarAdotantePorCpf(cpf);
        if (adotante == null) {
            System.out.println("Adotante não encontrado.");
            return;
        }

        System.out.print("Novo endereço: ");
        String novoEndereco = scanner.nextLine();

        System.out.print("Novas preferências: ");
        String novasPreferencias = scanner.nextLine();

        adotante.setEndereco(novoEndereco);
        adotante.setPreferencias(novasPreferencias);
        System.out.println("Adotante atualizado com sucesso.");
    }

    public void alternarStatusAdotante(Scanner scanner) {
        System.out.print("Digite o CPF do adotante para alterar o status: ");
        String cpf = scanner.nextLine();
        alternarStatusAdotante(cpf);
    }

    public void listarAdotantes() {
        if (adotantes.isEmpty()) {
            System.out.println("Nenhum adotante cadastrado.");
        } else {
            adotantes.forEach(System.out::println);
        }
    }

    public Adotante buscarAdotantePorCpf(String cpf) {
        return adotantes.stream()
                .filter(a -> a.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }

    public Adotante buscarAdotantePorId(String cpf) {
        return buscarAdotantePorCpf(cpf);
    }

    public boolean removerAdotante(String nome) {
        return adotantes.removeIf(a -> a.getNome().equalsIgnoreCase(nome));
    }

    public void alternarStatusAdotante(String cpf) {
        Adotante adotante = buscarAdotantePorCpf(cpf);
        if (adotante != null) {
            adotante.setAtivo(!adotante.isAtivo());
            System.out.println("Status do adotante alterado com sucesso.");
        } else {
            System.out.println("Adotante não encontrado.");
        }
    }

    public void editarAdotante(String cpf, String novoEndereco, String novasPreferencias) {
        Adotante adotante = buscarAdotantePorId(cpf);
        if (adotante != null) {
            adotante.setEndereco(novoEndereco);
            adotante.setPreferencias(novasPreferencias);
            System.out.println("Adotante atualizado com sucesso.");
        } else {
            System.out.println("Adotante não encontrado.");
        }
    }
}