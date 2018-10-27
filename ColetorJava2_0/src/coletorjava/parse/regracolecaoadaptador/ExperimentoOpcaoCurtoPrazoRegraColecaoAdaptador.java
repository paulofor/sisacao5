package coletorjava.parse.regracolecaoadaptador;

import java.util.Iterator;
import java.util.List;

import coletorjava.dao.*;
import coletorjava.modelo.*;
import coletorjava.parse.callback.ExperimentoOpcaoCurtoPrazoListaCallbackHtml;
import coletorjava.parse.callback.ExperimentoOpcaoCurtoPrazoDetalheCallbackHtml;
import coletorjava.parse.dados.ExperimentoOpcaoCurtoPrazoDadosParse;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.ExecutadorParse;
import br.com.digicom.parse.callback.ICallbackParse;

// Instnaciar um filho desse.
public abstract class ExperimentoOpcaoCurtoPrazoRegraColecaoAdaptador  {


	protected ExecutadorParse exec = null;
	protected ICallbackParse callbackLista = null;
	protected ICallbackParse callbackDetalhe = null;
	protected ExperimentoOpcaoCurtoPrazoDadosParse dadosParse = null;
	
	public ExperimentoOpcaoCurtoPrazoRegraColecaoAdaptador() {
		exec = new ExecutadorParse();
		dadosParse = new ExperimentoOpcaoCurtoPrazoDadosParse();
	}
	private ICallbackParse getCallbackLista() {
		if (callbackLista==null) {
			callbackLista = criaListaCallbackHtml();
		}
		return callbackLista;
	}
	private ICallbackParse getCallbackDetalhe() {
		if (callbackDetalhe==null) {
			callbackDetalhe = criaDetalheCallbackHtml();
		}
		return callbackDetalhe;
	}
	protected ICallbackParse criaListaCallbackHtml() {
		return new ExperimentoOpcaoCurtoPrazoListaCallbackHtml();
	}
	protected ICallbackParse criaDetalheCallbackHtml() {
		return new ExperimentoOpcaoCurtoPrazoDetalheCallbackHtml();
	}

	// Atualizar uma lista de objeto em uma p?gina sem referencia de objeto pai.
	// Exemplo Categorias em uma loja Virtual
	public final void atualizaLista(DaoConexao conexao)
			throws DaoException {
		
		dadosParse.setConexao(conexao);
		preparaDadosLista(dadosParse);
		exec.setCallbackParse(getCallbackLista()); // Callback recebe dados parse -> manter ordem.
		exec.setDadosParse(dadosParse);
		exec.executa();
		return;
		
		/*
		// Passo 2 - Montagem da fonte das urls
		
		return;
		*/
	}
	
	protected void preparaDadosLista(ExperimentoOpcaoCurtoPrazoDadosParse dados) {
	}
	
	// Atualiza todos os objetos do banco (retornado pelo dao.ListaCorrente )
	public void atualizaDetalhe(DaoConexao conexao) throws DaoException {
		ExperimentoOpcaoCurtoPrazoDao daoFonte = DBB.getInstancia().getExperimentoOpcaoCurtoPrazoDao(); // 
		daoFonte.setConexao(conexao);
		List<ExperimentoOpcaoCurtoPrazo> lista = daoFonte.ListaCorrente();
		Iterator<ExperimentoOpcaoCurtoPrazo> itLista = lista.iterator();
		while (itLista.hasNext()) {
			ExperimentoOpcaoCurtoPrazo corrente = itLista.next();
			atualizaDetalhe(corrente,conexao);
			
		}
		return;
	}
	
	// Atualiza apenas um objeto
	public final void atualizaDetalhe(ExperimentoOpcaoCurtoPrazo itemRaiz, DaoConexao conexao) throws DaoException {
		dadosParse.setItemDetalhe(itemRaiz);
		dadosParse.setConexao(conexao);
		preparaDadosDetalhe(dadosParse);
		exec.setCallbackParse(getCallbackDetalhe()); // Callback recebe dados parse -> manter ordem.
		exec.setDadosParse(dadosParse);
		exec.executa();
	}
	protected void preparaDadosDetalhe(ExperimentoOpcaoCurtoPrazoDadosParse dados) {
	}
	public ExperimentoOpcaoCurtoPrazo getItemRaiz() {
		return dadosParse.getItemDetalhe();
	}
	
	// Candidato para nao mais ser usado.
	private void atualizaItens(DaoConexao conexao) throws DaoException {
		// Passo 1 - Montagem do parse do objeto
		ExecutadorParse exec = new ExecutadorParse();
		ICallbackParse callback = new ExperimentoOpcaoCurtoPrazoListaCallbackHtml();
		ExperimentoOpcaoCurtoPrazoDadosParse dadosParse = new ExperimentoOpcaoCurtoPrazoDadosParse();
		dadosParse.setConexao(conexao);
		exec.setCallbackParse(callback);
		
		// Passo 2 - Montagem da fonte das urls
		ExperimentoOpcaoCurtoPrazoDao daoFonte = DBB.getInstancia().getExperimentoOpcaoCurtoPrazoDao(); // 
		daoFonte.setConexao(conexao);
		List<ExperimentoOpcaoCurtoPrazo> lista = daoFonte.ListaCorrente();
		Iterator<ExperimentoOpcaoCurtoPrazo> itLista = lista.iterator();
		while (itLista.hasNext()) {
			ExperimentoOpcaoCurtoPrazo corrente = itLista.next();
			dadosParse.setItemDetalhe(corrente);
			exec.setDadosParse(dadosParse);
			exec.executa();
		}
		return;
	} 

}