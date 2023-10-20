package school.sptech.factory;

import school.sptech.Sessao;
import school.sptech.utils.SessaoUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class SessaoFactory {

  public static Object getInstance(Object filme, Object preco, Object ingressosVendidos, Object sessao3d) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

    Class<Sessao> sessaoClass = Sessao.class;
    Constructor<?> constructor = sessaoClass.getConstructors()[0];

    Object[] args = new Object[constructor.getParameterCount()];
    Object sessao = constructor.newInstance(args);

    Field campoFilme = sessaoClass.getDeclaredField(SessaoUtils.ATRIBUTO_FILME);
    Field campoPreco = sessaoClass.getDeclaredField(SessaoUtils.ATRIBUTO_PRECO);
    Field campoIngressosVendidos = sessaoClass.getDeclaredField(SessaoUtils.ATRIBUTO_INGRESSOS_VENDIDOS);
    Field campoSessao3d = sessaoClass.getDeclaredField(SessaoUtils.ATRIBUTO_SESSAO_3D);

    campoFilme.trySetAccessible();
    campoPreco.trySetAccessible();
    campoIngressosVendidos.trySetAccessible();
    campoSessao3d.trySetAccessible();

    campoFilme.set(sessao, filme);
    campoPreco.set(sessao, preco);
    campoIngressosVendidos.set(sessao, ingressosVendidos);
    campoSessao3d.set(sessao, sessao3d);

    return sessao;
  }
}
