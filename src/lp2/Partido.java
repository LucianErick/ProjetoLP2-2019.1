package lp2;

import java.util.Objects;

/**
 * Classe Partido que refere-se a construcao de partidos governamentais.
 */
public class Partido {
    /**
     * Atributo que contem o nome do partido.
     */
    private String nomePartido;
    /**
     * Construtor da classe Partido a partir do nome.
     * @param nomePartido nome do partido a ser construido.
     */

    public Partido(String nomePartido) {
        this.nomePartido = nomePartido;
    }
    /**
     * Retorna o nome do objeto Partido.
     * @return nome do objeto Partido.
     */

    public String getNomePartido() {
        return nomePartido;
    }
    /**
     * Compara se dois objetos Partido possuem o mesmo nome.
     * @param o objeto Partido a ser comparado.
     * @return boolean confirmando ou nao, a igualdade.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Partido partido = (Partido) o;
        return nomePartido.equals(partido.nomePartido);
    }

    /**
     * Retorna o endereco de memoria do objeto Partido.
     * @return endereco de memoria.
     */

    @Override
    public int hashCode() {
        return Objects.hash(nomePartido);
    }
    /**
     * Representacao textual do objeto Partido.
     * @return String com a representacao do objeto relacionado.
     */

    @Override
    public String toString() {
        return String.format("%s", getNomePartido());
    }
}
