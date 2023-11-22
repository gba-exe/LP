package school.sptech.utils;

import school.sptech.auxiliar.Metodo;

public class SessaoUtils {

  public static final String ATRIBUTO_FILME = "filme";
  public static final String ATRIBUTO_PRECO = "preco";
  public static final String ATRIBUTO_INGRESSOS_VENDIDOS = "ingressosVendidos";
  public static final String ATRIBUTO_SESSAO_3D = "sessao3d";

  public static final String METODO_CALCULAR_PRECO_DO_INGRESSO = "calcularPrecoDoIngresso";

  // Especificacao

  public static final String ESPECIFICACAO_ATRIBUTO_FILME = "filme";
  public static final String ESPECIFICACAO_ATRIBUTO_PRECO = "preco";
  public static final String ESPECIFICACAO_ATRIBUTO_INGRESSOS_VENDIDOS = "ingressosVendidos";
  public static final String ESPECIFICACAO_ATRIBUTO_SESSAO_3D = "sessao3d";

  public static final Metodo ESPECIFICACAO_METODO_CALCULAR_PRECO_DO_INGRESSO =
      new Metodo("calcularPrecoDoIngresso", new Class<?>[0]);
}
