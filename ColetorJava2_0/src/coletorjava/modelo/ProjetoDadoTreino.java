package coletorjava.modelo;

import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface ProjetoDadoTreino extends DCIObjetoDominio , ProjetoDadoTreinoAgregadoI , ProjetoDadoTreinoDerivadaI
{

	
	public long getIdProjetoDadoTreino();
	public void setIdProjetoDadoTreino(long valor);
	
	
	public float getTarget();
	public void setTarget(float valor);
	
	
	public float getStop();
	public void setStop(float valor);
	
	
	public String getPosicaoCompraVenda();
	public void setPosicaoCompraVenda(String valor);
	
	
	public String getUltimaAlteracao();
	public void setUltimaAlteracao(String valor);
	
	
	public long getIdTickerRa();
	public void setIdTickerRa(long valor);
	
	
}

