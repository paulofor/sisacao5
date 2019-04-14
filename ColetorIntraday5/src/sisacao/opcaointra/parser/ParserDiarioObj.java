package sisacao.opcaointra.parser;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import sisacao.opcaointra.cotacao.CotacaoDiario;

public class ParserDiarioObj {

	static String diretorioArquivos = "download";
	
	static List<CotacaoDiario> listaCotacao = null;

	public void inicio(String dataAAAAMMDD) {
		File[] arquivos = arquivosDia(dataAAAAMMDD);
		listaCotacao = new ArrayList<CotacaoDiario>();
		for (File file : arquivos) {
			System.out.println("Arquivo: " + file.getAbsolutePath());
			executaParse(file);
		}
	}

	private static File[] arquivosDia(String dataAAAAMMDD) {
		// create new filename filter
		final String inicioArquivo = "BVBG.086.01_BV000328" + dataAAAAMMDD;
		FilenameFilter fileNameFilter = new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				if (name.length() < inicioArquivo.length())
					return false;
				return (name.substring(0, inicioArquivo.length()).compareTo(inicioArquivo) == 0);
			}
		};

		File folder = new File(diretorioArquivos);
		return folder.listFiles(fileNameFilter);
	}

	private static void executaParse(File inputFile) {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("PricRpt");
			System.out.println("----------------------------");
			System.out.println("nList.getLength(): " + nList.getLength());

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					String ticker = eElement.getElementsByTagName("TckrSymb").item(0).getTextContent();
					NodeList lista = eElement.getElementsByTagName("MktDataStrmId");
					if (lista.getLength() > 0) {

						String tipo = eElement.getElementsByTagName("MktDataStrmId").item(0).getTextContent();
						if ("E".equals(tipo)) {
							CotacaoDiario novo = new CotacaoDiario(ticker);
							System.out.println("Ticker: " + ticker);
							String fec = eElement.getElementsByTagName("LastPric").item(0).getTextContent();
							String min = eElement.getElementsByTagName("MinPric").item(0).getTextContent();
							String max = eElement.getElementsByTagName("MaxPric").item(0).getTextContent();
							String abe = eElement.getElementsByTagName("FrstPric").item(0).getTextContent();
							String neg = eElement.getElementsByTagName("RglrTxsQty").item(0).getTextContent();
							String vol = eElement.getElementsByTagName("RglrTraddCtrcts").item(0).getTextContent();
						}
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
