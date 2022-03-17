package br.inf.digicom.simulacao.validacao;

import java.util.List;

import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.inf.digicom.loopback.DaoBase;

public class AtivoAcao_SimulacaoComMonitor extends DaoBase{

	private Integer idPeriodo;
	
	
	@Override
	protected void executaImpl() {
		this.repAcao.simulacaoComMonitor(idPeriodo, new ListCallback<AtivoAcao>() {

			@Override
			public void onSuccess(List<AtivoAcao> objects) {
				for (AtivoAcao acao : objects) {
					System.out.println("Ticker: " + acao.getTicker());
				}
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}});
	}

	public void setIdPeriodo(Integer id) {
		this.idPeriodo = id;
	}
}
