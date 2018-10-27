package coletorjava.modelo;

import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface Ticker extends DCIObjetoDominio , TickerAgregadoI , TickerDerivadaI
{

	
	public long getIdTicker();
	public void setIdTicker(long valor);
	
	
	public String getNome();
	public void setNome(String valor);
	
	
	public String getEmpresa();
	public void setEmpresa(String valor);
	
	
	public String getTipoAcao();
	public void setTipoAcao(String valor);
	
	
	public String getDataInicioDiario();
	public void setDataInicioDiario(String valor);
	
	
	public String getDataMaisRecenteDiario();
	public void setDataMaisRecenteDiario(String valor);
	
	
	public String getDataInicioColetaOpcao();
	public void setDataInicioColetaOpcao(String valor);
	
	
	public String getDataFinalColetaOpcao();
	public void setDataFinalColetaOpcao(String valor);
	
	
}

