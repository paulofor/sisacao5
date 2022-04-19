package br.inf.digicom.simulacao.regraProjecao;

import com.strongloop.android.loopback.callbacks.ObjectCallback;

import br.com.digicom.sisacao.modelo.CotacaoIntradayAcaoResultado;
import br.inf.digicom.loopback.DaoBase;

public class CotacaoIntradayAcaoResultado_DataInicialTickerRegra extends ExecutorRegraProjecao {
	
	

	@Override
	protected void executaImpl() {
		final DatasetRegraProjecao ds = (DatasetRegraProjecao) getComum();
		String ticker = ds.getAtivoAcaoCorrente().getTicker();
		long idRegra = ds.getRegraProjecao().getId();
		repResultado.dataInicialTickerRegra(ticker, idRegra,  new ObjectCallback<CotacaoIntradayAcaoResultado>() {

			@Override
			public void onSuccess(CotacaoIntradayAcaoResultado resultado) {
				System.out.println("** Data Inicial = " + resultado.getDiaNum());
				ds.setDataInicial(resultado);
				executaProximo();
			}

			@Override
			public void onError(Throwable t) {
				onErrorBase(t);
			}});
	}

	@Override
	protected DaoBase getProximo() {
		return new br.inf.digicom.loopback.comum.diapregao.DiaPregao_ObtemIntradayResultadoValor();
	}

	
	/*
	
	AtivoAcao ticker;
	RegraProjecao regraProjecao;
	
	

	public void setTicker(AtivoAcao ativo) {
		this.ticker = ativo;
	}


	public void setRegraProjecao(RegraProjecao regraProjecao) {
		this.regraProjecao = regraProjecao;
	}
	
	public boolean concluido = false;
	public void executa() {
		concluido = false;
		repResultado.dataInicialTickerRegra(ticker.getTicker(), regraProjecao.getId(), new ObjectCallback<CotacaoIntradayAcaoResultado>() {

			@Override
			public void onSuccess(CotacaoIntradayAcaoResultado resultado) {
				// TODO Auto-generated method stub
				DiaPregao_ObtemIntradayResultadoValor processador = new DiaPregao_ObtemIntradayResultadoValor();
				processador.setDataNumInicio(resultado.getDiaNum());
				processador.setTicker(ticker.getTicker());
				processador.setRegraProjecao(regraProjecao);
				processador.executa();
				concluido = true;
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				t.printStackTrace();
				
			}});
		while (!concluido) {
			try {
				Thread.sleep(Constantes.SLEEP_1_REGRA_PROJECAO__OBTEM_PROCESSANDO);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	*/

	
}
