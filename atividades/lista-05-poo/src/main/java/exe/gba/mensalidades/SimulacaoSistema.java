package exe.gba.mensalidades;

public class SimulacaoSistema {
    public static void main(String[] args) {
        Estudante estudante = new Estudante("Manoel Gomes", "CCO", 1500.00);

        System.out.println(estudante.getMensalidade());
        estudante.aplicarDesconto(10.0);

        System.out.println(estudante.getNome());
        System.out.println(estudante.getCurso());
        System.out.println(estudante.getMensalidade());

        estudante.trancarMatricula();
        estudante.aplicarDesconto(5.0);
    }
}
