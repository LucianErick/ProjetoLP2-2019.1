package ECO.PropostasLegislativas;

/**
 * Classe responsavel por criar o objeto PL que se faz filha da super classe PropostaLegislativa. Se baseia nos atributos gerais da classe mae adicionados do atribut boolean Conclusivo e o int numeroPL que se inicia como sendo igual a 1
 */

public class PL extends PropostaLegislativa {
    /**
     * Atributo boolean para verificar se relaciona com uma proposta conclusiva ou nao
     */

    private boolean Conclusivo;
    /**
     * Atributo inteiro relacionado ao numero de PL iniciados sendo 1
     */

    private int numeroPL = 1;

    /**
     * Construtor da classe PL com parametros da classe mae e os atributos especificos da classe PL
     * @param DNIAutor dni do autor da proposta legislativa
     * @param ano ano em que a proposta legislativa foi criada
     * @param ementa os objetivos relacionados a proposta legislativa
     * @param interessesRelacionados interesses compostos a proposta legislativa
     * @param url endereco do documento relacionado
     * @param conclusivo boolean verificando referido a confirmacao da conclusao do proposta legislativa
     * @param codigo codigo relacionado a proposta legislativa
     */

    public PL(String DNIAutor, int ano, String ementa, String interessesRelacionados, String url, boolean conclusivo, String codigo) {
        super(DNIAutor, ano, ementa, interessesRelacionados, url, codigo);
        this.Conclusivo = conclusivo;
    }

    /**
     * Verifica se a proposta legistativa relacionada eh conclusiva ou nao
     * @return boolean com a confirmacao ou nao da conclusao
     */

    public String  isConclusivo() {
        if ( this.Conclusivo == true) {
            return " - Conclusiva";
        }
        return "";

    }

    /**
     * Representacao textual do objeto PL relacionado
     * @return representacao textual
     */

    @Override
    public String ToString() {
        return "Projeto de Lei - " + getCodigo() + " - " + getDNIAutor() + " - " + getEmenta() + isConclusivo() + " - " + getSituacaoAtual();
    }
}
