package ECO.Pessoa;

import static ECO.Util.Validador.*;

/**
 * Classe Deputado que tem Funcao como interface.
 */
public class Deputado implements Funcao {
    /**
     * Atributo do tipo Date que refere a data de inicio do objeto relacionado
     */
    private String dataDeInicio;
    /**
     * Atributo do tipo String que refere a quantidade de leis aprovadas pelo objeto Deputado.
     */
    private int quantidadeDeLeis;
    /**
     * Atributo que padroniza o formato do objeto Deputado.
     */
    private final String formato;

    /**
     * Construtor da classe Deputado  utilizando o dni e a data de inicio como essenciais para a caracterizacao do objeto Deputado.
     * @param dni codigo de identificacao do objeto.
     * @param dataDeInicio data de inicio na vida politica.
     */

    public Deputado(String dni, String dataDeInicio){
        validadorString(dni, "");
        validadorString(dataDeInicio, "");

        this.dataDeInicio = converteData(dataDeInicio);
        this.quantidadeDeLeis = 0;
        formato = "POL: ";
    }
    /**
     * Converte a data recebida para um padrão válido tradicional dd/mm/AAAA.
     * @param dataDeInicio String que contém a data que será padronizada.
     * @return a data em formato padronizado.
     */

    public String converteData(String dataDeInicio) {
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

    /**
     * Retorna a data de inicio de atuacao do objeto Deputado relacionado
     * @return a data de inicio do objeto Deputado relacionado
     */

    public String getDataDeInicio() {
        return dataDeInicio;
    }

    /**
     * Retorna a quantidade de leis cadastradas do objeto Deputado relacionado
     * @return
     */

    public int getQuantidadeDeLeis() {
        return quantidadeDeLeis;
    }

    /**
     * Retorna o formato do objeto Deputado.
     * @return o formato padronizado.
     */

    public String getFORMATO() {
        return formato;
    }

    /**
     * Representacao textual do objeto Deputado.
     * @return representacao textual.
     */

    @Override
    public String toString() {
        return getDataDeInicio() + " - " + getQuantidadeDeLeis()+ " Leis";
    }
}