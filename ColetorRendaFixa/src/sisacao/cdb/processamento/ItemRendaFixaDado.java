package sisacao.cdb.processamento;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.sisacao.modelo.RendaFixaPrivada;
import sisacao.cdb.daobase.DatasetColetorCDB;
import sisacao.cdb.loopback.RendaFixaPrivada_InsereSeNaoExisteFixaPrivada;

public class ItemRendaFixaDado implements IDadosParse{
	
	
	private DatasetColetorCDB ds = null;
	private List<RendaFixaPrivada> lista = new ArrayList<RendaFixaPrivada>();
	private RendaFixaPrivada_InsereSeNaoExisteFixaPrivada srv = new RendaFixaPrivada_InsereSeNaoExisteFixaPrivada();

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setJson(JSONObject json) {
		// TODO Auto-generated method stub
		
	}

	public void setDs(DatasetColetorCDB comum) {
		this.ds = comum;
	}

	public void addItem(RendaFixaPrivada cdb) {
		cdb.converteDataParaServer();
		lista.add(cdb);
	}

	public void finaliza() {
		System.out.println("Qtde item:" + lista.size());
		ds.setListaRendaFixaPrivada(lista);
		this.srv.setComum(ds);
		this.srv.executa();
		this.lista.clear();
		
	}

}
