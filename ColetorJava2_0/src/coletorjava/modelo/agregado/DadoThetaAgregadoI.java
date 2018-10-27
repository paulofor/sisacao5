package coletorjava.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletorjava.modelo.*;

// Gera??o autom?tica n?o alterar
public interface DadoThetaAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	// Montador tradicional
	public TreinoRede getTreinoRedeGeradoPor(boolean lazyLoader);
	public void setTreinoRedeGeradoPor(TreinoRede item);
	//public void setTreinoRedeGeradoPorComReversao(TreinoRede item);
	
	// Montador alternativo
	
	public void addListaTreinoRede_GeradoPor(TreinoRede item); 
	public TreinoRede getCorrenteTreinoRede_GeradoPor();
	
		
	
	// Sem Chave Estrangeira
	
	public ResultadoPrevisao getCorrenteResultadoPrevisao_Gera();
	public void addListaResultadoPrevisao_Gera(ResultadoPrevisao item);
	public List<ResultadoPrevisao> getListaResultadoPrevisao_Gera(); 
	public void setListaResultadoPrevisao_Gera(List<ResultadoPrevisao> item); 
	public void criaVaziaListaResultadoPrevisao_Gera();
	public boolean existeListaResultadoPrevisao_Gera();
 		
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
