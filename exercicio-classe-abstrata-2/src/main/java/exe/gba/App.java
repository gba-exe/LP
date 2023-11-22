package exe.gba;

import exe.gba.figura.Circulo;
import exe.gba.figura.Quadrado;
import exe.gba.figura.Retangulo;
import exe.gba.figura.Triangulo;

public class App {
    public static void main(String[] args) {
        Quadrado q1 = new Quadrado("azuj", 2, 5.0);
        Retangulo r1 = new Retangulo("vermei", 2, 5.0, 6.0);
        Triangulo t1 = new Triangulo("naranja", 2, 5.0, 6.0);
        Circulo c1 = new Circulo("azuj", 2, 3.0);

        Imagem imagem = new Imagem();

        imagem.adicionarFigura(q1);
        imagem.adicionarFigura(r1);
        imagem.adicionarFigura(t1);
        imagem.adicionarFigura(c1);

        imagem.exibeFiguras();

        imagem.exibeSomaArea();

        imagem.exibeFiguraAreaMaior20();

        imagem.exibeQuadrado();
    }
}