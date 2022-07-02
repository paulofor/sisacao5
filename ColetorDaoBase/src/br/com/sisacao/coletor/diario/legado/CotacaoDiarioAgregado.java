package br.com.sisacao.coletor.diario.legado;

import br.com.digicom.lib.dao.DaoConexao;

// Gera??o autom?tica n?o alterar
	public class CotacaoDiarioAgregado implements CotacaoDiarioAgregadoI
	{
		
		private CotacaoDiarioCarregador carregador = null;
		private CotacaoDiarioCarregador getCarregador() {
			if (carregador==null) {
				carregador = new CotacaoDiarioCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			
		}
		
		
		private CotacaoDiario vo;
		public CotacaoDiarioAgregado(CotacaoDiario item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
	}
