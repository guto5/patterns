package observer;

public class ClienteEmail implements Cliente {
    private String email;
    public ClienteEmail(String email) { this.email = email; }

    public void atualizar(String modelo) {
        System.out.println("📧 Email enviado para " + email + ": Novo celular disponível -> " + modelo);
    }
}
