package org.example;

public class Livro {

  private Integer id;
  private String nome;
  private Double preco;

  public Livro() {
  }

  public Livro(String nome, Double preco) {
    this.nome = nome;
    this.preco = preco;
  }

  public Livro(Integer id, String nome, Double preco) {
    this.id = id;
    this.nome = nome;
    this.preco = preco;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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
    return "\nLivro{" +
        "id='" + id + '\'' +
        ", nome='" + nome + '\'' +
        ", preco=" + preco +
        '}';
  }
}
