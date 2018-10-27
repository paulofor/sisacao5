package coletorjava.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletorjava.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class ResultadoMesAgregado implements ResultadoMesAgregadoI
	{
		
		private ResultadoMesCarregador carregador = null;
		private ResultadoMesCarregador getCarregador() {
			if (carregador==null) {
				carregador = new ResultadoMesCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			if (vo.getProjetoDadoTreinoGeradoPor(false) != null)
				vo.getProjetoDadoTreinoGeradoPor(false).setConexaoCarregador(conexao);
			if (vo.getMesAnoReferenteA(false) != null)
				vo.getMesAnoReferenteA(false).setConexaoCarregador(conexao);
			
		}
		
		
		private ResultadoMes vo;
		public ResultadoMesAgregado(ResultadoMes item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
		private ProjetoDadoTreino projetoDadoTreinoGeradoPor;
		// Montador Tradicional
		public ProjetoDadoTreino getProjetoDadoTreinoGeradoPor(boolean lazyloader) 
		{	
			if (lazyloader && projetoDadoTreinoGeradoPor==null)
			{
				try {
					getCarregador().CarregaItemProjetoDadoTreino_GeradoPor(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return projetoDadoTreinoGeradoPor;
		} 
		public void setProjetoDadoTreinoGeradoPor(ProjetoDadoTreino value) 
		{	
			projetoDadoTreinoGeradoPor = value;
		} 
		/*
		public void setProjetoDadoTreinoGeradoPorComReversao(ProjetoDadoTreino value) 
		{	
			projetoDadoTreinoGeradoPor = value;
			System.out.println("Alteracao:" + projetoDadoTreinoGeradoPor);
			if (projetoDadoTreinoGeradoPor!=null)
				projetoDadoTreinoGeradoPor.addListaResultadoMes_Gerou(vo);
		} 
		*/
		
		public void addListaProjetoDadoTreino_GeradoPor(ProjetoDadoTreino  value) 
		{	
			projetoDadoTreinoGeradoPor = value;
		} 
		public ProjetoDadoTreino getCorrenteProjetoDadoTreino_GeradoPor()
		{	
			return projetoDadoTreinoGeradoPor;
		} 
		
 		
		private MesAno mesAnoReferenteA;
		// Montador Tradicional
		public MesAno getMesAnoReferenteA(boolean lazyloader) 
		{	
			if (lazyloader && mesAnoReferenteA==null)
			{
				try {
					getCarregador().CarregaItemMesAno_ReferenteA(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return mesAnoReferenteA;
		} 
		public void setMesAnoReferenteA(MesAno value) 
		{	
			mesAnoReferenteA = value;
		} 
		/*
		public void setMesAnoReferenteAComReversao(MesAno value) 
		{	
			mesAnoReferenteA = value;
			System.out.println("Alteracao:" + mesAnoReferenteA);
			if (mesAnoReferenteA!=null)
				mesAnoReferenteA.addListaResultadoMes_BasePara(vo);
		} 
		*/
		
		public void addListaMesAno_ReferenteA(MesAno  value) 
		{	
			mesAnoReferenteA = value;
		} 
		public MesAno getCorrenteMesAno_ReferenteA()
		{	
			return mesAnoReferenteA;
		} 
		
 		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
		public boolean existeListaResultadoPrevisao_Semelhante() {
			return listaresultadoPrevisaoSemelhante!= null;
		}
		private List<ResultadoPrevisao> listaresultadoPrevisaoSemelhante;
		public void setListaResultadoPrevisao_Semelhante(List<ResultadoPrevisao> value) 
		{	
			listaresultadoPrevisaoSemelhante = value;
		} 
		public List<ResultadoPrevisao> getListaResultadoPrevisao_Semelhante ()
		{	
			// ligando o LazyLoader
			//if (listaresultadoPrevisaoSemelhante == null)
			//{
            //	getCarregador().CarregaListaResultadoPrevisao_Semelhante(vo);
            //}
			return listaresultadoPrevisaoSemelhante;
			
		} 
		public void addListaResultadoPrevisao_Semelhante(ResultadoPrevisao value)
		{	
			criaVaziaListaResultadoPrevisao_Semelhante();
			listaresultadoPrevisaoSemelhante.add(value);
		} 
		public ResultadoPrevisao getCorrenteResultadoPrevisao_Semelhante()
		{	
			if (listaresultadoPrevisaoSemelhante==null || listaresultadoPrevisaoSemelhante.size()==0) return null;
			return listaresultadoPrevisaoSemelhante.get(listaresultadoPrevisaoSemelhante.size()-1);
		} 
		public void criaVaziaListaResultadoPrevisao_Semelhante() {
			if (listaresultadoPrevisaoSemelhante == null)
            {
            	listaresultadoPrevisaoSemelhante = new ArrayList<ResultadoPrevisao>();
            }
		}
 		
	}
