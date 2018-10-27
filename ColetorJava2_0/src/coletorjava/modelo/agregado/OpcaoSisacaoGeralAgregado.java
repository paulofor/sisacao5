package coletorjava.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletorjava.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class OpcaoSisacaoGeralAgregado implements OpcaoSisacaoGeralAgregadoI
	{
		
		private OpcaoSisacaoGeralCarregador carregador = null;
		private OpcaoSisacaoGeralCarregador getCarregador() {
			if (carregador==null) {
				carregador = new OpcaoSisacaoGeralCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			if (vo.getTickerReferenteA(false) != null)
				vo.getTickerReferenteA(false).setConexaoCarregador(conexao);
			
		}
		
		
		private OpcaoSisacaoGeral vo;
		public OpcaoSisacaoGeralAgregado(OpcaoSisacaoGeral item) {
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
				tickerReferenteA.addListaOpcaoSisacaoGeral_Possui(vo);
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
     	
	}
