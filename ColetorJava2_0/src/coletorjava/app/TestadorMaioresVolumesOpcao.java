package coletorjava.app;

import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import coletorjava.modelo.OpcaoSisacao;
import coletorjava.regracolecao.FabricaRegra;
import coletorjava.regracolecao.OpcaoReferenciaRegraColecao;
import coletorjava.regracolecao.OpcaoSisacaoRegraColecao;
import coletorjava.util.UtilData;

public class TestadorMaioresVolumesOpcao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		OpcaoReferenciaRegraColecao srv = FabricaRegra.getInstancia().getOpcaoReferenciaRegraColecao();
		try {
			srv.getFiltro().setDataSexta(UtilData.obtemProximaSexta("01-01-2014"));
			srv.getFiltro().setDataFinal("24-04-2016");

			srv.GeraReferenciaPeriodo();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private static void listaOpcao() {
		OpcaoSisacaoRegraColecao srv  = FabricaRegra.getInstancia().getOpcaoSisacaoRegraColecao();
		srv.getFiltro().setCodigoTicker("ITUB4");
		srv.getFiltro().setData("08-04-2016");
		try {
			List<OpcaoSisacao> listaOpcao = srv.ListaOrdenadaNegocioPorTickerData();
			for (OpcaoSisacao opcao : listaOpcao) {
				System.out.println(opcao.getCodigoMercado() + " : " + opcao.getValorCotacao() + "(" + opcao.getQtdeNegocio() + ") : " + opcao.getCorrenteOpcaoSisacaoSerie_PertenceA().getDataVencimento());
			}
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	private static void geraReferencias() {
		OpcaoReferenciaRegraColecao srv = FabricaRegra.getInstancia().getOpcaoReferenciaRegraColecao();
		srv.getFiltro().setCodigoTicker("BBDC4");
		srv.getFiltro().setDataSexta("18-03-2016");
		try {
			srv.CriaSemanaPorTickerData();
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	
		
		
		
	

}
