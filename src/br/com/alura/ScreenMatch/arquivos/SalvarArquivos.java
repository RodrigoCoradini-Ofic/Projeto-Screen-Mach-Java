// Importando Bibliotecas
package br.com.alura.ScreenMatch.arquivos;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import br.com.alura.ScreenMatch.modelos.Titulo;
import com.google.gson.Gson;

public class SalvarArquivos {
    protected FileWriter arquivo;

    // Metodo para salvar a lista de arquivos
    public void salvarArquivos(ArrayList<Titulo> titulos, Gson gson) throws IOException {
        if (titulos.isEmpty()) {
            this.arquivo = new FileWriter("filmes.json");
            this.arquivo.write("\nArquivo Vazio");
            this.arquivo.close();
        } else {
            this.arquivo = new FileWriter("filmes.json");
            arquivo.write(gson.toJson(titulos));
            arquivo.close();

        }
    }
}
