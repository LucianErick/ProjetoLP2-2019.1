package lp2;

import java.util.HashMap;
import static lp2.Validador.validadorString;

/**
 * Classe ControllerPartido que serve para armazenar e ordenar os objetos do tipo Partido.
 */

public class ControllerPartido {
    /**
     * Atributo relacionado a um mapa que armazenara os objetos do tipo Partido que serao cadastrados.
     */
    private HashMap<String, Partido> mapaPartido;

    /**
     * Construtor da classe Partido que inicializa o mapaPartido referente ao objeto da classe ControllerPartido.
     * @param mapaPartido
     */
    public ControllerPartido(HashMap<String, Partido> mapaPartido) {

        this.mapaPartido = new HashMap<>();
    }

    /**
     * Cadastra o objeto Partido no mapaPartidos. Caso ja tenha um objeto Partido com um mesmo nome ja cadastrado, lanca-se uma excecao.
     * @param nomePartido nome do objeto Partido.
     * @return boolean relacionado cadastro ou nao do objeto Partido no mapaPartido
     */

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
