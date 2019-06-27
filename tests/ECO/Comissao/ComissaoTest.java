package ECO.Comissao;

import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

class ComissaoTest {
    private Comissao comissao1;
    private Comissao comissao2;
    private Comissao comissao3;

    @Test
    void testeConstrutor() {

        comissao1 = new Comissao("CCJC", "1111-0,2222-0,3333-0");
        assertEquals("CCJC" ,comissao1.getTema());
        assertEquals("1111-0,2222-0,3333-0", comissao1.getDniDeputados());

        comissao2 = new Comissao("SEILA", "4444-0,5555-0,6666-0");
        assertEquals("SEILA", comissao2.getTema());
        assertEquals("4444-0,5555-0,6666-0", comissao2.getDniDeputados());

        assertThrows(IllegalArgumentException.class, () -> comissao3 = new Comissao(" ", "123-0"));
    }

    @Test
    void testeEquals() {
        comissao1 = new Comissao("CCJC", "1111-0,2222-0,3333-0");
        comissao2 = new Comissao("SEILA", "123-0,234-0");
        comissao3 = new Comissao("CCJC", "0000-0");

        assertFalse(comissao1.equals(comissao2));
        assertFalse(comissao2.equals(comissao3));
        assertTrue(comissao1.equals(comissao3));
    }



}