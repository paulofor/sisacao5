package sisacao.dataset.treino.dao;

import com.strongloop.android.loopback.RestAdapter;

import br.com.digicom.sisacao.repositorio.RepositorioDiaPregao;
import br.com.digicom.sisacao.repositorio.RepositorioRegraProjecao;
import sisacao.dataset.treino.singleton.DatasetComum;

public abstract class DaoBase {
	
	private String URL_SISACAO_DATASET = "http://vps-40d69db1.vps.ovh.ca:22005/api";
	
	private RestAdapter adapter = new RestAdapter(URL_SISACAO_DATASET); 
	protected RepositorioDiaPregao repDiaPregao = adapter.createRepository(RepositorioDiaPregao.class);
	protected RepositorioRegraProjecao repRegraProjecao = adapter.createRepository(RepositorioRegraProjecao.class);

	
	private DatasetComum comum = null;
	
	
	
	public abstract void executa();
	
	protected void onError(Throwable t) {
		System.out.println("Erro[" + this + "] : " + t.getMessage());
	}

	public DatasetComum getComum() {
		return comum;
	}

	public void setComum(DatasetComum comum) {
		this.comum = comum;
	}
}
