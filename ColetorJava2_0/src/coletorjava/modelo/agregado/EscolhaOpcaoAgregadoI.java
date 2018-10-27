package coletorjava.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletorjava.modelo.*;

// Gera??o autom?tica n?o alterar
public interface EscolhaOpcaoAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	// Montador tradicional
	public Ticker getTickerReferenteA(boolean lazyLoader);
	public void setTickerReferenteA(Ticker item);
	//public void setTickerReferenteAComReversao(Ticker item);
	
	// Montador alternativo
	
	public void addListaTicker_ReferenteA(Ticker item); 
	public Ticker getCorrenteTicker_ReferenteA();
	
		
	// Montador tradicional
	public OpcaoSisacao getOpcaoSisacaoEscolha(boolean lazyLoader);
	public void setOpcaoSisacaoEscolha(OpcaoSisacao item);
	//public void setOpcaoSisacaoEscolhaComReversao(OpcaoSisacao item);
	
	// Montador alternativo
	
	public void addListaOpcaoSisacao_Escolha(OpcaoSisacao item); 
	public OpcaoSisacao getCorrenteOpcaoSisacao_Escolha();
	
		
	// Montador tradicional
	public DiaPregao getDiaPregaoReferenteA(boolean lazyLoader);
	public void setDiaPregaoReferenteA(DiaPregao item);
	//public void setDiaPregaoReferenteAComReversao(DiaPregao item);
	
	// Montador alternativo
	
	public void addListaDiaPregao_ReferenteA(DiaPregao item); 
	public DiaPregao getCorrenteDiaPregao_ReferenteA();
	
		
	
	// Sem Chave Estrangeira
	
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
