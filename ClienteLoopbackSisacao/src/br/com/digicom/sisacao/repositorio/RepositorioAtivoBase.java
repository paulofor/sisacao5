package br.com.digicom.sisacao.repositorio;

import java.util.HashMap;
import java.util.Map;

import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.callbacks.JsonArrayParser;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.remoting.adapters.RestContractItem;

import br.com.digicom.sisacao.modelo.AtivoAcao;


public class RepositorioAtivoBase {

		
	public static class AtivoAcaoRepository extends ModelRepository<AtivoAcao> {
		public AtivoAcaoRepository() {
			super("AtivoAcao", AtivoAcao.class);
		}
		@Override
		protected String verificaNomeUrl(String nome) {
			return "AtivoAcaos";
		}
		public void listaColetaIntraday(final ListCallback<AtivoAcao> callback) {
			RestContractItem contrato = new RestContractItem("NotificacaoApps/listaColetaIntraday","POST");
			this.getRestAdapter().getContract().addItem(contrato, "NotificacaoApp.listaColetaIntraday");
	        Map<String, Object> params = new HashMap<String, Object>();
	        invokeStaticMethod("listaColetaIntraday", params,   new JsonArrayParser<AtivoAcao>(this, callback));
			
		}

		
	}
}
