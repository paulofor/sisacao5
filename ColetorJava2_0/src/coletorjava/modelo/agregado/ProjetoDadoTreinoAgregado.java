package coletorjava.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletorjava.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class ProjetoDadoTreinoAgregado implements ProjetoDadoTreinoAgregadoI
	{
		
		private ProjetoDadoTreinoCarregador carregador = null;
		private ProjetoDadoTreinoCarregador getCarregador() {
			if (carregador==null) {
				carregador = new ProjetoDadoTreinoCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			if (vo.getTickerReferenteA(false) != null)
				vo.getTickerReferenteA(false).setConexaoCarregador(conexao);
			
		}
		
		
		private ProjetoDadoTreino vo;
		public ProjetoDadoTreinoAgregado(ProjetoDadoTreino item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
		private Ticker tickerReferenteA;
		// Montador Tradicional
		public Ticker getTickerReferenteA(boolean lazyloader) 
		{	
			if (lazyloader && tickerReferenteA==null)
			{
				try {
					getCarregador().CarregaItemTicker_ReferenteA(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return tickerReferenteA;
		} 
		public void setTickerReferenteA(Ticker value) 
		{	
			tickerReferenteA = value;
		} 
		/*
		public void setTickerReferenteAComReversao(Ticker value) 
		{	
			tickerReferenteA = value;
			System.out.println("Alteracao:" + tickerReferenteA);
			if (tickerReferenteA!=null)
				tickerReferenteA.addListaProjetoDadoTreino_Gera(vo);
		} 
		*/
		
		public void addListaTicker_ReferenteA(Ticker  value) 
		{	
			tickerReferenteA = value;
		} 
		public Ticker getCorrenteTicker_ReferenteA()
		{	
			return tickerReferenteA;
		} 
		
 		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
		public boolean existeListaDadoTreino_Gerou() {
			return listadadoTreinoGerou!= null;
		}
		private List<DadoTreino> listadadoTreinoGerou;
		public void setListaDadoTreino_Gerou(List<DadoTreino> value) 
		{	
			listadadoTreinoGerou = value;
		} 
		public List<DadoTreino> getListaDadoTreino_Gerou ()
		{	
			// ligando o LazyLoader
			//if (listadadoTreinoGerou == null)
			//{
            //	getCarregador().CarregaListaDadoTreino_Gerou(vo);
            //}
			return listadadoTreinoGerou;
			
		} 
		public void addListaDadoTreino_Gerou(DadoTreino value)
		{	
			criaVaziaListaDadoTreino_Gerou();
			listadadoTreinoGerou.add(value);
		} 
		public DadoTreino getCorrenteDadoTreino_Gerou()
		{	
			if (listadadoTreinoGerou==null || listadadoTreinoGerou.size()==0) return null;
			return listadadoTreinoGerou.get(listadadoTreinoGerou.size()-1);
		} 
		public void criaVaziaListaDadoTreino_Gerou() {
			if (listadadoTreinoGerou == null)
            {
            	listadadoTreinoGerou = new ArrayList<DadoTreino>();
            }
		}
 		
		public boolean existeListaResultadoMes_Gerou() {
			return listaresultadoMesGerou!= null;
		}
		private List<ResultadoMes> listaresultadoMesGerou;
		public void setListaResultadoMes_Gerou(List<ResultadoMes> value) 
		{	
			listaresultadoMesGerou = value;
		} 
		public List<ResultadoMes> getListaResultadoMes_Gerou ()
		{	
			// ligando o LazyLoader
			//if (listaresultadoMesGerou == null)
			//{
            //	getCarregador().CarregaListaResultadoMes_Gerou(vo);
            //}
			return listaresultadoMesGerou;
			
		} 
		public void addListaResultadoMes_Gerou(ResultadoMes value)
		{	
			criaVaziaListaResultadoMes_Gerou();
			listaresultadoMesGerou.add(value);
		} 
		public ResultadoMes getCorrenteResultadoMes_Gerou()
		{	
			if (listaresultadoMesGerou==null || listaresultadoMesGerou.size()==0) return null;
			return listaresultadoMesGerou.get(listaresultadoMesGerou.size()-1);
		} 
		public void criaVaziaListaResultadoMes_Gerou() {
			if (listaresultadoMesGerou == null)
            {
            	listaresultadoMesGerou = new ArrayList<ResultadoMes>();
            }
		}
 		
	}
