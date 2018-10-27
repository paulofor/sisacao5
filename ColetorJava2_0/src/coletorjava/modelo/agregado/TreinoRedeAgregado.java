package coletorjava.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletorjava.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class TreinoRedeAgregado implements TreinoRedeAgregadoI
	{
		
		private TreinoRedeCarregador carregador = null;
		private TreinoRedeCarregador getCarregador() {
			if (carregador==null) {
				carregador = new TreinoRedeCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			if (vo.getRedePertenceA(false) != null)
				vo.getRedePertenceA(false).setConexaoCarregador(conexao);
			if (vo.getDadoTreinoGeradoPor(false) != null)
				vo.getDadoTreinoGeradoPor(false).setConexaoCarregador(conexao);
			
		}
		
		
		private TreinoRede vo;
		public TreinoRedeAgregado(TreinoRede item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
		private Rede redePertenceA;
		// Montador Tradicional
		public Rede getRedePertenceA(boolean lazyloader) 
		{	
			if (lazyloader && redePertenceA==null)
			{
				try {
					getCarregador().CarregaItemRede_PertenceA(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return redePertenceA;
		} 
		public void setRedePertenceA(Rede value) 
		{	
			redePertenceA = value;
		} 
		/*
		public void setRedePertenceAComReversao(Rede value) 
		{	
			redePertenceA = value;
			System.out.println("Alteracao:" + redePertenceA);
			if (redePertenceA!=null)
				redePertenceA.addListaTreinoRede_Gerou(vo);
		} 
		*/
		
		public void addListaRede_PertenceA(Rede  value) 
		{	
			redePertenceA = value;
		} 
		public Rede getCorrenteRede_PertenceA()
		{	
			return redePertenceA;
		} 
		
 		
		private DadoTreino dadoTreinoGeradoPor;
		// Montador Tradicional
		public DadoTreino getDadoTreinoGeradoPor(boolean lazyloader) 
		{	
			if (lazyloader && dadoTreinoGeradoPor==null)
			{
				try {
					getCarregador().CarregaItemDadoTreino_GeradoPor(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return dadoTreinoGeradoPor;
		} 
		public void setDadoTreinoGeradoPor(DadoTreino value) 
		{	
			dadoTreinoGeradoPor = value;
		} 
		/*
		public void setDadoTreinoGeradoPorComReversao(DadoTreino value) 
		{	
			dadoTreinoGeradoPor = value;
			System.out.println("Alteracao:" + dadoTreinoGeradoPor);
			if (dadoTreinoGeradoPor!=null)
				dadoTreinoGeradoPor.addListaTreinoRede_Gerou(vo);
		} 
		*/
		
		public void addListaDadoTreino_GeradoPor(DadoTreino  value) 
		{	
			dadoTreinoGeradoPor = value;
		} 
		public DadoTreino getCorrenteDadoTreino_GeradoPor()
		{	
			return dadoTreinoGeradoPor;
		} 
		
 		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
		public boolean existeListaDadoTheta_Resultado() {
			return listadadoThetaResultado!= null;
		}
		private List<DadoTheta> listadadoThetaResultado;
		public void setListaDadoTheta_Resultado(List<DadoTheta> value) 
		{	
			listadadoThetaResultado = value;
		} 
		public List<DadoTheta> getListaDadoTheta_Resultado ()
		{	
			// ligando o LazyLoader
			//if (listadadoThetaResultado == null)
			//{
            //	getCarregador().CarregaListaDadoTheta_Resultado(vo);
            //}
			return listadadoThetaResultado;
			
		} 
		public void addListaDadoTheta_Resultado(DadoTheta value)
		{	
			criaVaziaListaDadoTheta_Resultado();
			listadadoThetaResultado.add(value);
		} 
		public DadoTheta getCorrenteDadoTheta_Resultado()
		{	
			if (listadadoThetaResultado==null || listadadoThetaResultado.size()==0) return null;
			return listadadoThetaResultado.get(listadadoThetaResultado.size()-1);
		} 
		public void criaVaziaListaDadoTheta_Resultado() {
			if (listadadoThetaResultado == null)
            {
            	listadadoThetaResultado = new ArrayList<DadoTheta>();
            }
		}
 		
	}
