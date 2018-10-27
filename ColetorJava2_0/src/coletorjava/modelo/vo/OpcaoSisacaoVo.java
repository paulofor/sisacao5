package coletorjava.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletorjava.modelo.*;
import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class OpcaoSisacaoVo implements OpcaoSisacao
{
		
	public long getIdObj()
    {
       return idOpcaoSisacao;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdOpcaoSisacao\" : \"" + idOpcaoSisacao + "\" "
		+ ", \"CodigoMercado\" : \"" + codigoMercado + "\" "
		+ ", \"PrecoExercicio\" : \"" + precoExercicio + "\" "
		+ ", \"DataInicioColeta\" : \"" + dataInicioColeta + "\" "
		+ ", \"IdOpcaoSisacaoSeriePa\" : \"" + idOpcaoSisacaoSeriePa + "\" "
		+ ", \"IdTickerDd\" : \"" + idTickerDd + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private OpcaoSisacaoDerivada derivada = null;
	private OpcaoSisacaoDerivada getDerivada() {
		if (derivada==null) {
			derivada = new OpcaoSisacaoDerivada(this);
		}
		return derivada;
	}

	private OpcaoSisacaoAgregado agregado = null;
	private OpcaoSisacaoAgregado getAgregado() {
		if (agregado==null) {
			agregado = new OpcaoSisacaoAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	// Montador Tradicional
	public OpcaoSisacaoSerie getOpcaoSisacaoSeriePertenceA(boolean lazyLoader)
	{
		return getAgregado().getOpcaoSisacaoSeriePertenceA(lazyLoader); 
	} 
	public void setOpcaoSisacaoSeriePertenceA(OpcaoSisacaoSerie value) 
	{
		getAgregado().setOpcaoSisacaoSeriePertenceA(value); 
	} 
	/*
	public void setOpcaoSisacaoSeriePertenceAComReversao(OpcaoSisacaoSerie value) 
	{
		getAgregado().setOpcaoSisacaoSeriePertenceAComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaOpcaoSisacaoSerie_PertenceA(OpcaoSisacaoSerie value)
	{
		getAgregado().setOpcaoSisacaoSeriePertenceA(value); 
	} 
	public OpcaoSisacaoSerie getCorrenteOpcaoSisacaoSerie_PertenceA()
	{
		return getAgregado().getOpcaoSisacaoSeriePertenceA(false); 
	} 
	
	
	// Montador Tradicional
	public Ticker getTickerDerivativoDe(boolean lazyLoader)
	{
		return getAgregado().getTickerDerivativoDe(lazyLoader); 
	} 
	public void setTickerDerivativoDe(Ticker value) 
	{
		getAgregado().setTickerDerivativoDe(value); 
	} 
	/*
	public void setTickerDerivativoDeComReversao(Ticker value) 
	{
		getAgregado().setTickerDerivativoDeComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaTicker_DerivativoDe(Ticker value)
	{
		getAgregado().setTickerDerivativoDe(value); 
	} 
	public Ticker getCorrenteTicker_DerivativoDe()
	{
		return getAgregado().getTickerDerivativoDe(false); 
	} 
	
	
	
	
	// Um pra um
	
	
	
	
	public float getValorCotacao()
	{
		return getDerivada().getValorCotacao(); 
	} 
	public void setValorCotacao(float value)
	{
		getDerivada().setValorCotacao(value); 
	} 
	
	public long getQtdeNegocio()
	{
		return getDerivada().getQtdeNegocio(); 
	} 
	public void setQtdeNegocio(long value)
	{
		getDerivada().setQtdeNegocio(value); 
	} 
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	
	// Montador Alternativo
	public boolean existeListaEscolhaOpcao_Escolhida() {
		return getAgregado().existeListaEscolhaOpcao_Escolhida();
	}
	public void criaVaziaListaEscolhaOpcao_Escolhida() {
		getAgregado().criaVaziaListaEscolhaOpcao_Escolhida();
	}
	public List<EscolhaOpcao> getListaEscolhaOpcao_Escolhida() 
	{
		return getAgregado().getListaEscolhaOpcao_Escolhida(); 
	} 
	public void setListaEscolhaOpcao_Escolhida(List<EscolhaOpcao> value) 
	{
		getAgregado().setListaEscolhaOpcao_Escolhida(value); 
	} 
	public void addListaEscolhaOpcao_Escolhida(EscolhaOpcao value) 
	{
		getAgregado().addListaEscolhaOpcao_Escolhida(value); 
	} 
	public EscolhaOpcao getCorrenteEscolhaOpcao_Escolhida()
	{
		return getAgregado().getCorrenteEscolhaOpcao_Escolhida(); 
	} 
	
	// Montador Alternativo
	public boolean existeListaCotacaoProcessadaOpcaoResultado_EstaEm() {
		return getAgregado().existeListaCotacaoProcessadaOpcaoResultado_EstaEm();
	}
	public void criaVaziaListaCotacaoProcessadaOpcaoResultado_EstaEm() {
		getAgregado().criaVaziaListaCotacaoProcessadaOpcaoResultado_EstaEm();
	}
	public List<CotacaoProcessadaOpcaoResultado> getListaCotacaoProcessadaOpcaoResultado_EstaEm() 
	{
		return getAgregado().getListaCotacaoProcessadaOpcaoResultado_EstaEm(); 
	} 
	public void setListaCotacaoProcessadaOpcaoResultado_EstaEm(List<CotacaoProcessadaOpcaoResultado> value) 
	{
		getAgregado().setListaCotacaoProcessadaOpcaoResultado_EstaEm(value); 
	} 
	public void addListaCotacaoProcessadaOpcaoResultado_EstaEm(CotacaoProcessadaOpcaoResultado value) 
	{
		getAgregado().addListaCotacaoProcessadaOpcaoResultado_EstaEm(value); 
	} 
	public CotacaoProcessadaOpcaoResultado getCorrenteCotacaoProcessadaOpcaoResultado_EstaEm()
	{
		return getAgregado().getCorrenteCotacaoProcessadaOpcaoResultado_EstaEm(); 
	} 
	
	// Montador Alternativo
	public boolean existeListaOpcaoReferencia_Possui() {
		return getAgregado().existeListaOpcaoReferencia_Possui();
	}
	public void criaVaziaListaOpcaoReferencia_Possui() {
		getAgregado().criaVaziaListaOpcaoReferencia_Possui();
	}
	public List<OpcaoReferencia> getListaOpcaoReferencia_Possui() 
	{
		return getAgregado().getListaOpcaoReferencia_Possui(); 
	} 
	public void setListaOpcaoReferencia_Possui(List<OpcaoReferencia> value) 
	{
		getAgregado().setListaOpcaoReferencia_Possui(value); 
	} 
	public void addListaOpcaoReferencia_Possui(OpcaoReferencia value) 
	{
		getAgregado().addListaOpcaoReferencia_Possui(value); 
	} 
	public OpcaoReferencia getCorrenteOpcaoReferencia_Possui()
	{
		return getAgregado().getCorrenteOpcaoReferencia_Possui(); 
	} 
	

	
	
	
	
	
	private long idOpcaoSisacao;
	public long getIdOpcaoSisacao()
	{
		return idOpcaoSisacao;
	}
	public  void setIdOpcaoSisacao(long value)
	{
		idOpcaoSisacao = value; 
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
	
	
	
	public String getPrecoExercicioFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(precoExercicio);
	}
	
	
	
	private float precoExercicio;
	public float getPrecoExercicio()
	{
		return precoExercicio;
	}
	public  void setPrecoExercicio(float value)
	{
		precoExercicio = value; 
	}
	
	
	
	
	
	private String dataInicioColeta;
	public String getDataInicioColeta()
	{
		return dataInicioColeta;
	}
	public  void setDataInicioColeta(String value)
	{
		dataInicioColeta = value; 
	}
	
	
	
	
		
	private long idOpcaoSisacaoSeriePa;
	public long getIdOpcaoSisacaoSeriePa() {
		// relacionamento
		if (idOpcaoSisacaoSeriePa==0 && this.getOpcaoSisacaoSeriePertenceA(false)!=null) 
			return getOpcaoSisacaoSeriePertenceA(false).getIdObj();
		else
			return idOpcaoSisacaoSeriePa;
	}
	public void setIdOpcaoSisacaoSeriePa(long _valor) {
		idOpcaoSisacaoSeriePa = _valor;
	}
	
	
	
	
		
	private long idTickerDd;
	public long getIdTickerDd() {
		// relacionamento
		if (idTickerDd==0 && this.getTickerDerivativoDe(false)!=null) 
			return getTickerDerivativoDe(false).getIdObj();
		else
			return idTickerDd;
	}
	public void setIdTickerDd(long _valor) {
		idTickerDd = _valor;
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
