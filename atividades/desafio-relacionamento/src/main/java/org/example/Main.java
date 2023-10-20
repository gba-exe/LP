package org.example;

public class Main {
    public static void main(String[] args) {

        Livro l1 = new Livro("001", "Pequeno Príncipe", "Diego", 100);
        Livro l2 = new Livro("002", "O Guia do Mochileiro das Galáxias", "Douglas Adams", 250);

        Prateleira p1 = new Prateleira(1, 100.0);

        System.out.println(p1.quantidadeLivros());

        p1.adicionarLivro(l1);
        System.out.println(p1.quantidadeLivros());

        p1.adicionarLivro(l2);
        System.out.println(p1.quantidadeLivros());

//        p1.removerLivro("001");
//        System.out.println(p1.quantidadeLivros());

        System.out.println(p1.getPesoTotal());

        System.out.println(p1.getLivroPorNome("Pequeno Príncipe"));
    }
}