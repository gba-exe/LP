package exe.gba;

import exe.gba.dev.Dev;
import exe.gba.dev.DevMobile;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private Vector<Dev> devs;

    public Consultoria(String nome, Integer vagas) {
        this.nome = nome;
        this.vagas = vagas;
        this.devs = new Vector<>(vagas);
    }

    public Boolean existePorNome (String nome) {
        for (Dev devAtual :
                devs) {
            if (devAtual.getNome().equalsIgnoreCase(nome)) {
                return true;
            }
        }
        
        return false;
    }

    public void contratar (Dev dev) {
        if (devs.size() < vagas) {
            devs.add(dev);
        }
    }

    public Integer getQuantidadeDevs () {
        return devs.size();
    }

    public Integer getQuantidadeDevsMobile () {
        int qtdDevs = 0;
        for (Dev devAtual :
                devs) {
            if (devAtual instanceof DevMobile) {
                qtdDevs += 1;
            }
        }

        return qtdDevs;
    }

    public Double getTotalSalarios () {
        Double totalSalarios = 0.0;

        for (Dev devAtual :
                devs) {
                totalSalarios += devAtual.getSalario();
        }

        return totalSalarios;
    }

    public Dev getDevPorNome (String nome) {
        for (Dev devAtual :
                devs) {
            if (devAtual.getNome().equalsIgnoreCase(nome)) {
                return devAtual;
            }
        }
        return null;
    }
}
