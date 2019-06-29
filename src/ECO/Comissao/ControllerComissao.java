package ECO.Comissao;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static ECO.Util.Validador.validadorString;

/**
 * Classe responsavel por controlar todas as acoes relacionadas ao objeto Comissao armazenando-os em uma colecao para melhor administracao
 */

public class ControllerComissao implements Serializable {
    /**
     * Atributo responsavel por armazenar os objetos Comissoes cadastrados;
     */

    private Map<String, Comissao> mapaComissoes;

    /**
     * Construtor da classe ControllerComissao que inicializar o mapaComissoes responsavel por armazenar os objetos cadastrados
     */

    public ControllerComissao() {
        this.mapaComissoes = new HashMap<>();
    }

    /**
     * Retorna o atributo da classe ControllerComissao com os objetos Comissao que foram cadastrados
     * @return o mapa com as comissoes ja cadastradas
     */

    public Map<String, Comissao> getMapaComissoes() {
        return mapaComissoes;
    }

    /**
     * Cadastra os objetos a partir dos parametros. Caso os parametros forem null ou vazio, uma excecao sera lancada. Se o tema ja estiver cadastrado, uma excecao tambem sera lancada
     * @param tema o tema responsavel como identificacao do objeto Comissao cadastrado
     * @param dniPoliticos String que carrega os dnis dos politicos participantes do objeto Comissao
     */

    public void cadastrarComissao(String tema, String dniPoliticos) {
        validadorString(tema, "Erro ao cadastrar comissao: tema nao pode ser vazio ou nulo");
        validadorString(dniPoliticos, "Erro ao cadastrar comissao: lista de politicos nao pode ser vazio ou nulo");
        this.mapaComissoes.put(tema, new Comissao(tema, dniPoliticos));
    }

    public void verificaComissao(String tema, String mensagem) {
        validadorString(tema, "Erro ao cadastrar comissao: tema nao pode ser vazio ou nulo");
        if (!this.mapaComissoes.containsKey(tema)) {
            throw new IllegalArgumentException(mensagem);
        }

    }

    public String getDniDeputados (String codigo) {
        return mapaComissoes.get(codigo).getDniDeputados();
    }

    public int getQuantidadeDeputados (String codigo) { return mapaComissoes.get(codigo).getDniDeputados().length();}

    /**
     * Metodo responsavel por inicializar o sistema chamando o metodo de ler os arquivos.
     */
    public void inicializaSistema() {
        this.lerArquivos();
    }

    /**
     * Metodo responsavel por finalizar o sistema chamando o metodo de escrever os arquivos.
     */
    public void finalizaSistema() {
        this.escreverArquivos();
    }

    private void escreverArquivos() {
        ObjectOutputStream comissaoArq = null;

        try {
            comissaoArq = new ObjectOutputStream(new FileOutputStream( "saves" + File.separator + "comissaoController.dat"));
            comissaoArq.writeObject(this.mapaComissoes);

        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void lerArquivos() {
        ObjectInputStream comissaoArq = null;

        try {
            comissaoArq = new ObjectInputStream(new FileInputStream("saves" + File.separator + "comissaoController.dat"));
            Map<String, Comissao> comissaoHashMap = (HashMap<String, Comissao>) comissaoArq.readObject();
            this.mapaComissoes = comissaoHashMap;

        } catch (IOException e) {
            this.escreverArquivos();
            this.inicializaSistema();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public void limpar() {

        this.mapaComissoes = new HashMap<>();
    }
}
