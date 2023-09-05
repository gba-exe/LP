package exe.gba.progressaoaritmetica;

import exe.gba.progressaoaritmetica.ProgressaoAritmetica;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        ProgressaoAritmetica pa = new ProgressaoAritmetica();

        System.out.println("Digite o primeiro termo da progressão aritmética: ");
        pa.setPrimeiroTermo(leitor.nextDouble());

        System.out.println("Digite a razão da progressão aritmética: ");
        pa.setRazao(leitor.nextDouble());

        System.out.println("Digite a posição do número que quer: ");
        System.out.println(pa.calcularTermo(leitor.nextInt()));
    }
}