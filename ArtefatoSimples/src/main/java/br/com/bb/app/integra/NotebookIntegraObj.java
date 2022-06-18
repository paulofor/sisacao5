package br.com.bb.app.integra;

import org.json.JSONArray;

import br.com.bb.NotebookObj;
import br.com.bb.notebook.CelulaNotebook;

public class NotebookIntegraObj extends NotebookObj {
	
	private JSONArray install() {
		CelulaNotebook celula = new CelulaNotebook();
		celula.adicionaLinha("!pip install -r requirements.txt --user");
		return celula.getJSON();
	}

	private JSONArray bibliotecas() {
		CelulaNotebook celula = new CelulaNotebook();
		celula.adicionaLinha("# Bibliotecas");
		celula.adicionaLinha("import requests");
		celula.adicionaLinha("import pandas as pd");
		celula.adicionaLinha("import json");
		celula.adicionaLinha("import os");
		celula.adicionaLinha("from time import sleep");
		celula.adicionaLinha("from bbmagic import Spark, Hdfs");
		celula.adicionaLinha("from bs4 import BeautifulSoup as bs");
		celula.adicionaLinha("from urllib.request import urlopen, ProxyHandler, install_opener, build_opener");
		celula.adicionaLinha("from urllib.request import urlopen");
		return celula.getJSON();
	}
	
	private JSONArray ambiente() {
		CelulaNotebook celula = new CelulaNotebook();
		celula.setTitulo("Definindo variáveis de ambiente");
		celula.adicionaLinha("from dotenv import load_dotenv");
		celula.adicionaLinha("load_dotenv(dotenv_path='./ambiente.env')");
		return celula.getJSON();
	}
	
	private JSONArray variaveisSpark() {
		CelulaNotebook celula = new CelulaNotebook();
		celula.adicionaLinha("# Credenciais de Produção");
		celula.adicionaLinha("if os.environ[\"AMBIENTE\"] == \"PRODUCAO\":");
		celula.adicionaLinha("    # Colocando proxies para acessar sites exernos");
		celula.adicionaLinha("    proxy = ProxyHandler(proxies={})");
		celula.adicionaLinha("    opener = build_opener(proxy)");
		celula.adicionaLinha("    install_opener(opener)");
		celula.adicionaLinha("");
		celula.adicionaLinha("    env = {");
		celula.adicionaLinha("      \"AMBIENTE\": os.environ[\"AMBIENTE\"],");
		celula.adicionaLinha("      \"DATA\": os.environ.get('CTMODATE'),");
		celula.adicionaLinha("      \"END\": \"/dados/corporativos/d1f\",");
		celula.adicionaLinha("      \"KEYTAB\": os.environ.get('KEYTAB')}");
		celula.adicionaLinha("    print(\"CARREGADO: credenciais de Produção\")");
		celula.adicionaLinha("    print(env)");
		celula.adicionaLinha("# Credenciais de Desenvolvimento ");  
		celula.adicionaLinha("elif os.environ[\"AMBIENTE\"] == \"MODELAGEM\":");
		celula.adicionaLinha("    env = {");
		celula.adicionaLinha("      \"AMBIENTE\": os.environ[\"AMBIENTE\"],");
		celula.adicionaLinha("      \"DATA\": os.environ.get('CTMODATE'),");
		celula.adicionaLinha("      \"END\": \"/dados/transientes/d1f/d1f1ba6\",");
		celula.adicionaLinha("      \"KEYTAB\": os.environ.get('KEYTAB')}");
		celula.adicionaLinha("    print(\"CARREGADO: credenciais de Desenvolvimento\")");
		celula.adicionaLinha("    print(env)");
		celula.adicionaLinha("else:");
		celula.adicionaLinha("    print(\"FALHA AO CARREGAR CREDENCIAS!\")");
		return celula.getJSON();
	}
	
	@Override
	protected void montaScript(JSONArray notebook) {
		notebook.putAll(this.install());
		notebook.putAll(this.bibliotecas());
		notebook.putAll(this.ambiente());
		notebook.putAll(this.variaveisSpark());
	}
}
