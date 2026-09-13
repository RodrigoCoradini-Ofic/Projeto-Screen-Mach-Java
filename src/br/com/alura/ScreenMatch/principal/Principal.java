package br.com.alura.ScreenMatch.principal;

import br.com.alura.ScreenMatch.Calculos.CalculadoraDeTempo;
import br.com.alura.ScreenMatch.Calculos.FiltroRecomendacao;
import br.com.alura.ScreenMatch.modelos.Episodio;
import br.com.alura.ScreenMatch.modelos.Filme;
import br.com.alura.ScreenMatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Filme novoFilme = new Filme("Venom - Tempo de Carnificina", 2024);
        String descricao = "Venom luta contra o Clitus Clessedy - O Carnificina";
        int duracaoEmMinutos = 120;
        boolean incluidoNoPlano = true;
        novoFilme.setFichaTecnica(descricao,duracaoEmMinutos,incluidoNoPlano);
        novoFilme.printaFichaTecnica();
        novoFilme.avalia(9);
        novoFilme.avalia(10);
        novoFilme.avalia(10);
        System.out.println(novoFilme.pegaMedia());
        System.out.println("---------------------------------------------------------------");

        Serie serie = new Serie("Demon Slayer", 2025);
        String descricaoSerie = "Muito bom";
        serie.setTemporadas(3);
        serie.setEpisodiosPorTemporada(12);
        serie.setMinutosPorEpisodio(50);
        int duracaoEmMinutoSerie = serie.getDuracaoEmMinutos();
        boolean incluidoSerie = true;
        serie.setFichaTecnica(descricaoSerie,duracaoEmMinutoSerie,incluidoSerie);
        serie.printaFichaTecnica();
        System.out.println("Maratonar: " + serie.getDuracaoEmMinutos() + " minutos");
        System.out.println("---------------------------------------------------------------");

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(novoFilme);
        calculadora.inclui(serie);
        System.out.println("Duração Total: " + calculadora.getDuracaoTotal() + " minutos");
        System.out.println("---------------------------------------------------------------");

        Episodio episodio = new Episodio();
        episodio.setEpisodio(1);
        episodio.setNome("Primeiro");
        episodio.setSerie(serie);
        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(novoFilme);
        filtro.filtra(episodio);
        System.out.println("---------------------------------------------------------------");

        // Criar Lista de Filmes
        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(novoFilme);
        Filme filme1 = new Filme("Demon Slayer Castle Infinity", 2025);
        filme1.setFichaTecnica("Top",  220, true);
        listaDeFilmes.add(filme1);
//        filme1.printaFichaTecnica();
        Filme filme2 = new Filme("Vingadores Era de Ultron", 2020);
        filme2.setFichaTecnica("Marvel", 200, false);
        listaDeFilmes.add(filme2);
        System.out.println(listaDeFilmes);
        System.out.println("Qtd de Filmes: " + listaDeFilmes.size());
        System.out.println("Filme Favorito: " + listaDeFilmes.get(1).getNome());
        System.out.println("---------------------------------------------------------------");

    }
}
