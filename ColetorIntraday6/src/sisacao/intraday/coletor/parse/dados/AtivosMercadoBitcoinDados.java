package sisacao.intraday.coletor.parse.dados;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ObjectCallback;

import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.sisacao.app.Loopback;
import br.com.digicom.sisacao.modelo.AtivoCriptomoeda;
import br.com.digicom.sisacao.repositorio.RepositorioCriptomoedaBase;

public class AtivosMercadoBitcoinDados  implements IDadosParse{
	
	
	RestAdapter adapter = new RestAdapter(Loopback.URL_SISACAO);
	
	RepositorioCriptomoedaBase.AtivoCriptomoedaRepository repCripto = adapter
			.createRepository(RepositorioCriptomoedaBase.AtivoCriptomoedaRepository.class);

	// http://api.mercadobitcoin.net/api/v4/symbols
	
	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setJson(JSONObject json) {
		// TODO Auto-generated method stub
		List<AtivoCriptomoeda> lista = new LinkedList<AtivoCriptomoeda>();
		try {
			JSONArray moedas = json.getJSONArray("base-currency");
			JSONArray descricao = json.getJSONArray("description");
			for (int i=0;i<moedas.length();i++) {
				String nome = moedas.getString(i);
				String desc = descricao.getString(i);
				System.out.println(nome + " - " + desc);
				if ((desc.toUpperCase().indexOf("PRECATORIO")==-1) &&
					(desc.toUpperCase().indexOf("PRECATÓRIO")==-1) &&
					(desc.toUpperCase().indexOf("CONSORCIO")==-1) &&
					(desc.toUpperCase().indexOf("CONSÓRCIO")==-1)) {
					System.out.println("Entrou");
					AtivoCriptomoeda ativo = new AtivoCriptomoeda();
					ativo.setTicker(nome);
					ativo.setNome(desc);
					lista.add(ativo);	
				}

			}
		} catch (JSONException e) {
			e.printStackTrace();
		};
		repCripto.atualizaMercadoBitcoin(lista, new ObjectCallback<AtivoCriptomoeda>() {

			@Override
			public void onSuccess(AtivoCriptomoeda object) {
				// TODO Auto-generated method stub
				System.out.println("Sucessso");
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				System.out.println("Erro");
			}

		});
	}

}
