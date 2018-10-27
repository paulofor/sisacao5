package coletorjava.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletorjava.modelo.*;
import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class CotacaoProcessadaOpcaoResultadoVo implements CotacaoProcessadaOpcaoResultado
{
		
	public long getIdObj()
    {
       return idCotacaoProcessadaOpcaoResultado;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdCotacaoProcessadaOpcaoResultado\" : \"" + idCotacaoProcessadaOpcaoResultado + "\" "
		+ ", \"Data\" : \"" + data + "\" "
		+ ", \"HoraSerieTemporal\" : \"" + horaSerieTemporal + "\" "
		+ ", \"ContadorDia\" : \"" + contadorDia + "\" "
		+ ", \"CodigoMercadoOpcao\" : \"" + codigoMercadoOpcao + "\" "
		+ ", \"ValorOpcao\" : \"" + valorOpcao + "\" "
		+ ", \"ResultadoT70S60\" : \"" + resultadoT70S60 + "\" "
		+ ", \"ResultadoT60S60\" : \"" + resultadoT60S60 + "\" "
		+ ", \"ResultadoT50S60\" : \"" + resultadoT50S60 + "\" "
		+ ", \"ResultadoT40S60\" : \"" + resultadoT40S60 + "\" "
		+ ", \"ResultadoT70S50\" : \"" + resultadoT70S50 + "\" "
		+ ", \"ResultadoT60S50\" : \"" + resultadoT60S50 + "\" "
		+ ", \"ResultadoT50S50\" : \"" + resultadoT50S50 + "\" "
		+ ", \"ResultadoT40S50\" : \"" + resultadoT40S50 + "\" "
		+ ", \"ValorSaidaT40S60\" : \"" + valorSaidaT40S60 + "\" "
		+ ", \"ValorSaidaT50S60\" : \"" + valorSaidaT50S60 + "\" "
		+ ", \"ValorSaidaT60S60\" : \"" + valorSaidaT60S60 + "\" "
		+ ", \"ValorSaidaT70S60\" : \"" + valorSaidaT70S60 + "\" "
		+ ", \"ValorSaidaT40S50\" : \"" + valorSaidaT40S50 + "\" "
		+ ", \"ValorSaidaT50S50\" : \"" + valorSaidaT50S50 + "\" "
		+ ", \"ValorSaidaT60S50\" : \"" + valorSaidaT60S50 + "\" "
		+ ", \"ValorSaidaT70S50\" : \"" + valorSaidaT70S50 + "\" "
		+ ", \"DataHoraSaidaT40S60\" : \"" + dataHoraSaidaT40S60 + "\" "
		+ ", \"DataHoraSaidaT50S60\" : \"" + dataHoraSaidaT50S60 + "\" "
		+ ", \"DataHoraSaidaT60S60\" : \"" + dataHoraSaidaT60S60 + "\" "
		+ ", \"DataHoraSaidaT70S60\" : \"" + dataHoraSaidaT70S60 + "\" "
		+ ", \"DataHoraSaidaT40S50\" : \"" + dataHoraSaidaT40S50 + "\" "
		+ ", \"DataHoraSaidaT50S50\" : \"" + dataHoraSaidaT50S50 + "\" "
		+ ", \"DataHoraSaidaT60S50\" : \"" + dataHoraSaidaT60S50 + "\" "
		+ ", \"DataHoraSaidaT70S50\" : \"" + dataHoraSaidaT70S50 + "\" "
		+ ", \"ValorAcao\" : \"" + valorAcao + "\" "
		+ ", \"LimiteDiaT50S50\" : \"" + limiteDiaT50S50 + "\" "
		+ ", \"LimiteDiaT60S60\" : \"" + limiteDiaT60S60 + "\" "
		+ ", \"IdOpcaoSisacaoRa\" : \"" + idOpcaoSisacaoRa + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private CotacaoProcessadaOpcaoResultadoDerivada derivada = null;
	private CotacaoProcessadaOpcaoResultadoDerivada getDerivada() {
		if (derivada==null) {
			derivada = new CotacaoProcessadaOpcaoResultadoDerivada(this);
		}
		return derivada;
	}

	private CotacaoProcessadaOpcaoResultadoAgregado agregado = null;
	private CotacaoProcessadaOpcaoResultadoAgregado getAgregado() {
		if (agregado==null) {
			agregado = new CotacaoProcessadaOpcaoResultadoAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
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
	

	
	
	
	
	
	private long idCotacaoProcessadaOpcaoResultado;
	public long getIdCotacaoProcessadaOpcaoResultado()
	{
		return idCotacaoProcessadaOpcaoResultado;
	}
	public  void setIdCotacaoProcessadaOpcaoResultado(long value)
	{
		idCotacaoProcessadaOpcaoResultado = value; 
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
	
	
	
	
	
	private String horaSerieTemporal;
	public String getHoraSerieTemporal()
	{
		return horaSerieTemporal;
	}
	public  void setHoraSerieTemporal(String value)
	{
		horaSerieTemporal = value; 
	}
	
	
	
	
	
	private long contadorDia;
	public long getContadorDia()
	{
		return contadorDia;
	}
	public  void setContadorDia(long value)
	{
		contadorDia = value; 
	}
	
	
	
	
	
	private String codigoMercadoOpcao;
	public String getCodigoMercadoOpcao()
	{
		return codigoMercadoOpcao;
	}
	public  void setCodigoMercadoOpcao(String value)
	{
		codigoMercadoOpcao = value; 
	}
	
	
	
	public String getValorOpcaoFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(valorOpcao);
	}
	
	
	
	private float valorOpcao;
	public float getValorOpcao()
	{
		return valorOpcao;
	}
	public  void setValorOpcao(float value)
	{
		valorOpcao = value; 
	}
	
	
	
	
	
	private long resultadoT70S60;
	public long getResultadoT70S60()
	{
		return resultadoT70S60;
	}
	public  void setResultadoT70S60(long value)
	{
		resultadoT70S60 = value; 
	}
	
	
	
	
	
	private long resultadoT60S60;
	public long getResultadoT60S60()
	{
		return resultadoT60S60;
	}
	public  void setResultadoT60S60(long value)
	{
		resultadoT60S60 = value; 
	}
	
	
	
	
	
	private long resultadoT50S60;
	public long getResultadoT50S60()
	{
		return resultadoT50S60;
	}
	public  void setResultadoT50S60(long value)
	{
		resultadoT50S60 = value; 
	}
	
	
	
	
	
	private long resultadoT40S60;
	public long getResultadoT40S60()
	{
		return resultadoT40S60;
	}
	public  void setResultadoT40S60(long value)
	{
		resultadoT40S60 = value; 
	}
	
	
	
	
	
	private long resultadoT70S50;
	public long getResultadoT70S50()
	{
		return resultadoT70S50;
	}
	public  void setResultadoT70S50(long value)
	{
		resultadoT70S50 = value; 
	}
	
	
	
	
	
	private long resultadoT60S50;
	public long getResultadoT60S50()
	{
		return resultadoT60S50;
	}
	public  void setResultadoT60S50(long value)
	{
		resultadoT60S50 = value; 
	}
	
	
	
	
	
	private long resultadoT50S50;
	public long getResultadoT50S50()
	{
		return resultadoT50S50;
	}
	public  void setResultadoT50S50(long value)
	{
		resultadoT50S50 = value; 
	}
	
	
	
	
	
	private long resultadoT40S50;
	public long getResultadoT40S50()
	{
		return resultadoT40S50;
	}
	public  void setResultadoT40S50(long value)
	{
		resultadoT40S50 = value; 
	}
	
	
	
	public String getValorSaidaT40S60Formatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(valorSaidaT40S60);
	}
	
	
	
	private float valorSaidaT40S60;
	public float getValorSaidaT40S60()
	{
		return valorSaidaT40S60;
	}
	public  void setValorSaidaT40S60(float value)
	{
		valorSaidaT40S60 = value; 
	}
	
	
	
	public String getValorSaidaT50S60Formatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(valorSaidaT50S60);
	}
	
	
	
	private float valorSaidaT50S60;
	public float getValorSaidaT50S60()
	{
		return valorSaidaT50S60;
	}
	public  void setValorSaidaT50S60(float value)
	{
		valorSaidaT50S60 = value; 
	}
	
	
	
	public String getValorSaidaT60S60Formatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(valorSaidaT60S60);
	}
	
	
	
	private float valorSaidaT60S60;
	public float getValorSaidaT60S60()
	{
		return valorSaidaT60S60;
	}
	public  void setValorSaidaT60S60(float value)
	{
		valorSaidaT60S60 = value; 
	}
	
	
	
	public String getValorSaidaT70S60Formatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(valorSaidaT70S60);
	}
	
	
	
	private float valorSaidaT70S60;
	public float getValorSaidaT70S60()
	{
		return valorSaidaT70S60;
	}
	public  void setValorSaidaT70S60(float value)
	{
		valorSaidaT70S60 = value; 
	}
	
	
	
	public String getValorSaidaT40S50Formatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(valorSaidaT40S50);
	}
	
	
	
	private float valorSaidaT40S50;
	public float getValorSaidaT40S50()
	{
		return valorSaidaT40S50;
	}
	public  void setValorSaidaT40S50(float value)
	{
		valorSaidaT40S50 = value; 
	}
	
	
	
	public String getValorSaidaT50S50Formatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(valorSaidaT50S50);
	}
	
	
	
	private float valorSaidaT50S50;
	public float getValorSaidaT50S50()
	{
		return valorSaidaT50S50;
	}
	public  void setValorSaidaT50S50(float value)
	{
		valorSaidaT50S50 = value; 
	}
	
	
	
	public String getValorSaidaT60S50Formatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(valorSaidaT60S50);
	}
	
	
	
	private float valorSaidaT60S50;
	public float getValorSaidaT60S50()
	{
		return valorSaidaT60S50;
	}
	public  void setValorSaidaT60S50(float value)
	{
		valorSaidaT60S50 = value; 
	}
	
	
	
	public String getValorSaidaT70S50Formatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(valorSaidaT70S50);
	}
	
	
	
	private float valorSaidaT70S50;
	public float getValorSaidaT70S50()
	{
		return valorSaidaT70S50;
	}
	public  void setValorSaidaT70S50(float value)
	{
		valorSaidaT70S50 = value; 
	}
	
	
	
	
	
	private String dataHoraSaidaT40S60;
	public String getDataHoraSaidaT40S60()
	{
		return dataHoraSaidaT40S60;
	}
	public  void setDataHoraSaidaT40S60(String value)
	{
		dataHoraSaidaT40S60 = value; 
	}
	
	
	
	
	
	private String dataHoraSaidaT50S60;
	public String getDataHoraSaidaT50S60()
	{
		return dataHoraSaidaT50S60;
	}
	public  void setDataHoraSaidaT50S60(String value)
	{
		dataHoraSaidaT50S60 = value; 
	}
	
	
	
	
	
	private String dataHoraSaidaT60S60;
	public String getDataHoraSaidaT60S60()
	{
		return dataHoraSaidaT60S60;
	}
	public  void setDataHoraSaidaT60S60(String value)
	{
		dataHoraSaidaT60S60 = value; 
	}
	
	
	
	
	
	private String dataHoraSaidaT70S60;
	public String getDataHoraSaidaT70S60()
	{
		return dataHoraSaidaT70S60;
	}
	public  void setDataHoraSaidaT70S60(String value)
	{
		dataHoraSaidaT70S60 = value; 
	}
	
	
	
	
	
	private String dataHoraSaidaT40S50;
	public String getDataHoraSaidaT40S50()
	{
		return dataHoraSaidaT40S50;
	}
	public  void setDataHoraSaidaT40S50(String value)
	{
		dataHoraSaidaT40S50 = value; 
	}
	
	
	
	
	
	private String dataHoraSaidaT50S50;
	public String getDataHoraSaidaT50S50()
	{
		return dataHoraSaidaT50S50;
	}
	public  void setDataHoraSaidaT50S50(String value)
	{
		dataHoraSaidaT50S50 = value; 
	}
	
	
	
	
	
	private String dataHoraSaidaT60S50;
	public String getDataHoraSaidaT60S50()
	{
		return dataHoraSaidaT60S50;
	}
	public  void setDataHoraSaidaT60S50(String value)
	{
		dataHoraSaidaT60S50 = value; 
	}
	
	
	
	
	
	private String dataHoraSaidaT70S50;
	public String getDataHoraSaidaT70S50()
	{
		return dataHoraSaidaT70S50;
	}
	public  void setDataHoraSaidaT70S50(String value)
	{
		dataHoraSaidaT70S50 = value; 
	}
	
	
	
	public String getValorAcaoFormatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(valorAcao);
	}
	
	
	
	private float valorAcao;
	public float getValorAcao()
	{
		return valorAcao;
	}
	public  void setValorAcao(float value)
	{
		valorAcao = value; 
	}
	
	
	
	public String getLimiteDiaT50S50Formatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(limiteDiaT50S50);
	}
	
	
	
	private float limiteDiaT50S50;
	public float getLimiteDiaT50S50()
	{
		return limiteDiaT50S50;
	}
	public  void setLimiteDiaT50S50(float value)
	{
		limiteDiaT50S50 = value; 
	}
	
	
	
	public String getLimiteDiaT60S60Formatada()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(limiteDiaT60S60);
	}
	
	
	
	private float limiteDiaT60S60;
	public float getLimiteDiaT60S60()
	{
		return limiteDiaT60S60;
	}
	public  void setLimiteDiaT60S60(float value)
	{
		limiteDiaT60S60 = value; 
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
