package sisacao.deeplearning.tensorflow.jupyter;

import org.json.JSONArray;

import br.com.digicom.sisacao.modelo.RedeNeural;

public class NotebookTreinoTensorFlow extends NotebookObj {

	private RedeNeural rede = null;
	
	public void setRedeNeural(RedeNeural rede) {
		this.rede = rede;
	}
	
	
	@Override
	protected void montaScript(JSONArray notebook) {
		importacoes(notebook);
		conexaoServidor(notebook);
		dadosValidacao(notebook);
		estruturaRede(notebook);
		compilacaoRede(notebook);
		fitRede(notebook);
		salvaRede(notebook);
		
	}
	
	private void estruturaRede(JSONArray notebook) {
		CelulaNotebook celula = new CelulaNotebook();
		celula.setTitulo("Minha Rede", 1);
		insereCelula(notebook,celula);
		celula = new CelulaNotebook();
		
		celula.setTitulo("Estrutra", 2);
		celula.adicionaLinha(this.rede.getEstrutura());
		celula.adicionaLinha("model.summary()");
		insereCelula(notebook,celula);
	}
	private void compilacaoRede(JSONArray notebook) {
		CelulaNotebook celula = new CelulaNotebook();
		celula.setTitulo("Compilacao", 2);
		celula.adicionaLinha(this.rede.getCompilacao());
		insereCelula(notebook,celula);
	}
	
	private void fitRede(JSONArray notebook) {
		CelulaNotebook celula = new CelulaNotebook();
		celula.setTitulo("Fit - Treino", 2);
		celula.adicionaLinha(this.rede.getFitTreinamento());
		insereCelula(notebook,celula);
	}
	private void salvaRede(JSONArray notebook) {
		CelulaNotebook celula = new CelulaNotebook();
		celula.setTitulo("Salva Rede", 2);
		celula.adicionaLinha("path='pesos/rede" + this.rede.getId() + ".h5'");
		celula.adicionaLinha("model.save(path)");
		insereCelula(notebook,celula);
	}
	
	private void dadosValidacao(JSONArray notebook) {
		CelulaNotebook celula = new CelulaNotebook();
		celula.setTitulo("Dados Validacao", 1);
		celula.adicionaLinha("urlValida = \"http://vps-40d69db1.vps.ovh.ca:23005/api/ExemploTreinoAcaos/obtemConjuntoDesenvolvimento?idPeriodo={}&codigoGrupoAcao={}&codigoRegraProjecao={}\".format(codigoPeriodo,codigoGrupo,codigoRegra)");
		celula.adicionaLinha("print(urlValida)");
		insereCelula(notebook,celula);
		
		celula = new CelulaNotebook();
		celula.adicionaLinha("r = requests.get(urlValida)");
		celula.adicionaLinha("j = r.json()");
		celula.adicionaLinha("dfValida = pd.DataFrame.from_dict(j)");
		insereCelula(notebook,celula);
		
		celula = new CelulaNotebook();
		celula.adicionaLinha("dfValida.head()");
		insereCelula(notebook,celula);
		
		celula = new CelulaNotebook();
		celula.adicionaLinha("dfTratadoValidaX = dfValida.apply(trataLinhaX, axis='columns')");
		celula.adicionaLinha("XValida = np.stack(dfTratadoValidaX.values)");
		celula.adicionaLinha("XValida.shape");
		insereCelula(notebook,celula);
		
		celula = new CelulaNotebook();
		celula.adicionaLinha("YValida = np.stack(dfValida['campoY'].values)");
		celula.adicionaLinha("YValida = YValida.reshape(-1,1)");
		celula.adicionaLinha("YValida.shape");
		insereCelula(notebook,celula);
		
	}
	
	
	
	private void importacoes(JSONArray notebook) {
		CelulaNotebook celula = new CelulaNotebook();
		celula.setTitulo("Importacoes", 1);
		celula.adicionaLinha("import tensorflow as tf");
		insereCelula(notebook,celula);
		
		celula = new CelulaNotebook();
		celula.adicionaLinha("print(tf.__version__)");
		insereCelula(notebook,celula);
		
		celula = new CelulaNotebook();
		celula.adicionaLinha("import requests");
		celula.adicionaLinha("import pandas as pd");
		celula.adicionaLinha("import numpy as np");
		insereCelula(notebook,celula);
	}
	
	private void conexaoServidor(JSONArray notebook) {
		CelulaNotebook celula = new CelulaNotebook();
		celula.setTitulo("Conectando com servidor", 1);
		celula.adicionaLinha("codigoGrupo = 'Neg-100'");
		celula.adicionaLinha("codigoPeriodo = '11'");
		celula.adicionaLinha("codigoRegra = 't11s17v'");
		celula.adicionaLinha("url = 'http://vps-40d69db1.vps.ovh.ca:23005/api/ExemploTreinoAcaos/obtemConjuntoTreino?idPeriodo={}&codigoGrupoAcao={}&codigoRegraProjecao={}'.format(codigoPeriodo,codigoGrupo,codigoRegra)");;
		insereCelula(notebook,celula);
		
		celula = new CelulaNotebook();
		celula.adicionaLinha("print(url)");
		insereCelula(notebook,celula);
		
		celula = new CelulaNotebook();
		celula.adicionaLinha("r = requests.get(url)");
		celula.adicionaLinha("j = r.json()");
		celula.adicionaLinha("df = pd.DataFrame.from_dict(j)");
		insereCelula(notebook,celula);
		
		celula = new CelulaNotebook();
		celula.adicionaLinha("def trataLinhaX(linha):");
		celula.adicionaLinha("    return np.fromstring(linha['campoX'], dtype=float, sep=',')");
		insereCelula(notebook,celula);
		
		celula = new CelulaNotebook();
		celula.adicionaLinha("dfTratadoX = df.apply(trataLinhaX, axis='columns')");
		celula.adicionaLinha("X = np.stack(dfTratadoX.values)");
		celula.adicionaLinha("X.shape");
		insereCelula(notebook,celula);
		
		celula = new CelulaNotebook();
		celula.adicionaLinha("Y = np.stack(df['campoY'].values)");
		celula.adicionaLinha("Y = Y.reshape(-1,1)");
		celula.adicionaLinha("Y.shape");
		insereCelula(notebook,celula);
	}

}
