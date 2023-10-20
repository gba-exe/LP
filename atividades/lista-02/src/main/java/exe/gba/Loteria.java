package exe.gba;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Loteria {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Integer numero;

        do {
            System.out.println("Escolha um numero entre 0 e 10: ");
            numero = leitor.nextInt();
        } while (numero < 0 || numero > 10);

        Integer random = ThreadLocalRandom.current().nextInt(0, 11);
        Integer contador = 0;

        while (random != numero){
            System.out.println(random);
            random = ThreadLocalRandom.current().nextInt(0, 11);

            contador++;
        }

        if (contador<=3){
            System.out.println("Você é MUITO sortudo");
        } else if (contador <=10) {
            System.out.println("Você é sortudo");
        } else {
            System.out.println("É melhor você parar de apostar e ir trabalhar");
        }

        // System.out.printf("Random: %d \nContador: %d", random, contador);
    }
}
