package org.example;

public class Contato {
    private String nome;
    private String telefone;
    private Boolean isBloqueado;

    public Contato(String nome, String telefone){
        this.nome = nome;
        this.telefone = telefone;
        this.isBloqueado = false;
    }

    public void bloquear(){
        this.isBloqueado = true;
    }

    public void desbloquear(){
        this.isBloqueado = false;
    }

    @Override
    public String toString() {
        return """

                +---------------------------------------------------------------+
                | Contato
                +---------------------------------------------------------------+
                | Nome: %s
                | Telefone: %s 
                | Status: %s
                +---------------------------------------------------------------+

                """.formatted(nome, telefone, isBloqueado ? "Bloqueado" : "Ativo");
    }
}
