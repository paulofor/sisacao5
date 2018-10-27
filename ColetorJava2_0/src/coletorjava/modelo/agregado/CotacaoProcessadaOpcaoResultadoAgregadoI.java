package coletorjava.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletorjava.modelo.*;

// Gera??o autom?tica n?o alterar
public interface CotacaoProcessadaOpcaoResultadoAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	// Montador tradicional
	public OpcaoSisacao getOpcaoSisacaoReferenteA(boolean lazyLoader);
	public void setOpcaoSisacaoReferenteA(OpcaoSisacao item);
	//public void setOpcaoSisacaoReferenteAComReversao(OpcaoSisacao item);
	
	// Montador alternativo
	
	public void addListaOpcaoSisacao_ReferenteA(OpcaoSisacao item); 
	public OpcaoSisacao getCorrenteOpcaoSisacao_ReferenteA();
	
		
	
	// Sem Chave Estrangeira
	
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
