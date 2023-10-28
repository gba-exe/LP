package org.example;

public class AlunoTecnologo extends Aluno{
    private Double nota1;
    private Double nota2;

    public AlunoTecnologo(String nome, String ra, Double nota1, Double nota2) {
        super(nome, ra);
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    @Override
    public Double calcularMedia() {
        return (nota1 + nota2) / 2;
    }
}
