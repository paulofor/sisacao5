package coletorjava.modelo;

import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface MesAno extends DCIObjetoDominio , MesAnoAgregadoI , MesAnoDerivadaI
{

	
	public long getIdMesAno();
	public void setIdMesAno(long valor);
	
	
	public String getNomeMes();
	public void setNomeMes(String valor);
	
	
	public long getNumeroAno();
	public void setNumeroAno(long valor);
	
	
	public String getMesAnoData();
	public void setMesAnoData(String valor);
	
	
	public long getNumeroMes();
	public void setNumeroMes(long valor);
	
	
}

