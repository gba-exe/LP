package school.sptech;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import school.sptech.utils.CompraUtils;
import school.sptech.utils.ProdutoUtils;

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
  @DisplayName("Produto")
  class ProdutoTests {

    @Nested
    @DisplayName("Todos os atributos de Produto devem estar privados")
    class TodosAtributosProdutosPrivadosTests {

      @Test
      @DisplayName("Cenário Único")
      void test1() {

        Class<Produto> clazz = Produto.class;
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
          int modifier = field.getModifiers();
          Assertions.assertTrue(Modifier.isPrivate(modifier));
        }
      }
    }

    @Nested
    @DisplayName("Todos os atributos de Produto devem possuir getters e setters")
    class TodosAtributosProdutosDevemPossuirGetterESettersTests {

      @Test
      @DisplayName("Cenário Único")
      void test1() throws NoSuchMethodException {

        Class<Produto> clazz = Produto.class;
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
    @DisplayName("O método de cálculo de frete deve ser público")
    class ProdutoCalculoFretePublicoTests {

      @Test
      @DisplayName("Cenário Único")
      void test1() throws NoSuchMethodException {

        Class<Produto> clazz = Produto.class;
        Method method = clazz.getMethod(ProdutoUtils.METODO_CALCULAR_FRETE);

        int modifier = method.getModifiers();
        Assertions.assertTrue(Modifier.isPublic(modifier));
      }
    }

    @Nested
    @DisplayName("A classe Produto deve ter um construtor que inicializa todos os atributos")
    class ProdutoConstrutorTests {

      @Test
      @DisplayName("Cenário Único")
      void test1() {

        Class<Produto> clazz = Produto.class;
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

              long qtdBoolean = Arrays.stream(parameters)
                  .filter(parameter -> parameter.getType().equals(Boolean.class))
                  .count();

              return (qtdString == 2 && qtdDouble == 2 && qtdBoolean == 1);
            });

        Assertions.assertTrue(hasFullConstructor);
      }
    }
  }

  @Nested
  @DisplayName("Compra")
  class CompraTests {

    @Nested
    @DisplayName("Todos os atributos de Compra devem estar privados")
    class TodosAtributosCompraPrivadosTests {

      @Test
      @DisplayName("Cenário Único")
      void test1() {
        Class<Compra> clazz = Compra.class;
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
          int modifier = field.getModifiers();
          Assertions.assertTrue(Modifier.isPrivate(modifier));
        }
      }
    }

    @Nested
    @DisplayName("Atributo nome cliente deve conter getters e setters")
    class CompraAtributoNomeClienteDevePossuirGetterESetterTests {

      @Test
      @DisplayName("Cenário Único")
      void test1() throws NoSuchMethodException, NoSuchFieldException {

        Class<Compra> clazz = Compra.class;
        Field field = clazz.getDeclaredField(CompraUtils.ATRIBUTO_NOME_CLIENTE);

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
    @DisplayName("Atributo produtos não deve conter getters e setters")
    class CompraAtributoProdutosNaoDevePossuirGetterESetterTests {

      @Test
      @DisplayName("Cenário Único")
      void test1() throws NoSuchFieldException {

        Class<Compra> clazz = Compra.class;
        Field field = clazz.getDeclaredField(CompraUtils.ATRIBUTO_PRODUTOS);

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
    @DisplayName("A lista de produtos deve ser inicializada no momento da criação do objeto")
    class CompraAtributoProdutosDeveSerInicializadoNaCriacaoDoObjetoTests {

      @Test
      @DisplayName("Cenário Único")
      void test1() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Class<Compra> clazz = Compra.class;
        Field produtosField = clazz.getDeclaredField(CompraUtils.ATRIBUTO_PRODUTOS);
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
