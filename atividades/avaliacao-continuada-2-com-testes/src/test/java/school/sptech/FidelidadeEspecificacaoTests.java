package school.sptech;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import school.sptech.auxiliar.Metodo;
import school.sptech.utils.CompraUtils;
import school.sptech.utils.ProdutoUtils;

import java.util.List;

@DisplayName("Fidelidade a especificação")
public class FidelidadeEspecificacaoTests {

  @Nested
  @DisplayName("Produtos")
  class ProdutoTests {

    @Nested
    @DisplayName("Todos os atributos de Produto devem respeitar os nomes especificados")
    class TodosAtributosProdutosComoEspecificadosTests {

      @Test
      @DisplayName("Cenário Único")
      void test1() {

        List<String> atributos = List.of(
            ProdutoUtils.ESPECIFICACAO_ATRIBUTO_NOME,
            ProdutoUtils.ESPECIFICACAO_ATRIBUTO_PRECO,
            ProdutoUtils.ESPECIFICACAO_ATRIBUTO_PESO_KG,
            ProdutoUtils.ESPECIFICACAO_ATRIBUTO_FRAGIL,
            ProdutoUtils.ESPECIFICACAO_ATRIBUTO_CATEGORIA
        );

        Class<Produto> clazz = Produto.class;

        for (String atributo : atributos) {

          Assertions.assertDoesNotThrow(() -> {
            clazz.getDeclaredField(atributo);
          });
        }
      }
    }

    @Nested
    @DisplayName("Todos os métodos de Produto devem respeitar os nomes e parâmetros especificados")
    class TodosMetodosProdutosComoEspecificadosTests {

      @Test
      @DisplayName("Cenário Único")
      void test1() {

        List<Metodo> metodos = List.of(ProdutoUtils.ESPECIFICACAO_METODO_CALCULAR_FRETE);

        Class<Produto> clazz = Produto.class;

        for (Metodo metodo : metodos) {

          Assertions.assertDoesNotThrow(() -> {
            clazz.getDeclaredMethod(metodo.getNome(), metodo.getArgs());
          });
        }
      }
    }
  }

  @Nested
  @DisplayName("Compra")
  class CompraTests {

    @Nested
    @DisplayName("Todos os atributos de Compra devem respeitar os nomes especificados")
    class TodosAtributosCompraComoEspecificadosTests {

      @Test
      @DisplayName("Cenário Único")
      void test1() {

        List<String> atributos = List.of(
            CompraUtils.ESPECIFICACAO_ATRIBUTO_NOME_CLIENTE,
            CompraUtils.ESPECIFICACAO_ATRIBUTO_PRODUTOS
        );

        Class<Compra> clazz = Compra.class;

        for (String atributo : atributos) {

          Assertions.assertDoesNotThrow(() -> {
            clazz.getDeclaredField(atributo);
          });
        }
      }
    }

    @Nested
    @DisplayName("Todos os métodos de Compra devem respeitar os nomes e parâmetros especificados")
    class TodosMetodosCompraComoEspecificadosTests {

      @Test
      @DisplayName("Cenário Único")
      void test1() {

        List<Metodo> metodos = List.of(
            CompraUtils.ESPECIFICACAO_METODO_ADICIONAR_PRODUTO,
            CompraUtils.ESPECIFICACAO_METODO_REMOVER_PRODUTO,
            CompraUtils.ESPECIFICACAO_GET_QUANTIDADE_PRODUTOS,
            CompraUtils.ESPECIFICACAO_GET_QUANTIDADE_PRODUTOS_FRAGEIS,
            CompraUtils.ESPECIFICACAO_GET_PRODUTO_POR_NOME,
            CompraUtils.ESPECIFICACAO_GET_PRODUTOS_POR_CATEGORIA,
            CompraUtils.ESPECIFICACAO_CALCULAR_TOTAL_FRETE,
            CompraUtils.ESPECIFICACAO_CALCULAR_TOTAL_PRODUTOS,
            CompraUtils.ESPECIFICACAO_CALCULAR_TOTAL_COMPRA
        );

        Class<Compra> clazz = Compra.class;

        for (Metodo metodo : metodos) {

          Assertions.assertDoesNotThrow(() -> {
            clazz.getDeclaredMethod(metodo.getNome(), metodo.getArgs());
          });
        }
      }
    }
  }
}
