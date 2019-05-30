package lp2;

import java.util.HashMap;
import java.util.Map;

import static lp2.Validador.*;

public class ControllerPessoa {
    private Map<String ,Pessoa> pessoas;

    public ControllerPessoa() {
        this.pessoas = new HashMap<>();
    }

    public boolean cadastraPessoa(String nome, String dni, String estado, String interesses) {
        validadorAtributo(nome, "Erro ao cadastrar pessoa: nome nao pode ser vazio ou nulo");
        validadorAtributo(dni, "Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo");
        validadorAtributo(estado, "Erro ao cadastrar pessoa: estado nao pode ser vazio ou nulo");
        validadorDni(dni, "Erro ao cadastrar pessoa: dni invalido");

        if(pessoas.containsKey(dni)) {
            throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni ja cadastrado");
        }
        else if (!pessoas.containsKey(dni)) {
            this.pessoas.put(dni, new Pessoa(nome, dni, estado, interesses));
            return true;
        }
        return false;
    }

    public boolean cadastraPessoa(String nome, String dni, String estado, String interesses, String partido) {
        validadorAtributo(nome, "Erro ao cadastrar pessoa: nome nao pode ser vazio ou nulo");
        validadorAtributo(dni, "Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo");
        validadorAtributo(estado, "Erro ao cadastrar pessoa: estado nao pode ser vazio ou nulo");
        validadorDni(dni, "Erro ao cadastrar pessoa: dni invalido");

        if(pessoas.containsKey(dni)) {
            throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni ja cadastrado");
        }
        else if (!pessoas.containsKey(dni)) {
            this.pessoas.put(dni, new Pessoa(nome, dni, estado, interesses));
            return true;
        }
        return false;
    }
}
