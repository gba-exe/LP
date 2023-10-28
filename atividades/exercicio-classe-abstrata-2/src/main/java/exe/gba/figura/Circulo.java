package exe.gba.figura;

public class Circulo extends Figura{
    private Double raio;

    public Circulo(String cor, Integer espessura, Double raio) {
        super(cor, espessura);
        this.raio = raio;
    }

    @Override
    public Double calcularArea() {
        return Math.PI * raio * raio;
    }

    @Override
    public String toString() {
        return "Circulo{" +
                "raio=" + raio +
                ", area=" + this.calcularArea() +
                "} " + super.toString();
    }
}
