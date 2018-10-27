package coletorjava.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletorjava.modelo.*;
import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class TreinoRedeVo implements TreinoRede
{
		
	public long getIdObj()
    {
       return idTreinoRede;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdTreinoRede\" : \"" + idTreinoRede + "\" "
		+ ", \"Lambda\" : \"" + lambda + "\" "
		+ ", \"Iteracoes\" : \"" + iteracoes + "\" "
		+ ", \"UltimaAlteracao\" : \"" + ultimaAlteracao + "\" "
		+ ", \"IdRedePa\" : \"" + idRedePa + "\" "
		+ ", \"IdDadoTreinoGp\" : \"" + idDadoTreinoGp + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private TreinoRedeDerivada derivada = null;
	private TreinoRedeDerivada getDerivada() {
		if (derivada==null) {
			derivada = new TreinoRedeDerivada(this);
		}
		return derivada;
	}

	private TreinoRedeAgregado agregado = null;
	private TreinoRedeAgregado getAgregado() {
		if (agregado==null) {
			agregado = new TreinoRedeAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	// Montador Tradicional
	public Rede getRedePertenceA(boolean lazyLoader)
	{
		return getAgregado().getRedePertenceA(lazyLoader); 
	} 
	public void setRedePertenceA(Rede value) 
	{
		getAgregado().setRedePertenceA(value); 
	} 
	/*
	public void setRedePertenceAComReversao(Rede value) 
	{
		getAgregado().setRedePertenceAComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaRede_PertenceA(Rede value)
	{
		getAgregado().setRedePertenceA(value); 
	} 
	public Rede getCorrenteRede_PertenceA()
	{
		return getAgregado().getRedePertenceA(false); 
	} 
	
	
	// Montador Tradicional
	public DadoTreino getDadoTreinoGeradoPor(boolean lazyLoader)
	{
		return getAgregado().getDadoTreinoGeradoPor(lazyLoader); 
	} 
	public void setDadoTreinoGeradoPor(DadoTreino value) 
	{
		getAgregado().setDadoTreinoGeradoPor(value); 
	} 
	/*
	public void setDadoTreinoGeradoPorComReversao(DadoTreino value) 
	{
		getAgregado().setDadoTreinoGeradoPorComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaDadoTreino_GeradoPor(DadoTreino value)
	{
		getAgregado().setDadoTreinoGeradoPor(value); 
	} 
	public DadoTreino getCorrenteDadoTreino_GeradoPor()
	{
		return getAgregado().getDadoTreinoGeradoPor(false); 
	} 
	
	
	
	
	// Um pra um
	
	
	
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	
	// Montador Alternativo
	public boolean existeListaDadoTheta_Resultado() {
		return getAgregado().existeListaDadoTheta_Resultado();
	}
	public void criaVaziaListaDadoTheta_Resultado() {
		getAgregado().criaVaziaListaDadoTheta_Resultado();
	}
	public List<DadoTheta> getListaDadoTheta_Resultado() 
	{
		return getAgregado().getListaDadoTheta_Resultado(); 
	} 
	public void setListaDadoTheta_Resultado(List<DadoTheta> value) 
	{
		getAgregado().setListaDadoTheta_Resultado(value); 
	} 
	public void addListaDadoTheta_Resultado(DadoTheta value) 
	{
		getAgregado().addListaDadoTheta_Resultado(value); 
	} 
	public DadoTheta getCorrenteDadoTheta_Resultado()
	{
		return getAgregado().getCorrenteDadoTheta_Resultado(); 
	} 
	

	
	
	
	
	
	private long idTreinoRede;
	public long getIdTreinoRede()
	{
		return idTreinoRede;
	}
	public  void setIdTreinoRede(long value)
	{
		idTreinoRede = value; 
	}
	
	
	
	
	
	private float lambda;
	public float getLambda()
	{
		return lambda;
	}
	public  void setLambda(float value)
	{
		lambda = value; 
	}
	
	
	
	
	
	private long iteracoes;
	public long getIteracoes()
	{
		return iteracoes;
	}
	public  void setIteracoes(long value)
	{
		iteracoes = value; 
	}
	
	
	
	
	
	private String ultimaAlteracao;
	public String getUltimaAlteracao()
	{
		return ultimaAlteracao;
	}
	public  void setUltimaAlteracao(String value)
	{
		ultimaAlteracao = value; 
	}
	
	
	
	
		
	private long idRedePa;
	public long getIdRedePa() {
		// relacionamento
		if (idRedePa==0 && this.getRedePertenceA(false)!=null) 
			return getRedePertenceA(false).getIdObj();
		else
			return idRedePa;
	}
	public void setIdRedePa(long _valor) {
		idRedePa = _valor;
	}
	
	
	
	
		
	private long idDadoTreinoGp;
	public long getIdDadoTreinoGp() {
		// relacionamento
		if (idDadoTreinoGp==0 && this.getDadoTreinoGeradoPor(false)!=null) 
			return getDadoTreinoGeradoPor(false).getIdObj();
		else
			return idDadoTreinoGp;
	}
	public void setIdDadoTreinoGp(long _valor) {
		idDadoTreinoGp = _valor;
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
