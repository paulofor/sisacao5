 package cotacaojava2.regracolecao;
 
 import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Set;

import javax.xml.rpc.ServiceException;

import br.com.digicom.cotacao.dao.CotacaoDiarioDao;
import br.com.digicom.cotacao.vo.CotacaoDiario;
import br.com.digicom.cotacao.vo.CotacaoDiarioOpcao;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.util.ArquivoLog;
import cotacaojava2.dao.DBB;
import cotacaojava2.webservice.CotacaoDiarioFiltro;
import cotacaojava2.webservice.CotacaoDiarioObjetoWs;
import cotacaojava2.webservice.CotacaoDiarioWSLocator;
import cotacaojava2.webservice.CotacaoDiarioWSSoap;
 
 public class CotacaoDiarioRegraColecaoImpl
 {
	 
	private CotacaoDiarioWSLocator locator = null;
    private CotacaoDiarioWSSoap ws = null;
     
    private CotacaoDiarioWSSoap getCotacaoDiarioWS() throws ServiceException {
	   if (ws==null) {
		   locator = new CotacaoDiarioWSLocator();
		   ws = locator.getCotacaoDiarioWSSoap();
	   }
	   return ws;
    }
	 
   public void leArquivoDiario(String nomeArquivo, Set listaAtivos, Set listaOnline, String dataPregao)
     throws IOException, DaoException
   {
     int qtdeTotal = 0;
     int qtdeAte50Neg = 0;
     int qtdeAte100Neg = 0;
     int qtdeAte200Neg = 0;
     int qtdeAte300Neg = 0;
     int qtdeAte500Neg = 0;
     int qtdeObservacao = 0;
     boolean emObservacao = false;
     int qtdeAte50NegObs = 0;
     int qtdeAte100NegObs = 0;
     int qtdeAte200NegObs = 0;
     int qtdeAte300NegObs = 0;
     int qtdeAte500NegObs = 0;
 
     CotacaoDiarioDao dao = DBB.getInstancia().getCotacaoDiarioDao();
     DaoConexao conn = dao.criaConexao();
     dao.setConexao(conn);
 
     File arquivo = new File(nomeArquivo);
     BufferedReader reader = null;
     reader = new BufferedReader(new FileReader(arquivo));
     String linha = reader.readLine();
     while ((linha = reader.readLine()) != null) {
       CotacaoDiario cotacao = new CotacaoDiario();
       cotacao.extraiLinhaArquivoDiario(linha);
       cotacao.setDataDD_MM_AAAA(dataPregao);
 
       if (listaAtivos.contains(cotacao.getTicker())) {
         emObservacao = true;
         System.out.println("InsereDiario:" + cotacao.imprime());
         qtdeObservacao++;
         dao.insereCotacao(cotacao, cotacao.getTicker());
       } else {
         emObservacao = false;
         if (cotacao.candidatoAcompanhamento()) {
           ArquivoLog.getInstancia().salvaLog(cotacao.imprime());
         }
       }
       
       try {
    	   if (listaOnline.contains(cotacao.getTicker())) {
    		   insereOnline(cotacao,cotacao.getTicker());
    	   }
       } catch (Exception e) {
    	   ArquivoLog.getInstancia().salvaLog("Erro insereOnline:" + e.getMessage());
       }
       
       if (cotacao.isAcao()) {
         qtdeTotal++;
         if (cotacao.getNegocios() <= 50L) {
           qtdeAte50Neg++;
           if (emObservacao) qtdeAte50NegObs++;
         }
         if (cotacao.getNegocios() <= 100L) {
           qtdeAte100Neg++;
           if (emObservacao) qtdeAte100NegObs++;
         }
         if (cotacao.getNegocios() <= 200L) {
           qtdeAte200Neg++;
           if (emObservacao) qtdeAte200NegObs++;
         }
         if (cotacao.getNegocios() <= 300L) {
           qtdeAte300Neg++;
           if (emObservacao) qtdeAte300NegObs++;
         }
         if (cotacao.getNegocios() <= 500L) {
           qtdeAte500Neg++;
           if (!emObservacao) continue; qtdeAte500NegObs++;
         }
       }
     }
     ArquivoLog.getInstancia().salvaLog("Total:" + qtdeTotal + 
       ", 50:" + qtdeAte50Neg + "(" + qtdeAte50NegObs + ")" + 
       ", +50:" + (qtdeTotal - qtdeAte50Neg) + "(" + (qtdeTotal - qtdeAte50Neg - (qtdeObservacao - qtdeAte50NegObs)) + ")" + 
       ", +100:" + (qtdeTotal - qtdeAte100Neg) + "(" + (qtdeTotal - qtdeAte100Neg - (qtdeObservacao - qtdeAte100NegObs)) + ")" + 
       ", +300:" + (qtdeTotal - qtdeAte300Neg) + "(" + (qtdeTotal - qtdeAte300Neg - (qtdeObservacao - qtdeAte300NegObs)) + ")" + 
       ", +500:" + (qtdeTotal - qtdeAte500Neg) + "(" + (qtdeTotal - qtdeAte500Neg - (qtdeObservacao - qtdeAte500NegObs)) + ")" + 
       ", Observação:" + qtdeObservacao);
     dao.liberaConexao(conn);
   }
   
   private void insereOnline(CotacaoDiario cotacao, String ticker) throws RemoteException, ServiceException{
	   CotacaoDiarioObjetoWs cotacaoWs = new CotacaoDiarioObjetoWs();
	   cotacaoWs.setAberturaCorrigido(cotacao.getAbertura());
	   cotacaoWs.setAberturaOriginal(cotacao.getAbertura());
	   cotacaoWs.setData(cotacao.getDataDD_MM_AAAA());
	   cotacaoWs.setFechamentoCorrigido(cotacao.getFechamento());
	   cotacaoWs.setFechamentoOriginal(cotacao.getFechamento());
	   cotacaoWs.setMaximoCorrigido(cotacao.getMaximo());
	   cotacaoWs.setMaximoOriginal(cotacao.getMaximo());
	   cotacaoWs.setMinimoCorrigido(cotacao.getMinimo());
	   cotacaoWs.setMinimoOriginal(cotacao.getMinimo());
	   cotacaoWs.setNegocios(cotacao.getNegocios());
	   cotacaoWs.setVolume(cotacao.getVolume());
	   
	   CotacaoDiarioFiltro filtro = new CotacaoDiarioFiltro();
	   filtro.setCotacao(cotacaoWs);
	   filtro.setNomeTicker(ticker);
	   this.getCotacaoDiarioWS().insereCotacaoDia(filtro);
	   
   }
 
	public void leArquivoDiarioOpcao(String nomeArquivo, Set listaAtivos, String dataPregao) throws IOException, DaoException {
     CotacaoDiarioDao dao = DBB.getInstancia().getCotacaoDiarioOpcaoDao();
     DaoConexao conn = dao.criaConexao();
     dao.setConexao(conn);
 
     File arquivo = new File(nomeArquivo);
     BufferedReader reader = null;
     reader = new BufferedReader(new FileReader(arquivo));
     String linha = reader.readLine();
     while ((linha = reader.readLine()) != null) {
       CotacaoDiarioOpcao cotacao = new CotacaoDiarioOpcao();
       cotacao.extraiLinhaArquivoDiario(linha);
       cotacao.setDataDD_MM_AAAA(dataPregao);
 
       if (listaAtivos.contains(cotacao.getTicker())) {
         System.out.println("InsereDiarioOpcao:" + cotacao.imprime());
         ArquivoLog.getInstancia().salvaLog("InsereDiarioOpcao:" + cotacao.imprime());
         dao.insereCotacao(cotacao, cotacao.getTicker());
       }
       if (cotacao.isOpcao()) {
    	   try {
    		   dao.insereOpcaoSeNecessario(cotacao);
    	   } catch (Exception e) {
    		   // Nao pode parar
    	   }
       }
       
       else if (cotacao.candidatoAcompanhamento()) {
         ArquivoLog.getInstancia().salvaLog(cotacao.imprime());
       }
     }
 
     dao.liberaConexao(conn);
   }
 
   public void leArquivoHistorico(String nomeArquivo, Set listaAtivos)
     throws IOException, DaoException
   {
     CotacaoDiarioDao dao = DBB.getInstancia().getCotacaoDiarioDao();
     DaoConexao conn = dao.criaConexao();
     dao.setConexao(conn);
 
     File arquivo = new File(nomeArquivo);
     BufferedReader reader = null;
     reader = new BufferedReader(new FileReader(arquivo));
     String linha = reader.readLine();
     while ((linha = reader.readLine()) != null) {
       CotacaoDiario cotacao = new CotacaoDiario();
       cotacao.extraiLinhaArquivo(linha);
 
       if (listaAtivos.contains(cotacao.getTicker())) {
         System.out.println("Insere:" + cotacao.imprime());
         dao.insereCotacao(cotacao, cotacao.getTicker());
       }
     }
     dao.liberaConexao(conn);
   }
 
   public void insereCotacao()
   {
   }
 }

