package coletorjava.modelo;

import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface CotacaoProcessadaOpcaoResultado extends DCIObjetoDominio , CotacaoProcessadaOpcaoResultadoAgregadoI , CotacaoProcessadaOpcaoResultadoDerivadaI
{

	
	public long getIdCotacaoProcessadaOpcaoResultado();
	public void setIdCotacaoProcessadaOpcaoResultado(long valor);
	
	
	public String getData();
	public void setData(String valor);
	
	
	public String getHoraSerieTemporal();
	public void setHoraSerieTemporal(String valor);
	
	
	public long getContadorDia();
	public void setContadorDia(long valor);
	
	
	public String getCodigoMercadoOpcao();
	public void setCodigoMercadoOpcao(String valor);
	
	
	public float getValorOpcao();
	public void setValorOpcao(float valor);
	
	public String getValorOpcaoFormatada();
	
	
	public long getResultadoT70S60();
	public void setResultadoT70S60(long valor);
	
	
	public long getResultadoT60S60();
	public void setResultadoT60S60(long valor);
	
	
	public long getResultadoT50S60();
	public void setResultadoT50S60(long valor);
	
	
	public long getResultadoT40S60();
	public void setResultadoT40S60(long valor);
	
	
	public long getResultadoT70S50();
	public void setResultadoT70S50(long valor);
	
	
	public long getResultadoT60S50();
	public void setResultadoT60S50(long valor);
	
	
	public long getResultadoT50S50();
	public void setResultadoT50S50(long valor);
	
	
	public long getResultadoT40S50();
	public void setResultadoT40S50(long valor);
	
	
	public float getValorSaidaT40S60();
	public void setValorSaidaT40S60(float valor);
	
	public String getValorSaidaT40S60Formatada();
	
	
	public float getValorSaidaT50S60();
	public void setValorSaidaT50S60(float valor);
	
	public String getValorSaidaT50S60Formatada();
	
	
	public float getValorSaidaT60S60();
	public void setValorSaidaT60S60(float valor);
	
	public String getValorSaidaT60S60Formatada();
	
	
	public float getValorSaidaT70S60();
	public void setValorSaidaT70S60(float valor);
	
	public String getValorSaidaT70S60Formatada();
	
	
	public float getValorSaidaT40S50();
	public void setValorSaidaT40S50(float valor);
	
	public String getValorSaidaT40S50Formatada();
	
	
	public float getValorSaidaT50S50();
	public void setValorSaidaT50S50(float valor);
	
	public String getValorSaidaT50S50Formatada();
	
	
	public float getValorSaidaT60S50();
	public void setValorSaidaT60S50(float valor);
	
	public String getValorSaidaT60S50Formatada();
	
	
	public float getValorSaidaT70S50();
	public void setValorSaidaT70S50(float valor);
	
	public String getValorSaidaT70S50Formatada();
	
	
	public String getDataHoraSaidaT40S60();
	public void setDataHoraSaidaT40S60(String valor);
	
	
	public String getDataHoraSaidaT50S60();
	public void setDataHoraSaidaT50S60(String valor);
	
	
	public String getDataHoraSaidaT60S60();
	public void setDataHoraSaidaT60S60(String valor);
	
	
	public String getDataHoraSaidaT70S60();
	public void setDataHoraSaidaT70S60(String valor);
	
	
	public String getDataHoraSaidaT40S50();
	public void setDataHoraSaidaT40S50(String valor);
	
	
	public String getDataHoraSaidaT50S50();
	public void setDataHoraSaidaT50S50(String valor);
	
	
	public String getDataHoraSaidaT60S50();
	public void setDataHoraSaidaT60S50(String valor);
	
	
	public String getDataHoraSaidaT70S50();
	public void setDataHoraSaidaT70S50(String valor);
	
	
	public float getValorAcao();
	public void setValorAcao(float valor);
	
	public String getValorAcaoFormatada();
	
	
	public float getLimiteDiaT50S50();
	public void setLimiteDiaT50S50(float valor);
	
	public String getLimiteDiaT50S50Formatada();
	
	
	public float getLimiteDiaT60S60();
	public void setLimiteDiaT60S60(float valor);
	
	public String getLimiteDiaT60S60Formatada();
	
	
	public long getIdOpcaoSisacaoRa();
	public void setIdOpcaoSisacaoRa(long valor);
	
	
}

