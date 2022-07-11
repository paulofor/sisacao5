package br.com.digicom.sisacao.repositorio;

import java.util.HashMap;
import java.util.Map;

import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.callbacks.JsonArrayParser;
import com.strongloop.android.loopback.callbacks.JsonObjectParser;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.ObjectCallback;
import com.strongloop.android.remoting.adapters.RestContractItem;

import br.com.digicom.sisacao.modelo.FundoImobiliario;

public class RepositorioFundoImobiliario  extends ModelRepository<FundoImobiliario>{

	public RepositorioFundoImobiliario() {
		super("FundoImobiliario", FundoImobiliario.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "FundoImobiliarios";
	}
	
	public void insereSeNaoExiste(final FundoImobiliario fundo, final ObjectCallback<FundoImobiliario> callback ) {
		RestContractItem contrato = new RestContractItem("FundoImobiliarios/insereSeNaoExiste","POST");
		this.getRestAdapter().getContract().addItem(contrato, "FundoImobiliario.insereSeNaoExiste");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("fundo", fundo.jSON());
        invokeStaticMethod("insereSeNaoExiste", params,   new JsonObjectParser<FundoImobiliario>(this, callback));
	}

	public void listaCompleta(final ListCallback<FundoImobiliario> callback ) {
		RestContractItem contrato = new RestContractItem("FundoImobiliarios/listaAluguel","GET");
		this.getRestAdapter().getContract().addItem(contrato, "FundoImobiliario.listaAluguel");
        Map<String, Object> params = new HashMap<String, Object>();
        invokeStaticMethod("listaAluguel", params,   new JsonArrayParser<FundoImobiliario>(this, callback));
	}
	
	public void listaIntradayFundo(final ListCallback<FundoImobiliario> callback ) {
		RestContractItem contrato = new RestContractItem("FundoImobiliarios/listaIntradayFundo","GET");
		this.getRestAdapter().getContract().addItem(contrato, "FundoImobiliario.listaIntradayFundo");
        Map<String, Object> params = new HashMap<String, Object>();
        invokeStaticMethod("listaIntradayFundo", params,   new JsonArrayParser<FundoImobiliario>(this, callback));
	}
}
