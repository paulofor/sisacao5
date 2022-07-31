package sisacao.dataset.treino.dao;

import java.util.List;

import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.digicom.sisacao.modelo.DiaPregao;
import br.com.digicom.sisacao.modelo.ExemploTreinoAcaoEntrada;
import br.com.digicom.sisacao.modelo.RegraProjecao;
import br.inf.digicom.loopback.IDatasetComum;
import br.inf.digicom.loopback.comum.ativoacao.AtivoAcao_ListaPorNomeGrupoDS;
import br.inf.digicom.loopback.comum.diapregao.DiaPregao_ObtemIntradayResultadoTickerAteFinalDS;
import br.inf.digicom.loopback.comum.diapregao.DiaPregao_ObtemIntradayResultadoTickerPeriodoQuantidadeDS;
import br.inf.digicom.loopback.comum.diapregao.DiaPregao_ObtemIntradayResultadoTickerQuantidadeB3DS;
import br.inf.digicom.loopback.comum.diapregao.DiaPregao_ObtemIntradayResultadoValorDS;
import br.inf.digicom.loopback.comum.regraprojecao.RegraProjecao_ObtemPorCodigoRegraDS;

public class DatasetExemplo implements IDatasetComum, 
											DiaPregao_ObtemIntradayResultadoTickerAteFinalDS,
											DiaPregao_ObtemIntradayResultadoTickerQuantidadeB3DS,
											DiaPregao_ObtemIntradayResultadoTickerPeriodoQuantidadeDS,
											AtivoAcao_ListaPorNomeGrupoDS,
											RegraProjecao_ObtemPorCodigoRegraDS,
											DiaPregao_ObtemIntradayResultadoValorDS{

	private int qtdeDia;
	private int posicaoEntrada;
	
	private String codigoGrupoAcao;
	private AtivoAcao ativoAcaoCorrente;
	private DiaPregao diaPregaoCorrente;
	
	
	
	private List<DiaPregao> listaCotacaoResultado;
	private int diaNumInicio;
	private int diaNumFinal;
	
	
	private String codigoRegraProjecao;
	private RegraProjecao regraProjecao;
	private ExemploTreinoAcaoEntrada exemploTreinoAcaoEntrada;
	


	public int getDiaNumPrevisao() {
		return this.diaPregaoCorrente.getDiaNum();
	}

	public int getTamanhoAmostra() {
		return this.regraProjecao.getDiaLimite();
	}
	
	public RegraProjecao getRegraProjecao() {
		return regraProjecao;
	}
	public void setRegraProjecao(RegraProjecao regraProjecao) {
		this.regraProjecao = regraProjecao;
	}
	public String getCodigoRegraProjecao() {
		return codigoRegraProjecao;
	}
	public void setListaCotacaoResultado(List<DiaPregao> listaCotacaoResultado) {
		this.listaCotacaoResultado = listaCotacaoResultado;
	}
	public int getQtdeDia() {
		return qtdeDia;
	}
	public void setQtdeDia(int qtdeDia) {
		this.qtdeDia = qtdeDia;
	}
	public List<DiaPregao> getListaCotacaoResultado() {
		return listaCotacaoResultado;
	}
	
	public int getPosicaoEntrada() {
		return posicaoEntrada;
	}
	public void setPosicaoEntrada(int posicaoEntrada) {
		this.posicaoEntrada = posicaoEntrada;
	}
	@Override
	public void setAtivoAcaoCorrente(AtivoAcao item) {
		this.ativoAcaoCorrente = item;
		
	}
	@Override
	public AtivoAcao getAtivoAcaoCorrente() {
		return this.ativoAcaoCorrente;
	}
	@Override
	public void setCodigoGrupoAcao(String codigo) {
		this.codigoGrupoAcao = codigo;
	}
	@Override
	public String getCodigoGrupoAcao() {
		return this.codigoGrupoAcao;
	}
	public void setDiaNumInicio(int diaNumInicio) {
		this.diaNumInicio = diaNumInicio;
	}
	public void setDiaNumFinal(int diaNumFinal) {
		this.diaNumFinal = diaNumFinal;
		
	}
	public int getDiaNumInicio() {
		return this.diaNumInicio;
	}
	public int getDiaNumFinal() {
		return this.diaNumFinal;
	}
	public DiaPregao getDiaPregaoCorrente() {
		return diaPregaoCorrente;
	}
	public void setDiaPregaoCorrente(DiaPregao diaPregaoCorrente) {
		this.diaPregaoCorrente = diaPregaoCorrente;
	}
	public void setCodigoRegraProjecao(String codigoRegra) {
		this.codigoRegraProjecao = codigoRegra;
	}
	public ExemploTreinoAcaoEntrada getExemploTreinoAcaoEntrada() {
		return exemploTreinoAcaoEntrada;
	}
	public void setExemploTreinoAcaoEntrada(ExemploTreinoAcaoEntrada exemploTreinoAcaoEntrada) {
		this.exemploTreinoAcaoEntrada = exemploTreinoAcaoEntrada;
	}

	
	
	
	
	
	
}
