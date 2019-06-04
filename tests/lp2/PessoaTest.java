package lp2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {
    private Pessoa pessoa1;
    private Pessoa pessoa2;
    private Pessoa pessoa3;
    private Pessoa pessoa4;
    private Pessoa pessoa5;

    @BeforeEach
    void setUp() {
        pessoa1 = new Pessoa("Ana", "213292920-3", "PB", "saude, economia");
        pessoa2 = new Pessoa("Ana", "213292925-4", "PB", "saude, economia","PMDB");
        pessoa3 = new Pessoa("Ana", "213292925-5", "PB","");
        pessoa4 = new Pessoa("Ana", "213292925-6", "PB","","PT");
        pessoa5 = new Pessoa("Ana", "213292920-3", "PB", "saude, economia");
    }

    @Test
    void PessoaTestSemPartido() {
        assertEquals("Ana - 213292920-3 (PB) - Interesses: saude, economia", pessoa1.toString());
    }
    @Test
    void pessoaConstrutorComPartidoComInteresseTest() {
        assertEquals("Ana - 213292925-4 (PB) - PMDB - Interesses: saude, economia", pessoa2.toString());
    }
    @Test
    void pessoaConstrutorSemPartidoSemInteresseTest() {
        assertEquals("Ana - 213292925-5 (PB)", pessoa3.toString());
    }
    @Test
    void pessoaConstrutorComPartidoSemInteresseTest() {
        assertEquals("Ana - 213292925-6 (PB) - PT", pessoa4.toString());
    }
    @Test
    void toString1Test() {
        assertEquals("Ana - 213292920-3 (PB) - Interesses: saude, economia", pessoa1.toString());
    }
    @Test
    void toString2Test() {
        assertEquals("Ana - 213292925-4 (PB) - PMDB - Interesses: saude, economia", pessoa2.toString());
    }

    @Test
    void toString3Test() {
        assertEquals("Ana - 213292925-5 (PB)", pessoa3.toString());
    }

    @Test
    void toString4Test() {
        assertEquals("Ana - 213292925-6 (PB) - PT", pessoa4.toString());
    }

    @Test
    void equalsTest1() {
        assertFalse(pessoa1.equals(pessoa2));
        assertFalse(pessoa1.equals(pessoa3));
        assertFalse(pessoa1.equals(pessoa4));

    }
    @Test
    void equalsTest2() {
        assertTrue(pessoa1.equals(pessoa5));

    }

    @Test
    void casdastraDeputadoTest() {
    	pessoa2.cadastraDeputado("24121996");
    	pessoa4.cadastraDeputado("10091999");
    	
        assertEquals("POL: Ana - 213292925-4 (PB) - PMDB - Interesses: saude, economia - 24/12/1996 - 0 Leis", pessoa2.toString());
        assertEquals("POL: Ana - 213292925-6 (PB) - PT - 10/09/1999 - 0 Leis", pessoa4.toString());

        // cadastro com data possuindo letras.
        assertThrows(IllegalArgumentException.class, () -> pessoa4.cadastraDeputado( "evhhu"));
        //cadastro com data fora do padrao aceitavel.
        assertThrows(IllegalArgumentException.class, () -> pessoa4.cadastraDeputado("11111111111"));
        //cadastro com o dia da data invalido.
        assertThrows(IllegalArgumentException.class, () -> pessoa4.cadastraDeputado("35102000"));
        //cadastro com data futura
        assertThrows(IllegalArgumentException.class, () -> pessoa4.cadastraDeputado("20112020"));
    }
}