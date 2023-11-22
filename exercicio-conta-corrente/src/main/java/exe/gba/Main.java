package exe.gba;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        ContaCorrente contaGabriel = new ContaCorrente("Gabriel Bazante de Araújo", 1000.00);
        System.out.println(contaGabriel);


        Historico operacao1 = new Historico(LocalDateTime.now(), "Comprar camiseta do Santos");
        contaGabriel.sacar(300.0, operacao1);

        System.out.println(contaGabriel);


        Historico operacao2 = new Historico(LocalDateTime.now(), "Vender caneca do Santos");
        contaGabriel.depositar(80.0, operacao2);

        System.out.println(contaGabriel);


        Historico operacao3 = new Historico(LocalDateTime.now(), "Comprar calça do Santos");
        contaGabriel.sacar(100.0, operacao3);

        System.out.println(contaGabriel);

        Historico operacao4 = new Historico(LocalDateTime.now(), "Comprar chuteira do Santos");
        contaGabriel.sacar(500.0, operacao4);

        System.out.println(contaGabriel);

        Historico operacao5 = new Historico(LocalDateTime.now(), "Comprar o Santos");
        contaGabriel.sacar(50000000000000000000000000000000000000000000000.0, operacao4);

        System.out.println(contaGabriel);

        contaGabriel.exibirExtrato();

        System.out.println(contaGabriel);
    }
}