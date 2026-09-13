package br.com.alura.ScreenMatch.Calculos;

import br.com.alura.ScreenMatch.modelos.Titulo;

public class CalculadoraDeTempo {
    // Atributos da Classe
    private int duracaoTotal;

    // Metodos da Classe
    public int getDuracaoTotal() {
        return duracaoTotal;
    }

    public void inclui(Titulo titulo) {
        duracaoTotal += titulo.getDuracaoEmMinutos();
    }
}
