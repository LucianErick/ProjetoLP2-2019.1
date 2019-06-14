package ECO;


import ECO.Comissao.ControllerComissao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class ControllerGeralTest {
    private ControllerGeral controleGeral;

    @Test
    void cadastraComissaoValidaTest() {
        this.controleGeral.getControlePessoas().cadastraPessoa("Ana Carolina","111222-2","PB","Música","PT");
        this.controleGeral.getControlePessoas().cadastraPessoa("Luciano Erick","6666-5","PB","Funk","BRASIL");
        this.controleGeral.getControleComissao().cadastrarComissao("NILSO","111222-2,6666-5");

        assertEquals("NILSO", this.controleGeral.getControleComissao().getMapaComissoes().get("NILSO").getTema());
    }

    @Test
    void cadastraComissaoDniInvalidoTest() {

        this.controleGeral.getControlePessoas().cadastraPessoa("Ana Carolina","111A22-2","PB","Música","PT");
        this.controleGeral.getControlePessoas().cadastraPessoa("Luciano Erick","6*66-5","PB","Funk","BRASIL");

        assertThrows(IllegalArgumentException.class, () -> this.controleGeral.getControleComissao().cadastrarComissao("NILSO","111A22-2,6*66-5"));
    }

    @Test
    void cadastraComissaoTemaJaCadastrado() {
        this.controleGeral.getControleComissao().cadastrarComissao("NILSO","1111-0,2222-9");
        assertEquals("NILSO", this.controleGeral.getControleComissao().getMapaComissoes().get("NILSO").getTema());
        this.controleGeral.getControleComissao().cadastrarComissao("NILSO","1111-0,2222-9");
        assertThrows(IllegalArgumentException.class, () -> this.controleGeral.getControleComissao().cadastrarComissao("NILSO","111A22-2,6*66-5"));




    }
}