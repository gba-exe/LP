package school.sptech;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private String nome;
    private List<Sessao> sessoes;

    public Cinema(String nome) {
        this.nome = nome;
        this.sessoes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionarSessao(Sessao sessao) {
        if (sessao != null) {
            sessoes.add(sessao);
        }
    }

    public Integer getQuantidadeSessoes3d() {
        Integer quantidadeSessoes3d = 0;

        for (Sessao sessaoAtual:
             sessoes) {
            if (sessaoAtual.getSessao3d()) {
                quantidadeSessoes3d++;
            }
        }

        return quantidadeSessoes3d;
    }

    public List<Sessao> getSessoesPorNomeFilme (String filme) {
        List<Sessao> listaFilmes = new ArrayList<>();

        for (Sessao sessaoAtual:
                sessoes) {
            if (sessaoAtual.getFilme().equalsIgnoreCase(filme)) {
                listaFilmes.add(sessaoAtual);
            }
        }

        return listaFilmes;
    }

    public Double getMediaIngressosVendidos() {
        Integer quantidadeDeSessoes = sessoes.size();
        Double valorArrecadado = 0.0;

        if (!sessoes.isEmpty()) {
            for (Sessao sessaoAtual :
                    sessoes) {
                valorArrecadado += sessaoAtual.getIngressosVendidos();
            }
            return valorArrecadado / quantidadeDeSessoes;
        }
        return 0.0;
    }

    public Double calcularTotalVendas() {
        Double totalVendas = 0.0;

        for (Sessao sessaoAtual :
                sessoes) {
            totalVendas += sessaoAtual.getIngressosVendidos() * sessaoAtual.calcularPrecoDoIngresso();
        }
        return totalVendas;

    }
}
