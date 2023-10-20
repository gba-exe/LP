package exe.gba.planocartesiano;

public class Ponto {
    private Integer x;
    private Integer y;

    public Ponto (Integer x, Integer y){
        this.x = x;
        this.y = y;
    }

    public void mover(int novoX, int novoY){
        this.x = novoX;
        this.y = novoY;
    }

    public Double getDistancia(Ponto outroPonto){
        Double distancia = Math.sqrt(Math.pow(outroPonto.x - this.x, 2) + Math.pow(outroPonto.y - this.y, 2));
        return distancia;
    }
}
