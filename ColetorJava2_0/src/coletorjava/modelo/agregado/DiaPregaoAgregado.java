package coletorjava.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletorjava.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class DiaPregaoAgregado implements DiaPregaoAgregadoI
	{
		
		private DiaPregaoCarregador carregador = null;
		private DiaPregaoCarregador getCarregador() {
			if (carregador==null) {
				carregador = new DiaPregaoCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			
		}
		
		
		private DiaPregao vo;
		public DiaPregaoAgregado(DiaPregao item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
		public boolean existeListaEscolhaOpcao_Possui() {
			return listaescolhaOpcaoPossui!= null;
		}
		private List<EscolhaOpcao> listaescolhaOpcaoPossui;
		public void setListaEscolhaOpcao_Possui(List<EscolhaOpcao> value) 
		{	
			listaescolhaOpcaoPossui = value;
		} 
		public List<EscolhaOpcao> getListaEscolhaOpcao_Possui ()
		{	
			// ligando o LazyLoader
			//if (listaescolhaOpcaoPossui == null)
			//{
            //	getCarregador().CarregaListaEscolhaOpcao_Possui(vo);
            //}
			return listaescolhaOpcaoPossui;
			
		} 
		public void addListaEscolhaOpcao_Possui(EscolhaOpcao value)
		{	
			criaVaziaListaEscolhaOpcao_Possui();
			listaescolhaOpcaoPossui.add(value);
		} 
		public EscolhaOpcao getCorrenteEscolhaOpcao_Possui()
		{	
			if (listaescolhaOpcaoPossui==null || listaescolhaOpcaoPossui.size()==0) return null;
			return listaescolhaOpcaoPossui.get(listaescolhaOpcaoPossui.size()-1);
		} 
		public void criaVaziaListaEscolhaOpcao_Possui() {
			if (listaescolhaOpcaoPossui == null)
            {
            	listaescolhaOpcaoPossui = new ArrayList<EscolhaOpcao>();
            }
		}
 		
		public boolean existeListaOpcaoReferencia_Possui() {
			return listaopcaoReferenciaPossui!= null;
		}
		private List<OpcaoReferencia> listaopcaoReferenciaPossui;
		public void setListaOpcaoReferencia_Possui(List<OpcaoReferencia> value) 
		{	
			listaopcaoReferenciaPossui = value;
		} 
		public List<OpcaoReferencia> getListaOpcaoReferencia_Possui ()
		{	
			// ligando o LazyLoader
			//if (listaopcaoReferenciaPossui == null)
			//{
            //	getCarregador().CarregaListaOpcaoReferencia_Possui(vo);
            //}
			return listaopcaoReferenciaPossui;
			
		} 
		public void addListaOpcaoReferencia_Possui(OpcaoReferencia value)
		{	
			criaVaziaListaOpcaoReferencia_Possui();
			listaopcaoReferenciaPossui.add(value);
		} 
		public OpcaoReferencia getCorrenteOpcaoReferencia_Possui()
		{	
			if (listaopcaoReferenciaPossui==null || listaopcaoReferenciaPossui.size()==0) return null;
			return listaopcaoReferenciaPossui.get(listaopcaoReferenciaPossui.size()-1);
		} 
		public void criaVaziaListaOpcaoReferencia_Possui() {
			if (listaopcaoReferenciaPossui == null)
            {
            	listaopcaoReferenciaPossui = new ArrayList<OpcaoReferencia>();
            }
		}
 		
	}
