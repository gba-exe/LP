package school.sptech;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import school.sptech.auxiliar.Metodo;
import school.sptech.utils.CinemaUtils;
import school.sptech.utils.SessaoUtils;

import java.util.List;

@DisplayName("Fidelidade a especificação")
public class FidelidadeEspecificacaoTests {

  @Nested
  @DisplayName("Sessoes")
  class SessaoTests {

    @Nested
    @DisplayName("Todos os atributos de Sessao devem respeitar os nomes especificados")
    class TodosAtributosSessoesComoEspecificadosTests {

      @Test
      @DisplayName("Cenário Único")
      void test1() {

        List<String> atributos = List.of(
            SessaoUtils.ESPECIFICACAO_ATRIBUTO_FILME,
            SessaoUtils.ESPECIFICACAO_ATRIBUTO_PRECO,
            SessaoUtils.ESPECIFICACAO_ATRIBUTO_INGRESSOS_VENDIDOS,
            SessaoUtils.ESPECIFICACAO_ATRIBUTO_SESSAO_3D
        );

        Class<Sessao> clazz = Sessao.class;

        for (String atributo : atributos) {

          Assertions.assertDoesNotThrow(() -> {
            clazz.getDeclaredField(atributo);
          });
        }
      }
    }

    @Nested
    @DisplayName("Todos os métodos de Sessao devem respeitar os nomes e parâmetros especificados")
    class TodosMetodosSessoesComoEspecificadosTests {

      @Test
      @DisplayName("Cenário Único")
      void test1() {

        List<Metodo> metodos = List.of(SessaoUtils.ESPECIFICACAO_METODO_CALCULAR_PRECO_DO_INGRESSO);

        Class<Sessao> clazz = Sessao.class;

        for (Metodo metodo : metodos) {

          Assertions.assertDoesNotThrow(() -> {
            clazz.getDeclaredMethod(metodo.getNome(), metodo.getArgs());
          });
        }
      }
    }
  }

  @Nested
  @DisplayName("Cinema")
  class CinemaTests {

    @Nested
    @DisplayName("Todos os atributos de Cinema devem respeitar os nomes especificados")
    class TodosAtributosCinemaComoEspecificadosTests {

      @Test
      @DisplayName("Cenário Único")
      void test1() {

        List<String> atributos = List.of(
            CinemaUtils.ESPECIFICACAO_ATRIBUTO_NOME,
            CinemaUtils.ESPECIFICACAO_ATRIBUTO_SESSOES
        );

        Class<Cinema> clazz = Cinema.class;

        for (String atributo : atributos) {

          Assertions.assertDoesNotThrow(() -> {
            clazz.getDeclaredField(atributo);
          });
        }
      }
    }

    @Nested
    @DisplayName("Todos os métodos de Cinema devem respeitar os nomes e parâmetros especificados")
    class TodosMetodosCinemaComoEspecificadosTests {

      @Test
      @DisplayName("Cenário Único")
      void test1() {

        List<Metodo> metodos = List.of(
            CinemaUtils.ESPECIFICACAO_METODO_ADICIONAR_SESSAO,
            CinemaUtils.ESPECIFICACAO_METODO_GET_QUANTIDADE_SESSOES_3D,
            CinemaUtils.ESPECIFICACAO_METODO_GET_SESSOES_POR_NOME_FILME,
            CinemaUtils.ESPECIFICACAO_METODO_MEDIA_INGRESSOS_VENDIDOS,
            CinemaUtils.ESPECIFICACAO_METODO_CALCULAR_TOTAL_VENDAS
        );

        Class<Cinema> clazz = Cinema.class;

        for (Metodo metodo : metodos) {

          Assertions.assertDoesNotThrow(() -> {
            clazz.getDeclaredMethod(metodo.getNome(), metodo.getArgs());
          });
        }
      }
    }
  }
}
