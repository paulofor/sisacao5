package coletorjava.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletorjava.modelo.*;

// Gera??o autom?tica n?o alterar
public interface OpcaoSisacaoGeralAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	// Montador tradicional
	public Ticker getTickerReferenteA(boolean lazyLoader);
	public void setTickerReferenteA(Ticker item);
	//public void setTickerReferenteAComReversao(Ticker item);
	
	// Montador alternativo
	
	public void addListaTicker_ReferenteA(Ticker item); 
	public Ticker getCorrenteTicker_ReferenteA();
	
		
	
	// Sem Chave Estrangeira
	
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
