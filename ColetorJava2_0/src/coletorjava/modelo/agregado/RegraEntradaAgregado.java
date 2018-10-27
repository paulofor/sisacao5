package coletorjava.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletorjava.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class RegraEntradaAgregado implements RegraEntradaAgregadoI
	{
		
		private RegraEntradaCarregador carregador = null;
		private RegraEntradaCarregador getCarregador() {
			if (carregador==null) {
				carregador = new RegraEntradaCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			
		}
		
		
		private RegraEntrada vo;
		public RegraEntradaAgregado(RegraEntrada item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
	}
