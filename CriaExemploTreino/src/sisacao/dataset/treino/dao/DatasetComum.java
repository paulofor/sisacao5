package sisacao.dataset.treino.dao;

import java.util.List;

import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.digicom.sisacao.modelo.DiaPregao;
import br.com.digicom.sisacao.modelo.RegraProjecao;
import br.inf.digicom.loopback.IDatasetComum;
import br.inf.digicom.loopback.comum.ativoacao.AtivoAcao_ListaPorNomeGrupoDS;
import br.inf.digicom.loopback.comum.regraprojecao.RegraProjecao_ObtemPorCodigoRegraDS;

public class DatasetComum implements IDatasetComum ,
								AtivoAcao_ListaPorNomeGrupoDS,
								RegraProjecao_ObtemPorCodigoRegraDS
			{
	
	private RegraProjecao regraProjecao = null;
	private int inicioPeriodo = 0;
	//private String ticker = null;
	private List<DiaPregao> listaPregao;
	private String codigoRegraProjecao;
	private int quantidadeDiasX = 0;
	//private String codigoGrupo;
	private AtivoAcao ativoAcao = null;
	private String codigoGrupoAcao = null;
	

	
	
	

	public int getQuantidadeDiasX() {
		return quantidadeDiasX;
	}

	public void setQuantidadeDiasX(int quantidadeDiasX) {
		this.quantidadeDiasX = quantidadeDiasX;
	}

	public RegraProjecao getRegraProjecao() {
		return regraProjecao;
	}

	public void setRegraProjecao(RegraProjecao regraProjecao) {
		this.regraProjecao = regraProjecao;
	}

	public int getInicioPeriodo() {
		return inicioPeriodo;
	}

	public void setInicioPeriodo(int inicioPeriodo) {
		this.inicioPeriodo = inicioPeriodo;
	}

	

	public List<DiaPregao> getListaPregao() {
		return listaPregao;
	}

	public void setListaPregao(List<DiaPregao> listaPregao) {
		this.listaPregao = listaPregao;
	}

	



	@Override
	public void setAtivoAcaoCorrente(AtivoAcao item) {
		this.ativoAcao = item;
	}

	@Override
	public AtivoAcao getAtivoAcaoCorrente() {
		return this.ativoAcao;
	}

	@Override
	public void setCodigoGrupoAcao(String codigo) {
		this.codigoGrupoAcao = codigo;
	}

	@Override
	public String getCodigoGrupoAcao() {
		return this.codigoGrupoAcao;
	}

	@Override
	public String getCodigoRegraProjecao() {
		return this.codigoRegraProjecao;
	}

	@Override
	public void setCodigoRegraProjecao(String codigoRegra) {
		this.codigoRegraProjecao = codigoRegra;
	}
	
	
	


}
