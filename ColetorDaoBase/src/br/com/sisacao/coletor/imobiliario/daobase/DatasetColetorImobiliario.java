package br.com.sisacao.coletor.imobiliario.daobase;

import java.util.List;

import br.com.digicom.sisacao.modelo.CotacaoIntradayImobiliario;
import br.com.digicom.sisacao.modelo.FundoImobiliario;
import br.inf.digicom.loopback.IDatasetComum;

public class DatasetColetorImobiliario implements IDatasetComum{
	
	private List<FundoImobiliario> listaFundoImobiliario;
	private FundoImobiliario fundoImobiliarioCorrente;
	private CotacaoIntradayImobiliario cotacaoIntradayImobiliario;
	
	
	public List<FundoImobiliario> getListaFundoImobiliario() {
		return listaFundoImobiliario;
	}
	public void setListaFundoImobiliario(List<FundoImobiliario> listaFundoImobiliario) {
		this.listaFundoImobiliario = listaFundoImobiliario;
	}
	public FundoImobiliario getFundoImobiliarioCorrente() {
		return fundoImobiliarioCorrente;
	}
	public void setFundoImobiliarioCorrente(FundoImobiliario fundoImobiliarioCorrente) {
		this.fundoImobiliarioCorrente = fundoImobiliarioCorrente;
	}
	public CotacaoIntradayImobiliario getCotacaoIntradayImobiliario() {
		return cotacaoIntradayImobiliario;
	}
	public void setCotacaoIntradayImobiliario(CotacaoIntradayImobiliario cotacaoIntradayImobiliario) {
		this.cotacaoIntradayImobiliario = cotacaoIntradayImobiliario;
	}
	

	
	
}
