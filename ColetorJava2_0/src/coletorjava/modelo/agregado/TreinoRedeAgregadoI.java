package coletorjava.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletorjava.modelo.*;

// Gera??o autom?tica n?o alterar
public interface TreinoRedeAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	// Montador tradicional
	public Rede getRedePertenceA(boolean lazyLoader);
	public void setRedePertenceA(Rede item);
	//public void setRedePertenceAComReversao(Rede item);
	
	// Montador alternativo
	
	public void addListaRede_PertenceA(Rede item); 
	public Rede getCorrenteRede_PertenceA();
	
		
	// Montador tradicional
	public DadoTreino getDadoTreinoGeradoPor(boolean lazyLoader);
	public void setDadoTreinoGeradoPor(DadoTreino item);
	//public void setDadoTreinoGeradoPorComReversao(DadoTreino item);
	
	// Montador alternativo
	
	public void addListaDadoTreino_GeradoPor(DadoTreino item); 
	public DadoTreino getCorrenteDadoTreino_GeradoPor();
	
		
	
	// Sem Chave Estrangeira
	
	public DadoTheta getCorrenteDadoTheta_Resultado();
	public void addListaDadoTheta_Resultado(DadoTheta item);
	public List<DadoTheta> getListaDadoTheta_Resultado(); 
	public void setListaDadoTheta_Resultado(List<DadoTheta> item); 
	public void criaVaziaListaDadoTheta_Resultado();
	public boolean existeListaDadoTheta_Resultado();
 		
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
