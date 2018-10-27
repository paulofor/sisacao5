package coletorjava.modelo;

import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface OpcaoSisacao extends DCIObjetoDominio , OpcaoSisacaoAgregadoI , OpcaoSisacaoDerivadaI
{

	
	public long getIdOpcaoSisacao();
	public void setIdOpcaoSisacao(long valor);
	
	
	public String getCodigoMercado();
	public void setCodigoMercado(String valor);
	
	
	public float getPrecoExercicio();
	public void setPrecoExercicio(float valor);
	
	public String getPrecoExercicioFormatada();
	
	
	public String getDataInicioColeta();
	public void setDataInicioColeta(String valor);
	
	
	public long getIdOpcaoSisacaoSeriePa();
	public void setIdOpcaoSisacaoSeriePa(long valor);
	
	
	public long getIdTickerDd();
	public void setIdTickerDd(long valor);
	
	
}

