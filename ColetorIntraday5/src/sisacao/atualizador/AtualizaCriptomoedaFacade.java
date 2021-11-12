package sisacao.atualizador;

import br.com.digicom.parse.ExecutadorParse;
import br.com.digicom.parse.callback.ICallbackParse;
import sisacao.atualizador.callback.CriptomoedaListaCallback;
import sisacao.atualizador.callback.CriptomoedaListaDado;


public class AtualizaCriptomoedaFacade {

	
	public void obtemListaCripomoeda() {
		ExecutadorParse exec = new ExecutadorParse();
		ICallbackParse callback = new CriptomoedaListaCallback();
		CriptomoedaListaDado dado = new CriptomoedaListaDado();
		callback.setDados(dado);
		exec.setCallbackParse(callback);
		exec.setDadosParse(dado);
		exec.executa();

	}
}
