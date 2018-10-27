package coletorjava.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletorjava.modelo.*;

// Gera??o autom?tica n?o alterar
public interface MesAnoAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	
	// Sem Chave Estrangeira
	
	public ResultadoPrevisao getCorrenteResultadoPrevisao_Gera();
	public void addListaResultadoPrevisao_Gera(ResultadoPrevisao item);
	public List<ResultadoPrevisao> getListaResultadoPrevisao_Gera(); 
	public void setListaResultadoPrevisao_Gera(List<ResultadoPrevisao> item); 
	public void criaVaziaListaResultadoPrevisao_Gera();
	public boolean existeListaResultadoPrevisao_Gera();
 		
	public ResultadoMes getCorrenteResultadoMes_BasePara();
	public void addListaResultadoMes_BasePara(ResultadoMes item);
	public List<ResultadoMes> getListaResultadoMes_BasePara(); 
	public void setListaResultadoMes_BasePara(List<ResultadoMes> item); 
	public void criaVaziaListaResultadoMes_BasePara();
	public boolean existeListaResultadoMes_BasePara();
 		
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
