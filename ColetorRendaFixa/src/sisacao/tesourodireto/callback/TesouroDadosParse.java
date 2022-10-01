package sisacao.tesourodireto.callback;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONObject;

import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.sisacao.modelo.TesouroDiretoCotacao;
import sisacao.tesourodireto.daobase.DatasetColetorTesouro;

public class TesouroDadosParse  implements IDadosParse {

	

	
	private DatasetColetorTesouro ds = null;
	private List<TesouroDiretoCotacao> listaCotacao = new LinkedList<TesouroDiretoCotacao>();
	//private CotacaoIntradayAcao_InsereValorHorario proc = new CotacaoIntradayAcao_InsereValorHorario();
	
	public DatasetColetorTesouro getDs() {
		return ds;
	}
	public void setDs(DatasetColetorTesouro ds) {
		this.ds = ds;
	}
	
	@Override
	public void setServidor(String paramString) {
	}
	@Override
	public void setJson(JSONObject json) {
	
	}
	
	public void adicionaCotacao(TesouroDiretoCotacao cotacao) {
		this.listaCotacao.add(cotacao);
	}
	
	public void enviaValor(Double valor, String horario) {
		/*
		this.cotacao.setDataHoraNegStr(horario);
		this.cotacao.setValor(valor);
		this.cotacao.setTicker(this.getTicker());
		this.ds.setCotacaoIntradayAcao(cotacao);
		proc.setComum(ds);
		proc.executa();
		*/
	}

}
