package exe.gba;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Integer tamanhoVetor;
        Integer total = 0;
        Boolean isRunning = true;

        System.out.println("Digite quantos números você quer adicionar: ");
        tamanhoVetor = leitor.nextInt();

        Integer[] vetor = new Integer[tamanhoVetor];


        for (int i = 0; i < tamanhoVetor; i++) {
            System.out.println(String.format("Digite o %dº número: ", i+1));
            Integer numero = leitor.nextInt();

            vetor[i] = numero;
            total += vetor[i];
        }

        System.out.println(total);

        leitor.close();
    }
}