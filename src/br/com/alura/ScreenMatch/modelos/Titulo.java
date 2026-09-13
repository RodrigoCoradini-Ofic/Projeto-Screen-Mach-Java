package br.com.alura.ScreenMatch.modelos;

public class Titulo implements Comparable<Titulo>{

    // Atributos Da Classe
    private String nome;
    private String descricao;
    private int totalDeAvaliacao;
    private double somaDasAvaliacao;
    private int duracaoEmMinutos;
    private boolean incluidoNoPlano;
    private int anoDeLancamento;

    // Construtor
    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }
    // Contrato com Comparable
    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    // Métodos Da Classe
    public void setFichaTecnica(String descricao,int duracaoEmMinutos,boolean incluidoNoPlano){
        this.descricao = descricao;
        this.duracaoEmMinutos = duracaoEmMinutos;
        this.incluidoNoPlano = incluidoNoPlano;
    }
    // Gerado pela IDE
    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setNome(String nome) {this.nome = nome;}
    // Acabou

    public void printaFichaTecnica(){
        System.out.println("Nome do Filme: " + nome);
        System.out.println("Ano de Lançamento: " + anoDeLancamento);
        System.out.println("Descrição Completa: \n" + descricao);
        System.out.println("Duração: " + duracaoEmMinutos + " minutos");
        System.out.println("Incluído no plano: " + incluidoNoPlano);
    }

    public void avalia(double nota){
        somaDasAvaliacao += nota;
        totalDeAvaliacao++;
    }

    public double pegaMedia(){
        return somaDasAvaliacao / totalDeAvaliacao;
    }

    //Metodo Acessor do totalDeAvaliacao
    public int getTotalDeAvaliacao(){
        return totalDeAvaliacao;
    }

    // Metodo Override do toString

    @Override
    public String toString() {
        return "Título: " + this.getNome() + " (" + this.getAnoDeLancamento() + ")";
    }
}
