package sisacao.atualizador.callback;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONObject;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.VoidCallback;

import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.sisacao.app.Loopback;
import br.com.digicom.sisacao.modelo.AtivoCriptomoeda;
import br.com.digicom.sisacao.repositorio.RepositorioCriptomoedaBase;

public class CriptomoedaListaDado implements IDadosParse{
	
	
	RestAdapter adapter = new RestAdapter(Loopback.URL_SISACAO);
	
	RepositorioCriptomoedaBase.AtivoCriptomoedaRepository repCripto = adapter
			.createRepository(RepositorioCriptomoedaBase.AtivoCriptomoedaRepository.class);

	private List<AtivoCriptomoeda> listaAtivo = null;
	
	public List<AtivoCriptomoeda> getLista() {
		return this.listaAtivo;
	}
	public CriptomoedaListaDado() {
		listaAtivo = new LinkedList<AtivoCriptomoeda>();
	}
	
	public void adicionaAtivo(AtivoCriptomoeda ativo) {
		this.listaAtivo.add(ativo);
	}
	
	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setJson(JSONObject json) {
		// TODO Auto-generated method stub
		
	}
	
	public void enviaDados() {
		repCripto.insereSeNaoExisteLista(this.listaAtivo, new VoidCallback() {
			@Override
			public void onSuccess() {
				// TODO Auto-generated method stub
				System.out.println("Enviou lista");
			}
			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}});
	}

}
