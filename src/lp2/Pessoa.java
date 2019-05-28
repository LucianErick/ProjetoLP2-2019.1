package lp2;

import static lp2.Validador.*;

public class Pessoa {


    private String dni;
    private String nome;
    private String estadoOrigem;
    private String interesses;
    private String partido;
    private Funcao funcao;

    public Pessoa(String dni, String nome, String estadoOrigem, String interesses) {
        validador(dni, "");
        validador(nome, "");
        validador(estadoOrigem, "");

        this.dni = dni;
        this.nome = nome;
        this.estadoOrigem = estadoOrigem;
        this.interesses = interesses;
    }

    public Pessoa(String dni, String nome, String estadoOrigem, String interesses, String partido) {
        validador(dni, "");
        validador(nome, "");
        validador(estadoOrigem, "");
        validador(partido, "");

        this.dni = dni;
        this.nome = nome;
        this.estadoOrigem = estadoOrigem;
        this.interesses = interesses;
        this.partido = partido;
    }

    public String getDni() {
        return dni;
    }

    public String getNome() {
        return nome;
    }

    public String getEstadoOrigem() {
        return estadoOrigem;
    }

    public String getInteresses() {
        return interesses;
    }

    public String getPartido() {
        return partido;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        String partido = this.partido == null ? "" : this.partido;
        String funcao = this.funcao == null ? "" : this.funcao.toString();

        return "Pessoa{" +
                "dni='" + dni + '\'' +
                ", nome='" + nome + '\'' +
                ", estadoOrigem='" + estadoOrigem + '\'' +
                ", interesses='" + interesses + '\'' +
                ", partido='" + partido + '\'' +
                ", funcao=" + funcao +
                '}';
    }
}