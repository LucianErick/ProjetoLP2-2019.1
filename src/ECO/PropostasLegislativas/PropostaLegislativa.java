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



    public abstract String ToString(); {

    }

    public String getDNIAutor() {
        return DNIAutor;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getEmenta() {
        return ementa;
    }

    public String getSituacaoAtual() {
        return situacaoAtual;
    }
}
