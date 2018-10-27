package coletorjava.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletorjava.modelo.*;
import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class OpcaoReferenciaVo implements OpcaoReferencia
{
		
	public long getIdObj()
    {
       return idOpcaoReferencia;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdOpcaoReferencia\" : \"" + idOpcaoReferencia + "\" "
		+ ", \"CodigoMercado\" : \"" + codigoMercado + "\" "
		+ ", \"Data\" : \"" + data + "\" "
		+ ", \"IdTickerRa\" : \"" + idTickerRa + "\" "
		+ ", \"IdDiaPregaoRa\" : \"" + idDiaPregaoRa + "\" "
		+ ", \"IdOpcaoSisacaoRa\" : \"" + idOpcaoSisacaoRa + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private OpcaoReferenciaDerivada derivada = null;
	private OpcaoReferenciaDerivada getDerivada() {
		if (derivada==null) {
			derivada = new OpcaoReferenciaDerivada(this);
		}
		return derivada;
	}

	private OpcaoReferenciaAgregado agregado = null;
	private OpcaoReferenciaAgregado getAgregado() {
		if (agregado==null) {
			agregado = new OpcaoReferenciaAgregado(this);
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
	
	
	// Montador Tradicional
	public OpcaoSisacao getOpcaoSisacaoReferenteA(boolean lazyLoader)
	{
		return getAgregado().getOpcaoSisacaoReferenteA(lazyLoader); 
	} 
	public void setOpcaoSisacaoReferenteA(OpcaoSisacao value) 
	{
		getAgregado().setOpcaoSisacaoReferenteA(value); 
	} 
	/*
	public void setOpcaoSisacaoReferenteAComReversao(OpcaoSisacao value) 
	{
		getAgregado().setOpcaoSisacaoReferenteAComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaOpcaoSisacao_ReferenteA(OpcaoSisacao value)
	{
		getAgregado().setOpcaoSisacaoReferenteA(value); 
	} 
	public OpcaoSisacao getCorrenteOpcaoSisacao_ReferenteA()
	{
		return getAgregado().getOpcaoSisacaoReferenteA(false); 
	} 
	
	
	
	
	// Um pra um
	
	
	
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	

	
	
	
	
	
	private long idOpcaoReferencia;
	public long getIdOpcaoReferencia()
	{
		return idOpcaoReferencia;
	}
	public  void setIdOpcaoReferencia(long value)
	{
		idOpcaoReferencia = value; 
	}
	
	
	
	
	
	private String codigoMercado;
	public String getCodigoMercado()
	{
		return codigoMercado;
	}
	public  void setCodigoMercado(String value)
	{
		codigoMercado = value; 
	}
	
	
	
	
	
	private String data;
	public String getData()
	{
		return data;
	}
	public  void setData(String value)
	{
		data = value; 
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
	
	
	
	
		
	private long idOpcaoSisacaoRa;
	public long getIdOpcaoSisacaoRa() {
		// relacionamento
		if (idOpcaoSisacaoRa==0 && this.getOpcaoSisacaoReferenteA(false)!=null) 
			return getOpcaoSisacaoReferenteA(false).getIdObj();
		else
			return idOpcaoSisacaoRa;
	}
	public void setIdOpcaoSisacaoRa(long _valor) {
		idOpcaoSisacaoRa = _valor;
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
