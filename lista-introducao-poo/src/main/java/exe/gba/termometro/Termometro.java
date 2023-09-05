package exe.gba.termometro;

public class Termometro {
    Double temperaturaAtual = 0.0;
    Double temperaturaMax = 0.0;
    Double  temperaturaMin = 0.0;

    void aumentaTemperatura(Double valorAumento){
        temperaturaAtual += valorAumento;
        if (temperaturaMax<temperaturaAtual){
            temperaturaMax = temperaturaAtual;
        }
    }
    void diminuiTemperatura(Double valorQueda){
        temperaturaAtual -= valorQueda;
        if (temperaturaAtual<temperaturaMin){
            temperaturaMin = temperaturaAtual;
        }
    }

    void exibeFarenheit(){
        Double farenheit = temperaturaAtual * 1.8 + 32;
        System.out.println(String.format("""
                            ========== Farenheit ==========
                            Temperatura Atual: %.1f
                            ===============================
                            """, farenheit));
    }
    void exibe(){
        System.out.println(String.format("""
                            ========== Farenheit ==========
                            Temperatura Atual: %.1f
                            Temperatura Máxima: %.1f
                            Temperatura Mínima: %.1f
                            ===============================
                            """, temperaturaAtual, temperaturaMax, temperaturaMin));
    }
}
