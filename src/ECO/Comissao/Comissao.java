package ECO.Comissao;

import java.util.*;

/**
 * Classe responsavel por criar o objeto Comissao a partir de um tema e uma String composta pelos dnis responsaveis pela identificacao dos deputadps participantes da comissao.
 */

public class Comissao {
    /**
     * Atributo tema responsavel por carregar o tema do objeto Comissao
     */
    private String tema;
    /**
     * Atributo dniDeputados responsavel por carregar uma String com os dnis dos deputados participantes do objeto Comissao criado;
     */
    private String dniDeputados;
    /**
     * Atributo listaDNI no qual converte o atributo dniDeputados para um Set.
     */
    private Set<String> listaDNI;

    /**
     * Construtor do objeto Comissao a partir do tema e da String de dnis recebidas como parametro;
     * @param tema tema do objeto Comissao criado;
     * @param dniDeputados String com os dnis dos deputados participantes do objeto Comissao
     */

    public Comissao(String tema, String dniDeputados) {
        this.tema = tema;
        this.listaDNI = new HashSet<>();
        String[] listaDeputados = dniDeputados.split(",");
        for(String dni : listaDeputados) {
            this.listaDNI.add(dni);
        }
    }

    /**
     * Metodo para retornar o tema do objeto Comissao relacionado
     * @return o atributo tema do objeto Comissao relacionado
     */

    public String getTema() {
        return tema;
    }

    /**
     * String com os dnis dos deputados participantes do objeto Comissao relacionado
     * @return String com os dnis dos deputados do objeto Comissao relacionado
     */

    public String getDniDeputados() {
        return dniDeputados;
    }

    public Set<String> getListaDNI() {
        return listaDNI;
    }

    /**
     * Compara dois objetos Comissao distintos se sao iguais ou nao. Caso forem, retorna True. O oposto, retorna False.
     * @param o objeto Comissao a ser comparado
     * @return um boolean relacionado a igualdade ou nao dos objetos
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comissao)) return false;
        Comissao comissao = (Comissao) o;
        return Objects.equals(getTema(), comissao.getTema());
    }

    /**
     * Endereco de memoria do objeto Comissao relacionado
     * @return o endereco de memoria do objeto Comissao relacionado
     */

    @Override
    public int hashCode() {
        return Objects.hash(getTema());
    }

}
