package exe.gba;

public class Operador {
    public static void main(String[] args){

        /*
            +
            -
            *
            /
            %

            Math.pow(numero1, numero2); = Potencia
        */

        Integer numero1 = 10;
        Integer numero2 = 10;

        // Erro: String nome = 'Gabriel';
        Character x = 'x'; // So pode 1 caracter

        System.out.println("Soma: " + (numero1 + numero2));
        System.out.println("Multiplicação: " + (numero1 * numero2));

        Double numeroReal1 = 1.50;
        Double numeroReal2 = 5.00;

        Double resultado = numeroReal1 + numeroReal2;

        /*
             Operadores lógicos

             ==
             === (não existe pq n precisa comparar o tipo da variavel, lol)

             >
             <
             >=
             <=
             !=
             ||
             &&

            Não muda muito do JS
         */

        if(true){ /*funciona pq o if so precisa saber se o resultado é verdadeiro ou falso*/};

        if(numero1 == numero2){
            System.out.println("É igual");
        } else {
            System.out.println("Não é igual");
        }

    }
}
