package exe.gba;

public class Main {
    public static void main(String[] args) {
        VendedorComissao v1 = new VendedorComissao(1, "Hideki", 25.0, .10);

        VendedorComissaoMaisFixo v2 = new VendedorComissaoMaisFixo(1, "Giovana", 25.0, .10, 1000.0);

        System.out.println(v1.calcularSalario());

        System.out.println(v2.calcularSalario());
    }
}