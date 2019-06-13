package ECO.PropostasLegislativas;

public class PL extends PropostaLegislativa {

    private boolean Conclusivo;

    private int numeroPL = 1;

    public PL(String DNIAutor, int ano, String ementa, String interessesRelacionados, String url, boolean conclusivo, String codigo) {
        super(DNIAutor, ano, ementa, interessesRelacionados, url, codigo);
        this.Conclusivo = conclusivo;
    }

    public boolean isConclusivo() {
        return Conclusivo;
    }


    @Override
    public String ToString() {
        return "Projeto de Lei - " + getCodigo() + " - " + getDNIAutor() + " - " + getEmenta() + " - " + isConclusivo() + " - " + getSituacaoAtual();
    }
}
