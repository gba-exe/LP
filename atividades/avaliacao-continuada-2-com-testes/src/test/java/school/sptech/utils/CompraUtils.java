package school.sptech.utils;

import school.sptech.Produto;
import school.sptech.auxiliar.Metodo;

public class CompraUtils {

  // Atributos
  public static final String ATRIBUTO_NOME_CLIENTE = "nomeCliente";
  public static final String ATRIBUTO_PRODUTOS = "produtos";

  // Métodos
  public static final String METODO_ADICIONAR_PRODUTO = "adicionarProduto";
  public static final String METODO_REMOVER_PRODUTO = "removerProduto";
  public static final String METODO_QUANTIDADE_PRODUTOS = "getQuantidadeProdutos";
  public static final String METODO_QUANTIDADE_PRODUTOS_FRAGEIS = "getQuantidadeProdutosFrageis";
  public static final String METODO_GET_PRODUTO_POR_NOME = "getProdutoPorNome";
  public static final String METODO_GET_PRODUTOS_POR_CATEGORIA = "getProdutosPorCategoria";
  public static final String METODO_CALCULAR_TOTAL_FRETE = "calcularTotalFrete";
  public static final String METODO_CALCULAR_TOTAL_PRODUTOS = "calcularTotalProdutos";
  public static final String METODO_CALCULAR_TOTAL_COMPRA = "calcularTotalCompra";

  // Especificação

  // Atributos
  public static final String ESPECIFICACAO_ATRIBUTO_NOME_CLIENTE = "nomeCliente";
  public static final String ESPECIFICACAO_ATRIBUTO_PRODUTOS = "produtos";

  // Métodos
  public static final Metodo ESPECIFICACAO_METODO_ADICIONAR_PRODUTO = new Metodo(
      "adicionarProduto", new Class<?>[] { Produto.class });

  public static final Metodo ESPECIFICACAO_METODO_REMOVER_PRODUTO = new Metodo(
      "removerProduto", new Class<?>[] { int.class });

  public static final Metodo ESPECIFICACAO_GET_QUANTIDADE_PRODUTOS = new Metodo(
      "getQuantidadeProdutos", new Class<?>[0]);

  public static final Metodo ESPECIFICACAO_GET_QUANTIDADE_PRODUTOS_FRAGEIS = new Metodo(
      "getQuantidadeProdutosFrageis", new Class<?>[0]);

  public static final Metodo ESPECIFICACAO_GET_PRODUTO_POR_NOME = new Metodo(
      "getProdutoPorNome", new Class<?>[] { String.class });

  public static final Metodo ESPECIFICACAO_GET_PRODUTOS_POR_CATEGORIA = new Metodo(
      "getProdutosPorCategoria", new Class<?>[] { String.class });

  public static final Metodo ESPECIFICACAO_CALCULAR_TOTAL_FRETE = new Metodo(
      "calcularTotalFrete", new Class<?>[0]);

  public static final Metodo ESPECIFICACAO_CALCULAR_TOTAL_PRODUTOS = new Metodo(
      "calcularTotalProdutos", new Class<?>[0]);

  public static final Metodo ESPECIFICACAO_CALCULAR_TOTAL_COMPRA = new Metodo(
      "calcularTotalCompra", new Class<?>[0]);
}
