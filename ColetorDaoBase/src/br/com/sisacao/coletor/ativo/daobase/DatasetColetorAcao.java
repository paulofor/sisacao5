package br.com.sisacao.coletor.ativo.daobase;

import java.util.List;

import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.digicom.sisacao.modelo.CotacaoIntradayAcao;
import br.inf.digicom.loopback.IDatasetComum;

public class DatasetColetorAcao implements IDatasetComum{
	
	private List<AtivoAcao> listaAtivoAcao;
	private AtivoAcao ativoAcaoCorrente;
	private CotacaoIntradayAcao cotacaoIntradayAcao;
	
	public List<AtivoAcao> getListaAtivoAcao() {
		return listaAtivoAcao;
	}
	public void setListaAtivoAcao(List<AtivoAcao> listaAtivoAcao) {
		this.listaAtivoAcao = listaAtivoAcao;
	}
	public AtivoAcao getAtivoAcaoCorrente() {
		return ativoAcaoCorrente;
	}
	public void setAtivoAcaoCorrente(AtivoAcao ativoAcaoCorrente) {
		this.ativoAcaoCorrente = ativoAcaoCorrente;
	}
	public CotacaoIntradayAcao getCotacaoIntradayAcao() {
		return cotacaoIntradayAcao;
	}
	public void setCotacaoIntradayAcao(CotacaoIntradayAcao cotacaoIntradayAcao) {
		this.cotacaoIntradayAcao = cotacaoIntradayAcao;
	}
	
	
	

}
