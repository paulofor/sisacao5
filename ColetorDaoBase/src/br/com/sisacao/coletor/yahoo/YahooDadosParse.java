package br.com.sisacao.coletor.yahoo;

import org.json.JSONObject;

import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.sisacao.modelo.AtivoIndice;
import br.com.digicom.sisacao.modelo.CotacaoIntradayIndice;
import br.com.sisacao.coletor.indice.daobase.DatasetColetorIndice;
import br.com.sisacao.coletor.indice.loopback.CotacaoIntradayIndice_InsereValorIndice;


public class YahooDadosParse implements IDadosParse{

	private AtivoIndice indice = null;
	private DatasetColetorIndice ds = null;
	private CotacaoIntradayIndice_InsereValorIndice proc = new CotacaoIntradayIndice_InsereValorIndice();
	private CotacaoIntradayIndice cotacao = new CotacaoIntradayIndice();
	
	public void setDataset(DatasetColetorIndice ds) {
		this.ds = ds;
	}
	
	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setJson(JSONObject json) {
		// TODO Auto-generated method stub
		
	}



	public void setAtivoIndice(AtivoIndice indice) {
		this.indice = indice;
	}
	public AtivoIndice getAtivoIndice() {
		return this.indice;
	}
	
	public void enviaValor(String valor) {
		
		double valorNum = Double.parseDouble(valor);
		
		cotacao.setTicker(this.indice.getTicker());
		cotacao.setValor(valorNum);
		ds.setCotacaoIntradayIndice(cotacao);
		proc.setComum(ds);
		proc.executa();
		
	}

	
}
