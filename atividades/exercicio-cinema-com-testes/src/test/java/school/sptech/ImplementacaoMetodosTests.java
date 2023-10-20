package school.sptech;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import school.sptech.auxiliar.Metodo;
import school.sptech.factory.CinemaFactory;
import school.sptech.factory.SessaoFactory;
import school.sptech.utils.CinemaUtils;
import school.sptech.utils.SessaoUtils;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@DisplayName("Implementação dos métodos")
public class ImplementacaoMetodosTests {

  @Nested
  @DisplayName("calcularPrecoDoIngresso")
  class MetodoCalcularPrecoDoIngressoTests {

    @Nested
    @DisplayName("Deve calcular o preço do ingresso de acordo com o tipo")
    class MetodoDeveCalcularOPrecoDoIngresso {

      @Test
      @DisplayName("Cenário 1 - Calculando preço de uma sessão normal - Filme X")
      void test1() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        Object sessao = SessaoFactory.getInstance("Filme X", 10.0, 100, false);

        Method metodoCalcularIngresso = sessao.getClass().getDeclaredMethod(SessaoUtils.METODO_CALCULAR_PRECO_DO_INGRESSO);

        metodoCalcularIngresso.setAccessible(true);

        Object preco = metodoCalcularIngresso.invoke(sessao);

        Assertions.assertEquals(10.0, (Double) preco, 1.0);
      }

      @Test
      @DisplayName("Cenário 2 - Calculando preço de uma sessão 3d - Filme X")
      void test2() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Object sessao = SessaoFactory.getInstance("Filme X", 10.0, 100, true);

        Method metodoCalcularIngresso = sessao.getClass().getDeclaredMethod(SessaoUtils.METODO_CALCULAR_PRECO_DO_INGRESSO);

        metodoCalcularIngresso.setAccessible(true);

        Object preco = metodoCalcularIngresso.invoke(sessao);

        Assertions.assertEquals(20.0, (Double) preco, 1.0);
      }

      @Test
      @DisplayName("Cenário 3 - Calculando preço de uma sessão normal - Filme Y")
      void test3() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Object sessao = SessaoFactory.getInstance("Filme Y", 39.90, 50, false);

        Method metodoCalcularIngresso = sessao.getClass().getDeclaredMethod(SessaoUtils.METODO_CALCULAR_PRECO_DO_INGRESSO);

        metodoCalcularIngresso.setAccessible(true);

        Object preco = metodoCalcularIngresso.invoke(sessao);

        Assertions.assertEquals(39.90, (Double) preco, 1.0);
      }

      @Test
      @DisplayName("Cenário 4 - Calculando preço de uma sessão 3d - Filme Y")
      void test4() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        Object sessao = SessaoFactory.getInstance("Filme Y", 27.55, 50, true);

        Method metodoCalcularIngresso = sessao.getClass().getDeclaredMethod(SessaoUtils.METODO_CALCULAR_PRECO_DO_INGRESSO);

        metodoCalcularIngresso.setAccessible(true);

        Object preco = metodoCalcularIngresso.invoke(sessao);

        Assertions.assertEquals(55.10, (Double) preco, 1.0);
      }
    }
  }

  @Nested
  @DisplayName("adicionarSessao")
  class MetodoAdicionarSessaoTests {

    @Nested
    @DisplayName("Deve adicionar a sessão recebida como argumento na lista")
    class MetodoAdicionarSessaoDeveAdicionarSessaoNaListaTests {

      @Test
      @DisplayName("Cenário 1 - Criando uma sessão")
      void test1() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        Object sessao = SessaoFactory.getInstance("Filme X", 10.0, 100, false);

        Object cinema = CinemaFactory.getInstance("Cine X");

        Class<Cinema> cinemaClass = Cinema.class;

        Method metodoAdicionarSessao = cinema.getClass().getDeclaredMethod(CinemaUtils.METODO_ADICIONAR_SESSAO, Sessao.class);

        metodoAdicionarSessao.setAccessible(true);
        metodoAdicionarSessao.invoke(cinema, (Sessao) sessao);

        Field campoSessoes = cinemaClass.getDeclaredField(CinemaUtils.ATRIBUTO_SESSOES);
        campoSessoes.setAccessible(true);

        Assertions.assertTrue(campoSessoes.get(cinema) instanceof List<?>);

        List<?> sessoes = (List<?>) campoSessoes.get(cinema);

        Field campoNome = sessao.getClass().getDeclaredField(SessaoUtils.ATRIBUTO_FILME);
        campoNome.trySetAccessible();

        Assertions.assertFalse(sessoes.isEmpty());
        Assertions.assertEquals(1, sessoes.size());
        Assertions.assertEquals("Filme X", campoNome.get(sessoes.get(0)));
      }

      @Test
      @DisplayName("Cenário 2 - Criando duas sessões")
      void test2() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        Object sessao1 = SessaoFactory.getInstance("Filme X", 10.0, 100, false);
        Object sessao2 = SessaoFactory.getInstance("Filme Y", 10.0, 100, false);

        Object cinema = CinemaFactory.getInstance("Cine X");

        Class<Cinema> cinemaClass = Cinema.class;

        Method metodoAdicionarSessao = cinema.getClass().getDeclaredMethod(CinemaUtils.METODO_ADICIONAR_SESSAO, Sessao.class);

        metodoAdicionarSessao.setAccessible(true);

        metodoAdicionarSessao.invoke(cinema, (Sessao) sessao1);
        metodoAdicionarSessao.invoke(cinema, (Sessao) sessao2);

        Field campoSessoes = cinemaClass.getDeclaredField(CinemaUtils.ATRIBUTO_SESSOES);

        campoSessoes.setAccessible(true);

        Assertions.assertTrue(campoSessoes.get(cinema) instanceof List<?>);

        List<?> sessoes = (List<?>) campoSessoes.get(cinema);

        Field campoNome = sessao1.getClass().getDeclaredField(SessaoUtils.ATRIBUTO_FILME);

        campoNome.trySetAccessible();

        Assertions.assertFalse(sessoes.isEmpty());
        Assertions.assertEquals(2, sessoes.size());
        Assertions.assertEquals("Filme X", campoNome.get(sessoes.get(0)));
        Assertions.assertEquals("Filme Y", campoNome.get(sessoes.get(1)));
      }
    }

    @Nested
    @DisplayName("Não deve adicionar a sessão recebida como argumento caso ela esteja nula")
    class MetodoAdicionarSessaoNaoDeveAdicionarSessaoNaListaCasoNuloTests {

      @Test
      @DisplayName("Cenário 1 - Chamando com sessão nula")
      void test1() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Object cinema = CinemaFactory.getInstance("Cine X");

        Class<Cinema> cinemaClass = Cinema.class;

        Method metodoAdicionarSessao = cinema.getClass().getDeclaredMethod(CinemaUtils.METODO_ADICIONAR_SESSAO, Sessao.class);

        metodoAdicionarSessao.setAccessible(true);

        metodoAdicionarSessao.invoke(cinema, (Sessao) null);

        Field campoSessoes = cinemaClass.getDeclaredField(CinemaUtils.ATRIBUTO_SESSOES);

        campoSessoes.setAccessible(true);

        Assertions.assertTrue(campoSessoes.get(cinema) instanceof List<?>);

        List<?> sessoes = (List<?>) campoSessoes.get(cinema);

        Assertions.assertTrue(sessoes.isEmpty());
      }
    }
  }

  @Nested
  @DisplayName("getQuantidadeSessoes3d")
  class MetodoQuantidadeSessoes3dTests {

    @Nested
    @DisplayName("Deve retornar a quantidade de sessões 3d na lista")
    class MetodoDeveRetornarQuantidadeDeSessoes3dTests {

      @Test
      @DisplayName("Cenário 1 - Deve retornar 0 caso a lista esteja vazia")
      void test1() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        Object cinema = CinemaFactory.getInstance("Cine X");

        Method metodoQuantidadeSessoes3d = cinema.getClass().getDeclaredMethod(CinemaUtils.METODO_GET_QUANTIDADE_SESSOES_3D);

        int quantidade = (int) metodoQuantidadeSessoes3d.invoke(cinema);

        Assertions.assertEquals(0, quantidade);
      }

      @Test
      @DisplayName("Cenário 2 - Deve retornar 1 caso a lista contenha 1 sessões 3d")
      void test2() throws NoSuchMethodException, NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object sessao1 = SessaoFactory.getInstance("Filme X", 10.0, 100, false);
        Object sessao2 = SessaoFactory.getInstance("Filme Y", 20.0, 65, true);
        Object sessao3 = SessaoFactory.getInstance("Filme Z", 10.0, 100, false);

        Object cinema = CinemaFactory.getInstance("Cine X");

        Class<Cinema> cinemaClass = Cinema.class;

        List<Object> sessoesInsert = List.of(sessao1, sessao2, sessao3);

        Field campoSessoes = cinemaClass.getDeclaredField(CinemaUtils.ATRIBUTO_SESSOES);

        campoSessoes.setAccessible(true);

        campoSessoes.set(cinema, sessoesInsert);

        Method metodoQuantidadeSessoes3d = cinema.getClass().getDeclaredMethod(CinemaUtils.METODO_GET_QUANTIDADE_SESSOES_3D);

        int quantidade = (int) metodoQuantidadeSessoes3d.invoke(cinema);

        Assertions.assertEquals(1, quantidade);
      }

      @Test
      @DisplayName("Cenário 3 - Deve retornar 3 caso a lista contenha 3 sessões 3d")
      void test3() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        Object sessao1 = SessaoFactory.getInstance("Filme A", 10.0, 100, true);
        Object sessao4 = SessaoFactory.getInstance("Filme B", 49.0, 29, false);
        Object sessao2 = SessaoFactory.getInstance("Filme C", 20.0, 65, true);
        Object sessao3 = SessaoFactory.getInstance("Filme D", 37.0, 100, true);
        Object sessao5 = SessaoFactory.getInstance("Filme E", 10.0, 57, false);

        Object cinema = CinemaFactory.getInstance("Cine X");

        List<Object> sessoesInsert = List.of(sessao1, sessao2, sessao3, sessao4, sessao5);

        Class<Cinema> cinemaClass = Cinema.class;

        Field campoSessoes = cinemaClass.getDeclaredField(CinemaUtils.ATRIBUTO_SESSOES);

        campoSessoes.setAccessible(true);

        campoSessoes.set(cinema, sessoesInsert);

        Method metodoQuantidadeSessoes3d = cinema.getClass().getDeclaredMethod(CinemaUtils.METODO_GET_QUANTIDADE_SESSOES_3D);

        int quantidade = (int) metodoQuantidadeSessoes3d.invoke(cinema);

        Assertions.assertEquals(3, quantidade);
      }
    }
  }

  @Nested
  @DisplayName("getSessoesPorNomeFilme")
  class MetodoSessoesPorNomeFilmeTests {

    @Nested
    @DisplayName("Deve retornar uma lista de sessões com a nome de filme especificado")
    class MetodoDeveRetornarUmaListaDeSessoesTests {

      @Test
      @DisplayName("Cenário 1 - Deve retornar uma lista com 3 sessões do mesmo filme")
      void test1() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        //Usar contains na String ????
        Object sessao1 = SessaoFactory.getInstance("Filme T", 10.0, 100, false);
        Object sessao5 = SessaoFactory.getInstance("Filme XYZ", 20.0, 65, true);
        Object sessao4 = SessaoFactory.getInstance("Filme A", 49.0, 29, false);
        Object sessao2 = SessaoFactory.getInstance("Filme XYZ", 20.0, 65, true);
        Object sessao3 = SessaoFactory.getInstance("Filme XYZ", 10.0, 100, false);

        Object cinema = CinemaFactory.getInstance("Cine X");

        Class<Cinema> cinemaClass = Cinema.class;

        List<?> sessoesInsert = List.of(sessao1, sessao2, sessao3, sessao4, sessao5);

        Field campoSessoes = cinemaClass.getDeclaredField(CinemaUtils.ATRIBUTO_SESSOES);

        campoSessoes.setAccessible(true);

        campoSessoes.set(cinema, sessoesInsert);

        Method metodoSessoesPorNomeFilme = cinema.getClass().getDeclaredMethod(CinemaUtils.METODO_GET_SESSOES_POR_NOME_FILME, String.class);

        metodoSessoesPorNomeFilme.setAccessible(true);

        List<?> sessoes = (List<?>) metodoSessoesPorNomeFilme.invoke(cinema, "Filme XYZ");

        Sessao sessaoObtida1 = (Sessao) sessoes.get(0);
        Sessao sessaoObtida2 = (Sessao) sessoes.get(1);
        Sessao sessaoObtida3 = (Sessao) sessoes.get(2);

        Class<Sessao> sessaoClass = Sessao.class;

        Field campoFilme = sessaoClass.getDeclaredField(SessaoUtils.ATRIBUTO_FILME);

        campoFilme.trySetAccessible();

        Assertions.assertEquals(3, sessoes.size());
        Assertions.assertEquals("Filme XYZ", campoFilme.get(sessaoObtida1));
        Assertions.assertEquals("Filme XYZ", campoFilme.get(sessaoObtida2));
        Assertions.assertEquals("Filme XYZ", campoFilme.get(sessaoObtida3));
      }

      @Test
      @DisplayName("Cenário 2 - Deve retornar uma lista com 1 sessão do filme")
      void test2() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        Object sessao1 = SessaoFactory.getInstance("Filme X", 10.0, 100, false);
        Object sessao4 = SessaoFactory.getInstance("Filme A", 49.0, 29, false);
        Object sessao3 = SessaoFactory.getInstance("Filme XYZ", 10.0, 100, false);
        Object sessao5 = SessaoFactory.getInstance("Filme B", 20.0, 65, true);
        Object sessao2 = SessaoFactory.getInstance("Filme XY", 20.0, 65, true);

        Object cinema = CinemaFactory.getInstance("Cine X");

        Class<Cinema> cinemaClass = Cinema.class;

        List<?> sessoesInsert = List.of(sessao1, sessao2, sessao3, sessao4, sessao5);

        Field campoSessoes = cinemaClass.getDeclaredField(CinemaUtils.ATRIBUTO_SESSOES);

        campoSessoes.setAccessible(true);

        campoSessoes.set(cinema, sessoesInsert);

        Method metodoSessoesPorNomeFilme = cinema.getClass().getDeclaredMethod(CinemaUtils.METODO_GET_SESSOES_POR_NOME_FILME, String.class);

        metodoSessoesPorNomeFilme.setAccessible(true);

        List<?> sessoes = (List<?>) metodoSessoesPorNomeFilme.invoke(cinema, "Filme A");

        Sessao sessaoObtida1 = (Sessao) sessoes.get(0);

        Class<Sessao> sessaoClass = Sessao.class;

        Field campoFilme = sessaoClass.getDeclaredField(SessaoUtils.ATRIBUTO_FILME);

        campoFilme.trySetAccessible();

        Assertions.assertFalse(sessoes.isEmpty());
        Assertions.assertEquals(1, sessoes.size());
        Assertions.assertEquals("Filme A", campoFilme.get(sessaoObtida1));
      }
    }

    @Nested
    @DisplayName("Deve retornar uma lista de sessões com o filme especificado ignorando letras maiúsculas e minúsculas")
    class MetodoDeveRetornarUmaListaDeSessoesIgnorandoCaseTests {

      @Test
      @DisplayName("Cenário 1 - Deve retornar uma lista com 3 sessões do mesmo filme")
      void test1() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        Object sessao1 = SessaoFactory.getInstance("FILME xyz", 10.0, 100, false);
        Object sessao5 = SessaoFactory.getInstance("filme XyZ", 20.0, 65, true);
        Object sessao4 = SessaoFactory.getInstance("Filme A", 49.0, 29, false);
        Object sessao2 = SessaoFactory.getInstance("filme XYZ", 20.0, 65, true);

        Object cinema = CinemaFactory.getInstance("Cine X");

        Class<Cinema> cinemaClass = Cinema.class;

        List<?> sessoesInsert = List.of(sessao1, sessao2, sessao4, sessao5);

        Field campoSessoes = cinemaClass.getDeclaredField(CinemaUtils.ATRIBUTO_SESSOES);

        campoSessoes.setAccessible(true);

        campoSessoes.set(cinema, sessoesInsert);

        Method metodoSessoesPorNomeFilme = cinema.getClass().getDeclaredMethod(CinemaUtils.METODO_GET_SESSOES_POR_NOME_FILME, String.class);

        metodoSessoesPorNomeFilme.setAccessible(true);

        List<?> sessoes = (List<?>) metodoSessoesPorNomeFilme.invoke(cinema, "FIlmE XYZ");

        Assertions.assertEquals(3, sessoes.size());
      }

      @Test
      @DisplayName("Cenário 2 - Deve retornar uma lista com 1 sessão do filme X")
      void test2() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Object sessao1 = SessaoFactory.getInstance("FILME www", 10.0, 100, false);
        Object sessao5 = SessaoFactory.getInstance("filme XyZ", 20.0, 65, true);
        Object sessao4 = SessaoFactory.getInstance("Filme A", 49.0, 29, false);
        Object sessao2 = SessaoFactory.getInstance("filme abc", 20.0, 65, true);

        Object cinema = CinemaFactory.getInstance("Cine X");

        Class<Cinema> cinemaClass = Cinema.class;

        List<?> sessoesInsert = List.of(sessao1, sessao2, sessao4, sessao5);

        Field campoSessoes = cinemaClass.getDeclaredField(CinemaUtils.ATRIBUTO_SESSOES);

        campoSessoes.setAccessible(true);

        campoSessoes.set(cinema, sessoesInsert);

        Method metodoSessoesPorNomeFilme = cinema.getClass().getDeclaredMethod(CinemaUtils.METODO_GET_SESSOES_POR_NOME_FILME, String.class);

        metodoSessoesPorNomeFilme.setAccessible(true);

        List<?> sessoes = (List<?>) metodoSessoesPorNomeFilme.invoke(cinema, "FIlmE XYZ");

        Assertions.assertEquals(1, sessoes.size());
      }
    }

    @Nested
    @DisplayName("Deve retornar uma lista fazia caso nenhuma sessão seja encontrada")
    class MetodoDeveRetornarUmaListaVaziaTests {

      @Test
      @DisplayName("Cenário 1 - Deve retornar uma lista vazia caso não encontre nenhuma sessão")
      void test1() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        Object sessao1 = SessaoFactory.getInstance("FILME xyz", 10.0, 100, false);
        Object sessao5 = SessaoFactory.getInstance("filme XyZ", 20.0, 65, true);
        Object sessao4 = SessaoFactory.getInstance("Filme A", 49.0, 29, false);
        Object sessao2 = SessaoFactory.getInstance("filme XYZ", 20.0, 65, true);

        Object cinema = CinemaFactory.getInstance("Cine X");

        Class<Cinema> cinemaClass = Cinema.class;

        List<?> sessoesInsert = List.of(sessao1, sessao2, sessao4, sessao5);

        Field campoSessoes = cinemaClass.getDeclaredField(CinemaUtils.ATRIBUTO_SESSOES);

        campoSessoes.setAccessible(true);

        campoSessoes.set(cinema, sessoesInsert);

        Method metodoSessoesPorNomeFilme = cinema.getClass().getDeclaredMethod(CinemaUtils.METODO_GET_SESSOES_POR_NOME_FILME, String.class);

        metodoSessoesPorNomeFilme.setAccessible(true);

        List<?> sessoes = (List<?>) metodoSessoesPorNomeFilme.invoke(cinema, "FIlmE bbb");

        Assertions.assertTrue(sessoes.isEmpty());
      }
    }
  }

  @Nested
  @DisplayName("getMediaIngressosVendidos")
  class MetodoMediaIngressosVendidosTests {

    @Nested
    @DisplayName("Deve retornar a média dos ingressos de todos as sessões")
    class MetodoDeveRetornarAMediaDasSessoesTests {

      @Test
      @DisplayName("Cenário 1 - Calculando média de ingressos vendidos de duas sessões")
      void test1() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        Object sessao1 = SessaoFactory.getInstance("Filme X", 49.50, 98, false);
        Object sessao2 = SessaoFactory.getInstance("Filme Y", 26.30, 32, true);

        Object cinema = CinemaFactory.getInstance("Cine X");

        Field campoSessoes = cinema.getClass().getDeclaredField(CinemaUtils.ATRIBUTO_SESSOES);

        campoSessoes.setAccessible(true);

        campoSessoes.set(cinema, List.of(sessao1, sessao2));

        Method metodoMediaIngressosVendidos = cinema.getClass().getDeclaredMethod(CinemaUtils.METODO_MEDIA_INGRESSOS_VENDIDOS);

        metodoMediaIngressosVendidos.setAccessible(true);

        Double media = (Double) metodoMediaIngressosVendidos.invoke(cinema);

        Assertions.assertEquals(65.0, media, 1.0);
      }

      @Test
      @DisplayName("Cenário 2 - Calculando média de ingressos vendidos de três sessões")
      void test2() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Object sessao1 = SessaoFactory.getInstance("Filme X", 49.50, 98, false);
        Object sessao2 = SessaoFactory.getInstance("Filme Y", 26.30, 32, true);
        Object sessao3 = SessaoFactory.getInstance("Filme Z", 22.60, 57, false);

        Object cinema = CinemaFactory.getInstance("Cine X");

        Field campoSessoes = cinema.getClass().getDeclaredField(CinemaUtils.ATRIBUTO_SESSOES);

        campoSessoes.setAccessible(true);

        campoSessoes.set(cinema, List.of(sessao1, sessao2, sessao3));

        Method metodoMediaIngressosVendidos = cinema.getClass().getDeclaredMethod(CinemaUtils.METODO_MEDIA_INGRESSOS_VENDIDOS);

        metodoMediaIngressosVendidos.setAccessible(true);

        Double media = (Double) metodoMediaIngressosVendidos.invoke(cinema);

        Assertions.assertEquals(62.3, media, 1.0);
      }

      @Test
      @DisplayName("Cenário 3 - Calculando média de ingressos vendidos com nenhuma sessão")
      void test3() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Object cinema = CinemaFactory.getInstance("Cine X");

        Method metodoMediaIngressosVendidos = cinema.getClass().getDeclaredMethod(CinemaUtils.METODO_MEDIA_INGRESSOS_VENDIDOS);

        metodoMediaIngressosVendidos.setAccessible(true);

        Double media = (Double) metodoMediaIngressosVendidos.invoke(cinema);

        Assertions.assertEquals(0.0, media);
      }
    }
  }

  @Nested
  @DisplayName("calcularTotalVendas")
  class MetodoCalcularTotalTests {

    @Nested
    @DisplayName("Deve retornar a soma de todos os ingressos vendidos em todas as sessões")
    class MetodoDeveRetornarASomaDasVendasTests {

      @Test
      @DisplayName("Cenário 1 - Calculando vendas de duas sessões")
      void test1() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Object sessao1 = SessaoFactory.getInstance("Filme X", 49.50, 98, false);
        Object sessao2 = SessaoFactory.getInstance("Filme Y", 26.30, 32, true);

        Object cinema = CinemaFactory.getInstance("Cine X");

        Field campoSessoes = cinema.getClass().getDeclaredField(CinemaUtils.ATRIBUTO_SESSOES);

        campoSessoes.setAccessible(true);

        campoSessoes.set(cinema, List.of(sessao1, sessao2));

        Method metodoTotalVendas = cinema.getClass().getDeclaredMethod(CinemaUtils.METODO_CALCULAR_TOTAL_VENDAS);

        metodoTotalVendas.setAccessible(true);

        Double totalVendas = (Double) metodoTotalVendas.invoke(cinema);

        Assertions.assertEquals(6534.2, totalVendas, 1.0);
      }

      @Test
      @DisplayName("Cenário 2 - Calculando vendas de três sessões")
      void test2() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Object sessao1 = SessaoFactory.getInstance("Filme X", 49.50, 98, false);
        Object sessao2 = SessaoFactory.getInstance("Filme Y", 26.30, 32, true);
        Object sessao3 = SessaoFactory.getInstance("Filme Z", 22.60, 57, false);

        Object cinema = CinemaFactory.getInstance("Cine X");

        Field campoSessoes = cinema.getClass().getDeclaredField(CinemaUtils.ATRIBUTO_SESSOES);

        campoSessoes.setAccessible(true);

        campoSessoes.set(cinema, List.of(sessao1, sessao2, sessao3));

        Method metodoTotalVendas = cinema.getClass().getDeclaredMethod(CinemaUtils.METODO_CALCULAR_TOTAL_VENDAS);

        metodoTotalVendas.setAccessible(true);

        Double totalVendas = (Double) metodoTotalVendas.invoke(cinema);

        Assertions.assertEquals(7822.4, totalVendas, 1.0);
      }

      @Test
      @DisplayName("Cenário 3 - Calculando vendas com nenhuma sessão")
      void test3() throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Object cinema = CinemaFactory.getInstance("Cine X");

        Field campoSessoes = cinema.getClass().getDeclaredField(CinemaUtils.ATRIBUTO_SESSOES);

        campoSessoes.setAccessible(true);

        Method metodoTotalVendas = cinema.getClass().getDeclaredMethod(CinemaUtils.METODO_CALCULAR_TOTAL_VENDAS);

        metodoTotalVendas.setAccessible(true);

        Double totalVendas = (Double) metodoTotalVendas.invoke(cinema);

        Assertions.assertEquals(0.0, totalVendas);
      }
    }
  }
}
