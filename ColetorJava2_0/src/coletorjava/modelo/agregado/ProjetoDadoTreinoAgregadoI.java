package coletorjava.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletorjava.modelo.*;

// Gera??o autom?tica n?o alterar
public interface ProjetoDadoTreinoAgregadoI{

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
	
	public DadoTreino getCorrenteDadoTreino_Gerou();
	public void addListaDadoTreino_Gerou(DadoTreino item);
	public List<DadoTreino> getListaDadoTreino_Gerou(); 
	public void setListaDadoTreino_Gerou(List<DadoTreino> item); 
	public void criaVaziaListaDadoTreino_Gerou();
	public boolean existeListaDadoTreino_Gerou();
 		
	public ResultadoMes getCorrenteResultadoMes_Gerou();
	public void addListaResultadoMes_Gerou(ResultadoMes item);
	public List<ResultadoMes> getListaResultadoMes_Gerou(); 
	public void setListaResultadoMes_Gerou(List<ResultadoMes> item); 
	public void criaVaziaListaResultadoMes_Gerou();
	public boolean existeListaResultadoMes_Gerou();
 		
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
