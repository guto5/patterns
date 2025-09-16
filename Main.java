import builder.Celular;
import observer.ClienteEmail;
import observer.ClienteSMS;
import observer.Loja;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Loja lojaPrincipal = new Loja("Tech Plus");
    private static List<Celular> celularesEmEstoque = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("===== Bem-vindo ao Sistema de Gerenciamento da Loja Tech Plus =====");
        lojaPrincipal.inscreverCliente(new ClienteEmail("vip.cliente@email.com"));
        lojaPrincipal.inscreverCliente(new ClienteSMS("+55999998888"));

        int opcao = -1;
        while (opcao != 0) {
            exibirMenu();
            try {
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        adicionarNovoCelular();
                        break;
                    case 2:
                        clonarCelularExistente();
                        break;
                    case 3:
                        inscreverNovoCliente();
                        break;
                    case 4:
                        listarCelularesEmEstoque();
                        break;
                    case 0:
                        System.out.println("\nSaindo do sistema... Até logo!");
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Por favor, digite um número válido.");
                scanner.nextLine();
                opcao = -1;
            }
            pressioneEnterParaContinuar();
        }

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n----------- MENU PRINCIPAL -----------");
        System.out.println("1. Adicionar novo celular (Builder)");
        System.out.println("2. Clonar celular existente (Prototype)");
        System.out.println("3. Inscrever novo cliente (Observer)");
        System.out.println("4. Listar celulares em estoque");
        System.out.println("0. Sair");
        System.out.println("------------------------------------");
    }

    // --- Ação 1: BUILDER ---
    private static void adicionarNovoCelular() {
        System.out.println("\n--- Adicionando Novo Celular (BUILDER) ---");
        try {
            System.out.print("Digite a marca: ");
            String marca = scanner.nextLine();
            System.out.print("Digite o modelo: ");
            String modelo = scanner.nextLine();
            System.out.print("Digite a memória (GB): ");
            int memoria = scanner.nextInt();
            System.out.print("Digite o preço (ex: 4999.90): ");
            double preco = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Digite a cor: ");
            String cor = scanner.nextLine();

            Celular novoCelular = new Celular.Builder(marca, modelo)
                    .memoria(memoria)
                    .preco(preco)
                    .cor(cor)
                    .build();

            celularesEmEstoque.add(novoCelular);
            // Ao adicionar, o OBSERVER é acionado automaticamente
            lojaPrincipal.adicionarNovoCelularAoEstoque(novoCelular);

        } catch (InputMismatchException e) {
            System.out.println("Erro de entrada. Por favor, insira os dados no formato correto.");
            scanner.nextLine();
        }
    }

    // --- Ação 2: PROTOTYPE ---
    private static void clonarCelularExistente() {
        System.out.println("\n--- Clonando Celular Existente (PROTOTYPE) ---");
        if (celularesEmEstoque.isEmpty()) {
            System.out.println("Nenhum celular em estoque para clonar. Adicione um primeiro.");
            return;
        }

        listarCelularesEmEstoque();
        System.out.print("Digite o número do celular que deseja clonar: ");

        try {
            int indice = scanner.nextInt() - 1;
            scanner.nextLine();

            if (indice < 0 || indice >= celularesEmEstoque.size()) {
                System.out.println("Número inválido!");
                return;
            }

            Celular original = celularesEmEstoque.get(indice);
            Celular clone = original.clone();

            System.out.println("\nCelular original selecionado:");
            original.exibirDetalhes();
            System.out.println("Modificando o clone...");

            System.out.print("Digite a NOVA memória (GB): ");
            clone.setMemoria(scanner.nextInt());
            System.out.print("Digite o NOVO preço: ");
            clone.setPreco(scanner.nextDouble());
            scanner.nextLine();
            System.out.print("Digite a NOVA cor: ");
            clone.setCor(scanner.nextLine());

            celularesEmEstoque.add(clone);
            // Ao adicionar o clone, o OBSERVER é acionado novamente
            lojaPrincipal.adicionarNovoCelularAoEstoque(clone);

        } catch (InputMismatchException e) {
            System.out.println("Erro de entrada. Por favor, insira um número válido.");
            scanner.nextLine();
        }
    }

    // --- Ação 3: OBSERVER ---
    private static void inscreverNovoCliente() {
        System.out.println("\n--- Inscrevendo Novo Cliente (OBSERVER) ---");
        System.out.print("Escolha o tipo de notificação (1 - Email, 2 - SMS): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        if (tipo == 1) {
            System.out.print("Digite o email do cliente: ");
            String email = scanner.nextLine();
            lojaPrincipal.inscreverCliente(new ClienteEmail(email));
        } else if (tipo == 2) {
            System.out.print("Digite o número de telefone do cliente: ");
            String telefone = scanner.nextLine();
            lojaPrincipal.inscreverCliente(new ClienteSMS(telefone));
        } else {
            System.out.println("Tipo de notificação inválido.");
        }
    }

    private static void listarCelularesEmEstoque() {
        System.out.println("\n--- Celulares Atualmente em Estoque ---");
        if (celularesEmEstoque.isEmpty()) {
            System.out.println("Estoque vazio.");
        } else {
            for (int i = 0; i < celularesEmEstoque.size(); i++) {
                System.out.print((i + 1) + ". ");
                celularesEmEstoque.get(i).exibirDetalhes();
            }
        }
    }

    private static void pressioneEnterParaContinuar() {
        System.out.println("\n[Pressione Enter para continuar...]");
        scanner.nextLine();
    }
}