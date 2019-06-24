package ECO.Votacao;

import ECO.Comissao.ControllerComissao;
import ECO.Pessoa.ControllerPessoa;

public class ControllerVotacao {

    private ControllerComissao controleComissao;
    private ControllerPessoa controllerPessoa;

    private int ay;
    private int nay;

    public ControllerVotacao() {
        this.controleComissao = new ControllerComissao();
        this.controllerPessoa = new ControllerPessoa();
    }


    public boolean quorumMininimo (String proposta, int deputadosPresentes, int totalDeDeputados) {
        System.out.println(proposta);
        System.out.println("PEC");
        if (proposta.equals("PLP") || proposta.equals("PL")) {
            return QuorumMinimoMetadeMaisUm(deputadosPresentes, totalDeDeputados);
        }
        if (proposta.equals("PEC")) {
            return QuorumMinimoTresQuintosMaisUm(deputadosPresentes, totalDeDeputados);
        }
        else {
            throw new IllegalArgumentException("erro no tipo de proposta");
        }
    }


    private boolean QuorumMinimoMetadeMaisUm(int presentes, int totalDeDeputados) {
        if (!(presentes >= (totalDeDeputados / 2) + 1)) {
            return false;
        }
        return true;
    }

    private boolean QuorumMinimoTresQuintosMaisUm(int presentes, int totalDeDeputados) {
        if (!(presentes >= (totalDeDeputados * 3 / 5) + 1)) {
            return false;
        }
        return true;
    }

    public boolean votacao() {
        return true;
    }

    public boolean aprovaVotos1(String comissaoAtual, String[] base, String[] listaDni) {

        int baseGov = 0;
        int oposicao = 0;
        for(int i=0; i < listaDni.length; i++) {

            for (int j = 0; j < base.length; j++) {
                System.out.println(controllerPessoa.getControllerPessoa());

                if (base[j].equals(controllerPessoa.getControllerPessoa().get(listaDni[i]).getPartido())) {
                    baseGov += 1;
                } else {
                    oposicao += 1;
                }
            }
        }
        return baseGov > oposicao;
    }
}
