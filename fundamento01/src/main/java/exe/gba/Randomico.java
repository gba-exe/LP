package exe.gba;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Randomico {
    public static void main(String[] args) {
        Integer aleatorio1 = ThreadLocalRandom.current().nextInt();//podemos criar um numero aleatorio com esse argumento
        System.out.println("1: " + aleatorio1);

        //limitando aleatorio
        Integer aleatorio2 = ThreadLocalRandom.current().nextInt(11); // bound é limite onde termina, mas ele termina sempre um antes do numero, nesse caso ele vai de 0 a 10 ignorando o 11
        System.out.println("2: " + aleatorio2);

        //escolhendo o numero inicial
        Integer aleatorio3 = ThreadLocalRandom.current().nextInt(5, 11);// origin é o numero inicial, nesse caso o 5 também será sorteado (esse aleatorio vai de 5 a 10)
        System.out.println("3: " + aleatorio3);

        Double aleatorioReal = ThreadLocalRandom.current().nextDouble(0,10.1);
        System.out.printf("4: %f", aleatorioReal); //interpolação é feita com %f para doubles e após a virgula vc coloca a variavel q quer adicionar, para string é %s

        /*
        double %f
        inteiro %d
        texto %s
         */

        // interpolação exemplos

        Scanner leitor = new Scanner(System.in);

        System.out.println("Quanto tempo, em minutos você passou se aquecendo? ");
        Integer tmpAquecendo = leitor.nextInt();

        System.out.println("Quanto tempo, em minutos você fez exercícios aeróbicos? ");
        Integer tmpAerobico = leitor.nextInt();

        System.out.println("Quanto tempo, em minutos você fez exercícios de musculação? ");
        Integer tmpMusculacao = leitor.nextInt();

        Integer caloriasPerdidas = (tmpAquecendo * 12) + (tmpAerobico * 20) + (tmpMusculacao * 25);
        Integer minutosTotais = tmpAquecendo + tmpAerobico + tmpMusculacao;

        System.out.printf("Olá, Jorge. Você fez um total de %d minutos de exercícios e perdeu cerca de %d calorias", minutosTotais, caloriasPerdidas);
        // vc escreve o texto que quer e no lugar das variaveis adiciona o tipo, apos isso as adiciona após a frase com virgulas em orde de como elas aparecem
    }
}
