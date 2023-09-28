package org.example;

public class Livro {
    private String codigo;
    private String nome;
    private String autor;
    private Integer quantidadePaginas;

    public Livro(String codigo, String nome, String autor, Integer quantidadePaginas) {
        this.codigo = codigo;
        this.nome = nome;
        this.autor = autor;
        this.quantidadePaginas = quantidadePaginas;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getQuantidadePaginas() {
        return quantidadePaginas;
    }

    public void setQuantidadePaginas(Integer quantidadePaginas) {
        this.quantidadePaginas = quantidadePaginas;
    }

    public Double calcularPeso() {
        return this.quantidadePaginas * 0.24;
    }
}
