package ECO;

import ECO.Pessoa.ControllerPessoa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ControllerPessoaTest {

    private ControllerPessoa controle;

    @BeforeEach
    void setUp() {
        this.controle = new ControllerPessoa();
    }

    @Test
    void testCadastraPessoaSemPartido() {
        controle.cadastraPessoa("Joao", "123564789-0", "PB", "");
        controle.cadastraPessoa("Maria", "987654321-0", "CE", "politica, novela");
        controle.cadastraPessoa("Pedro", "135797531-1", "RO", "futebol");
       // assertEquals("Joao - 123564789-0 (PB)", controle.exibirPessoa("123564789-0"));
       // assertEquals("Maria - 987654321-0 (CE) - Interesses: politica, novela", controle.exibirPessoa("987654321-0"));
       // assertEquals("Pedro - 135797531-1 (RO) - Interesses: futebol", controle.exibirPessoa("135797531-1"));
        assertThrows(IllegalArgumentException.class, () -> controle.cadastraPessoa("", "132321300-0", "PB", ""));
        assertThrows(IllegalArgumentException.class, () -> controle.cadastraPessoa("Luciano", "", "PB", ""));
        assertThrows(IllegalArgumentException.class, () -> controle.cadastraPessoa("Thayane", "132321300-4", "", "nao sei"));
        assertThrows(IllegalArgumentException.class, () -> controle.cadastraPessoa("Joao", "132321300,0", "PB", ""));
    }

    @Test
    void testCadastraPessoaComPartido() {
        controle.cadastraPessoa("Daniel", "123645468-0", "SP", "", "PSTS");
        controle.cadastraPessoa("Paulo", "123456789-0", "RJ", "Social", "PRTS");
        controle.cadastraPessoa("Joaquim", "123321456-9", "PB", "", "JPM");
        // assertEquals("Daniel - 123645468-0 (SP) - PSTS", controle.exibirPessoa("123645468-0"));
        // assertEquals("Paulo - 123456789-0 (RJ) - PRTS - Interesses: Social", controle.exibirPessoa("123456789-0"));
        // assertEquals("Joaquim - 123321456-9 (PB) - JPM", controle.exibirPessoa("123321456-9"));
        assertThrows(IllegalArgumentException.class, () -> controle.cadastraPessoa(" ", "132321300-1", "PB", "", "EU"));
        assertThrows(IllegalArgumentException.class, () -> controle.cadastraPessoa("Ana", "   ", "PB", "", "PSOL"));
        assertThrows(IllegalArgumentException.class, () -> controle.cadastraPessoa("Luciano", "132321300-3", "    ", "", "EU"));
    }

    @Test
    void testCadastraDeputado() {

        controle.cadastraPessoa("José", "123564789-0", "PB", "");
        //assertEquals ("José - 123564789-0 (PB)", controle.exibirPessoa("123564789-0"));
        //controle.cadastraPessoa("Daniel", "123645468-0", "SP", "", "PSTS");
        //assertEquals ("Daniel - 123645468-0 (SP) - PSTS", controle.exibirPessoa("123645468-0"));
        controle.cadastraPessoa("Paulo", "123456789-0", "RJ", "Social", "PRTS");
        //assertEquals ("Paulo - 123456789-0 (RJ) - PRTS - Interesses: Social", controle.exibirPessoa("123456789-0"));
        controle.cadastraPessoa("Joaquim", "123321456-9", "PB", "", "JPM");
        //assertEquals ("Joaquim - 123321456-9 (PB) - JPM", controle.exibirPessoa("123321456-9"));

        controle.cadastraDeputado("123645468-0", "09102000");
        //assertEquals ("POL: Daniel - 123645468-0 (SP) - PSTS - 09/10/2000 - 0 Leis", controle.exibirPessoa("123645468-0"));
        controle.cadastraDeputado("123456789-0", "13051986");
        //assertEquals ("POL: Paulo - 123456789-0 (RJ) - PRTS - Interesses: Social - 13/05/1986 - 0 Leis", controle.exibirPessoa("123456789-0"));

        assertThrows(IllegalArgumentException.class, () -> controle.cadastraDeputado("bvdbv", "10111000"));
        assertThrows(IllegalArgumentException.class, () -> controle.cadastraDeputado("b8928b", "10111001"));
        assertThrows(IllegalArgumentException.class, () -> controle.cadastraDeputado("9999999-9", "10111002"));
        assertThrows(IllegalArgumentException.class, () -> controle.cadastraDeputado("123321456-9", "evhhu"));
        assertThrows(IllegalArgumentException.class, () -> controle.cadastraDeputado("123321456-9", "11111111111"));
        assertThrows(IllegalArgumentException.class, () -> controle.cadastraDeputado("123321456-9", "35102000"));
        assertThrows(IllegalArgumentException.class, () -> controle.cadastraDeputado("123321456-9", "20112020"));
    }
}
