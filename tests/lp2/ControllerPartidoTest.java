package lp2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ControllerPartidoTest {
    private ControllerPartido controle;

    @Test
    void cadastraPartidoSemRepeticao() {
        assertEquals(true, this.controle.cadastraPartido("NILSO"));
        assertEquals(true, this.controle.cadastraPartido("LOUNGE"));
    }

    @Test
    void cadastraPartidoRepetidos() {
        assertEquals(true, this.controle.cadastraPartido("NILSO"));
        assertThrows(IllegalArgumentException.class, () -> controle.cadastraPartido("NILSO"));

    }

    @Test
    void cadastraPartidoVazioOuNulo() {
        assertThrows(IllegalArgumentException.class, () -> controle.cadastraPartido(""));
        assertThrows(IllegalArgumentException.class, () -> controle.cadastraPartido(null));

    }
}
    