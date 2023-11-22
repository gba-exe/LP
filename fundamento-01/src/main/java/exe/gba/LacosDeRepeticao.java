package exe.gba;

import java.util.Scanner;

public class LacosDeRepeticao {
    public static void main(String[] args) {

        // as estruturas de repeticoes são iguais as já vistas antes

        System.out.println("For de 0 a 10");

        for (Integer i = 0; i <= 10; i++) {
            System.out.println(i);
        }

        System.out.println("While de 0 a 10");

        Integer contador = 0;
        while (contador <= 10) {
            System.out.println(contador);
            contador++;
        }

        contador = 0;

        // mas temos o do while
        System.out.println("Do While de 0 a 10");

        Integer contador2 = 0;

        do {
            System.out.println(contador2);
            contador2++;
        } while (contador2 <= 10);

        // o do while realiza a instrução primeiro (tudo q tá dentro do Do) e só depois verifica a condição do while
        // util para perguntas pro usuario por exemplo

        Scanner leitor = new Scanner(System.in);
        Integer numero;

        do {
            System.out.println("Digite um número de 0 a 10: ");
            numero = leitor.nextInt();
        } while (numero < 0 || numero > 10);

        // ele pergunta pro usuario enquanto o numero não for de 0 a 10

        /*
         quando vc digita for aparecem 3 opções

         for = for cru, sem condições
         fori = for com a estrutura basica
         foreach = for para listas, veremos no futuro
         */
    }

}

