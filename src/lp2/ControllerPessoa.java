package lp2;

import java.util.HashMap;
import java.util.Map;
import static lp2.Validador.*;

/**
 * Classe ControllerPessoa que serve para armazenar os objetos Pessoa e objetos Deputado.
 */

public class ControllerPessoa {
    /**
     * Atributo que refere-se ao mapa para armazenar objetos Pessoa.
     */
    private Map<String ,Pessoa> pessoas;

    /**
     * Atributo que refere-se ao mapa para armazenar objetos Deputado.
     */
    private Map<String, Deputado> deputados;

    /**
     * Construtor da classe ControllerPessoa inicializa o mapa de pessoas cadastradas.
     */

    public ControllerPessoa() {
        this.pessoas = new HashMap<>();
        this.deputados = new HashMap<>();
    }

    /**
     * Cadastra pessoas de acordo com os metodos da classe, menos o partido. Caso os parametros sejam invalidos, lanca-se uma excecao.
     * @param nome nome do objeto a ser cadastrado
     * @param dni codigo de identificacao do objeto a ser cadastrado.
     * @param estadoOrigem estado de origem do objeto a ser cadastrado.
     * @param interesses interesses do objeto a ser cadastrado
     */

    public void cadastraPessoa(String nome, String dni, String estadoOrigem, String interesses) {
        validadorString(nome, "Erro ao cadastrar pessoa: nome nao pode ser vazio ou nulo");
        validadorString(dni, "Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo");
        validadorString(estadoOrigem, "Erro ao cadastrar pessoa: estado nao pode ser vazio ou nulo");
        validadorDni(dni, "Erro ao cadastrar pessoa: dni invalido");
        if (pessoas.containsKey(dni)) {
            throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni ja cadastrado");
        } else if (!pessoas.containsKey(dni)) {
            this.pessoas.put(dni, new Pessoa(nome, dni, estadoOrigem, interesses));
        }
    }
    /**
     * Cadastra pessoas de acordo com os metodos da classe, incluindo o partido. Caso os parametros sejam invalidos, lanca-se uma excecao.
     * @param nome nome do objeto a ser cadastrado
     * @param dni codigo de identificacao do objeto a ser cadastrado.
     * @param estadoOrigem estado de origem do objeto a ser cadastrado.
     * @param interesses interesses do objeto a ser cadastrado
     * @param partido partido do objeto a ser cadastrado
     */


    public void cadastraPessoa(String nome, String dni, String estadoOrigem, String interesses, String partido) {
        validadorString(nome, "Erro ao cadastrar pessoa: nome nao pode ser vazio ou nulo");
        validadorString(dni, "Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo");
        validadorString(estadoOrigem, "Erro ao cadastrar pessoa: estado nao pode ser vazio ou nulo");
        validadorDni(dni, "Erro ao cadastrar pessoa: dni invalido");
        if(pessoas.containsKey(dni)) {
            throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni ja cadastrado");
        }
        else if (!pessoas.containsKey(dni)) {
            this.pessoas.put(dni, new Pessoa(nome, dni, estadoOrigem, interesses, partido));
        }
    }

    /**
     * Cadastra objeto Deputado a partir do dni e a data de inicio de atuacao. Caso tenha parametro invalido, lanca-se uma excecao.
     * @param dni codigo de identificacao.
     * @param dataDeInicio data de inicio de atuacao politica
     */

    public void cadastraDeputado (String dni, String dataDeInicio) {
        validadorString(dni, "Erro ao cadastrar deputado: dni nao pode ser vazio ou nulo");
        validadorDni(dni, "Erro ao cadastrar deputado: dni invalido");
        if (!pessoas.containsKey(dni)) {
            throw new IllegalArgumentException("Erro ao cadastrar deputado: pessoa nao encontrada");
        }
        validadorString(dataDeInicio, "Erro ao cadastrar deputado: data nao pode ser vazio ou nulo");
        validadorData(dataDeInicio, "Erro ao cadastrar deputado: data invalida");
        validadorDataFutura(dataDeInicio, "Erro ao cadastrar deputado: data futura");

        if (pessoas.get(dni).getPartido() == null || pessoas.get(dni).getPartido().trim().equals("")) {
            throw new IllegalArgumentException("Erro ao cadastrar deputado: pessoa sem partido");
        }

        this.deputados.put(dni, new Deputado(dni, dataDeInicio));
        pessoas.get(dni).cadastraDeputado(dataDeInicio);
    }

    /**
     * Exibe uma pessoa cadastrada no sistema a partir do DNI. Caso o parametro seja invalido, uma exececao eh lancada.
     * @param dni codigo de identificacao.
     * @return a pessoa cadastrada em um formato para Pessoas Politicas e outra para Nao Politicas.
     */

    public String exibirPessoa(String dni) {
        validadorString(dni, "Erro ao exibir pessoa: dni nao pode ser vazio ou nulo");
        validadorDni(dni, "Erro ao exibir pessoa: dni invalido");
        if(!pessoas.containsKey(dni)) {
            throw new IllegalArgumentException("Erro ao exibir pessoa: pessoa nao encontrada");
        }
        if(deputados == null) {
            return pessoas.get(dni).toString();
        }
        if(!deputados.containsKey(dni)) {
            return pessoas.get(dni).toString();
        } else {
            return "POL: " + pessoas.get(dni).toString() + " - " + deputados.get(dni).toString();
        }
    }
}

