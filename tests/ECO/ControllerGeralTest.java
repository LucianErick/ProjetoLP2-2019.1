package ECO;


import ECO.Comissao.ControllerComissao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ControllerGeralTest {
    private ControllerGeral controleGeral;

    @Test
    void cadastraComissaoValidaTest() {
        this.controleGeral.getControlePessoas().cadastraPessoa("Ana Carolina","111222-2","PB","Música","PT");
        this.controleGeral.getControlePessoas().cadastraPessoa();
        this.controleGeral.getControleComissao().cadastrarComissao("NILSO","111222-2,6666-5");
        assertEquals("NILSO",this.controleGeral.getControleComissao());




    }
}