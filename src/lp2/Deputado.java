package lp2;

import java.util.Date;

import static lp2.Validador.*;

/**
 * Classe Deputado que tem Funcao como interface.
 */
public class Deputado implements Funcao{
    /**
     * Atributo do tipo Date que refere a data de inicio do objeto relacionado
     */
    private Date dataDeInicio;
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

        this.quantidadeDeLeis = 0;
        formato = "POL: ";
    }

    /**
     * Retorna o formato do objeto Deputado.
     * @return o formato padronizado.
     */

    public String getFormato() {
        return formato;
    }

    /**
     * Representacao textual do objeto Deputado.
     * @return representacao textual.
     */

    @Override
    public String toString() {
        return "";
    }
}
