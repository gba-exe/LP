package exe.gba;

import exe.gba.figura.Figura;
import exe.gba.figura.Quadrado;

import java.util.ArrayList;
import java.util.List;

public class Imagem {
    public List<Figura> figuras = new ArrayList<>();

    public void adicionarFigura (Figura f) {
        figuras.add(f);
    }

    public void exibeFiguras () {
        System.out.println(figuras);
    }

    public void exibeSomaArea () {
        Double somaArea = 0.0;

        for (Figura figuraAtual :
                figuras) {
            somaArea += figuraAtual.calcularArea();
        }

        System.out.println(somaArea);
    }

    public void exibeFiguraAreaMaior20 () {
        for (Figura figuraAtual :
                figuras) {
            if (figuraAtual.calcularArea() > 20) {
                System.out.println(figuraAtual);
            }
        }
    }

    public void exibeQuadrado () {
        for (Figura figuraAtual :
                figuras) {
            if (figuraAtual instanceof Quadrado) {
                System.out.println(figuraAtual);
            }
        }
    }


}
