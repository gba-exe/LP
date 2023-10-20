package exe.gba;

import java.util.Scanner;

public class CalculadoraTroco {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Qual o valor unitário do produto? ");
        Integer valUnitario = leitor.nextInt();

        System.out.println("Qual a quantidade vendida? ");
        Integer qtdVendida = leitor.nextInt();

        System.out.println("Qual o valor pago pelo cliente? ");
        Integer valCliente = leitor.nextInt();

        Integer troco = valCliente - (valUnitario * qtdVendida);

        System.out.println("Seu troco será de R$" + troco);
    }
}
