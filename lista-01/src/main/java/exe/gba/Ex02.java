package exe.gba;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Quanto tempo, em minutos você passou se aquecendo? ");
        Integer tmpAquecendo = leitor.nextInt();

        System.out.println("Quanto tempo, em minutos você fez exercícios aeróbicos? ");
        Integer tmpAerobico = leitor.nextInt();

        System.out.println("Quanto tempo, em minutos você fez exercícios de musculação? ");
        Integer tmpMusculacao = leitor.nextInt();

        Integer caloriasPerdidas = (tmpAquecendo * 12) + (tmpAerobico * 20) + (tmpMusculacao * 25);
        Integer minutosTotais = tmpAquecendo + tmpAerobico + tmpMusculacao;

        System.out.printf("Olá, Jorge. Você fez um total de  %d minutos de exercícios e perdeu cerca de %d calorias", minutosTotais, caloriasPerdidas);
    }
}
