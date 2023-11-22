package exe.gba.minhasolucao;

public class Livro {
    private Integer idLivro;
    private String nome;
    private Double preco;

    public Livro () {

    }
    public Livro(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public Integer getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Integer idLivro) {
        this.idLivro = idLivro;
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

    @Override
    public String toString() {
        return """
                
                +---------------------------------------------------------------------+
                | ID: %d
                +---------------------------------------------------------------------+
                | Nome: %s          
                | Preço: R$ %.2f             
                +---------------------------------------------------------------------+
                """.formatted(idLivro, nome, preco);
    }
}
