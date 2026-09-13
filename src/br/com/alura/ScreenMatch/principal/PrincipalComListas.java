package br.com.alura.ScreenMatch.principal;

import br.com.alura.ScreenMatch.modelos.Filme;
import br.com.alura.ScreenMatch.modelos.Serie;
import br.com.alura.ScreenMatch.modelos.Titulo;

import java.util.*;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme novoFilme = new Filme("Venom - Tempo de Carnificina", 2024);
        Serie serie = new Serie("Demon Slayer", 2025);
        Filme filme1 = new Filme("Demon Slayer Castle Infinity", 2025);
        Filme filme2 = new Filme("Vingadores Era de Ultron", 2020);

        List<Titulo> lista = new LinkedList<>();
        lista.add(novoFilme);
        lista.add(serie);
        lista.add(filme1);
        lista.add(filme2);

        for (Titulo item : lista) {
            System.out.println(item.getNome());
//            Filme filme = (Filme) item;
//            System.out.println(filme.getClassificacao());
        }

        // Fazendo um Teste de Ordenação
        List<String> buscaPorArtista = new LinkedList<>();
        buscaPorArtista.add("Tom Hardy");
        buscaPorArtista.add("Rodrigo Coradini");
        buscaPorArtista.add("Adlam Sender");
        System.out.println(buscaPorArtista);

        Collections.sort(buscaPorArtista);
        System.out.println("Artistas Ordenados: ");
        System.out.println(buscaPorArtista);

        // Ordenando a Lista de Filmes
        System.out.println("Lista dos Filmes Antes: ");
        System.out.println(lista);
        Collections.sort(lista);
        System.out.println("Filmes Ordenados: ");
        System.out.println(lista);
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Filmes Ordenados por Ano de Lancamento: ");
        System.out.println(lista);
    }
}
