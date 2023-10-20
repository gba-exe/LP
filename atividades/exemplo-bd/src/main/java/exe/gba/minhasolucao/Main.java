package exe.gba.minhasolucao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CRUD crud = new CRUD();
        Scanner leitorTexto = new Scanner(System.in);
        Scanner leitorNumero = new Scanner(System.in);
        Integer resposta;

        while (true) {
            System.out.println("""
                    +------------------------------+
                    | Livraria SPTECH              |
                    +------------------------------+
                    | 1) Cadastrar livro           |
                    | 2) Exibir livros             |
                    | 3) Atualizar livro           |
                    | 4) Remover livro             |
                    | 5) Buscar por nome           |
                    | 6) Sair                      |
                    +------------------------------+
                    """);

            resposta = leitorNumero.nextInt();

            if (resposta == 6) {
                break;
            }

            if (resposta > 6 || resposta < 0){
                System.out.println("Número Inválido");
            }

            switch (resposta) {
                case 1:
                    System.out.println("Digite o nome do livro: ");
                    String nomeLivro = leitorTexto.nextLine();

                    System.out.println("Digite o preço do livro: ");
                    Double precoLivro = leitorNumero.nextDouble();

                    crud.inserirLivro(nomeLivro, precoLivro);
                    break;

                case 2:
                    crud.listarLivros();
                    break;

                case 3:
                    System.out.println("Digite o ID do livro a ser atualizado: ");
                    Integer idLivro = leitorNumero.nextInt();

                    System.out.println("Digite o novo nome do livro: ");
                    String novoNomeLivro = leitorTexto.nextLine();

                    System.out.println("Digite o novo preço do livro: ");
                    Double novoPrecoLivro = leitorNumero.nextDouble();

                    crud.atualizarLivro(idLivro, novoNomeLivro, novoPrecoLivro);
                    break;

                case 4:
                    System.out.println("Digite o ID do livro a ser deletado: ");
                    Integer idLivroDeletado = leitorNumero.nextInt();

                    crud.deletarLivro(idLivroDeletado);
                    break;

                case 5:
                    System.out.println("Digite o nome do livro: ");
                    String pesquisa = leitorTexto.nextLine();

                    crud.buscarLivro(pesquisa);
                    break;
            }

        }
    }
}