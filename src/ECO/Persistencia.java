package ECO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;


import ECO.Comissao.Comissao;
import ECO.Pessoa.Pessoa;
import ECO.PropostasLegislativas.ControllerPLS;
import ECO.PropostasLegislativas.PropostaLegislativa;
import ECO.Votacao.ControllerVotacao;


public class Persistencia {

    private Map<String, Pessoa> pessoas;
    private Map<String, Comissao> comissoes;
    private Map<String, PropostaLegislativa> propostasLegislativas;
    private Map<String, ControllerVotacao> votacoes;
    private File pessoasF;
    private File comissoesF;
    private File propostasLegislativasF;
    private File votacoesF;
    private FileOutputStream fos;
    private FileInputStream fis;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;


    public Persistencia() {
        this.pessoasF = new File("pessoas.txt");
        this.comissoesF = new File("comissoes.txt");
        this.propostasLegislativasF = new File("propostas.txt");
        this.votacoesF = new File("votacoes.txt");
    }

    public Map<String, Pessoa> getPessoas() {
        return pessoas;
    }

    public Map<String, Comissao> getComissoes() {
        return comissoes;
    }

    public Map<String, PropostaLegislativa> getPropostasLegislativas() {
        return propostasLegislativas;
    }

    public Map<String, ControllerVotacao> getVotacoes() {
        return votacoes;
    }
    public void salvar() {
        this.salvarPessoas();
        this.salvarComissoes();
        this.salvarPropostasLegislativas();
        this.salvarVotacao();
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
    private void salvarComissoes() {
        try {
            this.fos = new FileOutputStream(this.comissoesF);
            this.oos = new ObjectOutputStream(this.fos);
            oos.writeObject(this.comissoes);
        } catch (IOException ioe) {
            System.err.println("Erro no salvamento de comissão");
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

    private void salvarVotacao() {
        try {
            this.fos = new FileOutputStream(this.votacoesF);
            this.oos = new ObjectOutputStream(this.fos);
            oos.writeObject(this.votacoes);
        } catch (IOException ioe) {
            System.err.println("Erro no salvamento de votações");
        }
    }



    public void limpar() {
        File arquivo = new File("arquivoEspecifico.dat");
        arquivo.delete();
    }

    public void carregar() throws IOException {

        ObjectInputStream arqObjectos = null;
            try{
                if (! new File("arquivoEspecifico.dat").exists()) {
                    FileOutputStream fos = new FileOutputStream("arquivoEspecifico.dat");
                    fos.close();
                }
                FileInputStream arqObjectos1 = new FileInputStream("arquivoEspecifico.dat");
                if (arqObjectos1.available() > 0) {
                    arqObjectos = new ObjectInputStream(arqObjectos1);
                    arqObjectos.readObject();
                }
                } catch (ClassNotFoundException e) {
                e.printStackTrace();
                } catch (FileNotFoundException e) {
                e.printStackTrace();
                } catch (IOException e) {
                e.printStackTrace();
                } finally{
                if(arqObjectos != null)
                    arqObjectos.close();
        }
    }
}