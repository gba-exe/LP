package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Turma {
    private List<Aluno> listaAlunos = new ArrayList<>();

    public void adicionarAluno (Aluno aluno) {
        this.listaAlunos.add(aluno);
    }

    public Aluno getAlunoPorRa (String ra) {
        for (Aluno alunoAtual:
             listaAlunos) {
            if (alunoAtual.getRa().equals(ra)) {
                return alunoAtual;
            }
        }

        return null;
    }

    public Aluno getAlunoPorNome (String nome){
        for (Aluno alunoAtual:
             listaAlunos) {
            if (alunoAtual.getNome().contains(nome)) {
                return alunoAtual;
            }
        }
        return null;
    }

    public Aluno getAlunoComMaiorMedia () {
        Double maiorMedia = listaAlunos.get(0).calcularMedia();
        Aluno alunoMaiorMedia = null;

        for (Aluno alunoAtual:
             listaAlunos) {
            if (alunoAtual.calcularMedia() >= maiorMedia) {
                maiorMedia = alunoAtual.calcularMedia();
                alunoMaiorMedia = alunoAtual;
            }
        }

        return alunoMaiorMedia;
    }
    public Aluno getAlunoComMenorMedia () {
        Double menorMedia = listaAlunos.get(0).calcularMedia();
        Aluno alunoMaiorMedia = null;

        for (Aluno alunoAtual:
             listaAlunos) {
            if (alunoAtual.calcularMedia() <= menorMedia) {
                menorMedia = alunoAtual.calcularMedia();
                alunoMaiorMedia = alunoAtual;
            }
        }

        return alunoMaiorMedia;
    }

    public Double  calcularMediaDaTurma () {
        Double mediaTurma = 0.0;

        for (Aluno alunoAtual:
             listaAlunos) {
            mediaTurma += alunoAtual.calcularMedia();
        }

        return mediaTurma > 0.0 ? mediaTurma / listaAlunos.size() : 0.0;
    }

    public Double getMediaPorRa (String ra) {
        for (Aluno alunoAtual:
                listaAlunos) {
            if (alunoAtual.getRa().equals(ra)) {
                return alunoAtual.calcularMedia();
            }
        }

        return 0.0;
    }

    public List<Double> getMediasEmCrescente () {
        List<Double> listaMedias = new ArrayList<>();

        for (Aluno alunoAtual:
                listaAlunos) {
            listaMedias.add(alunoAtual.calcularMedia());
        }

        Collections.sort(listaMedias);

        return listaMedias;
    }

    public Double getMediana () {
        List<Double> listaMedias = getMediasEmCrescente();

        if(listaMedias.size() % 2 == 0) {
            Integer metade1 = listaMedias.size()/2 - 1;
            Integer metade2 = listaMedias.size()/2;

            Double mediana = (listaMedias.get(metade1) + listaMedias.get(metade2)) / 2;
            return mediana;
        } else {
            Integer metade = listaMedias.size()/2;

            Double mediana = listaMedias.get(metade);
            return mediana;
        }
    }
}
