package exe.gba;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fruta {
    public static void main(String[] args) {
        List<String> frutas = new ArrayList<>();

        Scanner leitor = new Scanner(System.in);

        frutas.add("banana");
        frutas.add("maçã");
        frutas.add("melão");
        frutas.add("melancia");
        frutas.add("pêra");

        System.out.println("Digite o nome da fruta que quer buscar.");
        String nome = leitor.nextLine();

        for (String frutaDaVez : frutas) {
            if (frutaDaVez.equals(nome.toLowerCase())) {
                System.out.printf("A fruta %s existe na lista", nome);
                return;
            }
        }

        System.out.printf("Não existe a fruta %s na lista", nome);
    }
}
