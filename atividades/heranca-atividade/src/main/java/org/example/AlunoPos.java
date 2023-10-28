package org.example;

public class AlunoPos extends Aluno{
    private Double monografia;

    public AlunoPos(String nome, String ra, Double monografia) {
        super(nome, ra);
        this.monografia = monografia;
    }


    @Override
    public Double calcularMedia() {
        return null;
    }
}
