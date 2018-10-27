package coletorjava.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletorjava.modelo.*;

// Gera??o autom?tica n?o alterar
public interface OpcaoSisacaoSerieAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	
	// Sem Chave Estrangeira
	
	public OpcaoSisacao getCorrenteOpcaoSisacao_Possui();
	public void addListaOpcaoSisacao_Possui(OpcaoSisacao item);
	public List<OpcaoSisacao> getListaOpcaoSisacao_Possui(); 
	public void setListaOpcaoSisacao_Possui(List<OpcaoSisacao> item); 
	public void criaVaziaListaOpcaoSisacao_Possui();
	public boolean existeListaOpcaoSisacao_Possui();
 		
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
