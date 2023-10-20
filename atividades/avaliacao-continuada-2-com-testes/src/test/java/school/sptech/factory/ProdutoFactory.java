package school.sptech.factory;

import school.sptech.Produto;
import school.sptech.utils.ProdutoUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ProdutoFactory {

  public static Object getInstance(Object nome, Object preco, Object pesoKg, Object fragil, Object categoria)
      throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

    Class<Produto> produtoClass = Produto.class;
    Constructor<?> constructor = produtoClass.getConstructors()[0];

    Object[] args = new Object[constructor.getParameterCount()];
    Object produto = constructor.newInstance(args);

    Field campoNome = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_NOME);
    Field campoPreco = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_PRECO);
    Field campoPeso = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_PESO_KG);
    Field campoFragil = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_FRAGIL);
    Field campoCategoria = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_CATEGORIA);

    campoNome.trySetAccessible();
    campoPreco.trySetAccessible();
    campoPeso.trySetAccessible();
    campoFragil.trySetAccessible();
    campoCategoria.trySetAccessible();

    campoNome.set(produto, nome);
    campoPreco.set(produto, preco);
    campoPeso.set(produto, pesoKg);
    campoFragil.set(produto, fragil);
    campoCategoria.set(produto, categoria);

    return produto;
  }
}
