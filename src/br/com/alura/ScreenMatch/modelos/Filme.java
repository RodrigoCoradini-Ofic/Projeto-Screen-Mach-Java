package br.com.alura.ScreenMatch.modelos;

import br.com.alura.ScreenMatch.Calculos.Classificavel;

public class Filme extends Titulo implements Classificavel {
    // Atributos da Classe
    private String diretor;

    // Construtor
    public Filme(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }

    // Metodos da Classe
    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getClassificacao() {
        return (int) pegaMedia() / 2;
    }
}
