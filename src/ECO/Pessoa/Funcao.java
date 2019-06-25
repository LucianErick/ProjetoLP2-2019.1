package ECO.Pessoa;

/**
 * Interface Funcao em prol da padronizacao de funcoes politicas.
 */

public interface Funcao {

    @Override
    public String toString();

    public String getFORMATO();

    public void adicionaLei();
}
