package org.example;

import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private String nome;
    private List<Contato> listaContatos;

    public Grupo(String nome) {
        this.nome = nome;
        this.listaContatos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Contato> getListaContatos() {
        return listaContatos;
    }

    public void adicionarContato(Contato contato) { this.listaContatos.add(contato); }
    public void adicionarContato(String nome, String telefone) {
        Contato contato = new Contato(nome, telefone);
        this.listaContatos.add(contato);
    }

    public void removerContato(Contato contato) {
        this.listaContatos.remove(contato);
    }

    public void removerContato(int indice) {
        if (indice >= 0 && indice < listaContatos.size()) {
            this.listaContatos.remove(indice);
        }
    }
}
