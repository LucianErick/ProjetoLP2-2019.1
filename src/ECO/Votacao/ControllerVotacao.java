package ECO.Votacao;

import ECO.Comissao.Comissao;
import ECO.Comissao.ControllerComissao;
import ECO.Pessoa.ControllerPessoa;
import ECO.Pessoa.Pessoa;
import ECO.PropostasLegislativas.ControllerPLS;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static ECO.Util.Validador.validadorString;

public class ControllerVotacao implements Serializable {


    private ControllerComissao controleComissao;
    private ControllerPessoa controllerPessoa;
    private ControllerPLS controllerPLS;



    public ControllerVotacao(ControllerComissao controllerComissao, ControllerPessoa controllerPessoa, ControllerPLS controllerPLS) {
        this.controleComissao = controllerComissao;
        this.controllerPessoa = controllerPessoa;
        this.controllerPLS = controllerPLS;
    }




    public void votarLibertacaoDoLula(Map<String, Pessoa> pessoa, Map<String, Comissao>  comissao, String nomeDoLula) {
        System.out.println("a");
    }







    public boolean votarComissao(String codigo, String statusGovernista, String proximoLocal) {

//        Verificacoes
    	

        validadorString(statusGovernista, "Erro ao votar proposta: status invalido");
    	
        boolean aprovacao = false;
        if (!controleComissao.getMapaComissoes().containsKey("CCJC")) {
            throw new IllegalArgumentException("Erro ao votar proposta: CCJC nao cadastrada");
        }

        validadorString(proximoLocal, "Erro ao votar proposta: proximo local vazio");

        if (!statusGovernista.equals("GOVERNISTA") && !statusGovernista.equals("OPOSICAO")
                && !statusGovernista.equals("LIVRE")) {
            throw new IllegalArgumentException("Erro ao votar proposta: status invalido");
        }
        if (!controllerPLS.getControllerPLS().containsKey(codigo)) {
            throw new IllegalArgumentException("Erro ao votar proposta: projeto inexistente");
        }

        if (controllerPLS.getControllerPLS().get(codigo).getSituacaoAtual().equals("ARQUIVADO")
                || controllerPLS.getControllerPLS().get(codigo).getSituacaoAtual().equals("APROVADO")) {
            throw new IllegalArgumentException("Erro ao votar proposta: tramitacao encerrada");
        }
        


        String[] situacaoAtual = controllerPLS.getControllerPLS().get(codigo).getSituacaoAtual().split("VOTACAO");
        String localAtual = situacaoAtual[1].substring(2, situacaoAtual[1].length() - 1);

        if (localAtual.trim().equals("plenario") && proximoLocal.equals("plenario")){
            throw new IllegalArgumentException("Erro ao votar proposta: proposta encaminhada ao plenario");
        }

//		Governista

        if (aprovaGoverno(localAtual) && statusGovernista.equals("GOVERNISTA")) {
            controllerPLS.getControllerPLS().get(codigo).setSituacaoAtual("EM VOTACAO (" + proximoLocal + ")");
            aprovacao = true;
 
            if (controllerPLS.getControllerPLS().get(codigo).verificaBooleanConclusivo() == true
                    && (!localAtual.equals("CCJC"))) {
                controllerPLS.getControllerPLS().get(codigo).setSituacaoAtual("APROVADO");
                String dniAutor = controllerPLS.getControllerPLS().get(codigo).getDNIAutor();
                controllerPessoa.getDeputados().get(dniAutor).adicionaLei();
            }
        }
        else if (aprovaGoverno(localAtual) == false && statusGovernista.equals("GOVERNISTA")) {
            controllerPLS.getControllerPLS().get(codigo).setSituacaoAtual("EM VOTACAO (" + proximoLocal + ")");

            aprovacao = false;
            if (controllerPLS.getControllerPLS().get(codigo).verificaBooleanConclusivo() == true) {
                controllerPLS.getControllerPLS().get(codigo).setSituacaoAtual("ARQUIVADO");

            }
        }

//		Oposicao


        else if (aprovaGoverno(localAtual) && statusGovernista.equals("OPOSICAO")) {
            aprovacao = false;

            if (controllerPLS.getControllerPLS().get(codigo).verificaBooleanConclusivo() == true ) {
                controllerPLS.getControllerPLS().get(codigo).setSituacaoAtual("ARQUIVADO");

            }
            else {
            	controllerPLS.getControllerPLS().get(codigo).setSituacaoAtual("EM VOTACAO (" + proximoLocal + ")");
            }
        }
        else if (aprovaGoverno(localAtual) == false && statusGovernista.equals("OPOSICAO")) {
            controllerPLS.getControllerPLS().get(codigo).setSituacaoAtual("EM VOTACAO (" + proximoLocal + ")");

            aprovacao = true;
            if (controllerPLS.getControllerPLS().get(codigo).verificaBooleanConclusivo() == true
                    && (!localAtual.equals("CCJC"))) {

                controllerPLS.getControllerPLS().get(codigo).setSituacaoAtual("APROVADO");
                String dniAutor = controllerPLS.getControllerPLS().get(codigo).getDNIAutor();
                controllerPessoa.getDeputados().get(dniAutor).adicionaLei();
            }

        }

//		Livre

        else if (statusGovernista.equals("LIVRE")) {
            if (verificaInteresse(localAtual, codigo)) {
                aprovacao = true;
                controllerPLS.getControllerPLS().get(codigo).setSituacaoAtual("EM VOTACAO (" + proximoLocal + ")");
                if(verificaInteresse(localAtual, codigo) && !localAtual.equals("CCJC")) {
                    controllerPLS.getControllerPLS().get(codigo).setSituacaoAtual("APROVADO");

                }
            }
            if (verificaInteresse(localAtual, codigo) == false) {
                aprovacao = false;
                controllerPLS.getControllerPLS().get(codigo).setSituacaoAtual("EM VOTACAO (" + proximoLocal + ")");
                if(verificaInteresse(localAtual, codigo) == false && !localAtual.equals("CCJC")) {
                    controllerPLS.getControllerPLS().get(codigo).setSituacaoAtual("ARQUIVADO");

                }
            }
        }

        return aprovacao;
    }


    public boolean votarPlenario(String codigo, String statusGovernista, String presentes) {




        if (controllerPLS.getControllerPLS().get(codigo).getSituacaoAtual().equals("ARQUIVADO")
                || controllerPLS.getControllerPLS().get(codigo).getSituacaoAtual().equals("APROVADO")) {
            throw new IllegalArgumentException("Erro ao votar proposta: tramitacao encerrada");
        }
        String[] situacaoAtual = controllerPLS.getControllerPLS().get(codigo).getSituacaoAtual().split("VOTACAO");
        String localAtual = situacaoAtual[1].substring(2, situacaoAtual[1].length() - 1);
        String tipoDeProposta = controllerPLS.getControllerPLS().get(codigo).getCodigo().substring(0, 3).trim();

        if ((controleComissao.getMapaComissoes().containsKey(localAtual))) {
            throw new IllegalArgumentException("Erro ao votar proposta: tramitacao em comissao");
        }

        String[] deputadosPresentes = presentes.split(",");

        int DepPresentes = deputadosPresentes.length;

        controllerPLS.quorumMininimo(codigo, DepPresentes, controllerPessoa.qtdDeputados());


        validadorString(codigo, "Erro ao votar proposta: projeto inexistente");
        validadorString(statusGovernista, "Erro ao votar proposta: status invalido");
        validadorString(presentes, "");
        if (!controllerPLS.getControllerPLS().containsKey(codigo)) {
            throw new IllegalArgumentException("Erro ao votar proposta: projeto inexistente");
        }
        controleComissao.verificaComissao("CCJC", "Erro ao votar proposta: CCJC nao cadastrada");
        
        boolean aprovacao = false;
        int turno = 0;
        
        if(aprovaPlPlenario(presentes))
        	aprovacao = true;
        	




        return aprovacao;
    }




    private boolean aprovaGoverno(String comissaoAtual) {
    	
    	String[] base = controllerPessoa.exibirBase().trim().split(",");
        Set<String> listaDni = controleComissao.getMapaComissoes().get(comissaoAtual).getListaDNI();
        int baseGov = 0;
        int oposicao = 0;
        for (String F : listaDni ) {
            for (int j = 0; j < base.length; j++) {
                if (base[j].equals(controllerPessoa.getDeputados().get(F).getPartido())) {
                    baseGov += 1;
                } else {
                    oposicao += 1;
                }
            }
        }
        return baseGov > oposicao;
    }

    private boolean verificaInteresse(String comissaoAtual, String cod) {
        Set<String> listaDni = controleComissao.getMapaComissoes().get(comissaoAtual).getListaDNI();
        String[] interesse = controllerPLS.getInteressesRelacionados(cod).trim().split(",");
        int aceita = 0;
        int rejeita = 0;
        for (int j = 0; j < interesse.length; j++) {
            for (String F : listaDni ) {
                String[] interesseDNI = controllerPessoa.getDeputados().get(F).getInteresses().trim().split(",");
                for (int l = 0; l < interesseDNI.length; l++) {
                    if (interesseDNI[l].equals(interesse[j]))
                        aceita+=1;
                }

            }
            rejeita += 1;
        }
        if(aceita > rejeita) {
            return true;
        }
        return false;
    }

    private boolean  aprovaGovernoPlenario(String presentes, String codigo){
        HashSet<String> listaPartidoDosPresentes = new HashSet<>();

        String[] base = controllerPessoa.exibirBase().trim().split(",");
        String[] DepPresentes = presentes.trim().split(",");
        for ( int i = 0; i < DepPresentes.length; i++){
            listaPartidoDosPresentes.add(controllerPessoa.getPartidos(DepPresentes[i]));
        }
        int baseGov = 0;
        int oposicao = 0;

        for (String F : listaPartidoDosPresentes ) {
            for (int j = 0; j < base.length; j++) {
                if (listaPartidoDosPresentes.contains(base[j])) {
                    baseGov += 1;
                } else {
                    oposicao += 1;
                }
            }
        }
        return baseGov > oposicao;
    }

    private boolean aprovaPlPlenario(String presentes) {
    	String[] listaPresentes = presentes.trim().split(",");
    	String base = controllerPessoa.exibirBase();
    	
    	 int baseGov = 0;
         int oposicao = 0;
    	for(int i = 0; i < listaPresentes.length; i++) {
    		if(controllerPessoa.getControllerPessoa().get(listaPresentes[i]).getPartido().equals(base)){
    			baseGov += 1;
    		}else {
    			oposicao +=1;
    		}
    	}
    	if(baseGov > oposicao) {
    		return true;
    	}
    	return false;
    }

















}
