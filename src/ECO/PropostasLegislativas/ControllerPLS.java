package ECO.PropostasLegislativas;

import ECO.Comissao.Comissao;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static ECO.Util.Validador.*;

public class ControllerPLS implements Serializable {

    private int numeroPL = 1;
    private int numeroPLP = 1;
    private int numeroPEC = 1;
    private static final long serialVersionUID = 1L;

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
        return  propostasDeLeis.get(codigo).toString();
    }

     public boolean verificaBooleanConclusivo(String codigo) {
        return this.propostasDeLeis.get(codigo).verificaBooleanConclusivo();
    }

    public HashMap<String, PropostaLegislativa> getPropostasDeLeis() {
        return propostasDeLeis;
    }


    public String  getInteressesRelacionados(String codigo) {
        return propostasDeLeis.get(codigo).getInteressesRelacionados();
    }

    public void alteraSituacaoAtual (String codigo, String alteracao) {
        propostasDeLeis.get(codigo).setSituacaoAtual(alteracao);
    }

    public void quorumMininimo (String codigo, int deputadosPresentes, int totalDeDeputados) {
        propostasDeLeis.get(codigo).quorumMininimo(deputadosPresentes, totalDeDeputados);
    }

    public String exibirTramitacao(String codigo) {
        return propostasDeLeis.get(codigo).exibirTramitacao(codigo);
    }


    public void escreverArquivos(Map<String, PropostaLegislativa> map, String arquivo){

        FileOutputStream arquivoPLS;

        try {
            arquivoPLS = new FileOutputStream(arquivo);
            ObjectOutputStream gravarPLS = new ObjectOutputStream(arquivoPLS);
            gravarPLS.writeObject(map);
            gravarPLS.flush();
            gravarPLS.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Map<String, PropostaLegislativa> lerArquivos (String arquivo){
        File arquivoPLS = null;
        arquivoPLS = new File(arquivo);
        Map<String, PropostaLegislativa> map = new HashMap<>();
        FileInputStream fis;

        try {
            if (!arquivoPLS.exists()) {
                arquivoPLS.createNewFile();
            }
            else if (arquivoPLS.length() == 0) {
                System.out.println("ARQUIVO VAZIO");

            }else{
                fis = new FileInputStream(arquivo);
                ObjectInputStream ois = new ObjectInputStream(fis);
                map = (Map<String, PropostaLegislativa>) ois.readObject();
                ois.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;


    }
    public void limpar() {
        this.propostasDeLeis = new HashMap<>();
    }
}
