package exe.gba.planocartesiano;

public class TestePonto {
    public static void main(String[] args) {
        Ponto pontoA = new Ponto(4,1);
        Ponto pontoB = new Ponto(1,3);

        pontoA.mover(1,1);
        pontoB.mover(3,1);

        pontoA.getDistancia(pontoB);
    }
}
