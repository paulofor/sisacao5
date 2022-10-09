package sisacao.tesourodireto.loopback;

import java.util.List;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.VoidCallback;

import br.com.digicom.sisacao.modelo.TesouroDiretoCotacao;
import br.com.digicom.sisacao.repositorio.RepositorioTesouroDiretoCotacao;
import sisacao.cdb.daobase.ColetorCDBDaoBase;
import sisacao.tesourodireto.daobase.DatasetColetorTesouro;

public class TesouroDiretoCotacao_InsereLista extends ColetorCDBDaoBase{

	
	RestAdapter adapterItem = new RestAdapter(urlLoopback);
	protected final RepositorioTesouroDiretoCotacao rep = 
			adapterItem.createRepository(RepositorioTesouroDiretoCotacao.class);
	
	public TesouroDiretoCotacao_InsereLista() {
		super();
	}
	
	
	
	@Override
	protected void executaImpl() {

		DatasetColetorTesouro ds = (DatasetColetorTesouro) getComum();
		List<TesouroDiretoCotacao> listaTesouro = ds.getListaTesouroDiretoCotacao();
		rep.insereLista(listaTesouro, new VoidCallback() {

			@Override
			public void onSuccess() {
				finalizar();
			}

			@Override
			public void onError(Throwable t) {
				onErrorBase(t);
			}});
		
		
	}
		
}
