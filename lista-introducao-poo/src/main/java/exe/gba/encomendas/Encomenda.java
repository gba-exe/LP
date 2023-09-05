package exe.gba.encomendas;

public class Encomenda {
    String tamanho = "";
    String enderecoRemetente = "";
    
    String enderecoDestinatario = "";
    Double distancia = 0.0;
    Double valorEncomenda = 0.0;
    Double frete = 0.0;
    Double valorTotal = 0.0;
    
    void calcularFrete(){
        Double porcentagem = 0.0;
        Double precoKM = 0.0;
        
        if(tamanho.toUpperCase().equals("P")){
            porcentagem = 0.01;
        } else if (tamanho.toUpperCase().equals("M")) {
            porcentagem = 0.03;
        }else if (tamanho.toUpperCase().equals("G")) {
            porcentagem = 0.03;
        } else {
            System.out.println("Tamanho inválido");
        }

        if(distancia <= 50.0){
            precoKM = 3.00;
        } else if (distancia <= 200.0){
            precoKM = 5.00;
        } else {
            precoKM = 7.00;
        }

        frete += precoKM + (valorEncomenda * porcentagem);
        valorTotal += frete + valorEncomenda;
    }

    void emitirEtiqueta(){
        System.out.println(String.format("""
                ***** ETIQUETA PARA ENVIO *****
                Endereço do remetente: %s
                Endereço do destinatário: %s
                Tamanho: %s
                --------------------------------------------------
                Valor encomenda: R$ %.2f
                Valor frete: R$ %.2f
                --------------------------------------------------
                Valor total: R$ %.2f
                """, enderecoRemetente, enderecoDestinatario, tamanho, valorEncomenda, frete, valorTotal));
    }
}
