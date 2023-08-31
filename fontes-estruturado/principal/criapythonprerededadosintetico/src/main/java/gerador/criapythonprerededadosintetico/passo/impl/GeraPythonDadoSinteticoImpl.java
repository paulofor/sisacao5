package gerador.criapythonprerededadosintetico.passo.impl;


import java.text.Normalizer;

import org.json.JSONArray;

import br.com.gersis.loopback.modelo.ExperimentoPreRede;
import gerador.criapythonprerededadosintetico.passo.*;
import gerador.jupyter.CelulaNotebook;



public class GeraPythonDadoSinteticoImpl extends GeraPythonDadoSintetico {

	private NotebookPreRedeDadoSintetico notebook = new NotebookPreRedeDadoSintetico();
	
	@Override
	protected boolean executaCustom(ExperimentoPreRede experimentoCorrente) {
		notebook.setExperimento(experimentoCorrente);
		notebook.geraNotebook();
		return true;
	} 


}

