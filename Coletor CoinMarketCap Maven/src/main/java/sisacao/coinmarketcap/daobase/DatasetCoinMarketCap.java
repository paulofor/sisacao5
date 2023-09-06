package sisacao.coinmarketcap.daobase;

import java.util.List;

import br.com.digicom.sisacao.modelo.CotacaoIntradayCoinmarketcap;
import br.inf.digicom.loopback.IDatasetComum;

public class DatasetCoinMarketCap  implements IDatasetComum{
	
	private List<CotacaoIntradayCoinmarketcap> listaCotacao;

	public List<CotacaoIntradayCoinmarketcap> getListaCotacao() {
		return listaCotacao;
	}

	public void setListaCotacao(List<CotacaoIntradayCoinmarketcap> listaCotacao) {
		this.listaCotacao = listaCotacao;
	}

	
}
