package exe.gba;

import exe.gba.funcionario.Horista;
import exe.gba.funcionario.Vendedor;

public class Main {
    public static void main(String[] args) {
        Vendedor v1 = new Vendedor("000000000", "Gabriel", 1000000.0, 0.3);
        Horista h1 = new Horista("1111111111", "Giovanna", 100, 10.0);

        Empresa empresa = new Empresa();

        empresa.adicionarFunc(v1);
        empresa.adicionarFunc(h1);

        empresa.exibeTodos();

        empresa.exibeTotalSalario();
    }
}