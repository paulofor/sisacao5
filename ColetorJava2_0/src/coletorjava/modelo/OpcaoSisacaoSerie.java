package coletorjava.modelo;

import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface OpcaoSisacaoSerie extends DCIObjetoDominio , OpcaoSisacaoSerieAgregadoI , OpcaoSisacaoSerieDerivadaI
{

	
	public long getIdOpcaoSisacaoSerie();
	public void setIdOpcaoSisacaoSerie(long valor);
	
	
	public String getMesAno();
	public void setMesAno(String valor);
	
	
	public String getLetra();
	public void setLetra(String valor);
	
	
	public String getDataVencimento();
	public void setDataVencimento(String valor);
	
	
	public String getDataInicioColeta();
	public void setDataInicioColeta(String valor);
	
	
	public boolean getConstruida();
	public void setConstruida(boolean valor);
	
	
	public boolean getPossuiIntraday();
	public void setPossuiIntraday(boolean valor);
	
	
}

