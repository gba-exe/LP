package exe.gba.empresa;

public class TesteEmpregado {
    public static void main(String[] args) {
        Empregado empregado = new Empregado();

        empregado.nome = "João";
        empregado.salario = 5400.00;
        empregado.cargo = "Analista de Sistemas";

        System.out.println(String.format("""
                ========= Pré Reajuste =========
                Nome: %s
                Salário: R$ %.2f
                Cargo: %s
                ================================
                """, empregado.nome, empregado.salario, empregado.cargo));

        empregado.reajustarSalario(15.0);

        System.out.println(String.format("""
                ========= Pós Reajuste =========
                Nome: %s
                Salário: R$ %.2f
                Cargo: %s
                ================================
                """, empregado.nome, empregado.salario, empregado.cargo));

        Empregado empregado2 = new Empregado();

        empregado2.nome = "Gabriel";
        empregado2.salario = 800000.00;
        empregado2.cargo = "CTO";

        System.out.println(String.format("""
                ========= Pré Reajuste =========
                Nome: %s
                Salário: R$ %.2f
                Cargo: %s
                ================================
                """, empregado2.nome, empregado2.salario, empregado2.cargo));

        empregado2.reajustarSalario(-20.0);

        System.out.println(String.format("""
                ========= Pós Reajuste =========
                Nome: %s
                Salário: R$ %.2f
                Cargo: %s
                ================================
                """, empregado2.nome, empregado2.salario, empregado2.cargo));

    }
}
