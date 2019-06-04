package lp2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    void testCadastraDeputado() {
        assertEquals(true, controle.cadastraPessoa("José", "123564789-0", "PB", ""));
        assertEquals(true, controle.cadastraPessoa("Daniel", "123645468-0", "SP", "", "PSTS"));
        assertEquals(true, controle.cadastraPessoa("Paulo", "123456789-0", "RJ", "Social", "PRTS"));
        assertEquals(true, controle.cadastraPessoa("Joaquim", "123321456-9", "PB", "", "JPM"));

        assertEquals(true, controle.cadastraDeputado("123645468-0", "09102000"));
        assertEquals(true, controle.cadastraDeputado("123456789-0", "13051986"));

        assertThrows(IllegalArgumentException.class, () -> controle.cadastraDeputado("bvdbv", "10111000"));

        assertThrows(IllegalArgumentException.class, () -> controle.cadastraDeputado("b8928b", "10111001"));

        assertThrows(IllegalArgumentException.class, () -> controle.cadastraDeputado("9999999-9", "10111002"));

        assertThrows(IllegalArgumentException.class, () -> controle.cadastraDeputado("123321456-9", "evhhu"));
        assertThrows(IllegalArgumentException.class, () -> controle.cadastraDeputado("123321456-9", "11111111111"));
        assertThrows(IllegalArgumentException.class, () -> controle.cadastraDeputado("123321456-9", "35102000"));
        assertThrows(IllegalArgumentException.class, () -> controle.cadastraDeputado("123321456-9", "20112020"));
        assertThrows(IllegalArgumentException.class, () -> controle.cadastraDeputado("123645468-0", "20112001"));
        assertThrows(IllegalArgumentException.class, () -> controle.cadastraDeputado("123564789-0", "20112002"));
    }

}