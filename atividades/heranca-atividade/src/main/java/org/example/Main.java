package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
            Aluno de pos
            Aluno de bacharelado
            Aluno de tecnologo
         */

        List<Aluno> alunos = new ArrayList<>();

        AlunoPos p1 = new AlunoPos("Gabriel", "12345", 10.0);

        AlunoPos p2 = new AlunoPos( "Gio", "54321",10.0);

        alunos.add(p1);
        alunos.add(p2);

        AlunoTecnologo tec1 = new AlunoTecnologo("Vitor", "99999", 10.0, 8.0);

        alunos.add(tec1);

        System.out.println(tec1.calcularMedia());
    }
}