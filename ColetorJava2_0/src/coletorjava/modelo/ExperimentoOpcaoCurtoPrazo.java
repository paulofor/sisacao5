package coletorjava.modelo;

import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface ExperimentoOpcaoCurtoPrazo extends DCIObjetoDominio , ExperimentoOpcaoCurtoPrazoAgregadoI , ExperimentoOpcaoCurtoPrazoDerivadaI
{

	
	public long getIdExperimentoOpcaoCurtoPrazo();
	public void setIdExperimentoOpcaoCurtoPrazo(long valor);
	
	
	public String getDescricaoExperimento();
	public void setDescricaoExperimento(String valor);
	
	
}

