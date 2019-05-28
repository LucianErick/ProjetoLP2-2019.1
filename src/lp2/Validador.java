package lp2;

public class Validador {

    public static void validador(String parametro, String mensagem) {
        if (parametro == null || "".equals(parametro.trim())) {
            throw new IllegalArgumentException(mensagem);
        }
    }
}
