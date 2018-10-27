package coletorjava.modelo;

import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface DiaPregao extends DCIObjetoDominio , DiaPregaoAgregadoI , DiaPregaoDerivadaI
{

	
	public long getIdDiaPregao();
	public void setIdDiaPregao(long valor);
	
	
	public String getData();
	public void setData(String valor);
	
	
	public boolean getFeriado();
	public void setFeriado(boolean valor);
	
	
}

