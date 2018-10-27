package coletorjava.parse.regracolecaoadaptador;

import java.util.Iterator;
import java.util.List;

import coletorjava.dao.*;
import coletorjava.modelo.*;
import coletorjava.parse.callback.OpcaoSisacaoListaCallbackHtml;
import coletorjava.parse.callback.OpcaoSisacaoDetalheCallbackHtml;
import coletorjava.parse.dados.OpcaoSisacaoDadosParse;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.ExecutadorParse;
import br.com.digicom.parse.callback.ICallbackParse;

// Instnaciar um filho desse.
public abstract class OpcaoSisacaoRegraColecaoAdaptador  {


	protected ExecutadorParse exec = null;
	protected ICallbackParse callbackLista = null;
	protected ICallbackParse callbackDetalhe = null;
	protected OpcaoSisacaoDadosParse dadosParse = null;
	
	public OpcaoSisacaoRegraColecaoAdaptador() {
		exec = new ExecutadorParse();
		dadosParse = new OpcaoSisacaoDadosParse();
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
		return new OpcaoSisacaoListaCallbackHtml();
	}
	protected ICallbackParse criaDetalheCallbackHtml() {
		return new OpcaoSisacaoDetalheCallbackHtml();
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
		
		OpcaoSisacaoSerieDao daoFonte = DBB.getInstancia().getOpcaoSisacaoSerieDao(); // Dependente ?
		daoFonte.setConexao(conexao);
		List<OpcaoSisacaoSerie> lista = daoFonte.ListaCorrente();
		Iterator<OpcaoSisacaoSerie> itLista = lista.iterator();
		while (itLista.hasNext()) {
			OpcaoSisacaoSerie corrente = itLista.next();
			dadosParse.setOpcaoSisacaoSerie_PertenceA(corrente);
			exec.setDadosParse(dadosParse);
			exec.executa();
		}
		
		return;
		*/
	}
	
	protected void preparaDadosLista(OpcaoSisacaoDadosParse dados) {
	}
	
	// Atualiza todos os objetos do banco (retornado pelo dao.ListaCorrente )
	public void atualizaDetalhe(DaoConexao conexao) throws DaoException {
		OpcaoSisacaoDao daoFonte = DBB.getInstancia().getOpcaoSisacaoDao(); // 
		daoFonte.setConexao(conexao);
		List<OpcaoSisacao> lista = daoFonte.ListaCorrente();
		Iterator<OpcaoSisacao> itLista = lista.iterator();
		while (itLista.hasNext()) {
			OpcaoSisacao corrente = itLista.next();
			atualizaDetalhe(corrente,conexao);
			
		}
		return;
	}
	
	// Atualiza apenas um objeto
	public final void atualizaDetalhe(OpcaoSisacao itemRaiz, DaoConexao conexao) throws DaoException {
		dadosParse.setItemDetalhe(itemRaiz);
		dadosParse.setConexao(conexao);
		preparaDadosDetalhe(dadosParse);
		exec.setCallbackParse(getCallbackDetalhe()); // Callback recebe dados parse -> manter ordem.
		exec.setDadosParse(dadosParse);
		exec.executa();
	}
	protected void preparaDadosDetalhe(OpcaoSisacaoDadosParse dados) {
	}
	public OpcaoSisacao getItemRaiz() {
		return dadosParse.getItemDetalhe();
	}
	
	// Candidato para nao mais ser usado.
	private void atualizaItens(DaoConexao conexao) throws DaoException {
		// Passo 1 - Montagem do parse do objeto
		ExecutadorParse exec = new ExecutadorParse();
		ICallbackParse callback = new OpcaoSisacaoListaCallbackHtml();
		OpcaoSisacaoDadosParse dadosParse = new OpcaoSisacaoDadosParse();
		dadosParse.setConexao(conexao);
		exec.setCallbackParse(callback);
		
		// Passo 2 - Montagem da fonte das urls
		OpcaoSisacaoDao daoFonte = DBB.getInstancia().getOpcaoSisacaoDao(); // 
		daoFonte.setConexao(conexao);
		List<OpcaoSisacao> lista = daoFonte.ListaCorrente();
		Iterator<OpcaoSisacao> itLista = lista.iterator();
		while (itLista.hasNext()) {
			OpcaoSisacao corrente = itLista.next();
			dadosParse.setItemDetalhe(corrente);
			exec.setDadosParse(dadosParse);
			exec.executa();
		}
		return;
	} 

}