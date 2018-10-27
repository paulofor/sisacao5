package coletorjava.modelo;

import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface TreinoRede extends DCIObjetoDominio , TreinoRedeAgregadoI , TreinoRedeDerivadaI
{

	
	public long getIdTreinoRede();
	public void setIdTreinoRede(long valor);
	
	
	public float getLambda();
	public void setLambda(float valor);
	
	
	public long getIteracoes();
	public void setIteracoes(long valor);
	
	
	public String getUltimaAlteracao();
	public void setUltimaAlteracao(String valor);
	
	
	public long getIdRedePa();
	public void setIdRedePa(long valor);
	
	
	public long getIdDadoTreinoGp();
	public void setIdDadoTreinoGp(long valor);
	
	
}

