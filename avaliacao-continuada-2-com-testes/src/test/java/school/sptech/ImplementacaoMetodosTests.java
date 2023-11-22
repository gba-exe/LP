package school.sptech;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import school.sptech.factory.CompraFactory;
import school.sptech.utils.CompraUtils;
import school.sptech.factory.ProdutoFactory;
import school.sptech.utils.ProdutoUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@DisplayName("Implementação dos métodos")
public class ImplementacaoMetodosTests {

  @Nested
  @DisplayName("Métodos de manipulação de lista")
  class MetodosManipulacaoListaTests {

    @Nested
    @DisplayName("adicionarProduto")
    class MetodoAdicionarProdutoTests {

      @Nested
      @DisplayName("Deve adicionar o produto passado como argumento na lista")
      class MetodoAdicionarProdutoDeveAdicionarProdutoNaListaTests {

        @Test
        @DisplayName("Cenário 1 - Produto Computador")
        void test1() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException {

          Object produto = ProdutoFactory
              .getInstance("Computador", 3400.0, 1.65, true, "Informática");

          Object compra = CompraFactory.getInstance("Diego Brito");

          Class<Compra> compraClass = Compra.class;

          Method metodoAdicionarProduto = compraClass
              .getDeclaredMethod(CompraUtils.METODO_ADICIONAR_PRODUTO, Produto.class);

          Field campoProdutos = compraClass.getDeclaredField(CompraUtils.ATRIBUTO_PRODUTOS);
          campoProdutos.trySetAccessible();

          metodoAdicionarProduto.invoke(compra, (Produto) produto);

          Assertions.assertTrue(campoProdutos.get(compra) instanceof List<?>);

          List<?> produtos = (List<?>) campoProdutos.get(compra);

          Assertions.assertFalse(produtos.isEmpty());

          Class<Produto> produtoClass = Produto.class;

          Field campoNome = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_NOME);
          campoNome.trySetAccessible();

          Object produtoLista = produtos.get(0);
          Assertions.assertEquals("Computador", campoNome.get(produtoLista));
        }

        @Test
        @DisplayName("Cenário 2 - Criando dois produtos")
        void test2() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException {

          Object produto = ProdutoFactory
              .getInstance("Notebook", 3400.0, 1.65, true, "Informática");

          Object produto2 = ProdutoFactory
              .getInstance("Chinelo", 20.99, 0.4, false, "Calçados");

          Object compra = CompraFactory.getInstance("Diego Brito");

          Class<Compra> compraClass = Compra.class;

          Method metodoAdicionarProduto = compraClass
              .getDeclaredMethod(CompraUtils.METODO_ADICIONAR_PRODUTO, Produto.class);

          Field campoProdutos = compraClass.getDeclaredField(CompraUtils.ATRIBUTO_PRODUTOS);
          campoProdutos.trySetAccessible();

          metodoAdicionarProduto.invoke(compra, (Produto) produto);
          metodoAdicionarProduto.invoke(compra, (Produto) produto2);

          Assertions.assertTrue(campoProdutos.get(compra) instanceof List<?>);

          List<?> produtos = (List<?>) campoProdutos.get(compra);

          Assertions.assertEquals(2, produtos.size());

          Class<Produto> produtoClass = Produto.class;

          Field campoNome = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_NOME);
          campoNome.trySetAccessible();

          Assertions.assertEquals("Notebook", campoNome.get(produtos.get(0)));
          Assertions.assertEquals("Chinelo", campoNome.get(produtos.get(1)));
        }
      }

      @Nested
      @DisplayName("Não deve adicionar o produto caso seja nulo")
      class MetodoAdicionarProdutoNaoDeveAdicionarProdutoNaListaCasoNuloTests {

        @Test
        @DisplayName("Cenário 1 - Passando produto nulo")
        void test1() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

          Object compra = CompraFactory.getInstance("Diego Brito");

          Class<Compra> compraClass = Compra.class;

          Method metodoAdicionarProduto = compraClass
              .getDeclaredMethod(CompraUtils.METODO_ADICIONAR_PRODUTO, Produto.class);

          Field campoProdutos = compraClass.getDeclaredField(CompraUtils.ATRIBUTO_PRODUTOS);
          campoProdutos.trySetAccessible();

          metodoAdicionarProduto.invoke(compra, (Object) null);

          Assertions.assertTrue(campoProdutos.get(compra) instanceof List<?>);

          List<?> produtos = (List<?>) campoProdutos.get(compra);

          Assertions.assertTrue(produtos.isEmpty());
        }
      }
    }

    @Nested
    @DisplayName("removerProduto")
    class MetodoRemoverProdutoTests {

      @Nested
      @DisplayName("Deve remover o produto com indice especificado da lista")
      class MetodoDeveRemoverPeloIndiceTests {

        @Test
        @DisplayName("Cenário 1 - Removendo item de uma lista de um item")
        void test1() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

          Object produto = ProdutoFactory
              .getInstance("Notebook", 3400.0, 1.65, true, "Informática");

          List<Object> listaProdutos = new ArrayList<>();
          listaProdutos.add(produto);

          Object compra = CompraFactory.getInstance("Diego Brito");

          Class<Compra> compraClass = Compra.class;

          Field campoProdutos = compraClass.getDeclaredField(CompraUtils.ATRIBUTO_PRODUTOS);
          campoProdutos.trySetAccessible();

          campoProdutos.set(compra, listaProdutos);

          Method metodoAdicionarProduto = compraClass
              .getDeclaredMethod(CompraUtils.METODO_REMOVER_PRODUTO, int.class);

          metodoAdicionarProduto.invoke(compra, 0);

          Assertions.assertTrue(campoProdutos.get(compra) instanceof List<?>);

          List<?> produtoAposMetodo = (List<?>) campoProdutos.get(compra);

          Assertions.assertTrue(produtoAposMetodo.isEmpty());
        }

        @Test
        @DisplayName("Cenário 2 - Removendo segundo item de uma lista de 3 itens")
        void test2() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

          Object produto = ProdutoFactory
              .getInstance("Notebook", 3400.0, 1.65, true, "Informática");

          Object produto2 = ProdutoFactory
              .getInstance("Chinelo", 20.99, 0.4, false, "Calçados");

          Object produto3 = ProdutoFactory
              .getInstance("Cereal Matinal", 10.80, 0.5, false, "Alimentação");

          List<Object> listaProdutos = new ArrayList<>();
          listaProdutos.add(produto);
          listaProdutos.add(produto2);
          listaProdutos.add(produto3);

          Object compra = CompraFactory.getInstance("Diego Brito");

          Class<Compra> compraClass = Compra.class;

          Field campoProdutos = compraClass.getDeclaredField(CompraUtils.ATRIBUTO_PRODUTOS);
          campoProdutos.trySetAccessible();

          campoProdutos.set(compra, listaProdutos);

          Method metodoAdicionarProduto = compraClass
              .getDeclaredMethod(CompraUtils.METODO_REMOVER_PRODUTO, int.class);

          metodoAdicionarProduto.invoke(compra, 1);

          Assertions.assertTrue(campoProdutos.get(compra) instanceof List<?>);

          List<?> produtoAposMetodo = (List<?>) campoProdutos.get(compra);

          Assertions.assertEquals(2, produtoAposMetodo.size());

          Class<Produto> produtoClass = Produto.class;

          Field campoNome = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_NOME);
          campoNome.trySetAccessible();

          Assertions.assertEquals("Notebook", campoNome.get(produtoAposMetodo.get(0)));
          Assertions.assertEquals("Cereal Matinal", campoNome.get(produtoAposMetodo.get(1)));
        }
      }

      @Nested
      @DisplayName("Caso o indice não exista não deve fazer nada")
      class MetodoNaoDeveRetornarErroEmIndiceInvalidoTests {

        @Test
        @DisplayName("Cenário 1 - Tentando remover indice maior, menor e igual ao tamanho da lista")
        void test1() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
          Object produto = ProdutoFactory
              .getInstance("Notebook", 3400.0, 1.65, true, "Informática");

          Object produto2 = ProdutoFactory
              .getInstance("Chinelo", 20.99, 0.4, false, "Calçados");

          Object produto3 = ProdutoFactory
              .getInstance("Cereal Matinal", 10.80, 0.5, false, "Alimentação");

          List<Object> listaProdutos = new ArrayList<>();
          listaProdutos.add(produto);
          listaProdutos.add(produto2);
          listaProdutos.add(produto3);

          Object compra = CompraFactory.getInstance("Diego Brito");

          Class<Compra> compraClass = Compra.class;

          Field campoProdutos = compraClass.getDeclaredField(CompraUtils.ATRIBUTO_PRODUTOS);
          campoProdutos.trySetAccessible();

          campoProdutos.set(compra, listaProdutos);

          Method metodoAdicionarProduto = compraClass
              .getDeclaredMethod(CompraUtils.METODO_REMOVER_PRODUTO, int.class);

          Assertions.assertDoesNotThrow(() -> {
            metodoAdicionarProduto.invoke(compra, 9);
          });
        }

        @Test
        @DisplayName("Cenário 2 - Tentando remover indice negativo")
        void test2() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
          Object produto = ProdutoFactory
              .getInstance("Notebook", 3400.0, 1.65, true, "Informática");

          Object produto2 = ProdutoFactory
              .getInstance("Chinelo", 20.99, 0.4, false, "Calçados");

          Object produto3 = ProdutoFactory
              .getInstance("Cereal Matinal", 10.80, 0.5, false, "Alimentação");

          List<Object> listaProdutos = new ArrayList<>();
          listaProdutos.add(produto);
          listaProdutos.add(produto2);
          listaProdutos.add(produto3);

          Object compra = CompraFactory.getInstance("Diego Brito");

          Class<Compra> compraClass = Compra.class;

          Field campoProdutos = compraClass.getDeclaredField(CompraUtils.ATRIBUTO_PRODUTOS);
          campoProdutos.trySetAccessible();

          campoProdutos.set(compra, listaProdutos);

          Method metodoAdicionarProduto = compraClass
              .getDeclaredMethod(CompraUtils.METODO_REMOVER_PRODUTO, int.class);

          Assertions.assertDoesNotThrow(() -> {
            metodoAdicionarProduto.invoke(compra, -10);
          });
        }

        @Test
        @DisplayName("Cenário 3 - Tentando remover igual ao tamanho da lista")
        void test3() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

          Object produto = ProdutoFactory
              .getInstance("Notebook", 3400.0, 1.65, true, "Informática");

          Object produto2 = ProdutoFactory
              .getInstance("Chinelo", 20.99, 0.4, false, "Calçados");

          Object produto3 = ProdutoFactory
              .getInstance("Cereal Matinal", 10.80, 0.5, false, "Alimentação");

          List<Object> listaProdutos = new ArrayList<>();
          listaProdutos.add(produto);
          listaProdutos.add(produto2);
          listaProdutos.add(produto3);

          Object compra = CompraFactory.getInstance("Diego Brito");

          Class<Compra> compraClass = Compra.class;

          Field campoProdutos = compraClass.getDeclaredField(CompraUtils.ATRIBUTO_PRODUTOS);
          campoProdutos.trySetAccessible();

          campoProdutos.set(compra, listaProdutos);

          Method metodoAdicionarProduto = compraClass
              .getDeclaredMethod(CompraUtils.METODO_REMOVER_PRODUTO, int.class);

          Assertions.assertDoesNotThrow(() -> {
            metodoAdicionarProduto.invoke(compra, listaProdutos.size());
          });
        }

        @Test
        @DisplayName("Cenário 4 - Tentando remover indice 0 de uma lista vazia")
        void test4() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

          List<Object> listaProdutos = new ArrayList<>();

          Object compra = CompraFactory.getInstance("Diego Brito");

          Class<Compra> compraClass = Compra.class;

          Field campoProdutos = compraClass.getDeclaredField(CompraUtils.ATRIBUTO_PRODUTOS);
          campoProdutos.trySetAccessible();

          campoProdutos.set(compra, listaProdutos);

          Method metodoAdicionarProduto = compraClass
              .getDeclaredMethod(CompraUtils.METODO_REMOVER_PRODUTO, int.class);

          Assertions.assertDoesNotThrow(() -> {
            metodoAdicionarProduto.invoke(compra, 0);
          });
        }
      }
    }
  }

  @Nested
  @DisplayName("Métodos de busca na lista")
  class MetodosBuscaListaTests {

    @Nested
    @DisplayName("getQuantidadeProdutos")
    class MetodoQuantidadeProdutosTests {

      @Nested
      @DisplayName("Deve retornar a quantidade de produtos da lista")
      class MetodoDeveRetornarQuantidadeDeProdutosTests {

        @Test
        @DisplayName("Cenário 1 - Deve retornar 0 caso a lista esteja vazia")
        void test1() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

          List<Object> listaProdutos = new ArrayList<>();

          Object compra = CompraFactory.getInstance("Diego Brito");

          Class<Compra> compraClass = Compra.class;

          Field campoProdutos = compraClass.getDeclaredField(CompraUtils.ATRIBUTO_PRODUTOS);
          campoProdutos.trySetAccessible();

          campoProdutos.set(compra, listaProdutos);

          Method metodoQuantidadeProdutos = compraClass
              .getDeclaredMethod(CompraUtils.METODO_QUANTIDADE_PRODUTOS);

          Assertions.assertEquals(0, metodoQuantidadeProdutos.invoke(compra));
        }

        @Test
        @DisplayName("Cenário 2 - Deve retornar 1 caso a lista contenha 1 item")
        void test2() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

          Object produto = ProdutoFactory
              .getInstance("Notebook", 3400.0, 1.65, true, "Informática");

          List<Object> listaProdutos = new ArrayList<>();
          listaProdutos.add(produto);

          Object compra = CompraFactory.getInstance("Diego Brito");

          Class<Compra> compraClass = Compra.class;

          Field campoProdutos = compraClass.getDeclaredField(CompraUtils.ATRIBUTO_PRODUTOS);
          campoProdutos.trySetAccessible();

          campoProdutos.set(compra, listaProdutos);

          Method metodoQuantidadeProdutos = compraClass
              .getDeclaredMethod(CompraUtils.METODO_QUANTIDADE_PRODUTOS);

          Assertions.assertEquals(1, metodoQuantidadeProdutos.invoke(compra));
        }

        @Test
        @DisplayName("Cenário 3 - Deve retornar 3 caso a lista contenha 3 itens")
        void test3() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

          Object produto = ProdutoFactory
              .getInstance("Notebook", 3400.0, 1.65, true, "Informática");

          Object produto2 = ProdutoFactory
              .getInstance("Chinelo", 20.99, 0.4, false, "Calçados");

          Object produto3 = ProdutoFactory
              .getInstance("Cereal Matinal", 10.80, 0.5, false, "Alimentação");

          List<Object> listaProdutos = new ArrayList<>();
          listaProdutos.add(produto);
          listaProdutos.add(produto2);
          listaProdutos.add(produto3);

          Object compra = CompraFactory.getInstance("Diego Brito");

          Class<Compra> compraClass = Compra.class;

          Field campoProdutos = compraClass.getDeclaredField(CompraUtils.ATRIBUTO_PRODUTOS);
          campoProdutos.trySetAccessible();

          campoProdutos.set(compra, listaProdutos);

          Method metodoQuantidadeProdutos = compraClass
              .getDeclaredMethod(CompraUtils.METODO_QUANTIDADE_PRODUTOS);

          Assertions.assertEquals(3, metodoQuantidadeProdutos.invoke(compra));
        }
      }
    }

    @Nested
    @DisplayName("getQuantidadeProdutosFrageis")
    class MetodoQuantidadeProdutosFrageisTests {

      @Nested
      @DisplayName("Deve retornar a quantidade apenas de produtos frágeis de lista")
      class MetodoDeveRetornarQuantidadeDeProdutosTests {

        @Test
        @DisplayName("Cenário 1 - Deve retornar 0 caso não tenha nenhum produto frágil")
        void test1() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
          Object produto = ProdutoFactory
              .getInstance("Notebook", 3400.0, 1.65, false, "Informática");

          Object produto2 = ProdutoFactory
              .getInstance("Chinelo", 20.99, 0.4, false, "Calçados");

          Object produto3 = ProdutoFactory
              .getInstance("Cereal Matinal", 10.80, 0.5, false, "Alimentação");

          List<Object> listaProdutos = new ArrayList<>();
          listaProdutos.add(produto);
          listaProdutos.add(produto2);
          listaProdutos.add(produto3);

          Object compra = CompraFactory.getInstance("Diego Brito");

          Class<Compra> compraClass = Compra.class;

          Field campoProdutos = compraClass.getDeclaredField(CompraUtils.ATRIBUTO_PRODUTOS);
          campoProdutos.trySetAccessible();

          campoProdutos.set(compra, listaProdutos);

          Method metodoQuantidadeProdutosFrageis = compraClass
              .getDeclaredMethod(CompraUtils.METODO_QUANTIDADE_PRODUTOS_FRAGEIS);

          Assertions.assertEquals(0, metodoQuantidadeProdutosFrageis.invoke(compra));
        }

        @Test
        @DisplayName("Cenário 2 - Deve retornar 2 caso a listas contenha 2 produtos frágeis")
        void test2() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

          Object produto = ProdutoFactory
              .getInstance("Notebook", 3400.0, 1.65, true, "Informática");

          Object produto2 = ProdutoFactory
              .getInstance("Chinelo", 20.99, 0.4, false, "Calçados");

          Object produto3 = ProdutoFactory
              .getInstance("Cálice de vidro", 45.80, 0.2, true, "Louça");

          List<Object> listaProdutos = new ArrayList<>();
          listaProdutos.add(produto);
          listaProdutos.add(produto2);
          listaProdutos.add(produto3);

          Object compra = CompraFactory.getInstance("Diego Brito");

          Class<Compra> compraClass = Compra.class;

          Field campoProdutos = compraClass.getDeclaredField(CompraUtils.ATRIBUTO_PRODUTOS);
          campoProdutos.trySetAccessible();

          campoProdutos.set(compra, listaProdutos);

          Method metodoQuantidadeProdutosFrageis = compraClass
              .getDeclaredMethod(CompraUtils.METODO_QUANTIDADE_PRODUTOS_FRAGEIS);

          Assertions.assertEquals(2, metodoQuantidadeProdutosFrageis.invoke(compra));
        }
      }
    }

    @Nested
    @DisplayName("getProdutoPorNome")
    class MetodoGetProdutoPorNomeTests {

      @Nested
      @DisplayName("Deve retornar um objeto produto com o nome especificado")
      class MetodoDeveRetornarObjetoPeloNomeTests {

        @Test
        @DisplayName("Cenário 1 - Deve retornar o objeto Notebook")
        void test1() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

          Object produto = ProdutoFactory
              .getInstance("Notebook", 3400.0, 1.65, false, "Informática");

          Object produto2 = ProdutoFactory
              .getInstance("Chinelo", 20.99, 0.4, false, "Calçados");

          Object produto3 = ProdutoFactory
              .getInstance("Cereal Matinal", 10.80, 0.5, false, "Alimentação");

          List<Object> listaProdutos = new ArrayList<>();
          listaProdutos.add(produto);
          listaProdutos.add(produto2);
          listaProdutos.add(produto3);

          Object compra = CompraFactory.getInstance("Diego Brito");

          Class<Compra> compraClass = Compra.class;

          Field campoProdutos = compraClass.getDeclaredField(CompraUtils.ATRIBUTO_PRODUTOS);
          campoProdutos.trySetAccessible();

          campoProdutos.set(compra, listaProdutos);

          Method metodoGetProdutoPorNome = compraClass
              .getDeclaredMethod(CompraUtils.METODO_GET_PRODUTO_POR_NOME, String.class);

          Object resultado = metodoGetProdutoPorNome.invoke(compra, "Notebook");

          Class<Produto> produtoClass = Produto.class;

          Field campoNome = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_NOME);
          campoNome.trySetAccessible();

          Field campoPreco = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_PRECO);
          campoPreco.trySetAccessible();

          Field campoCategoria = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_CATEGORIA);
          campoCategoria.trySetAccessible();

          Assertions.assertEquals("Notebook", campoNome.get(resultado));
          Assertions.assertEquals(3400.0, campoPreco.get(resultado));
          Assertions.assertEquals("Informática", campoCategoria.get(resultado));
        }

        @Test
        @DisplayName("Cenário 2 - Deve retornar o objeto Chinelo")
        void test2() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

          Object produto = ProdutoFactory
              .getInstance("Notebook", 3400.0, 1.65, false, "Informática");

          Object produto2 = ProdutoFactory
              .getInstance("Chinelo", 20.99, 0.4, false, "Calçados");

          Object produto3 = ProdutoFactory
              .getInstance("Cereal Matinal", 10.80, 0.5, false, "Alimentação");

          List<Object> listaProdutos = new ArrayList<>();
          listaProdutos.add(produto);
          listaProdutos.add(produto2);
          listaProdutos.add(produto3);

          Object compra = CompraFactory.getInstance("Diego Brito");

          Class<Compra> compraClass = Compra.class;

          Field campoProdutos = compraClass.getDeclaredField(CompraUtils.ATRIBUTO_PRODUTOS);
          campoProdutos.trySetAccessible();

          campoProdutos.set(compra, listaProdutos);

          Method metodoGetProdutoPorNome = compraClass
              .getDeclaredMethod(CompraUtils.METODO_GET_PRODUTO_POR_NOME, String.class);

          Object resultado = metodoGetProdutoPorNome.invoke(compra, "Cereal Matinal");

          Class<Produto> produtoClass = Produto.class;

          Field campoNome = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_NOME);
          campoNome.trySetAccessible();

          Field campoPreco = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_PRECO);
          campoPreco.trySetAccessible();

          Field campoCategoria = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_CATEGORIA);
          campoCategoria.trySetAccessible();

          Assertions.assertEquals("Cereal Matinal", campoNome.get(resultado));
          Assertions.assertEquals(10.80, campoPreco.get(resultado));
          Assertions.assertEquals("Alimentação", campoCategoria.get(resultado));
        }
      }

      @Nested
      @DisplayName("Deve retornar um objeto produto com o nome especificado ignorando letras maiúsculas e minúsculas")
      class MetodoDeveRetornarObjetoPeloNomeIgnoreCaseTests {

        @Test
        @DisplayName("Cenário 1 - Deve retornar o objeto Notebook")
        void test1() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

          Object produto = ProdutoFactory
              .getInstance("Notebook", 3400.0, 1.65, false, "Informática");

          Object produto2 = ProdutoFactory
              .getInstance("Chinelo", 20.99, 0.4, false, "Calçados");

          Object produto3 = ProdutoFactory
              .getInstance("Cereal Matinal", 10.80, 0.5, false, "Alimentação");

          List<Object> listaProdutos = new ArrayList<>();
          listaProdutos.add(produto);
          listaProdutos.add(produto2);
          listaProdutos.add(produto3);

          Object compra = CompraFactory.getInstance("Diego Brito");

          Class<Compra> compraClass = Compra.class;

          Field campoProdutos = compraClass.getDeclaredField(CompraUtils.ATRIBUTO_PRODUTOS);
          campoProdutos.trySetAccessible();

          campoProdutos.set(compra, listaProdutos);

          Method metodoGetProdutoPorNome = compraClass
              .getDeclaredMethod(CompraUtils.METODO_GET_PRODUTO_POR_NOME, String.class);

          Object resultado = metodoGetProdutoPorNome.invoke(compra, "NOTEbook");

          Class<Produto> produtoClass = Produto.class;

          Field campoNome = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_NOME);
          campoNome.trySetAccessible();

          Field campoPreco = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_PRECO);
          campoPreco.trySetAccessible();

          Field campoCategoria = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_CATEGORIA);
          campoCategoria.trySetAccessible();

          Assertions.assertEquals("Notebook", campoNome.get(resultado));
          Assertions.assertEquals(3400.0, campoPreco.get(resultado));
          Assertions.assertEquals("Informática", campoCategoria.get(resultado));
        }

        @Test
        @DisplayName("Cenário 2 - Deve retornar o objeto Chinelo")
        void test2() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

          Object produto = ProdutoFactory
              .getInstance("Notebook", 3400.0, 1.65, false, "Informática");

          Object produto2 = ProdutoFactory
              .getInstance("Chinelo", 20.99, 0.4, false, "Calçados");

          Object produto3 = ProdutoFactory
              .getInstance("Cereal Matinal", 10.80, 0.5, false, "Alimentação");

          List<Object> listaProdutos = new ArrayList<>();
          listaProdutos.add(produto);
          listaProdutos.add(produto2);
          listaProdutos.add(produto3);

          Object compra = CompraFactory.getInstance("Diego Brito");

          Class<Compra> compraClass = Compra.class;

          Field campoProdutos = compraClass.getDeclaredField(CompraUtils.ATRIBUTO_PRODUTOS);
          campoProdutos.trySetAccessible();

          campoProdutos.set(compra, listaProdutos);

          Method metodoGetProdutoPorNome = compraClass
              .getDeclaredMethod(CompraUtils.METODO_GET_PRODUTO_POR_NOME, String.class);

          Object resultado = metodoGetProdutoPorNome.invoke(compra, "ceREal mAtInAl");

          Class<Produto> produtoClass = Produto.class;

          Field campoNome = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_NOME);
          campoNome.trySetAccessible();

          Field campoPreco = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_PRECO);
          campoPreco.trySetAccessible();

          Field campoCategoria = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_CATEGORIA);
          campoCategoria.trySetAccessible();

          Assertions.assertEquals("Cereal Matinal", campoNome.get(resultado));
          Assertions.assertEquals(10.80, campoPreco.get(resultado));
          Assertions.assertEquals("Alimentação", campoCategoria.get(resultado));
        }
      }

      @Nested
      @DisplayName("Deve retornar null caso o produto não seja encontrado")
      class MetodoDeveRetornarNullCasoNaoExistaTests {

        @Test
        @DisplayName("Cenário 1 - Deve retornar null caso valor não exista")
        void test1() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

          Object produto = ProdutoFactory
              .getInstance("Notebook", 3400.0, 1.65, false, "Informática");

          Object produto2 = ProdutoFactory
              .getInstance("Chinelo", 20.99, 0.4, false, "Calçados");

          Object produto3 = ProdutoFactory
              .getInstance("Cereal Matinal", 10.80, 0.5, false, "Alimentação");

          List<Object> listaProdutos = new ArrayList<>();
          listaProdutos.add(produto);
          listaProdutos.add(produto2);
          listaProdutos.add(produto3);

          Object compra = CompraFactory.getInstance("Diego Brito");

          Class<Compra> compraClass = Compra.class;

          Field campoProdutos = compraClass.getDeclaredField(CompraUtils.ATRIBUTO_PRODUTOS);
          campoProdutos.trySetAccessible();

          campoProdutos.set(compra, listaProdutos);

          Method metodoGetProdutoPorNome = compraClass
              .getDeclaredMethod(CompraUtils.METODO_GET_PRODUTO_POR_NOME, String.class);

          Object resultado = metodoGetProdutoPorNome.invoke(compra, "Lâmpada de LED");

          Assertions.assertNull(resultado);
        }
      }
    }

    @Nested
    @DisplayName("getProdutosPorCategoria")
    class MetodoGetProdutosPorCategoriaTests {

      @Nested
      @DisplayName("Deve retornar uma lista de produtos com a categoria especificada")
      class MetodoDeveRetornarUmaListaDeProdutosTests {

        @Test
        @DisplayName("Cenário 1 - Deve retornar uma lista com 3 produtos da mesma categoria")
        void test1() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

          Object produto = ProdutoFactory
              .getInstance("Notebook", 3400.0, 1.65, false, "Informática");

          Object produto2 = ProdutoFactory
              .getInstance("Chinelo", 20.99, 0.2, false, "Calçados");

          Object produto3 = ProdutoFactory
              .getInstance("Cereal Matinal", 10.80, 0.5, false, "Alimentação");

          Object produto4 = ProdutoFactory
              .getInstance("Teclado", 250.99, 0.3, true, "Informática");

          Object produto5 = ProdutoFactory
              .getInstance("Mouse Gamer", 1099.99, 0.2, true, "Informática");

          List<Object> listaProdutos = new ArrayList<>();
          listaProdutos.add(produto);
          listaProdutos.add(produto2);
          listaProdutos.add(produto3);
          listaProdutos.add(produto4);
          listaProdutos.add(produto5);

          Object compra = CompraFactory.getInstance("Diego Brito");

          Class<Compra> compraClass = Compra.class;

          Field campoProdutos = compraClass.getDeclaredField(CompraUtils.ATRIBUTO_PRODUTOS);
          campoProdutos.trySetAccessible();

          campoProdutos.set(compra, listaProdutos);

          Method metodoGetProdutoPorCategoria = compraClass
              .getDeclaredMethod(CompraUtils.METODO_GET_PRODUTOS_POR_CATEGORIA, String.class);

          List<?> resultado = (List<?>) metodoGetProdutoPorCategoria.invoke(compra, "Informática");

          Class<Produto> produtoClass = Produto.class;

          Field campoNome = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_NOME);
          campoNome.trySetAccessible();

          Assertions.assertEquals(3, resultado.size());

          Assertions.assertEquals("Notebook", campoNome.get(resultado.get(0)));
          Assertions.assertEquals("Teclado", campoNome.get(resultado.get(1)));
          Assertions.assertEquals("Mouse Gamer", campoNome.get(resultado.get(2)));
        }

        @Test
        @DisplayName("Cenário 2 - Deve retornar uma lista com 1 produtos da mesma categoria")
        void test2() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

          Object produto = ProdutoFactory
              .getInstance("Notebook", 3400.0, 1.65, false, "Informática");

          Object produto2 = ProdutoFactory
              .getInstance("Chinelo", 20.99, 0.2, false, "Calçados");

          Object produto3 = ProdutoFactory
              .getInstance("Cereal Matinal", 10.80, 0.5, false, "Alimentação");

          Object produto4 = ProdutoFactory
              .getInstance("Teclado", 250.99, 0.3, true, "Informática");

          Object produto5 = ProdutoFactory
              .getInstance("Mouse Gamer", 1099.99, 0.2, true, "Informática");

          List<Object> listaProdutos = new ArrayList<>();
          listaProdutos.add(produto);
          listaProdutos.add(produto2);
          listaProdutos.add(produto3);
          listaProdutos.add(produto4);
          listaProdutos.add(produto5);

          Object compra = CompraFactory.getInstance("Diego Brito");

          Class<Compra> compraClass = Compra.class;

          Field campoProdutos = compraClass.getDeclaredField(CompraUtils.ATRIBUTO_PRODUTOS);
          campoProdutos.trySetAccessible();

          campoProdutos.set(compra, listaProdutos);

          Method metodoGetProdutoPorCategoria = compraClass
              .getDeclaredMethod(CompraUtils.METODO_GET_PRODUTOS_POR_CATEGORIA, String.class);

          List<?> resultado = (List<?>) metodoGetProdutoPorCategoria.invoke(compra, "Alimentação");

          Class<Produto> produtoClass = Produto.class;

          Field campoNome = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_NOME);
          campoNome.trySetAccessible();

          Assertions.assertEquals(1, resultado.size());

          Assertions.assertEquals("Cereal Matinal", campoNome.get(resultado.get(0)));
        }
      }

      @Nested
      @DisplayName("Deve retornar uma lista de produtos com a categoria especificada ignorando letras maiúsculas e minúsculas")
      class MetodoDeveRetornarUmaListaDeProdutosIgnorandoCaseTests {

        @Test
        @DisplayName("Cenário 1 - Deve retornar uma lista com 3 produtos da mesma categoria")
        void test1() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

          Object produto = ProdutoFactory
              .getInstance("Notebook", 3400.0, 1.65, false, "Informática");

          Object produto2 = ProdutoFactory
              .getInstance("Chinelo", 20.99, 0.2, false, "Calçados");

          Object produto3 = ProdutoFactory
              .getInstance("Cereal Matinal", 10.80, 0.5, false, "Alimentação");

          Object produto4 = ProdutoFactory
              .getInstance("Teclado", 250.99, 0.3, true, "Informática");

          Object produto5 = ProdutoFactory
              .getInstance("Mouse Gamer", 1099.99, 0.2, true, "Informática");

          List<Object> listaProdutos = new ArrayList<>();
          listaProdutos.add(produto);
          listaProdutos.add(produto2);
          listaProdutos.add(produto3);
          listaProdutos.add(produto4);
          listaProdutos.add(produto5);

          Object compra = CompraFactory.getInstance("Diego Brito");

          Class<Compra> compraClass = Compra.class;

          Field campoProdutos = compraClass.getDeclaredField(CompraUtils.ATRIBUTO_PRODUTOS);
          campoProdutos.trySetAccessible();

          campoProdutos.set(compra, listaProdutos);

          Method metodoGetProdutoPorCategoria = compraClass
              .getDeclaredMethod(CompraUtils.METODO_GET_PRODUTOS_POR_CATEGORIA, String.class);

          List<?> resultado = (List<?>) metodoGetProdutoPorCategoria.invoke(compra, "INFORMÁTICA");

          Class<Produto> produtoClass = Produto.class;

          Field campoNome = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_NOME);
          campoNome.trySetAccessible();

          Assertions.assertEquals(3, resultado.size());

          Assertions.assertEquals("Notebook", campoNome.get(resultado.get(0)));
          Assertions.assertEquals("Teclado", campoNome.get(resultado.get(1)));
          Assertions.assertEquals("Mouse Gamer", campoNome.get(resultado.get(2)));
        }

        @Test
        @DisplayName("Cenário 2 - Deve retornar uma lista com 1 produtos da categoria Alimentação")
        void test2() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

          Object produto = ProdutoFactory
              .getInstance("Notebook", 3400.0, 1.65, false, "Informática");

          Object produto2 = ProdutoFactory
              .getInstance("Chinelo", 20.99, 0.2, false, "Calçados");

          Object produto3 = ProdutoFactory
              .getInstance("Cereal Matinal", 10.80, 0.5, false, "Alimentação");

          Object produto4 = ProdutoFactory
              .getInstance("Teclado", 250.99, 0.3, true, "Informática");

          Object produto5 = ProdutoFactory
              .getInstance("Mouse Gamer", 1099.99, 0.2, true, "Informática");

          List<Object> listaProdutos = new ArrayList<>();
          listaProdutos.add(produto);
          listaProdutos.add(produto2);
          listaProdutos.add(produto3);
          listaProdutos.add(produto4);
          listaProdutos.add(produto5);

          Object compra = CompraFactory.getInstance("Diego Brito");

          Class<Compra> compraClass = Compra.class;

          Field campoProdutos = compraClass.getDeclaredField(CompraUtils.ATRIBUTO_PRODUTOS);
          campoProdutos.trySetAccessible();

          campoProdutos.set(compra, listaProdutos);

          Method metodoGetProdutoPorCategoria = compraClass
              .getDeclaredMethod(CompraUtils.METODO_GET_PRODUTOS_POR_CATEGORIA, String.class);

          List<?> resultado = (List<?>) metodoGetProdutoPorCategoria.invoke(compra, "alImEnTaÇão");

          Class<Produto> produtoClass = Produto.class;

          Field campoNome = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_NOME);
          campoNome.trySetAccessible();

          Assertions.assertEquals(1, resultado.size());

          Assertions.assertEquals("Cereal Matinal", campoNome.get(resultado.get(0)));
        }
      }

      @Nested
      @DisplayName("Deve retornar uma lista fazia caso nenhum produto seja encontrado")
      class MetodoDeveRetornarUmaListaVaziaTests {

        @Test
        @DisplayName("Cenário 1 - Deve retornar uma lista vazia caso não encontre nenhum produto")
        void test1() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

          Object produto = ProdutoFactory
              .getInstance("Notebook", 3400.0, 1.65, false, "Informática");

          Object produto2 = ProdutoFactory
              .getInstance("Chinelo", 20.99, 0.2, false, "Calçados");

          Object produto3 = ProdutoFactory
              .getInstance("Cereal Matinal", 10.80, 0.5, false, "Alimentação");

          Object produto4 = ProdutoFactory
              .getInstance("Teclado", 250.99, 0.3, true, "Informática");

          Object produto5 = ProdutoFactory
              .getInstance("Mouse Gamer", 1099.99, 0.2, true, "Informática");

          List<Object> listaProdutos = new ArrayList<>();
          listaProdutos.add(produto);
          listaProdutos.add(produto2);
          listaProdutos.add(produto3);
          listaProdutos.add(produto4);
          listaProdutos.add(produto5);

          Object compra = CompraFactory.getInstance("Diego Brito");

          Class<Compra> compraClass = Compra.class;

          Field campoProdutos = compraClass.getDeclaredField(CompraUtils.ATRIBUTO_PRODUTOS);
          campoProdutos.trySetAccessible();

          campoProdutos.set(compra, listaProdutos);

          Method metodoGetProdutoPorCategoria = compraClass
              .getDeclaredMethod(CompraUtils.METODO_GET_PRODUTOS_POR_CATEGORIA, String.class);

          List<?> resultado = (List<?>) metodoGetProdutoPorCategoria.invoke(compra, "Teste");
          Assertions.assertTrue(resultado.isEmpty());
        }
      }
    }
  }

  @Nested
  @DisplayName("Métodos de cálculo")
  class MetodosCalculoTests {

    @Nested
    @DisplayName("calcularFrete")
    class MetodoCalcularFreteTests {

      @Nested
      @DisplayName("Deve retornar o frete de um produto")
      class MetodoDeveCalcularOFreteCorretamenteTests {

        @Test
        @DisplayName("Cenário 1 - Calculando frete produto Notebook (Frágil false)")
        void test1() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

          Object produto = ProdutoFactory
              .getInstance("Notebook", 3400.0, 1.65, false, "Informática");

          Class<Produto> produtoClass = Produto.class;
          Method metodoCalcularFrete = produtoClass.getDeclaredMethod(ProdutoUtils.METODO_CALCULAR_FRETE);

          Double resultado = (Double) metodoCalcularFrete.invoke(produto);

          Assertions.assertEquals(0.165, resultado, 0.1);
        }

        @Test
        @DisplayName("Cenário 2 - Calculando frete produto Notebook (Frágil true)")
        void test2() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

          Object produto = ProdutoFactory
              .getInstance("Notebook", 3400.0, 1.65, true, "Informática");

          Class<Produto> produtoClass = Produto.class;
          Method metodoCalcularFrete = produtoClass.getDeclaredMethod(ProdutoUtils.METODO_CALCULAR_FRETE);

          Double resultado = (Double) metodoCalcularFrete.invoke(produto);

          Assertions.assertEquals(0.33, resultado, 0.1);
        }

        @Test
        @DisplayName("Cenário 3 - Calculando frete produto Geladeira (Frágil false)")
        void test3() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

          Object produto = ProdutoFactory
              .getInstance("Geladeira", 6400.0, 113.0, false, "Eletrodomésticos");

          Class<Produto> produtoClass = Produto.class;
          Method metodoCalcularFrete = produtoClass.getDeclaredMethod(ProdutoUtils.METODO_CALCULAR_FRETE);

          Double resultado = (Double) metodoCalcularFrete.invoke(produto);

          Assertions.assertEquals(11.3, resultado, 0.1);
        }

        @Test
        @DisplayName("Cenário 4 - Calculando frete produto Geladeira (Frágil true)")
        void test4() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

          Object produto = ProdutoFactory
              .getInstance("Geladeira", 6400.0, 113.0, true, "Eletrodomésticos");

          Class<Produto> produtoClass = Produto.class;
          Method metodoCalcularFrete = produtoClass.getDeclaredMethod(ProdutoUtils.METODO_CALCULAR_FRETE);

          Double resultado = (Double) metodoCalcularFrete.invoke(produto);

          Assertions.assertEquals(22.6, resultado, 0.1);
        }
      }
    }

    @Nested
    @DisplayName("calcularTotalFrete")
    class MetodoCalcularTotalFreteTests {

      @Nested
      @DisplayName("Deve retornar a soma dos fretes de todos os produtos")
      class MetodoDeveRetornarASomaDosFretesTests {

        @Test
        @DisplayName("Cenário 1 - Calculando frete de dois produtos")
        void test1() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

          Object produto = ProdutoFactory
              .getInstance("Geladeira", 6400.0, 113.0, true, "Eletrodomésticos");

          Object produto2 = ProdutoFactory
              .getInstance("Notebook", 3400.0, 1.65, false, "Informática");

          List<Object> listaProdutos = new ArrayList<>();
          listaProdutos.add(produto);
          listaProdutos.add(produto2);

          Object compra = CompraFactory.getInstance("Diego Brito");

          Class<Compra> compraClass = Compra.class;

          Field campoProdutos = compraClass.getDeclaredField(CompraUtils.ATRIBUTO_PRODUTOS);
          campoProdutos.trySetAccessible();

          campoProdutos.set(compra, listaProdutos);

          Method metodoCalcularTotalFrete = compraClass
              .getDeclaredMethod(CompraUtils.METODO_CALCULAR_TOTAL_FRETE);

          Double totalFretes = (Double) metodoCalcularTotalFrete.invoke(compra);

          Assertions.assertEquals(22.6 + 0.165, totalFretes, 0.1);
        }

        @Test
        @DisplayName("Cenário 2 - Calculando frete de três produtos")
        void test2() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

          Object produto = ProdutoFactory
              .getInstance("Geladeira", 6400.0, 113.0, true, "Eletrodomésticos");

          Object produto2 = ProdutoFactory
              .getInstance("Notebook", 3400.0, 1.65, false, "Informática");

          Object produto3 = ProdutoFactory
              .getInstance("Televisão", 4500.0, 14.0, true, "Eletrodomésticos");

          List<Object> listaProdutos = new ArrayList<>();
          listaProdutos.add(produto);
          listaProdutos.add(produto2);
          listaProdutos.add(produto3);

          Object compra = CompraFactory.getInstance("Diego Brito");

          Class<Compra> compraClass = Compra.class;

          Field campoProdutos = compraClass.getDeclaredField(CompraUtils.ATRIBUTO_PRODUTOS);
          campoProdutos.trySetAccessible();

          campoProdutos.set(compra, listaProdutos);

          Method metodoCalcularTotalFrete = compraClass
              .getDeclaredMethod(CompraUtils.METODO_CALCULAR_TOTAL_FRETE);

          Double totalFretes = (Double) metodoCalcularTotalFrete.invoke(compra);

          Assertions.assertEquals(22.6 + 0.165 + 2.8, totalFretes, 0.1);
        }

        @Test
        @DisplayName("Cenário 3 - Calculando frete de zero produtos")
        void test3() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

          List<Object> listaProdutos = new ArrayList<>();

          Object compra = CompraFactory.getInstance("Diego Brito");

          Class<Compra> compraClass = Compra.class;

          Field campoProdutos = compraClass.getDeclaredField(CompraUtils.ATRIBUTO_PRODUTOS);
          campoProdutos.trySetAccessible();

          campoProdutos.set(compra, listaProdutos);

          Method metodoCalcularTotalFrete = compraClass
              .getDeclaredMethod(CompraUtils.METODO_CALCULAR_TOTAL_FRETE);

          Double totalFretes = (Double) metodoCalcularTotalFrete.invoke(compra);

          Assertions.assertEquals(0.0, totalFretes);
        }
      }
    }

    @Nested
    @DisplayName("calcularTotalProdutos")
    class MetodoCalcularTotalProdutosTests {

      @Nested
      @DisplayName("Deve retornar a soma dos preços de todos os produtos")
      class MetodoDeveRetornarASomaDosPrecosTests {

        @Test
        @DisplayName("Cenário 1 - Calculando preço de dois produtos")
        void test1() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

          Object produto = ProdutoFactory
              .getInstance("Geladeira", 6400.0, 113.0, true, "Eletrodomésticos");

          Object produto2 = ProdutoFactory
              .getInstance("Notebook", 3400.0, 1.65, false, "Informática");

          List<Object> listaProdutos = new ArrayList<>();
          listaProdutos.add(produto);
          listaProdutos.add(produto2);

          Object compra = CompraFactory.getInstance("Diego Brito");

          Class<Compra> compraClass = Compra.class;

          Field campoProdutos = compraClass.getDeclaredField(CompraUtils.ATRIBUTO_PRODUTOS);
          campoProdutos.trySetAccessible();

          campoProdutos.set(compra, listaProdutos);

          Method metodoCalcularTotalProdutos = compraClass
              .getDeclaredMethod(CompraUtils.METODO_CALCULAR_TOTAL_PRODUTOS);

          Double totalPrecos = (Double) metodoCalcularTotalProdutos.invoke(compra);

          Assertions.assertEquals(6400.0 + 3400.0, totalPrecos, 0.1);
        }

        @Test
        @DisplayName("Cenário 2 - Calculando preço de três produtos")
        void test2() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

          Object produto = ProdutoFactory
              .getInstance("Geladeira", 6400.0, 113.0, true, "Eletrodomésticos");

          Object produto2 = ProdutoFactory
              .getInstance("Notebook", 3400.0, 1.65, false, "Informática");

          Object produto3 = ProdutoFactory
              .getInstance("Televisão", 4500.0, 14.0, true, "Eletrodomésticos");

          List<Object> listaProdutos = new ArrayList<>();
          listaProdutos.add(produto);
          listaProdutos.add(produto2);
          listaProdutos.add(produto3);

          Object compra = CompraFactory.getInstance("Diego Brito");

          Class<Compra> compraClass = Compra.class;

          Field campoProdutos = compraClass.getDeclaredField(CompraUtils.ATRIBUTO_PRODUTOS);
          campoProdutos.trySetAccessible();

          campoProdutos.set(compra, listaProdutos);

          Method metodoCalcularTotalProdutos = compraClass
              .getDeclaredMethod(CompraUtils.METODO_CALCULAR_TOTAL_PRODUTOS);

          Double totalPrecos = (Double) metodoCalcularTotalProdutos.invoke(compra);

          Assertions.assertEquals(6400.0 + 3400.0 + 4500.0, totalPrecos, 0.1);
        }

        @Test
        @DisplayName("Cenário 3 - Calculando preço com zero produtos")
        void test3() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

          List<Object> listaProdutos = new ArrayList<>();

          Object compra = CompraFactory.getInstance("Diego Brito");

          Class<Compra> compraClass = Compra.class;

          Field campoProdutos = compraClass.getDeclaredField(CompraUtils.ATRIBUTO_PRODUTOS);
          campoProdutos.trySetAccessible();

          campoProdutos.set(compra, listaProdutos);

          Method metodoCalcularTotalProdutos = compraClass
              .getDeclaredMethod(CompraUtils.METODO_CALCULAR_TOTAL_PRODUTOS);

          Double totalPrecos = (Double) metodoCalcularTotalProdutos.invoke(compra);

          Assertions.assertEquals(0.0, totalPrecos);
        }
      }
    }

    @Nested
    @DisplayName("calcularTotalCompra")
    class MetodoCalcularTotalCompraTests {

      @Nested
      @DisplayName("Deve retornar a soma de preços mais a soma de fretes de todos os produtos")
      class MetodoDeveRetornarASomaDosPrecosMaisSomaDosFretesTests {

        @Test
        @DisplayName("Cenário 1 - Calculando dois produtos")
        void test1() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

          Object produto = ProdutoFactory
              .getInstance("Geladeira", 6400.0, 113.0, true, "Eletrodomésticos");

          Object produto2 = ProdutoFactory
              .getInstance("Notebook", 3400.0, 1.65, false, "Informática");

          List<Object> listaProdutos = new ArrayList<>();
          listaProdutos.add(produto);
          listaProdutos.add(produto2);

          Object compra = CompraFactory.getInstance("Diego Brito");

          Class<Compra> compraClass = Compra.class;

          Field campoProdutos = compraClass.getDeclaredField(CompraUtils.ATRIBUTO_PRODUTOS);
          campoProdutos.trySetAccessible();

          campoProdutos.set(compra, listaProdutos);

          Method metodoCalcularTotalCompra = compraClass
              .getDeclaredMethod(CompraUtils.METODO_CALCULAR_TOTAL_COMPRA);

          Double totalCompra = (Double) metodoCalcularTotalCompra.invoke(compra);

          Assertions.assertEquals(6400.0 + 3400.0 + 22.6 + 0.165, totalCompra, 0.1);
        }

        @Test
        @DisplayName("Cenário 2 - Calculando três produtos")
        void test2() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

          Object produto = ProdutoFactory
              .getInstance("Geladeira", 6400.0, 113.0, true, "Eletrodomésticos");

          Object produto2 = ProdutoFactory
              .getInstance("Notebook", 3400.0, 1.65, false, "Informática");

          Object produto3 = ProdutoFactory
              .getInstance("Televisão", 4500.0, 14.0, true, "Eletrodomésticos");

          List<Object> listaProdutos = new ArrayList<>();
          listaProdutos.add(produto);
          listaProdutos.add(produto2);
          listaProdutos.add(produto3);

          Object compra = CompraFactory.getInstance("Diego Brito");

          Class<Compra> compraClass = Compra.class;

          Field campoProdutos = compraClass.getDeclaredField(CompraUtils.ATRIBUTO_PRODUTOS);
          campoProdutos.trySetAccessible();

          campoProdutos.set(compra, listaProdutos);

          Method metodoCalcularTotalCompra = compraClass
              .getDeclaredMethod(CompraUtils.METODO_CALCULAR_TOTAL_COMPRA);

          Double totalCompra = (Double) metodoCalcularTotalCompra.invoke(compra);

          Assertions.assertEquals(6400.0 + 3400.0 + 4500.0 + 22.6 + 0.165 + 2.8, totalCompra, 0.1);
        }

        @Test
        @DisplayName("Cenário 3 - Calculando com zero produtos")
        void test3() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

          List<Object> listaProdutos = new ArrayList<>();

          Object compra = CompraFactory.getInstance("Diego Brito");

          Class<Compra> compraClass = Compra.class;

          Field campoProdutos = compraClass.getDeclaredField(CompraUtils.ATRIBUTO_PRODUTOS);
          campoProdutos.trySetAccessible();

          campoProdutos.set(compra, listaProdutos);

          Method metodoCalcularTotalCompra = compraClass
              .getDeclaredMethod(CompraUtils.METODO_CALCULAR_TOTAL_COMPRA);

          Double totalCompra = (Double) metodoCalcularTotalCompra.invoke(compra);

          Assertions.assertEquals(0.0, totalCompra);
        }
      }
    }
  }
}
