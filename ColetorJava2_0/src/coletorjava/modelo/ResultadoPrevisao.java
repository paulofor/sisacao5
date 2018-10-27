package coletorjava.modelo;

import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface ResultadoPrevisao extends DCIObjetoDominio , ResultadoPrevisaoAgregadoI , ResultadoPrevisaoDerivadaI
{

	
	public long getIdResultadoPrevisao();
	public void setIdResultadoPrevisao(long valor);
	
	
	public long getQtdeVerdadeiroPostivo();
	public void setQtdeVerdadeiroPostivo(long valor);
	
	
	public long getQtdeFalsoPositivo();
	public void setQtdeFalsoPositivo(long valor);
	
	
	public long getQtdeTotal();
	public void setQtdeTotal(long valor);
	
	
	public long getPercentualSucessoPrevisao();
	public void setPercentualSucessoPrevisao(long valor);
	
	
	public float getPercentualPrecisao();
	public void setPercentualPrecisao(float valor);
	
	
	public String getUltimaAlteracao();
	public void setUltimaAlteracao(String valor);
	
	
	public long getIdDadoThetaGd();
	public void setIdDadoThetaGd(long valor);
	
	
	public long getIdResultadoMesMp();
	public void setIdResultadoMesMp(long valor);
	
	
	public long getIdMesAnoRa();
	public void setIdMesAnoRa(long valor);
	
	
}

