package coletorjava.regracolecao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.parse.log.DatasUtils;
import coletorjava.app.ColetorJava2Obj;
import coletorjava.app.Constantes;
import coletorjava.app.PosicaoBDI;
import coletorjava.dao.CotacaoDaoExtendida;
import coletorjava.dao.OpcaoSisacaoGeralDao;
import coletorjava.modelo.CotacaoDiario;
import coletorjava.modelo.FabricaVo;
import coletorjava.modelo.OpcaoSisacao;
import coletorjava.modelo.OpcaoSisacaoGeral;
import coletorjava.modelo.OpcaoSisacaoSerie;
import coletorjava.modelo.Ticker;
import coletorjava.regracolecao.CotacaoDiarioRegraColecao;
import coletorjava.regracolecao.FabricaRegra;
import coletorjava.regracolecao.OpcaoSisacaoGeralRegraColecao;
import coletorjava.regracolecao.OpcaoSisacaoRegraColecao;
import coletorjava.regracolecao.OpcaoSisacaoSerieRegraColecao;
import coletorjava.regracolecao.TickerRegraColecao;
import coletorjava.util.TrataArquivos;

public class OpcaoSisacaoGeralRegraColecaoImpl extends OpcaoSisacaoGeralRegraColecao {

	@Override
	public List<OpcaoSisacaoGeral> LeArquivoBDIDiaAnterior(DaoConexao conexao) throws DaoException {
		System.out.println("Lendo arquivo: " + ColetorJava2Obj.NOME_ARQUIVO_BDI);
		this.getFiltro().setNomeCompletoArquivoBDI(ColetorJava2Obj.NOME_ARQUIVO_BDI);
		return LeArquivoBDI(conexao);
	}

	@Override
	public List<OpcaoSisacaoGeral> LeArquivoBDI(DaoConexao conexao) throws DaoException {
		List<OpcaoSisacaoGeral> listaSaida = new LinkedList<OpcaoSisacaoGeral>();
		File arquivo = new File(this.getFiltro().getNomeCompletoArquivoBDI());
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(arquivo));
			String linha = reader.readLine();
			while ((linha = reader.readLine()) != null) {
				OpcaoSisacaoGeral opcao = this.extraiLinha(linha);
				if (opcao != null) {
					listaSaida.add(opcao);
				}
			}
		} catch (IOException e) {

		}
		System.out.println("Total : " + listaSaida.size());
		return listaSaida;
	}

	private OpcaoSisacaoGeral extraiLinha(String linha) {
		OpcaoSisacaoGeral opcao = null;
		String tipo = linha.substring(PosicaoBDI.TIPOREG_INI_D - 1, PosicaoBDI.TIPOREG_FIM_D);
		String nome = null;
		float precoExercicio = 0;
		String dataVencimento = null;
		String indCar = null;
		String descricaoBdi = null;
		String nomeRes = null;
		String especificacao = null;
		float ult, abe, max, min;
		long neg, vol;
		if (tipo.equals("02")) {
			nome = linha.substring(PosicaoBDI.COD_NEG_INI_D - 1, PosicaoBDI.COD_NEG_FIM_D).trim();
			precoExercicio = PosicaoBDI.extraiValor(PosicaoBDI.PREEXE_INI_D, PosicaoBDI.PREEXE_FIM_D, linha);
			descricaoBdi = linha.substring(PosicaoBDI.DESBDI_INI_D - 1, PosicaoBDI.DESBDI_FIM_D).trim();
			dataVencimento = PosicaoBDI.getDataDD_MM_AAAA(PosicaoBDI.DATVEN_INI_D, PosicaoBDI.DATVEN_FIM_D, linha);
			indCar = linha.substring(PosicaoBDI.INDCAR_INI_D - 1, PosicaoBDI.INDCAR_FIM_D);
			nomeRes = linha.substring(PosicaoBDI.NOMERES_INI_D - 1, PosicaoBDI.NOMERES_FIM_D).trim();
			especificacao = linha.substring(PosicaoBDI.ESPECI_INI_D - 1, PosicaoBDI.ESPECI_FIM_D).trim();
			// ----- Dados de Cotacao -----//
			neg = PosicaoBDI.extraiInteiro(PosicaoBDI.TOTNEG_INI_D, PosicaoBDI.TOTNEG_FIM_D, linha);

			if (descricaoBdi.contains("OPCOES COMPRA")) {
				// System.out.println(nome + " (" + precoExercicio + ")" +
				// nomeRes + " - " + especificacao);
				opcao = FabricaVo.criaOpcaoSisacaoGeral();
				opcao.setCodigoMercado(nome);
				opcao.setPrecoExercicio(precoExercicio);
				opcao.setMesAno(converteMesAno(dataVencimento));
				opcao.setEspecificacao(especificacao);
				opcao.setNomeRes(nomeRes);
				opcao.setDataVencimentoStr(dataVencimento);
				opcao.setTotalNegocioDiaAnterior(neg);

			}

		}
		return opcao;
	}

	private String converteMesAno(String dataVencimento) {
		// DD-MM-AAAA
		// 01234567890
		String saida = "01-" + dataVencimento.substring(3);
		return saida;
	}

	@Override
	public OpcaoSisacaoGeral AtualizaLista(DaoConexao conexao) throws DaoException {
		TickerRegraColecao tickerServ = FabricaRegra.getInstancia().getTickerRegraColecao();
		List<OpcaoSisacaoGeral> listaOpcao = this.getListaEntradaItem();
		OpcaoSisacaoGeralDao dao = getDao();
		dao.setConexao(conexao);
		for (OpcaoSisacaoGeral opcao : listaOpcao) {
			OpcaoSisacaoGeral pesquisa = dao.ObtemPorTickerMesAno(opcao.getCodigoMercado(), DCConvert.ToDataAAAA_MM_DD(opcao.getMesAno()));

			if (pesquisa == null) {
				tickerServ.getFiltro().setOpcaoArquivo(opcao);
				Ticker ticker = tickerServ.ObtemPorOpcaoSisacaoGeral(conexao);
				opcao.setTickerReferenteA(ticker);
				if (ticker != null) {
					dao.insereItem(opcao);
					System.out.println("Inseriu:" + opcao.getCodigoMercado());
				} else {
					System.out.println("Não achou ticker: " + opcao.getCodigoMercado());
				}
			}
		}
		return null;
	}

	@Override
	public OpcaoSisacaoGeral ExtraiOpcoesParaColeta(DaoConexao conexao) throws DaoException {
		/*
		 * Lógica de montagem 1- Obter todas as opcoes que vencem 2 meses a
		 * frente. 2- Encontrar em qual série vai entrar (observando que se não
		 * existe deve ser criada a nova série) 3- Inserir na lista de opçoes (
		 * colocando o Ticker e a Serie )
		 */
		String data = getDataSomaMesColeta(1);
		this.getFiltro().setMesAno(data);
		// Interessante coletar todas ? Ou so com preço de exercicio próximo ?
		// Todas !!!
		List<OpcaoSisacaoGeral> listaParaColeta = this.ListaPorMesAnoComTickerPreco(conexao);

		OpcaoSisacaoRegraColecao opcaoSisacaoSrv = FabricaRegra.getInstancia().getOpcaoSisacaoRegraColecao();
		OpcaoSisacaoSerieRegraColecao serieSisacaoSrv = FabricaRegra.getInstancia().getOpcaoSisacaoSerieRegraColecao();
		serieSisacaoSrv.getFiltro().setMesAnoBd(data);
		serieSisacaoSrv.getFiltro().setVencimento(listaParaColeta.get(0).getDataVencimentoStr());
		OpcaoSisacaoSerie serie = serieSisacaoSrv.ObtemCriaSeNecessario(conexao);

		CotacaoDaoExtendida daoIntraday = new CotacaoDaoExtendida();
		DaoConexao conexaoIntra = daoIntraday.criaConexao();
		daoIntraday.setConexao(conexaoIntra);
		for (OpcaoSisacaoGeral opcao : listaParaColeta) {
			OpcaoSisacao nova = FabricaVo.criaOpcaoSisacao();
			nova.setCodigoMercado(opcao.getCodigoMercado());
			nova.setTickerDerivativoDe(opcao.getTickerReferenteA(false));
			nova.setOpcaoSisacaoSeriePertenceA(serie);
			nova.setPrecoExercicio(opcao.getPrecoExercicio());
			opcaoSisacaoSrv.getFiltro().setItem(nova);
			opcaoSisacaoSrv.CriaSeNecessario(conexao);
			daoIntraday.criaTabelaIntradayOpcao(opcao.getCodigoMercado().toUpperCase());
			//
		}
		conexaoIntra.fechaConexao();

		return null;
	}

	private String getDataSomaMesColeta(int meses) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, meses);
		String dataStr = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-01");
		dataStr = sdf.format(cal.getTime());
		return dataStr;
	}

	@Override
	public List<OpcaoSisacaoGeral> ListaPorMesAnoComTickerPreco(DaoConexao conexao) throws DaoException {
		List<OpcaoSisacaoGeral> lista = null;
		OpcaoSisacaoGeralDao dao = getDao();

		String dataBD = this.getFiltro().getMesAno();
		dao.setConexao(conexao);
		lista = dao.ListaPorMesAnoComTicker(dataBD);
		CotacaoDiarioRegraColecao cotacaoDiarioSrv = FabricaRegra.getInstancia().getCotacaoDiarioRegraColecao();
		for (OpcaoSisacaoGeral opcao : lista) {
			cotacaoDiarioSrv.getFiltro().setTicker(opcao.getTickerReferenteA(false));
			// CotacaoDiario cotacao =
			// cotacaoDiarioSrv.CotacaoMaisRecentePorTicker(conexao);
		}
		return lista;
	}

	@Override
	public OpcaoSisacaoGeral RegistrarPorCotacaoDiario(DaoConexao conexao) throws DaoException {
		this.getFiltro().validaCotacaoDiario();
		CotacaoDiario diario = this.getFiltro().getCotacaoDiario();
		System.out.println(diario.getLinhaLog());
		OpcaoSisacaoSerieRegraColecao serieSrv = FabricaRegra.getInstancia().getOpcaoSisacaoSerieRegraColecao();
		serieSrv.getFiltro().setCotacaoDiario(diario);
		OpcaoSisacaoSerie serie = serieSrv.ObtemOuCriaPorCotacaoDiario(conexao);
		OpcaoSisacaoGeralDao dao = getDao(conexao);
		String ticker = diario.getNomeTicker();
		String mesAnoBd = diario.getMesAnoOpcao();
		OpcaoSisacaoGeral pesquisa = obtemPorMesAnoCodigoMercado(mesAnoBd, ticker, conexao);
		if (pesquisa == null) {
			TickerRegraColecao tickerSrv = FabricaRegra.getInstancia().getTickerRegraColecao();
			tickerSrv.getFiltro().setCotacaoDiarioOpcao(diario);
			Ticker tickerObj = tickerSrv.ObtemPorCotacaoDiarioOpcao(conexao);
			if (tickerObj != null) {
				OpcaoSisacaoGeral opcao = FabricaVo.criaOpcaoSisacaoGeral();
				opcao.setCodigoMercado(diario.getNomeTicker());
				opcao.setTickerReferenteA(tickerObj);
				opcao.setPrecoExercicio(diario.getPrecoExercicio());
				opcao.setDataInclusao(DatasUtils.getDataDD_MM_AAAA());
				opcao.setMesAno(DatasUtils.converteAAAA_MM_DD2DD_MM_AAAA(mesAnoBd));
				dao.insereItem(opcao); // o que é o insere se não existe ?
			}
		}
		return null;
	}

	private OpcaoSisacaoGeral obtemPorMesAnoCodigoMercado(String mesAnoDb, String nomeTicker, DaoConexao conexao) throws DaoException {
		OpcaoSisacaoGeralDao dao = getDao(conexao);
		OpcaoSisacaoGeral result = dao.obtemPorMesAnoCodigoMercado(mesAnoDb, nomeTicker);
		return result;
	}

	private String colocaDiaPrimeiro(String dataNormal) {
		// DD-MM-AAAAA
		// 01234567890
		return "01-" + dataNormal.substring(3);
	}

	private String obtemMesAnoBd(String dataNormal) {
		// DD-MM-AAAAA
		// 01234567890
		String ano = dataNormal.substring(6);
		String mes = dataNormal.substring(3, 5);
		return ano + "-" + mes + "-01";
	}

	@Override
	public List<OpcaoSisacaoGeral> ListaPorMesAnoCodigoTicker(DaoConexao conexao) throws DaoException {
		String codigoTicker = this.getFiltro().validaCodigoTicker();
		String mesAno = this.getFiltro().validaMesAno();
		mesAno = obtemMesAnoBd(mesAno);
		OpcaoSisacaoGeralDao dao = getDao(conexao);
		return dao.ListaPorMesAnoCodigoTicker(mesAno, codigoTicker);
	}

	@Override
	public List<OpcaoSisacaoGeral> ListaPorDataCodigoTicker(DaoConexao conexao) throws DaoException {
		String tickerAtivo = this.getFiltro().validaCodigoTicker();
		String data = this.getFiltro().getData();
		OpcaoSisacaoSerieRegraColecao serieSrv = FabricaRegra.getInstancia().getOpcaoSisacaoSerieRegraColecao();
		serieSrv.getFiltro().setData(data);
		List<OpcaoSisacaoSerie> listaSerie = serieSrv.SeriesAtivasPorData(conexao);
		OpcaoSisacaoGeralRegraColecao opcaoGeralSrv = FabricaRegra.getInstancia().getOpcaoSisacaoGeralRegraColecao();
		opcaoGeralSrv.getFiltro().setCodigoTicker(tickerAtivo);
		List<OpcaoSisacaoGeral> listaOpcaoGeral = null;
		for (OpcaoSisacaoSerie serie : listaSerie) {
			opcaoGeralSrv.getFiltro().setMesAno(serie.getMesAno());
			List<OpcaoSisacaoGeral> lista = opcaoGeralSrv.ListaPorMesAnoCodigoTicker(conexao);
			if (listaOpcaoGeral == null) {
				listaOpcaoGeral = lista;
			} else {
				listaOpcaoGeral.addAll(lista);
			}
		}
		return listaOpcaoGeral;
	}

	@Override
	public OpcaoSisacaoGeral EscolheOpcoes15Minutos(DaoConexao conexao) throws DaoException {
		String mesAno = this.getFiltro().validaMesAno();
		String ticker = this.getFiltro().validaCodigoTicker();
		// Começa a coleta dois meses antes
		mesAno = somaMesParaMesAno(mesAno, 2);
		mesAno = DatasUtils.converteDD_MM_AAAA2AAAA_MM_DD(mesAno);
		OpcaoSisacaoGeralDao dao = getDao(conexao);
		dao.ListaPorMesAnoCodigoTicker(mesAno, ticker);
		return null;
	}

	private String somaMesParaMesAno(String mesAno, int meses) {
		// 01-MM-AAAA
		// 0123456789
		String mes = mesAno.substring(3, 5);
		String ano = mesAno.substring(6);
		int mesInt = Integer.parseInt(mes);
		int anoInt = Integer.parseInt(ano);
		mesInt = mesInt + meses;
		if (mesInt > 12) {
			mesInt = mesInt - 12;
			anoInt = anoInt + 1;
		}
		String dataSaida = "01-" + String.format("%02d", mesInt) + "-" + anoInt;
		return dataSaida;
	}

	@Override
	public List<OpcaoSisacaoGeral> SelecionarParaColetaPorDataTicker(DaoConexao conexao) throws DaoException {
		CotacaoDiarioRegraColecao diarioSrv = FabricaRegra.getInstancia().getCotacaoDiarioRegraColecao();
		String dataColeta = this.getFiltro().validaData();
		diarioSrv.getFiltro().setCodigoTicker(this.getFiltro().validaCodigoTicker());
		diarioSrv.getFiltro().setData(dataColeta);
		CotacaoDiario cotacao = diarioSrv.ObtemPorNomeTickerAnteriorData(conexao);
		float limite1 = cotacao.getFechamentoOriginal() - 5;
		float limite2 = cotacao.getAberturaOriginal() + 5;
		String mesAnoOpcao = somaMesParaMesAno(dataColeta, 2);
		this.getFiltro().setMesAno(mesAnoOpcao);
		List<OpcaoSisacaoGeral> lista = this.ListaPorMesAnoCodigoTicker(conexao);
		List<OpcaoSisacaoGeral> escolhidos = new LinkedList<OpcaoSisacaoGeral>();
		for (OpcaoSisacaoGeral opcao : lista) {
			if (opcao.getPrecoExercicio() >= limite1 && opcao.getPrecoExercicio() <= limite2) {
				escolhidos.add(opcao);
			}
		}
		return escolhidos;
	}

	@Override
	public List<OpcaoSisacaoGeral> Lista15MinutosPorDataTicker(DaoConexao conexao) throws DaoException {
		String data = getFiltro().validaData();
		String ticker = getFiltro().validaCodigoTicker();
		OpcaoSisacaoGeralDao dao = getDao(conexao);
		data = DatasUtils.converteDD_MM_AAAA2AAAA_MM_DD(data);
		return dao.Lista15MinutosPorDataTicker(data, ticker);
	}

	@Override
	public List<OpcaoSisacaoGeral> MelhoresParaColeta(DaoConexao conexao) throws DaoException {
		List<OpcaoSisacaoGeral> listaComLiquidez = this.MelhoresComLiquidezDiaAnterior(conexao);
		List<String> listaTicker = new ArrayList<String>();
		for (OpcaoSisacaoGeral opcao : listaComLiquidez) {
			// opcao.get
			System.out.println(opcao.getCodigoMercado() + "(" + opcao.getPrecoExercicioFormatada() + ") " + opcao.getTotalNegocioDiaAnterior());
		}
		System.out.println("Total: " + listaComLiquidez.size());
		return listaComLiquidez;
	}

	@Override
	public List<OpcaoSisacaoGeral> MelhoresComLiquidezDiaAnterior(DaoConexao conexao) throws DaoException {
		List<OpcaoSisacaoGeral> listaDiaAnterior = this.LeArquivoBDIDiaAnterior(conexao);
		List<OpcaoSisacaoGeral> listaSaida = new ArrayList<OpcaoSisacaoGeral>();
		for (OpcaoSisacaoGeral opcao : listaDiaAnterior) {
			if (opcao.getTotalNegocioDiaAnterior() > Constantes.NEGOCIOS_PARA_COLETA_OPCAO) {
				listaSaida.add(opcao);
			}
		}
		return listaSaida;
	}

	@Override
	public List<OpcaoSisacaoGeral> ListaOrdenadaNegocioPorTickerData(DaoConexao conexao) throws DaoException {
		List<OpcaoSisacaoGeral> listaSaida = new ArrayList<OpcaoSisacaoGeral>();
		
		String nomeTicker = getFiltro().validaCodigoTicker();
		String dataRef = getFiltro().validaData();
		
		String ano = dataRef.substring(6);
		String dia = dataRef.substring(0,2);
		String mes = dataRef.substring(3,5);
		List<CotacaoDiario> listaComNegocio = new ArrayList<CotacaoDiario>();
		String nomeArquivoZip = "D:/CotacaoJava/download/" + ano + "/bdi" + mes + dia + ".zip";
		String nomeArquivo = "D:/CotacaoJava/download/Temp";
		
		try {
			TrataArquivos.unzipFiles(nomeArquivoZip, nomeArquivo);
			
			TickerRegraColecao tickerSrv = FabricaRegra.getInstancia().getTickerRegraColecao();
			tickerSrv.getFiltro().setCodigoEmpresa(nomeTicker);
			Ticker ticker = tickerSrv.ObtemPorCodigo();

			CotacaoDiarioRegraColecao cotacaoSrv = FabricaRegra.getInstancia().getCotacaoDiarioRegraColecao();
			cotacaoSrv.getFiltro().setTicker(ticker);

			

			File arquivo = new File(nomeArquivo);
			BufferedReader reader = null;
			reader = new BufferedReader(new FileReader(arquivo));
			String linha = reader.readLine();
			while ((linha = reader.readLine()) != null) {
				cotacaoSrv.getFiltro().setLinhaArquivoDiario(linha);
				// System.out.println(linha);
				CotacaoDiario cotacao = cotacaoSrv.ExtraiLinhaArquivoDiario(null);
				if (cotacao.getEhOpcao() && cotacao.getNegocios() > 0) {
					if ((cotacao.getNomeResArquivo().substring(0, 4).compareToIgnoreCase(ticker.getNome().substring(0, 4)) == 0)
							&& (cotacao.getEspecificacaoArquivo().split(" ")[0].compareToIgnoreCase(ticker.getTipoAcao()) == 0)) {
						// System.out.println(cotacao.getNomeTicker() + " : " +
						// cotacao.getFechamentoOriginalFormatada() + " (" +
						// cotacao.getNegocios() + ")");
						listaComNegocio.add(cotacao);
					}
				}
			}
			Collections.sort(listaComNegocio, new Comparator<CotacaoDiario>() {
				@Override
				public int compare(CotacaoDiario cot1, CotacaoDiario cot2) {
					return (int) (cot2.getNegocios() - cot1.getNegocios());
				}
			});

		} catch (IOException e) {
			System.out.println("Erro Arquivo");
			e.printStackTrace();
		}
		for (CotacaoDiario cotacao : listaComNegocio) {
			this.getFiltro().setCodigoTicker(cotacao.getNomeTicker());
			this.getFiltro().setData(dataRef);
			OpcaoSisacaoGeral opcao = this.ObtemPorDataCodigoTicker();
			//System.out.println(cotacao.getNomeTicker() + " : " + cotacao.getFechamentoOriginalFormatada() + " (" + cotacao.getNegocios() + ") Vcto:"
			//		+ cotacao.getDataVencimento());
			if (opcao==null) {
				//System.out.println("Nao existe");
			} else {
				opcao.setValorCotacao(cotacao.getFechamentoOriginal());
				opcao.setQtdeNegocio(cotacao.getNegocios());
				listaSaida.add(opcao);
			}
		}
		return listaSaida;
	}

	@Override
	public OpcaoSisacaoGeral ObtemPorDataCodigoTicker(DaoConexao conexao) throws DaoException {
		String data = getFiltro().validaData();
		String ticker = getFiltro().validaCodigoTicker();
		OpcaoSisacaoGeralDao dao = getDao(conexao);
		//data = DatasUtils.converteDD_MM_AAAA2AAAA_MM_DD(data);
		// DD-MM-AAAA
		// 0123456789
		String ano = data.substring(6) + "-12-31";
		return dao.ObtemPorAnoCodigoTicker(ano,ticker);
	}

	
	

}
