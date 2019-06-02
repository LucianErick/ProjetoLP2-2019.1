package lp2;

import java.util.Objects;

public class Partido {
    private String nomePartido;


    public Partido(String nomePartido) {
        this.nomePartido = nomePartido;
    }

    public String getNomePartido() {
        return nomePartido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Partido partido = (Partido) o;
        return nomePartido.equals(partido.nomePartido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomePartido);
    }

    @Override
    public String toString() {
        return String.format("%s", getNomePartido());
    }
}
