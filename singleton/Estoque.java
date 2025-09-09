package singleton;

public class Estoque {
    private static Estoque instancia;
    private int quantidade = 0;

    private Estoque() {}

    public static Estoque getInstancia() {
        if (instancia == null) {
            instancia = new Estoque();
        }
        return instancia;
    }

    public void adicionarCelular() {
        quantidade++;
        System.out.println("📦 Estoque: agora temos " + quantidade + " celulares.");
    }
}
