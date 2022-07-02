package br.com.sisacao.coletor.mercadoria.daobase;

import java.util.List;

import br.com.digicom.sisacao.modelo.AtivoMercadoria;
import br.com.digicom.sisacao.modelo.CotacaoIntradayMercadoria;
import br.inf.digicom.loopback.IDatasetComum;

public class DatasetColetorMercadoria implements IDatasetComum{
	
	private List<AtivoMercadoria> listaAtivoMercadoria;
	private AtivoMercadoria ativoMercadoriaCorrente;
	private CotacaoIntradayMercadoria cotacaoIntradayMercadoria;
	public List<AtivoMercadoria> getListaAtivoMercadoria() {
		return listaAtivoMercadoria;
	}
	public void setListaAtivoMercadoria(List<AtivoMercadoria> listaAtivoMercadoria) {
		this.listaAtivoMercadoria = listaAtivoMercadoria;
	}
	public AtivoMercadoria getAtivoMercadoriaCorrente() {
		return ativoMercadoriaCorrente;
	}
	public void setAtivoMercadoriaCorrente(AtivoMercadoria ativoMercadoriaCorrente) {
		this.ativoMercadoriaCorrente = ativoMercadoriaCorrente;
	}
	public CotacaoIntradayMercadoria getCotacaoIntradayMercadoria() {
		return cotacaoIntradayMercadoria;
	}
	public void setCotacaoIntradayMercadoria(CotacaoIntradayMercadoria cotacaoIntradayMercadoria) {
		this.cotacaoIntradayMercadoria = cotacaoIntradayMercadoria;
	}

	
	


}
