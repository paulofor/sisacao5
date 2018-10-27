package coletorjava.modelo;

import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface Cotacao extends DCIObjetoDominio , CotacaoAgregadoI , CotacaoDerivadaI
{

	
	public long getId();
	public void setId(long valor);
	
	
	public long getNeg();
	public void setNeg(long valor);
	
	
	public String getData();
	public void setData(String valor);
	
	
	public float getUlt();
	public void setUlt(float valor);
	
	public String getUltFormatada();
	
	
	public String getHoraReal();
	public void setHoraReal(String valor);
	
	
	public String getHoraNeg();
	public void setHoraNeg(String valor);
	
	
}

