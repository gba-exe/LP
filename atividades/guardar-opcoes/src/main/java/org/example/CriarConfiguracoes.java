package org.example;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Configuracoes {
    private List<String> opcoes = new ArrayList<>();

    public Configuracoes (){
        opcoes.add("CPU");
        opcoes.add("RAM");
        opcoes.add("ARMAZENAMENTO");
    }

    public void criarConfiguracoes () {
        File configTxt = new File("config.txt");

        System.out.println("File created: " + configTxt.getName());
    }
}
