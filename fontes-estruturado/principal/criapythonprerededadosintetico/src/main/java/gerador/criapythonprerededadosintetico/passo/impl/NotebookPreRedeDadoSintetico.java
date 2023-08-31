package gerador.criapythonprerededadosintetico.passo.impl;

import java.text.Normalizer;

import org.json.JSONArray;

import br.com.gersis.loopback.modelo.ExperimentoPreRede;
import gerador.jupyter.CelulaNotebook;
import gerador.jupyter.NotebookObj;


public class NotebookPreRedeDadoSintetico extends NotebookObj{

	
	private ExperimentoPreRede experimento;
	
	public void setExperimento(ExperimentoPreRede experimento) {
		this.experimento = experimento;
	}
	

	

	public String getNomeArquivo() {
		return "ExperimentoSintetico_" 
				+ this.experimento.getVersaoPreRede().getPreRedeNeural().getNome() 
				+ "_v" + this.experimento.getVersaoPreRede().getNumero();
				
				
	}
	
	@Override
	protected void montaScript(JSONArray notebook) {
		importacoes(notebook);

		// tradicional
		conexaoServidor(notebook);
		if (this.experimento.getAmostraDadoSinteticoEntrada2Id()!=0) {
			conexaoServidor2(notebook);
		}
		//dadosValidacao(notebook);

		estruturaRede(notebook);
		compilacaoRede(notebook);
		fitRede(notebook);
		salvaRede(notebook);
		enviaRede(notebook);
	}
	
	private void salvaRede(JSONArray notebook) {
		CelulaNotebook celula = new CelulaNotebook();
		celula.setTitulo("Salva Rede", 2);
		celula.adicionaLinha("path='pesos/" + this.getNomeArquivo() + ".h5'");
		celula.adicionaLinha("model.save(path)");
		insereCelula(notebook,celula);
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
		celula.adicionaLinha("ssh.connect(\"191.252.219.136\", username=\"root\", password=\"Digicom2004$\")");
		celula.adicionaLinha("sftp = ssh.open_sftp()");
		celula.adicionaLinha("sftp.put(\"pesos/" + this.getNomeArquivo() + ".h5\", \"/root/executa-rede/redes/" + this.getNomeArquivo() + ".h5\")");
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
		celula.adicionaLinha(this.experimento.getVersaoPreRede().getEstrutura());
		celula.adicionaLinha("model.summary()");
		insereCelula(notebook,celula);
		
		celula = new CelulaNotebook();
		celula.adicionaLinha("tf.keras.utils.plot_model(model, show_shapes=True)");
		insereCelula(notebook,celula);
	}
	private void compilacaoRede(JSONArray notebook) {
		CelulaNotebook celula = new CelulaNotebook();
		celula.setTitulo("Compilacao", 2);
		celula.adicionaLinha(this.experimento.getVersaoPreRede().getCompilacao());
		insereCelula(notebook,celula);
	}
	
	private void fitRede(JSONArray notebook) {
		CelulaNotebook celula = new CelulaNotebook();
		celula.setTitulo("Fit - Treino", 2);
		celula.adicionaLinha(this.experimento.getVersaoPreRede().getFitTreinamento());
		insereCelula(notebook,celula);
	}

	
	
	
	private void importacoes(JSONArray notebook) {
		CelulaNotebook celula = new CelulaNotebook();
		celula.setTitulo("Instalação", 1);
		celula.adicionaLinha("import tensorflow as tf");
		celula.adicionaLinha("import pkg_resources");
		celula.adicionaLinha("");
		celula.adicionaLinha("required_version = '2.12.0'");
		celula.adicionaLinha("");
		celula.adicionaLinha("# Verificar se o TensorFlow já está instalado e obter a versão");
		celula.adicionaLinha("try:");
		celula.adicionaLinha("	version = pkg_resources.get_distribution(\"tensorflow\").version");
		celula.adicionaLinha("except pkg_resources.DistributionNotFound:");
		celula.adicionaLinha("	version = None");
		celula.adicionaLinha("");
		celula.adicionaLinha("# Verificar a versão e instalar se necessário");
		celula.adicionaLinha("if version is None or version != required_version:");
		celula.adicionaLinha("	print(f\"Instalando TensorFlow {required_version}...\")");
		celula.adicionaLinha("	!pip install tensorflow=={required_version}");
		celula.adicionaLinha("else:");
		celula.adicionaLinha("	print(f\"Versão do TensorFlow {version} já está instalada.\")");
		insereCelula(notebook,celula);
		
		//celula = new CelulaNotebook();
		//celula.setTitulo("Importacoes", 1);
		//celula.adicionaLinha("import tensorflow as tf");
		//insereCelula(notebook,celula);
		

		
		celula = new CelulaNotebook();
		celula.setTitulo("Importacoes", 1);
		celula.adicionaLinha("import requests");
		celula.adicionaLinha("import pandas as pd");
		celula.adicionaLinha("import numpy as np");
		insereCelula(notebook,celula);
	}
	
	
	
	
	
	
	private void conexaoServidor(JSONArray notebook) {
		CelulaNotebook celula = new CelulaNotebook();
		celula.setTitulo("Dados Treino " + this.experimento.getVersaoPreRede().getPreRedeNeural().getNome() + " (entrada 1) " , 1);
		celula.adicionaLinha("idAmostra = '" + this.experimento.getAmostraDadoSinteticoEntrada1Id() + "'");
		celula.adicionaLinha("url = 'http://vps-40d69db1.vps.ovh.ca:23004/api/ExemploDadoSinteticos/listaPorAmostraParaTreino?idAmostra={}'.format(idAmostra)");;
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
		celula.adicionaLinha("Entrada1 = np.stack(dfTratadoX.values)");
		celula.adicionaLinha("Entrada1.shape");
		insereCelula(notebook,celula);
		
		celula = new CelulaNotebook();
		celula.adicionaLinha("Y = np.stack(df['campoY'].values)");
		celula.adicionaLinha("Saida1 = Y.reshape(-1,1).astype(int)");
		celula.adicionaLinha("Saida1.shape");
		insereCelula(notebook,celula);
		
		
		celula = new CelulaNotebook();
		celula.adicionaLinha("# Verificar se há valores não numéricos");
		celula.adicionaLinha("has_non_numeric = np.isnan(Entrada1).any() or np.isinfEntrada1).any()");
		celula.adicionaLinha("if has_non_numeric:");
		celula.adicionaLinha("    print(\"O array contém valores não numéricos.\")");
		celula.adicionaLinha("else:");
		celula.adicionaLinha("    print(\"O array contém apenas valores numéricos.\")");
		insereCelula(notebook,celula);
		
		celula = new CelulaNotebook();
		celula.adicionaLinha("# Verificar se há valores não numéricos");
		celula.adicionaLinha("has_non_numeric = np.issubdtype(Saida1.dtype, np.number) is False");
		celula.adicionaLinha("if has_non_numeric:");
		celula.adicionaLinha("    print(\"O array contém valores não numéricos.\")");
		celula.adicionaLinha("else:");
		celula.adicionaLinha("    print(\"O array contém apenas valores numéricos.\")");
		insereCelula(notebook,celula);
		
	}
	
	private void conexaoServidor2(JSONArray notebook) {
		CelulaNotebook celula = new CelulaNotebook();
		celula.setTitulo("Dados Treino " + this.experimento.getVersaoPreRede().getPreRedeNeural().getNome() + " (entrada 1) " , 1);
		celula.adicionaLinha("idAmostra = '" + this.experimento.getAmostraDadoSinteticoEntrada2Id() + "'");
		celula.adicionaLinha("url = 'http://vps-40d69db1.vps.ovh.ca:23004/api/ExemploDadoSinteticos/listaPorAmostraParaTreino?idAmostra={}'.format(idAmostra)");;
		insereCelula(notebook,celula);
		
		celula = new CelulaNotebook();
		celula.adicionaLinha("print(url)");
		insereCelula(notebook,celula);
		
		celula = new CelulaNotebook();
		celula.adicionaLinha("r = requests.get(url)");
		celula.adicionaLinha("j = r.json()");
		celula.adicionaLinha("df = pd.DataFrame.from_dict(j)");
		insereCelula(notebook,celula);
		
		//celula = new CelulaNotebook();
		//celula.adicionaLinha("def trataLinhaX(linha):");
		//celula.adicionaLinha("    return np.fromstring(linha['campoX'], dtype=float, sep=',')");
		//insereCelula(notebook,celula);
		
		celula = new CelulaNotebook();
		celula.adicionaLinha("dfTratadoX = df.apply(trataLinhaX, axis='columns')");
		celula.adicionaLinha("Entrada2 = np.stack(dfTratadoX.values)");
		celula.adicionaLinha("Entrada2.shape");
		insereCelula(notebook,celula);
		
		celula = new CelulaNotebook();
		celula.adicionaLinha("Y = np.stack(df['campoY'].values)");
		celula.adicionaLinha("Saida2 = Y.reshape(-1,1).astype(int)");
		celula.adicionaLinha("Saida2.shape");
		insereCelula(notebook,celula);
		
		
		celula = new CelulaNotebook();
		celula.adicionaLinha("# Verificar se há valores não numéricos");
		celula.adicionaLinha("has_non_numeric = np.isnan(Entrada2).any() or np.isinf(Entrada2).any()");
		celula.adicionaLinha("if has_non_numeric:");
		celula.adicionaLinha("    print(\"O array contém valores não numéricos.\")");
		celula.adicionaLinha("else:");
		celula.adicionaLinha("    print(\"O array contém apenas valores numéricos.\")");
		insereCelula(notebook,celula);
		
		celula = new CelulaNotebook();
		celula.adicionaLinha("# Verificar se há valores não numéricos");
		celula.adicionaLinha("has_non_numeric = np.issubdtype(Saida2.dtype, np.number) is False");
		celula.adicionaLinha("if has_non_numeric:");
		celula.adicionaLinha("    print(\"O array contém valores não numéricos.\")");
		celula.adicionaLinha("else:");
		celula.adicionaLinha("    print(\"O array contém apenas valores numéricos.\")");
		insereCelula(notebook,celula);
		
	}


	public String removerAcentos(String texto) {
	    String textoSemAcentos = Normalizer.normalize(texto, Normalizer.Form.NFD)
	        .replaceAll("[^\\p{ASCII}]", "");
	    return textoSemAcentos;
	}




	



	

}
