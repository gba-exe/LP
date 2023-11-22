package exe.gba.musica;

public class Main {
    public static void main(String[] args) {
        Musica massacra = new Musica("Massacra", "Hellhammer", "Thrash Metal", 2.51);
        Musica fourHorsemen = new Musica("The Four Horsemen", "Metallica", "Thrash Metal", 7.12);
        Musica holyWars = new Musica("Holy wars... The Punishment Due", "Megadeth", "Thrash Metal", 6.32);
        Musica pneumoultramicroscopicsilicovulcanoconiosis = new Musica("Pneumoultramicroscopicsilicovulcanoconiosis", "XAVLEGBMAOFFFASSSSITIMIWOAMNDUTROABCWAPWAEIIPPOHFFFX", "Slum Metal", 3.25);
        Musica mussoliniMosh = new Musica("Mussolini Mosh", "Gama Bomb", "Metal", 1.13);
        Musica trueLove = new Musica("True Love", "SOJA", "Reggae", 3.13);

        Playlist metal = new Playlist();

        metal.adicionarMusica(massacra);
        metal.adicionarMusica(fourHorsemen);
        metal.adicionarMusica(holyWars);
        metal.adicionarMusica(pneumoultramicroscopicsilicovulcanoconiosis);
        metal.adicionarMusica(mussoliniMosh);
        metal.adicionarMusica(trueLove);

        metal.moverMusica(3,0);

        System.out.println("Duração da playlist: " + metal.getDuracao());
        metal.exibirMusicas();
    }
}
