package coletorjava.regracolecao.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.util.DCConvert;
import coletorjava.dao.OpcaoReferenciaDao;
import coletorjava.modelo.DiaPregao;
import coletorjava.modelo.FabricaVo;
import coletorjava.modelo.OpcaoReferencia;
import coletorjava.modelo.OpcaoSisacao;
import coletorjava.modelo.Ticker;
import coletorjava.regracolecao.DiaPregaoRegraColecao;
import coletorjava.regracolecao.FabricaRegra;
import coletorjava.regracolecao.OpcaoReferenciaRegraColecao;
import coletorjava.regracolecao.OpcaoSisacaoRegraColecao;
import coletorjava.regracolecao.TickerRegraColecao;
import coletorjava.util.UtilData;

public class OpcaoReferenciaRegraColecaoImpl extends OpcaoReferenciaRegraColecao {

	String[] listaTicker = new String[] { "ITUB4", "BBDC4", "VALE5", "BBAS3" };

	DiaPregaoRegraColecao diaSrv = FabricaRegra.getInstancia().getDiaPregaoRegraColecao();
	OpcaoSisacaoRegraColecao srv = FabricaRegra.getInstancia().getOpcaoSisacaoRegraColecao();
	TickerRegraColecao tickerSrv = FabricaRegra.getInstancia().getTickerRegraColecao();

	@Override
	public OpcaoReferencia CriaSemanaPorTickerData(DaoConexao conexao) throws DaoException {

		srv.getFiltro().setCodigoTicker(this.getFiltro().getCodigoTicker());
		srv.getFiltro().setData(this.getFiltro().getDataSexta());

		List<OpcaoSisacao> listaOpcao = null;
		listaOpcao = srv.ListaOrdenadaNegocioPorTickerData(conexao);

		while (listaOpcao == null) {
			String dataPesquisa = srv.getFiltro().getData();
			diaSrv.getFiltro().setDataDeslocamento(dataPesquisa);
			diaSrv.getFiltro().setDiasDeslocamento(-1);
			DiaPregao dataAnterior = diaSrv.DeslocaDias(conexao);
			srv.getFiltro().setData(dataAnterior.getData());
			listaOpcao = srv.ListaOrdenadaNegocioPorTickerData(conexao);
		}
		srv.getFiltro().setData(this.getFiltro().getDataSexta());

		tickerSrv.getFiltro().setCodigoEmpresa(this.getFiltro().getCodigoTicker());
		Ticker ticker = tickerSrv.ObtemPorCodigo(conexao);

		String data = this.getFiltro().getDataSexta();
		diaSrv.getFiltro().setDataSexta(data);
		List<DiaPregao> listaDia = diaSrv.ObtemProximaSemana(conexao);

		OpcaoSisacao escolhida = aplicaRegraEscolha(listaOpcao);
		List<OpcaoReferencia> listaInsercao = new ArrayList<OpcaoReferencia>();
		for (DiaPregao dia : listaDia) {
			OpcaoReferencia opcao = FabricaVo.criaOpcaoReferencia();
			opcao.setDiaPregaoReferenteA(dia);
			opcao.setOpcaoSisacaoReferenteA(escolhida);
			opcao.setTickerReferenteA(ticker);
			opcao.setData(dia.getData());
			opcao.setCodigoMercado(escolhida.getCodigoMercado());
			listaInsercao.add(opcao);
		}

		OpcaoReferenciaDao dao = getDao(conexao);
		for (OpcaoReferencia referencia : listaInsercao) {
			dao.insereItem(referencia);
		}

		return listaInsercao.get(listaInsercao.size() - 1);

	}

	private final float PRECO_MAIOR_1 = 1.9f;
	private final float PRECO_MENOR_1 = 0.6f;
	private final float PRECO_MAIOR_2 = 2.8f;
	private final float PRECO_MENOR_2 = 0.3f;

	private final int DIA_MAX_1 = 40;
	private final int DIA_MIN_1 = 8;
	private final int DIA_MAX_3 = 50;
	private final int DIA_MIN_3 = 6;

	// Tempo > 10
	private OpcaoSisacao aplicaRegraEscolha(List<OpcaoSisacao> listaOpcao) throws DaoException {
		OpcaoSisacao saida = null;
		for (OpcaoSisacao opcao : listaOpcao) {
			this.diaSrv.getFiltro().setOpcaoVencimento(opcao);
			List<DiaPregao> dias = this.diaSrv.SextaAteVencimento();
			System.out.println(opcao.getCodigoMercado() + " dias: " + dias.size() + " $ " + opcao.getValorCotacao() + " (" + opcao.getQtdeNegocio() + ")");
			if (dias.size() >= DIA_MIN_1 && dias.size() <= DIA_MAX_1 && opcao.getValorCotacao() >= PRECO_MENOR_1 && opcao.getValorCotacao() <= PRECO_MAIOR_1) {
				saida = opcao;
				break;
			}
		}
		if (saida == null) {
			// Segunda Tentativa
			for (OpcaoSisacao opcao : listaOpcao) {
				this.diaSrv.getFiltro().setOpcaoVencimento(opcao);
				List<DiaPregao> dias = this.diaSrv.SextaAteVencimento();
				System.out.println(opcao.getCodigoMercado() + " dias: " + dias.size() + " $ " + opcao.getValorCotacao() + " (" + opcao.getQtdeNegocio() + ")");
				if (dias.size() >= DIA_MIN_1 && dias.size() <= DIA_MAX_1 && opcao.getValorCotacao() >= PRECO_MENOR_2
						&& opcao.getValorCotacao() <= PRECO_MAIOR_2) {
					saida = opcao;
					break;
				}
			}
		}
		if (saida == null) {
			// Terceira Tentativa
			for (OpcaoSisacao opcao : listaOpcao) {
				this.diaSrv.getFiltro().setOpcaoVencimento(opcao);
				List<DiaPregao> dias = this.diaSrv.SextaAteVencimento();
				System.out.println(opcao.getCodigoMercado() + " dias: " + dias.size() + " $ " + opcao.getValorCotacao() + " (" + opcao.getQtdeNegocio() + ")");
				if (dias.size() >= DIA_MIN_3 && dias.size() <= DIA_MAX_3 && opcao.getValorCotacao() >= PRECO_MENOR_2
						&& opcao.getValorCotacao() <= PRECO_MAIOR_2) {
					saida = opcao;
					break;
				}
			}
		}
		return saida;
	}

	@Override
	public OpcaoReferencia GeraReferenciaDia(DaoConexao conexao) throws DaoException {
		for (String ticker : listaTicker) {
			getFiltro().setCodigoTicker(ticker);
			this.CriaSemanaPorTickerData(conexao);
		}
		return null;
	}

	@Override
	public OpcaoReferencia GeraReferenciaPeriodo(DaoConexao conexao) throws DaoException {
		try {
			boolean continua = true;
			while (continua) {
				GeraReferenciaDia(conexao);
				diaSrv.getFiltro().setDataSexta(getFiltro().validaDataSexta());
				String proximo;

				proximo = UtilData.obtemProximaSexta(getFiltro().validaDataSexta());

				getFiltro().setDataSexta(proximo);
				continua = testaContinua(getFiltro().getDataSexta(), getFiltro().getDataFinal());
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	private boolean testaContinua(String dataSexta, String dataFinal) {
		return (UtilData.getNumeroData(dataSexta) < UtilData.getNumeroData(dataFinal));
	}

	@Override
	public List<OpcaoReferencia> ListaAtivoParaColetaNaData(DaoConexao conexao) throws DaoException {
		String dataBd = DCConvert.ToDataAAAA_MM_DD(this.getFiltro().validaData());
		OpcaoReferenciaDao dao = getDao(conexao);
		return dao.ListaAtivoParaColetaNaData(dataBd);
	}

}
