
package ECO;

import easyaccept.EasyAccept;

import java.io.FileNotFoundException;
import java.io.IOException;


public class Facade {
    private ControllerGeral controladorGeral;
    private Persistencia persistencia;

    public Facade() {
     //   this.controladorGeral = new ControllerGeral();
     //   this.persistencia = new Persistencia(controladorGeral);
    }

    //US1
    public void cadastrarPessoa(String nome, String dni, String estadoOrigem, String interesses) {
        this.controladorGeral.cadastrarPessoa(nome, dni, estadoOrigem, interesses);
    }

    public void cadastrarPessoa(String nome, String dni, String estadoOrigem, String interesses, String partido) {
        this.controladorGeral.cadastrarPessoa(nome, dni, estadoOrigem, interesses, partido);
    }

    // US2

    public void cadastrarDeputado(String dni, String dataInicio) {
        this.controladorGeral.cadastrarDeputado(dni, dataInicio);
    }

    // US3

    public String exibirPessoa(String dni) {
        return this.controladorGeral.exibePessoa(dni);
    }

    // US4

    public void cadastrarPartido(String nomePartido) {
        this.controladorGeral.cadastrarPartido(nomePartido);
    }


    public String exibirBase() {
        return this.controladorGeral.exibeBase();
    }

    // US5

    public void cadastrarComissao(String tema, String dniPoliticos) {
        this.controladorGeral.cadastrarComissao(tema, dniPoliticos);
    }

    // US6

    public String cadastrarPL(String dni, int ano, String ementa, String interesses, String url, boolean conclusivo) {
        return this.controladorGeral.cadastrarPL(dni, ano, ementa, interesses, url, conclusivo);
    }

    public String cadastrarPLP(String dni, int ano, String ementa, String interesses, String url, String artigos) {
        return this.controladorGeral.cadastrarPLP(dni, ano, ementa, interesses, url, artigos);
    }

    public String cadastrarPEC(String dni, int ano, String ementa, String interesses, String url, String artigos) {
        return this.controladorGeral.cadastrarPEC(dni, ano, ementa, interesses, url, artigos);
    }

    public String exibirProjeto(String codigo) {
        return this.controladorGeral.exibirProjeto(codigo);
    }

    // US7

    public boolean votarComissao(String codigo, String statusGovernista, String proximoLocal) {
        return controladorGeral.votarComissao(codigo, statusGovernista, proximoLocal);
    }
    public boolean votarPlenario(String codigo, String statusGovernista, String presentes) {
        return controladorGeral.votarPlenario(codigo, statusGovernista, presentes);
    }

//    US8

    public String exibirTramitacao(String codigo) {
        return exibirTramitacao(codigo);
    }

    public void salvarSistema() throws IOException {
        this.persistencia.salvar();
    }
    public void carregarSistema() throws IOException {
        this.persistencia.carregar();
    }

    public void limparSistema(){
        this.persistencia.limpar();
        this.controladorGeral = new ControllerGeral();
    }

    public static void main(String[] args) {
        args = new String[] {
                "ECO.Facade",
                "acceptance_tests/use_case_1.txt", "acceptance_tests/use_case_2.txt",
                "acceptance_tests/use_case_3.txt", "acceptance_tests/use_case_4.txt",
                "acceptance_tests/use_case_5.txt", "acceptance_tests/use_case_6.txt",
                "acceptance_tests/use_case_7.txt",
//                    "acceptance_tests/use_case_8.txt",
//                    "acceptance_tests/use_case_9.txt",
                };

        EasyAccept.main(args);
    }
}