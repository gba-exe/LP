package exe.gba;

import java.util.Scanner;

public class Leitura {
    public static void main(String[] args) {
        // recebendo input de usuários:

        Scanner leitor = new Scanner(System.in);

        /*
        Scanner = tipo
        leitor = nome
        new = novo
        System.in = entrada padrão do sistema (assim como System.out é a saída padrão)

         O método scanner pode receber vários valores dentro do parenteses, mas por enquanto estaremos so usando o System.in
         */

        System.out.println("Digite seu nome: ");
        String nomeDigitado = leitor.nextLine(); //quando chegar nessa linha o codigo vai parar esperando o usuario digitar algo

        System.out.println("Olá " + nomeDigitado);

        // se quiser ler números é diferente
        System.out.println("Agora digite sua idade: ");
        Integer idadeDigitada = leitor.nextInt(); //muda somente a função q nesse caso vira nextInt(), mas existem outras como nextDouble()

        String mensagem = idadeDigitada > 30 ? "Véão" : "Jofem";
        //.next() ou .nextLine()?
        // o .nextLine() pula uma linha apos digitado e é mais recomendado
    }
}
