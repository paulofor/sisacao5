package sisacao.fii.parser.dado;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.sisacao.modelo.FundoImobiliario;

public class FundoImobiliarioDado implements IDadosParse{
	
	private List<FundoImobiliario> listaFundo;
	private FundoImobiliario fundo;
	
	public FundoImobiliarioDado() {
		listaFundo = new ArrayList<FundoImobiliario>();
	}
	
	
	
	public List<FundoImobiliario> getLista() {
		return this.listaFundo;
	}

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setJson(JSONObject json) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	public void addFundo(String ticker, String nome, String segmento, String administrador) {
		FundoImobiliario novo = new FundoImobiliario();
		novo.setAdministrador(administrador);
		novo.setTicker(ticker);
		novo.setNome(nome);
		novo.setSegmento(segmento);
		this.listaFundo.add(novo);
	}



	public FundoImobiliario getFundo() {
		return fundo;
	}



	public void setFundo(FundoImobiliario fundo) {
		this.fundo = fundo;
	}

}
