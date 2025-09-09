import builder.Celular;
import prototype.CelularPrototype;
import observer.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== Loja de Celulares =====\n");

        // --- Builder ---
        System.out.println("BUILDER - Criar celular personalizado");
        System.out.print("Digite o modelo do celular: ");
        String modelo = sc.nextLine();

        Celular celularCustom = new Celular.Builder()
                .marca("Apple")
                .modelo(modelo)
                .memoria(128)
                .preco(3999.90)
                .build();

        celularCustom.exibirDetalhes();

        // --- Prototype ---
        System.out.println("\nPROTOTYPE - Clonar celular base");
        CelularPrototype base = new CelularPrototype("Samsung", "S24", 128, 4999.90);
        CelularPrototype clone = base.clonar();

        System.out.print("Digite o novo preço para o clone: ");
        double novoPreco = sc.nextDouble();
        sc.nextLine();

        clone.setPreco(novoPreco);

        base.exibirDetalhes();
        clone.exibirDetalhes();

        // --- Observer ---
        System.out.println("\nOBSERVER - Notificação de cliente");
        Loja loja = new Loja();
        loja.adicionarCliente(new ClienteEmail("cliente@email.com"));

        System.out.print("Digite o novo produto que chegou: ");
        String novoProduto = sc.nextLine();

        loja.novoProduto(novoProduto);

        sc.close();
    }
}
