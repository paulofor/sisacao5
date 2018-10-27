package coletorjava.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletorjava.modelo.*;

// Gera??o autom?tica n?o alterar
public interface ResultadoMesAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	// Montador tradicional
	public ProjetoDadoTreino getProjetoDadoTreinoGeradoPor(boolean lazyLoader);
	public void setProjetoDadoTreinoGeradoPor(ProjetoDadoTreino item);
	//public void setProjetoDadoTreinoGeradoPorComReversao(ProjetoDadoTreino item);
	
	// Montador alternativo
	
	public void addListaProjetoDadoTreino_GeradoPor(ProjetoDadoTreino item); 
	public ProjetoDadoTreino getCorrenteProjetoDadoTreino_GeradoPor();
	
		
	// Montador tradicional
	public MesAno getMesAnoReferenteA(boolean lazyLoader);
	public void setMesAnoReferenteA(MesAno item);
	//public void setMesAnoReferenteAComReversao(MesAno item);
	
	// Montador alternativo
	
	public void addListaMesAno_ReferenteA(MesAno item); 
	public MesAno getCorrenteMesAno_ReferenteA();
	
		
	
	// Sem Chave Estrangeira
	
	public ResultadoPrevisao getCorrenteResultadoPrevisao_Semelhante();
	public void addListaResultadoPrevisao_Semelhante(ResultadoPrevisao item);
	public List<ResultadoPrevisao> getListaResultadoPrevisao_Semelhante(); 
	public void setListaResultadoPrevisao_Semelhante(List<ResultadoPrevisao> item); 
	public void criaVaziaListaResultadoPrevisao_Semelhante();
	public boolean existeListaResultadoPrevisao_Semelhante();
 		
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
