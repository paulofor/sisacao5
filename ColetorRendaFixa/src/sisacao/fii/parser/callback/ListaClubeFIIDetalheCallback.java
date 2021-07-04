package sisacao.fii.parser.callback;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.CallbackParseHtml;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.sisacao.modelo.FundoImobiliario;
import sisacao.fii.parser.FundoImobiliarioFacade;
import sisacao.fii.parser.dado.FundoImobiliarioDado;

public class ListaClubeFIIDetalheCallback extends CallbackParseHtml{
	
	private FundoImobiliario fundo;
	private FundoImobiliarioFacade facade = new FundoImobiliarioFacade();
	

	@Override
	public URL getUrl() throws MalformedURLException {
		String url = "https://www.clubefii.com.br/fundo_basico?cod=" + this.fundo.getTicker();
		return new URL(url);
	}

	@Override
	public void setDados(IDadosParse paramIDadosParse) {
		this.fundo = ((FundoImobiliarioDado) paramIDadosParse).getFundo();
		
		
	}
	
	public void handleText(char[] data, int pos) {
		super.handleText(data, pos);
		String conteudo = String.copyValueOf(data);
		if ("descrição geral".equals(this.getUltConteudo2())) {
			System.out.println(conteudo);
			this.fundo.setDescricao(conteudo);
		}
	}

	@Override
	public void finalizacaoErro() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finalizacaoOk() throws DaoException {
		this.facade.salvaItemBasico(fundo);
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
