package school.sptech.factory;

import school.sptech.Cinema;
import school.sptech.utils.CinemaUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class CinemaFactory {

  public static Object getInstance(Object nomeCinema) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

    Class<Cinema> cinemaClass = Cinema.class;
    Constructor<?> constructor = cinemaClass.getConstructors()[0];

    Object[] args = new Object[constructor.getParameterCount()];
    Object cinema = constructor.newInstance(args);

    Field campoNome = cinemaClass.getDeclaredField(CinemaUtils.ATRIBUTO_NOME);
    Field campoSessoes = cinemaClass.getDeclaredField(CinemaUtils.ATRIBUTO_SESSOES);

    campoNome.trySetAccessible();
    campoSessoes.trySetAccessible();

    campoNome.set(cinema, nomeCinema);
    campoSessoes.set(cinema, new ArrayList<>());

    return cinema;
  }
}
