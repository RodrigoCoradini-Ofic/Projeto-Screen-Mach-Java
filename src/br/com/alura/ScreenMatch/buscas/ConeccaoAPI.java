// Importando Bibliotecas
package br.com.alura.ScreenMatch.buscas;
import br.com.alura.ScreenMatch.excessoes.ErroDeConversaoDeAnoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class ConeccaoAPI {
    protected String keyApi;// = "&apikey=b4c80ec4";
    protected HttpResponse<String> response;
    // Constantes
    private static final String KEY_URL = "https://www.omdbapi.com/?t=";

    public ConeccaoAPI() throws IOException {
        // Buscando a Chave da API no arquivo config.properties
        Properties properties = new Properties();
        FileInputStream input = new FileInputStream("config.properties");
        properties.load(input);
        String apiKey = properties.getProperty("omdb.api.key");
        this.keyApi = apiKey;
        input.close();
    }

    // Metodo para Conectar API
    public void conectarApi(String busca) throws IOException, InterruptedException {
        try {
            String endereco = KEY_URL + busca + "&apikey=" + keyApi;

            // Cria um Cliente HTTP para conversar com Servidores
            HttpClient client = HttpClient.newHttpClient();
            // Cria uma Requisição HTTP para um determinado Servidor
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            // Envia a Requisição para o Servidor
            this.response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // Printa na Tela
            System.out.println(response.body());
        }  catch (NumberFormatException e){
            System.out.println("Erro ao buscar titulo");
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e){
            System.out.println("Argumento de Busca Inválido");
            System.out.println(e.getMessage());
        }catch (ErroDeConversaoDeAnoException e) {
            System.out.println(e.getMessage());
        }
    }

    public HttpResponse<String> getResponse() {
        return this.response;
    }
}
