package coletorjava.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletorjava.modelo.*;

// Gera??o autom?tica n?o alterar
public interface OpcaoSisacaoAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	// Montador tradicional
	public OpcaoSisacaoSerie getOpcaoSisacaoSeriePertenceA(boolean lazyLoader);
	public void setOpcaoSisacaoSeriePertenceA(OpcaoSisacaoSerie item);
	//public void setOpcaoSisacaoSeriePertenceAComReversao(OpcaoSisacaoSerie item);
	
	// Montador alternativo
	
	public void addListaOpcaoSisacaoSerie_PertenceA(OpcaoSisacaoSerie item); 
	public OpcaoSisacaoSerie getCorrenteOpcaoSisacaoSerie_PertenceA();
	
		
	// Montador tradicional
	public Ticker getTickerDerivativoDe(boolean lazyLoader);
	public void setTickerDerivativoDe(Ticker item);
	//public void setTickerDerivativoDeComReversao(Ticker item);
	
	// Montador alternativo
	
	public void addListaTicker_DerivativoDe(Ticker item); 
	public Ticker getCorrenteTicker_DerivativoDe();
	
		
	
	// Sem Chave Estrangeira
	
	public EscolhaOpcao getCorrenteEscolhaOpcao_Escolhida();
	public void addListaEscolhaOpcao_Escolhida(EscolhaOpcao item);
	public List<EscolhaOpcao> getListaEscolhaOpcao_Escolhida(); 
	public void setListaEscolhaOpcao_Escolhida(List<EscolhaOpcao> item); 
	public void criaVaziaListaEscolhaOpcao_Escolhida();
	public boolean existeListaEscolhaOpcao_Escolhida();
 		
	public CotacaoProcessadaOpcaoResultado getCorrenteCotacaoProcessadaOpcaoResultado_EstaEm();
	public void addListaCotacaoProcessadaOpcaoResultado_EstaEm(CotacaoProcessadaOpcaoResultado item);
	public List<CotacaoProcessadaOpcaoResultado> getListaCotacaoProcessadaOpcaoResultado_EstaEm(); 
	public void setListaCotacaoProcessadaOpcaoResultado_EstaEm(List<CotacaoProcessadaOpcaoResultado> item); 
	public void criaVaziaListaCotacaoProcessadaOpcaoResultado_EstaEm();
	public boolean existeListaCotacaoProcessadaOpcaoResultado_EstaEm();
 		
	public OpcaoReferencia getCorrenteOpcaoReferencia_Possui();
	public void addListaOpcaoReferencia_Possui(OpcaoReferencia item);
	public List<OpcaoReferencia> getListaOpcaoReferencia_Possui(); 
	public void setListaOpcaoReferencia_Possui(List<OpcaoReferencia> item); 
	public void criaVaziaListaOpcaoReferencia_Possui();
	public boolean existeListaOpcaoReferencia_Possui();
 		
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
