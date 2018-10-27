package coletorjava.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletorjava.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class ResultadoPrevisaoAgregado implements ResultadoPrevisaoAgregadoI
	{
		
		private ResultadoPrevisaoCarregador carregador = null;
		private ResultadoPrevisaoCarregador getCarregador() {
			if (carregador==null) {
				carregador = new ResultadoPrevisaoCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			if (vo.getDadoThetaGeradoDe(false) != null)
				vo.getDadoThetaGeradoDe(false).setConexaoCarregador(conexao);
			if (vo.getResultadoMesMesmoPeriodo(false) != null)
				vo.getResultadoMesMesmoPeriodo(false).setConexaoCarregador(conexao);
			if (vo.getMesAnoReferenteA(false) != null)
				vo.getMesAnoReferenteA(false).setConexaoCarregador(conexao);
			
		}
		
		
		private ResultadoPrevisao vo;
		public ResultadoPrevisaoAgregado(ResultadoPrevisao item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
		private DadoTheta dadoThetaGeradoDe;
		// Montador Tradicional
		public DadoTheta getDadoThetaGeradoDe(boolean lazyloader) 
		{	
			if (lazyloader && dadoThetaGeradoDe==null)
			{
				try {
					getCarregador().CarregaItemDadoTheta_GeradoDe(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return dadoThetaGeradoDe;
		} 
		public void setDadoThetaGeradoDe(DadoTheta value) 
		{	
			dadoThetaGeradoDe = value;
		} 
		/*
		public void setDadoThetaGeradoDeComReversao(DadoTheta value) 
		{	
			dadoThetaGeradoDe = value;
			System.out.println("Alteracao:" + dadoThetaGeradoDe);
			if (dadoThetaGeradoDe!=null)
				dadoThetaGeradoDe.addListaResultadoPrevisao_Gera(vo);
		} 
		*/
		
		public void addListaDadoTheta_GeradoDe(DadoTheta  value) 
		{	
			dadoThetaGeradoDe = value;
		} 
		public DadoTheta getCorrenteDadoTheta_GeradoDe()
		{	
			return dadoThetaGeradoDe;
		} 
		
 		
		private ResultadoMes resultadoMesMesmoPeriodo;
		// Montador Tradicional
		public ResultadoMes getResultadoMesMesmoPeriodo(boolean lazyloader) 
		{	
			if (lazyloader && resultadoMesMesmoPeriodo==null)
			{
				try {
					getCarregador().CarregaItemResultadoMes_MesmoPeriodo(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return resultadoMesMesmoPeriodo;
		} 
		public void setResultadoMesMesmoPeriodo(ResultadoMes value) 
		{	
			resultadoMesMesmoPeriodo = value;
		} 
		/*
		public void setResultadoMesMesmoPeriodoComReversao(ResultadoMes value) 
		{	
			resultadoMesMesmoPeriodo = value;
			System.out.println("Alteracao:" + resultadoMesMesmoPeriodo);
			if (resultadoMesMesmoPeriodo!=null)
				resultadoMesMesmoPeriodo.addListaResultadoPrevisao_Semelhante(vo);
		} 
		*/
		
		public void addListaResultadoMes_MesmoPeriodo(ResultadoMes  value) 
		{	
			resultadoMesMesmoPeriodo = value;
		} 
		public ResultadoMes getCorrenteResultadoMes_MesmoPeriodo()
		{	
			return resultadoMesMesmoPeriodo;
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
				mesAnoReferenteA.addListaResultadoPrevisao_Gera(vo);
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
     	
	}
