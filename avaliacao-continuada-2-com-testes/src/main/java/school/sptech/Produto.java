package school.sptech;

public class Produto {
    private String nome;
    private Double preco;
    private Double pesoKg;
    private Boolean fragil;
    private String categoria;

    public Produto(String nome, Double preco, Double pesoKg, Boolean fragil, String categoria) {
        this.nome = nome;
        this.preco = preco;
        this.pesoKg = pesoKg;
        this.fragil = fragil;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(Double pesoKg) {
        this.pesoKg = pesoKg;
    }

    public Boolean getFragil() {
        return fragil;
    }

    public void setFragil(Boolean fragil) {
        this.fragil = fragil;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double calcularFrete () {
        Double frete = pesoKg * 0.10;

        if (fragil) {
            return frete * 2;
        }

        return frete;
    }
}
