package observer;

import builder.Celular;

import java.util.ArrayList;
import java.util.List;

public class Loja {
    private String nome;
    private List<Cliente> clientesInscritos = new ArrayList<>();
    private List<Celular> estoque = new ArrayList<>();

    public Loja(String nome) {
        this.nome = nome;
    }

    public void inscreverCliente(Cliente cliente) {
        clientesInscritos.add(cliente);
        System.out.println("✅ Cliente inscrito para receber notificações da loja " + nome + ".");
    }

    public void desinscreverCliente(Cliente cliente) {
        clientesInscritos.remove(cliente);
    }

    public void adicionarNovoCelularAoEstoque(Celular celular) {
        System.out.println("\n=======================================================");
        System.out.println("✨ Novo produto adicionado ao estoque da loja " + nome + "!");
        celular.exibirDetalhes();
        System.out.println("=======================================================");

        estoque.add(celular);
        notificarClientes(celular);
    }

    private void notificarClientes(Celular celular) {
        System.out.println("📢 Notificando " + clientesInscritos.size() + " cliente(s) sobre a novidade...");
        for (Cliente cliente : clientesInscritos) {
            cliente.atualizar(celular);
        }
    }
}
