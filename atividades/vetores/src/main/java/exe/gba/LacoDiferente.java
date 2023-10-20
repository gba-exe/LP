package exe.gba;

import java.util.ArrayList;
import java.util.List;

public class LacoDiferente {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();

        nomes.add("Gabriel");
        nomes.add("Giovanna");
        nomes.add("Hideki");
        nomes.add("Nicolas");
        nomes.add("Bárbara");

        for (int i = 0; i < nomes.size(); i++) {
            System.out.println(nomes.get(i));
        }

        System.out.println("-".repeat(20));

        for(String nomeDaVez : nomes){
            System.out.println(nomeDaVez);
        }
    }

}
