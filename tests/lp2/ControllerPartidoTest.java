package lp2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class ControllerPartidoTest {
    private ControllerPartido controle;

    @Test
    void cadastraPartidoSemRepeticao() {

        controle.cadastraPartido("NILSO");
        assertEquals("NILSO", this.controle.exibirBase());
        controle.cadastraPartido("LOUNGE");
        assertEquals("NILSO,LOUNGE", this.controle.exibirBase());

    }

    @Test
    void cadastraPartidoRepetidos() {

        controle.cadastraPartido("NILSO");
        assertEquals("NILSO", this.controle.exibirBase());
        controle.cadastraPartido("NILSO");
        assertThrows(IllegalArgumentException.class, () -> this.controle.exibirBase());
        assertEquals("NILSO", this.controle.exibirBase());

    }

    @Test
    void cadastraPartidoVazioOuNulo() {
     //   assertThrows(IllegalArgumentException.class, () -> controle.cadastraPartido(""));
        assertThrows(IllegalArgumentException.class, () -> controle.cadastraPartido(null));

    }

    @Test
    void exibirBasePartidoRepitido() {

        controle.cadastraPartido("NILSO");
        assertEquals("NILSO", this.controle.exibirBase());
        controle.cadastraPartido("NILSO");
        assertThrows(IllegalArgumentException.class, () -> this.controle.exibirBase());
        assertEquals("NILSO", this.controle.exibirBase());
    }

    @Test
    void exibirBasePartidoInvalido() {

        assertEquals("", this.controle.exibirBase());
        controle.cadastraPartido("");
        assertThrows(IllegalArgumentException.class, () -> this.controle.exibirBase());
        assertEquals("", this.controle.exibirBase());
        controle.cadastraPartido(null);
        assertThrows(IllegalArgumentException.class, () -> this.controle.exibirBase());
        assertEquals("", this.controle.exibirBase());

    }
    @Test
    void exibirBasePartidoSemRepeticao() {

        this.controle.cadastraPartido("NILSO");
        assertEquals("NILSO", this.controle.exibirBase());
        controle.cadastraPartido("LOUNGE");
        assertEquals("NILSO,LOUNGE", this.controle.exibirBase());
    }
}