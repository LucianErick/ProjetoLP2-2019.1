package ECO.PropostasLegislativas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerPLSTest {
    private ControllerPLS controlePLS;

    @BeforeEach
    void setUp() {
        controlePLS = new ControllerPLS();
    }

    @Test
    void cadastrarPL() {
        assertEquals("PL 1/2000", controlePLS.cadastrarPL("111", 2000, "231", "Acessibilidade", "eu_faco_coisas_sociais_importantes.com", true));
        assertEquals("PL 2/2010", controlePLS.cadastrarPL("222", 2010, "232", "Transporte", "www.google.com", false));
    }

    @Test
    void cadastrarPLP() {
        assertEquals("PLP 1/1998", controlePLS.cadastrarPLP("123", 1998, "13212", "Educação", "eu_me_importo_com_a_educacao.com", "qualquer um"));
        assertEquals("PLP 2/2015", controlePLS.cadastrarPLP("666", 2015, "333", "Cultura", "EIEIEEJEJE", "Quero umas musiquinha"));
    }

    @Test
    void cadastrarPEC() {
        assertEquals("PEC 1/2019", controlePLS.cadastrarPEC("456", 2019, "13213", "ÓDIO", "prende_todo_mundo_ae.com", "Prende geral."));
        assertEquals("PEC 2/2018", controlePLS.cadastrarPEC("999", 2018, "1321", "Programação", "Programar_eh_top.com", "P2 EH TOP"));
    }

    @Test
    void exibirProjeto() {
    }

    @Test
    void verificaBooleanConclusivo() {
    }

    @Test
    void alteraSituacaoAtual() {
    }

    @Test
    void quorumMininimo() {
    }
}