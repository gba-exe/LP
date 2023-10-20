package exe.gba.musica;

public class Musica {
    private String nome;
    private String artista;
    private String genero;
    private Double duracao;

    public Musica(String nome, String artista, String genero, Double duracao) {
        this.nome = nome;
        this.artista = artista;
        this.genero = genero;
        this.duracao = duracao;
    }

    public String getNome() {
        return nome;
    }

    public String getArtista() {
        return artista;
    }

    public String getGenero() {
        return genero;
    }

    public Double getDuracao() {
        return duracao;
    }

    public void exibirInformacoes(){
        System.out.println("""
                ------------------------------------------------------------------
                %s | %s
                Gênero: %s   Duração: %.2f
                ┊ ⇄ ◁◁ II ▷▷ ↻ ┊
                ------------------------------------------------------------------
                """.formatted(nome,artista,genero,duracao));
    }
}
