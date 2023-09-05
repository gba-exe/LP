package exe.gba.encomendas;

public class Main {
    public static void main(String[] args) {
        Encomenda encomenda = new Encomenda();

        encomenda.tamanho = "p";
        encomenda.enderecoRemetente = "Rua Banabuiu, 320";
        encomenda.enderecoDestinatario = "Rua dos Bobos, 0";

        encomenda.distancia = 55.0;
        encomenda.valorEncomenda = 100.0;

        encomenda.calcularFrete();
        encomenda.emitirEtiqueta();
    }
}
