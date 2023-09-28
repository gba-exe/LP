package exe.gba;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        /*================== Sem vetor ======================*/
        /*Scanner leitor = new Scanner(System.in);
        Double totalNotas = 0.0;
        Double media = 0.0;
        String situacao;

        System.out.println("Informe o nome do aluno: ");
        String nome = leitor.nextLine();

        System.out.println("Informe a quantidade de notas: ");
        Integer qtdNotas = leitor.nextInt();

        for (int i = 0; i < qtdNotas; i++) {
            System.out.println(String.format("Informe a nota %d", i+1));
            totalNotas += leitor.nextDouble();
        }

        media = totalNotas / qtdNotas;

        situacao = media >= 6 ? "Aprovado" : "O aluno precisará se dedicar mais";


        System.out.println("-".repeat(20));
        System.out.println(String.format("Nome do aluno: %s", nome));
        System.out.println(String.format("Média: %.2f", media));
        System.out.println(String.format("Situação: %s", situacao));
        System.out.println("-".repeat(20));*/


        /*================== Sem vetor ======================*/
        Scanner leitor = new Scanner(System.in);
        Double[] notas;
        Double totalNotas = 0.0;
        Double media = 0.0;
        String situacao;

        System.out.println("Informe o nome do aluno: ");
        String nome = leitor.nextLine();

        System.out.println("Informe a quantidade de notas: ");
        Integer qtdNotas = leitor.nextInt();

         notas = new Double[qtdNotas];

        for (int i = 0; i < qtdNotas; i++) {
            System.out.println(String.format("Informe a nota %d", i+1));
            Double nota = leitor.nextDouble();
            notas[i] = nota;
        }

        for (int i = 0; i < notas.length; i++) {
            totalNotas += notas[i];
        }
        media = totalNotas / qtdNotas;

        situacao = media >= 6 ? "Aprovado" : "O aluno precisará se dedicar mais";


        System.out.println("-".repeat(20));
        System.out.println(String.format("Nome do aluno: %s", nome));
        System.out.println(String.format("Média: %.2f", media));
        System.out.println(String.format("Situação: %s", situacao));
        System.out.println("-".repeat(20));

        leitor.close();
    }
}
