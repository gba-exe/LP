package exe.gba;

public class Main {
    public static void main(String[] args) {
        Aluno a1  = new Aluno("02231062", "Gabriel", 9.0, 8.75);

        AlunoGraduacao g1 = new AlunoGraduacao("02231007", "Giovanna", 10.0, 9.5, 9.9);

        System.out.println("Aluno: ");
        System.out.println(a1.getNome());
        System.out.println(a1.getMedia());

        System.out.println("-".repeat(15));

        System.out.println("Aluno Graduação: ");
        System.out.println(g1.getNome());
        System.out.println(g1.getMedia());
    }
}