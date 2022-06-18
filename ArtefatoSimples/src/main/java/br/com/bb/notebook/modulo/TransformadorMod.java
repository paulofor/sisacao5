package br.com.bb.notebook.modulo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import br.com.bb.notebook.CelulaNotebook;

public class TransformadorMod {

	public void insereArquivo(CelulaNotebook celula, String nomeArquivo) {
		FileInputStream fstream;
		try {
			fstream = new FileInputStream(nomeArquivo);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			while ((strLine = br.readLine()) != null)   {
				strLine = strLine.replaceAll("\t", "  ");
				celula.adicionaLinha("" + strLine + " ");
			}
			fstream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
