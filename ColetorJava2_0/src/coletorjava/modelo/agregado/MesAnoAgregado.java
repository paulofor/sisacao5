package coletorjava.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletorjava.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class MesAnoAgregado implements MesAnoAgregadoI
	{
		
		private MesAnoCarregador carregador = null;
		private MesAnoCarregador getCarregador() {
			if (carregador==null) {
				carregador = new MesAnoCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			
		}
		
		
		private MesAno vo;
		public MesAnoAgregado(MesAno item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
     	
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
 		
		public boolean existeListaResultadoMes_BasePara() {
			return listaresultadoMesBasePara!= null;
		}
		private List<ResultadoMes> listaresultadoMesBasePara;
		public void setListaResultadoMes_BasePara(List<ResultadoMes> value) 
		{	
			listaresultadoMesBasePara = value;
		} 
		public List<ResultadoMes> getListaResultadoMes_BasePara ()
		{	
			// ligando o LazyLoader
			//if (listaresultadoMesBasePara == null)
			//{
            //	getCarregador().CarregaListaResultadoMes_BasePara(vo);
            //}
			return listaresultadoMesBasePara;
			
		} 
		public void addListaResultadoMes_BasePara(ResultadoMes value)
		{	
			criaVaziaListaResultadoMes_BasePara();
			listaresultadoMesBasePara.add(value);
		} 
		public ResultadoMes getCorrenteResultadoMes_BasePara()
		{	
			if (listaresultadoMesBasePara==null || listaresultadoMesBasePara.size()==0) return null;
			return listaresultadoMesBasePara.get(listaresultadoMesBasePara.size()-1);
		} 
		public void criaVaziaListaResultadoMes_BasePara() {
			if (listaresultadoMesBasePara == null)
            {
            	listaresultadoMesBasePara = new ArrayList<ResultadoMes>();
            }
		}
 		
	}
