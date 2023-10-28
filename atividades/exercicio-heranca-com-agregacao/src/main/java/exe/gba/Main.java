package exe.gba;

import exe.gba.dev.Dev;
import exe.gba.dev.DevMobile;

public class Main {
    public static void main(String[] args) {
        Dev dev1 = new Dev("Gabriel", 100, 100.0);
        Dev dev2 = new Dev("Vitor", 100, 100.0);
        DevMobile devMobile = new DevMobile("Giovanna", 100, 100.0, 100, 200.0);

        Consultoria consultoria = new Consultoria("SPTECH", 3);

        consultoria.contratar(dev1);
        consultoria.contratar(dev2);
        consultoria.contratar(devMobile);

        System.out.println(consultoria.existePorNome("Vitor"));

        System.out.println(consultoria.getQuantidadeDevs());
        System.out.println(consultoria.getQuantidadeDevsMobile());

        System.out.println(consultoria.getTotalSalarios());

        System.out.println(consultoria.getDevPorNome("Giovanna"));
    }
}