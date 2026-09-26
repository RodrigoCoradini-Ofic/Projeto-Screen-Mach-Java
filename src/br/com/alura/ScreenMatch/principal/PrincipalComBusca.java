package br.com.alura.ScreenMatch.principal;

import br.com.alura.ScreenMatch.modelos.Titulo;
import br.com.alura.ScreenMatch.modelos.TituloOMDB;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite um Filme para Busca: (Em MINÚSCULO)");
        var busca = leitura.nextLine();

//        String busca = "matrix";
        //String chave = System.getenv("OMDB_API_KEY"); "&apikey=b4c80ec4"
        String endereco = "https://www.omdbapi.com/?t=" + busca + "&apikey=b4c80ec4";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
        TituloOMDB meuTituloOMDB = gson.fromJson(response.body(), TituloOMDB.class);
        System.out.println(meuTituloOMDB);
        try{
            Titulo meuTitulo = new Titulo(meuTituloOMDB);
            System.out.println("Título já Covertido");
            System.out.println(meuTitulo);
        } catch(NumberFormatException e){
            System.out.println("Erro ao buscar titulo");
            System.out.println(e.getMessage());
        }

        System.out.println("Funcionou!!!!");
    }
}
