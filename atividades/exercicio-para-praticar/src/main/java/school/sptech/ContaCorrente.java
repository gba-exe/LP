package school.sptech;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ContaCorrente {
    private String titular;
    private String agencia;
    private String numero;
    private List<OperacaoBancaria> operacoes;

    public ContaCorrente(String titular, String agencia, String numero) {
        this.titular = titular;
        this.agencia = agencia;
        this.numero = numero;
        this.operacoes = new ArrayList<>();
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void adicionarOperacao (String categoria, String descricao, Double valor) {
        Boolean categoriaInvalida = categoria == null || categoria.isBlank();
        Boolean descricaoInvalida = valor == null || descricao.isBlank();
        Boolean valorInvalido = valor == null || valor <= 0;

        if (!categoriaInvalida && !descricaoInvalida && !valorInvalido) {
            OperacaoBancaria operacao = new OperacaoBancaria(categoria, descricao, valor);
            operacoes.add(operacao);
        }
    }
    public List<OperacaoBancaria> buscarOperacoesPorCategoria (String categoria) {
        List<OperacaoBancaria> operacoesEncontradas = new ArrayList<>();

        if (categoria != null) {
            for (OperacaoBancaria operacaoAtual :
                    operacoes) {
                if (operacaoAtual.getCategoria().equalsIgnoreCase(categoria)) {
                    operacoesEncontradas.add(operacaoAtual);
                }
            }
        }

        return operacoesEncontradas;
    }

    public List<OperacaoBancaria> buscarOperacoesPorValor (Double valor) { return null; }

    public List<OperacaoBancaria> buscarOperacoesSaida () { return null; }
    public List<OperacaoBancaria> buscarOperacoesEntrada () { return null; }

    public List<OperacaoBancaria> buscarOperacoesPorDescricao (String descricao) { return null; }

    public Double buscarMaiorValor () { return null; }

    public Double buscarMenorValor () { return null; }

    public Double obterSaldo () { return null; }
}
