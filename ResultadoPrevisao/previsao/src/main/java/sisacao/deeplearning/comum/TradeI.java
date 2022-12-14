package sisacao.deeplearning.comum;

import br.com.digicom.sisacao.modelo.CotacaoDiarioAcao;

public interface TradeI {

	String getTicker();

	int getDiaNumSaida();

	int getDiaNumEntrada();

	Object getPrevisao();

	double limiteInferior();

	double limiteSuperior();

	void saidaInferior(CotacaoDiarioAcao cotacao);

	void saidaSuperior(CotacaoDiarioAcao cotacao);
	
	boolean getFechado();

}
