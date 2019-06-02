package lp2;

import java.util.HashMap;
import java.util.Map;

import static lp2.Validador.*;

public class ControllerPessoa {
    private Map<String ,Pessoa> pessoas;

    public ControllerPessoa() {
        this.pessoas = new HashMap<>();
    }

    public void cadastraPessoa(String nome, String dni, String estado, String interesses) {
        validadorString(nome, "Erro ao cadastrar pessoa: nome nao pode ser vazio ou nulo");
        validadorString(dni, "Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo");
        validadorString(estado, "Erro ao cadastrar pessoa: estado nao pode ser vazio ou nulo");
        validadorDni(dni, "Erro ao cadastrar pessoa: dni invalido");
        if(pessoas.containsKey(dni)) {
            throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni ja cadastrado");
        }
        this.pessoas.put(dni, new Pessoa(nome, dni, estado, interesses));
    }

    public void cadastraPessoa(String nome, String dni, String estado, String interesses, String partido) {
        validadorString(nome, "Erro ao cadastrar pessoa: nome nao pode ser vazio ou nulo");
        validadorString(dni, "Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo");
        validadorString(estado, "Erro ao cadastrar pessoa: estado nao pode ser vazio ou nulo");
        validadorDni(dni, "Erro ao cadastrar pessoa: dni invalido");
        if(pessoas.containsKey(dni)) {
            throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni ja cadastrado");
        }
        this.pessoas.put(dni, new Pessoa(nome, dni, estado, interesses, partido));
    }
}
