package school.sptech;

import java.util.ArrayList;
import java.util.List;

public class Compra {
    private String nomeCliente;
    private List<Produto> produtos;

    public Compra(String nomeCliente) {
        this.nomeCliente = nomeCliente;
        this.produtos = new ArrayList<>();
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public void adicionarProduto (Produto produto) {
        if (produto != null) {
            produtos.add(produto);
        }
    }

    public void removerProduto (int indice) {
        if (indice >= 0 && indice < produtos.size()) {
            produtos.remove(indice);
        }
    }

    public Integer getQuantidadeProdutos () {
        return produtos.size();
    }

    public Integer getQuantidadeProdutosFrageis () {
        Integer quantidadeProdutos = 0;

        for (Produto produtoAtual:
             produtos) {
            if (produtoAtual.getFragil()) {
                quantidadeProdutos++;
            }
        }

        return quantidadeProdutos;
    }

    public Produto getProdutoPorNome (String nome) {
        for (Produto produtoAtual:
             produtos) {
            if (produtoAtual.getNome().equalsIgnoreCase(nome)) { return produtoAtual; }
        }

        return null;
    }

    public List<Produto> getProdutosPorCategoria (String categoria) {
        List <Produto> produtosEncontrados = new ArrayList<>();

        for (Produto produtoAtual :
                produtos) {
            if (produtoAtual.getCategoria().equalsIgnoreCase(categoria)) {
                produtosEncontrados.add(produtoAtual);
            }
        }

        return produtosEncontrados;
    }
    
    public Double calcularTotalFrete () {
        Double frete = 0.0;

        for (Produto produtoAtual :
                produtos) {
            frete += produtoAtual.calcularFrete();
        }
        
        return frete;
    }
    
    public Double calcularTotalProdutos () {
        Double total = 0.0;

        for (Produto produtoAtual :
                produtos) {
            total += produtoAtual.getPreco();
        }

        return total;
    }

    public Double calcularTotalCompra () {
        return this.calcularTotalFrete() + this.calcularTotalProdutos();
    }
}
