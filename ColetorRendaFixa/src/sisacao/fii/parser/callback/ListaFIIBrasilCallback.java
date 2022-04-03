package sisacao.fii.parser.callback;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.swing.text.html.HTML;
import javax.swing.text.html.HTML.Tag;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.CallbackParseHtml;
import br.com.digicom.parse.callback.IDadosParse;
import sisacao.fii.parser.FundoImobiliarioFacade;
import sisacao.fii.parser.dado.AluguelFIIDado;
import sisacao.fii.parser.dado.FundoImobiliarioDado;

public class ListaFIIBrasilCallback extends CallbackParseHtml{

	
	private FundoImobiliarioDado dado;
	boolean ligaLinha = false;
	
	private String tickerFundo;
	private String nomeFundo;
	private String segmentoFundo;
	private String administradorFundo;
	
	@Override
	public URL getUrl() throws MalformedURLException {
		String url = "https://fiibrasil.com/lista-de-fiis-brasil/";
		return new URL(url);
	}
	
	
	

	@Override
	public void handleEndTag(Tag t, int pos) {
		super.handleEndTag(t, pos);
		if (t==HTML.Tag.TD) {
			System.out.println("Final de coluna");
			System.out.println("UltConteudo:" + this.getUltConteudo());
			System.out.println("UltClasse:" + this.getUltClasse());
			System.out.println();
			if ("column-1".equals(this.getUltClasse())) {
				this.tickerFundo = this.getUltConteudo();
			}
			if ("column-2".equals(this.getUltClasse())) {
				this.nomeFundo = this.getUltConteudo();
				this.dado.addFundo(tickerFundo, nomeFundo, "", "");
			}
		}
	}




	@Override
	public void setDados(IDadosParse paramIDadosParse) {
		this.dado = (FundoImobiliarioDado) paramIDadosParse;
		
	}

	@Override
	public void finalizacaoErro() {
		System.out.println("Finalizou2");
	}

	@Override
	public void finalizacaoOk() throws DaoException {
		FundoImobiliarioFacade.trataLista(this.dado.getLista());
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

}
