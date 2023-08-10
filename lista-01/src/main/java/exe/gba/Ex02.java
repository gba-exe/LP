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

        System.out.println("");
    }
}
