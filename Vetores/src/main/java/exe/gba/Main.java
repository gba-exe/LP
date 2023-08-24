package exe.gba;

public class Main {
    // Método
    public static void main(String[] args) {
        // variaveis declaradas sem valor são iguais a NULL
        // NullPointerException = variavel não inicializada
        Integer[] numerosInteiros1;

        // vetores em java sempre tem tamanho fixo
        Integer[] numerosInteiros2 = new Integer[5];

        Integer[] numerosInteiros3 = {1,2,3,4,5};

        Object[] objetos = new Object[1];

        for (int i = 0; i < numerosInteiros3.length; i++) {
            System.out.println(numerosInteiros3[i]);
        }
    }
}