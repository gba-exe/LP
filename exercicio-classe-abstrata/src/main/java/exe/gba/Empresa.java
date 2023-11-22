package exe.gba;

import exe.gba.funcionario.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private List<Funcionario> funcionarios = new ArrayList<>();

    public void adicionarFunc (Funcionario f) {
        funcionarios.add(f);
    }

    public void exibeTodos () {
        System.out.println(funcionarios);
    }

    public void exibeTotalSalario (){
        double totalSalario = 0.0;
        for (Funcionario funcionarioAtual :
                funcionarios) {
            totalSalario += funcionarioAtual.calcSalario();
        }

        System.out.println(totalSalario);
    }
}
