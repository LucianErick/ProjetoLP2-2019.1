//package lp2;
//
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class PartidoTest {
//    private Partido partido1;
//    private Partido partido2;
//    private Partido partido3;
//
//    @BeforeEach
//    void setUp() {
//        this.partido1 = new Partido("NILSO");
//        this.partido2 = new Partido("LOUNGE");
//        this.partido3 = new Partido("NILSO");
//    }
//
//    @Test
//    void construtorTest() {
//
//        assertEquals("NILSO", this.partido1.toString());
//        assertEquals("LOUNGE", this.partido2.toString());
//
//    }
//
//    @Test
//    void toStringTest() {
//
//        assertEquals("NILSO", partido1.toString());
//    }
//    @Test
//    void equalsTest1() {
//        assertFalse(partido2.equals(partido1));
//        assertFalse(partido1.equals(partido2));
//
//    }
//    @Test
//    void equalsTest2() {
//        assertTrue(partido1.equals(partido3));
//
//    }
//
//}
