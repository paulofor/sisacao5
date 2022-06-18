package br.com.bb;

import org.json.JSONArray;
import org.json.JSONException;

import br.com.bb.notebook.CelulaNotebook;
import br.com.bb.notebook.modulo.SparkBasicoMod;
import br.com.bb.notebook.modulo.TransformadorMod;

public class NotebookPlanilhaExterna extends NotebookObj {

	private SparkBasicoMod sparkBasico = null;
	private TransformadorMod transformador = null;
	
	public NotebookPlanilhaExterna() {
		this.sparkBasico = new SparkBasicoMod();
		this.transformador = new TransformadorMod();
	}
	
	@Override
	protected void montaScript(JSONArray notebook) {
		this.sparkBasico.bbmagic(notebook);
		this.sparkBasico.parametrosSpark(notebook, false, this.getProp());
		this.importacoes(notebook);
		this.obtendoArquivoExterno(notebook);
		this.ajusteDataframe(notebook);
		//this.ajustandoDataFrame(notebook);
		//this.colunas(notebook);
		this.salvaArquivoLocal(notebook);
		this.sparkBasico.sessaoSpark(notebook, false);
		this.sparkBasico.estruturaTabela(notebook, getProp());
		this.sparkBasico.trataArquivoParaTabela(notebook, getProp());
		this.sparkBasico.finalizaSpark(notebook);
		
		//this.sparkBasico.trataArquivoParaTabela(notebook,this.getProp())
	}
	
	private void ajusteDataframe(JSONArray notebook) {
		CelulaNotebook celula = new CelulaNotebook();
		celula.setTitulo("Ajustando o dataframe");
		String nomeArquivo = this.getProp().getString("transformacao");
		transformador.insereArquivo(celula,nomeArquivo);
		notebook.putAll(celula.getJSON());
	}

	private void colunas(JSONArray notebook) {
		CelulaNotebook celula = new CelulaNotebook();
		celula.setTitulo("Colunas");
		JSONArray colunas = this.getProp().getJSONArray("colunas");
		celula.adicionaLinha("colunas = " + colunas.toString());
		notebook.putAll(celula.getJSON());
		celula = new CelulaNotebook();
		celula.adicionaLinha("for x in range(len(colunas)):");
		celula.adicionaLinha("  defSemInicio = defSemInicio.rename(columns={ defSemInicio.columns[x]: colunas[x][\"nome\"] }, inplace = False)");
		celula.adicionaLinha("defColunas = defSemInicio.iloc[: , :len(colunas)-len(defSemInicio.columns)]");
		notebook.putAll(celula.getJSON());
		celula = new CelulaNotebook();
		celula.adicionaLinha("defColunas.head()");
		notebook.putAll(celula.getJSON());
	}
	
	private void ajustandoDataFrame(JSONArray notebook) {
		CelulaNotebook celula = new CelulaNotebook();
		celula.setTitulo("Retirada de linhas iniciais");
		int numLinhas = this.getProp().getInt("quantidade_linha_inicio");
		celula.adicionaLinha("linhas = " + numLinhas);
		celula.adicionaLinha("defSemInicio = dfSemEspacos.tail(len(dfSemEspacos.index) - linhas)");
		celula.adicionaLinha("defSemInicio.head(5)");
		notebook.putAll(celula.getJSON());
	}
	
	private void salvaArquivoLocal(JSONArray notebook) {
		CelulaNotebook celula = new CelulaNotebook();
		celula.setTitulo("Leva arquivo para HDFS");
		String nomeArquivo = this.getProp().getString("nome_arquivo");
		celula.adicionaLinha("planilha.to_csv('" + nomeArquivo + ".csv', sep = ';', index=False)");
		celula.adicionaLinha("hdfs = Hdfs(hdp=3)");
		String dominio = this.getProp().getString("dominio");
		String sandbox = this.getProp().getString("sandbox");
		celula.adicionaLinha("hdfs_path = '/dados/transientes/" + dominio + "/" + sandbox + "/dados_brutos/'");
		celula.adicionaLinha("local_path = '" + nomeArquivo + ".csv'");
		celula.adicionaLinha("hdfs.upload(hdfs_path=hdfs_path, local_path=local_path, overwrite=True)");
		notebook.putAll(celula.getJSON());
		
	}

	private void importacoes(JSONArray notebook) {
		CelulaNotebook celula = new CelulaNotebook();
		celula.setTitulo("Importação");
		celula.adicionaLinha("import requests");
		celula.adicionaLinha("import pandas as pd");
		celula.adicionaLinha("import numpy as np");
		celula.adicionaLinha("from datetime import date");
		notebook.putAll(celula.getJSON());
	}
	private void obtendoArquivoExterno(JSONArray notebook) {
		CelulaNotebook celula = new CelulaNotebook();
		celula.setTitulo("Obtem o arquivo para um dataframe");
		String url = this.getProp().getString("url");
		celula.adicionaLinha("url = \"" + url +"\"");
		celula.adicionaLinha("print(url)");
		celula.adicionaLinha("try:");
		celula.adicionaLinha("   r = requests.get(url, allow_redirects=True)");
		celula.adicionaLinha("except requests.exceptions.RequestException as e:  # This is the correct syntax");
		celula.adicionaLinha("   print('ocorreu erro')");
		celula.adicionaLinha("   print(e)");
		celula.adicionaLinha("   raise SystemExit(e)");
		notebook.putAll(celula.getJSON());
		celula = new CelulaNotebook();
		celula.adicionaLinha("open(\"" + this.getProp().getString("nome_arquivo") + ".xlsx\", 'wb').write(r.content)");
		notebook.putAll(celula.getJSON());
		celula = new CelulaNotebook();
		JSONArray planilhas = null;
		try {
			planilhas = this.getProp().getJSONArray("planilhas");
		} catch (JSONException e) {
			planilhas = null;
		}
		if (planilhas==null) {
			celula.adicionaLinha("dfBruto = pd.read_excel(\"" + this.getProp().getString("nome_arquivo") + ".xlsx\",engine='openpyxl')");
			celula.adicionaLinha("dfSemEspacos = dfBruto.applymap(lambda x: x.strip() if isinstance(x, str) else x)");
		} else {
			for (int i=0;i<planilhas.length();i++) {
				String nomePlanilha = planilhas.getJSONObject(i).getString("nome");
				celula.adicionaLinha("dfBruto" + i + " = pd.read_excel(\"" + this.getProp().getString("nome_arquivo") + ".xlsx\",engine='openpyxl',sheet_name='" + nomePlanilha + "')");
				celula.adicionaLinha("dfSemEspacos" + i + " = dfBruto" + i + ".applymap(lambda x: x.strip() if isinstance(x, str) else x)");
			}
		}
		notebook.putAll(celula.getJSON());
	}
}
