package factory;

public class FabricaCelular {
    public static Celular criarCelular(String tipo) {
        switch (tipo.toLowerCase()) {
            case "iphone": return new Iphone();
            case "samsung": return new Samsung();
            case "xiaomi": return new Xiaomi();
            default: throw new IllegalArgumentException("Modelo não disponível");
        }
    }
}
