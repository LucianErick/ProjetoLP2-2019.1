package lp2;

import java.util.Date;

import static lp2.Validador.*;


public class Deputado implements Funcao{

    private Date dataDeInicio;

    private int quantidadeDeLeis;

    private final String formato;

    public Deputado(String dni, String dataDeInicio){
        validadorString(dni, "");
        validadorString(dataDeInicio, "");
        this.quantidadeDeLeis = 0;
        formato = "POL: ";
    }

    public String getFormato() {
        return formato;
    }

    @Override
    public String toString() {
        return "";
    }
}
