
package ECO;

import easyaccept.EasyAccept;
import ECO.Pessoa.ControllerPessoa;

public class Facade {
    private ControllerPessoa controladorPessoa;

    public Facade() {
        this.controladorPessoa = new ControllerPessoa();
    }

    //US1
    public void cadastrarPessoa(String nome, String dni, String estadoOrigem, String interesses) {
        this.controladorPessoa.cadastraPessoa(nome, dni, estadoOrigem, interesses);
    }
    public void cadastrarPessoa(String nome, String dni, String estadoOrigem, String interesses, String partido) {
        this.controladorPessoa.cadastraPessoa(nome, dni, estadoOrigem, interesses, partido);
    }

    // US2
    public void cadastrarDeputado(String dni, String dataInicio) {
        this.controladorPessoa.cadastraDeputado(dni, dataInicio);
    }

    //US3

    //public String exibirPessoa(String dni) {
    //  return this.controladorPessoa.exibirPessoa(dni);
    // }

    // US4
    public void cadastrarPartido(String nomePartido) {
        this.controladorPessoa.cadastrarPartido(nomePartido);
    }
    public String exibirBase() {
        return this.controladorPessoa.exibirBase();
    }

    public void salvarSistema() {}
    public void limparSistema() {}
    public void carregarSistema() {}



    public static void main(String[] args) {
        args = new String[] { "ECO.Facade", "acceptance_tests/use_case_1.txt", "acceptance_tests/use_case_2.txt", "acceptance_tests/use_case_3.txt", "acceptance_tests/use_case_4.txt" };
        EasyAccept.main(args);
    }
}