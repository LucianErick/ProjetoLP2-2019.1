package ECO.Votacao;

import ECO.Comissao.Comissao;
import ECO.Comissao.ControllerComissao;

public class ControllerVotacao {
    private ControllerComissao controleComissao;
    private Plenario plenario;

    public ControllerVotacao() {
        this.controleComissao = new ControllerComissao();
        this.plenario = new Plenario();
    }

    public ControllerComissao getControleComissao() {
        return controleComissao;
    }

    public Plenario getPlenario() {
        return plenario;
    }

}
