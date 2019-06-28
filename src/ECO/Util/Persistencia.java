package ECO.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import ECO.Comissao.Comissao;
import ECO.Comissao.ControllerComissao;
import ECO.ControllerGeral;
import ECO.Pessoa.ControllerPessoa;
import ECO.Pessoa.Pessoa;
import ECO.PropostasLegislativas.ControllerPLS;
import ECO.PropostasLegislativas.PropostaLegislativa;
import ECO.Votacao.ControllerVotacao;


public class Persistencia {

    private Map<String, Pessoa> pessoas;
    private Map<String, Comissao> comissoes;
    private Map<String, PropostaLegislativa> propostasLegislativas;
    private List<String> partidos;
    private File pessoasF;
    private File comissoesF;
    private File propostasLegislativasF;
    private File votacoesF;
    private File partidosF;
    private FileOutputStream fos;
    private FileInputStream fis;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    /**
     * Inicializa os objetos File para armazenar e carregar os atributos de dados.
     * @param controladorGeral
     */

    public Persistencia(ControllerGeral controladorGeral) {
        this.pessoasF = new File("pessoas.dat");
        this.comissoesF = new File("comissoes.dat");
        this.propostasLegislativasF = new File("propostas.dat");
        this.partidosF = new File("partidos.dat");
        this.limpar();
    }


    public void salvar(ControllerComissao controleComissao, ControllerPessoa controlePessoas, ControllerPLS controllerPLS) {
        this.salvarPessoas();
        this.salvarComissoes();
        this.salvarPropostasLegislativas();
    }
    private void salvarPessoas(HashMap<String, Pessoa> pessoas) {
        try {
            this.fos = new FileOutputStream(this.pessoasF);
            this.oos = new ObjectOutputStream(this.fos);
            oos.writeObject(this.pessoas);
        } catch (IOException ioe) {
            System.err.println("Erro no salvamento de pessoas");
        }
    }
    private void salvarComissoes(Map<String, Comissao> comissoes) {
        try {
            this.fos = new FileOutputStream(this.comissoesF);
            this.oos = new ObjectOutputStream(this.fos);
            oos.writeObject(this.comissoes);
        } catch (IOException ioe) {
            System.err.println("Erro no salvamento de comissão");
        }
    }
    private void salvarPropostasLegislativas(HashMap<String, PropostaLegislativa> propostas) {
        try {
            this.fos = new FileOutputStream(this.propostasLegislativasF);
            this.oos = new ObjectOutputStream(this.fos);
            oos.writeObject(this.propostasLegislativas);
        } catch (IOException ioe) {
            System.err.println("Erro no salvamento de propostas legislativas");
        }
    }

    public void carregar(ControllerGeral controllerGeral) throws ClassNotFoundException, IOException {
        this.carregarPessoas();
        this.carregarComissoes();
        this.carregarPropostas();
        this.carregarPartidos();
    }

    public void limpar() {
        this.pessoas = new HashMap<String, Pessoa>();
        this.comissoes = new HashMap<String, Comissao>();
        this.propostasLegislativas = new HashMap<String, PropostaLegislativa>();
        this.partidos = new ArrayList<String>();
    }

    private Object carregarObjeto(File file) throws ClassNotFoundException, IOException {
        Object object;
        try {
            this.fis = new FileInputStream(file);
            this.ois = new ObjectInputStream(fis);
            object = ois.readObject();
        } catch (IOException ioe) {
            System.err.println("Erro na leitura do arquivo, " + file);
            throw new IOException();

        }
        return object;

    }

    @SuppressWarnings("unchecked")
    private void carregarPessoas() throws ClassNotFoundException, IOException {
        this.pessoas = (HashMap<String, Pessoa>) (this.carregarObjeto(pessoasF));
    }


    @SuppressWarnings("unchecked")
    private void carregarComissoes() throws ClassNotFoundException, IOException {
        this.comissoes = (HashMap<String, Comissao>) (this.carregarObjeto(comissoesF));
    }


    @SuppressWarnings("unchecked")
    private void carregarPropostas() throws ClassNotFoundException, IOException {
        this.propostasLegislativas = (HashMap<String, PropostaLegislativa>) (this.carregarObjeto(propostasLegislativasF));
    }


    @SuppressWarnings("unchecked")
    private void carregarPartidos() throws ClassNotFoundException, IOException {
        this.partidos = (ArrayList<String>) (this.carregarObjeto(partidosF));
    }


}