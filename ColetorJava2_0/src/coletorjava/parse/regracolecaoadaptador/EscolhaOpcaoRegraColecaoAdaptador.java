package coletorjava.parse.regracolecaoadaptador;

import java.util.Iterator;
import java.util.List;

import coletorjava.dao.*;
import coletorjava.modelo.*;
import coletorjava.parse.callback.EscolhaOpcaoListaCallbackHtml;
import coletorjava.parse.callback.EscolhaOpcaoDetalheCallbackHtml;
import coletorjava.parse.dados.EscolhaOpcaoDadosParse;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.ExecutadorParse;
import br.com.digicom.parse.callback.ICallbackParse;

// Instnaciar um filho desse.
public abstract class EscolhaOpcaoRegraColecaoAdaptador  {


	protected ExecutadorParse exec = null;
	protected ICallbackParse callbackLista = null;
	protected ICallbackParse callbackDetalhe = null;
	protected EscolhaOpcaoDadosParse dadosParse = null;
	
	public EscolhaOpcaoRegraColecaoAdaptador() {
		exec = new ExecutadorParse();
		dadosParse = new EscolhaOpcaoDadosParse();
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
		return new EscolhaOpcaoListaCallbackHtml();
	}
	protected ICallbackParse criaDetalheCallbackHtml() {
		return new EscolhaOpcaoDetalheCallbackHtml();
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
	
	protected void preparaDadosLista(EscolhaOpcaoDadosParse dados) {
	}
	
	// Atualiza todos os objetos do banco (retornado pelo dao.ListaCorrente )
	public void atualizaDetalhe(DaoConexao conexao) throws DaoException {
		EscolhaOpcaoDao daoFonte = DBB.getInstancia().getEscolhaOpcaoDao(); // 
		daoFonte.setConexao(conexao);
		List<EscolhaOpcao> lista = daoFonte.ListaCorrente();
		Iterator<EscolhaOpcao> itLista = lista.iterator();
		while (itLista.hasNext()) {
			EscolhaOpcao corrente = itLista.next();
			atualizaDetalhe(corrente,conexao);
			
		}
		return;
	}
	
	// Atualiza apenas um objeto
	public final void atualizaDetalhe(EscolhaOpcao itemRaiz, DaoConexao conexao) throws DaoException {
		dadosParse.setItemDetalhe(itemRaiz);
		dadosParse.setConexao(conexao);
		preparaDadosDetalhe(dadosParse);
		exec.setCallbackParse(getCallbackDetalhe()); // Callback recebe dados parse -> manter ordem.
		exec.setDadosParse(dadosParse);
		exec.executa();
	}
	protected void preparaDadosDetalhe(EscolhaOpcaoDadosParse dados) {
	}
	public EscolhaOpcao getItemRaiz() {
		return dadosParse.getItemDetalhe();
	}
	
	// Candidato para nao mais ser usado.
	private void atualizaItens(DaoConexao conexao) throws DaoException {
		// Passo 1 - Montagem do parse do objeto
		ExecutadorParse exec = new ExecutadorParse();
		ICallbackParse callback = new EscolhaOpcaoListaCallbackHtml();
		EscolhaOpcaoDadosParse dadosParse = new EscolhaOpcaoDadosParse();
		dadosParse.setConexao(conexao);
		exec.setCallbackParse(callback);
		
		// Passo 2 - Montagem da fonte das urls
		EscolhaOpcaoDao daoFonte = DBB.getInstancia().getEscolhaOpcaoDao(); // 
		daoFonte.setConexao(conexao);
		List<EscolhaOpcao> lista = daoFonte.ListaCorrente();
		Iterator<EscolhaOpcao> itLista = lista.iterator();
		while (itLista.hasNext()) {
			EscolhaOpcao corrente = itLista.next();
			dadosParse.setItemDetalhe(corrente);
			exec.setDadosParse(dadosParse);
			exec.executa();
		}
		return;
	} 

}