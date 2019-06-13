package ECO.PropostasLegislativas;

public class PEC extends PropostaLegislativa {


    private String artigo;


    public PEC(String DNIAutor, int ano, String ementa, String interessesRelacionados, String url, String artigo, String codigo) {
        super(DNIAutor, ano, ementa, interessesRelacionados, url, codigo);
        this.artigo = artigo;

    }

    public String getArtigo() {
        return artigo;
    }

    @Override
    public String ToString() {
        return "Projeto de Emenda Constitucional - " + getCodigo() + " - " + getDNIAutor() + " - " + getEmenta() + " - " + getArtigo() + " - " + getSituacaoAtual();
    }
}
