package br.inf.digicom.simulacao.regra;

import br.com.digicom.sisacao.modelo.RegraSimulacao;
import br.inf.digicom.simulacao.IRegraPontoEntrada;

public class FabricaRegra {
	
	private final static String PACOTE_REGRA = "br.inf.digicom.simulacao.regra";
	public final static int TICKER_DIA = 20;
	
	public static synchronized IRegraPontoEntrada criaRegra(RegraSimulacao regra) {
		String nomeRegra = PACOTE_REGRA + "." + regra.getNomeClasse();
		IRegraPontoEntrada saida = null;
		try {
			saida = (IRegraPontoEntrada) Class.forName(nomeRegra).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return saida;
	}

}
