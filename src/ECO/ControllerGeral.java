package ECO;

import ECO.Comissao.ControllerComissao;
import ECO.Pessoa.ControllerPessoa;
import ECO.PropostasLegislativas.ControllerPLS;
import ECO.Votacao.ControllerVotacao;

import static ECO.Util.Validador.validadorDni;
import static ECO.Util.Validador.validadorString;

/**
 * Classe responsavel por controller todos os controllers das classes mais especificas
 */

public class ControllerGeral {
    /**
     * Atributo do tipo ControllerPessoa responsavel por armazenar pessoas.
     */
    private ControllerPessoa controlePessoas;
    /**
     * Atributo do tipo ControllerComissao responsavel por armazenar comissoes.
     */
    private ControllerComissao controleComissao;
    /**
     * Atributo do tipo ControllerPessoa responsavel por armazenar propostas legislativas.
     */
    private ControllerPLS controllerPLS;

    /**
     * Atributo do tipo ControllerVotacao responsavel por armazenar algo a mudar!!!!!!!!!!!!!!!!!!!!!!!!.
     */
    private ControllerVotacao controllerVotacao;

    /**
     * Construtor da classe ControllerGeral onde todos os controllers sao inicializados
     */

    public ControllerGeral() {
        this.controlePessoas = new ControllerPessoa();
        this.controleComissao = new ControllerComissao();
        this.controllerPLS = new ControllerPLS();
        this.controllerVotacao = new ControllerVotacao();

    }

    /**
     * Retorna o atributo controlePessoas do objeto ControllerGeral relacionado
     * @return controle com objetos Pessoa armazenados
     */

    public ControllerPessoa getControlePessoas() {
        return controlePessoas;
    }
    /**
     * Retorna o atributo controleComissao do objeto ControllerGeral relacionado
     * @return controle com objetos Comissao armazenados
     */

    public ControllerComissao getControleComissao() {
        return controleComissao;
    }

    /**
     * Cadastra o objeto Pessoa atraves dos parametros nome, dni, estado de origem e intesses
     * @param nome
     * @param dni
     * @param estadoOrigem
     * @param interesses
     */

    public void cadastrarPessoa(String nome, String dni, String estadoOrigem, String interesses) {
        this.controlePessoas.cadastraPessoa(nome, dni, estadoOrigem, interesses);
    }

    /**
     * Cadastra o objeto Pessoa atraves dos parametros nome, dni, estado de origem, interesses e partido.
     * @param nome
     * @param dni
     * @param estadoOrigem
     * @param interesses
     * @param partido
     */

    public void cadastrarPessoa(String nome, String dni, String estadoOrigem, String interesses, String partido) {
        this.controlePessoas.cadastraPessoa(nome, dni, estadoOrigem,interesses, partido);
    }

    /**
     * Cadastra o objeto Deputado a partir dos parametros dni e data de inicio de atuacao
     * @param dni
     * @param dataInicio
     */

    public void cadastrarDeputado(String dni, String dataInicio) {
        this.controlePessoas.cadastraDeputado(dni, dataInicio);
    }

    /**
     * Exibe o objeto Pessoa que possue o dni passado como parametro
     * @param dni
     * @return
     */

    public String exibePessoa(String dni) {
        return this.controlePessoas.exibirPessoa(dni);
    }

    /**
     * Cadastra a String partido passado como parametro
     * @param nomePartido
     */

    public void cadastrarPartido(String nomePartido) {
        this.controlePessoas.cadastrarPartido(nomePartido);
    }

    /**
     * Exibe todos as Strings partido ja cadastradas
     * @return
     */

    public String exibeBase() {
        return this.controlePessoas.exibirBase();
    }
    
    

    /**
     * Cadastra o objeto Comissao de acordo com exigencias estabelecidas como: tema ja cadastrado, tema ou String dniPoliticos nulo ou vazia.
     * @param tema meio de identificacao do objeto Comissao
     * @param dniPoliticos String com os dni dos politicos da comissao relacionada
     */

    public void cadastrarComissao(String tema, String dniPoliticos) {
        validadorString(tema, "Erro ao cadastrar comissao: tema nao pode ser vazio ou nulo");
        validadorString(dniPoliticos, "Erro ao cadastrar comissao: lista de politicos nao pode ser vazio ou nulo");
        if (this.controleComissao.getMapaComissoes().containsKey(tema)) {
            throw new IllegalArgumentException("Erro ao cadastrar comissao: tema existente");
        }

        String[] listaDni = dniPoliticos.trim().split(",");
        for (String dni : listaDni) {
            validadorDni(dni, "Erro ao cadastrar comissao: dni invalido");

            if (!this.controlePessoas.getPessoas().containsKey(dni)) {
                throw new IllegalArgumentException("Erro ao cadastrar comissao: pessoa inexistente");
            }
            if (this.controlePessoas.getPessoas().get(dni).getFuncao() == null) {
                throw new IllegalArgumentException("Erro ao cadastrar comissao: pessoa nao eh deputado");
            }
            else {
                this.controleComissao.cadastrarComissao(tema, dniPoliticos);
            }

        }
    }

    /**
     * Cadastra a proposta legislativa do tipo PL. Recebe os atributos da super classe e os especificos da classe PL. Caso o dni seja invalido/vazio/null, uma excecao sera lancada
     * @param dni
     * @param ano
     * @param ementa
     * @param interesses
     * @param url
     * @param conclusivo
     * @return a chamada do metodo
     */

    public String cadastrarPL(String dni, int ano, String ementa, String interesses, String url, boolean conclusivo) {
        validadorString(dni, "Erro ao cadastrar projeto: autor nao pode ser vazio ou nulo");
        validadorDni(dni, "Erro ao cadastrar projeto: dni invalido");
        this.controlePessoas.verificaDeputado(dni);
        return this.controllerPLS.cadastrarPL(dni, ano, ementa, interesses, url, conclusivo);
    }

    /**
     * Cadastra a proposta legislativa do tipo PLP. Recebe os atributos da super classe e os especificos da classe PL. Caso o dni seja invalido/vazio/null, uma excecao sera lancada
     * @param dni
     * @param ano
     * @param ementa
     * @param interesses
     * @param url
     * @param artigos
     * @return chamada do metodo
     */

    public String cadastrarPLP(String dni, int ano, String ementa, String interesses, String url, String artigos) {
        validadorString(dni, "Erro ao cadastrar projeto: autor nao pode ser vazio ou nulo");
        validadorDni(dni, "Erro ao cadastrar projeto: dni invalido");
        this.controlePessoas.verificaDeputado(dni);
        return this.controllerPLS.cadastrarPLP(dni, ano, ementa, interesses, url, artigos);
    }

    /**
     * Cadastra a proposta legislativa do tipo PEC. Recebe os atributos da super classe e os especificos da classe PL. Caso o dni seja invalido/vazio/null, uma excecao sera lancada
     * @param dni
     * @param ano
     * @param ementa
     * @param interesses
     * @param url
     * @param artigos
     * @return chamada do metodo
     */

    public String cadastrarPEC(String dni, int ano, String ementa, String interesses, String url, String artigos) {
        validadorString(dni, "Erro ao cadastrar projeto: autor nao pode ser vazio ou nulo");
        validadorDni(dni, "Erro ao cadastrar projeto: dni invalido");
        this.controlePessoas.verificaDeputado(dni);
        return this.controllerPLS.cadastrarPEC(dni, ano, ementa, interesses, url, artigos);
    }

    /**
     * Exibe o projeto relacionado ao condigo passado como parametro
     * @param codigo codigo relacionado a proposta legislativa
     * @return chamada do metodo
     */

    public String exibirProjeto(String codigo) {
        return this.controllerPLS.exibirProjeto(codigo);
    }









    public boolean votarComissao(String codigo, String statusGovernista, String proxLocal) {
        validadorString(statusGovernista, "Erro ao votar proposta: status invalido");
    	boolean aprovacao = false;
    	if(!controleComissao.getMapaComissoes().containsKey("CCJC")) {
    		throw new IllegalArgumentException("Erro ao votar proposta: CCJC nao cadastrada");
    	}

        validadorString(proxLocal,"Erro ao votar proposta: proximo local vazio");

    	if(!statusGovernista.equals("GOVERNISTA") && !statusGovernista.equals("OPOSICAO") && !statusGovernista.equals("LIVRE")) {
    		throw new IllegalArgumentException("Erro ao votar proposta: status invalido");
    	}
    	if(!controllerPLS.getControllerPLS().containsKey(codigo)) {
    		throw new IllegalArgumentException("Erro ao votar proposta: projeto inexistente");
    	}

    	if (controllerPLS.getControllerPLS().get(codigo).getSituacaoAtual().equals("ARQUIVADO") || controllerPLS.getControllerPLS().get(codigo).getSituacaoAtual().equals("APROVADO")) {
    	    throw new IllegalArgumentException("Erro ao votar proposta: tramitacao encerrada");
        }

        String[] situacaoAtual = controllerPLS.getControllerPLS().get(codigo).getSituacaoAtual().split("VOTACAO");
    	String localAtual = situacaoAtual[1].substring(2, situacaoAtual[1].length()-1);

//        System.out.println(" ");
//        System.out.println(" ");



        if(aprovaGoverno(localAtual) && statusGovernista.equals("GOVERNISTA")) {
    		controllerPLS.getControllerPLS().get(codigo).setSituacaoAtual("EM VOTACAO (" + proxLocal + ")");

            aprovacao = true;
            if (controllerPLS.getControllerPLS().get(codigo).verificaBooleanConclusivo(codigo) == true && (!localAtual.equals("CCJC"))){
                controllerPLS.getControllerPLS().get(codigo).setSituacaoAtual("APROVADO");
                String dniAutor = controllerPLS.getControllerPLS().get(codigo).getDNIAutor();
                controlePessoas.getPessoas().get(dniAutor).getFuncao().adicionaLei();
            }
    	}
        else if (aprovaGoverno(localAtual) == false && statusGovernista.equals("GOVERNISTA")) {
            controllerPLS.getControllerPLS().get(codigo).setSituacaoAtual("EM VOTACAO (" + proxLocal + ")");

            aprovacao = false;
            if (controllerPLS.getControllerPLS().get(codigo).verificaBooleanConclusivo(codigo) == true){
                controllerPLS.getControllerPLS().get(codigo).setSituacaoAtual("ARQUIVADO");

            }
        }
        else if(aprovaGoverno(localAtual) && statusGovernista.equals("OPOSICAO"))  {
            aprovacao = false;

            if (controllerPLS.getControllerPLS().get(codigo).verificaBooleanConclusivo(codigo) == true) {
                controllerPLS.getControllerPLS().get(codigo).setSituacaoAtual("ARQUIVADO");

            }
    	}
        else if (aprovaGoverno(localAtual) == false && statusGovernista.equals("OPOSICAO")) {
            controllerPLS.getControllerPLS().get(codigo).setSituacaoAtual("EM VOTACAO (" + proxLocal + ")");

            aprovacao = true;
            if (controllerPLS.getControllerPLS().get(codigo).verificaBooleanConclusivo(codigo) == true && (!localAtual.equals("CCJC"))){

                controllerPLS.getControllerPLS().get(codigo).setSituacaoAtual("APROVADO");
                String dniAutor = controllerPLS.getControllerPLS().get(codigo).getDNIAutor();
                controlePessoas.getPessoas().get(dniAutor).getFuncao().adicionaLei();
            }

        }

        return aprovacao;
    }


    public boolean votarPlenario(String codigo, String statusGovernista, String presentes) {


        if (controllerPLS.getControllerPLS().get(codigo).getSituacaoAtual().equals("ARQUIVADO") || controllerPLS.getControllerPLS().get(codigo).getSituacaoAtual().equals("APROVADO")) {
            throw new IllegalArgumentException("Erro ao votar proposta: tramitacao encerrada");
        }
        String[] situacaoAtual = controllerPLS.getControllerPLS().get(codigo).getSituacaoAtual().split("VOTACAO");
        String localAtual = situacaoAtual[1].substring(2, situacaoAtual[1].length()-1);
        String tipoDeProposta = controllerPLS.getControllerPLS().get(codigo).getCodigo().substring(0, 3).trim();

        if ((controleComissao.getMapaComissoes().containsKey(localAtual))) {
            throw new IllegalArgumentException("Erro ao votar proposta: tramitacao em comissao");
        }
        controllerVotacao.quorumMininimo(tipoDeProposta, presentes.length(), controlePessoas.qtdDeputados());

        validadorString(codigo, "Erro ao votar proposta: projeto inexistente");
        validadorString(statusGovernista, "Erro ao votar proposta: status invalido");
        validadorString(presentes, "");
        controllerPLS.verificaExistenciaProposta(codigo);
        controleComissao.verificaComissao("CCJC", "Erro ao votar proposta: CCJC nao cadastrada");

//        ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
        boolean aprovacao = false;
//        if ()


        return true;
    }

    private boolean aprovaGoverno(String comissaoAtual) {

        String[] base = controlePessoas.exibirBase().trim().split(",");
        String[] listaDni = controleComissao.getDniDeputados(comissaoAtual).trim().split(",");
        int baseGov = 0;
        int oposicao = 0;
        for(int i=0; i < listaDni.length; i++) {
            for (int j = 0; j < base.length; j++) {
                if (base[j].equals(controlePessoas.getControllerPessoa().get(listaDni[i]).getPartido())) {
                    baseGov += 1;
                } else {
                    oposicao += 1;
                }
            }
        }
        System.out.println(baseGov > oposicao);
        return baseGov > oposicao;
    }









//    private boolean aprovaGoverno(String comissaoAtual) {
//    	String[] base = controlePessoas.exibirBase().trim().split(",");
//    	String[] listaDni = controleComissao.getDniDeputados(comissaoAtual).trim().split(",");
//    	int baseGov = 0;
//    	int oposicao = 0;
//    	for(int i=0; i < listaDni.length; i++) {
//
//            for (int j = 0; j < base.length; j++) {
//
//                if (base[j].equals(controlePessoas.getControllerPessoa().get(listaDni[i]).getPartido())) {
//                    baseGov += 1;
//                } else {
//                    oposicao += 1;
//                }
//            }
//        }
//    	return baseGov > oposicao;
//	}
//
//
//
//    public boolean votarComissao(String cod, String statusGovernista, String proxLocal) {
//        validadorString(statusGovernista, "Erro ao votar proposta: status invalido");
//    	boolean aprovacao = false;
//    	if(!controleComissao.getMapaComissoes().containsKey("C")) {
//    		throw new IllegalArgumentException("Erro ao votar proposta: CCJC nao cadastrada");
//    	}
//
//        validadorString(proxLocal,"Erro ao votar proposta: proximo local vazio");
//
//    	if(!statusGovernista.equals("GOVERNISTA") && !statusGovernista.equals("OPOSICAO") && !statusGovernista.equals("LIVRE")) {
//    		throw new IllegalArgumentException("Erro ao votar proposta: status invalido");
//    	}
//    	if(!controllerPLS.getControllerPLS().containsKey(cod)) {
//    		throw new IllegalArgumentException("Erro ao votar proposta: projeto inexistente");
//    	}
//    	if (controllerPLS.getControllerPLS().get(cod).getSituacaoAtual().equals("ARQUIVADO") && controllerPLS.getControllerPLS().get(cod).getSituacaoAtual().equals("APROVADO")) {
//    	    throw new IllegalArgumentException("Erro ao votar proposta: tramitacao encerrada");
//        }
//    	if(proxLocal.equals("-")) {
//    		return false;
//    	}
//
//    	if(aprovaGoverno("CCJC") && statusGovernista.equals("GOVERNISTA")) {
//    		controllerPLS.getControllerPLS().get(cod).setSituacaoAtual("EM VOTACAO (" + proxLocal + ")");
//      		aprovacao = true;
//    		if(aprovaGoverno(proxLocal)) {
//    			controllerPLS.getControllerPLS().get(cod).setSituacaoAtual("APROVADO");
//    		}
//    	} else if(aprovaGoverno("CCJC") && statusGovernista.equals("OPOSICAO"))  {
//    		controllerPLS.getControllerPLS().get(cod).setSituacaoAtual("ARQUIVADO");
//    		aprovacao = false;
//    	}
//    	return aprovacao;
//    }
//
//
//    public boolean votarPlenario(String codigo, String statusGovernista, String presentes) {
//        if (controllerPLS.getControllerPLS().get(codigo).getSituacaoAtual().equals("CCJC")) {
//            throw new IllegalArgumentException("Erro ao votar proposta: tramitacao em comissao");
//        }
//        validadorString(codigo, "Erro ao votar proposta: projeto inexistente");
//        validadorString(statusGovernista, "Erro ao votar proposta: status invalido");
//        validadorString(presentes, "");
//        controllerPLS.verificaExistenciaProposta(codigo);
//        controleComissao.verificaComissao("CCJC", "Erro ao votar proposta: CCJC nao cadastrada");
//
//        return true;
//    }
}
