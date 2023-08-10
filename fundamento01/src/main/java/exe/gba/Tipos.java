package exe.gba;

/*
    Classes -> representa um objeto
    Interface -> especie de contrato
    Enum -> enumeradores, lista
 */
public class Tipos {
    public static void main(String[] args) {
        String nome = "Gabriel";

        /*
            Em Java os tipos não são dinâmicos, ou seja, não tem como trocar o tipo da variavel depois de declarado
        */

        /*
            Mais usados (os com * nem tanto)
            -> Integer
            -> Double
            * BigDecimal
            * Float

            String - "Gabriel"

            Boolean = true, false
         */

        // variaveis camelCase

        Integer numeroInteiro = 10;
        Integer numeroInteiro2;

        //Não recomendável
        Integer num1, num2 = 20, num3;


        Double numeralReal = 0.10;

        // is ou has em booleans
        Boolean isPago = true;
        Boolean maiorIdade = false;

        /*

            Classes Wrapper x tipos primitivos

            Integer x int
            Double x double
            Boolean x boolean

            Os da esquerda são como uma classe que tem mais funções, ja os da direita são só o tipo da variavel, sem função nenhuma
         */

        System.out.println(nome + " " + numeroInteiro);
        System.out.println("Julio Furch");
    }
}