package ECO.Votacao;

import ECO.Comissao.Comissao;
import ECO.Comissao.ControllerComissao;

public class ControllerVotacao {
    private ControllerComissao controleComissao;
    private Plenario plenario;
    private int ay;
    private int nay;

    public ControllerVotacao() {
        this.controleComissao = new ControllerComissao();
        this.plenario = new Plenario();
    }


    public boolean votacaoPLConclusiva (String statusGovernista, int votoAFavor, int votoContra, int votoGovernista, int votoOposicao) {
        if (statusGovernista.equals("GOVERNISTA")) {
            if (votoGovernista > votoOposicao) {
                return true;
            } else {
                return false;
            }
        }

        if (statusGovernista.equals("OPOSICAO")){
            if (votoOposicao > votoGovernista) {
                return true;
            } else {
                return false;
            }
        }

        if (statusGovernista.equals("LIVRE")) {
            if (votoAFavor > votoContra) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            throw new IllegalArgumentException("algo errado");
        }
    }
//
//    public ControllerComissao getControleComissao() {
//        return controleComissao;
//    }
//
//    public Plenario getPlenario() {
//        return plenario;
//    }
//
//    public void verificaStatusGovernista(String statusGovernista) {
//        if (!statusGovernista.equals(Orientacao.values())){
//            throw new IllegalArgumentException("Erro ao votar proposta: status invalido");
//        }
//    }
//
//    public void votacaoPLConclussiva (String codigo) {
//
//    }
//
//    public void votar () {
//        if
//    }

}
