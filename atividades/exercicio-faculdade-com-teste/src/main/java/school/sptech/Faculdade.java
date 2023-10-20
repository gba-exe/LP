package school.sptech;

import java.util.ArrayList;
import java.util.List;

public class Faculdade {

  private String nome;
  private List<Aluno> alunos;

  public Faculdade(String nome) {
    this.nome = nome;
    this.alunos = new ArrayList<>();
  }

  /*
      Deve verificar se existe um aluno com o nome informado, caso não exista,
      retorne false;
  */
  public Boolean existsAlunoPorNome(String nome) {
    for (Aluno alunoAtual:
         alunos) {
      if (alunoAtual.getNome().equalsIgnoreCase(nome)) {
        return true;
      }
    }
    return false;
  }

  /*
      Deve matricular um aluno na faculdade (inserir na lista), se a lista já
      possuir um aluno com o nome informado, não deve matricular;
  */
  public void matricularAluno(Aluno aluno) {
    if (aluno != null) {
      for (Aluno alunoAtual:
              alunos) {
        if (alunoAtual.getNome().equalsIgnoreCase(aluno.getNome())) {
          return;
        }
      }

      alunos.add(aluno);

    }
  }

  /*
      Deve cancelar a matricula de um aluno na faculdade (ativo = false), se não existir
      um aluno com o RA informado, não faça nada.
  */
  public void cancelarMatricula(String ra) {
    for (Aluno alunoAtual:
         alunos) {
      if (alunoAtual.getRa().equals(ra)) {
        alunoAtual.setAtivo(false);
      }
    }
  }

  /*
      Deve retornar a quantidade de alunos contidos na lista (matriculados);
  */
  public Integer getQuantidadeAlunos() {
    Integer quantidadeAluno = 0;

    for (Aluno alunoAtual:
         alunos) {
      if (alunoAtual.isAtivo()) {
        quantidadeAluno++;
      }
    }

    return quantidadeAluno;
  }

  /*
      Deve retornar a quantidade de alunos matriculados (contidos na lista)
      no semestre informado;
  */
  public Integer getQuantidadeAlunosPorSemestre(Integer semestre) {
    Integer quantidadeAluno = 0;

    for (Aluno alunoAtual:
         alunos) {
      if (alunoAtual.getSemestre().equals(semestre)) {
        quantidadeAluno++;
      }
    }

    return quantidadeAluno;
  }

  /*
      Deve retornar a quantidade de alunos com matrícula cancelada (contidos na lista);
  */
  public Integer getQuantidadeAlunosComMatriculaCancelada() {
    Integer quantidadeAluno = 0;

    for (Aluno alunoAtual:
            alunos) {
      if (!alunoAtual.isAtivo()) {
        quantidadeAluno++;
      }
    }

    return quantidadeAluno;
  }

  public String getNome() {
    return this.nome;
  }
}