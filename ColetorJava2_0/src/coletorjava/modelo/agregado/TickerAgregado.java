package coletorjava.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletorjava.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class TickerAgregado implements TickerAgregadoI
	{
		
		private TickerCarregador carregador = null;
		private TickerCarregador getCarregador() {
			if (carregador==null) {
				carregador = new TickerCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			
		}
		
		
		private Ticker vo;
		public TickerAgregado(Ticker item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
		public boolean existeListaOpcaoSisacaoGeral_Possui() {
			return listaopcaoSisacaoGeralPossui!= null;
		}
		private List<OpcaoSisacaoGeral> listaopcaoSisacaoGeralPossui;
		public void setListaOpcaoSisacaoGeral_Possui(List<OpcaoSisacaoGeral> value) 
		{	
			listaopcaoSisacaoGeralPossui = value;
		} 
		public List<OpcaoSisacaoGeral> getListaOpcaoSisacaoGeral_Possui ()
		{	
			// ligando o LazyLoader
			//if (listaopcaoSisacaoGeralPossui == null)
			//{
            //	getCarregador().CarregaListaOpcaoSisacaoGeral_Possui(vo);
            //}
			return listaopcaoSisacaoGeralPossui;
			
		} 
		public void addListaOpcaoSisacaoGeral_Possui(OpcaoSisacaoGeral value)
		{	
			criaVaziaListaOpcaoSisacaoGeral_Possui();
			listaopcaoSisacaoGeralPossui.add(value);
		} 
		public OpcaoSisacaoGeral getCorrenteOpcaoSisacaoGeral_Possui()
		{	
			if (listaopcaoSisacaoGeralPossui==null || listaopcaoSisacaoGeralPossui.size()==0) return null;
			return listaopcaoSisacaoGeralPossui.get(listaopcaoSisacaoGeralPossui.size()-1);
		} 
		public void criaVaziaListaOpcaoSisacaoGeral_Possui() {
			if (listaopcaoSisacaoGeralPossui == null)
            {
            	listaopcaoSisacaoGeralPossui = new ArrayList<OpcaoSisacaoGeral>();
            }
		}
 		
		public boolean existeListaOpcaoSisacao_Gera() {
			return listaopcaoSisacaoGera!= null;
		}
		private List<OpcaoSisacao> listaopcaoSisacaoGera;
		public void setListaOpcaoSisacao_Gera(List<OpcaoSisacao> value) 
		{	
			listaopcaoSisacaoGera = value;
		} 
		public List<OpcaoSisacao> getListaOpcaoSisacao_Gera ()
		{	
			// ligando o LazyLoader
			//if (listaopcaoSisacaoGera == null)
			//{
            //	getCarregador().CarregaListaOpcaoSisacao_Gera(vo);
            //}
			return listaopcaoSisacaoGera;
			
		} 
		public void addListaOpcaoSisacao_Gera(OpcaoSisacao value)
		{	
			criaVaziaListaOpcaoSisacao_Gera();
			listaopcaoSisacaoGera.add(value);
		} 
		public OpcaoSisacao getCorrenteOpcaoSisacao_Gera()
		{	
			if (listaopcaoSisacaoGera==null || listaopcaoSisacaoGera.size()==0) return null;
			return listaopcaoSisacaoGera.get(listaopcaoSisacaoGera.size()-1);
		} 
		public void criaVaziaListaOpcaoSisacao_Gera() {
			if (listaopcaoSisacaoGera == null)
            {
            	listaopcaoSisacaoGera = new ArrayList<OpcaoSisacao>();
            }
		}
 		
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
 		
		public boolean existeListaProjetoDadoTreino_Gera() {
			return listaprojetoDadoTreinoGera!= null;
		}
		private List<ProjetoDadoTreino> listaprojetoDadoTreinoGera;
		public void setListaProjetoDadoTreino_Gera(List<ProjetoDadoTreino> value) 
		{	
			listaprojetoDadoTreinoGera = value;
		} 
		public List<ProjetoDadoTreino> getListaProjetoDadoTreino_Gera ()
		{	
			// ligando o LazyLoader
			//if (listaprojetoDadoTreinoGera == null)
			//{
            //	getCarregador().CarregaListaProjetoDadoTreino_Gera(vo);
            //}
			return listaprojetoDadoTreinoGera;
			
		} 
		public void addListaProjetoDadoTreino_Gera(ProjetoDadoTreino value)
		{	
			criaVaziaListaProjetoDadoTreino_Gera();
			listaprojetoDadoTreinoGera.add(value);
		} 
		public ProjetoDadoTreino getCorrenteProjetoDadoTreino_Gera()
		{	
			if (listaprojetoDadoTreinoGera==null || listaprojetoDadoTreinoGera.size()==0) return null;
			return listaprojetoDadoTreinoGera.get(listaprojetoDadoTreinoGera.size()-1);
		} 
		public void criaVaziaListaProjetoDadoTreino_Gera() {
			if (listaprojetoDadoTreinoGera == null)
            {
            	listaprojetoDadoTreinoGera = new ArrayList<ProjetoDadoTreino>();
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
