import model.Animal;
import model.Adotante;
import model.Gato;
import model.Cao;
import service.AdotanteService;
import service.AnimalService;
import service.AdocaoService;

import java.util.Scanner;
import java.util.UUID;


public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AnimalService animalService = new AnimalService();
    private static final AdotanteService adotanteService = new AdotanteService();
    private static final AdocaoService adocaoService = new AdocaoService();

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n=== SISTEMA DA ONG - Proteção Animal ===");
            System.out.println("[1] Gestão de Adotantes");
            System.out.println("[2] Gestão de Animais");
            System.out.println("[3] Gestão de Adoções");
            System.out.println("[4] Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite um número.");
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    menuGestaoAdotantes();
                    break;
                case 2:
                    menuGestaoAnimais();
                    break;
                case 3:
                    menuAdocoes(scanner, adotanteService, animalService, adocaoService);
                    break;
                case 4:
                    System.out.println("Encerrando o sistema. Obrigado!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);
    }

    // ===== MENU: Gestão de Adotantes =====
    private static void menuGestaoAdotantes() {
        int opcao;

        do {
            System.out.println("\n--- Gestão de Adotantes ---");
            System.out.println("[1] Adicionar Perfil Adotante");
            System.out.println("[2] Editar Perfil Adotante");
            System.out.println("[3] Habilitar/Desabilitar Adotante");
            System.out.println("[4] Listar Todos Adotantes");
            System.out.println("[5] Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite um número.");
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    adotanteService.adicionarAdotante(scanner);
                    break;
                case 2:
                    adotanteService.editarAdotante(scanner);
                    break;
                case 3:
                    adotanteService.alternarStatusAdotante(scanner);
                    break;
                case 4:
                    adotanteService.listarAdotantes();
                    break;
                case 5:
                    System.out.println("Retornando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 5);
    }

    // ===== MENU: Gestão de Animais =====
    private static void menuGestaoAnimais() {
        int opcao;

        do {
            System.out.println("\n--- Gestão de Animais ---");
            System.out.println("[1] Cadastrar Cão");
            System.out.println("[2] Cadastrar Gato");
            System.out.println("[3] Listar Animais");
            System.out.println("[4] Remover Animal por ID");
            System.out.println("[5] Alterar Status do Animal");
            System.out.println("[0] Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite um número.");
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    cadastrarCao();
                    break;
                case 2:
                    cadastrarGato();
                    break;
                case 3:
                    animalService.listarAnimais();
                    break;
                case 4:
                    removerAnimal();
                    break;
                case 5:
                    alterarStatus();
                    break;
                case 0:
                    System.out.println("Retornando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);
    }

    // ===== Cadastro de Cão =====
    private static void cadastrarCao() {
        System.out.println("\n--- Cadastro de Cão ---");
        String id = UUID.randomUUID().toString();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Idade (anos): ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Condição de saúde: ");
        String saude = scanner.nextLine();

        System.out.print("Temperamento: ");
        String temperamento = scanner.nextLine();

        System.out.print("Porte (pequeno, médio, grande): ");
        String porte = scanner.nextLine();

        System.out.print("Necessita passeios? (Sim / Não): ");
        boolean passeio = scanner.nextLine().trim().equalsIgnoreCase("sim");

        Animal cao = new Cao(nome, idade, saude, temperamento, porte, passeio);
        animalService.adicionarAnimal(cao);
    }

    // ===== Cadastro de Gato =====
    private static void cadastrarGato() {
        System.out.println("\n--- Cadastro de Gato ---");
        String id = UUID.randomUUID().toString();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Idade (anos): ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Condição de saúde: ");
        String saude = scanner.nextLine();

        System.out.print("Temperamento: ");
        String temperamento = scanner.nextLine();

        System.out.print("Convive com outros gatos? (Sim / Não): ");
        boolean convive = scanner.nextLine().trim().equalsIgnoreCase("sim");

        Animal gato = new Gato(nome, idade, saude, temperamento, convive);
        animalService.adicionarAnimal(gato);
    }

    // ===== Remoção de Animal por ID =====
    private static void removerAnimal() {
        System.out.print("Digite o ID do animal a ser removido: ");
        String id = scanner.nextLine();
        boolean removido = animalService.removerAnimalPorId(id);
        System.out.println(removido ? "Animal removido com sucesso." : "Animal não encontrado.");
    }

    // ===== Alteração de Status do Animal =====
    private static void alterarStatus() {
        System.out.print("Digite o ID do animal para alterar o status: ");
        String id = scanner.nextLine();
        animalService.alternarStatus(id);
    }

    // ===== Menu Adocoes ====
    private static void menuAdocoes(Scanner scanner, AdotanteService adotanteService,
                                    AnimalService animalService, AdocaoService adocaoService) {
        boolean gerenciando = true;

        while (gerenciando) {
            System.out.println("\n--- Gestão de Adoções ---");
            System.out.println("[1] Gerar Adoção");
            System.out.println("[2] Realizar Adoção");
            System.out.println("[3] Listar Adoções");
            System.out.println("[4] Voltar ao menu Prinical");
            System.out.print("Escolha uma opção: ");
            int opcao;

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite um número.");
                continue;
            }

            switch (opcao) {
                case 1:
                    adotanteService.listarAdotantes();
                    System.out.print("Digite o CPF do adotante: ");
                    String cpfAdotante = scanner.nextLine();
                    Adotante adotante = adotanteService.buscarAdotantePorId(cpfAdotante);
                    if (adotante == null) {
                        System.out.println("Adotante não encontrado.");
                        break;
                    }

                    animalService.listarAnimais();
                    System.out.print("Digite o ID do animal: ");
                    String idAnimal = scanner.nextLine();
                    Animal animal = animalService.buscarPorId(idAnimal);
                    if (animal == null) {
                        System.out.println("Animal não encontrado.");
                        break;
                    }

                    adocaoService.gerarAdocao(adotante, animal);
                    break;

                case 2:
                    System.out.print("Digite o CPF do adotante: ");
                    String cpfBusca = scanner.nextLine();
                    System.out.print("Digite o ID do animal: ");
                    String id = scanner.nextLine();
                    adocaoService.realizarAdocao(cpfBusca, id);
                    break;

                case 3:
                    adocaoService.listarAdocoesDetalhadas();
                    break;

                case 4:
                    gerenciando = false;
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}