package exe.gba;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Acumulador {
    public static void main(String[] args) {
        Integer soma = 0, aleatorio;

        do {
            aleatorio = ThreadLocalRandom.current().nextInt(0,11);
            soma += aleatorio;

            // System.out.println(aleatorio);
        } while (aleatorio != 0);

        System.out.printf("A soma dos números é %d", soma);
    }
}
