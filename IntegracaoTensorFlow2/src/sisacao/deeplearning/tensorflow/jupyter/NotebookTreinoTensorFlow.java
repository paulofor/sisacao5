package sisacao.deeplearning.tensorflow.jupyter;

import org.json.JSONArray;

import br.com.digicom.sisacao.modelo.TreinoRede;

public class NotebookTreinoTensorFlow extends NotebookObj {

	private TreinoRede treinoRede;
	
	
	
	public TreinoRede getTreinoRede() {
		return treinoRede;
	}

	public void setTreinoRede(TreinoRede treinoRede) {
		this.treinoRede = treinoRede;
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
		enviaRede(notebook);
		registraTreinamento(notebook);
	}
	
	private void registraTreinamento(JSONArray notebook) {
		CelulaNotebook celula = new CelulaNotebook();
		celula.setTitulo("Registra Treinamento", 1);
		celula.adicionaLinha("#import requests");
		celula.adicionaLinha("url = 'http://vps-40d69db1.vps.ovh.ca:23004/api/TreinoRedes/executouTreinamento'");
		celula.adicionaLinha("myobj = {'id': " + this.getTreinoRede().getId() + "}");
		celula.adicionaLinha("x = requests.post(url, json = myobj)");
		celula.adicionaLinha("print(x.text)");
		insereCelula(notebook,celula);
		//celula = new CelulaNotebook();
	}
	
	private void enviaRede(JSONArray notebook) {
		CelulaNotebook celula = new CelulaNotebook();
		celula.setTitulo("Enviando Rede", 1);
		insereCelula(notebook,celula);
		celula = new CelulaNotebook();
		
		celula.adicionaLinha("!pip install paramiko");
		insereCelula(notebook,celula);
		celula = new CelulaNotebook();
		
		celula.adicionaLinha("import os");
		celula.adicionaLinha("import paramiko");
		insereCelula(notebook,celula);
		celula = new CelulaNotebook();
		
		celula.adicionaLinha("ssh = paramiko.SSHClient()");
		celula.adicionaLinha("ssh.set_missing_host_key_policy(paramiko.AutoAddPolicy())");
		celula.adicionaLinha("ssh.connect(\"191.252.219.136\", username=\"root\", password=\"digicom2004%\")");
		celula.adicionaLinha("sftp = ssh.open_sftp()");
		celula.adicionaLinha("sftp.put(\"pesos/treino_rede" + this.getTreinoRede().getId() + ".h5\", \"/root/executa-rede/redes/treino_rede" + this.getTreinoRede().getId() + ".h5\")");
		celula.adicionaLinha("sftp.close()");
		celula.adicionaLinha("ssh.close()");
		insereCelula(notebook,celula);

	}
	
	
	private void estruturaRede(JSONArray notebook) {
		CelulaNotebook celula = new CelulaNotebook();
		celula.setTitulo("Minha Rede", 1);
		insereCelula(notebook,celula);
		celula = new CelulaNotebook();
		
		celula.setTitulo("Estrutra", 2);
		celula.adicionaLinha(this.getTreinoRede().getRedeNeural().getEstrutura());
		celula.adicionaLinha("model.summary()");
		insereCelula(notebook,celula);
	}
	private void compilacaoRede(JSONArray notebook) {
		CelulaNotebook celula = new CelulaNotebook();
		celula.setTitulo("Compilacao", 2);
		celula.adicionaLinha(this.getTreinoRede().getRedeNeural().getCompilacao());
		insereCelula(notebook,celula);
	}
	
	private void fitRede(JSONArray notebook) {
		CelulaNotebook celula = new CelulaNotebook();
		celula.setTitulo("Fit - Treino", 2);
		celula.adicionaLinha(this.getTreinoRede().getRedeNeural().getFitTreinamento());
		insereCelula(notebook,celula);
	}
	private void salvaRede(JSONArray notebook) {
		CelulaNotebook celula = new CelulaNotebook();
		celula.setTitulo("Salva Rede", 2);
		celula.adicionaLinha("path='pesos/treino_rede" + this.getTreinoRede().getId() + ".h5'");
		celula.adicionaLinha("model.save(path)");
		insereCelula(notebook,celula);
	}
	
	private void dadosValidacao(JSONArray notebook) {
		CelulaNotebook celula = new CelulaNotebook();
		celula.setTitulo("Dados Validacao", 1);
		celula.adicionaLinha("diaInicio = '" + this.treinoRede.getPeriodoTreinoRede().getDiaNumInicioValidacao() + "'");
		celula.adicionaLinha("diaFinal = '" + this.treinoRede.getPeriodoTreinoRede().getDiaNumFinalValidacao() + "'");
		celula.adicionaLinha("idGrupo = '" + this.treinoRede.getGrupoAcaoId() + "'");
		celula.adicionaLinha("idRegra = '" + this.treinoRede.getRegraProjecaoId() + "'");
		celula.adicionaLinha("idTipo = '" + this.treinoRede.getTipoExemploTreinoId() + "'");
		celula.adicionaLinha("urlValida = 'http://vps-40d69db1.vps.ovh.ca:23004/api/ExemploTreinoAcaoSaidas/listaParaTreino?diaNumInicio={}&diaNumFinal={}&idGrupoAcao={}&idRegraProjecao={}&idTipoExemplo={}'.format(diaInicio,diaFinal,idGrupo,idRegra,idTipo)");;
		insereCelula(notebook,celula);
		
		celula = new CelulaNotebook();
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
		celula.adicionaLinha("diaInicio = '" + this.treinoRede.getPeriodoTreinoRede().getDiaNumInicioTreino() + "'");
		celula.adicionaLinha("diaFinal = '" + this.treinoRede.getPeriodoTreinoRede().getDiaNumFinalTreino() + "'");
		celula.adicionaLinha("idGrupo = '" + this.treinoRede.getGrupoAcaoId() + "'");
		celula.adicionaLinha("idRegra = '" + this.treinoRede.getRegraProjecaoId() + "'");
		celula.adicionaLinha("idTipo = '" + this.treinoRede.getTipoExemploTreinoId() + "'");
		celula.adicionaLinha("url = 'http://vps-40d69db1.vps.ovh.ca:23004/api/ExemploTreinoAcaoSaidas/listaParaTreino?diaNumInicio={}&diaNumFinal={}&idGrupoAcao={}&idRegraProjecao={}&idTipoExemplo={}'.format(diaInicio,diaFinal,idGrupo,idRegra,idTipo)");;
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
