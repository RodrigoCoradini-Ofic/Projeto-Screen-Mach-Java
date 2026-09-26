// Importando Bibliotecas
package br.com.alura.ScreenMatch.buscas;
import br.com.alura.ScreenMatch.arquivos.SalvarArquivos;
import br.com.alura.ScreenMatch.modelos.Titulo;
import br.com.alura.ScreenMatch.modelos.TituloOMDB;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BuscarRespostaUsuario {
    protected Scanner scanner;
    protected ConeccaoAPI coneccaoAPI;
    protected Gson gson;
    protected ArrayList<Titulo> titulos;
    protected SalvarArquivos salvarArquivos;
    protected String busca;

    // Construtor da Classe
    public BuscarRespostaUsuario() throws IOException {
        this.scanner = new Scanner(System.in);
        this.coneccaoAPI = new ConeccaoAPI();
        this.gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();
        this.titulos = new ArrayList<>();
        this.salvarArquivos = new SalvarArquivos();
        this.busca = "";
    }

    // Metodo para ler o que o usuário escreveu
     public void pegarRespostaUsuario() throws IOException, InterruptedException {
        while(!busca.equalsIgnoreCase("sair")){
            System.out.println("Digite um Filme para Busca: (Em MINÚSCULO)");
            this.busca = scanner.nextLine().replace(' ', '+');

            // Se o usuário escrever "sair" sai do loop
            if (busca.equalsIgnoreCase("sair")){
                continue;}

            // Conecat a API
            coneccaoAPI.conectarApi(busca);

            // Transformar a resposta da API (o Json) em um Objeto Java
            TituloOMDB meuTituloOMDB = gson.fromJson(coneccaoAPI.getResponse().body(), TituloOMDB.class);
            //System.out.println(meuTituloOMDB);

            // Renomear os atributos do Objeto Java de forma mais Bonita
            Titulo meuTitulo = new Titulo(meuTituloOMDB);
            //System.out.println("Título já Covertido");
            System.out.println(meuTitulo);

            // Adicionando o Titulo na Lista de Titulos
            this.titulos.add(meuTitulo);

        }
        System.out.println("Salvando...");
        this.salvarArquivos.salvarArquivos(this.titulos, this.gson);
     }
}
