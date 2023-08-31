package gerador.obtemacaousa.loopback;


import br.com.gersis.daobase.IDatasetComum;
import br.com.gersis.loopback.modelo.*;
import java.util.List;

public class DatasetAplicacao  implements IDatasetComum {
	private List<AtivoAcaoUsa> listaAcao;


	public void setListaAcao(List<AtivoAcaoUsa> valor) { 
		this.listaAcao = valor;
	}
	public List<AtivoAcaoUsa> getListaAcao() { 
		return this.listaAcao;
	}
}
