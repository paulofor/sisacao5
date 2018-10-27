package coletorjava.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletorjava.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class PeriodoPregaoAgregado implements PeriodoPregaoAgregadoI
	{
		
		private PeriodoPregaoCarregador carregador = null;
		private PeriodoPregaoCarregador getCarregador() {
			if (carregador==null) {
				carregador = new PeriodoPregaoCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			
		}
		
		
		private PeriodoPregao vo;
		public PeriodoPregaoAgregado(PeriodoPregao item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
	}
