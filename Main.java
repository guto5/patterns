import singleton.Estoque;
import factory.*;
import observer.*;

public class Main {
    public static void main(String[] args) {
        // --- Singleton ---
        Estoque estoque = Estoque.getInstancia();
        estoque.adicionarCelular();

        // --- Factory ---
        Celular c1 = FabricaCelular.criarCelular("iphone");
        Celular c2 = FabricaCelular.criarCelular("samsung");
        c1.exibirDetalhes();
        c2.exibirDetalhes();

        // --- Observer ---
        Loja loja = new Loja();
        loja.adicionarCliente(new ClienteEmail("joao@email.com"));
        loja.adicionarCliente(new ClienteEmail("maria@email.com"));

        loja.novoProduto("iPhone 15 Pro");
    }
}
