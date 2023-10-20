package school.sptech;

public class Sessao {
    private String filme;
    private Double preco;
    private Integer ingressosVendidos;
    private Boolean sessao3d;

    public Sessao(String filme, Double preco, Integer ingressosVendidos, Boolean sessao3d) {
        this.filme = filme;
        this.preco = preco;
        this.ingressosVendidos = ingressosVendidos;
        this.sessao3d = sessao3d;
    }

    public String getFilme() {
        return filme;
    }

    public void setFilme(String filme) {
        this.filme = filme;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getIngressosVendidos() {
        return ingressosVendidos;
    }

    public void setIngressosVendidos(Integer ingressosVendidos) {
        this.ingressosVendidos = ingressosVendidos;
    }

    public Boolean getSessao3d() {
        return sessao3d;
    }

    public void setSessao3d(Boolean sessao3d) {
        this.sessao3d = sessao3d;
    }

    public Double calcularPrecoDoIngresso() {
        if (sessao3d) { return preco*2; }

        return preco;
    }
}
