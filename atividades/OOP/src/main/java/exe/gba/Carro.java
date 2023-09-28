package exe.gba;

public class Carro {
    String marca;
    String modelo;
    Integer anoLancamento;

    Double velocidadeAtual = 0.0;

    // Método
    void acelerar(){
        System.out.println("Vrummmmmmmmmmmmmmmmm...");
        velocidadeAtual += 2.5;
    }
    void frear(){
        System.out.println("jhgfjhdgfkgjlhlkjgj...");
        velocidadeAtual -= 2.5;
    }
}
