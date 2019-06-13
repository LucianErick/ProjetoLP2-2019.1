package ECO.Comissao;

import ECO.Pessoa.Deputado;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static ECO.Util.Validador.validadorString;

public class ControllerComissao {
    private Map<String, Comissao> comissoes;
    private Map<String, Deputado> listaPoliticos;

    public ControllerComissao() {
        this.comissoes = new HashMap<>();
        this.listaPoliticos = new ArrayList<>();
    }

    public Map<String, Deputado> getListaPoliticos() {
        return listaPoliticos;
    }

    public void cadastrarComissao(String tema, String dniPoliticos) {
        validadorString(tema, "Erro ao cadastrar comissao: tema nao pode ser vazio ou nulo");
        validadorString(dniPoliticos, "Erro ao cadastrar comisssao: lista de politicos nao pode ser vazia ou nula");

        if (this.comissoes.containsKey(tema)) {
            throw new IllegalArgumentException("Erro ao cadastrar comissao: tema existente");
        }
    }












    }
}
