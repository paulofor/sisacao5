package coletorjava.modelo;

import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface RegraEntrada extends DCIObjetoDominio , RegraEntradaAgregadoI , RegraEntradaDerivadaI
{

	
	public long getIdRegraEntrada();
	public void setIdRegraEntrada(long valor);
	
	
	public String getNomeRegra();
	public void setNomeRegra(String valor);
	
	
}

