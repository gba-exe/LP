package exe.gba;

public class AlunoGraduacao extends Aluno{
    private Double nota3;

    public AlunoGraduacao(String ra, String nome, Double nota1, Double nota2, Double nota3) {
        super(ra, nome, nota1, nota2);
        this.nota3 = nota3;
    }

    @Override
    public Double getMedia() {
        return super.getMedia() * .4 + this.nota3 * .6;
    }
}
