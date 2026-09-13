package br.com.alura.ScreenMatch.modelos;

public class Serie extends Titulo{
    // Atributos da Classe
    private int temporadas;
    private int episodiosPorTemporada;
    private int minutosPorEpisodio;
    private boolean ativa;

    // Construtor
    public Serie(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }

    // Metodos da Classe
    @Override
    public int getDuracaoEmMinutos() {
        return (temporadas * episodiosPorTemporada * minutosPorEpisodio);
    }

    // Metodos GETTERS
    public int getTemporadas() {
        return temporadas;
    }
    public boolean isAtiva() {
        return ativa;
    }
    public int getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
    }
    public int getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }

    // Metodos SETTERS
    public void setEpisodiosPorTemporada(int episodiosPorTemporada) {this.episodiosPorTemporada = episodiosPorTemporada;}
    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }
    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }
    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }
}
