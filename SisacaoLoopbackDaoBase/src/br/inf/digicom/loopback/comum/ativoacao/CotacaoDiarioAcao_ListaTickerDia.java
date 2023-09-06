package br.inf.digicom.loopback.comum.ativoacao;

import java.util.ArrayList;
import java.util.List;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.sisacao.modelo.CotacaoDiarioAcao;
import br.com.digicom.sisacao.repositorio.RepositorioAcaoBase;
import br.inf.digicom.loopback.comum.DaoBaseComum;
import br.inf.digicom.loopback.comum.DaoBaseException;

public class CotacaoDiarioAcao_ListaTickerDia extends DaoBaseComum{

	
public static String NOME = "CotacaoDiarioAcao_ListaTickerDia";
	
	RestAdapter adapterItem = new RestAdapter(urlLoopback);
	protected final RepositorioAcaoBase.CotacaoDiarioAcaoRepository rep = 
			adapterItem.createRepository(RepositorioAcaoBase.CotacaoDiarioAcaoRepository.class);
	
	
	@Override
	protected long getTempo() {
		return 2000;
	}

	@Override
	protected void executaImpl() {
		final CotacaoDiarioAcao_ListaTickerDiaDS ds = (CotacaoDiarioAcao_ListaTickerDiaDS) getComum();
		if (ds.getDiaNum()==0) {
			throw new DaoBaseException("DiaNum não encontrado no dataset");
		}
		if (ds.getListaTicker()==null) {
			throw new DaoBaseException("Ticker não encontrado no dataset");
		}
		if (ds.getListaTicker().size()==0) {
			ds.setListaCotacaoDiario(new ArrayList<CotacaoDiarioAcao>());
			executaProximo();
		} else {
			this.rep.listaTickerDia(ds.getListaTicker(), ds.getDiaNum(), new  ListCallback<CotacaoDiarioAcao>() {
				@Override
				public void onError(Throwable t) {
					onErrorBase(t);
				}
	
				@Override
				public void onSuccess(List<CotacaoDiarioAcao> objects) {
					ds.setListaCotacaoDiario(objects);
					executaProximo();
				}
				
			});
		}

	}

	@Override
	protected String getNome() {
		return NOME;
	}



}
