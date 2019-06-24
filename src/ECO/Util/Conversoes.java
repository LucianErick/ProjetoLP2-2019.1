package ECO.Util;

import ECO.Votacao.Orientacao;

import static ECO.Votacao.Orientacao.GOVERNISTA;

public class Conversoes {

    public static String converteData(String dataDeInicio) {
        String aux = "";
        char[] array = dataDeInicio.toCharArray();
        for(int i=0; i<array.length; i++) {
            if(i == 1 || i == 3) {
                aux += array[i] + "/";
            }else {
                aux += array[i];
            }
        }
        dataDeInicio=aux;
        return dataDeInicio;
    }

    public static Orientacao  converteStatusGovernistaEmEnum (String statusGovernista) {
        if (statusGovernista.equals("GOVERNISTA")) {
            return GOVERNISTA;
        }
        if (statusGovernista.equals("OPOSICAO")) {
            return Orientacao.OPOSICAO;
        }
        if (statusGovernista.equals("LIVRE")) {
            return Orientacao.LIVRE;
        }
        throw new IllegalArgumentException("erro, errou rude");
    }
}
