package org.example;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner leitor = new Scanner(System.in);
    Scanner leitorString = new Scanner(System.in);

    Conexao conexao = new Conexao();
    JdbcTemplate con = conexao.getConexaoDoBanco();

    con.execute("""
        CREATE TABLE IF NOT EXISTS livro (
          id INT PRIMARY KEY AUTO_INCREMENT,
          nome VARCHAR(255),
          preco DECIMAL(10, 2)
        )
        """);

    LivroDao livroDao = new LivroDao(con);
    Menu menu = new Menu(leitor, leitorString, livroDao);

    Integer opcao;

    do {
      menu.exibirMenu();
      opcao = menu.solicitarOpcao();

      switch (opcao) {
        case 1 -> menu.cadastrarLivro();
        case 2 -> menu.listarLivros();
        case 3 -> menu.atualizarLivro();
        case 4 -> menu.removerLivro();
        case 5 -> menu.buscarLivroPorNome();
        case 6 -> menu.exibirMensagemSair();
        default -> menu.exibirMensagemOpcaoInvalida();
      }

    } while(opcao != 6);
  }
}