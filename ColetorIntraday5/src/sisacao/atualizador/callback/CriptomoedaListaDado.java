package sisacao.atualizador.callback;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONObject;

import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.sisacao.modelo.AtivoCriptomoeda;

public class CriptomoedaListaDado implements IDadosParse{

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

}
