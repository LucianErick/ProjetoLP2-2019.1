package ECO.PropostasLegislativas;

/**
 * Super Classe responsavel por padronizar os distintos objetos relacionados a proposta legislativa com os atributos e metodos em comum as classes filhas
 */

public abstract class PropostaLegislativa {
    /**
     * Atributo String que armazena o dni do autor da proposta legislativa
     */

    private String DNIAutor;
    /**
     * Atributo int que armazena o ano que a proposta legislativa foi lancada
     */

    private int ano;
    /**
     * Atributo String com o codigo da proposta legislativa
     */

    private String codigo;
    /**
     * Atributo String com a ementa da proposta legislativa
     */

    private String ementa;
    /**
     * Atributo String com os interesses relacionados a proposta legislativa
     */

    private String interessesRelacionados;
    /**
     * Atributo String que armazena a situacao atual da proposta legislativa
     */

    private String situacaoAtual;
    /**
     * Atributo String que armazena o endereco do documento
     */

    private String url;

    /**
     * Construtor da classe Proposta Legislativa atraves dos atributos da propria classe.
     * @param DNIAutor
     * @param ano
     * @param ementa
     * @param interessesRelacionados
     * @param url
     * @param codigo
     */

    public PropostaLegislativa(String DNIAutor, int ano, String ementa, String interessesRelacionados, String url, String codigo) {
        this.DNIAutor = DNIAutor;
        this.interessesRelacionados = interessesRelacionados;
        this.ano = ano;
        this.ementa = ementa;
        this.url = url;
        this.codigo = codigo;
        this.situacaoAtual = "EM VOTACAO (CCJC)";
    }

    /**
     * Exibe o projeto responsavel pela proposta legislativa
     * @param codigo
     * @return String com o projeto da proposta legislativa
     */

    public String ExibeProjeto(String codigo) {
        String saida = "";
        return saida;
    }

    /**
     * Retorna o ano que a proposta legislativa foi inicializada
     * @return ano de inicio
     */

    public int getAno() {
        return ano;
    }

    /**
     * Representacao textual da classe PropostaLegislativa
     * @return String com a representacao textual
     */

    public abstract String ToString(); {

    }

    /**
     * Retorna a String com o dni do autor da proposta legislativa
     * @return o dni do autor
     */

    public String getDNIAutor() {
        return DNIAutor;
    }

    /**
     * Retorna a String com o codigo da proposta legislativa
     * @return codigo
     */

    public String getCodigo() {
        return this.codigo;
    }

    /**
     * Retorna a String com o ementa da proposta legislativa
     * @return ementa
     */

    public String getEmenta() {
        return ementa;
    }

    /**
     * Retorna a String com a situacao atual da proposta legislativa
     * @return situacao atual
     */

    public String getSituacaoAtual() {
        return situacaoAtual;
    }


    //    criado para a votacao, nao sei se vai continuar
    public abstract boolean verificaBooleanConclusivo(String codigo);

    public void setSituacaoAtual(String situacaoAtual) {
        this.situacaoAtual = situacaoAtual;
    }

    public String getInteressesRelacionados() {
        return interessesRelacionados;
    }
}
