package sisacao.fii.parser.dado;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.sisacao.modelo.AluguelFundoImobiliario;
import br.com.digicom.sisacao.modelo.FundoImobiliario;
import sisacao.fii.parser.FundoImobiliarioFacade;

public class AluguelFIIDado implements IDadosParse{
	
	private FundoImobiliario fundo;
	private List<AluguelFundoImobiliario> listaAluguel;
	
	public AluguelFIIDado() {
		listaAluguel = new ArrayList<AluguelFundoImobiliario>();
	}

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setJson(JSONObject json) {
		// TODO Auto-generated method stub
		
	}

	public void setFundo(FundoImobiliario fundo) {
		this.fundo = fundo;
	}

	public FundoImobiliario getFundo() {
		return this.fundo;
	}

	public void addAluguel(AluguelFundoImobiliario aluguel) {
		listaAluguel.add(aluguel);
	}

	public void finaliza() {
		System.out.println("Vai enviar servidor");
		FundoImobiliarioFacade.insereListaAluguelPorItem(this.listaAluguel);
	}
}
