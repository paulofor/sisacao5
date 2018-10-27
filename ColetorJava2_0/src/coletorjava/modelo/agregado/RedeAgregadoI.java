package coletorjava.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletorjava.modelo.*;

// Gera??o autom?tica n?o alterar
public interface RedeAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	
	// Sem Chave Estrangeira
	
	public TreinoRede getCorrenteTreinoRede_Gerou();
	public void addListaTreinoRede_Gerou(TreinoRede item);
	public List<TreinoRede> getListaTreinoRede_Gerou(); 
	public void setListaTreinoRede_Gerou(List<TreinoRede> item); 
	public void criaVaziaListaTreinoRede_Gerou();
	public boolean existeListaTreinoRede_Gerou();
 		
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
