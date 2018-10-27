package coletorjava.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletorjava.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class OpcaoSisacaoSerieAgregado implements OpcaoSisacaoSerieAgregadoI
	{
		
		private OpcaoSisacaoSerieCarregador carregador = null;
		private OpcaoSisacaoSerieCarregador getCarregador() {
			if (carregador==null) {
				carregador = new OpcaoSisacaoSerieCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			
		}
		
		
		private OpcaoSisacaoSerie vo;
		public OpcaoSisacaoSerieAgregado(OpcaoSisacaoSerie item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
		public boolean existeListaOpcaoSisacao_Possui() {
			return listaopcaoSisacaoPossui!= null;
		}
		private List<OpcaoSisacao> listaopcaoSisacaoPossui;
		public void setListaOpcaoSisacao_Possui(List<OpcaoSisacao> value) 
		{	
			listaopcaoSisacaoPossui = value;
		} 
		public List<OpcaoSisacao> getListaOpcaoSisacao_Possui ()
		{	
			// ligando o LazyLoader
			//if (listaopcaoSisacaoPossui == null)
			//{
            //	getCarregador().CarregaListaOpcaoSisacao_Possui(vo);
            //}
			return listaopcaoSisacaoPossui;
			
		} 
		public void addListaOpcaoSisacao_Possui(OpcaoSisacao value)
		{	
			criaVaziaListaOpcaoSisacao_Possui();
			listaopcaoSisacaoPossui.add(value);
		} 
		public OpcaoSisacao getCorrenteOpcaoSisacao_Possui()
		{	
			if (listaopcaoSisacaoPossui==null || listaopcaoSisacaoPossui.size()==0) return null;
			return listaopcaoSisacaoPossui.get(listaopcaoSisacaoPossui.size()-1);
		} 
		public void criaVaziaListaOpcaoSisacao_Possui() {
			if (listaopcaoSisacaoPossui == null)
            {
            	listaopcaoSisacaoPossui = new ArrayList<OpcaoSisacao>();
            }
		}
 		
	}
