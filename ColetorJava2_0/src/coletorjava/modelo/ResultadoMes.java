package coletorjava.modelo;

import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface ResultadoMes extends DCIObjetoDominio , ResultadoMesAgregadoI , ResultadoMesDerivadaI
{

	
	public long getIdResultadoMes();
	public void setIdResultadoMes(long valor);
	
	
	public long getQtdeTotal();
	public void setQtdeTotal(long valor);
	
	
	public long getQtdeSucesso();
	public void setQtdeSucesso(long valor);
	
	
	public long getQtdeFracasso();
	public void setQtdeFracasso(long valor);
	
	
	public long getQtdeNeutro();
	public void setQtdeNeutro(long valor);
	
	
	public float getPercentualSucesso();
	public void setPercentualSucesso(float valor);
	
	
	public String getUltimaAlteracao();
	public void setUltimaAlteracao(String valor);
	
	
	public long getIdProjetoDadoTreinoGp();
	public void setIdProjetoDadoTreinoGp(long valor);
	
	
	public long getIdMesAnoRa();
	public void setIdMesAnoRa(long valor);
	
	
}

