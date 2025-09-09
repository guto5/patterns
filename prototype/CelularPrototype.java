package prototype;

public class CelularPrototype implements Cloneable {
  private String marca;
  private String modelo;
  private int memoria;
  private double preco;

  public CelularPrototype(String marca, String modelo, int memoria, double preco) {
    this.marca = marca;
    this.modelo = modelo;
    this.memoria = memoria;
    this.preco = preco;
  }

  public CelularPrototype clonar() {
    try {
      return (CelularPrototype) this.clone();
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
  }

  public void setMemoria(int memoria) {
    this.memoria = memoria;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }

  public void exibirDetalhes() {
    System.out.println("📱 " + marca + " " + modelo + " - " + memoria + "GB - R$" + preco);
  }
}
