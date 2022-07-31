package sisacao.cdb.loopback;

import java.util.List;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.VoidCallback;

import br.com.digicom.sisacao.modelo.RendaFixaPrivada;
import br.com.digicom.sisacao.repositorio.RepositorioRendaFixaPrivada;
import sisacao.cdb.daobase.ColetorCDBDaoBase;
import sisacao.cdb.daobase.DatasetColetorCDB;

public class RendaFixaPrivada_InsereSeNaoExisteFixaPrivada extends ColetorCDBDaoBase{

	
	RestAdapter adapterItem = new RestAdapter(urlLoopback);
	protected final RepositorioRendaFixaPrivada rep = 
			adapterItem.createRepository(RepositorioRendaFixaPrivada.class);
	
	
	@Override
	protected void executaImpl() {
		DatasetColetorCDB ds = (DatasetColetorCDB) getComum();
		List<RendaFixaPrivada> listaCdb = ds.getListaRendaFixaPrivada();
		rep.insereSeNaoExisteFixaPrivada(listaCdb, new VoidCallback() {

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
