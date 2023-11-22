package exe.gba.confeitaria;

public class Bolo {
    String sabor = "";
    Double valor = 0.0;
    Integer quantidadeVendida = 0;

    void comprarBolo(Integer qtdBolo){
        if(quantidadeVendida + qtdBolo > 100){
            System.out.println("Seu pedido ultrapassou nosso limite diário para esse bolo.");
        } else {
            quantidadeVendida += qtdBolo;
        }
    }

    void exibirRelatorio(){
        Double total = valor * quantidadeVendida;

        System.out.println(String.format("O bolo de %s , foi comprado %d vezes hoje, totalizando R$ %.2f", sabor, quantidadeVendida, total));
    }
}
