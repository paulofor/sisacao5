package br.com.sisacao.coletor.b3;

import java.util.Calendar;

import org.json.JSONObject;

import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.sisacao.modelo.CotacaoIntradayImobiliario;
import br.com.sisacao.coletor.ativo.loopback.CotacaoIntradayImobiliario_InsereValorHorario;
import br.com.sisacao.coletor.imobiliario.daobase.DatasetColetorImobiliario;

public class B3DadosImobiliarioParse extends B3DadosParseBase implements IDadosParse {

	

	
	private DatasetColetorImobiliario ds = null;
	private CotacaoIntradayImobiliario_InsereValorHorario proc = new CotacaoIntradayImobiliario_InsereValorHorario();
	private CotacaoIntradayImobiliario cotacao = new CotacaoIntradayImobiliario();

	public DatasetColetorImobiliario getDs() {
		return ds;
	}
	public void setDs(DatasetColetorImobiliario ds) {
		this.ds = ds;
	}
	public CotacaoIntradayImobiliario getCotacao() {
		return cotacao;
	}
	public void setCotacao(CotacaoIntradayImobiliario cotacao) {
		this.cotacao = cotacao;
	}
	@Override
	public void setServidor(String paramString) {
	}
	@Override
	public void setJson(JSONObject json) {
	
	}
	public String getTicker() {
		return this.ds.getFundoImobiliarioCorrente().getTicker();
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
		this.cotacao.setDataHoraStr(horario);
		this.cotacao.setValor(valor);
		this.cotacao.setTicker(this.getTicker());
		this.ds.setCotacaoIntradayImobiliario(cotacao);
		proc.setComum(ds);
		proc.executa();
	}

}
