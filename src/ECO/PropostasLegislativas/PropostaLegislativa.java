package ECO.PropostasLegislativas;

public abstract class PropostaLegislativa {

    private String DNIAutor;

    private int ano;

    private String codigo;

    private String ementa;

    private String interessesRelacionados;

    private String situacaoAtual;

    private String url;

    public PropostaLegislativa(String DNIAutor, int ano, String ementa, String interessesRelacionados, String url, String codigo) {
        this.DNIAutor = DNIAutor;
        this.interessesRelacionados = interessesRelacionados;
        this.ano = ano;
        this.ementa = ementa;
        this.url = url;
        this.codigo = codigo;
        this.situacaoAtual = "EM VOTACAO (CCJC)";
    }

    public String ExibeProjeto(String codigo) {
        String saida = "";
        return saida;
    }

    public int getAno() {
        return ano;
    }



    public abstract String ToString();

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