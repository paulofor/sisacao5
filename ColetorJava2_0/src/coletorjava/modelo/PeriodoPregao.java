package coletorjava.modelo;

import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface PeriodoPregao extends DCIObjetoDominio , PeriodoPregaoAgregadoI , PeriodoPregaoDerivadaI
{

	
	public long getIdPeriodoPregao();
	public void setIdPeriodoPregao(long valor);
	
	
	public String getHoraInicio();
	public void setHoraInicio(String valor);
	
	
	public String getHoraTermino();
	public void setHoraTermino(String valor);
	
	
	public String getDataInicioPeriodo();
	public void setDataInicioPeriodo(String valor);
	
	
	public String getDataTerminoPeriodo();
	public void setDataTerminoPeriodo(String valor);
	
	
}

