package lp2;

import java.util.HashMap;
import java.util.Map;

import static lp2.Validador.*;

public class ControllerPessoa {
    private Map<String ,Pessoa> pessoas;

    // Inicializa o mapa de pessoas.
    public ControllerPessoa() {
        this.pessoas = new HashMap<>();
    }

    // Método que cadastra pessoa sem partido.
    public void cadastraPessoa(String nome, String dni, String estado, String interesses) {
        // Checando se o nome, dni ou estado são vazios ou nulos.
        validadorAtributo(nome, "Erro ao cadastrar pessoa: nome nao pode ser vazio ou nulo");
        validadorAtributo(dni, "Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo");
        validadorAtributo(estado, "Erro ao cadastrar pessoa: estado nao pode ser vazio ou nulo");
        // Checando se o dni é válido.
        validadorDni(dni, "Erro ao cadastrar pessoa: dni invalido");
        // Checando se o dni já foi cadastrado.
        if(pessoas.containsKey(dni)) {
            throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni ja cadastrado");
        }
        // Adicionando o objeto do tipo Pessoa ao mapa.
        this.pessoas.put(dni, new Pessoa(nome, dni, estado, interesses));
    }

    // Método que cadastra pessoa com partido.
    public void cadastraPessoa(String nome, String dni, String estado, String interesses, String partido) {
        // Checando se o nome, dni ou estado são vazios ou nulos.
        validadorAtributo(nome, "Erro ao cadastrar pessoa: nome nao pode ser vazio ou nulo");
        validadorAtributo(dni, "Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo");
        validadorAtributo(estado, "Erro ao cadastrar pessoa: estado nao pode ser vazio ou nulo");
        // Checando se o dni é válido.
        validadorDni(dni, "Erro ao cadastrar pessoa: dni invalido");
        // Checando se o dni já foi cadastrado.
        if(pessoas.containsKey(dni)) {
            throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni ja cadastrado");
        }
        // Adicionando o objeto do tipo Pessoa ao mapa;
        this.pessoas.put(dni, new Pessoa(nome, dni, estado, interesses, partido));
    }
}
