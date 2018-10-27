package coletorjava.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletorjava.modelo.*;

// Gera??o autom?tica n?o alterar
public interface UsuarioAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	
	// Sem Chave Estrangeira
	
	public DispositivoUsuario getCorrenteDispositivoUsuario_Usa();
	public void addListaDispositivoUsuario_Usa(DispositivoUsuario item);
	public List<DispositivoUsuario> getListaDispositivoUsuario_Usa(); 
	public void setListaDispositivoUsuario_Usa(List<DispositivoUsuario> item); 
	public void criaVaziaListaDispositivoUsuario_Usa();
	public boolean existeListaDispositivoUsuario_Usa();
 		
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
