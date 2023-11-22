package school.sptech.utils;

import school.sptech.auxiliar.Metodo;

public class ProdutoUtils {

  // Atributos
  public static final String ATRIBUTO_NOME = "nome";
  public static final String ATRIBUTO_PRECO = "preco";
  public static final String ATRIBUTO_PESO_KG = "pesoKg";
  public static final String ATRIBUTO_FRAGIL = "fragil";
  public static final String ATRIBUTO_CATEGORIA = "categoria";

  // Métodos
  public static final String METODO_CALCULAR_FRETE = "calcularFrete";

  // Especificação

  // Atributos
  public static final String ESPECIFICACAO_ATRIBUTO_NOME = "nome";
  public static final String ESPECIFICACAO_ATRIBUTO_PRECO = "preco";
  public static final String ESPECIFICACAO_ATRIBUTO_PESO_KG = "pesoKg";
  public static final String ESPECIFICACAO_ATRIBUTO_FRAGIL = "fragil";
  public static final String ESPECIFICACAO_ATRIBUTO_CATEGORIA = "categoria";

  // Métodos
  public static final Metodo ESPECIFICACAO_METODO_CALCULAR_FRETE = new Metodo("calcularFrete", new Class<?>[0]);
}
