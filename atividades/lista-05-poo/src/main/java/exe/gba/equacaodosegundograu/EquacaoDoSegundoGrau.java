package exe.gba.equacaodosegundograu;

import java.util.ArrayList;
import java.util.List;

public class EquacaoDoSegundoGrau {
    private Integer a;
    private Integer b;
    private Integer c;
    private List<Double> raizes = new ArrayList<>();

    public EquacaoDoSegundoGrau(Integer a, Integer b, Integer c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public List calcularRaizes(){
        Double delta = Math.pow(b,2)-4*a*c;
        Double raiz1 = (-b - Math.sqrt(delta))/ 2*a;
        Double raiz2 = (-b + Math.sqrt(delta))/ 2*a;


        if (delta > 0.0){
            raizes.add(raiz1);
            raizes.add(raiz2);
        } else if (delta == 0.0){
            raizes.add(raiz1);
        }

        return raizes;
    }
}
