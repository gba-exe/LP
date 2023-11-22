package exe.gba;

import java.util.Scanner;

public class Tabuada {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        Integer opcao = -1;
        Boolean soma = false;
        Boolean mult = false;
        Boolean div = false;
        Boolean sub = false;
        Boolean pot = false;
        Boolean rest = false;

        System.out.println("""
                Digite o número correspondente a operação desejada:
                1 - Soma
                2 - Multiplicação
                3 - Divisão
                4 - Subtração
                5 - Potenciação
                6 - Resto
                0 - Sair
                """);
        opcao = leitor.nextInt();

        switch (opcao){
            case 1:
                soma = true;
                break;
            case 2:
                mult = true;
                break;
            case 3:
                div = true;
                break;
            case 4:
                sub = true;
                break;
            case 5:
                pot = true;
                break;
            case 6:
                rest = true;
                break;
            default:
                System.out.println("Até logo!");
                return;
        }

        System.out.println("Digite um número inteiro: ");
        Integer numero = leitor.nextInt();

        if (soma) {
            for (int i = 0; i < 10; i++) {
                System.out.printf("%d + %d = %d\n", numero, i+1, numero + (i + 1));
            }
        } else if (mult) {
            for (int i = 0; i < 10; i++) {
                System.out.printf("%d * %d = %d\n", numero, i+1, numero * (i + 1));
            }
        } else if (div) {
            for (int i = 0; i < 10; i++) {
                System.out.printf("%d / %d = %d\n", numero, i+1, numero / (i + 1));
            }
        } else if (sub) {
            for (int i = 0; i < 10; i++) {
                System.out.printf("%d - %d = %d\n1", numero, i+1, numero - (i + 1));
            }
        } else if (pot) {
            for (int i = 0; i < 10; i++) {
                System.out.printf("%d ^ %d = %.2f\n1", numero, i+1, Math.pow(numero,i + 1));
            }
        } else if (rest) {
            for (int i = 0; i < 10; i++) {
                System.out.printf("%d / %d = %d\n1", numero, i+1, numero % (i + 1));
            }
        }


    }
}
