package exe.gba;

public class Main {
    public static void main(String[] args) {
        /*
        Carro carro1 = new Carro();
        Carro carro2 = new Carro();

        carro1.modelo = "Monza Tubarão";
        carro1.marca = "Chevrolet";
        carro1.anoLancamento = 1991;

        carro2.modelo = "Caravan";
        carro2.marca = "Chevrolet";
        carro2.anoLancamento = 1977;

        System.out.println(String.format("Carrito 1: %s %s",carro1.marca, carro1.modelo));
        System.out.println(String.format("Carrito 2: %s %s",carro2.marca, carro2.modelo));

        carro1.acelerar();
         */

        // Instância
        Calculadora calculadora = new Calculadora();

        calculadora.somar(3, 2);

        System.out.println("Fim");
    }
}