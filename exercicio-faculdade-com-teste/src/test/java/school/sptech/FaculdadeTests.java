package school.sptech;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FaculdadeTests {

  private List<Aluno> alunos;

  @Test
  @DisplayName("Exists aluno por nome quando acionado com valor nulo deve retornar falso")
  public void testExistsAlunoPorNomeQuandoAcionadoComValorNuloDeveRetornarFalso() {
    Faculdade instance = new Faculdade("Bandtec");
    this.matricularAlunos(instance);
    assertFalse(instance.existsAlunoPorNome(null));
  }

  @Test
  @DisplayName("Exists aluno por nome quando acionado com valor inexistente deve retornar falso")
  public void testExistsAlunoPorNomeQuandoAcionadoComValorInexistenteDeveRetornarFalso() {
    Faculdade instance = new Faculdade("Bandtec");
    this.matricularAlunos(instance);
    assertFalse(instance.existsAlunoPorNome("Vera Goulart"));
  }

  @Test
  @DisplayName("Exists aluno por nome quando acionado com valor existente deve retornar verdadeiro")
  public void testExistsAlunoPorNomeQuandoAcionadoComValorExistenteDeveRetornarVerdadeiro() {
    Faculdade instance = new Faculdade("Bandtec");
    this.matricularAlunos(instance);
    assertTrue(instance.existsAlunoPorNome("diego Brito"));
  }

  @Test
  @DisplayName("Matricular aluno quando acionado com valor nulo não deve alterar tamanho da lista")
  public void testMatricularAlunoQuandoAcionadoComValorNuloNaoDeveAlterarTamanhoDaLista() {
    Faculdade instance = new Faculdade("Bandtec");
    instance.matricularAluno(null);
    assertEquals(0, instance.getQuantidadeAlunos());
  }

  @Test
  @DisplayName("Matricular aluno quando acionado com valor duplicado não deve alterar tamanho da lista")
  public void testMatricularAlunoQuandoAcionadoComValorDuplicadoNaoDeveAlterarTamanhoDaLista() {
    Faculdade instance = new Faculdade("Bandtec");
    this.matricularAlunos(instance);
    instance.matricularAluno(new Aluno("#32", "Diego brito", 4));
    assertEquals(this.alunos.size(), instance.getQuantidadeAlunos());
  }

  @Test
  @DisplayName("Matricular aluno quando acionado com valor único deve alterar tamanho da lista")
  public void testMatricularAlunoQuandoAcionadoComValorUnicoDeveAlterarTamanhoDaLista() {
    Faculdade instance = new Faculdade("Bandtec");
    this.matricularAlunos(instance);
    instance.matricularAluno(new Aluno("#32", "Marise Miranda", 4));
    assertEquals((this.alunos.size() + 1), instance.getQuantidadeAlunos());
  }

  @Test
  @DisplayName("Cancelar matricula quando acionado e lista esta vazia não deve retornar 0")
  public void testCancelarMatriculaQuandoAcionadoEListaEstaVaziaDeveRetornar0AoAcionarGetCancelados() {
    Faculdade instance = new Faculdade("Bandtec");
    instance.cancelarMatricula("#1");
    assertEquals(0, instance.getQuantidadeAlunosComMatriculaCancelada());
  }

  @Test
  @DisplayName("Cancelar matricula quando acionado com valor nulo não deve alterar quantidade de aluno com matricula cancelada")
  public void testCancelarMatriculaQuandoAcionadoComValorNuloNaoDeveAlterarQuantidadeDeAlunoComMatriculaCancelada() {
    Faculdade instance = new Faculdade("Bandtec");
    this.matricularAlunos(instance);
    instance.cancelarMatricula(null);
    assertEquals(0, instance.getQuantidadeAlunosComMatriculaCancelada());
  }

  @Test
  @DisplayName("Cancelar matricula quando acionado com valor existente deve alterar quantidade de aluno com matricula cancelada")
  public void testCancelarMatriculaQuandoAcionadoComValorExistenteDeveAlterarQuantidadeDeAlunoComMatriculaCancelada() {
    Faculdade instance = new Faculdade("Bandtec");
    this.matricularAlunos(instance);
    instance.cancelarMatricula("#1");
    assertEquals(1, instance.getQuantidadeAlunosComMatriculaCancelada());
  }

  @Test
  @DisplayName("Get quantidade alunos quando acionado e lista esta vazia deve retornar 0")
  public void testGetQuantidadeAlunosQuandoAcionadoEListaEstaVaziaDevRetornar0() {
    Faculdade instance = new Faculdade("Bandtec");
    assertEquals(0, instance.getQuantidadeAlunos());
  }

  @Test
  @DisplayName("Get quantidade alunos quando acionado e lista possui 4 alunos deve retornar 4")
  public void testGetQuantidadeAlunosQuandoAcionadoEListaPossui4AlunosDevRetornar4() {
    Faculdade instance = new Faculdade("Bandtec");
    this.matricularAlunos(instance);
    assertEquals(4, instance.getQuantidadeAlunos());
  }

  @Test
  @DisplayName("Get quantidade alunos por semestre quando acionado e lista esta vazia deve retornar 0")
  public void testGetQuantidadeAlunosPorSemestreQuandoAcionadoEListaEstaVaziaDeveRetornar0() {
    Faculdade instance = new Faculdade("Bandtec");
    assertEquals(0, instance.getQuantidadeAlunosPorSemestre(1));
  }

  @Test
  @DisplayName("Get quantidade alunos por semestre quando acionado com valor nulo deve retornar 0")
  public void testGetQuantidadeAlunosPorSemestreQuandoAcionadoComValorNuloDeveRetornar0() {
    Faculdade instance = new Faculdade("Bandtec");
    this.matricularAlunos(instance);
    assertEquals(0, instance.getQuantidadeAlunosPorSemestre(null));
  }

  @Test
  @DisplayName("Get quantidade alunos por semestre quando acionado com valor inexistente deve retornar 0")
  public void testGetQuantidadeAlunosPorSemestreQuandoAcionadoComValorInexistenteDeveRetornar0() {
    Faculdade instance = new Faculdade("Bandtec");
    this.matricularAlunos(instance);
    assertEquals(0, instance.getQuantidadeAlunosPorSemestre(42));
  }

  @Test
  @DisplayName("Get quantidade alunos por semestre quando acionado com valor 2 deve retornar 2")
  public void testGetQuantidadeAlunosPorSemestreQuandoAcionadoCom2DeveRetornar2() {
    Faculdade instance = new Faculdade("Bandtec");
    this.matricularAlunos(instance);
    assertEquals(2, instance.getQuantidadeAlunosPorSemestre(2));
  }

  @Test
  @DisplayName("Get quantidade alunos com matricula cancelada quando acionado e lista esta vazia deve retornar 0")
  public void testGetQuantidadeAlunosComMatriculaCanceladaQuandoAcionadoEListaEstaVaziaDeveRetornar0() {
    Faculdade instance = new Faculdade("Bandtec");
    assertEquals(0, instance.getQuantidadeAlunosComMatriculaCancelada());
  }

  @Test
  @DisplayName("Get quantidade alunos com matricula cancelada quando acionado e lista não possui alunos com matricula cancelada deve retornar 0")
  public void testGetQuantidadeAlunosComMatriculaCanceladaQuandoAcionadoEListaNaoPossuiAlunosComMatriculaCanceladaDeveRetornar0() {
    Faculdade instance = new Faculdade("Bandtec");
    this.matricularAlunos(instance);
    assertEquals(0, instance.getQuantidadeAlunosComMatriculaCancelada());
  }

  @Test
  @DisplayName("Get quantidade alunos com matricula cancelada quando acionado e lista possui 1 aluno com matricula cancelada deve retornar 1")
  public void testGetQuantidadeAlunosComMatriculaCanceladaQuandoAcionadoEListaPossui1AlunoComMatriculaCanceladaDeveRetornar1() {
    Faculdade instance = new Faculdade("Bandtec");
    this.matricularAlunos(instance);
    instance.cancelarMatricula("#2");
    assertEquals(1, instance.getQuantidadeAlunosComMatriculaCancelada());
  }

  private void matricularAlunos(Faculdade faculdade){

    this.alunos = Arrays.asList(
        new Aluno("#1", "Diego Brito", 2),
        new Aluno("#2", "Giuliana Miniguiti", 3),
        new Aluno("#3", "Gerson Santos", 4),
        new Aluno("#4", "Célia Taniwaki", 2)
    );

    for (Aluno aluno : alunos) {
      faculdade.matricularAluno(aluno);
    }
  }
}
