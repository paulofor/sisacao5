package sisacao.opcaointra.app;

import br.com.digicom.lib.dao.DaoException;
import coletorjava.modelo.DiaPregao;
import coletorjava.regracolecao.DiaPregaoRegraColecao;
import coletorjava.regracolecao.FabricaRegra;
import timer.AgregadorThreadColeta;

public class TestadorApp {

	public static void main(String[] args) {
		//testaColetaDiaria();
		try {
			obtendoDiaPregao();
		} catch (DaoException e) {
			System.out.println("Erro:" + e.getMessage());
			e.printStackTrace();
		}
	}

	private static void pesquisOpcoesComVolume() throws DaoException {
		FuncoesObj obj = new FuncoesObj();
		obj.pesquisOpcoesComVolume();
	}
	
	private static void obtendoDiaPregao() throws DaoException {
		DiaPregaoRegraColecao diaPregaoSrv = FabricaRegra.getInstancia().getDiaPregaoRegraColecao();
		diaPregaoSrv.getFiltro().setDataPesquisa("06-01-2017");
		DiaPregao dia = diaPregaoSrv.ObtemPorDataPesquisa();
		System.out.println(dia.getData());
	}
	
	private static void testaColetaDiaria() {
		AgregadorThreadColeta obj = new AgregadorThreadColeta();
		obj.disparaColetoresDia("1219");
	}

	
}
