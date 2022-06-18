package br.com.bb;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import br.com.bb.notebook.CelulaNotebook;
import br.com.bb.notebook.modulo.SparkBasicoMod;
import br.com.bb.notebook.modulo.SparkScriptSqlMod;

public class NotebookSql extends NotebookObj{

	private SparkBasicoMod sparkBasico = null;
	private SparkScriptSqlMod sparkSql = null;
	
	public NotebookSql() {
		this.sparkBasico = new SparkBasicoMod();
		this.sparkSql = new SparkScriptSqlMod();
	}
	
	@Override
	protected void montaScript(JSONArray notebook)  {
		try {
			// bbmagic
			this.sparkBasico.bbmagic(notebook);
			
			// spark
			String baseDados = this.getProp().getString("base_dados");
			boolean db2 =  "db2".equals(baseDados);
			this.sparkBasico.parametrosSpark(notebook,db2, this.getProp());
			this.sparkBasico.sessaoSpark(notebook,db2);
			
			//String sandbox = this.getProp().getString("sandbox");
			
			// importações Spark
			this.sparkSql.importacoes(notebook);
			
			// Tabelas
			CelulaNotebook celula = new CelulaNotebook();
			celula.setTitulo("Tabelas",1);
			notebook.putAll(celula.getJSON());
			
			JSONArray arquivos = this.getProp().getJSONArray("tabelas");
			for (int i=0;i<arquivos.length();i++) {
				JSONObject item = arquivos.getJSONObject(i);
				this.sparkSql.script(notebook, this.getProp(), (i+1));
				if (db2) {
					this.sparkSql.executaScriptDb2(notebook,(i+1));
				} else {
					//this.sparkSql.executaScriptHive(notebook,this.getProp(), (i+1));
					String[] campos = {"dt_ref"};
					this.sparkSql.executaScriptHive(notebook,this.getProp(), (i+1), campos);
				}
				
				this.sparkBasico.persisteDataframe(notebook,this.getProp(),(i+1),db2);
			}
			this.sparkBasico.finalizaSpark(notebook);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
