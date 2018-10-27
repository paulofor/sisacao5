package coletorjava.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletorjava.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class OpcaoReferenciaAgregado implements OpcaoReferenciaAgregadoI
	{
		
		private OpcaoReferenciaCarregador carregador = null;
		private OpcaoReferenciaCarregador getCarregador() {
			if (carregador==null) {
				carregador = new OpcaoReferenciaCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			if (vo.getTickerReferenteA(false) != null)
				vo.getTickerReferenteA(false).setConexaoCarregador(conexao);
			if (vo.getDiaPregaoReferenteA(false) != null)
				vo.getDiaPregaoReferenteA(false).setConexaoCarregador(conexao);
			if (vo.getOpcaoSisacaoReferenteA(false) != null)
				vo.getOpcaoSisacaoReferenteA(false).setConexaoCarregador(conexao);
			
		}
		
		
		private OpcaoReferencia vo;
		public OpcaoReferenciaAgregado(OpcaoReferencia item) {
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
				tickerReferenteA.addListaOpcaoReferencia_Possui(vo);
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
		
 		
		private DiaPregao diaPregaoReferenteA;
		// Montador Tradicional
		public DiaPregao getDiaPregaoReferenteA(boolean lazyloader) 
		{	
			if (lazyloader && diaPregaoReferenteA==null)
			{
				try {
					getCarregador().CarregaItemDiaPregao_ReferenteA(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return diaPregaoReferenteA;
		} 
		public void setDiaPregaoReferenteA(DiaPregao value) 
		{	
			diaPregaoReferenteA = value;
		} 
		/*
		public void setDiaPregaoReferenteAComReversao(DiaPregao value) 
		{	
			diaPregaoReferenteA = value;
			System.out.println("Alteracao:" + diaPregaoReferenteA);
			if (diaPregaoReferenteA!=null)
				diaPregaoReferenteA.addListaOpcaoReferencia_Possui(vo);
		} 
		*/
		
		public void addListaDiaPregao_ReferenteA(DiaPregao  value) 
		{	
			diaPregaoReferenteA = value;
		} 
		public DiaPregao getCorrenteDiaPregao_ReferenteA()
		{	
			return diaPregaoReferenteA;
		} 
		
 		
		private OpcaoSisacao opcaoSisacaoReferenteA;
		// Montador Tradicional
		public OpcaoSisacao getOpcaoSisacaoReferenteA(boolean lazyloader) 
		{	
			if (lazyloader && opcaoSisacaoReferenteA==null)
			{
				try {
					getCarregador().CarregaItemOpcaoSisacao_ReferenteA(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return opcaoSisacaoReferenteA;
		} 
		public void setOpcaoSisacaoReferenteA(OpcaoSisacao value) 
		{	
			opcaoSisacaoReferenteA = value;
		} 
		/*
		public void setOpcaoSisacaoReferenteAComReversao(OpcaoSisacao value) 
		{	
			opcaoSisacaoReferenteA = value;
			System.out.println("Alteracao:" + opcaoSisacaoReferenteA);
			if (opcaoSisacaoReferenteA!=null)
				opcaoSisacaoReferenteA.addListaOpcaoReferencia_Possui(vo);
		} 
		*/
		
		public void addListaOpcaoSisacao_ReferenteA(OpcaoSisacao  value) 
		{	
			opcaoSisacaoReferenteA = value;
		} 
		public OpcaoSisacao getCorrenteOpcaoSisacao_ReferenteA()
		{	
			return opcaoSisacaoReferenteA;
		} 
		
 		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
	}
