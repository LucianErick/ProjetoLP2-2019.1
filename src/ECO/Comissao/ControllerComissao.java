package ECO.Comissao;

import java.util.HashMap;
import java.util.Map;

import static ECO.Util.Validador.validadorString;

public class ControllerComissao {

    private Map<String, Comissao> mapaComissoes;

    public ControllerComissao() {
        this.mapaComissoes = new HashMap<>();
    }

    public void cadastrarComissao(String tema, String dniPoliticos) {
        validadorString(tema, "Erro ao cadastrar comissao: tema nao pode ser vazio ou nulo");
        validadorString(dniPoliticos, "Erro ao cadastrar comissao: lista de politicos nao pode ser vazio ou nulo");

        if (this.mapaComissoes.containsKey(tema)) {
            throw new IllegalArgumentException("Erro ao cadastrar comissao: tema existente");
        }
        this.mapaComissoes.put(tema, new Comissao(tema, dniPoliticos));
    }
}
