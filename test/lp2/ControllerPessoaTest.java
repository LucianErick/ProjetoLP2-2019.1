package lp2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerPessoaTest {
    private ControllerPessoa controle;

    @Test
    void testCadastraPessoaSemPartido() {

        assertEquals(true, controle.cadastraPessoa("José", "123564789-0", "PB", ""));
        assertEquals(true, controle.cadastraPessoa("Maria", "987654321-0", "CE", "politica, novela"));
        assertEquals(true, controle.cadastraPessoa("Pedro", "135797531-1", "RO", "futebol"));
        assertThrows(IllegalArgumentException.class, () -> controle.cadastraPessoa("", "132321300-0", "PB", ""));
        assertThrows(IllegalArgumentException.class, () -> controle.cadastraPessoa("Luciano", "", "PB", ""));
        assertThrows(IllegalArgumentException.class, () -> controle.cadastraPessoa("Thayane", "132321300-4", "", "nao sei"));
        assertThrows(IllegalArgumentException.class, () -> controle.cadastraPessoa("José", "132321300,0", "PB", ""));
    }

    @Test
    void testCadastraPessoaComPartido() {
        assertEquals(true, controle.cadastraPessoa("Daniel", "123645468-0", "SP", "", "PSTS"));
        assertEquals(true, controle.cadastraPessoa("Paulo", "123456789-0", "RJ", "Social", "PRTS"));
        assertEquals(true, controle.cadastraPessoa("Joaquim", "123321456-9", "PB", "", "JPM"));
        assertThrows(IllegalArgumentException.class, () -> controle.cadastraPessoa(" ", "132321300-1", "PB", "", "EU"));
        assertThrows(IllegalArgumentException.class, () -> controle.cadastraPessoa("Ana", "   ", "PB", "", "PSOL"));
        assertThrows(IllegalArgumentException.class, () -> controle.cadastraPessoa("Luciano", "132321300-3", "    ", "", "EU"));
        assertThrows(IllegalArgumentException.class, () -> controle.cadastraPessoa("Luciano", "132321300-4", "PB", "", "EU"));
    }
}