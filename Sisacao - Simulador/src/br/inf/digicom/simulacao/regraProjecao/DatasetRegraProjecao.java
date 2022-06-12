package br.inf.digicom.simulacao.regraProjecao;

import java.util.List;

import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.digicom.sisacao.modelo.CotacaoIntradayAcaoResultado;
import br.com.digicom.sisacao.modelo.DiaPregao;
import br.com.digicom.sisacao.modelo.RegraProjecao;
import br.inf.digicom.loopback.IDatasetComum;
import br.inf.digicom.loopback.comum.ativoacao.AtivoAcao_ListaPorNomeGrupoDS;
import br.inf.digicom.loopback.comum.diapregao.DiaPregao_ObtemIntradayResultadoValorDS;
import br.inf.digicom.loopback.comum.regraprojecao.RegraProjecao_ObtemPorCodigoRegraDS;

public class DatasetRegraProjecao implements IDatasetComum , 
					RegraProjecao_ObtemPorCodigoRegraDS,
					AtivoAcao_ListaPorNomeGrupoDS, 
					DiaPregao_ObtemIntradayResultadoValorDS{
	
	private String codigoRegra;
	private RegraProjecao regraProjecao;
	
	private String codigoGrupoAcao;
	private AtivoAcao ativoAcaoCorrente;
	
	private CotacaoIntradayAcaoResultado dataInicial;
	private List<DiaPregao> listaCotacaoResultado;
	
	
	
	public String getCodigoRegraProjecao() {
		return codigoRegra;
	}
	public void setCodigoRegraProjecao(String codigoRegra) {
		this.codigoRegra = codigoRegra;
	}
	public RegraProjecao getRegraProjecao() {
		regraProjecao.setId(20);
		return regraProjecao;
	}
	public void setRegraProjecao(RegraProjecao regraProjecao) {
		this.regraProjecao = regraProjecao;
	}
	public String getCodigoGrupoAcao() {
		return codigoGrupoAcao;
	}
	public void setCodigoGrupoAcao(String codigoGrupoAcao) {
		this.codigoGrupoAcao = codigoGrupoAcao;
	}
	public AtivoAcao getAtivoAcaoCorrente() {
		ativoAcaoCorrente.setTicker("EGIE3");
		return ativoAcaoCorrente;
	}
	public void setAtivoAcaoCorrente(AtivoAcao ativoAcaoCorrente) {
		this.ativoAcaoCorrente = ativoAcaoCorrente;
	}
	public void setDataInicial(CotacaoIntradayAcaoResultado resultado) {
		this.dataInicial = resultado;
	}
	public CotacaoIntradayAcaoResultado getDataInicial() {
		return this.dataInicial;
	}
	@Override
	public void setListaCotacaoResultado(List<DiaPregao> listaCotacao) {
		this.listaCotacaoResultado = listaCotacao;
	}
	
	
	public List<DiaPregao> getListaCotacaoResultado() {
		return listaCotacaoResultado;
	}
	@Override
	public int getDiaNumInicio() {
		return 20210101;
	}
	@Override
	public int getTamanhoAmostra() {
		return 0;
	}

	
	

	

}
