package lp2;

import java.util.HashMap;
import static lp2.Validador.validadorString;


public class ControllerPartido {

    private HashMap<String, Partido> mapaPartido;


    public ControllerPartido(HashMap<String, Partido> mapaPartido) {

        this.mapaPartido = new HashMap<>();
    }

    public boolean cadastraPartido(String nomePartido) {

        validadorString(nomePartido, "Erro ao cadastrar partido: nome nao pode ser vazio ou nulo");


        if (mapaPartido.containsKey(nomePartido)) {
            throw new IllegalArgumentException("Erro ao cadastrar partido: nome ja cadastrado");

        } else if (!mapaPartido.containsKey(nomePartido)) {
            this.mapaPartido.put(nomePartido, new Partido(nomePartido));
            return true;
        }

        return false;
    }
}
