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

        Boolean isIgual = numero1 == numero2;

        //operadores ternários existem da mesma forma que no JS

        // ou seja

        // essa variável é igual a
        String mensagem =
                numero1 == numero2 ? "é igual" : "não é igual";

        // essa cadeia de if else
        if (isIgual){
            System.out.println("É igual");
        } else {
            System.out.println("Não é igual");
        }

        // o if para boolean é mais facil, não precisamos usar o ==, como por exemplo

        if(isIgual){
            System.out.println("condicional true");
        }

        if(!isIgual){
            System.out.println("condicional false");
        }

        /*
            outro operador condicional é o switch case

         */
        Integer numeroOpcao = 2;

        switch (numeroOpcao){ // aqui dizemos a variavel que queremos observar
            case 1: // caso a variavel seja igual a 1
                System.out.println("usuario escolheu 1");// printamos isso
            break;

            case 2: // caso a variavel seja igual a 2
                System.out.println("usuario escolheu 2");// printamos isso
                break;

            case 3: // caso a variavel seja igual a 3
                System.out.println("usuario escolheu 3");// printamos isso
                break;

            case 4: // caso a variavel seja igual a 4
                System.out.println("usuario escolheu 4");// printamos isso
                break;

            default: // é como se fosse um else, caso não encontre a comparação acima, ele solta o q tiver no default
                System.out.println("opção não encontrada");
        }
        //como se fosse if e else if, porém de uma vez só, ele compara todos, um if para várias condições basicamente

        /*
        case = if/else if
        default = else
         */
    }
}
