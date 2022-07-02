package br.com.sisacao.coletor.b3;

import java.util.Calendar;

import org.json.JSONObject;

import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.sisacao.modelo.CotacaoIntradayMercadoria;
import br.com.sisacao.coletor.ativo.loopback.CotacaoIntradayMercadoria_InsereValorHorario;
import br.com.sisacao.coletor.mercadoria.daobase.DatasetColetorMercadoria;

public class B3DadosMercadoriaParse extends B3DadosParseBase implements IDadosParse {

	

	
	private DatasetColetorMercadoria ds = null;
	private CotacaoIntradayMercadoria_InsereValorHorario proc = new CotacaoIntradayMercadoria_InsereValorHorario();
	private CotacaoIntradayMercadoria cotacao = new CotacaoIntradayMercadoria();

	public DatasetColetorMercadoria getDs() {
		return ds;
	}
	public void setDs(DatasetColetorMercadoria ds) {
		this.ds = ds;
	}
	public CotacaoIntradayMercadoria getCotacao() {
		return cotacao;
	}
	public void setCotacao(CotacaoIntradayMercadoria cotacao) {
		this.cotacao = cotacao;
	}
	@Override
	public void setServidor(String paramString) {
	}
	@Override
	public void setJson(JSONObject json) {
	
	}
	public String getTicker() {
		return this.ds.getAtivoMercadoriaCorrente().getTicker();
	}
	public String getAAAA_MM_DD() {
		 Calendar now = Calendar.getInstance();
		 String data = colocaZeroEsquerda(now.get(1)) + "-" + 
		        colocaZeroEsquerda(now.get(2) + 1) + "-" + 
		        colocaZeroEsquerda(now.get(5));
		 return data;
	}
	private static String colocaZeroEsquerda(int num) {
		if (num > 9) return "" + num;
		      return "0" + num;
	}
	public void enviaValor(Double valor, String horario) {
		this.cotacao.setDataHoraNegStr(horario);
		this.cotacao.setValor(valor);
		this.cotacao.setTicker(this.getTicker());
		this.ds.setCotacaoIntradayMercadoria(cotacao);
		proc.setComum(ds);
		proc.executa();
	}

}
