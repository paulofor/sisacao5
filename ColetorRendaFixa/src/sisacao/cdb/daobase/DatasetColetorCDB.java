package sisacao.cdb.daobase;

import java.util.List;

import br.com.digicom.sisacao.modelo.RendaFixaPrivada;
import br.inf.digicom.loopback.IDatasetComum;

public class DatasetColetorCDB implements IDatasetComum{
	
	private List<RendaFixaPrivada> listaRendaFixaPrivada;

	public List<RendaFixaPrivada> getListaRendaFixaPrivada() {
		return listaRendaFixaPrivada;
	}

	public void setListaRendaFixaPrivada(List<RendaFixaPrivada> listaRendaFixaPrivada) {
		this.listaRendaFixaPrivada = listaRendaFixaPrivada;
	}
	
	
	
	
	

}
