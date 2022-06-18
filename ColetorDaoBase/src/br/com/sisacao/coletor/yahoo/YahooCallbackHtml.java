package br.com.sisacao.coletor.yahoo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.CallbackParseHtml;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.sisacao.coletor.indice.processamento.IndiceDadosParse;

public class YahooCallbackHtml extends CallbackParseHtml{
	
	private IndiceDadosParse dados = null;

	@Override
	public URL getUrl() throws MalformedURLException {
		if ("sp500".equals(dados.getAtivoIndice().getTicker())) {
			return new URL("https://finance.yahoo.com/quote/%5EGSPC/");
		}
		if ("dow".equals(dados.getAtivoIndice().getTicker())) {
			return new URL("https://finance.yahoo.com/quote/%5EDJI/");
		}
		if ("nasdaq".equals(dados.getAtivoIndice().getTicker())) {
			return new URL("https://finance.yahoo.com/quote/NQ%3DF/");
		}
		return null;
	}

	String valor = null;
	
	public void handleText(char[] data, int pos) {
		super.handleText(data,pos);
		if (valor==null && "fin-streamer".equals(this.getUltTagSimples().toString())) {
			valor = String.copyValueOf(data);
			valor = valor.replaceAll(",", "");
		}
	}
	
	
	@Override
	public void setDados(IDadosParse paramIDadosParse) {
		this.dados = (IndiceDadosParse) paramIDadosParse;
	}

	@Override
	public void finalizacaoErro() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finalizacaoOk() throws DaoException {
		System.out.println("Valor: " + this.valor);
		this.dados.enviaValor(valor);
	}

	@Override
	public void inicializacao() {
		this.valor = null;
	}

	@Override
	public boolean getLoop() {
		return false;
	}

	@Override
	public boolean isPost() {
		return false;
	}

	@Override
	public List camposPost() {
		return null;
	}

	@Override
	public String getCharSet() {
		return null;
	}
	@Override
	public URL getJsonUrl() throws MalformedURLException {
		return null;
	}

}
