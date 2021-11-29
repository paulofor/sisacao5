package sisacao.intraday.coletor.parse.dados;

import org.json.JSONObject;

import com.strongloop.android.loopback.RestAdapter;

import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.sisacao.app.Loopback;
import br.com.digicom.sisacao.repositorio.RepositorioCriptomoedaBase;

public class CotacaoIntradayFoxbit implements IDadosParse{
	
	RestAdapter adapter = new RestAdapter(Loopback.URL_SISACAO);
	
	RepositorioCriptomoedaBase.AtivoCriptomoedaRepository repCripto = adapter
			.createRepository(RepositorioCriptomoedaBase.AtivoCriptomoedaRepository.class);

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setJson(JSONObject json) {
		// TODO Auto-generated method stub
		
	}

}
