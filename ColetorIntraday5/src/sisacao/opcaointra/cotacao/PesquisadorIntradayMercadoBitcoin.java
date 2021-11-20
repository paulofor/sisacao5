package sisacao.opcaointra.cotacao;

import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.ExecutadorParseApache2;
import br.com.digicom.parse.PesquisadorTimer;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.sisacao.modelo.AtivoCriptomoeda;
import sisacao.atualizador.callback.CriptomoedaBitcoinCallback;

public class PesquisadorIntradayMercadoBitcoin extends PesquisadorTimer{
	
	private ExecutadorParseApache2 execMB;
	
	public PesquisadorIntradayMercadoBitcoin() {
		this.execMB = new ExecutadorParseApache2();
	}

	public void inicializa(List<AtivoCriptomoeda> objects, String diaAtual) {
		// TODO Auto-generated method stub
		System.out.println("Inicializando MercadoBitcoin");
		CriptomoedaBitcoinCallback callback = getCallback();
		IDadosParse manipulador = getManipulador(objects,diaAtual);
		callback.setLista(objects);
		//super.setCallbackParse(callback);
		//super.setDadosParse(manipulador);
		this.execMB.setCallbackParse(callback);
		this.execMB.setDadosParse(manipulador);
	}

	private CriptomoedaBitcoinCallback getCallback() {
		return new CriptomoedaBitcoinCallback();
	}
	
	private IDadosParse getManipulador(List<AtivoCriptomoeda> objects, String data) {
		return new CotacaoIntradayManipuladorMercadoBitcoin(data);
	}
	public void run() {
		//executadorParse.executa();
		try {
			this.execMB.executa();
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

}
