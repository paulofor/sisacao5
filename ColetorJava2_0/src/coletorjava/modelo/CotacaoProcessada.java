package coletorjava.modelo;

import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface CotacaoProcessada extends DCIObjetoDominio , CotacaoProcessadaAgregadoI , CotacaoProcessadaDerivadaI
{

	
	public long getIdCotacaoProcessada();
	public void setIdCotacaoProcessada(long valor);
	
	
	public String getHoraCotacaoTempoReal();
	public void setHoraCotacaoTempoReal(String valor);
	
	
	public float getValorTempoReal();
	public void setValorTempoReal(float valor);
	
	public String getValorTempoRealFormatada();
	
	
	public float getValorCorrigido();
	public void setValorCorrigido(float valor);
	
	public String getValorCorrigidoFormatada();
	
	
	public long getContadorDia();
	public void setContadorDia(long valor);
	
	
	public String getData();
	public void setData(String valor);
	
	
	public String getHoraSerieTemporal();
	public void setHoraSerieTemporal(String valor);
	
	
	public String getHoraCotacao();
	public void setHoraCotacao(String valor);
	
	
	public long getNegocios();
	public void setNegocios(long valor);
	
	
	public float getValor();
	public void setValor(float valor);
	
	public String getValorFormatada();
	
	
}

