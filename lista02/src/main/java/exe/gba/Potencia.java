package exe.gba;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Potencia {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Integer b;
        Integer e;
        Integer potencia;

        do {
            System.out.println("Escolha B (Positivo e inteiro): ");
            b = leitor.nextInt();

            System.out.println("Escolha E (Positivo e inteiro): ");
            e = leitor.nextInt();
        } while (b < 0 || e < 0);

        potencia = b;

        for (int i = 1; i < e; i++) {
            potencia = potencia * b;
            System.out.printf("Pontencia: %d \nI: %d\n",potencia,i);
        }

        System.out.println(potencia);
    }
}
