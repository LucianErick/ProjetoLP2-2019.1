package ECO.Pessoa;

import java.util.*;

import static ECO.Util.Validador.*;

/**
 * Classe ControllerPessoa que serve para armazenar os objetos Pessoa e objetos Deputado.
 */

public class ControllerPessoa {
    /**
     * Atributo que refere-se ao mapa para armazenar objetos Pessoa.
     */
    private Map<String ,Pessoa> pessoas;
    private List<String> partidos;
    private int deputados = 0;

    /**
     * Construtor da classe ControllerPessoa inicializa o mapa de pessoas cadastradas.
     */

    public ControllerPessoa() {
        this.pessoas = new HashMap<>();
        this.partidos = new ArrayList<>();
    }

    public Map<String, Pessoa> getPessoas() {
        return pessoas;
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

        pessoas.get(dni).cadastraDeputado(dataDeInicio);
        deputados += 1;
    }

    /**
     * Verifica se o objeto Deputado atraves do seu dni existe no mapa de pessoas. Caso não, lanca-se uma excecao. Verifica tambem se o objeto cadastrado no mapa pessoas tem a funcao de deputado tambem
     * @param dni codigo de identificacao do objeto Pessoa.
     */

    public void verificaDeputado(String dni) {
        if (!pessoas.containsKey(dni)){
            throw new IllegalArgumentException("Erro ao cadastrar projeto: pessoa inexistente");
        }
        if (pessoas.get(dni).getFuncao() == null){
            throw new IllegalArgumentException("Erro ao cadastrar projeto: pessoa nao eh deputado");
        }
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
        return pessoas.get(dni).toString();
    }

    /**
     * Cadastra a String partido na lista partidos
     * @param partido String recebida como parametro responsavel por representar o partido relacionado
     */

    public void cadastrarPartido(String partido) {
        validadorString(partido, "Erro ao cadastrar partido: partido nao pode ser vazio ou nulo");
        this.partidos.add(partido);
    }

    /**
     * Exibe os partidos ja cadastrados em ordem alfabetica e sem repeticao
     * @return uma String com todos os partidos ja cadastrados ja ordenados
     */

    public String exibirBase() {
        String saida = "";
        Collections.sort(this.partidos);
        for (String partido : this.partidos) {
            saida += partido + ",";
        }
        if(saida.length() != 0) {
            saida = saida.substring(0,saida.length() - 1);
        }
        return saida;
    }
    
    public Map<String ,Pessoa> getControllerPessoa() {
        return this.pessoas;
    }

    public String getPartidos (String dni) {
        return pessoas.get(dni).getPartido();
    }

    public String getInteresses (String dni) {
        return pessoas.get(dni).getInteresses();
    }

    public boolean verificaPartidos (String partidos) {
        if ( this.partidos.contains(partidos)) {
            return true;
        }
        return false;
    }

    public void adicionaLeia (String dni) {
        pessoas.get(dni).getFuncao().adicionaLei();
    }

    public int qtdDeputados () {
        return this.deputados;
    }

}

