package sisacao.atualizador.callback;

import java.net.CookieManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.CallbackParseJson;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.sisacao.modelo.AtivoCriptomoeda;

public class CriptomoedaBitcoinCallback extends CallbackParseJson{
	
	private String url;
	
	public void antesLoop() {
		
	}
	
	public void setLista(List<AtivoCriptomoeda> lista) {
		this.url = montaUrl(lista);
	}
	
	private String montaUrl(List<AtivoCriptomoeda> lista) {
		// https://cdn.mercadobitcoin.com.br/api/tickers?pairs=BRLbtc,BRLeth
		String saida = "";
		for (int i=0;i<lista.size();i++) {
			AtivoCriptomoeda moeda = lista.get(i);
			String dadoConsulta =  "BRL" + moeda.getTicker().toLowerCase();
			if (i>0) {
				saida += "," + dadoConsulta;
			} else {
				saida += dadoConsulta;
			}
		}
		return "https://cdn.mercadobitcoin.com.br/api/tickers?pairs=" + saida;
	}

	@Override
	public URL getUrl() throws MalformedURLException {
		return new URL(this.url);
	}

	@Override
	public void setDados(IDadosParse paramIDadosParse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finalizacaoErro() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finalizacaoOk() throws DaoException {
		System.out.println("Finalizou");
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
	public void setCookies(CookieManager cookies) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CookieManager getCookies() {
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

}
