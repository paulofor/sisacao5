package coletorjava.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletorjava.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class UsuarioAgregado implements UsuarioAgregadoI
	{
		
		private UsuarioCarregador carregador = null;
		private UsuarioCarregador getCarregador() {
			if (carregador==null) {
				carregador = new UsuarioCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			
		}
		
		
		private Usuario vo;
		public UsuarioAgregado(Usuario item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
		public boolean existeListaDispositivoUsuario_Usa() {
			return listadispositivoUsuarioUsa!= null;
		}
		private List<DispositivoUsuario> listadispositivoUsuarioUsa;
		public void setListaDispositivoUsuario_Usa(List<DispositivoUsuario> value) 
		{	
			listadispositivoUsuarioUsa = value;
		} 
		public List<DispositivoUsuario> getListaDispositivoUsuario_Usa ()
		{	
			// ligando o LazyLoader
			//if (listadispositivoUsuarioUsa == null)
			//{
            //	getCarregador().CarregaListaDispositivoUsuario_Usa(vo);
            //}
			return listadispositivoUsuarioUsa;
			
		} 
		public void addListaDispositivoUsuario_Usa(DispositivoUsuario value)
		{	
			criaVaziaListaDispositivoUsuario_Usa();
			listadispositivoUsuarioUsa.add(value);
		} 
		public DispositivoUsuario getCorrenteDispositivoUsuario_Usa()
		{	
			if (listadispositivoUsuarioUsa==null || listadispositivoUsuarioUsa.size()==0) return null;
			return listadispositivoUsuarioUsa.get(listadispositivoUsuarioUsa.size()-1);
		} 
		public void criaVaziaListaDispositivoUsuario_Usa() {
			if (listadispositivoUsuarioUsa == null)
            {
            	listadispositivoUsuarioUsa = new ArrayList<DispositivoUsuario>();
            }
		}
 		
	}
