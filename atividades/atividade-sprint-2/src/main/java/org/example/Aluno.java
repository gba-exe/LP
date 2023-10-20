package org.example;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String ra;
    private String nome;
    private List<Double> listaNotas;

    public Aluno(String ra, String nome) {
        this.ra = ra;
        this.nome = nome;
        this.listaNotas = new ArrayList<>();
    }

    public String getRa() {
        return ra;
    }

    public String getNome() {
        return nome;
    }

    public void adicionarNota (Double nota){
        if (nota >= 0 && nota <= 10) {
            listaNotas.add(nota);
            System.out.println("Nota adicionada!");
        } else {
            System.out.println("Nota inválida! ");
        }
    }

    public Double calcularMedia () {
        Double media = 0.0;

        for (Double notaAtual:
             listaNotas) {
            media += notaAtual;
        }

        return media / listaNotas.size();
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "ra='" + ra + '\'' +
                ", nome='" + nome + '\'' +
                ", listaNotas=" + listaNotas +
                '}';
    }
}
