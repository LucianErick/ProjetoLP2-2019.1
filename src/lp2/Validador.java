package lp2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Validador {

    public static void validadorString(String parametro, String mensagem) {
        if (parametro == null || "".equals(parametro.trim())) {
            throw new IllegalArgumentException(mensagem);
        }
    }

    public static void validadorDni(String dni, String mensagem) {
        for (int i = 0; i < dni.length(); i++) {
            char caractere = dni.charAt(i);
            if (!(Character.isDigit(caractere) || '-' == caractere)) {
                throw new IllegalArgumentException(mensagem);
            }
        }
    }

    public static void validadorData (String data, String mensagem) {
        for (int i = 0; i < data.length(); i++) {
            char caractere = data.charAt(i);
            if (!(Character.isDigit(caractere))){
                throw new IllegalArgumentException(mensagem);
            }
        }
        try {
            DateFormat format = new SimpleDateFormat("ddMMyyyy");
            format.setLenient(false);
            format.parse(data);

        } catch (ParseException e){
            throw new IllegalArgumentException(mensagem);
        }
    }

    public static void validadorDataFutura (String data, String mensagem) {

        try {
            Date hoje = new Date();
            DateFormat format = new SimpleDateFormat("ddMMyyyy");
            Date date = format.parse(data);

            if (date.after(hoje)){
                throw new IllegalArgumentException(mensagem);
            }

        } catch (ParseException e){
            throw new IllegalArgumentException("Problemas nas conversao de datas.");
        }
    }
}