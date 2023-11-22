package school.sptech.utils;

import school.sptech.Sessao;
import school.sptech.auxiliar.Metodo;

public class CinemaUtils {

  public static final String ATRIBUTO_NOME = "nome";
  public static final String ATRIBUTO_SESSOES = "sessoes";

  public static final String METODO_ADICIONAR_SESSAO = "adicionarSessao";
  public static final String METODO_GET_QUANTIDADE_SESSOES_3D = "getQuantidadeSessoes3d";
  public static final String METODO_GET_SESSOES_POR_NOME_FILME = "getSessoesPorNomeFilme";
  public static final String METODO_MEDIA_INGRESSOS_VENDIDOS = "getMediaIngressosVendidos";
  public static final String METODO_CALCULAR_TOTAL_VENDAS = "calcularTotalVendas";

  // Especificação

  public static final String ESPECIFICACAO_ATRIBUTO_NOME = "nome";
  public static final String ESPECIFICACAO_ATRIBUTO_SESSOES = "sessoes";

  public static final Metodo ESPECIFICACAO_METODO_ADICIONAR_SESSAO = new Metodo("adicionarSessao", new Class<?>[] { Sessao.class });
  public static final Metodo ESPECIFICACAO_METODO_GET_QUANTIDADE_SESSOES_3D = new Metodo("getQuantidadeSessoes3d", new Class<?>[] { });
  public static final Metodo ESPECIFICACAO_METODO_GET_SESSOES_POR_NOME_FILME = new Metodo("getSessoesPorNomeFilme", new Class<?>[] { String.class });
  public static final Metodo ESPECIFICACAO_METODO_MEDIA_INGRESSOS_VENDIDOS = new Metodo("getMediaIngressosVendidos", new Class<?>[] { });
  public static final Metodo ESPECIFICACAO_METODO_CALCULAR_TOTAL_VENDAS = new Metodo("calcularTotalVendas", new Class<?>[] { });
}
