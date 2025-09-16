package builder;

public class Celular implements Cloneable {
  private String marca;
  private String modelo;
  private int memoria;
  private double preco;
  private String cor;

  // Construtor privado para forçar o uso do Builder
  private Celular(Builder builder) {
    this.marca = builder.marca;
    this.modelo = builder.modelo;
    this.memoria = builder.memoria;
    this.preco = builder.preco;
    this.cor = builder.cor;
  }

  public void exibirDetalhes() {
    System.out.println(
            String.format("📱 %s %s (%s) - %dGB - R$ %.2f",
                    this.marca, this.modelo, this.cor, this.memoria, this.preco)
    );
  }

  // --- Implementação do Prototype ---
  @Override
  public Celular clone() {
    try {
      return (Celular) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new AssertionError("Não foi possível clonar o objeto Celular", e);
    }
  }

  // Setters para modificar as propriedades do objeto clonado
  public void setMemoria(int memoria) {
    this.memoria = memoria;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }

  public void setCor(String cor) {
    this.cor = cor;
  }

  @Override
  public String toString() {
    return marca + " " + modelo + " " + memoria + "GB (" + cor + ")";
  }

  // --- Builder ---
  public static class Builder {
    private final String marca;
    private final String modelo;

    private int memoria = 128;
    private double preco = 0.0;
    private String cor = "Preto";

    public Builder(String marca, String modelo) {
      this.marca = marca;
      this.modelo = modelo;
    }

    public Builder memoria(int memoria) {
      this.memoria = memoria;
      return this;
    }

    public Builder preco(double preco) {
      this.preco = preco;
      return this;
    }

    public Builder cor(String cor) {
      this.cor = cor;
      return this;
    }

    public Celular build() {
      return new Celular(this);
    }
  }
}