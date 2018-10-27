package coletorjava.modelo;

import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface OpcaoReferencia extends DCIObjetoDominio , OpcaoReferenciaAgregadoI , OpcaoReferenciaDerivadaI
{

	
	public long getIdOpcaoReferencia();
	public void setIdOpcaoReferencia(long valor);
	
	
	public String getCodigoMercado();
	public void setCodigoMercado(String valor);
	
	
	public String getData();
	public void setData(String valor);
	
	
	public long getIdTickerRa();
	public void setIdTickerRa(long valor);
	
	
	public long getIdDiaPregaoRa();
	public void setIdDiaPregaoRa(long valor);
	
	
	public long getIdOpcaoSisacaoRa();
	public void setIdOpcaoSisacaoRa(long valor);
	
	
}

