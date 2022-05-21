package br.com.sisacao.coletor.b3;

import java.util.Calendar;

import org.json.JSONObject;

import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.digicom.sisacao.modelo.CotacaoIntradayAcao;
import br.com.sisacao.coletor.ativo.daobase.DatasetColetorAcao;
import br.com.sisacao.coletor.ativo.loopback.CotacaoIntradayAcao_InsereValorHorario;

public class B3DadosParse implements IDadosParse {

	
	private AtivoAcao acao = null;
	private DatasetColetorAcao ds = null;
	private CotacaoIntradayAcao_InsereValorHorario proc = new CotacaoIntradayAcao_InsereValorHorario();
	private CotacaoIntradayAcao cotacao = new CotacaoIntradayAcao();
	
	
	public AtivoAcao getAcao() {
		return acao;
	}
	public void setAcao(AtivoAcao acao) {
		this.acao = acao;
	}
	public DatasetColetorAcao getDs() {
		return ds;
	}
	public void setDs(DatasetColetorAcao ds) {
		this.ds = ds;
	}
	public CotacaoIntradayAcao getCotacao() {
		return cotacao;
	}
	public void setCotacao(CotacaoIntradayAcao cotacao) {
		this.cotacao = cotacao;
	}
	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setJson(JSONObject json) {
		// TODO Auto-generated method stub
		
	}
	public String getTicker() {
		return this.acao.getTicker();
	}
	public String getAAAA_MM_DD() {
		 Calendar now = Calendar.getInstance();
		 String data = colocaZeroEsquerda(now.get(1)) + "-" + 
		        colocaZeroEsquerda(now.get(2) + 1) + "-" + 
		        now.get(5);
		 return data;
	}
	private static String colocaZeroEsquerda(int num) {
		if (num > 9) return "" + num;
		      return "0" + num;
	}
	
	
	public void enviaValor(Double valor, String horario) {
		this.cotacao.setDataHoraNegStr(horario);
		this.cotacao.setValor(valor);
		this.cotacao.setTicker(this.acao.getTicker());
		this.ds.setCotacaoIntradayAcao(cotacao);
		proc.setComum(ds);
		proc.executa();
	}
	




}
