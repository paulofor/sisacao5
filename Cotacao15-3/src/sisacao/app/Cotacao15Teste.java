package sisacao.app;

import java.util.List;

import br.com.digicom.lib.dao.DaoException;

import coletorjava.modelo.OpcaoReferencia;
import coletorjava.regracolecao.FabricaRegra;
import coletorjava.regracolecao.OpcaoReferenciaRegraColecao;

public class Cotacao15Teste {

	static OpcaoReferenciaRegraColecao opcaoRefSrv = FabricaRegra.getInstancia().getOpcaoReferenciaRegraColecao();

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		opcaoRefSrv.getFiltro().setData("12-09-2016");
		try {
			List<OpcaoReferencia> listaOpcao = opcaoRefSrv.ListaAtivoParaColetaNaData();
			for (OpcaoReferencia opcao : listaOpcao) {
				System.out.println(opcao.getCodigoMercado());
			}
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		
	}

}
