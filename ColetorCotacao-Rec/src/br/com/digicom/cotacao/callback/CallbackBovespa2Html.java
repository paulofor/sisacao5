package br.com.digicom.cotacao.callback;

import br.com.digicom.cotacao.handle.CotacaoManipulador;
import br.com.digicom.cotacao.vo.Cotacao;
import br.com.digicom.parse.callback.CallbackParseHtml;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.util.ArquivoLog;
import br.com.digicom.util.DatasUtils;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.swing.text.html.HTML;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class CallbackBovespa2Html extends CallbackParseHtml implements
		ICallbackCotacao {
	private String ticker;
	private Cotacao cotacao = null;
	private CotacaoManipulador cotacaoManipulador = null;

	boolean ligaNegocio = false;
	boolean ligaUlt = false;
	boolean ligaHora = false;
	
	private String horario = null;
	
	public CallbackBovespa2Html() {
		//this.setDebug();
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	/*
	public void inicioTag(HTML.Tag t, String nomeClasse, String nomeId) {
		if ("divHorarioMovimentacaoAtivo".equals(nomeId)) {
			ligaHora = true;
		}
	}
	*/
	
	public void handleText(char[] data, int pos) {
		super.handleText(data, pos);
		String dado = String.copyValueOf(data);
		if (ligaHora) {
			horario = dado;
			ligaHora = false;
		}
		if (dado.indexOf("R$") == 0) {
			this.cotacao = new Cotacao();
			this.cotacao.setTicker(this.ticker);
			this.cotacao.setHoraReal(DatasUtils.getHora());
			this.cotacao.setUlt(dado.substring(3));
			this.cotacao.setNeg("0");
			this.cotacao.setHoraNegocio(horario);
		}
		if (ligaNegocio) {
			ligaNegocio = false;
			dado = dado.replaceAll("\\.", "");
			this.cotacao.setNeg(dado);
		}
		if ("N� de Neg�cios".equals(dado)) {
			ligaNegocio = true;
		}
	}

	public CallbackBovespa2Html(String ticker) {
		this.ticker = ticker;
	}

	public void startElement(String uri, String localName, String qName,
			Attributes atributos) throws SAXException {
		System.out.println("Iniciou elemento:" + qName);

		if (qName.compareTo("PAPEL") == 0) {
			this.cotacao = new Cotacao();
			this.cotacao.setTicker(this.ticker);
			this.cotacao.setHoraReal(DatasUtils.getHora());
			this.cotacao.setUlt(atributos.getValue("VALOR_ULTIMO"));
			this.cotacao.setNeg(atributos.getValue("QUANT_NEG"));
			this.cotacao.setHoraNegocio(atributos.getValue("HORA"));
		}
	}

	public void finalizacaoErro() {
		if (this.cotacao.getUlt() != null) {
			this.cotacaoManipulador.setCotacao(this.cotacao);
			this.cotacaoManipulador.gravaCotacao();
			this.cotacao.setNeg("0");
			this.cotacao.setHoraNegocio("00:00:00");
		}
		ArquivoLog.getInstancia().salvaLog(
				"Erro Callback - Ticker:" + this.cotacao.toString());
	}

	public void finalizacaoOk() {
		System.out.println(this.cotacao);
		this.cotacaoManipulador.setCotacao(this.cotacao);
		this.cotacaoManipulador.gravaCotacao();
	}

	public URL getUrl() throws MalformedURLException {
		String saida = "http://www.bmfbovespa.com.br/Pregao-online/ExecutaAcaoCotRapXSL.asp?gstrCA=&txtCodigo=" + this.ticker + "&intIdiomaXsl=0";
		return new URL(saida.toString());
	}

	public void inicializacao() {
		this.cotacao = new Cotacao();
		this.cotacao.setTicker(this.ticker);
	}

	public boolean getLoop() {
		return false;
	}

	public void setDados(IDadosParse dadosParse) {
		this.cotacaoManipulador = ((CotacaoManipulador) dadosParse);
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

/*
 * Location: D:\Java-Recuperacao\coletorcotacao.jar Qualified Name:
 * br.com.digicom.cotacao.callback.CallbackBovespaHtml JD-Core Version: 0.6.0
 */