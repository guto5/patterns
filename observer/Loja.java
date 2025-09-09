package observer;

import java.util.ArrayList;
import java.util.List;

public class Loja {
    private List<Cliente> clientes = new ArrayList<>();

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void novoProduto(String modelo) {
        System.out.println("📢 Chegou um novo celular: " + modelo);
        for (Cliente c : clientes) {
            c.atualizar(modelo);
        }
    }
}
