package coletorjava.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletorjava.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class DispositivoUsuarioAgregado implements DispositivoUsuarioAgregadoI
	{
		
		private DispositivoUsuarioCarregador carregador = null;
		private DispositivoUsuarioCarregador getCarregador() {
			if (carregador==null) {
				carregador = new DispositivoUsuarioCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			if (vo.getUsuarioReferenteA(false) != null)
				vo.getUsuarioReferenteA(false).setConexaoCarregador(conexao);
			
		}
		
		
		private DispositivoUsuario vo;
		public DispositivoUsuarioAgregado(DispositivoUsuario item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
		private Usuario usuarioReferenteA;
		// Montador Tradicional
		public Usuario getUsuarioReferenteA(boolean lazyloader) 
		{	
			if (lazyloader && usuarioReferenteA==null)
			{
				try {
					getCarregador().CarregaItemUsuario_ReferenteA(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return usuarioReferenteA;
		} 
		public void setUsuarioReferenteA(Usuario value) 
		{	
			usuarioReferenteA = value;
		} 
		/*
		public void setUsuarioReferenteAComReversao(Usuario value) 
		{	
			usuarioReferenteA = value;
			System.out.println("Alteracao:" + usuarioReferenteA);
			if (usuarioReferenteA!=null)
				usuarioReferenteA.addListaDispositivoUsuario_Usa(vo);
		} 
		*/
		
		public void addListaUsuario_ReferenteA(Usuario  value) 
		{	
			usuarioReferenteA = value;
		} 
		public Usuario getCorrenteUsuario_ReferenteA()
		{	
			return usuarioReferenteA;
		} 
		
 		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
	}
