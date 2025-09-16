package observer;

import builder.Celular;

public class ClienteSMS implements Cliente {
  private String numeroTelefone;

  public ClienteSMS(String numeroTelefone) {
    this.numeroTelefone = numeroTelefone;
  }

  @Override
  public void atualizar(Celular novoCelular) {
    System.out.println("📲 SMS para [" + numeroTelefone + "]: Imperdivel! Novo " + novoCelular.toString() + " chegou em nossa loja. Corre pra ver!");
  }
}
