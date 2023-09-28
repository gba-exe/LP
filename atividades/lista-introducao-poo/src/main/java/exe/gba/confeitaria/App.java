package exe.gba.confeitaria;

public class App {
    public static void main(String[] args) {
        Bolo boloMorango = new Bolo();
        Bolo boloChocolate = new Bolo();
        Bolo boloAbacaxi = new Bolo();

        boloMorango.sabor = "Morango";
        boloMorango.valor = 40.0;

        boloChocolate.sabor = "Chocolate";
        boloChocolate.valor = 50.0;

        boloAbacaxi.sabor = "Abacaxi";
        boloAbacaxi.valor = 30.0;

        boloMorango.comprarBolo(10);
        boloMorango.comprarBolo(20);

        boloChocolate.comprarBolo(40);
        boloChocolate.comprarBolo(50);

        boloAbacaxi.comprarBolo(50);
        boloAbacaxi.comprarBolo(100);
        boloAbacaxi.comprarBolo(50);

        boloMorango.exibirRelatorio();
        boloChocolate.exibirRelatorio();
        boloAbacaxi.exibirRelatorio();
    }
}