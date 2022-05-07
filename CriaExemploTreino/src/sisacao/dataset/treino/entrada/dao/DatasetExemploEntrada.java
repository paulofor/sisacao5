package sisacao.dataset.treino.entrada.dao;

import java.util.List;

import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.digicom.sisacao.modelo.DiaPregao;
import br.inf.digicom.loopback.IDatasetComum;
import br.inf.digicom.loopback.comum.ativoacao.AtivoAcao_ListaPorNomeGrupoDS;
import br.inf.digicom.loopback.comum.diapregao.DiaPregao_ObtemIntradayResultadoTickerQuantidadeDS;

public class DatasetExemploEntrada implements IDatasetComum, 
											DiaPregao_ObtemIntradayResultadoTickerQuantidadeDS,
											AtivoAcao_ListaPorNomeGrupoDS{

	private int qtdeDia;
	private int posicaoDia;
	
	private String codigoGrupoAcao;
	private AtivoAcao ativoAcaoCorrente;
	
	private List<DiaPregao> listaCotacaoResultado;
	
	
	

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
	public int getPosicaoDia() {
		return posicaoDia;
	}
	public void setPosicaoDia(int posicaoDia) {
		this.posicaoDia = posicaoDia;
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
	
	
	
	
	
}
