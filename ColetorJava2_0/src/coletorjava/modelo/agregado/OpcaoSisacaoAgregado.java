package coletorjava.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletorjava.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class OpcaoSisacaoAgregado implements OpcaoSisacaoAgregadoI
	{
		
		private OpcaoSisacaoCarregador carregador = null;
		private OpcaoSisacaoCarregador getCarregador() {
			if (carregador==null) {
				carregador = new OpcaoSisacaoCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			if (vo.getOpcaoSisacaoSeriePertenceA(false) != null)
				vo.getOpcaoSisacaoSeriePertenceA(false).setConexaoCarregador(conexao);
			if (vo.getTickerDerivativoDe(false) != null)
				vo.getTickerDerivativoDe(false).setConexaoCarregador(conexao);
			
		}
		
		
		private OpcaoSisacao vo;
		public OpcaoSisacaoAgregado(OpcaoSisacao item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
		private OpcaoSisacaoSerie opcaoSisacaoSeriePertenceA;
		// Montador Tradicional
		public OpcaoSisacaoSerie getOpcaoSisacaoSeriePertenceA(boolean lazyloader) 
		{	
			if (lazyloader && opcaoSisacaoSeriePertenceA==null)
			{
				try {
					getCarregador().CarregaItemOpcaoSisacaoSerie_PertenceA(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return opcaoSisacaoSeriePertenceA;
		} 
		public void setOpcaoSisacaoSeriePertenceA(OpcaoSisacaoSerie value) 
		{	
			opcaoSisacaoSeriePertenceA = value;
		} 
		/*
		public void setOpcaoSisacaoSeriePertenceAComReversao(OpcaoSisacaoSerie value) 
		{	
			opcaoSisacaoSeriePertenceA = value;
			System.out.println("Alteracao:" + opcaoSisacaoSeriePertenceA);
			if (opcaoSisacaoSeriePertenceA!=null)
				opcaoSisacaoSeriePertenceA.addListaOpcaoSisacao_Possui(vo);
		} 
		*/
		
		public void addListaOpcaoSisacaoSerie_PertenceA(OpcaoSisacaoSerie  value) 
		{	
			opcaoSisacaoSeriePertenceA = value;
		} 
		public OpcaoSisacaoSerie getCorrenteOpcaoSisacaoSerie_PertenceA()
		{	
			return opcaoSisacaoSeriePertenceA;
		} 
		
 		
		private Ticker tickerDerivativoDe;
		// Montador Tradicional
		public Ticker getTickerDerivativoDe(boolean lazyloader) 
		{	
			if (lazyloader && tickerDerivativoDe==null)
			{
				try {
					getCarregador().CarregaItemTicker_DerivativoDe(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return tickerDerivativoDe;
		} 
		public void setTickerDerivativoDe(Ticker value) 
		{	
			tickerDerivativoDe = value;
		} 
		/*
		public void setTickerDerivativoDeComReversao(Ticker value) 
		{	
			tickerDerivativoDe = value;
			System.out.println("Alteracao:" + tickerDerivativoDe);
			if (tickerDerivativoDe!=null)
				tickerDerivativoDe.addListaOpcaoSisacao_Gera(vo);
		} 
		*/
		
		public void addListaTicker_DerivativoDe(Ticker  value) 
		{	
			tickerDerivativoDe = value;
		} 
		public Ticker getCorrenteTicker_DerivativoDe()
		{	
			return tickerDerivativoDe;
		} 
		
 		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
		public boolean existeListaEscolhaOpcao_Escolhida() {
			return listaescolhaOpcaoEscolhida!= null;
		}
		private List<EscolhaOpcao> listaescolhaOpcaoEscolhida;
		public void setListaEscolhaOpcao_Escolhida(List<EscolhaOpcao> value) 
		{	
			listaescolhaOpcaoEscolhida = value;
		} 
		public List<EscolhaOpcao> getListaEscolhaOpcao_Escolhida ()
		{	
			// ligando o LazyLoader
			//if (listaescolhaOpcaoEscolhida == null)
			//{
            //	getCarregador().CarregaListaEscolhaOpcao_Escolhida(vo);
            //}
			return listaescolhaOpcaoEscolhida;
			
		} 
		public void addListaEscolhaOpcao_Escolhida(EscolhaOpcao value)
		{	
			criaVaziaListaEscolhaOpcao_Escolhida();
			listaescolhaOpcaoEscolhida.add(value);
		} 
		public EscolhaOpcao getCorrenteEscolhaOpcao_Escolhida()
		{	
			if (listaescolhaOpcaoEscolhida==null || listaescolhaOpcaoEscolhida.size()==0) return null;
			return listaescolhaOpcaoEscolhida.get(listaescolhaOpcaoEscolhida.size()-1);
		} 
		public void criaVaziaListaEscolhaOpcao_Escolhida() {
			if (listaescolhaOpcaoEscolhida == null)
            {
            	listaescolhaOpcaoEscolhida = new ArrayList<EscolhaOpcao>();
            }
		}
 		
		public boolean existeListaCotacaoProcessadaOpcaoResultado_EstaEm() {
			return listacotacaoProcessadaOpcaoResultadoEstaEm!= null;
		}
		private List<CotacaoProcessadaOpcaoResultado> listacotacaoProcessadaOpcaoResultadoEstaEm;
		public void setListaCotacaoProcessadaOpcaoResultado_EstaEm(List<CotacaoProcessadaOpcaoResultado> value) 
		{	
			listacotacaoProcessadaOpcaoResultadoEstaEm = value;
		} 
		public List<CotacaoProcessadaOpcaoResultado> getListaCotacaoProcessadaOpcaoResultado_EstaEm ()
		{	
			// ligando o LazyLoader
			//if (listacotacaoProcessadaOpcaoResultadoEstaEm == null)
			//{
            //	getCarregador().CarregaListaCotacaoProcessadaOpcaoResultado_EstaEm(vo);
            //}
			return listacotacaoProcessadaOpcaoResultadoEstaEm;
			
		} 
		public void addListaCotacaoProcessadaOpcaoResultado_EstaEm(CotacaoProcessadaOpcaoResultado value)
		{	
			criaVaziaListaCotacaoProcessadaOpcaoResultado_EstaEm();
			listacotacaoProcessadaOpcaoResultadoEstaEm.add(value);
		} 
		public CotacaoProcessadaOpcaoResultado getCorrenteCotacaoProcessadaOpcaoResultado_EstaEm()
		{	
			if (listacotacaoProcessadaOpcaoResultadoEstaEm==null || listacotacaoProcessadaOpcaoResultadoEstaEm.size()==0) return null;
			return listacotacaoProcessadaOpcaoResultadoEstaEm.get(listacotacaoProcessadaOpcaoResultadoEstaEm.size()-1);
		} 
		public void criaVaziaListaCotacaoProcessadaOpcaoResultado_EstaEm() {
			if (listacotacaoProcessadaOpcaoResultadoEstaEm == null)
            {
            	listacotacaoProcessadaOpcaoResultadoEstaEm = new ArrayList<CotacaoProcessadaOpcaoResultado>();
            }
		}
 		
		public boolean existeListaOpcaoReferencia_Possui() {
			return listaopcaoReferenciaPossui!= null;
		}
		private List<OpcaoReferencia> listaopcaoReferenciaPossui;
		public void setListaOpcaoReferencia_Possui(List<OpcaoReferencia> value) 
		{	
			listaopcaoReferenciaPossui = value;
		} 
		public List<OpcaoReferencia> getListaOpcaoReferencia_Possui ()
		{	
			// ligando o LazyLoader
			//if (listaopcaoReferenciaPossui == null)
			//{
            //	getCarregador().CarregaListaOpcaoReferencia_Possui(vo);
            //}
			return listaopcaoReferenciaPossui;
			
		} 
		public void addListaOpcaoReferencia_Possui(OpcaoReferencia value)
		{	
			criaVaziaListaOpcaoReferencia_Possui();
			listaopcaoReferenciaPossui.add(value);
		} 
		public OpcaoReferencia getCorrenteOpcaoReferencia_Possui()
		{	
			if (listaopcaoReferenciaPossui==null || listaopcaoReferenciaPossui.size()==0) return null;
			return listaopcaoReferenciaPossui.get(listaopcaoReferenciaPossui.size()-1);
		} 
		public void criaVaziaListaOpcaoReferencia_Possui() {
			if (listaopcaoReferenciaPossui == null)
            {
            	listaopcaoReferenciaPossui = new ArrayList<OpcaoReferencia>();
            }
		}
 		
	}
