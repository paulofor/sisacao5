package coletorjava.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletorjava.modelo.*;

// Gera??o autom?tica n?o alterar
public interface DispositivoUsuarioAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	// Montador tradicional
	public Usuario getUsuarioReferenteA(boolean lazyLoader);
	public void setUsuarioReferenteA(Usuario item);
	//public void setUsuarioReferenteAComReversao(Usuario item);
	
	// Montador alternativo
	
	public void addListaUsuario_ReferenteA(Usuario item); 
	public Usuario getCorrenteUsuario_ReferenteA();
	
		
	
	// Sem Chave Estrangeira
	
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
