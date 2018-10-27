package coletorjava.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletorjava.modelo.*;

// Gera??o autom?tica n?o alterar
public interface TickerAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	
	// Sem Chave Estrangeira
	
	public OpcaoSisacaoGeral getCorrenteOpcaoSisacaoGeral_Possui();
	public void addListaOpcaoSisacaoGeral_Possui(OpcaoSisacaoGeral item);
	public List<OpcaoSisacaoGeral> getListaOpcaoSisacaoGeral_Possui(); 
	public void setListaOpcaoSisacaoGeral_Possui(List<OpcaoSisacaoGeral> item); 
	public void criaVaziaListaOpcaoSisacaoGeral_Possui();
	public boolean existeListaOpcaoSisacaoGeral_Possui();
 		
	public OpcaoSisacao getCorrenteOpcaoSisacao_Gera();
	public void addListaOpcaoSisacao_Gera(OpcaoSisacao item);
	public List<OpcaoSisacao> getListaOpcaoSisacao_Gera(); 
	public void setListaOpcaoSisacao_Gera(List<OpcaoSisacao> item); 
	public void criaVaziaListaOpcaoSisacao_Gera();
	public boolean existeListaOpcaoSisacao_Gera();
 		
	public EscolhaOpcao getCorrenteEscolhaOpcao_Possui();
	public void addListaEscolhaOpcao_Possui(EscolhaOpcao item);
	public List<EscolhaOpcao> getListaEscolhaOpcao_Possui(); 
	public void setListaEscolhaOpcao_Possui(List<EscolhaOpcao> item); 
	public void criaVaziaListaEscolhaOpcao_Possui();
	public boolean existeListaEscolhaOpcao_Possui();
 		
	public ProjetoDadoTreino getCorrenteProjetoDadoTreino_Gera();
	public void addListaProjetoDadoTreino_Gera(ProjetoDadoTreino item);
	public List<ProjetoDadoTreino> getListaProjetoDadoTreino_Gera(); 
	public void setListaProjetoDadoTreino_Gera(List<ProjetoDadoTreino> item); 
	public void criaVaziaListaProjetoDadoTreino_Gera();
	public boolean existeListaProjetoDadoTreino_Gera();
 		
	public OpcaoReferencia getCorrenteOpcaoReferencia_Possui();
	public void addListaOpcaoReferencia_Possui(OpcaoReferencia item);
	public List<OpcaoReferencia> getListaOpcaoReferencia_Possui(); 
	public void setListaOpcaoReferencia_Possui(List<OpcaoReferencia> item); 
	public void criaVaziaListaOpcaoReferencia_Possui();
	public boolean existeListaOpcaoReferencia_Possui();
 		
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
