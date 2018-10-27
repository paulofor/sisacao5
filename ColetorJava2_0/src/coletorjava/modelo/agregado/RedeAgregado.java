package coletorjava.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletorjava.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class RedeAgregado implements RedeAgregadoI
	{
		
		private RedeCarregador carregador = null;
		private RedeCarregador getCarregador() {
			if (carregador==null) {
				carregador = new RedeCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			
		}
		
		
		private Rede vo;
		public RedeAgregado(Rede item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
     	
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
