package builder;

public class Celular {
  private String marca;
  private String modelo;
  private int memoria;
  private double preco;

  private Celular(Builder builder) {
    this.marca = builder.marca;
    this.modelo = builder.modelo;
    this.memoria = builder.memoria;
    this.preco = builder.preco;
  }

  public void exibirDetalhes() {
    System.out.println("📱 " + marca + " " + modelo + " - " + memoria + "GB - R$" + preco);
  }

  // --- Builder interno ---
  public static class Builder {
    private String marca;
    private String modelo;
    private int memoria;
    private double preco;

    public Builder marca(String marca) {
      this.marca = marca;
      return this;
    }

    public Builder modelo(String modelo) {
      this.modelo = modelo;
      return this;
    }

    public Builder memoria(int memoria) {
      this.memoria = memoria;
      return this;
    }

    public Builder preco(double preco) {
      this.preco = preco;
      return this;
    }

    public Celular build() {
      return new Celular(this);
    }
  }
}
