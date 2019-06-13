package ECO.PropostasLegislativas;

import java.util.HashMap;

public class ControllerPLS {

    private int numeroPL = 1;
    private int numeroPLP = 1;
    private int numeroPEC = 1;

    public HashMap<String, PropostaLegislativa> propostasDeLeis;

    public String cadastrarPL(String dni, int ano, String ementa, String interesses, String url, boolean conclusivo){
        String codigo = "PL "+ this.numeroPL+ "/" + ano;
        propostasDeLeis.put(codigo,new PL(dni,ano,ementa,interesses,url,conclusivo, codigo));
        this.numeroPL ++;
        return codigo;
    }

    public String cadastrarPLP(String dni, int ano, String ementa, String interesses, String url, String artigos){
        String codigo = "PLP "+ this.numeroPLP+ "/" + ano;
        propostasDeLeis.put(codigo,new PLP(dni,ano,ementa,interesses,url,artigos, codigo));
        this.numeroPLP ++;
        return codigo;

    }

    public String cadastrarPEC(String dni, int ano, String ementa, String interesses, String url, String artigos){
        String codigo = "PLP "+ this.numeroPEC+ "/" + ano;
        propostasDeLeis.put(codigo,new PEC(dni,ano,ementa,interesses,url,artigos, codigo));
        this.numeroPEC ++;
        return codigo;
    }

    public String exibirProjeto(String codigo){
        return "a";
    }
}
