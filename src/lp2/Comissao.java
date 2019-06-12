package lp2;

import java.util.Objects;

public class Comissao {
    private String tema;
    private String dniDeputados;

    public Comissao(String tema, String dniDeputados) {
        this.tema = tema;
        this.dniDeputados = dniDeputados;
    }

    public String getTema() {
        return tema;
    }

    public String getDniDeputados() {
        return dniDeputados;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comissao)) return false;
        Comissao comissao = (Comissao) o;
        return Objects.equals(getTema(), comissao.getTema());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTema());
    }
}
