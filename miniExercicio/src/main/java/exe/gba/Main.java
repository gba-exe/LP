package exe.gba;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Scanner leitorNumero = new Scanner(System.in);

        System.out.println("Digite sua meta: ");
        Cofre cofrinho = new Cofre(leitor.nextLine(), 10.0);

        System.out.println(cofrinho);

//        cofrinho.setMeta(leitor.nextLine());

        while (true){
            System.out.println(String.format("Meta: %s", cofrinho.getMeta()));
            System.out.println("""
                    Escolha uma opção:
                    1 - Depositar
                    2 - Balançar
                    3 - Quebrar
                    0 - Sair
                    """);
            Integer opcao = leitor.nextInt();

            switch (opcao){
                case 1:
                    System.out.println("Digite o valor a ser depositado: ");
                    Double deposito = leitorNumero.nextDouble();
                    cofrinho.depositar(deposito);
                    break;
                case 2:
                    cofrinho.balancar();
                    break;
                case 3:
                    cofrinho.quebrar();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Valor Inválido");
            }
            System.out.println("\n");
        }
    }
}