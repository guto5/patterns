package observer;

import builder.Celular;

public class ClienteEmail implements Cliente {
    private String email;

    public ClienteEmail(String email) {
        this.email = email;
    }

    @Override
    public void atualizar(Celular novoCelular) {
        System.out.println("📧 Email enviado para [" + email + "]: Olá! O novo " + novoCelular.toString() + " já está disponível em nossa loja. Não perca!");
    }
}
