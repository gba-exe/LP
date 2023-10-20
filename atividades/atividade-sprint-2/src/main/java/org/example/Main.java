package org.example;

public class Main {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("02231062","Gabriel");
        Aluno aluno2 = new Aluno("02231007","Giovanna");
        Aluno aluno3 = new Aluno("02231011","Neymar");
        Aluno aluno4 = new Aluno("02231008","Elano");
        Aluno aluno5 = new Aluno("02231010","Ganso");

        Turma cco1 = new Turma();
        Turma cco2 = new Turma();

        aluno1.adicionarNota(9.0);
        aluno1.adicionarNota(9.75);

        aluno2.adicionarNota(9.0);
        aluno2.adicionarNota(9.0);

        aluno3.adicionarNota(10.0);
        aluno3.adicionarNota(10.0);

        aluno4.adicionarNota(8.0);
        aluno4.adicionarNota(8.0);

        aluno5.adicionarNota(10.0);
        aluno5.adicionarNota(9.0);

        System.out.println("A média é de: %.2f".formatted(aluno1.calcularMedia()));
        System.out.println("A média é de: %.2f".formatted(aluno2.calcularMedia()));

        cco1.adicionarAluno(aluno1);
        cco1.adicionarAluno(aluno2);
        cco1.adicionarAluno(aluno3);
        cco1.adicionarAluno(aluno4);
        cco1.adicionarAluno(aluno5);

        System.out.println(cco1.getAlunoPorRa("02231062"));
        System.out.println(cco1.getAlunoPorNome("Gio"));

        System.out.println(cco1.getAlunoComMaiorMedia());
        System.out.println(cco1.getAlunoComMenorMedia());

        System.out.println(cco1.calcularMediaDaTurma());
        System.out.println(cco2.calcularMediaDaTurma());

        System.out.println(cco1.getMediaPorRa("02231011"));

        System.out.println(cco1.getMediana());
    }
}