package sisacao.tesourodireto.callback;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONObject;

import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.sisacao.modelo.TesouroDiretoCotacao;
import br.inf.digicom.loopback.util.DataUtils;
import sisacao.tesourodireto.daobase.DatasetColetorTesouro;
import sisacao.tesourodireto.loopback.TesouroDiretoCotacao_InsereLista;

public class TesouroDadosParse  implements IDadosParse {

	

	
	private DatasetColetorTesouro ds = null;
	private List<TesouroDiretoCotacao> listaCotacao = new LinkedList<TesouroDiretoCotacao>();
	private TesouroDiretoCotacao_InsereLista proc = new TesouroDiretoCotacao_InsereLista();
	
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
	public void inicializaLista() {
		this.listaCotacao.clear();
	}
	
	public void adicionaCotacao(TesouroDiretoCotacao cotacao) {
		if (cotacao.ativo()) { 
			System.out.println(cotacao);
			cotacao.setDiaNum(DataUtils.getDiaNumCorrente());
			cotacao.setDataHoraStr(DataUtils.getHoraCorrente());
			this.listaCotacao.add(cotacao);
		}
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
	public void enviaDados() {
		this.ds.setListaTesouroDiretoCotacao(listaCotacao);
		this.proc.setComum(ds);
		this.proc.executa();
	}

}
