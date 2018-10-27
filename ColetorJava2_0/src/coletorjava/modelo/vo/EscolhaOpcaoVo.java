package coletorjava.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletorjava.modelo.*;
import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class EscolhaOpcaoVo implements EscolhaOpcao
{
		
	public long getIdObj()
    {
       return idEscolhaOpcao;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdEscolhaOpcao\" : \"" + idEscolhaOpcao + "\" "
		+ ", \"DataReferencia\" : \"" + dataReferencia + "\" "
		+ ", \"HoraReferencia\" : \"" + horaReferencia + "\" "
		+ ", \"FaixaEscolha\" : \"" + faixaEscolha + "\" "
		+ ", \"IdTickerRa\" : \"" + idTickerRa + "\" "
		+ ", \"IdOpcaoSisacaoE\" : \"" + idOpcaoSisacaoE + "\" "
		+ ", \"IdDiaPregaoRa\" : \"" + idDiaPregaoRa + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private EscolhaOpcaoDerivada derivada = null;
	private EscolhaOpcaoDerivada getDerivada() {
		if (derivada==null) {
			derivada = new EscolhaOpcaoDerivada(this);
		}
		return derivada;
	}

	private EscolhaOpcaoAgregado agregado = null;
	private EscolhaOpcaoAgregado getAgregado() {
		if (agregado==null) {
			agregado = new EscolhaOpcaoAgregado(this);
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
	
	
	// Montador Tradicional
	public OpcaoSisacao getOpcaoSisacaoEscolha(boolean lazyLoader)
	{
		return getAgregado().getOpcaoSisacaoEscolha(lazyLoader); 
	} 
	public void setOpcaoSisacaoEscolha(OpcaoSisacao value) 
	{
		getAgregado().setOpcaoSisacaoEscolha(value); 
	} 
	/*
	public void setOpcaoSisacaoEscolhaComReversao(OpcaoSisacao value) 
	{
		getAgregado().setOpcaoSisacaoEscolhaComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaOpcaoSisacao_Escolha(OpcaoSisacao value)
	{
		getAgregado().setOpcaoSisacaoEscolha(value); 
	} 
	public OpcaoSisacao getCorrenteOpcaoSisacao_Escolha()
	{
		return getAgregado().getOpcaoSisacaoEscolha(false); 
	} 
	
	
	// Montador Tradicional
	public DiaPregao getDiaPregaoReferenteA(boolean lazyLoader)
	{
		return getAgregado().getDiaPregaoReferenteA(lazyLoader); 
	} 
	public void setDiaPregaoReferenteA(DiaPregao value) 
	{
		getAgregado().setDiaPregaoReferenteA(value); 
	} 
	/*
	public void setDiaPregaoReferenteAComReversao(DiaPregao value) 
	{
		getAgregado().setDiaPregaoReferenteAComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaDiaPregao_ReferenteA(DiaPregao value)
	{
		getAgregado().setDiaPregaoReferenteA(value); 
	} 
	public DiaPregao getCorrenteDiaPregao_ReferenteA()
	{
		return getAgregado().getDiaPregaoReferenteA(false); 
	} 
	
	
	
	
	// Um pra um
	
	
	
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	

	
	
	
	
	
	private long idEscolhaOpcao;
	public long getIdEscolhaOpcao()
	{
		return idEscolhaOpcao;
	}
	public  void setIdEscolhaOpcao(long value)
	{
		idEscolhaOpcao = value; 
	}
	
	
	
	
	
	private String dataReferencia;
	public String getDataReferencia()
	{
		return dataReferencia;
	}
	public  void setDataReferencia(String value)
	{
		dataReferencia = value; 
	}
	
	
	
	
	
	private String horaReferencia;
	public String getHoraReferencia()
	{
		return horaReferencia;
	}
	public  void setHoraReferencia(String value)
	{
		horaReferencia = value; 
	}
	
	
	
	
	
	private long faixaEscolha;
	public long getFaixaEscolha()
	{
		return faixaEscolha;
	}
	public  void setFaixaEscolha(long value)
	{
		faixaEscolha = value; 
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
	
	
	
	
		
	private long idOpcaoSisacaoE;
	public long getIdOpcaoSisacaoE() {
		// relacionamento
		if (idOpcaoSisacaoE==0 && this.getOpcaoSisacaoEscolha(false)!=null) 
			return getOpcaoSisacaoEscolha(false).getIdObj();
		else
			return idOpcaoSisacaoE;
	}
	public void setIdOpcaoSisacaoE(long _valor) {
		idOpcaoSisacaoE = _valor;
	}
	
	
	
	
		
	private long idDiaPregaoRa;
	public long getIdDiaPregaoRa() {
		// relacionamento
		if (idDiaPregaoRa==0 && this.getDiaPregaoReferenteA(false)!=null) 
			return getDiaPregaoReferenteA(false).getIdObj();
		else
			return idDiaPregaoRa;
	}
	public void setIdDiaPregaoRa(long _valor) {
		idDiaPregaoRa = _valor;
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
