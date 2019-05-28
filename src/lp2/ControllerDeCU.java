package lp2;

import java.util.HashMap;
import java.util.Map;

public class ControllerDeCU {
    Map<String, Pessoa> bla;

    public ControllerDeCU() {
        this.bla = new HashMap<>();
    }

    public String cadastraDeputado() {
        Deputado deputado = new Deputado();
        this.bla.get("").setFuncao(deputado);
    }
}
