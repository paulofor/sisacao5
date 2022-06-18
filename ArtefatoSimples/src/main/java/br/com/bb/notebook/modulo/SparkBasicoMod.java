package br.com.bb.notebook.modulo;

import org.json.JSONArray;
import org.json.JSONObject;

import br.com.bb.notebook.CelulaNotebook;

public class SparkBasicoMod {

	public void bbmagic(JSONArray notebook) {
		CelulaNotebook celula = new CelulaNotebook();
		celula.adicionaLinha("!pip install -r requirements.txt --user");
		notebook.putAll(celula.getJSON());
		celula = new CelulaNotebook();
		celula.setTitulo("Inicialização",1);
		celula.adicionaLinha("from bbmagic import Spark, Hdfs, Kinit");
		celula.adicionaLinha("import os");
		celula.adicionaLinha("import getpass");
		notebook.putAll(celula.getJSON());
		celula = new CelulaNotebook();
		celula.adicionaLinha("!kdestroy");
		notebook.putAll(celula.getJSON());
	}

	public void parametrosSpark(JSONArray notebook, boolean db2, JSONObject prop) {
		CelulaNotebook celula = new CelulaNotebook();
		String dominioDes = "sbx_" +prop.getString("sandbox");
		String sandbox = prop.getString("sandbox");
		String dominioProd = prop.getString("dominio_producao");
		celula.setTitulo("Parâmetros sessão Spark",1);
		celula.adicionaLinha("#CONSTANTES PARA DEFINIR A QUAL CLUSTER SE CONECTAR E O NOME DA SESSAO NO CONTEXTO DO NOTEBOOK E QUAL LINGUAGEM A SER UTILIZADA");
		celula.adicionaLinha("HDP_VERSION = 3  # type: int");
		celula.adicionaLinha("SESSION_NAME = \"carga_" + dominioDes + "\"  # type: str");
		celula.adicionaLinha("LANGUAGE = \"python\"");
		celula.adicionaLinha("");
		celula.adicionaLinha("#CONSTANTES QUE DEFINEM OS VALORES PARA DIMENSIONAMENTO DA SESSAO SPARK NO YARN");
		celula.adicionaLinha("DRIVER_MEMORY = \"2g\"  # type: str");
		celula.adicionaLinha("DRIVER_CORES = 2  # type: int");
		celula.adicionaLinha("EXECUTOR_CORES = 3  # type: int");
		celula.adicionaLinha("EXECUTOR_MEMORY = \"6g\"  # type: str");
		celula.adicionaLinha("NUM_EXECUTORS = 1  # type: int ");
		celula.adicionaLinha("");
		celula.adicionaLinha("#CONSTANTE QUE SERVE PARA CONFIGURAR PARAMETROSA DO SPARK CONFIG");
		celula.adicionaLinha("SPARK_CONF = {");
		celula.adicionaLinha("  \"spark.driver.memoryOverhead\": \"1G\",");
		celula.adicionaLinha("  \"spark.executor.memoryOverhead\": \"1G\",");
		celula.adicionaLinha("  \"spark.sql.broadcastTimeout\" : \"6000000\"");
		celula.adicionaLinha("}  # type: Dict[str, str]");
		celula.adicionaLinha("");
		celula.adicionaLinha("#CONSTANTE QUE SERVE PARA DEFINIR PARAMETROS A SEREM UTILIZADOS CONFORME AMBIENTE (MODELAGEM OU SCORAGE/PRODUCAO) NO QUAL O JOB SERA EXECUTADO ");
		celula.adicionaLinha("AMBIENTE = os.environ[\"AMBIENTE\"] ");
		celula.adicionaLinha("if AMBIENTE == \"MODELAGEM\":");
		celula.adicionaLinha("  ENV_VAR = {");
		if (db2) {
			celula.adicionaLinha("    \"DOMINIO\":\"" + sandbox + "\",");
			celula.adicionaLinha("    \"KEYTAB\": input(\"Matrícula SISBB:\"),");
			celula.adicionaLinha("    \"user\" : \"" + sandbox + "\" ,");
			celula.adicionaLinha("    \"password\" :  getpass.getpass(\"Informe a senha de " + sandbox + ": \") ,");
		} else {
			celula.adicionaLinha("    \"DOMINIO\":\"" + dominioDes + "\",");
			celula.adicionaLinha("    \"KEYTAB\": input(\"Matrícula SISBB:\"),");
		}
		celula.adicionaLinha("}");
		celula.adicionaLinha("else:");
		celula.adicionaLinha("  ENV_VAR = {");
		celula.adicionaLinha("    \"DOMINIO\":\"" + dominioProd + "\",");
		celula.adicionaLinha("    \"KEYTAB\": os.environ['KEYTAB']");
		celula.adicionaLinha("}");
		notebook.putAll(celula.getJSON());
		
	}

	public void sessaoSpark(JSONArray notebook, boolean db2) {
		CelulaNotebook celula = new CelulaNotebook();
		celula.setTitulo("Cria sessão Spark",1);
		celula.adicionaLinha("spark = Spark(");
		celula.adicionaLinha("  session_name= SESSION_NAME, ");
		celula.adicionaLinha("  username=  ENV_VAR[\"KEYTAB\"], ");
		celula.adicionaLinha("  hdp = HDP_VERSION, ");
		celula.adicionaLinha("  language = LANGUAGE, ");
		//celula.adicionaLinha("  driver_memory=DRIVER_MEMORY,");
		//celula.adicionaLinha("  driver_cores=DRIVER_CORES,");
		//celula.adicionaLinha("  executor_cores=EXECUTOR_CORES,");
		celula.adicionaLinha("  executor_memory=EXECUTOR_MEMORY,");
		//celula.adicionaLinha("  num_executors=NUM_EXECUTORS,");
		celula.adicionaLinha("  spark_conf=SPARK_CONF,");
		celula.adicionaLinha("  auth = 'Kerberos',");
		if (db2) {
			celula.adicionaLinha("  env = ENV_VAR,");
			celula.adicionaLinha("  db2=True");
		} else {
			celula.adicionaLinha("  env = ENV_VAR");
		}
		celula.adicionaLinha(")");
		notebook.putAll(celula.getJSON());
	}
	

	public void finalizaSpark(JSONArray notebook) {
		CelulaNotebook celula = new CelulaNotebook();
		celula.setTitulo("Finaliza sessão Spark");
		celula.adicionaLinha("%spark cleanup");
		notebook.putAll(celula.getJSON());
	}
	
	public void estruturaTabela(JSONArray notebook, JSONObject prop) {
		CelulaNotebook celula = new CelulaNotebook();
		JSONArray colunas = prop.getJSONArray("colunas");
		celula.setTitulo("Estrutura da Tabela");
		celula.adicionaLinha("%%spark");
		celula.adicionaLinha("from pyspark.sql.functions import *");
		celula.adicionaLinha("from pyspark.sql.types import DecimalType, DateType, DoubleType, IntegerType, LongType, ShortType, StringType, StructField, StructType");
		celula.adicionaLinha("schemaTab = StructType(");
		celula.adicionaLinha("    [");
		for (int i=0; i<colunas.length(); i++) {
			JSONObject coluna = colunas.getJSONObject(i);
			celula.adicionaLinha("        StructField(\"" + coluna.getString("nome") + "\", " + coluna.getString("tipo") + "Type(), True),");
		}
		celula.adicionaLinha("    ]");
		celula.adicionaLinha(")");
		notebook.putAll(celula.getJSON());
	}
	
	
	public void persisteDataframe(JSONArray notebook, JSONObject prop, int indice, boolean db2) {
		this.nomeTabela(notebook, prop, indice, db2);
		if (!db2) {
			//this.exclusaoParticao(notebook, indice);
		}
		//this.ordenacaoCamposTabela(notebook, indice, db);
		//this.insercaoDadoTabela(notebook, indice, db2);
		this.insercaoDadoTabelaSemParticao(notebook, indice, db2);
		if (!db2) {
			//this.resumoTabelaPorMes(notebook, indice, db2);
			this.resumoTabelaGeral(notebook, indice, db2);
		}
	}
	
	private void nomeTabela(JSONArray notebook, JSONObject prop, int indice, boolean db2) {
		CelulaNotebook celula = new CelulaNotebook();
		celula.setTitulo("Nome da tabela", 3);
		celula.adicionaLinha("%%spark");
		celula.adicionaLinha("");
		String dominio = prop.getString("dominio");
		String sandbox = prop.getString("sandbox");
		String tabela = prop.getJSONArray("tabelas").getJSONObject(indice-1).getString("tabela");
		celula.adicionaLinha("tabela" + indice + " = os.environ[\"DOMINIO\"] + \"." + tabela + "\"");
		notebook.putAll(celula.getJSON());
	}
	
	
	private void resumoTabelaPorMes(JSONArray notebook, int indice, boolean db2) {
		CelulaNotebook celula = new CelulaNotebook();
		celula.setTitulo("Total da tabela", 3);
		celula.adicionaLinha("%%spark");
		celula.adicionaLinha("");
		celula.adicionaLinha("#print(tabela" + indice + ")");
		celula.adicionaLinha("#dfResult = spark.sql(\"select * from \" + tabela" + indice + ")");
		celula.adicionaLinha("#dfResult.groupBy('aa_ref','mm_ref').count().show()");
		notebook.putAll(celula.getJSON());
	}
	private void resumoTabelaGeral(JSONArray notebook, int indice, boolean db2) {
		CelulaNotebook celula = new CelulaNotebook();
		celula.setTitulo("Total da tabela", 3);
		celula.adicionaLinha("%%spark");
		celula.adicionaLinha("");
		celula.adicionaLinha("print(tabela" + indice + ")");
		celula.adicionaLinha("dfResult = spark.sql(\"select * from \" + tabela" + indice + ")");
		celula.adicionaLinha("dfResult.groupBy('dt_ref').count().show()");
		notebook.putAll(celula.getJSON());
	}
	
	private void insercaoDadoTabelaSemParticao(JSONArray notebook, int indice, boolean db2) {
		CelulaNotebook celula = new CelulaNotebook();
		celula.setTitulo("Inserindo dados na tabela", 3);
		celula.adicionaLinha("%%time");
		celula.adicionaLinha("%%spark");
		celula.adicionaLinha("");
		if (!db2) {
			celula.adicionaLinha("df" + indice + ".write.mode(\"overwrite\").saveAsTable(tabela" + indice + ")");
		} else {
			celula.adicionaLinha("dfOrdenada.write\\");
			celula.adicionaLinha(" .format(\"jdbc\")\\");
			celula.adicionaLinha(" .option(\"url\", URL)\\");
			celula.adicionaLinha(" .option(\"driver\",\"com.ibm.db2.jcc.DB2Driver\")\\");
			celula.adicionaLinha(" .mode(\"append\")\\");
			celula.adicionaLinha(" .option(\"dbtable\", tabela" + indice +")\\");
			celula.adicionaLinha(" .option(\"user\", db2_user)\\");
			celula.adicionaLinha(" .option(\"password\",db2_password)\\");
			celula.adicionaLinha(" .save()");
		}
		notebook.putAll(celula.getJSON());
	}
	
	private void insercaoDadoTabela(JSONArray notebook, int indice, boolean db2) {
		CelulaNotebook celula = new CelulaNotebook();
		celula.setTitulo("Inserindo dados na tabela", 3);
		celula.adicionaLinha("%%time");
		celula.adicionaLinha("%%spark");
		celula.adicionaLinha("");
		if (!db2) {
			celula.adicionaLinha("dfOrdenada.write.insertInto(tabela" + indice + ")");
			celula.adicionaLinha("df" + indice + ".write.mode(\"overwrite\").saveAsTable(tabela" + indice + ")");
		} else {
			celula.adicionaLinha("dfOrdenada.write\\");
			celula.adicionaLinha(" .format(\"jdbc\")\\");
			celula.adicionaLinha(" .option(\"url\", URL)\\");
			celula.adicionaLinha(" .option(\"driver\",\"com.ibm.db2.jcc.DB2Driver\")\\");
			celula.adicionaLinha(" .mode(\"append\")\\");
			celula.adicionaLinha(" .option(\"dbtable\", tabela" + indice +")\\");
			celula.adicionaLinha(" .option(\"user\", db2_user)\\");
			celula.adicionaLinha(" .option(\"password\",db2_password)\\");
			celula.adicionaLinha(" .save()");
		}
		notebook.putAll(celula.getJSON());
	}
	
	// MODULO - ORDENACAO DE CAMPOS
	private void ordenacaoCamposTabela(JSONArray notebook, int indice, boolean db2) {
		CelulaNotebook celula = new CelulaNotebook();
		celula = new CelulaNotebook();
		celula.setTitulo("Estrutura de fonte e destino", 3);
		celula.adicionaLinha("%%spark");
		celula.adicionaLinha("");
		if (!db2) {
			celula.adicionaLinha("#dfDestino = spark.sql(\"select * from \" + tabela" + indice + " + \" limit 1\")");
		} else {
			celula.adicionaLinha("sql = \"select * from \" + tabela" + indice + " + \" limit 1\"");
			celula.adicionaLinha("dfDestino = reader.jdbc(");
			celula.adicionaLinha("    URL,");
			celula.adicionaLinha("    \" (\" + sql + \") as t\",");
			celula.adicionaLinha("    properties= {'user': db2_user, 'password': db2_password}");
			celula.adicionaLinha(")");
		}
		celula.adicionaLinha("#df" + indice + ".printSchema()");
		celula.adicionaLinha("#dfDestino.printSchema()");
		notebook.putAll(celula.getJSON());
		
		celula = new CelulaNotebook();
		celula.setTitulo("Ordenação de campos. Totais antes e depois.", 3);
		celula.adicionaLinha("%%spark");
		celula.adicionaLinha("");
		celula.adicionaLinha("#dfOrdenada = df" + indice + ".select(dfDestino.columns)");
		celula.adicionaLinha("");
		celula.adicionaLinha("#dfOrdenada.groupBy('aa_ref','mm_ref').count().show()");
		celula.adicionaLinha("#df" + indice + ".groupBy('aa_ref','mm_ref').count().show()");
		notebook.putAll(celula.getJSON());
		
	}
	
	
	// Modulo - PARTICAO
	private void exclusaoParticao(JSONArray notebook, int indice) {
		CelulaNotebook celula = new CelulaNotebook();
		celula.setTitulo("Comando de exclusão das partições", 3);
		celula.adicionaLinha("%%time");
		celula.adicionaLinha("%%spark");
		celula.adicionaLinha("");
		celula.adicionaLinha("#dfData" + indice + ".cache()");
		celula.adicionaLinha("#mes = int(dfData" + indice + ".first()['mm_ref'])");
		celula.adicionaLinha("#ano = int(dfData" + indice + ".first()['aa_ref'])");
		celula.adicionaLinha("#sqlParticao = \"ALTER TABLE \" + tabela" + indice + " + \" DROP IF EXISTS PARTITION(AA_REF= \" + str(ano) + \", MM_REF = \" + str(mes) + \")\"");
		celula.adicionaLinha("#sqlParticao10 = \"ALTER TABLE \" + tabela" + indice + " + \" DROP IF EXISTS PARTITION(AA_REF= \" + str(ano-10) + \", MM_REF = \" + str(mes) + \")\"");
		celula.adicionaLinha("#print(sqlParticao)");
		celula.adicionaLinha("#print(sqlParticao10)");
		notebook.putAll(celula.getJSON());
		
		celula = new CelulaNotebook();  
		celula.setTitulo("Execução de exclusão das partições", 3);
		celula.adicionaLinha("%%time");
		celula.adicionaLinha("%%spark");
		celula.adicionaLinha("");
		celula.adicionaLinha("#spark.sql(sqlParticao)");
		celula.adicionaLinha("#spark.sql(sqlParticao10)");
		celula.adicionaLinha("#spark.catalog.refreshTable(tabela" + indice +")");
		notebook.putAll(celula.getJSON());
	}

	public void trataArquivoParaTabela(JSONArray notebook, JSONObject prop) {
		// TODO Auto-generated method stub
		CelulaNotebook celula = new CelulaNotebook();
		String dominio = prop.getString("dominio");
		String sandbox = prop.getString("sandbox");
		String nomeArquivo = prop.getString("nome_arquivo");
		String tabela = prop.getString("nome_tabela");
		String coalesce = prop.getString("coalesce");
		celula.setTitulo("Leva arquivo para Tabela");
		//celula.adicionaLinha("%%spark");
		//celula.adicionaLinha("df = spark.read.option(\"delimiter\", \";\").option(\"header\", \"true\").csv(\"/dados/transientes/" + dominio + "/sbx_" + sandbox + "/dados_brutos/" + nomeArquivo + ".csv\");");
		celula.adicionaLinha("%%spark");
		celula.adicionaLinha("df = spark.read \\");
		celula.adicionaLinha("    .option(\"delimiter\", \";\") \\");
		celula.adicionaLinha("    .option(\"header\", \"true\") \\");
		celula.adicionaLinha("    .schema(schemaTab) \\");
		celula.adicionaLinha("    .csv(\"/dados/transientes/" + dominio + "/" + sandbox + "/dados_brutos/" + nomeArquivo  + ".csv\")");
		celula.adicionaLinha("df = df.coalesce(" + coalesce + ")");
		
		notebook.putAll(celula.getJSON());
		celula = new CelulaNotebook();
		celula.adicionaLinha("%%time");
		celula.adicionaLinha("%%spark");
		celula.adicionaLinha("");
		celula.adicionaLinha("df.write.format(\"orc\").mode(\"overwrite\").saveAsTable(\"sbx_" + sandbox + "." + tabela + "\",path=\"/dados/transientes/" + dominio + "/" + sandbox + "/hve/external/" + tabela +"\")");
		notebook.putAll(celula.getJSON());
	}

}
