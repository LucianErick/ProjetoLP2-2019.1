package lp2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class PessoaTest {
    private Pessoa pessoa1;
    private Pessoa pessoa2;
    private Pessoa pessoa3;
    private Pessoa pessoa4;
    private Pessoa pessoa5;

    @BeforeEach
    void setUp() {
        pessoa1 = new Pessoa("213292920-3", "Ana", "PB", "saude, economia");
        pessoa2 = new Pessoa("213292925-4", "Ana", "PB", "saude, economia","PMDB");
        pessoa3 = new Pessoa("213292925-5", "Ana", "PB","");
        pessoa4 = new Pessoa("213292925-6", "Ana", "PB","","PT");
        pessoa5 = new Pessoa("213292920-3", "Ana", "PB", "saude, economia");
    }

    @Test
    void pessoaConstrutorSemPartidoComInteresseTest() {
        assertEquals("Ana - 213292920-3 (PB) - Interesses: saude, economia", pessoa1.toString());
    }
    @Test
    void pessoaConstrutorComPartidoComInteresseTest() {
        assertEquals("Ana - 213292920-3 (PB) - PMDB - Interesses: saude, economia", pessoa2.toString());
    }
    @Test
    void pessoaConstrutorSemPartidoSemInteresseTest() {
        assertEquals("Ana - 213292920-3 (PB)", pessoa3.toString());
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
        assertEquals("Ana - 213292920-3 (PB) - PMDB - Interesses: saude, economia", pessoa2.toString());
    }

    @Test
    void toString3Test() {
        assertEquals("Ana - 213292920-3 (PB)", pessoa3.toString());
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
}