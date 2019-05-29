package lp2;

import java.util.Objects;

import static lp2.Validador.*;

public class Pessoa {


    private String dni;
    private String nome;
    private String estadoOrigem;
    private String interesses;
    private String partido;
    private Funcao funcao;

    public Pessoa(String dni, String nome, String estadoOrigem, String interesses) {
        validadorAtributo(dni, "");
        validadorAtributo(nome, "");
        validadorAtributo(estadoOrigem, "");

        this.dni = dni;
        this.nome = nome;
        this.estadoOrigem = estadoOrigem;
        this.interesses = interesses;
    }

    public Pessoa(String dni, String nome, String estadoOrigem, String interesses, String partido) {
        validadorAtributo(dni, "");
        validadorAtributo(nome, "");
        validadorAtributo(estadoOrigem, "");
        validadorAtributo(partido, "");

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
        if (!funcao.equals("") && partido.equals("")) {
            return String.format("%s - %s (%s) - Interesses: %s", this.nome, this.dni, this.estadoOrigem);
        }
        else if (funcao.equals("") && !partido.equals("")) {
            return String.format("%s - %s (%s) - %s", this.nome, this.dni, this.estadoOrigem, this.partido);
        }
        else if (funcao.equals("") && partido.equals("")) {
            return String.format("%s - %s (%s) - %s - Interesses: %s", this.nome, this.dni, this.estadoOrigem, this.partido, this.interesses);
        }
        else {
            return String.format("%s - %s (%s)", this.nome, this.dni, this.estadoOrigem);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa)) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(getDni(), pessoa.getDni());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDni());
    }
}