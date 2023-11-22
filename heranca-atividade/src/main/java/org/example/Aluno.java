package org.example;

public abstract class Aluno {
    private String nome;
    private String ra;
    private Double nota1;
    private Double nota2;

    public Aluno(String nome, String ra) {
        this.nome = nome;
        this.ra = ra;
    }

    public abstract Double calcularMedia ();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public Double getNota1() {
        return nota1;
    }

    public void setNota1(Double nota1) {
        this.nota1 = nota1;
    }

    public Double getNota2() {
        return nota2;
    }

    public void setNota2(Double nota2) {
        this.nota2 = nota2;
    }
}
