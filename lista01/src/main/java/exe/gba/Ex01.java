package exe.gba;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        System.out.println("Quantos filhos de 0 a 3 anos você tem? ");
        Integer qtdFilhos03 = leitor.nextInt();

        System.out.println("Quantos filhos de 4 a 16 anos você tem? ");
        Integer qtdFilhos416 = leitor.nextInt();

        System.out.println("Quantos filhos de 17 a 18 anos você tem? ");
        Integer qtdFilhos1718 = leitor.nextInt();

        Double bolsa = (qtdFilhos03 * 25.12) + (qtdFilhos416 * 15.88) + (qtdFilhos1718 * 12.44);
        Integer totalFilhos = qtdFilhos03 + qtdFilhos416 + qtdFilhos1718;

        System.out.println("Você tem um total de " + totalFilhos + " filhos e vai receber R$" + bolsa + " de bolsa");
    }
}