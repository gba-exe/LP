package exe.gba.termometro;

public class TesteTermometro {
    public static void main(String[] args) {
        Termometro termometro = new Termometro();

        termometro.temperaturaAtual = 18.0;
        termometro.temperaturaMax = 24.0;
        termometro.temperaturaMin = 12.0;

        termometro.aumentaTemperatura(10.0);
        termometro.diminuiTemperatura(20.0);
        termometro.aumentaTemperatura(12.0);

        termometro.exibeFarenheit();
        termometro.exibe();
    }
}
