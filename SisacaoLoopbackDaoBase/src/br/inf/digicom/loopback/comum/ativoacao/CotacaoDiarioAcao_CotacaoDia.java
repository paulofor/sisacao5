package br.inf.digicom.loopback.comum.ativoacao;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ObjectCallback;

import br.com.digicom.sisacao.modelo.CotacaoDiarioAcao;
import br.com.digicom.sisacao.repositorio.RepositorioAcaoBase;
import br.inf.digicom.loopback.comum.DaoBaseComum;
import br.inf.digicom.loopback.comum.DaoBaseException;

public class CotacaoDiarioAcao_CotacaoDia extends DaoBaseComum{

	
public static String NOME = "CotacaoDiarioAcao_CotacaoDia";
	
	RestAdapter adapterItem = new RestAdapter(urlLoopback);
	protected final RepositorioAcaoBase.CotacaoDiarioAcaoRepository rep = 
			adapterItem.createRepository(RepositorioAcaoBase.CotacaoDiarioAcaoRepository.class);
	
	
	@Override
	protected long getTempo() {
		return 2000;
	}

	@Override
	protected void executaImpl() {
		final CotacaoDiarioAcao_CotacaoDiaDS ds = (CotacaoDiarioAcao_CotacaoDiaDS) getComum();
		if (ds.getDiaNum()==0) {
			throw new DaoBaseException("DiaNum não encontrado no dataset");
		}
		if (ds.getTicker()==null) {
			throw new DaoBaseException("Ticker não encontrado no dataset");
		}
		this.rep.cotacaoDia(ds.getTicker(), ds.getDiaNum(), new  ObjectCallback<CotacaoDiarioAcao>() {

			@Override
			public void onSuccess(CotacaoDiarioAcao cotacaoDia) {
				ds.setCotacaoDiarioAcao(cotacaoDia);
				executaProximo();
			}

			@Override
			public void onError(Throwable t) {
				onErrorBase(t);
			}
			
		});

	}

	@Override
	protected String getNome() {
		return NOME;
	}



}
