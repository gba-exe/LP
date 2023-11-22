package org.example;

import java.util.List;
import java.util.Scanner;

public class Menu {

  private Scanner leitor;
  private Scanner leitorString;
  private LivroDao livroDao;

  public Menu(Scanner leitor, Scanner leitorString, LivroDao livroDao) {
    this.leitor = leitor;
    this.leitorString = leitorString;
    this.livroDao = livroDao;
  }

  public void exibirMenu() {
    System.out.println("""
          +---------------------------+
          | Livraria SPTECH           |
          +---------------------------+
          | 1) Cadastrar Livro        |
          | 2) Exibir livros          |
          | 3) Atualizar livro        |
          | 4) Remover livro          |
          | 5) Buscar por nome        |
          | 6) Sair                   |
          +---------------------------+
          """);
  }

  public Integer solicitarOpcao() {
    System.out.println("Selecione uma opção:");
    return leitor.nextInt();
  }

  public void cadastrarLivro() {
    System.out.println("Nome do livro:");
    String nome = leitorString.nextLine();

    System.out.println("Preço do livro:");
    Double preco = leitor.nextDouble();

    Livro livro = new Livro(nome, preco);
    livroDao.cadastrar(livro);
  }

  public void listarLivros() {
    List<Livro> livros = livroDao.listar();
    System.out.println(livros);
  }

  public void atualizarLivro() {
    System.out.println("Id do livro:");
    Integer id = leitor.nextInt();

    System.out.println("Nome do livro:");
    String nome = leitorString.nextLine();

    System.out.println("Preço do livro:");
    Double preco = leitor.nextDouble();

    Livro livro = new Livro(id, nome, preco);
    livroDao.atualizar(livro);
  }

  public void removerLivro() {
    System.out.println("Id do livro:");
    Integer id = leitor.nextInt();

    livroDao.remover(id);
  }

  public void buscarLivroPorNome() {
    System.out.println("Digite o nome do livro:");
    String busca = leitorString.nextLine();

    List<Livro> livros = livroDao.buscarPorNome(busca);
    System.out.println(livros);
  }

  public void exibirMensagemSair() {
    System.out.println("Até mais :)");
  }

  public void exibirMensagemOpcaoInvalida() {
    System.out.println("Opção inválida, digite outro valor.");
  }
}
