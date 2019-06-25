package ECO;

import ECO.Comissao.Comissao;
import ECO.Pessoa.Deputado;
import ECO.Pessoa.Pessoa;
import ECO.PropostasLegislativas.PropostaLegislativa;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Dados {

    private Map<String, Pessoa> pessoas;
    private Map<String, Deputado> deputados;
    private Map<String, Comissao> comissoes;
    private Map<String, PropostaLegislativa> propostasLegislativas;
    private File pessoasF;
    private File deputadosF;
    private File comissoesF;
    private File propostasLegislativasF;
    private FileOutputStream fos;
    private FileInputStream fis;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public Dados() {
        this.pessoasF = new File("pessoas.txt");
        this.deputadosF = new File("deputados.txt");
        this.comissoesF = new File("comissoes.txt");
        this.propostasLegislativasF = new File("propostas.txt");
        this.limpar();
    }

    public void limpar() {
        this.pessoas = new HashMap<String, Pessoa>();
        this.deputados = new HashMap<String, Deputado>();
        this.comissoes = new HashMap<String, Comissao>();
        this.propostasLegislativas = new HashMap<String, PropostaLegislativa>();

    }
    public void salvar() {
        this.salvarPessoas();
        this.salvarDeputados();
        this.salvarComissoes();
        this.salvarPropostasLegislativas();
    }
    private void salvarPessoas() {
        try {
            this.fos = new FileOutputStream(this.pessoasF);
            this.oos = new ObjectOutputStream(this.fos);
            oos.writeObject(this.pessoas);

        } catch (IOException ioe) {
            System.err.println("Erro no salvamento de pessoas");
        }
    }
    private void salvarDeputados() {
        try {
            this.fos = new FileOutputStream(this.deputadosF);
            this.oos = new ObjectOutputStream(this.fos);
            oos.writeObject(this.deputados);

        } catch (IOException ioe) {
            System.err.println("Erro no salvamento de deputados");
        }
    }
    private void salvarComissoes() {
        try {
            this.fos = new FileOutputStream(this.comissoesF);
            this.oos = new ObjectOutputStream(this.fos);
            oos.writeObject(this.comissoes);

        } catch (IOException ioe) {
            System.err.println("Erro no salvamento de comissões");
        }
    }
    private void salvarPropostasLegislativas() {
        try {
            this.fos = new FileOutputStream(this.propostasLegislativasF);
            this.oos = new ObjectOutputStream(this.fos);
            oos.writeObject(this.propostasLegislativas);

        } catch (IOException ioe) {
            System.err.println("Erro no salvamento de propostas legislativas");
        }
    }

    public Map<String, Pessoa> getPessoas() {
        return pessoas;
    }

    public Map<String, Deputado> getDeputados() {
        return deputados;
    }

    public Map<String, Comissao> getComissoes() {
        return comissoes;
    }

    public Map<String, PropostaLegislativa> getPropostasLegislativas() {
        return propostasLegislativas;
    }
}

