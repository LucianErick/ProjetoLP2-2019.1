package lp2;

import java.util.List;
import java.util.Scanner;

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

    public void cadastrarPessoa(ControllerPessoa controlePessoas) {
        String nome = entrada.nextLine();
        String dni = entrada.nextLine();
        String estadoOrigem = entrada.nextLine();
        String interesses = entrada.nextLine();

        this.controlePessoas.cadastraPessoa(nome, dni, estadoOrigem, interesses);
    }

    public void cadastrarPessoa(ControllerPessoa controlePessoas) {
        String nome = entrada.nextLine();
        String dni = entrada.nextLine();
        String estadoOrigem = entrada.nextLine();
        String interesses = entrada.nextLine();
        String partido = entrada.nextLine();

        this.controlePessoas.cadastraPessoa(nome, dni, estadoOrigem,interesses, partido);
    }

    public void cadastrarDeputado(ControllerPessoa controlePessoas) {
        String dni = entrada.nextLine();
        String dataDeInicio = entrada.nextLine();

        this.controlePessoas.cadastraDeputado(dni, dataDeInicio);
    }

    public void cadastrarPartido(ControllerPessoa controlePessoas) {
        String partido = entrada.nextLine();

        this.controlePessoas.cadastrarPartido(partido);
    }

    public void cadastrarComissao(ControllerComissao controleComissao) {
        String tema = entrada.nextLine();
        String dniPoliticos = entrada.nextLine();
        List<String> politicos = dniPoliticos.split(",");
        for (String dni : politicos) {
            if(!this.controlePessoas.getPessoas().containsKey(dni)) {
                throw new IllegalArgumentException("Erro ao cadastrar comissao: pessoa inexistente");
            } else {
                this.controleComissao.cadastrarComissao(tema, dniPoliticos);
            }
            if(this.controlePessoas.getPessoas().get(dni).getFuncao() == null) {
                throw new IllegalArgumentException("Erro ao cadastrar comissao: pessoa nao eh deputado");
            } else {
                this.controleComissao.getListaPoliticos().put(dni, controlePessoas.getPessoas(dni));

            }


        }


        this.controleComissao.cadastrarComissao(tema, dniPoliticos);
    }

}
