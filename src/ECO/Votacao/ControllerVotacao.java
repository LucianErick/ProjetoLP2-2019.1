package ECO.Votacao;

import ECO.Comissao.ControllerComissao;
import ECO.Pessoa.ControllerPessoa;

import java.io.Serializable;
import java.util.Set;

public class ControllerVotacao implements Serializable {

    private ControllerComissao controleComissao;
    private ControllerPessoa controllerPessoa;



    public ControllerVotacao() {
        this.controleComissao = new ControllerComissao();
        this.controllerPessoa = new ControllerPessoa();
    }


    public void quorumMininimo (String proposta, int deputadosPresentes, int totalDeDeputados) {
        if (proposta.equals("PLP") || proposta.equals("PL")) {
             QuorumMinimoMetadeMaisUm(deputadosPresentes, totalDeDeputados);
        }
         else if (proposta.equals("PEC")) {
             QuorumMinimoTresQuintosMaisUm(deputadosPresentes, totalDeDeputados);
        }
        else {
            throw new IllegalArgumentException("erro no tipo de proposta");
        }

    }


    private void QuorumMinimoMetadeMaisUm(int presentes, int totalDeDeputados) {
        if (!(presentes >= (totalDeDeputados / 2) + 1)) {
            throw new IllegalArgumentException("Erro ao votar proposta: quorum invalido");
        }

    }

    private void QuorumMinimoTresQuintosMaisUm(int presentes, int totalDeDeputados) {
        if (!(presentes >= (totalDeDeputados * 3 / 5) + 1)) {
            throw new IllegalArgumentException("Erro ao votar proposta: quorum invalido");
        }
    }


































}
