package coletorjava.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletorjava.modelo.*;
import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class ProjetoDadoTreinoVo implements ProjetoDadoTreino
{
		
	public long getIdObj()
    {
       return idProjetoDadoTreino;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdProjetoDadoTreino\" : \"" + idProjetoDadoTreino + "\" "
		+ ", \"Target\" : \"" + target + "\" "
		+ ", \"Stop\" : \"" + stop + "\" "
		+ ", \"PosicaoCompraVenda\" : \"" + posicaoCompraVenda + "\" "
		+ ", \"UltimaAlteracao\" : \"" + ultimaAlteracao + "\" "
		+ ", \"IdTickerRa\" : \"" + idTickerRa + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private ProjetoDadoTreinoDerivada derivada = null;
	private ProjetoDadoTreinoDerivada getDerivada() {
		if (derivada==null) {
			derivada = new ProjetoDadoTreinoDerivada(this);
		}
		return derivada;
	}

	private ProjetoDadoTreinoAgregado agregado = null;
	private ProjetoDadoTreinoAgregado getAgregado() {
		if (agregado==null) {
			agregado = new ProjetoDadoTreinoAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	// Montador Tradicional
	public Ticker getTickerReferenteA(boolean lazyLoader)
	{
		return getAgregado().getTickerReferenteA(lazyLoader); 
	} 
	public void setTickerReferenteA(Ticker value) 
	{
		getAgregado().setTickerReferenteA(value); 
	} 
	/*
	public void setTickerReferenteAComReversao(Ticker value) 
	{
		getAgregado().setTickerReferenteAComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaTicker_ReferenteA(Ticker value)
	{
		getAgregado().setTickerReferenteA(value); 
	} 
	public Ticker getCorrenteTicker_ReferenteA()
	{
		return getAgregado().getTickerReferenteA(false); 
	} 
	
	
	
	
	// Um pra um
	
	
	
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	
	// Montador Alternativo
	public boolean existeListaDadoTreino_Gerou() {
		return getAgregado().existeListaDadoTreino_Gerou();
	}
	public void criaVaziaListaDadoTreino_Gerou() {
		getAgregado().criaVaziaListaDadoTreino_Gerou();
	}
	public List<DadoTreino> getListaDadoTreino_Gerou() 
	{
		return getAgregado().getListaDadoTreino_Gerou(); 
	} 
	public void setListaDadoTreino_Gerou(List<DadoTreino> value) 
	{
		getAgregado().setListaDadoTreino_Gerou(value); 
	} 
	public void addListaDadoTreino_Gerou(DadoTreino value) 
	{
		getAgregado().addListaDadoTreino_Gerou(value); 
	} 
	public DadoTreino getCorrenteDadoTreino_Gerou()
	{
		return getAgregado().getCorrenteDadoTreino_Gerou(); 
	} 
	
	// Montador Alternativo
	public boolean existeListaResultadoMes_Gerou() {
		return getAgregado().existeListaResultadoMes_Gerou();
	}
	public void criaVaziaListaResultadoMes_Gerou() {
		getAgregado().criaVaziaListaResultadoMes_Gerou();
	}
	public List<ResultadoMes> getListaResultadoMes_Gerou() 
	{
		return getAgregado().getListaResultadoMes_Gerou(); 
	} 
	public void setListaResultadoMes_Gerou(List<ResultadoMes> value) 
	{
		getAgregado().setListaResultadoMes_Gerou(value); 
	} 
	public void addListaResultadoMes_Gerou(ResultadoMes value) 
	{
		getAgregado().addListaResultadoMes_Gerou(value); 
	} 
	public ResultadoMes getCorrenteResultadoMes_Gerou()
	{
		return getAgregado().getCorrenteResultadoMes_Gerou(); 
	} 
	

	
	
	
	
	
	private long idProjetoDadoTreino;
	public long getIdProjetoDadoTreino()
	{
		return idProjetoDadoTreino;
	}
	public  void setIdProjetoDadoTreino(long value)
	{
		idProjetoDadoTreino = value; 
	}
	
	
	
	
	
	private float target;
	public float getTarget()
	{
		return target;
	}
	public  void setTarget(float value)
	{
		target = value; 
	}
	
	
	
	
	
	private float stop;
	public float getStop()
	{
		return stop;
	}
	public  void setStop(float value)
	{
		stop = value; 
	}
	
	
	
	
	
	private String posicaoCompraVenda;
	public String getPosicaoCompraVenda()
	{
		return posicaoCompraVenda;
	}
	public  void setPosicaoCompraVenda(String value)
	{
		posicaoCompraVenda = value; 
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
	
	
	
	
		
	private long idTickerRa;
	public long getIdTickerRa() {
		// relacionamento
		if (idTickerRa==0 && this.getTickerReferenteA(false)!=null) 
			return getTickerReferenteA(false).getIdObj();
		else
			return idTickerRa;
	}
	public void setIdTickerRa(long _valor) {
		idTickerRa = _valor;
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
