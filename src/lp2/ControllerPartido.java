package lp2;

import java.util.*;

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
     */
    public ControllerPartido() {

        this.mapaPartido = new HashMap<>();
    }

    /**
     * Cadastra o objeto Partido no mapaPartidos. Caso ja tenha um objeto Partido com um mesmo nome ja cadastrado, lanca-se uma excecao.
     * @param nomePartido nome do objeto Partido.
     * @return boolean relacionado cadastro ou nao do objeto Partido no mapaPartido
     */

    public void cadastraPartido(String nomePartido) {

        validadorString(nomePartido, "Erro ao cadastrar partido: partido nao pode ser vazio ou nulo");
        if (mapaPartido.containsKey(nomePartido)) {
            throw new IllegalArgumentException("Erro ao cadastrar partido: nome ja cadastrado");

        } else if (!mapaPartido.containsKey(nomePartido)) {
            this.mapaPartido.put(nomePartido, new Partido(nomePartido));
        }
    }

    /**
     * Exibe os partidos cadastrados, em ordem alfabetica(lexicografica), no mapa de partidos.
     * @return uma string contendo os nomes dos partidos separados por virgula "partido1,partido2...".
     */
    public String exibirBase() {
        String saida = "";
        List<Partido> partidosList = new ArrayList<>(this.mapaPartido.values());
        Collections.sort(partidosList);

        for (Partido partido : partidosList) {
            saida += String.format("%s,", partido.toString());
        }
        if(saida.length() > 0) {
            saida = saida.substring(0,saida.length() - 1);
        }
        return saida;
    }
}
