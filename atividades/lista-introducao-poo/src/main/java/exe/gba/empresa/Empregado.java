package exe.gba.empresa;

public class Empregado {
    String nome = "";
    String cargo = "";
    Double salario = 0.0;

    void reajustarSalario (Double porcentagemReajuste){
        salario += salario * (porcentagemReajuste/100);
    }
}
