package ECO.PropostasLegislativas;

/**
 * Classe responsavel por criar o objeto PLP que se faz filha da super classe PropostaLegislativa. Se baseia nos atributos gerais da super classe adicionando o atributo artigo especifico da classe PLP.
 */

public class PLP extends PropostaLegislativa {
    /**
     * Atributo que armazena a String artigo especifico da classe PLP
     */

    private String artigo;
    /**
     * Construtor da classe a partir dos atributos gerais da classe mae com o atributo artigo especifico da classe PEC.
     * @param DNIAutor dni do autor da proposta legislativa relacionada
     * @param ano ano em que a proposta legistaliva foi inicializada
     * @param ementa objetivos da proposta legislativa
     * @param interessesRelacionados interesses relacionados a proposta legislativa
     * @param url forma padronizada de representacao do documento relacionado a proposta legislativa
     * @param artigo artigo especifico da classe PEC
     * @param codigo codigo da proposta legislativa
     */

    public PLP(String DNIAutor, int ano, String ementa, String interessesRelacionados, String url, String artigo, String codigo) {
        super(DNIAutor, ano, ementa, interessesRelacionados, url, codigo);
        this.artigo = artigo;
    }

    /**
     * Retorna o artigo do objeto da classe PLP relacionado
     * @return String com o artigo da proposta legislativa
     */

    public String getArtigo() {
        return artigo;
    }

    /**
     * Representacao textual do objeto PLP relacionado
     * @return String com a representacao textual
     */

    @Override
    public String ToString() {
        return "Projeto de Lei Complementar - " + getCodigo() + " - " + getDNIAutor() + " - " + getEmenta() + " - " + getArtigo() + " - " + getSituacaoAtual();
    }
}
