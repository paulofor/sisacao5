package br.inf.digicom.loopback.comum.ativoacao;

import java.util.List;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.digicom.sisacao.repositorio.RepositorioAcaoBase;
import br.inf.digicom.loopback.comum.DaoBaseComum;
import br.inf.digicom.loopback.comum.DaoBaseException;

public class AtivoAcao_ListaPorNomeGrupo extends DaoBaseComum {

	public static String NOME = "AtivoAcao_ListaPorNomeGrupo";
	
	RestAdapter adapterItem = new RestAdapter(urlLoopback);
	protected final RepositorioAcaoBase.AtivoAcaoRepository rep = 
			adapterItem.createRepository(RepositorioAcaoBase.AtivoAcaoRepository.class);
	
	
	@Override
	protected long getTempo() {
		return 2000;
	}

	@Override
	protected void executaImpl() {
		final AtivoAcao_ListaPorNomeGrupoDS ds = (AtivoAcao_ListaPorNomeGrupoDS) getComum();
		if (ds.getCodigoGrupoAcao()==null) {
			throw new DaoBaseException("CodigoGrupoAcao não encontrado no dataset");
		}
		this.rep.listaPorNomeGrupo(ds.getCodigoGrupoAcao(), new  ListCallback<AtivoAcao>() {

			@Override
			public void onSuccess(List<AtivoAcao> objects) {
				/*
				AtivoAcao debug = new AtivoAcao();
				debug.setTicker("CESP6");
				ds.setAtivoAcaoCorrente(debug);
				executaProximo();
				*/
				
				System.out.println("Ativos: " + objects.size());
				for (AtivoAcao corrente: objects) {
					ds.setAtivoAcaoCorrente(corrente);
					executaProximoSemFinalizar();
				}
				finalizar();
				
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
