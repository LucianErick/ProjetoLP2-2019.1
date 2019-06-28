package ECO.Votacao;

import ECO.Comissao.Comissao;
import ECO.Pessoa.Deputado;
import ECO.PropostasLegislativas.PropostaLegislativa;

import java.io.Serializable;
import java.util.*;

import static ECO.Util.Validador.validadorString;

public class ControllerVotacao implements Serializable {


    public ControllerVotacao() {

    }


    public boolean votarComissao(String codigo, String statusGovernista, String proximoLocal, Map<String, Comissao> comissoes, HashMap<String, PropostaLegislativa> propostasLegislativas,
                                 Map<String, Deputado> deputados, String partidosBase, String interessesRelacionados) {


//        Verificacoes

        validadorString(statusGovernista, "Erro ao votar proposta: status invalido");

        boolean aprovacao = false;
        if (!comissoes.containsKey("CCJC")) {
            throw new IllegalArgumentException("Erro ao votar proposta: CCJC nao cadastrada");
        }

        validadorString(proximoLocal, "Erro ao votar proposta: proximo local vazio");

        if (!statusGovernista.equals("GOVERNISTA") && !statusGovernista.equals("OPOSICAO")
                && !statusGovernista.equals("LIVRE")) {
            throw new IllegalArgumentException("Erro ao votar proposta: status invalido");
        }
        if (!propostasLegislativas.containsKey(codigo)) {
            throw new IllegalArgumentException("Erro ao votar proposta: projeto inexistente");
        }

        if (propostasLegislativas.get(codigo).getSituacaoAtual().equals("ARQUIVADO")
                || propostasLegislativas.get(codigo).getSituacaoAtual().equals("APROVADO")) {
            throw new IllegalArgumentException("Erro ao votar proposta: tramitacao encerrada");
        }

        String[] situacaoAtual = propostasLegislativas.get(codigo).getSituacaoAtual().split("VOTACAO");
        String localAtual = situacaoAtual[1].substring(2, situacaoAtual[1].length() - 1);

        if (localAtual.trim().equals("plenario") && proximoLocal.equals("plenario")) {
            throw new IllegalArgumentException("Erro ao votar proposta: proposta encaminhada ao plenario");
        }


//		Governista

        if (aprovaGoverno(localAtual, partidosBase, comissoes, deputados) && statusGovernista.equals("GOVERNISTA")) {
            propostasLegislativas.get(codigo).setSituacaoAtual("EM VOTACAO (" + proximoLocal + ")");
            aprovacao = true;

            if (propostasLegislativas.get(codigo).verificaBooleanConclusivo() == true
                    && (!localAtual.equals("CCJC"))) {
                propostasLegislativas.get(codigo).setSituacaoAtual("APROVADO");
                String dniAutor = propostasLegislativas.get(codigo).getDNIAutor();
                deputados.get(dniAutor).adicionaLei();
            }
        } else if (aprovaGoverno(localAtual, partidosBase, comissoes, deputados) == false && statusGovernista.equals("GOVERNISTA")) {
            propostasLegislativas.get(codigo).setSituacaoAtual("EM VOTACAO (" + proximoLocal + ")");

            aprovacao = false;
            if (propostasLegislativas.get(codigo).verificaBooleanConclusivo() == true) {
                propostasLegislativas.get(codigo).setSituacaoAtual("ARQUIVADO");

            }
        }

//		Oposicao


        else if (aprovaGoverno(localAtual, partidosBase, comissoes, deputados) && statusGovernista.equals("OPOSICAO")) {
            aprovacao = false;

            if (propostasLegislativas.get(codigo).verificaBooleanConclusivo() == true) {
                propostasLegislativas.get(codigo).setSituacaoAtual("ARQUIVADO");

            } else {
                propostasLegislativas.get(codigo).setSituacaoAtual("EM VOTACAO (" + proximoLocal + ")");
            }
        } else if (aprovaGoverno(localAtual, partidosBase, comissoes, deputados) == false && statusGovernista.equals("OPOSICAO")) {
            propostasLegislativas.get(codigo).setSituacaoAtual("EM VOTACAO (" + proximoLocal + ")");

            aprovacao = true;
            if (propostasLegislativas.get(codigo).verificaBooleanConclusivo() == true
                    && (!localAtual.equals("CCJC"))) {

                propostasLegislativas.get(codigo).setSituacaoAtual("APROVADO");
                String dniAutor = propostasLegislativas.get(codigo).getDNIAutor();
                deputados.get(dniAutor).adicionaLei();
            }

        }


//		Livre

        else if (statusGovernista.equals("LIVRE")) {
            if (verificaInteresse(localAtual, comissoes, deputados, propostasLegislativas, interessesRelacionados)) {
                aprovacao = true;
                propostasLegislativas.get(codigo).setSituacaoAtual("EM VOTACAO (" + proximoLocal + ")");
                if (verificaInteresse(localAtual, comissoes, deputados, propostasLegislativas, interessesRelacionados) && !localAtual.equals("CCJC")) {
                    propostasLegislativas.get(codigo).setSituacaoAtual("APROVADO");

                }
            }
            if (verificaInteresse(localAtual, comissoes, deputados, propostasLegislativas, interessesRelacionados) == false) {
                aprovacao = false;
                propostasLegislativas.get(codigo).setSituacaoAtual("EM VOTACAO (" + proximoLocal + ")");
                if (verificaInteresse(localAtual, comissoes, deputados, propostasLegislativas, interessesRelacionados) == false && !localAtual.equals("CCJC")) {
                    propostasLegislativas.get(codigo).setSituacaoAtual("ARQUIVADO");

                }
            }
        }

        if (propostasLegislativas.get(codigo).exibirTramitacao(codigo).equals("")) {
        propostasLegislativas.get(codigo).setTramitacao("EM VOTACAO (CCJC)"); }

        propostasLegislativas.get(codigo).setTramitacao( propostasLegislativas.get(codigo).exibirTramitacao(codigo) + ", APROVADO (" + localAtual + ")");
        return aprovacao;
    }


    public boolean votarPlenario(String codigo, String statusGovernista, String presentes, Map<String, Comissao> comissoes, HashMap<String, PropostaLegislativa> propostasLegislativas, Map<String, Deputado> deputados, String partidosBase) {

        System.out.println(codigo);
        System.out.println(codigo.contains("PL "));
        boolean aprovacao = false;
        int turno = 0;
        
        if (propostasLegislativas.get(codigo).getSituacaoAtual().equals("ARQUIVADO")
                || propostasLegislativas.get(codigo).getSituacaoAtual().equals("APROVADO")) {
            throw new IllegalArgumentException("Erro ao votar proposta: tramitacao encerrada");
        }
        
        if(aprovaPlenario(presentes,partidosBase, deputados)) {
        	aprovacao = true;
        	propostasLegislativas.get(codigo).setSituacaoAtual("APROVADO");
            String dniAutor = propostasLegislativas.get(codigo).getDNIAutor();
            deputados.get(dniAutor).adicionaLei();
        }else {
        	aprovacao = false;
        	propostasLegislativas.get(codigo).setSituacaoAtual("ARQUIVADO");
        }


        return aprovacao;
    }


    private boolean aprovaGoverno(String comissaoAtual, String base1, Map<String, Comissao> comissoes, Map<String, Deputado> deputados) {

        String[] base = base1.trim().split(",");
        Set<String> listaDni = comissoes.get(comissaoAtual).getListaDNI();
        int baseGov = 0;
        int oposicao = 0;
        for (String F : listaDni) {
            for (int j = 0; j < base.length; j++) {
                if (base[j].equals(deputados.get(F).getPartido())) {
                    baseGov += 1;
                } else {
                    oposicao += 1;
                }
            }
        }
        return baseGov > oposicao;
    }

    private boolean verificaInteresse(String comissaoAtual, Map<String, Comissao> comissoes, Map<String, Deputado> deputados,
                                      HashMap<String, PropostaLegislativa> propostasLegislativas, String interessesRelacionadas) {

        Set<String> listaDni = comissoes.get(comissaoAtual).getListaDNI();
        String[] interesse = interessesRelacionadas.trim().split(",");
        int aceita = 0;
        int rejeita = 0;
        for (int j = 0; j < interesse.length; j++) {
            for (String F : listaDni) {
                String[] interesseDNI = deputados.get(F).getInteresses().trim().split(",");
                for (int l = 0; l < interesseDNI.length; l++) {
                    if (interesseDNI[l].equals(interesse[j]))
                        aceita += 1;
                }

            }
            rejeita += 1;
        }

        if (aceita > rejeita) {
            return true;
        }
        return false;
    }
    
    private boolean aprovaPlenario(String presentes, String base1, Map<String,Deputado> deputados) {
    	String[] listaPresentes = presentes.trim().split(",");
    	String[] base = base1.trim().split(",");
    	
    	
    	int baseGov = 0;
    	
    	for(int i = 0; i< listaPresentes.length; i++) {
    		for(int j = 0;j < base.length; j++) {
    			if(deputados.get(listaPresentes[i]).getPartido().equals(base[j])) {
    				baseGov += 1;
    			}
    		}
    	}
    	
    	if(baseGov >= Math.floor(listaPresentes.length/2)+1) {
    		return true;
    	}
    	return false;
    }

    private boolean plenarioDiferenciacao (String codigo, String statusGovernista, String presentes, Map<String, Comissao> comissoes, HashMap<String, PropostaLegislativa> propostasLegislativas, Map<String, Deputado> deputados, String partidosBase) {
        if (codigo.contains("PL ")) {
            if (1 == 1) {
                return true;
            }
        }

        if (codigo.contains("PLP")) {
            if (1 == 1) {
                return true;
            }
        }

        if (codigo.contains("PEC")) {
            if (1 == 1) {
                return true;
            }
        }
        return false;
    }




















}
