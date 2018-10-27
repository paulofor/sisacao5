package coletorjava.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletorjava.modelo.*;

// Gera??o autom?tica n?o alterar
public interface ResultadoPrevisaoAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	// Montador tradicional
	public DadoTheta getDadoThetaGeradoDe(boolean lazyLoader);
	public void setDadoThetaGeradoDe(DadoTheta item);
	//public void setDadoThetaGeradoDeComReversao(DadoTheta item);
	
	// Montador alternativo
	
	public void addListaDadoTheta_GeradoDe(DadoTheta item); 
	public DadoTheta getCorrenteDadoTheta_GeradoDe();
	
		
	// Montador tradicional
	public ResultadoMes getResultadoMesMesmoPeriodo(boolean lazyLoader);
	public void setResultadoMesMesmoPeriodo(ResultadoMes item);
	//public void setResultadoMesMesmoPeriodoComReversao(ResultadoMes item);
	
	// Montador alternativo
	
	public void addListaResultadoMes_MesmoPeriodo(ResultadoMes item); 
	public ResultadoMes getCorrenteResultadoMes_MesmoPeriodo();
	
		
	// Montador tradicional
	public MesAno getMesAnoReferenteA(boolean lazyLoader);
	public void setMesAnoReferenteA(MesAno item);
	//public void setMesAnoReferenteAComReversao(MesAno item);
	
	// Montador alternativo
	
	public void addListaMesAno_ReferenteA(MesAno item); 
	public MesAno getCorrenteMesAno_ReferenteA();
	
		
	
	// Sem Chave Estrangeira
	
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
