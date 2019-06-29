
package ECO;

import easyaccept.EasyAccept;

import java.io.IOException;


public class Facade {
    private ControllerGeral controladorGeral;


    public Facade() {
          this.controladorGeral = new ControllerGeral();

    }

    public void carregarSistema() throws IOException, ClassNotFoundException {
        this.controladorGeral.iniciaSistema();
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
        return controladorGeral.exibirTramitacao(codigo);
    }

//   US9

    public void configurarEstrategiaPropostaRelacionada(String dni, String estrategia) {
        controladorGeral.configurarEstrategiaPropostaRelacionada(dni, estrategia);
    }


    public String pegarPropostaRelacionada(String dni) {
        return controladorGeral.pegarPropostaRelacionada(dni);
    }


//   US10
    public void salvarSistema() throws IOException {
         this.controladorGeral.finalizaSistema();
    }


    public void limparSistema(){
         this.controladorGeral.limparSistema();
   }

    public static void main(String[] args) {
        args = new String[] {
                "ECO.Facade",
//                "acceptance_tests/use_case_1.txt", "acceptance_tests/use_case_2.txt",
//                "acceptance_tests/use_case_3.txt", "acceptance_tests/use_case_4.txt",
//                "acceptance_tests/use_case_5.txt", "acceptance_tests/use_case_6.txt",
                "acceptance_tests/use_case_7.txt",
                "acceptance_tests/use_case_8.txt",
//                "acceptance_tests/use_case_9.txt",
                };

        EasyAccept.main(args);

//
//        ControllerGeral controllerGeral = new ControllerGeral();
//
//        controllerGeral.cadastrarPessoa("Artur1", "1111-1", "PB", "SAUDE,COMIDA", "GOVERNO");
//        controllerGeral.cadastrarPessoa("Artur2", "2222-1", "PB", "SAUDE,COMIDA", "GOVERNO");
//        controllerGeral.cadastrarPessoa("Artur3", "3333-1", "PB", "SAUDE,COMIDA", "GOVERNO");
//        controllerGeral.cadastrarPessoa("Artur4", "4444-1", "PB", "SAUDE,COMIDA", "GOVERNO");
//        controllerGeral.cadastrarPessoa("Artur5", "5555-1", "PB", "SAUDE,COMIDA", "GOVERNO");
//        controllerGeral.cadastrarPessoa("Artur6", "6666-1", "PB", "SAUDE,COMIDA", "GOVERNO");
//        controllerGeral.cadastrarPessoa("Artur7", "7777-1", "PB", "SAUDE,COMIDA", "GOVERNO");
//        controllerGeral.cadastrarPessoa("Artur8", "8888-1", "PB", "SAUDE,COMIDA", "GOVERNO");
//        controllerGeral.cadastrarPessoa("Artur9", "9999-2", "PB", "SAUDE,COMIDA", "OPOSICAO");
//        controllerGeral.cadastrarPessoa("Artur10", "1010-2", "PB", "SAUDE,COMIDA", "OPOSICAO");
//
//        controllerGeral.cadastrarDeputado("1111-1", "12012000");
//        controllerGeral.cadastrarDeputado("2222-1", "12012000");
//        controllerGeral.cadastrarDeputado("3333-1", "12012000");
//        controllerGeral.cadastrarDeputado("4444-1", "12012000");
//        controllerGeral.cadastrarDeputado("5555-1", "12012000");
//        controllerGeral.cadastrarDeputado("6666-1", "12012000");
//        controllerGeral.cadastrarDeputado("7777-1", "12012000");
//        controllerGeral.cadastrarDeputado("8888-1", "12012000");
//        controllerGeral.cadastrarDeputado("9999-2", "12012000");
//        controllerGeral.cadastrarDeputado("1010-2", "12012000");
//
//        controllerGeral.cadastrarPartido("GOVERNO");
//
//        System.out.println(controllerGeral.exibeBase());
//        System.out.println(" ");
//
//        System.out.println(controllerGeral.exibePessoa("1111-1"));
//        System.out.println(controllerGeral.exibePessoa("2222-1"));
//        System.out.println(controllerGeral.exibePessoa("3333-1"));
//        System.out.println(controllerGeral.exibePessoa("4444-1"));
//        System.out.println(controllerGeral.exibePessoa("5555-1"));
//        System.out.println(controllerGeral.exibePessoa("6666-1"));
//        System.out.println(controllerGeral.exibePessoa("7777-1"));
//        System.out.println(controllerGeral.exibePessoa("8888-1"));
//        System.out.println(controllerGeral.exibePessoa("9999-2"));
//        System.out.println(controllerGeral.exibePessoa("1010-2"));
//        System.out.println(" ");
//
//        controllerGeral.cadastrarComissao("CCJC","1111-1,2222-1,3333-1,4444-1,5555-1,8888-1,9999-2,1010-2");
//        controllerGeral.cadastrarComissao("SAUDE","1111-1,2222-1,3333-1,4444-1,9999-2");
//
//        controllerGeral.cadastrarPL("1111-1", 2015, "SAUDE", "SAUDE", "OI", true);
//        controllerGeral.cadastrarPL("1111-1", 2015, "SAUDE", "SAUDE", "OI", false);
//        controllerGeral.cadastrarPL("1111-1", 2015, "SAUDE", "SAUDE", "OI", true);
//
//
//        controllerGeral.cadastrarPLP("1111-1", 2015, "SAUDE", "SAUDE", "OI", "OI");
//        controllerGeral.cadastrarPEC("1111-1", 2015, "SAUDE", "SAUDE", "OI", "OI");
//
//        System.out.println(controllerGeral.exibirProjeto("PL 1/2015"));
//        System.out.println(controllerGeral.exibirProjeto("PL 2/2015"));
//        System.out.println(controllerGeral.exibirProjeto("PL 3/2015"));
//        System.out.println(" ");
//
//
//        System.out.println(controllerGeral.exibirProjeto("PLP 1/2015"));
//        System.out.println(" ");
//
//
//        System.out.println(controllerGeral.exibirProjeto("PEC 1/2015"));
//        System.out.println(" ");
//
//        controllerGeral.votarComissao("PL 1/2015", "GOVERNISTA", "SAUDE");
//        controllerGeral.votarComissao("PL 1/2015", "GOVERNISTA", "-");
//        controllerGeral.votarComissao("PL 2/2015", "OPOSICAO", "plenario");
//        controllerGeral.votarComissao("PL 3/2015", "OPOSICAO", "plenario");
//        controllerGeral.votarComissao("PLP 1/2015", "GOVERNISTA", "plenario");
//        controllerGeral.votarComissao("PEC 1/2015", "GOVERNISTA", "plenario");
//
//        System.out.println(controllerGeral.exibePessoa("1111-1"));
//        System.out.println(" ");
//
//        System.out.println(controllerGeral.exibirProjeto("PL 1/2015"));
//        System.out.println(controllerGeral.exibirProjeto("PL 2/2015"));
//        System.out.println(controllerGeral.exibirProjeto("PL 3/2015"));
//        System.out.println(" ");
//
//
//        System.out.println(controllerGeral.exibirProjeto("PLP 1/2015"));
//        System.out.println(" ");
//
//        System.out.println(controllerGeral.exibirProjeto("PEC 1/2015"));
//        System.out.println(" ");
//
////        controllerGeral.votarComissao("PL 1/2015", "OPOSICAO", "-");
//
//        System.out.println(controllerGeral.exibirTramitacao("PL 1/2015"));
//        System.out.println(controllerGeral.exibirTramitacao("PL 2/2015"));
//        System.out.println(controllerGeral.exibirTramitacao("PL 3/2015"));
//        System.out.println(controllerGeral.exibirTramitacao("PLP 1/2015"));
//        System.out.println(controllerGeral.exibirTramitacao("PEC 1/2015"));
//        System.out.println(" ");
//
//        controllerGeral.votarPlenario("PL 2/2015", "GOVERNISTA", "1111-1,2222-1,3333-1,4444-1,5555-1,6666-1,8888-1,9999-2,1010-2");
//        controllerGeral.votarPlenario("PLP 1/2015", "GOVERNISTA", "1111-1,2222-1,3333-1,4444-1,5555-1,6666-1,8888-1,9999-2,1010-2");
//        controllerGeral.votarPlenario("PEC 1/2015", "GOVERNISTA", "1111-1,2222-1,3333-1,4444-1,5555-1,6666-1,8888-1,9999-2,1010-2");
//
//        System.out.println(" ");
//        System.out.println(controllerGeral.exibirProjeto("PL 2/2015"));
//        System.out.println(controllerGeral.exibirProjeto("PLP 1/2015"));
//        System.out.println(controllerGeral.exibirProjeto("PEC 1/2015"));
//        System.out.println(" ");
//
//        controllerGeral.votarPlenario("PL 2/2015", "GOVERNISTA", "1111-1,2222-1,3333-1,4444-1,5555-1,6666-1,8888-1,9999-2,1010-2");
//        controllerGeral.votarPlenario("PLP 1/2015", "GOVERNISTA", "1111-1,2222-1,3333-1,4444-1,5555-1,6666-1,8888-1,9999-2,1010-2");
//        controllerGeral.votarPlenario("PEC 1/2015", "GOVERNISTA", "1111-1,2222-1,3333-1,4444-1,5555-1,6666-1,8888-1,9999-2,1010-2");
//
//        System.out.println(" ");
//        System.out.println(controllerGeral.exibirProjeto("PL 2/2015"));
//        System.out.println(controllerGeral.exibirProjeto("PLP 1/2015"));
//        System.out.println(controllerGeral.exibirProjeto("PEC 1/2015"));
//        System.out.println(" ");

    }
}