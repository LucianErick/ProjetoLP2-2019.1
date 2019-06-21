package ECO.Votacao;

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
        switch (statusGovernista) {
            case "GOVERNISTA":
                return votoGovernista > votoOposicao;

            case "OPOSICAO":
                return votoOposicao > votoGovernista;

            case "LIVRE":
                return votoAFavor > votoContra;

            default:
                throw new IllegalArgumentException("ERRO AE");
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
