package exe.gba;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DesafioNumeros {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        List<Integer> numerosInteiros = new ArrayList<>();

        Integer total = 0;
        Integer menorNumero = 0;
        Integer maiorNumero = 0;

        while (true) {
            System.out.println("Digite um número inteiro: ");
            Integer numero = leitor.nextInt();

            if (numero == 0){
                break;
            } else {
                numerosInteiros.add(numero);
            }
        }

        System.out.println("Números pares: ");
        for (Integer numeroAtual: numerosInteiros) {
            if (numeroAtual%2 == 0){
                System.out.println(numeroAtual);
            }
        }

        System.out.println("\nNúmeros ímpares: ");
        for (Integer numeroAtual: numerosInteiros) {
            if (numeroAtual%2 != 0){
                System.out.println(numeroAtual);
            }
        }

        System.out.println("Soma de todos os números: ");
        for (Integer numeroAtual: numerosInteiros) {
            total += numeroAtual;
        }
        System.out.println(total);

        System.out.println("Menor número: ");
        menorNumero = numerosInteiros.get(0);
        for (Integer numeroAtual: numerosInteiros) {
            if (numeroAtual < menorNumero){
                menorNumero = numeroAtual;
            }
        }
        System.out.println(menorNumero);

        System.out.println("Maior número: ");
        for (Integer numeroAtual: numerosInteiros) {
            if (numeroAtual > maiorNumero){
                maiorNumero = numeroAtual;
            }
        }
        System.out.println(maiorNumero);
    }
}
