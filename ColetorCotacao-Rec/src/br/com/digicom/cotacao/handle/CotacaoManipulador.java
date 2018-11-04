package br.com.digicom.cotacao.handle;

import org.json.JSONObject;

import br.com.digicom.cotacao.vo.Cotacao;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.util.DatasUtils;

public class CotacaoManipulador implements IDadosParse {
	private Cotacao cotacao;

	public Cotacao getCotacao() {
		return this.cotacao;
	}

	public void setCotacao(Cotacao cotacao) {
		this.cotacao = cotacao;
	}

	public void gravaCotacao() {
		DaoThread daoTh = new DaoThread();
		daoTh.setCotacao(this.cotacao);

		daoTh.start();
	}

	public void setServidor(String arg0) {
	}

	public static String qtde(String numero) {
		// Melhorar para testar se é numerico, senao retorna 0
		if (numero==null) return  "0";
		if ("-".equals(numero)) return "0";
		StringBuffer saida = new StringBuffer("");
		for (int i = 0; i < numero.length(); i++) {
			if (numero.charAt(i) == '.')
				continue;
			saida.append(numero.charAt(i));
		}
		return saida.toString();
	}

	public static String valor(String numero) {
		if (numero!=null)
			return numero.replace(",", ".");
		else
			return "";
	}

	public static String data_hoje() {
		return DatasUtils.getData();
	}

	@Override
	public void setJson(JSONObject json) {
		// TODO Auto-generated method stub
		
	}
}

/*
 * Location: D:\Java-Recuperacao\coletorcotacao.jar Qualified Name:
 * br.com.digicom.cotacao.handle.CotacaoManipulador JD-Core Version: 0.6.0
 */