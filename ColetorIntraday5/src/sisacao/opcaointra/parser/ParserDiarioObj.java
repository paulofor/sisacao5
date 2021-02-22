package sisacao.opcaointra.parser;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.util.DCConvert;
import coletorjava.modelo.CotacaoDiario;
import coletorjava.modelo.FabricaVo;
import coletorjava.regracolecao.CotacaoDiarioRegraColecao;
import coletorjava.regracolecao.FabricaRegra;
import sisacao.opcaointra.cotacao.CotacaoDiarioOld;

public class ParserDiarioObj {

	static String diretorioArquivos = "download";
	
	static List<CotacaoDiarioOld> listaCotacao = null;
	
	
	static List<CotacaoDiario> listaAcao = new ArrayList<CotacaoDiario>();
	static List<CotacaoDiario> listaOpcao = new ArrayList<CotacaoDiario>();
	
	static Map<String,CotacaoDiario> mapaAcao = new HashMap<String,CotacaoDiario>();
	
	static CotacaoDiarioRegraColecao cotacaoDiarioRegra;
	
	public ParserDiarioObj() {
		cotacaoDiarioRegra = FabricaRegra.getInstancia().getCotacaoDiarioRegraColecao();
	}
	
	
	public void inicio(String dataAAAAMMDD) {
		File[] arquivos = arquivosDia(dataAAAAMMDD);
		if (arquivos.length==0) {
			System.out.println("Não tem arquivos de " + dataAAAAMMDD);
			return;
		}
		Arrays.sort(arquivos);
		listaCotacao = new ArrayList<CotacaoDiarioOld>();
		File file = arquivos[arquivos.length-1];
		//for (File file : arquivos) {
		System.out.println("Arquivo: " + file.getAbsolutePath());
		executaParse(file,dataAAAAMMDD);
		//}
	}

	private File[] arquivosDia(String dataAAAAMMDD) {
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
	
	private boolean ehOpcao(String ticker) {
		boolean saida = (Character.isLetter(ticker.charAt(0)) && 
				Character.isLetter(ticker.charAt(1)) && 
				Character.isLetter(ticker.charAt(2)) && 
				Character.isLetter(ticker.charAt(3)) && 
				Character.isLetter(ticker.charAt(4)) && 
				Character.isDigit(ticker.charAt(5)) );
		return saida;
		
	}
	private boolean ehAcao(String ticker) {
		boolean saida = (Character.isLetter(ticker.charAt(0)) && 
				Character.isLetter(ticker.charAt(1)) && 
				Character.isLetter(ticker.charAt(2)) && 
				Character.isLetter(ticker.charAt(3)) && 
				Character.isDigit(ticker.charAt(4)) &&
				ticker.charAt(ticker.length()-1) != 'F' &&
				ticker.length() <= 7);
		if (saida)
			saida = !"18".equals(ticker.substring(ticker.length()-2));
		if (saida)
			saida = !"19".equals(ticker.substring(ticker.length()-2));
		return saida;
	}
	
	private void persisteCotacaoAcao() throws DaoException {
		cotacaoDiarioRegra.setListaEntradaItem(mapaAcao.values());
		cotacaoDiarioRegra.InsereListaAcao();
	}
	private void persisteCotacaoOpcao() {
		cotacaoDiarioRegra.setListaEntradaItem(listaOpcao);
	}

	private void executaParse(File inputFile, String data) {
		Element eElement = null;
		String ticker = null;
		String tipo = null;
		
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("PricRpt");
			//System.out.println("----------------------------");
			//System.out.println("nList.getLength(): " + nList.getLength());

			int contaItem = 0;
			listaAcao = new ArrayList<CotacaoDiario>();
			listaOpcao = new ArrayList<CotacaoDiario>();
			mapaAcao = new HashMap<String,CotacaoDiario>(); 
			
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					eElement = (Element) nNode;
					ticker = eElement.getElementsByTagName("TckrSymb").item(0).getTextContent();
					NodeList lista = eElement.getElementsByTagName("MktDataStrmId");
					if (lista.getLength() > 0) {

						tipo = eElement.getElementsByTagName("MktDataStrmId").item(0).getTextContent();
						if ("E".equals(tipo) && eElement.getElementsByTagName("LastPric").item(0)!=null) {
							contaItem++;
							CotacaoDiario novo = FabricaVo.criaCotacaoDiario();
							System.out.println(ticker);
							String fec = eElement.getElementsByTagName("LastPric").item(0).getTextContent();
							String min = eElement.getElementsByTagName("MinPric").item(0).getTextContent();
							String max = eElement.getElementsByTagName("MaxPric").item(0).getTextContent();
							String abe = eElement.getElementsByTagName("FrstPric").item(0).getTextContent();
							String neg = eElement.getElementsByTagName("RglrTxsQty").item(0).getTextContent();
							String vol = eElement.getElementsByTagName("RglrTraddCtrcts").item(0).getTextContent();
							Node nodePerc = eElement.getElementsByTagName("OscnPctg").item(0);
							String perc = (nodePerc!=null ? eElement.getElementsByTagName("OscnPctg").item(0).getTextContent() : "0");
							
							novo.setFechamentoOriginal(Float.parseFloat(fec));
							novo.setAberturaOriginal(Float.parseFloat(abe));
							novo.setNegocios(Integer.parseInt(neg));
							novo.setNomeTicker(ticker);
							novo.setMaximoOriginal(Float.parseFloat(max));
							novo.setMinimoOriginal(Float.parseFloat(min));
							novo.setVolume(Float.parseFloat(vol));
							novo.setData(data);
							novo.setPercentual(Float.parseFloat(perc));
							
							//listaAcao.add(novo);
							if (!mapaAcao.containsKey(novo.getNomeTicker())) {
								mapaAcao.put(novo.getNomeTicker(), novo);
							} else {
								System.out.println("Ticker: " + novo.getNomeTicker());
							}
								
							
							/*
							if (ehAcao(ticker)) {
								listaAcao.add(novo);
							}
							if (ehOpcao(ticker)) {
								listaOpcao.add(novo);
							}
							*/
							
							
						}
					}

				}
			}
			//System.out.println("Ações: " + listaAcao.size());
			//System.out.println("Opções: " + listaOpcao.size());
			//System.out.println("Itens: " + contaItem);
			
			this.persisteCotacaoAcao();
			//for (CotacaoDiario cotacao : listaAcao) {
			//	System.out.println(cotacao);
			//}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
