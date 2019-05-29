package lp2;

import java.util.HashMap;
import java.util.Map;

public class ControllerPessoa {
    private Map<String ,Pessoa> pessoas;

    // Inicializa o mapa de pessoas.
    public ControllerPessoa() {
        this.pessoas = new HashMap<>();
    }

    // Método que cadastra pessoa sem partido.
    public void cadastraPessoa(String nome, String dni, String estado, String interesses) {
        this.pessoas.put(dni, new Pessoa(nome, dni, estado, interesses));
    }

    // Método que cadastra pessoa com partido.
    public void cadastraPessoa(String nome, String dni, String estado, String interesses, String partido) {
        this.pessoas.put(dni, new Pessoa(nome, dni, estado, interesses, partido));
    }
}
