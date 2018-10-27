package coletorjava.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletorjava.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class EscolhaOpcaoAgregado implements EscolhaOpcaoAgregadoI
	{
		
		private EscolhaOpcaoCarregador carregador = null;
		private EscolhaOpcaoCarregador getCarregador() {
			if (carregador==null) {
				carregador = new EscolhaOpcaoCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			if (vo.getTickerReferenteA(false) != null)
				vo.getTickerReferenteA(false).setConexaoCarregador(conexao);
			if (vo.getOpcaoSisacaoEscolha(false) != null)
				vo.getOpcaoSisacaoEscolha(false).setConexaoCarregador(conexao);
			if (vo.getDiaPregaoReferenteA(false) != null)
				vo.getDiaPregaoReferenteA(false).setConexaoCarregador(conexao);
			
		}
		
		
		private EscolhaOpcao vo;
		public EscolhaOpcaoAgregado(EscolhaOpcao item) {
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
				tickerReferenteA.addListaEscolhaOpcao_Possui(vo);
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
		
 		
		private OpcaoSisacao opcaoSisacaoEscolha;
		// Montador Tradicional
		public OpcaoSisacao getOpcaoSisacaoEscolha(boolean lazyloader) 
		{	
			if (lazyloader && opcaoSisacaoEscolha==null)
			{
				try {
					getCarregador().CarregaItemOpcaoSisacao_Escolha(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return opcaoSisacaoEscolha;
		} 
		public void setOpcaoSisacaoEscolha(OpcaoSisacao value) 
		{	
			opcaoSisacaoEscolha = value;
		} 
		/*
		public void setOpcaoSisacaoEscolhaComReversao(OpcaoSisacao value) 
		{	
			opcaoSisacaoEscolha = value;
			System.out.println("Alteracao:" + opcaoSisacaoEscolha);
			if (opcaoSisacaoEscolha!=null)
				opcaoSisacaoEscolha.addListaEscolhaOpcao_Escolhida(vo);
		} 
		*/
		
		public void addListaOpcaoSisacao_Escolha(OpcaoSisacao  value) 
		{	
			opcaoSisacaoEscolha = value;
		} 
		public OpcaoSisacao getCorrenteOpcaoSisacao_Escolha()
		{	
			return opcaoSisacaoEscolha;
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
				diaPregaoReferenteA.addListaEscolhaOpcao_Possui(vo);
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
		
 		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
	}
