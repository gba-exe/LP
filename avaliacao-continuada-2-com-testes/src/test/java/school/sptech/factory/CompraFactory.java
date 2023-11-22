package school.sptech.factory;

import school.sptech.Compra;
import school.sptech.utils.CompraUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class CompraFactory {

  public static Object getInstance(Object nomeCliente)
      throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

    Class<Compra> compraClass = Compra.class;
    Constructor<?> constructor = compraClass.getConstructors()[0];

    Object[] args = new Object[constructor.getParameterCount()];
    Object compra = constructor.newInstance(args);

    Field campoNomeCliente = compraClass.getDeclaredField(CompraUtils.ATRIBUTO_NOME_CLIENTE);
    Field campoProdutos = compraClass.getDeclaredField(CompraUtils.ATRIBUTO_PRODUTOS);

    campoNomeCliente.trySetAccessible();
    campoProdutos.trySetAccessible();

    campoNomeCliente.set(compra, nomeCliente);
    campoProdutos.set(compra, new ArrayList<>());

    return compra;
  }
}
