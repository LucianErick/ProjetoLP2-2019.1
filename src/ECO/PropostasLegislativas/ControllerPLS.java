package ECO.PropostasLegislativas;

import ECO.Util.Validador;

import java.util.HashMap;

import static ECO.Util.Validador.*;

public class ControllerPLS {

    private int numeroPL = 1;
    private int numeroPLP = 1;
    private int numeroPEC = 1;

    private HashMap<String, PropostaLegislativa> propostasDeLeis;

    public ControllerPLS() {
        this.propostasDeLeis = new HashMap<>();
    }

    public String cadastrarPL(String dni, int ano, String ementa, String interesses, String url, boolean conclusivo){
        validadorString(dni, "Erro ao cadastrar projeto: autor nao pode ser vazio ou nulo");
        validadorDni(dni, "Erro ao cadastrar projeto: dni invalido");
        validadorString(ementa, "Erro ao cadastrar projeto: ementa nao pode ser vazia ou nula");
        validadorString(interesses, "Erro ao cadastrar projeto: interesse nao pode ser vazio ou nulo");
        validadorString(url, "Erro ao cadastrar projeto: url nao pode ser vazio ou nulo");
        validadorAnoFuturo(ano, "Erro ao cadastrar projeto: ano posterior ao ano atual" );
        validadorAno(ano, "Erro ao cadastrar projeto: ano anterior a 1988");

        String codigo = "PL "+ this.numeroPL + "/" + ano;
        propostasDeLeis.put(codigo,new PL(dni,ano,ementa,interesses,url,conclusivo, codigo));
        this.numeroPL ++;
        return codigo;
    }

    public String cadastrarPLP(String dni, int ano, String ementa, String interesses, String url, String artigos){
        validadorString(dni, "Erro ao cadastrar projeto: autor nao pode ser vazio ou nulo");
        validadorDni(dni, "Erro ao cadastrar projeto: dni invalido");
        validadorString(ementa, "Erro ao cadastrar projeto: ementa nao pode ser vazia ou nula");
        validadorString(interesses, "Erro ao cadastrar projeto: interesse nao pode ser vazio ou nulo");
        validadorString(url, "Erro ao cadastrar projeto: url nao pode ser vazio ou nulo");
        validadorString(artigos, "Erro ao cadastrar projeto: artigo nao pode ser vazio ou nulo");
        validadorAnoFuturo(ano, "Erro ao cadastrar projeto: ano posterior ao ano atual" );
        validadorAno(ano, "Erro ao cadastrar projeto: ano anterior a 1988");

        String codigo = "PLP "+ this.numeroPLP + "/" + ano;
        propostasDeLeis.put(codigo,new PLP(dni,ano,ementa,interesses,url,artigos, codigo));
        this.numeroPLP ++;
        return codigo;

    }

    public String cadastrarPEC(String dni, int ano, String ementa, String interesses, String url, String artigos){
        validadorString(dni, "Erro ao cadastrar projeto: autor nao pode ser vazio ou nulo");
        validadorDni(dni, "Erro ao cadastrar projeto: dni invalido");
        validadorString(ementa, "Erro ao cadastrar projeto: ementa nao pode ser vazia ou nula");
        validadorString(interesses, "Erro ao cadastrar projeto: interesse nao pode ser vazio ou nulo");
        validadorString(url, "Erro ao cadastrar projeto: url nao pode ser vazio ou nulo");
        validadorString(artigos, "Erro ao cadastrar projeto: artigo nao pode ser vazio ou nulo");
        validadorAnoFuturo(ano, "Erro ao cadastrar projeto: ano posterior ao ano atual" );
        validadorAno(ano, "Erro ao cadastrar projeto: ano anterior a 1988");

        String codigo = "PEC "+ this.numeroPEC + "/" + ano;
        propostasDeLeis.put(codigo,new PEC(dni,ano,ementa,interesses,url,artigos, codigo));
        this.numeroPEC ++;
        return codigo;
    }

    /**
     * Exibe o projeto que se refere a String codigo passada como parametro
     * @param codigo meio de identificacao do projeto
     * @return o toString do projeto relacionado
     */
    public String exibirProjeto(String codigo){
        return  propostasDeLeis.get(codigo).ToString();
    }

    public boolean verificaBooleanConclusivo(String codigo) {
        return this.propostasDeLeis.get(codigo).verificaBooleanConclusivo(codigo);
    }

    //    criado para a votacao, nao sei se vai continuar
    public void verificaExistenciaProposta (String codigo) {
        if (propostasDeLeis.containsValue(codigo)) {
            throw new IllegalArgumentException("");
        }
    }
}
