package coletorjava.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletorjava.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class DadoTreinoAgregado implements DadoTreinoAgregadoI
	{
		
		private DadoTreinoCarregador carregador = null;
		private DadoTreinoCarregador getCarregador() {
			if (carregador==null) {
				carregador = new DadoTreinoCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			if (vo.getProjetoDadoTreinoPossui(false) != null)
				vo.getProjetoDadoTreinoPossui(false).setConexaoCarregador(conexao);
			
		}
		
		
		private DadoTreino vo;
		public DadoTreinoAgregado(DadoTreino item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
		private ProjetoDadoTreino projetoDadoTreinoPossui;
		// Montador Tradicional
		public ProjetoDadoTreino getProjetoDadoTreinoPossui(boolean lazyloader) 
		{	
			if (lazyloader && projetoDadoTreinoPossui==null)
			{
				try {
					getCarregador().CarregaItemProjetoDadoTreino_Possui(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return projetoDadoTreinoPossui;
		} 
		public void setProjetoDadoTreinoPossui(ProjetoDadoTreino value) 
		{	
			projetoDadoTreinoPossui = value;
		} 
		/*
		public void setProjetoDadoTreinoPossuiComReversao(ProjetoDadoTreino value) 
		{	
			projetoDadoTreinoPossui = value;
			System.out.println("Alteracao:" + projetoDadoTreinoPossui);
			if (projetoDadoTreinoPossui!=null)
				projetoDadoTreinoPossui.addListaDadoTreino_Gerou(vo);
		} 
		*/
		
		public void addListaProjetoDadoTreino_Possui(ProjetoDadoTreino  value) 
		{	
			projetoDadoTreinoPossui = value;
		} 
		public ProjetoDadoTreino getCorrenteProjetoDadoTreino_Possui()
		{	
			return projetoDadoTreinoPossui;
		} 
		
 		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
		public boolean existeListaTreinoRede_Gerou() {
			return listatreinoRedeGerou!= null;
		}
		private List<TreinoRede> listatreinoRedeGerou;
		public void setListaTreinoRede_Gerou(List<TreinoRede> value) 
		{	
			listatreinoRedeGerou = value;
		} 
		public List<TreinoRede> getListaTreinoRede_Gerou ()
		{	
			// ligando o LazyLoader
			//if (listatreinoRedeGerou == null)
			//{
            //	getCarregador().CarregaListaTreinoRede_Gerou(vo);
            //}
			return listatreinoRedeGerou;
			
		} 
		public void addListaTreinoRede_Gerou(TreinoRede value)
		{	
			criaVaziaListaTreinoRede_Gerou();
			listatreinoRedeGerou.add(value);
		} 
		public TreinoRede getCorrenteTreinoRede_Gerou()
		{	
			if (listatreinoRedeGerou==null || listatreinoRedeGerou.size()==0) return null;
			return listatreinoRedeGerou.get(listatreinoRedeGerou.size()-1);
		} 
		public void criaVaziaListaTreinoRede_Gerou() {
			if (listatreinoRedeGerou == null)
            {
            	listatreinoRedeGerou = new ArrayList<TreinoRede>();
            }
		}
 		
	}
