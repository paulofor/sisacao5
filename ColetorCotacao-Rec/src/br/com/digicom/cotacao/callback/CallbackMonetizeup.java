package br.com.digicom.cotacao.callback;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.swing.text.html.HTML.Tag;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.CallbackParseHtml;
import br.com.digicom.parse.callback.IDadosParse;

public class CallbackMonetizeup extends CallbackParseHtml implements ICallbackCotacao{

	private String ticker;
	
	private float ofertaCompra;
	private float ofertaVenda;
	private float ultimo;
	private int negocios;
	
	
	public CallbackMonetizeup() {
		//this.setDebug();
	}
	
	@Override
	public URL getUrl() throws MalformedURLException {
		String url = "https://www.monetizeup.com.br/site/pages/Opcoes/DadosOpcoes.aspx?Codigo=" + ticker + "&Ano=2020";
		return new URL(url);
	}

	@Override
	public void setDados(IDadosParse paramIDadosParse) {
		// TODO Auto-generated method stub
		
	}
	
	
	

	@Override
	protected void elementoSimples(Tag t, String nomeId, String nomeClasse, String conteudo) {
		
		super.elementoSimples(t, nomeId, nomeClasse, conteudo);
		if ("MainContent_lblDtCotacao".equals(nomeId)) {
			System.out.println("Data Hora: "+ conteudo);
		}
		if ("MainContent_lblCotVlMaximoCompraOferta".equals(nomeId)) {
			System.out.println("Oferta Compra: "+ conteudo);
			//this.ofertaCompra = conteudo;
		}
		if ("MainContent_lblCotVlMaximoVendaOferta".equals(nomeId)) {
			System.out.println("Oferta Venda: "+ conteudo);
		}
		if ("MainContent_lblCotVlUltimoNegocio".equals(nomeId)) {
			System.out.println("Último negócio: "+ conteudo);
		}
		if ("MainContent_lblCotQtNegociosDia".equals(nomeId)) {
			System.out.println("Qtde: "+ conteudo);
		}
	}

	@Override
	public void handleText(char[] data, int pos) {
		super.handleText(data, pos);
		String dado = String.copyValueOf(data);
		
	}

	@Override
	public void finalizacaoErro() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finalizacaoOk() throws DaoException {
		//System.out.println("Of.Compra:" + this.)
	}

	@Override
	public void inicializacao() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getLoop() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPost() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List camposPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCharSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URL getJsonUrl() throws MalformedURLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTicker(String ticker) {
		this.ticker = ticker;
		
	}

}
