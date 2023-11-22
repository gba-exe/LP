package org.example;

import java.util.ArrayList;
import java.util.List;

public class Prateleira {
    private List<Livro> livros;
    private Integer limite;
    private Double peso;

    public Prateleira(Integer limite, Double peso) {
        this.livros = new ArrayList<>();
        this.limite = limite;
        this.peso = peso;
    }

    public void adicionarLivro (Livro livro) {
        if (livros.size() < limite) {
            livros.add(livro);
            System.out.println("Livro adicionado.");
        } else {
            System.out.println("Limite de livros atingido.");
        }
    }

    public Integer quantidadeLivros () {
        return livros.size();
    }

    public void removerLivro (String codigo) {
        for (Livro livroAtual : livros) {
            if (livroAtual.getCodigo().equals(codigo)){
                livros.remove(livroAtual);
                break;
            }
        }
    }

    public Double getPesoTotal() {
        Double pesoTotal = peso;
        for (Livro livroAtual:
             livros) {
            pesoTotal += livroAtual.calcularPeso();
        }

        return pesoTotal;
    }

    public Livro getLivroPorNome (String nome) {
        for (Livro livroAtual : livros) {
            if (livroAtual.getNome().equalsIgnoreCase(nome)){
                return livroAtual;
            }
        }

        return null;
    }
}
