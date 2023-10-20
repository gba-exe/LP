package org.example;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
import com.github.javafaker.Faker;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker(new Locale("pt-BR"));

        String name = faker.name().fullName();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();

        String streetAddress = faker.address().streetAddress();

        System.out.println("""
                Nome: %s
                Primeiro nome: %s
                Segundo nome: %s
                Endereço: %s
                """.formatted(name, firstName, lastName, streetAddress));

        Looca luquinhas = new Looca();

        Memoria memoria = luquinhas.getMemoria();
        Sistema sistema = luquinhas.getSistema();

        Temperatura temperatura = luquinhas.getTemperatura();

        System.out.println(memoria);
        System.out.println(sistema);
        System.out.println(temperatura);
    }
}