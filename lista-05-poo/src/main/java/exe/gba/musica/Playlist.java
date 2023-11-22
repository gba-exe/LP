package exe.gba.musica;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private List<Musica> listaMusicas = new ArrayList<>();

    public void adicionarMusica(Musica novaMusica){
        listaMusicas.add(novaMusica);
    }

    public void moverMusica(Integer posicao, Integer novaPosicao){
        Musica musicaToMove = listaMusicas.get(posicao);
        listaMusicas.remove(musicaToMove);
        listaMusicas.add(novaPosicao, musicaToMove);
    }

    public void removerMusica(Integer posicao){
        Musica musicaToRemove = listaMusicas.get(posicao);
        listaMusicas.remove(musicaToRemove);
    }

    public Double getDuracao(){
        Double totalMin = 0.0;

        for (Musica musicaAtual:
             listaMusicas) {
            totalMin += musicaAtual.getDuracao();
        }
        return totalMin;
    }

    public void exibirMusicas(){
        for (Musica musicaAtual:
             listaMusicas) {
            musicaAtual.exibirInformacoes();
        }
    }
}
