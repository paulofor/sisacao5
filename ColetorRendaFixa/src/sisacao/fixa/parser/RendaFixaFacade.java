package sisacao.fixa.parser;

import com.strongloop.android.loopback.RestAdapter;

import br.com.digicom.parse.ExecutadorParse;
import br.com.digicom.parse.callback.ICallbackParse;
import br.com.digicom.sisacao.app.Loopback;
import br.com.digicom.sisacao.repositorio.RepositorioFundoImobiliario;
import sisacao.cdb.processamento.ItemRendaFixaDado;
import sisacao.cdb.processamento.ListaRendaFixaYubbCallback;

public class RendaFixaFacade {
	
	
	static RestAdapter adapter = new RestAdapter(Loopback.URL_SISACAO);
	static RepositorioFundoImobiliario repFundoImobiliario = adapter.createRepository(RepositorioFundoImobiliario.class);


	public void obtemListaRendaFixa() {
		// TODO Auto-generated method stub
		ExecutadorParse exec = new ExecutadorParse();
		ICallbackParse callback = new ListaRendaFixaYubbCallback();
		ItemRendaFixaDado dado = new ItemRendaFixaDado();
		callback.setDados(dado);
		exec.setCallbackParse(callback);
		exec.setDadosParse(dado);
		exec.executa();
	}

}
