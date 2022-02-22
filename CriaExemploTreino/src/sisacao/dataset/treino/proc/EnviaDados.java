package sisacao.dataset.treino.proc;

import com.strongloop.android.loopback.RestAdapter;

import br.com.digicom.sisacao.modelo.ExemploTreinoAcao;
import br.com.digicom.sisacao.modelo.RegraProjecao;
import br.com.digicom.sisacao.repositorio.RepositorioExemploTreinoAcao;

public class EnviaDados {

	private String URL_SISACAO_DATASET = "http://vps-40d69db1.vps.ovh.ca:22005/api";
	
	private RestAdapter adapter = new RestAdapter(URL_SISACAO_DATASET); 
	protected RepositorioExemploTreinoAcao rep = adapter.createRepository(RepositorioExemploTreinoAcao.class);
	
	
	public void enviaDia(String ticker, RegraProjecao regraProjecao, DadosTreino dadoTreino) {
		ExemploTreinoAcao exemplo = new ExemploTreinoAcao();
		exemplo.setCampoX(dadoTreino.getSaidaX());
		exemplo.setCampoY(dadoTreino.getSaidaY());
		exemplo.setTicker(ticker);
		exemplo.setRegraProjecaoId(regraProjecao.getId());
		exemplo.setDiaNumInicio(dadoTreino.getDiaNumInicio());
		exemplo.setDiaNumPrevisao(dadoTreino.getDiaNumPrevisao());
	}
}
