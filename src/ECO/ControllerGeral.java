package ECO;

import ECO.Comissao.ControllerComissao;
import ECO.Pessoa.ControllerPessoa;
import java.util.Scanner;
import static ECO.Util.Validador.*;

public class ControllerGeral {
    private ControllerPessoa controlePessoas;
    private ControllerComissao controleComissao;
    Scanner entrada = new Scanner(System.in);

    public ControllerGeral() {
        this.controlePessoas = new ControllerPessoa();
        this.controleComissao = new ControllerComissao();
    }

    public ControllerPessoa getControlePessoas() {
        return controlePessoas;
    }

    public ControllerComissao getControleComissao() {
        return controleComissao;
    }

    public void cadastrarPessoa(String nome, String dni, String estadoOrigem, String interesses) {
        this.controlePessoas.cadastraPessoa(nome, dni, estadoOrigem, interesses);
    }

    public void cadastrarPessoa(String nome, String dni, String estadoOrigem, String interesses, String partido) {
        this.controlePessoas.cadastraPessoa(nome, dni, estadoOrigem,interesses, partido);
    }

    public void cadastrarDeputado(String dni, String dataInicio) {
        this.controlePessoas.cadastraDeputado(dni, dataInicio);
    }

    public String exibePessoa(String dni) {
        return this.controlePessoas.exibirPessoa(dni);
    }

    public void cadastrarPartido(String nomePartido) {
        this.controlePessoas.cadastrarPartido(nomePartido);
    }

    public String exibeBase() {
        return this.controlePessoas.exibirBase();
    }

    public void cadastrarComissao(ControllerComissao controleComissao) {
        String tema = entrada.nextLine();
        validadorString(tema, "Erro ao cadastrar comissao: tema nao pode ser vazio ou nulo");
        String dniPoliticos = entrada.nextLine();
        validadorString(dniPoliticos, "Erro ao cadastrar comissao: lista de politicos nao pode ser vazio ou nulo");

        String[] listaDni = dniPoliticos.split(",");
        for (String dni : listaDni) {
            validadorDni(dni, "Erro ao cadastrar comissao: dni invalido");

            if (this.controlePessoas.getPessoas().containsKey(dni) && this.controlePessoas.getPessoas().get(dni).getFuncao() != null) {
                this.controleComissao.cadastrarComissao(tema, dniPoliticos);
            }
            else if (!this.controlePessoas.getPessoas().containsKey(dni)) {
                throw new IllegalArgumentException("Erro ao cadastrar comissao: pessoa inexistente");
            }
            else if (this.controlePessoas.getPessoas().get(dni).getFuncao() == null) {
                throw new IllegalArgumentException("Erro ao cadastrar comissao: pessoa nao eh deputado");
            }
        }
    }
}