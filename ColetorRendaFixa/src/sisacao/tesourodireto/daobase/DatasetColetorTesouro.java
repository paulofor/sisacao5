package sisacao.tesourodireto.daobase;

import java.util.List;

import br.com.digicom.sisacao.modelo.TesouroDiretoCotacao;
import br.inf.digicom.loopback.IDatasetComum;

public class DatasetColetorTesouro implements IDatasetComum{
	
	
	List<TesouroDiretoCotacao> listaTesouroDiretoCotacao;

	public List<TesouroDiretoCotacao> getListaTesouroDiretoCotacao() {
		return listaTesouroDiretoCotacao;
	}

	public void setListaTesouroDiretoCotacao(List<TesouroDiretoCotacao> listaTesouroDiretoCotacao) {
		this.listaTesouroDiretoCotacao = listaTesouroDiretoCotacao;
	}
	
	
	
	
	
	
	

}
