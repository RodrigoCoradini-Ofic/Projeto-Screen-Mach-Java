// Importando Bibliotecas
package br.com.alura.ScreenMatch.principal;
import br.com.alura.ScreenMatch.buscas.BuscarRespostaUsuario;
import java.io.IOException;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {

        // Iniciando a Busca
        BuscarRespostaUsuario buscarRespostaUsuario = new BuscarRespostaUsuario();
        buscarRespostaUsuario.pegarRespostaUsuario();
    }
}
