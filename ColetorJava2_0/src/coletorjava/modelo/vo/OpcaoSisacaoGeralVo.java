package coletorjava.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletorjava.modelo.*;
import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class OpcaoSisacaoGeralVo implements OpcaoSisacaoGeral
{
		
	public long getIdObj()
    {
       return idOpcaoSisacaoGeral;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdOpcaoSisacaoGeral\" : \"" + idOpcaoSisacaoGeral + "\" "
		+ ", \"CodigoMercado\" : \"" + codigoMercado + "\" "
		+ ", \"PrecoExercicio\" : \"" + precoExercicio + "\" "
		+ ", \"DataInclusao\" : \"" + dataInclusao + "\" "
		+ ", \"MesAno\" : \"" + mesAno + "\" "
		+ ", \"DescricaoBdi\" : \"" + descricaoBdi + "\" "
		+ ", \"ColetaDiario\" : \"" + coletaDiario + "\" "
		+ ", \"PossuiColetaIntraday\" : \"" + possuiColetaIntraday + "\" "
		+ ", \"Possui15minutos\" : \"" + possui15minutos + "\" "
		+ ", \"IdTickerRa\" : \"" + idTickerRa + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private OpcaoSisacaoGeralDerivada derivada = null;
	private OpcaoSisacaoGeralDerivada getDerivada() {
		if (derivada==null) {
			derivada = new OpcaoSisacaoGeralDerivada(this);
		}
		return derivada;
	}

	private OpcaoSisacaoGeralAgregado agregado = null;
	private OpcaoSisacaoGeralAgregado getAgregado() {
		if (agregado==null) {
			agregado = new OpcaoSisacaoGeralAgregado(this);
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
	
	
	
	
	public String getDataVencimentoStr()
	{
		return getDerivada().getDataVencimentoStr(); 
	} 
	public void setDataVencimentoStr(String value)
	{
		getDerivada().setDataVencimentoStr(value); 
	} 
	
	public String getEspecificacao()
	{
		return getDerivada().getEspecificacao(); 
	} 
	public void setEspecificacao(String value)
	{
		getDerivada().setEspecificacao(value); 
	} 
	
	public String getNomeRes()
	{
		return getDerivada().getNomeRes(); 
	} 
	public void setNomeRes(String value)
	{
		getDerivada().setNomeRes(value); 
	} 
	
	public long getTotalNegocioDiaAnterior()
	{
		return getDerivada().getTotalNegocioDiaAnterior(); 
	} 
	public void setTotalNegocioDiaAnterior(long value)
	{
		getDerivada().setTotalNegocioDiaAnterior(value); 
	} 
	
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
	

	
	
	
	
	
	private long idOpcaoSisacaoGeral;
	public long getIdOpcaoSisacaoGeral()
	{
		return idOpcaoSisacaoGeral;
	}
	public  void setIdOpcaoSisacaoGeral(long value)
	{
		idOpcaoSisacaoGeral = value; 
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
	
	
	
	
	
	private String dataInclusao;
	public String getDataInclusao()
	{
		return dataInclusao;
	}
	public  void setDataInclusao(String value)
	{
		dataInclusao = value; 
	}
	
	
	
	
	
	private String mesAno;
	public String getMesAno()
	{
		return mesAno;
	}
	public  void setMesAno(String value)
	{
		mesAno = value; 
	}
	
	
	
	
	
	private String descricaoBdi;
	public String getDescricaoBdi()
	{
		return descricaoBdi;
	}
	public  void setDescricaoBdi(String value)
	{
		descricaoBdi = value; 
	}
	
	
	
	
	
	private boolean coletaDiario;
	public boolean getColetaDiario()
	{
		return coletaDiario;
	}
	public  void setColetaDiario(boolean value)
	{
		coletaDiario = value; 
	}
	
	
	
	
	
	private boolean possuiColetaIntraday;
	public boolean getPossuiColetaIntraday()
	{
		return possuiColetaIntraday;
	}
	public  void setPossuiColetaIntraday(boolean value)
	{
		possuiColetaIntraday = value; 
	}
	
	
	
	
	
	private boolean possui15minutos;
	public boolean getPossui15minutos()
	{
		return possui15minutos;
	}
	public  void setPossui15minutos(boolean value)
	{
		possui15minutos = value; 
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
