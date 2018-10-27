package coletorjava.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletorjava.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class CotacaoProcessadaAgregado implements CotacaoProcessadaAgregadoI
	{
		
		private CotacaoProcessadaCarregador carregador = null;
		private CotacaoProcessadaCarregador getCarregador() {
			if (carregador==null) {
				carregador = new CotacaoProcessadaCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			
		}
		
		
		private CotacaoProcessada vo;
		public CotacaoProcessadaAgregado(CotacaoProcessada item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
	}
