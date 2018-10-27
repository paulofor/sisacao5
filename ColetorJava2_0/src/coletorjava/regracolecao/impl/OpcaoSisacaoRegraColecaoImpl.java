package coletorjava.regracolecao.impl;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.parse.log.DatasUtils;
import coletorjava.dao.CotacaoDaoExtendida;
import coletorjava.dao.CotacaoProcessadaDao;
import coletorjava.dao.DBB;
import coletorjava.dao.OpcaoSisacaoDao;
import coletorjava.dao.OpcaoSisacaoGeralDao;
import coletorjava.modelo.Cotacao;
import coletorjava.modelo.CotacaoDiario;
import coletorjava.modelo.FabricaVo;
import coletorjava.modelo.OpcaoSisacao;
import coletorjava.modelo.OpcaoSisacaoGeral;
import coletorjava.modelo.OpcaoSisacaoSerie;
import coletorjava.modelo.Ticker;
import coletorjava.modelo.vo.custom.OpcaoSisacaoECotacao;
import coletorjava.regracolecao.CotacaoDiarioRegraColecao;
import coletorjava.regracolecao.CotacaoProcessadaRegraColecao;
import coletorjava.regracolecao.CotacaoRegraColecao;
import coletorjava.regracolecao.DiaPregaoRegraColecao;
import coletorjava.regracolecao.FabricaRegra;
import coletorjava.regracolecao.OpcaoSisacaoGeralRegraColecao;
import coletorjava.regracolecao.OpcaoSisacaoRegraColecao;
import coletorjava.regracolecao.OpcaoSisacaoSerieRegraColecao;
import coletorjava.regracolecao.TickerRegraColecao;
import coletorjava.util.TrataArquivos;
import coletorjava.util.UtilData;


public class OpcaoSisacaoRegraColecaoImpl  extends OpcaoSisacaoRegraColecao {

	@Override
	public List<OpcaoSisacao> Lista15MinutosPorDataTicker(DaoConexao conexao) throws DaoException {
		String data = getFiltro().validaData();
		String ticker = getFiltro().validaCodigoTicker();
		OpcaoSisacaoDao dao = getDao(conexao);
		data = DatasUtils.converteDD_MM_AAAA2AAAA_MM_DD(data);
		return dao.Lista15MinutosPorDataTicker(data,ticker);
	}
	
	
	@Override
	public OpcaoSisacao CriaSeNecessario(DaoConexao conexao) throws DaoException {
		OpcaoSisacao item = this.getFiltro().getItem();
		if (item==null) {
			throw new RuntimeException("Item não colocado no filtro");
		}
		if (item.getIdOpcaoSisacaoSeriePa()==0) {
			throw new RuntimeException("Item sem IdOpcaoSisacaoSeriePa");
		}
		OpcaoSisacaoDao dao = getDao();
		dao.setConexao(conexao);
		if (item.getCodigoMercado().indexOf("VALE")!=-1) {
			System.out.println("Teste");
		}
		OpcaoSisacao pesquisa = dao.ObtemPorCodigoSerie(item.getCodigoMercado(), item.getIdOpcaoSisacaoSeriePa());
		
		if (pesquisa==null) {
			System.out.println(item.getCodigoMercado() + " inseriu");
			dao.insereItem(item);
		} else {
			System.out.println(item.getCodigoMercado() + " encontrou");
			item = pesquisa;
		}
		return item;
	}

	@Override
	public List<OpcaoSisacao> ListaIntradayDisponivelPorDataTicker(DaoConexao conexao) throws DaoException {
		// TODO Auto-generated method stub
		throw new RuntimeException("Metodo nao implementado");
	}

	@Override
	public OpcaoSisacao CriaParaColetaPorVolumeNegocioDiaAnterior(DaoConexao conexao) throws DaoException {
		// Passos:
		// 1- Identificar as opcoes com volume de negocios superior a 50 no dia anterior.
		// 2- Tratar essas lista de opcoes.
		// 3- Verifica se já está sendo coletada, não faz nada (data_vencimento (serie) - codigo mercado )
		// 4- Se não esta sendo coletada
		// 4.1 - Verifica se existe a serie, se náo criar
		// 4.2 - Verifica se existe o ticker se não criar
		// 4.3 - Verifica se existe tabela se não criar
		// 4.4 - Cria o registro para inicio de coleta no mes seguinte
		OpcaoSisacaoGeralRegraColecao geralSrv = FabricaRegra.getInstancia().getOpcaoSisacaoGeralRegraColecao();
		OpcaoSisacaoRegraColecao opcaoSrv = FabricaRegra.getInstancia().getOpcaoSisacaoRegraColecao();
		OpcaoSisacaoSerieRegraColecao serieSrv = FabricaRegra.getInstancia().getOpcaoSisacaoSerieRegraColecao();
		TickerRegraColecao tickerSrv = FabricaRegra.getInstancia().getTickerRegraColecao();
		
		List<OpcaoSisacaoGeral> listaGeral = geralSrv.MelhoresComLiquidezDiaAnterior(conexao);
		for (OpcaoSisacaoGeral opcao : listaGeral) {
			opcaoSrv.getFiltro().setCodigoTicker(opcao.getCodigoMercado());
			opcaoSrv.getFiltro().setData(opcao.getDataVencimentoStr());
			OpcaoSisacao opcaoBd = opcaoSrv.ObtemPorCodigoMercadoEVencimento(conexao);
			OpcaoSisacao nova = FabricaVo.criaOpcaoSisacao();
			nova.setCodigoMercado(opcao.getCodigoMercado());
			nova.setDataInicioColeta(DatasUtils.getDataDD_MM_AAAA());
			nova.setPrecoExercicio(opcao.getPrecoExercicio());
			
			if (opcaoBd == null) {
				System.out.println("Inserindo " + opcao.getCodigoMercado() + " em opcao_sisacao");
				String dataBd = DatasUtils.converteDD_MM_AAAA2AAAA_MM_DD(opcao.getMesAno());
				serieSrv.getFiltro().setMesAnoBd(dataBd);
				serieSrv.getFiltro().setVencimento(opcao.getDataVencimentoStr());
				OpcaoSisacaoSerie serie = serieSrv.ObtemCriaSeNecessario(conexao);
				tickerSrv.getFiltro().setOpcaoArquivo(opcao);
				Ticker ticker = tickerSrv.ObtemPorOpcaoSisacaoGeral(conexao);
				if (ticker==null) {
					// Criar o ticker
					String especificacao = tickerSrv.getFiltro().getOpcaoArquivo().getEspecificacao().trim();
					String nomeRes = tickerSrv.getFiltro().getOpcaoArquivo().getNomeRes().substring(0,4).trim();
					System.out.println("Não existe ticker: " + nomeRes + " (" + especificacao + ")");
				} else {
					nova.setOpcaoSisacaoSeriePertenceA(serie);
					nova.setTickerDerivativoDe(ticker);
					opcaoSrv.insereItemLoad(nova, conexao);
					
				}
				
			}
			opcaoSrv.getFiltro().setItem(nova);
			opcaoSrv.CriaTabelaColetaIntraday(conexao);
					
		}
		for (OpcaoSisacaoGeral opcao : listaGeral) {
			System.out.println("repair table intradayopcao." + opcao.getCodigoMercado().toLowerCase() + ";");
		}
		System.out.println("repair table intradayopcao.vale5;");
		System.out.println("repair table intradayopcao.petr4;");
		System.out.println("repair table intradayopcao.bbdc4;");
		System.out.println("repair table intradayopcao.itub4;");
		System.out.println("repair table intraday.vale5;");
		System.out.println("repair table intraday.petr4;");
		System.out.println("repair table intraday.bbdc4;");
		System.out.println("repair table intraday.itub4;");
		return null;
	}

	@Override
	public OpcaoSisacao ObtemPorCodigoMercadoEVencimento(DaoConexao conexao) throws DaoException {
		String dataVencimento = DatasUtils.converteDD_MM_AAAA2AAAA_MM_DD(getFiltro().validaData());
		String codigoMercado = getFiltro().validaCodigoTicker();
		OpcaoSisacaoDao dao = getDao();
		dao.setConexao(conexao);
		OpcaoSisacao opcao = dao.ObtemPorCodigoMercadoEVencimento(dataVencimento, codigoMercado);
		return opcao;	
	}

	@Override
	public OpcaoSisacao CriaTabelaColetaIntraday(DaoConexao conexao) throws DaoException {
		OpcaoSisacao opcao = this.getFiltro().validaItem();
		CotacaoDaoExtendida dao = (CotacaoDaoExtendida) DBB.getInstancia().getCotacaoDao();
		dao.setConexao(conexao);
		//dao.setIntradayOpcao();
		//dao.setConexao(dao.criaConexao());
		dao.criaTabelaIntradayOpcao(opcao.getCodigoMercado());
		return opcao;
	}

	@Override
	public List<OpcaoSisacao> ListaPorTickerMesAnoUso(DaoConexao conexao) throws DaoException {
		String data1 = this.getFiltro().validaData();
		String dataProximoMes = UtilData.getDataProximoMes(data1);
		this.getFiltro().setData(dataProximoMes);
		List<OpcaoSisacao> saida = this.ListaPorTickerMesAno(conexao);
		this.getFiltro().setData(data1);
		return saida;
	}

	@Override
	public List<OpcaoSisacao> ListaSemDadosIntradayPorSerie(DaoConexao conexao) throws DaoException {
		// TODO Auto-generated method stub
		throw new RuntimeException("Metodo nao implementado");
	}

	@Override
	public OpcaoSisacao ExisteDadoIntraday(DaoConexao conexao) throws DaoException {
		// TODO Auto-generated method stub
		OpcaoSisacao opcao = this.getFiltro().validaItem();
		if (opcao.getOpcaoSisacaoSeriePertenceA(false)==null) new RuntimeException("E preciso incluitr OpcaoSisacaoSerie");
		
		String codigoMercado = opcao.getCodigoMercado();
		String mesAno = opcao.getOpcaoSisacaoSeriePertenceA(false).getMesAno();
		//dd-mm-aaaa
		//0123456789
		String ano = mesAno.substring(6);
		String dataInicial = ano + "-01-01";
		String dataFinal = ano + "-12-31";
		// Criar uma conexao com o banco intraday local
		CotacaoDaoExtendida daoCotacao = (CotacaoDaoExtendida) DBB.getInstancia().getCotacaoDao();
		daoCotacao.setIntradayOpcao();
		DaoConexao connLocal = daoCotacao.criaConexao();
		daoCotacao.setConexao(connLocal);
		
		long quantidade = daoCotacao.quantidadeRegistros(codigoMercado, dataInicial, dataFinal);
		return ((quantidade>0)?opcao:null);
	}

	@Override
	public OpcaoSisacao MelhorEscolhaTickerData(DaoConexao conexao) throws DaoException {
		throw new RuntimeException("Metodo nao implementado");
	}
	@Override
	public OpcaoSisacao MelhorEscolhaTickerDataVenda(DaoConexao conexao) throws DaoException {
		DiaPregaoRegraColecao diaPregaoSrv = FabricaRegra.getInstancia().getDiaPregaoRegraColecao();
		
		CotacaoRegraColecao cotacaoSrv = FabricaRegra.getInstancia().getCotacaoRegraColecao();
		List<OpcaoSisacaoECotacao> listaCandidata = new ArrayList<OpcaoSisacaoECotacao>();
		List<OpcaoSisacao> listaOpcao = this.ListaPorTickerMesAnoUso();
		int cont = 0;
		for (OpcaoSisacao item : listaOpcao) {
			cotacaoSrv.getFiltro().setDataPesquisa(this.getFiltro().getData());
			cotacaoSrv.getFiltro().setNomeTicker(item.getCodigoMercado());
			Cotacao cotacao = cotacaoSrv.AnteriorDataPesquisaQuantidadeOpcao();
			if (cotacao!=null) {
				listaCandidata.add(new OpcaoSisacaoECotacao(item, cotacao));
			}
		}
		Collections.sort(listaCandidata, new Comparator() {
            @Override
            public int compare(Object i1, Object i2) {
            	OpcaoSisacaoECotacao obj1 = (OpcaoSisacaoECotacao) i1;
            	OpcaoSisacaoECotacao obj2 = (OpcaoSisacaoECotacao) i2;
                return (obj1.getNeg()<obj2.getNeg() ? 1 : -1);
            }
        });
		OpcaoSisacao saida = null;
		// Primeira tentativa
		for (OpcaoSisacaoECotacao op : listaCandidata) {
			System.out.println(op.getOpcao().getCodigoMercado() +  " : " + op.getUlt() + "  [" + op.getNeg() + "] em " + op.getDataHora());
			if (op.getUlt() >= 2 && op.getUlt() <= 3) {
				saida = op.getOpcao();
				break;
			}
		}
		if (saida==null) {
			// Segunda tentativa
			for (OpcaoSisacaoECotacao op : listaCandidata) {
				System.out.println(op.getOpcao().getCodigoMercado() +  " : " + op.getUlt() + "  [" + op.getNeg() + "] em " + op.getDataHora());
				if (op.getUlt() >= 1.5 && op.getUlt() <= 3) {
					saida = op.getOpcao();
					break;
				}
			}
		}
		if (saida==null) {
			// Terceira tentativa
			for (OpcaoSisacaoECotacao op : listaCandidata) {
				System.out.println(op.getOpcao().getCodigoMercado() +  " : " + op.getUlt() + "  [" + op.getNeg() + "] em " + op.getDataHora());
				if (op.getUlt() >= 1 && op.getUlt() <= 3) {
					saida = op.getOpcao();
					break;
				}
			}
		}
		if (saida==null && listaCandidata.size() > 0) {
			// Quarta tentativa
			saida = listaCandidata.get(0).getOpcao();
		}
		return saida;
	}
	
	
	@Override
	public List<OpcaoSisacao> ListaPorSerieTicker(DaoConexao conexao) throws DaoException {
		OpcaoSisacaoSerie serie = this.getFiltro().validaSeriePesquisa();
		Ticker ticker = this.getFiltro().validaTickerPesquisa();
		OpcaoSisacaoDao dao = getDao(conexao);
		return dao.ListaPorSerieTicker(serie.getIdObj(),ticker.getIdObj());
	}


	@Override
	public OpcaoSisacao ObtemPorCodigoMercadoAno(DaoConexao conexao) throws DaoException {
		String ticker = this.getFiltro().validaCodigoTicker();
		String data = this.getFiltro().validaData();
		OpcaoSisacaoDao dao = getDao();
		// AAAA-MM-DD
		// 0123456789
		String dataAno = DCConvert.ToDataAAAA_MM_DD(data).substring(0,4);
		dao.setConexao(conexao);
		OpcaoSisacao saida = dao.ObtemPorCodigoMercadoAno(ticker,dataAno);
		return saida;
	}


	@Override
	public OpcaoSisacao ObtemPorCodigoMercado(DaoConexao conexao) throws DaoException {
		throw new RuntimeException("Usar ObtemPorCodigoMercadoAno");
	}


	
	// Mesmo após a montagem das tabelas de 15 minutos, existam opções que apresentam 
	// Valores zerados. É preciso retirar tais opções da lista de disponíveis.
	@Override
	public OpcaoSisacao ExcluiOpcaoTickerAnoIntradayZerado(DaoConexao conexao) throws DaoException {
		
		OpcaoSisacaoSerieRegraColecao serieSrv = FabricaRegra.getInstancia().getOpcaoSisacaoSerieRegraColecao();
		OpcaoSisacaoRegraColecao opcaoSrv = FabricaRegra.getInstancia().getOpcaoSisacaoRegraColecao();
		TickerRegraColecao tickerSrv = FabricaRegra.getInstancia().getTickerRegraColecao();
		
		Ticker ticker = getFiltro().getTickerPesquisa();
		String codigoTicker = null;
		if (ticker==null) {
			codigoTicker = getFiltro().validaCodigoTicker();
			tickerSrv.getFiltro().setCodigoEmpresa(codigoTicker);
			ticker = tickerSrv.ObtemPorCodigo();
		}
		String data = this.getFiltro().validaData();
		// DD-MM-AAAA
		// 0123456789
		String ano = data.substring(6);
		for (int mes= 1 ; mes<=12; mes++) {
			String dataRef = "01-" + String.format("%02d", mes) + "-" + ano;
			// Obtendo a serie do mes
			this.getFiltro().setData(dataRef);
			this.getFiltro().setTickerPesquisa(ticker);
			List<OpcaoSisacao> listaOpcao = this.ListaPorTickerMesAno(conexao);
			for (OpcaoSisacao opcao : listaOpcao) {
				this.getFiltro().setItem(opcao);
				if (this.EhValidaNoPeriodo15(conexao)==null) {
					this.excluiItem(opcao);
				} else {
					System.out.println("Manteve " + opcao.getCodigoMercado());
				}
			}
		}
		return null;
	}


	@Override
	public List<OpcaoSisacao> ListaPorTickerMesAno(DaoConexao conexao) throws DaoException {
		String dataReg = this.getFiltro().validaData();
		Ticker ticker = this.getFiltro().getTickerPesquisa();
		if (ticker==null) {
			String codigoTicker = this.getFiltro().validaCodigoTicker();
			TickerRegraColecao tickerSrv = FabricaRegra.getInstancia().getTickerRegraColecao();
			tickerSrv.getFiltro().setCodigoEmpresa(codigoTicker);
			ticker = tickerSrv.ObtemPorCodigo(conexao);
		}
		OpcaoSisacaoDao dao = getDao(conexao);
		String dataBd = DCConvert.ToDataAAAA_MM_DD(dataReg);
		List<OpcaoSisacao> lista = dao.ListaPorTickerMesAno(ticker.getIdTicker(), dataBd);
		return lista;
	}


	@Override
	public OpcaoSisacao EhValidaNoPeriodo15(DaoConexao conexao) throws DaoException {
		OpcaoSisacaoSerieRegraColecao serieSrv = FabricaRegra.getInstancia().getOpcaoSisacaoSerieRegraColecao();
		OpcaoSisacaoSerie serie = serieSrv.obtemPorChave(this.getFiltro().getItem().getIdOpcaoSisacaoSeriePa());
		
		CotacaoProcessadaDao cotacaoDao = CotacaoProcessadaRegraColecao.getDao();
		cotacaoDao.setConexao(conexao);
		String dataFinal = DCConvert.ToDataAAAA_MM_DD(serie.getDataVencimento());
		String dataInicial = DCConvert.ToDataAAAA_MM_DD(serie.getDataInicioColeta());
		String nomeTicker = this.getFiltro().getItem().getCodigoMercado();
		int zeros = cotacaoDao.QuantidadeZerados(dataInicial, dataFinal, nomeTicker);
		
		return (zeros==0? FabricaVo.criaOpcaoSisacao(): null);
	}


	@Override
	public List<OpcaoSisacao> MelhoresVolumesDiaAnteriorPorTicker(DaoConexao conexao) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<OpcaoSisacao> ListaOrdenadaNegocioPorTickerData(DaoConexao conexao) throws DaoException {
		List<OpcaoSisacao> listaSaida = new ArrayList<OpcaoSisacao>();
		
		String nomeTicker = getFiltro().validaCodigoTicker();
		String dataRef = getFiltro().validaData();
		
		String ano = dataRef.substring(6);
		String dia = dataRef.substring(0,2);
		String mes = dataRef.substring(3,5);
		
		String nomeArquivoZip = "D:/CotacaoJava/download/" + ano + "/bdi" + mes + dia + ".zip";
		String nomeArquivo = "D:/CotacaoJava/download/Temp";
		

		try {
			TrataArquivos.unzipFiles(nomeArquivoZip, nomeArquivo);
			
			TickerRegraColecao tickerSrv = FabricaRegra.getInstancia().getTickerRegraColecao();
			tickerSrv.getFiltro().setCodigoEmpresa(nomeTicker);
			Ticker ticker = tickerSrv.ObtemPorCodigo();

			CotacaoDiarioRegraColecao cotacaoSrv = FabricaRegra.getInstancia().getCotacaoDiarioRegraColecao();
			cotacaoSrv.getFiltro().setTicker(ticker);

			List<CotacaoDiario> listaComNegocio = new ArrayList<CotacaoDiario>();
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
			for (CotacaoDiario cotacao : listaComNegocio) {
				this.getFiltro().setCodigoTicker(cotacao.getNomeTicker());
				this.getFiltro().setData(dataRef);
				OpcaoSisacao opcao = this.ObtemPorDataCodigoTicker();
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
		} catch (IOException e) {
			System.out.println("Erro Arquivo");
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public OpcaoSisacao ObtemPorDataCodigoTicker(DaoConexao conexao) throws DaoException {
		
		// Data da pesquisa
		String data = getFiltro().validaData();
		String ticker = getFiltro().validaCodigoTicker();
		try {
			OpcaoSisacaoDao dao = getDao(conexao);
			String dataFutura = UtilData.deslocaDias(data, 180);
			dataFutura = DCConvert.ToDataAAAA_MM_DD_HHMMSS(dataFutura);
			return dao.ObtemPorAnoCodigoTicker(dataFutura,ticker);
		} catch (Exception e) {
			return null;
		}
	}

	
}
