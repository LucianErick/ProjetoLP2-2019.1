package lp2;

import java.util.HashMap;
import java.util.Map;

import static lp2.Validador.validadorString;

public class ControllerComissao {
    private Map<String, Comissao> comissoes;
    public ControllerComissao() {
        this.comissoes = new HashMap<>();
    }

    public void cadastrarComissao(String tema, String dniPoliticos) {
        validadorString(tema, "Erro ao cadastrar comissao: tema nao pode ser vazio ou nulo");
        validadorString(dniPoliticos, "Erro ao cadastrar comisssao: lista de politicos nao pode ser vazia ou nula");


    }
}
