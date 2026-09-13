package br.com.alura.ScreenMatch.Calculos;

public class FiltroRecomendacao {

    public void filtra(Classificavel classificavel){
        if(classificavel.getClassificacao() >= 4){
            System.out.println("Está entre os Preferidos no momento!");
        } else if (classificavel.getClassificacao() >= 2){
            System.out.println("Está muito bem Avaliado no momento!");
        } else{
            System.out.println("Coloque para assistir mais tarde");
        }
    }
}
