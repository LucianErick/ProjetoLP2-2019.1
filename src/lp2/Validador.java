package lp2;

public class Validador {

    public static void validadorAtributo(String parametro, String mensagem) {
        if (parametro == null || "".equals(parametro.trim())) {
            throw new IllegalArgumentException(mensagem);
        }
    }

    public static void validadorDni(String dni, String mensagem) {
        for (int i = 0; i < dni.length(); i++) {
            char caractere = dni.charAt(i);
            if (!(Character.isDigit(caractere) || "-".equals(caractere))) {
                throw new IllegalArgumentException(mensagem);
            }
        }
    }
}
