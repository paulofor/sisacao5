package coletorjava.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletorjava.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class CotacaoProcessadaOpcaoResultadoAgregado implements CotacaoProcessadaOpcaoResultadoAgregadoI
	{
		
		private CotacaoProcessadaOpcaoResultadoCarregador carregador = null;
		private CotacaoProcessadaOpcaoResultadoCarregador getCarregador() {
			if (carregador==null) {
				carregador = new CotacaoProcessadaOpcaoResultadoCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			if (vo.getOpcaoSisacaoReferenteA(false) != null)
				vo.getOpcaoSisacaoReferenteA(false).setConexaoCarregador(conexao);
			
		}
		
		
		private CotacaoProcessadaOpcaoResultado vo;
		public CotacaoProcessadaOpcaoResultadoAgregado(CotacaoProcessadaOpcaoResultado item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
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
				opcaoSisacaoReferenteA.addListaCotacaoProcessadaOpcaoResultado_EstaEm(vo);
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
