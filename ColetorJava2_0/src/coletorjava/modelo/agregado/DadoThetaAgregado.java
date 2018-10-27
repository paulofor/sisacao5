package coletorjava.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletorjava.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class DadoThetaAgregado implements DadoThetaAgregadoI
	{
		
		private DadoThetaCarregador carregador = null;
		private DadoThetaCarregador getCarregador() {
			if (carregador==null) {
				carregador = new DadoThetaCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			if (vo.getTreinoRedeGeradoPor(false) != null)
				vo.getTreinoRedeGeradoPor(false).setConexaoCarregador(conexao);
			
		}
		
		
		private DadoTheta vo;
		public DadoThetaAgregado(DadoTheta item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
		private TreinoRede treinoRedeGeradoPor;
		// Montador Tradicional
		public TreinoRede getTreinoRedeGeradoPor(boolean lazyloader) 
		{	
			if (lazyloader && treinoRedeGeradoPor==null)
			{
				try {
					getCarregador().CarregaItemTreinoRede_GeradoPor(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return treinoRedeGeradoPor;
		} 
		public void setTreinoRedeGeradoPor(TreinoRede value) 
		{	
			treinoRedeGeradoPor = value;
		} 
		/*
		public void setTreinoRedeGeradoPorComReversao(TreinoRede value) 
		{	
			treinoRedeGeradoPor = value;
			System.out.println("Alteracao:" + treinoRedeGeradoPor);
			if (treinoRedeGeradoPor!=null)
				treinoRedeGeradoPor.addListaDadoTheta_Resultado(vo);
		} 
		*/
		
		public void addListaTreinoRede_GeradoPor(TreinoRede  value) 
		{	
			treinoRedeGeradoPor = value;
		} 
		public TreinoRede getCorrenteTreinoRede_GeradoPor()
		{	
			return treinoRedeGeradoPor;
		} 
		
 		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
		public boolean existeListaResultadoPrevisao_Gera() {
			return listaresultadoPrevisaoGera!= null;
		}
		private List<ResultadoPrevisao> listaresultadoPrevisaoGera;
		public void setListaResultadoPrevisao_Gera(List<ResultadoPrevisao> value) 
		{	
			listaresultadoPrevisaoGera = value;
		} 
		public List<ResultadoPrevisao> getListaResultadoPrevisao_Gera ()
		{	
			// ligando o LazyLoader
			//if (listaresultadoPrevisaoGera == null)
			//{
            //	getCarregador().CarregaListaResultadoPrevisao_Gera(vo);
            //}
			return listaresultadoPrevisaoGera;
			
		} 
		public void addListaResultadoPrevisao_Gera(ResultadoPrevisao value)
		{	
			criaVaziaListaResultadoPrevisao_Gera();
			listaresultadoPrevisaoGera.add(value);
		} 
		public ResultadoPrevisao getCorrenteResultadoPrevisao_Gera()
		{	
			if (listaresultadoPrevisaoGera==null || listaresultadoPrevisaoGera.size()==0) return null;
			return listaresultadoPrevisaoGera.get(listaresultadoPrevisaoGera.size()-1);
		} 
		public void criaVaziaListaResultadoPrevisao_Gera() {
			if (listaresultadoPrevisaoGera == null)
            {
            	listaresultadoPrevisaoGera = new ArrayList<ResultadoPrevisao>();
            }
		}
 		
	}
