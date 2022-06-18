package br.com.bb.notebook.modulo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;

import br.com.bb.notebook.CelulaNotebook;

public class SparkScriptSqlMod {
	
	public void script2(JSONArray notebook, JSONObject prop, int indice) throws IOException {
		CelulaNotebook celula = new CelulaNotebook();
		String tabela = prop.getJSONArray("tabelas").getJSONObject(indice-1).getString("tabela");
		//celula.setTitulo(tabela + "( #" + indice + " )",2);
		celula.setTitulo(" *** " + tabela + " ***",2);
		notebook.putAll(celula.getJSON());
		celula = new CelulaNotebook();
		celula.setTitulo("Sql",3);
		celula.adicionaLinha("%%spark");
		celula.adicionaLinha("sql" + indice + " = \\");
		String nomeArquivo = prop.getJSONArray("tabelas").getJSONObject(indice-1).getString("arquivo_sql");
		JSONArray listaTabela= null;
		String nomeTabela = null;
		try {
			listaTabela = prop.getJSONArray("tabelas").getJSONObject(indice-1).getJSONArray("replace_tabela");
		} catch (Exception e) {
			
		}
		FileInputStream fstream = new FileInputStream(nomeArquivo);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String strLine;
		while ((strLine = br.readLine()) != null)   {
			strLine = strLine.replaceAll("\t", "  ");
			if (listaTabela!=null) {
				for (int i=0;i<listaTabela.length();i++) {
					int posicao = listaTabela.getJSONObject(i).getInt("posicao");
					nomeTabela = listaTabela.getJSONObject(i).getString("nome");
					strLine = strLine.replaceFirst(nomeTabela, " \" + tabela" + posicao + " + \" ");
				}
			}
			celula.adicionaLinha("\"" + strLine + " \\n\" \\");
		}
		fstream.close();
		notebook.putAll(celula.getJSON());
		celula = new CelulaNotebook();
		celula.adicionaLinha("%%spark");
		celula.adicionaLinha("print(sql" + indice + ")");
		notebook.putAll(celula.getJSON());
	}
	

	public void script(JSONArray notebook, JSONObject prop, int indice) throws IOException {
		CelulaNotebook celula = new CelulaNotebook();
		String tabela = prop.getJSONArray("tabelas").getJSONObject(indice-1).getString("tabela");
		//celula.setTitulo(tabela + "( #" + indice + " )",2);
		celula.setTitulo(" *** " + tabela + " ***",2);
		notebook.putAll(celula.getJSON());
		celula = new CelulaNotebook();
		celula.setTitulo("Sql",3);
		celula.adicionaLinha("%%spark");
		celula.adicionaLinha("sql" + indice + " = '''");
		String nomeArquivo = prop.getJSONArray("tabelas").getJSONObject(indice-1).getString("arquivo_sql");
		JSONArray listaTabela= null;
		String nomeTabela = null;
		try {
			listaTabela = prop.getJSONArray("tabelas").getJSONObject(indice-1).getJSONArray("replace_tabela");
		} catch (Exception e) {
			
		}
		FileInputStream fstream = new FileInputStream(nomeArquivo);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String strLine;
		while ((strLine = br.readLine()) != null)   {
			strLine = strLine.replaceAll("\t", "  ");
			if (listaTabela!=null) {
				for (int i=0;i<listaTabela.length();i++) {
					int posicao = listaTabela.getJSONObject(i).getInt("posicao");
					nomeTabela = listaTabela.getJSONObject(i).getString("nome");
					strLine = strLine.replaceFirst(nomeTabela, " \" + tabela" + posicao + " + \" ");
				}
			}
			//celula.adicionaLinha("" + strLine + "\n");
			celula.adicionaLinha(strLine);
		}
		celula.adicionaLinha("''' \n");
		fstream.close();
		notebook.putAll(celula.getJSON());
		celula = new CelulaNotebook();
		celula.adicionaLinha("%%spark");
		celula.adicionaLinha("print(sql" + indice + ")");
		notebook.putAll(celula.getJSON());
	}
	
	public void importacoes(JSONArray notebook) {
		CelulaNotebook celula = new CelulaNotebook();
		celula.setTitulo("Importacoes",1);
		celula.adicionaLinha("%%spark");
		celula.adicionaLinha("");
		celula.adicionaLinha("import os");
		celula.adicionaLinha("");
		notebook.putAll(celula.getJSON());
	}
	
	
	public void executaScriptHive(JSONArray notebook, JSONObject prop, int indice) {
		JSONObject obj = prop.getJSONArray("tabelas").getJSONObject(indice-1);
		Integer coalesce = obj.getInt("coalesce");
		CelulaNotebook celula = new CelulaNotebook();
		celula.setTitulo("Dataframe",3);
		celula.adicionaLinha("%%time");
		celula.adicionaLinha("%%spark");
		celula.adicionaLinha("");
		celula.adicionaLinha("df" + indice + " = spark.sql(sql" + indice + ").coalesce(" + coalesce + ")");
		celula.adicionaLinha("dfData" + indice + " = df" + indice + ".groupBy('aa_ref','mm_ref').count()");
		celula.adicionaLinha("dfData" + indice + ".show()");
		//celula.adicionaLinha("df" + indice + ".printSchema()");
		notebook.putAll(celula.getJSON());
	}
	public void executaScriptHive(JSONArray notebook, JSONObject prop, int indice, String[] campos) {
		JSONObject obj = prop.getJSONArray("tabelas").getJSONObject(indice-1);
		Integer coalesce = obj.getInt("coalesce");
		String conteudoCampos = "";
		for (int i=0;i<campos.length;i++) {
			if (i==0) conteudoCampos += "'" + campos[i] + "'";
			else conteudoCampos += ",'" + campos[i] + "'";
		}
		CelulaNotebook celula = new CelulaNotebook();
		celula.setTitulo("Dataframe",3);
		celula.adicionaLinha("%%time");
		celula.adicionaLinha("%%spark");
		celula.adicionaLinha("");
		celula.adicionaLinha("df" + indice + " = spark.sql(sql" + indice + ").coalesce(" + coalesce + ")");
		celula.adicionaLinha("dfData" + indice + " = df" + indice + ".groupBy(" + conteudoCampos + ").count()");
		celula.adicionaLinha("dfData" + indice + ".show()");
		notebook.putAll(celula.getJSON());
	}
	
	public void executaScriptDb2(JSONArray notebook,int ind) {
		CelulaNotebook celula = new CelulaNotebook();
		celula.setTitulo("Cria dataframe com dados do DB2",3);
		celula.adicionaLinha("%%spark");
		celula.adicionaLinha("");
		celula.adicionaLinha("db2_user = os.environ['user']");
		celula.adicionaLinha("db2_password = os.environ['password']");
		celula.adicionaLinha("URL = 'jdbc:db2://gwdb2.bb.com.br:50100/BDB2P04'");
		celula.adicionaLinha("reader = spark.read.option(\"driver\", \"com.ibm.db2.jcc.DB2Driver\")");
		notebook.putAll(celula.getJSON());
		CelulaNotebook celula2 = new CelulaNotebook();
		celula2.adicionaLinha("%%spark");
		celula2.adicionaLinha("");
		celula2.adicionaLinha("df" + ind + " = reader.jdbc(");
		celula2.adicionaLinha("    URL,");
		celula2.adicionaLinha("    \" (\" + sql" + ind + " + \") as t\",");
		celula2.adicionaLinha("    properties= {'user': db2_user, 'password': db2_password}");
		celula2.adicionaLinha(")");
		celula2.adicionaLinha("df" + ind + ".count()");
		notebook.putAll(celula2.getJSON());
	}
}
