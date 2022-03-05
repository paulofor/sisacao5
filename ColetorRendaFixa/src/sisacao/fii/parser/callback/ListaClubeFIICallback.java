package sisacao.fii.parser.callback;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.ExecutadorParse;
import br.com.digicom.parse.callback.CallbackParseHtml;
import br.com.digicom.parse.callback.ICallbackParse;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.sisacao.modelo.FundoImobiliario;
import sisacao.fii.parser.FundoImobiliarioFacade;
import sisacao.fii.parser.dado.FundoImobiliarioDado;

public class ListaClubeFIICallback extends CallbackParseHtml {

	private String tickerFundo;
	private String nomeFundo;
	private String segmentoFundo;
	private String administradorFundo;
	
	private int contaItem;
	
	private FundoImobiliarioDado dado;
		
	@Override
	public URL getUrl() throws MalformedURLException {
		String url = "https://www.clubefii.com.br/fundo_imobiliario_lista";
		return new URL(url);
	}

	boolean ligaLinha = false;
	
	public void handleText(char[] data, int pos) {
		super.handleText(data, pos);
		String conteudo = String.copyValueOf(data);
		if (ligaLinha) {
			contaItem++;
			if (contaItem==1) {
				nomeFundo = conteudo;
				System.out.println("Fundo:" + nomeFundo);
			}
			if (contaItem==8) {
				segmentoFundo = conteudo;
			}
			if (contaItem==9) {
				administradorFundo = conteudo;
				ligaLinha = false;
				this.dado.addFundo(tickerFundo, nomeFundo, segmentoFundo, administradorFundo);
			}
		}
		if ("nenhuma_cor".equals(this.getUltClasse())) {
			ligaLinha = true;
			tickerFundo = conteudo;
			contaItem = 0;
			
		}
		
		
		
	}
	
	
	@Override
	public void setDados(IDadosParse paramIDadosParse) {
		this.dado = (FundoImobiliarioDado) paramIDadosParse;
	}

	@Override
	public void finalizacaoErro() {
		// TODO Auto-generated method stub
		System.out.println("Finalizou2");
	}

	@Override
	public void finalizacaoOk() throws DaoException {
		FundoImobiliarioFacade.trataLista(this.dado.getLista());
	}
	
	

	@Override
	public void inicializacao() {
		//this.setDebug();
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

	

	
}
