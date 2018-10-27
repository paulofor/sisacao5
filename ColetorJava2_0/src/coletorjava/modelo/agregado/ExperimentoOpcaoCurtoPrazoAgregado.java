package coletorjava.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletorjava.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class ExperimentoOpcaoCurtoPrazoAgregado implements ExperimentoOpcaoCurtoPrazoAgregadoI
	{
		
		private ExperimentoOpcaoCurtoPrazoCarregador carregador = null;
		private ExperimentoOpcaoCurtoPrazoCarregador getCarregador() {
			if (carregador==null) {
				carregador = new ExperimentoOpcaoCurtoPrazoCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			
		}
		
		
		private ExperimentoOpcaoCurtoPrazo vo;
		public ExperimentoOpcaoCurtoPrazoAgregado(ExperimentoOpcaoCurtoPrazo item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
	}
