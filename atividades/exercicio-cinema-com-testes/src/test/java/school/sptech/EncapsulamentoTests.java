package school.sptech;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import school.sptech.utils.CinemaUtils;
import school.sptech.utils.SessaoUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Arrays;

@DisplayName("Encapsulamento")
public class EncapsulamentoTests {

  @Nested
  @DisplayName("Sessao")
  class SessaoTests {

    @Nested
    @DisplayName("Todos os atributos de Sessao devem estar privados")
    class TodosAtributosSessaosPrivadosTests {

      @Test
      @DisplayName("Cenário Único")
      void test1() {

        Class<Sessao> clazz = Sessao.class;
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
          int modifier = field.getModifiers();
          Assertions.assertTrue(Modifier.isPrivate(modifier));
        }
      }
    }

    @Nested
    @DisplayName("Todos os atributos de Sessao devem possuir getters e setters")
    class TodosAtributosSessaosDevemPossuirGetterESettersTests {

      @Test
      @DisplayName("Cenário Único")
      void test1() throws NoSuchMethodException {

        Class<Sessao> clazz = Sessao.class;
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {

          String getName = String.format("get%s", StringUtils.capitalize(field.getName()));
          String setName = String.format("set%s", StringUtils.capitalize(field.getName()));

          Method getter = clazz.getDeclaredMethod(getName);
          Method setter = clazz.getDeclaredMethod(setName, field.getType());

          int getModifier = getter.getModifiers();
          int setModifier = setter.getModifiers();

          Assertions.assertTrue(Modifier.isPublic(getModifier));
          Assertions.assertTrue(Modifier.isPublic(setModifier));
        }
      }
    }

    @Nested
    @DisplayName("O método de cálculo do preço do ingresso deve ser público")
    class SessaoCalculoFretePublicoTests {

      @Test
      @DisplayName("Cenário Único")
      void test1() throws NoSuchMethodException {

        Class<Sessao> clazz = Sessao.class;
        Method method = clazz.getMethod(SessaoUtils.METODO_CALCULAR_PRECO_DO_INGRESSO);

        int modifier = method.getModifiers();
        Assertions.assertTrue(Modifier.isPublic(modifier));
      }
    }

    @Nested
    @DisplayName("A classe Sessao deve ter um construtor que inicializa todos os atributos")
    class SessaoConstrutorTests {

      @Test
      @DisplayName("Cenário Único")
      void test1() {

        Class<Sessao> clazz = Sessao.class;
        Constructor<?>[] constructors = clazz.getConstructors();

        Assertions.assertTrue(constructors.length > 0);

        boolean hasFullConstructor = Arrays.stream(constructors)
            .anyMatch(constructor -> {
              Parameter[] parameters = constructor.getParameters();

              long qtdString = Arrays.stream(parameters)
                  .filter(parameter -> parameter.getType().equals(String.class))
                  .count();

              long qtdDouble = Arrays.stream(parameters)
                  .filter(parameter -> parameter.getType().equals(Double.class))
                  .count();

              long qtdInteger = Arrays.stream(parameters)
                  .filter(parameter -> parameter.getType().equals(Integer.class))
                  .count();

              long qtdBoolean = Arrays.stream(parameters)
                  .filter(parameter -> parameter.getType().equals(Boolean.class))
                  .count();

              return (qtdString >= 1 && qtdDouble >= 1 && qtdInteger >= 1 && qtdBoolean >= 1);
            });

        Assertions.assertTrue(hasFullConstructor);
      }
    }
  }

  @Nested
  @DisplayName("Cinema")
  class CinemaTests {

    @Nested
    @DisplayName("Todos os atributos de Cinema devem estar privados")
    class TodosAtributosCinemaPrivadosTests {

      @Test
      @DisplayName("Cenário Único")
      void test1() {
        Class<Cinema> clazz = Cinema.class;
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
          int modifier = field.getModifiers();
          Assertions.assertTrue(Modifier.isPrivate(modifier));
        }
      }
    }

    @Nested
    @DisplayName("Atributo nome deve conter getters e setters")
    class CinemaAtributoNomeClienteDevePossuirGetterESetterTests {

      @Test
      @DisplayName("Cenário Único")
      void test1() throws NoSuchMethodException, NoSuchFieldException {

        Class<Cinema> clazz = Cinema.class;
        Field field = clazz.getDeclaredField(CinemaUtils.ATRIBUTO_NOME);

        String getName = String.format("get%s", StringUtils.capitalize(field.getName()));
        String setName = String.format("set%s", StringUtils.capitalize(field.getName()));

        Method getter = clazz.getDeclaredMethod(getName);
        Method setter = clazz.getDeclaredMethod(setName, field.getType());

        int getModifier = getter.getModifiers();
        int setModifier = setter.getModifiers();

        Assertions.assertTrue(Modifier.isPublic(getModifier));
        Assertions.assertTrue(Modifier.isPublic(setModifier));
      }
    }

    @Nested
    @DisplayName("Atributo sessoes não deve conter getters e setters")
    class CinemaAtributoSessoesNaoDevePossuirGetterESetterTests {

      @Test
      @DisplayName("Cenário Único")
      void test1() throws NoSuchFieldException {

        Class<Cinema> clazz = Cinema.class;
        Field field = clazz.getDeclaredField(CinemaUtils.ATRIBUTO_SESSOES);

        String getName = String.format("get%s", StringUtils.capitalize(field.getName()));
        String setName = String.format("set%s", StringUtils.capitalize(field.getName()));

        Assertions.assertThrows(NoSuchMethodException.class, () -> {
          clazz.getDeclaredMethod(getName);
        });

        Assertions.assertThrows(NoSuchMethodException.class, () -> {
          clazz.getDeclaredMethod(setName, field.getType());
        });
      }
    }

    @Nested
    @DisplayName("A lista de sessoes deve ser inicializada no momento da criação do objeto")
    class CinemaAtributoSessoesDeveSerInicializadoNaCriacaoDoObjetoTests {

      @Test
      @DisplayName("Cenário Único")
      void test1() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Class<Cinema> clazz = Cinema.class;
        Field produtosField = clazz.getDeclaredField(CinemaUtils.ATRIBUTO_SESSOES);
        Constructor<?> constructor = clazz.getConstructors()[0];

        Object[] args = new Object[constructor.getParameterCount()];

        Object compra = constructor.newInstance(args);

        produtosField.trySetAccessible();
        Object produtos = produtosField.get(compra);

        Assertions.assertNotNull(produtos);
      }
    }
  }
}
