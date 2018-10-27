package coletorjava.modelo;

import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface DadoTheta extends DCIObjetoDominio , DadoThetaAgregadoI , DadoThetaDerivadaI
{

	
	public long getIdDadoTheta();
	public void setIdDadoTheta(long valor);
	
	
	public String getNomeArquivo();
	public void setNomeArquivo(String valor);
	
	
	public String getUltimaAlteracao();
	public void setUltimaAlteracao(String valor);
	
	
	public long getIdTreinoRedeGp();
	public void setIdTreinoRedeGp(long valor);
	
	
}

