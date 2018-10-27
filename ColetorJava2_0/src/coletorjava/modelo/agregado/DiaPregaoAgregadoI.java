package coletorjava.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletorjava.modelo.*;

// Gera??o autom?tica n?o alterar
public interface DiaPregaoAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	
	// Sem Chave Estrangeira
	
	public EscolhaOpcao getCorrenteEscolhaOpcao_Possui();
	public void addListaEscolhaOpcao_Possui(EscolhaOpcao item);
	public List<EscolhaOpcao> getListaEscolhaOpcao_Possui(); 
	public void setListaEscolhaOpcao_Possui(List<EscolhaOpcao> item); 
	public void criaVaziaListaEscolhaOpcao_Possui();
	public boolean existeListaEscolhaOpcao_Possui();
 		
	public OpcaoReferencia getCorrenteOpcaoReferencia_Possui();
	public void addListaOpcaoReferencia_Possui(OpcaoReferencia item);
	public List<OpcaoReferencia> getListaOpcaoReferencia_Possui(); 
	public void setListaOpcaoReferencia_Possui(List<OpcaoReferencia> item); 
	public void criaVaziaListaOpcaoReferencia_Possui();
	public boolean existeListaOpcaoReferencia_Possui();
 		
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
