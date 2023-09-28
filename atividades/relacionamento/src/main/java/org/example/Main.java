package org.example;

public class Main {
    public static void main(String[] args) {
        Grupo grupo = new Grupo("Trio Parada Dura");

        Contato gabriel = new Contato("Gabriel", "(11) 945180144");
        Contato bomDiaECia = new Contato("Bom dia e companhia", "40028922");
        Contato policia = new Contato("Policia - Emergência", "190");


        grupo.adicionarContato(gabriel);
        grupo.adicionarContato(bomDiaECia);
        grupo.adicionarContato(policia);
        grupo.adicionarContato("Mateus", "(11) 961522655");

        System.out.println(grupo.getListaContatos());

        grupo.removerContato(policia);
        grupo.removerContato(2);

        System.out.println(grupo.getListaContatos());
    }
}