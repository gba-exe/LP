package exe.gba;

import java.util.Scanner;

public class CalculoMedia {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Qual o seu nome? ");
        String nomeUsuario = leitor.nextLine();

        System.out.println("Qual a sua primeira nota? ");
        Integer n1 = leitor.nextInt();

        System.out.println("Qual a sua segunda nota? ");
        Integer n2 = leitor.nextInt();

        Integer media = (n1 + n2) / 2;

        System.out.println("Olá " + nomeUsuario + ". Sua média foi de " + media);
    }
}
