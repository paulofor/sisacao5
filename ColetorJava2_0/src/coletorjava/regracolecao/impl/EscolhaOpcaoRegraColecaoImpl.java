package coletorjava.regracolecao.impl;


import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JTextArea;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletorjava.dao.EscolhaOpcaoDao;
import coletorjava.modelo.Cotacao;
import coletorjava.modelo.CotacaoProcessada;
import coletorjava.modelo.DiaPregao;
import coletorjava.modelo.EscolhaOpcao;
import coletorjava.modelo.FabricaVo;
import coletorjava.modelo.MesAno;
import coletorjava.modelo.OpcaoSisacao;
import coletorjava.modelo.OpcaoSisacaoSerie;
import coletorjava.modelo.Ticker;
import coletorjava.regracolecao.CotacaoProcessadaRegraColecao;
import coletorjava.regracolecao.CotacaoRegraColecao;
import coletorjava.regracolecao.DiaPregaoRegraColecao;
import coletorjava.regracolecao.EscolhaOpcaoRegraColecao;
import coletorjava.regracolecao.FabricaRegra;
import coletorjava.regracolecao.MesAnoRegraColecao;
import coletorjava.regracolecao.OpcaoSisacaoRegraColecao;
import coletorjava.regracolecao.OpcaoSisacaoSerieRegraColecao;
import coletorjava.regracolecao.TickerRegraColecao;


public  class EscolhaOpcaoRegraColecaoImpl  extends EscolhaOpcaoRegraColecao { 
	
	private float INICIO_FAIXA1 = 0.8f;
	private float FINAL_FAIXA1 = 2.0f;
	
	private float INCIO_FAIXA2 = 2.0f;
	private float FINAL_FAIXA2 = 4.0f;
			
	
	public  List CriaPorNomeTickerAnoFaixa1( DaoConexao conexao )  throws  DaoException{
		CriaEscolhaOpcaoFaixaTh thread = new CriaEscolhaOpcaoFaixaTh((int) getFiltro().validaAno(),getFiltro().validaNomeTicker(),getFiltro().getTextArea(),1);
		thread.start();
		return null;
	}
	public  List CriaPorNomeTickerAnoFaixa2( DaoConexao conexao )  throws  DaoException{
		CriaEscolhaOpcaoFaixaTh thread = new CriaEscolhaOpcaoFaixaTh((int) getFiltro().validaAno(),getFiltro().validaNomeTicker(),getFiltro().getTextArea(),2);
		thread.start();
		return null;
	}
	
	class CriaEscolhaOpcaoFaixaTh extends Thread{
		private int ano = 0;
		private String ticker = null;
		private JTextArea saida = null;
		
		private List<MesAno> listaMeses = null;
		private Ticker tickerObj = null;
		
		private int codigoFaixa = 0;
		
		private OpcaoSisacaoSerieRegraColecao serieSrv = FabricaRegra.getInstancia().getOpcaoSisacaoSerieRegraColecao();
		private OpcaoSisacaoRegraColecao opcaoSrv = FabricaRegra.getInstancia().getOpcaoSisacaoRegraColecao();
		private CotacaoRegraColecao cotacaoIntraSrv = FabricaRegra.getInstancia().getCotacaoRegraColecao();
		private CotacaoProcessadaRegraColecao cotacaoSrv = FabricaRegra.getInstancia().getCotacaoProcessadaRegraColecao();
		private DiaPregaoRegraColecao diaPregaoSrv = FabricaRegra.getInstancia().getDiaPregaoRegraColecao();
		
		public CriaEscolhaOpcaoFaixaTh(int ano, String ticker, JTextArea texto, int codigoFaixa) {
			this.ano = ano;
			this.ticker = ticker;
			saida = texto;
			this.codigoFaixa = codigoFaixa;
		}
		
		public void run() {
			saida.setText("");
			saida.append("inicializando..." + '\n');
			BuilderOpcaoCotacao builder = new BuilderOpcaoCotacao();
			EscolhaOpcao escolha = FabricaVo.criaEscolhaOpcao();
			try {
				carregaListaMeses();
				carregaTicker();
				opcaoSrv.getFiltro().setTickerPesquisa(tickerObj);
				escolha.setTickerReferenteA(tickerObj);
				for (MesAno mes : listaMeses) {
					diaPregaoSrv.getFiltro().setDataMesAno(mes.getMesAnoData());
					List<DiaPregao> listaDia = diaPregaoSrv.ListaPorDataMesAno();
					builder.inicializa();
					saida.append("tratando " + mes.getNomeMes() + "\n");
					cotacaoSrv.getFiltro().setDataPesquisa(ajustaData(mes.getMesAnoData()));
					cotacaoIntraSrv.getFiltro().setDataPesquisa(ajustaData(mes.getMesAnoData()));
					serieSrv.getFiltro().setMesAnoEstudo(mes);
					OpcaoSisacaoSerie serie = serieSrv.ObtemPorMesAnoEstudo();
					saida.append("serie: " + serie.getLetra() + "\n");
					opcaoSrv.getFiltro().setSeriePesquisa(serie);
					List<OpcaoSisacao> listaOpcao = opcaoSrv.ListaPorSerieTicker();
					CotacaoEOpcao co = null;
					for (OpcaoSisacao opcao : listaOpcao) {
						cotacaoSrv.getFiltro().setDataPesquisa(ajustaData(mes.getMesAnoData()));
						cotacaoIntraSrv.getFiltro().setDataPesquisa(ajustaData(mes.getMesAnoData()));
						co = null;
						cotacaoSrv.getFiltro().setNomeTicker(opcao.getCodigoMercado());
						cotacaoIntraSrv.getFiltro().setNomeTicker(opcao.getCodigoMercado());
						List<CotacaoProcessada> listaCotacao = cotacaoSrv.AnteriorDataPesquisaQuantidadeOpcao();
						Cotacao cotacaoIntra = cotacaoIntraSrv.AnteriorDataPesquisaQuantidadeOpcao();
						saida.append(opcao.getCodigoMercado() + " em " + ajustaData(mes.getMesAnoData()) + " (" + opcao.getPrecoExercicioFormatada() + ") : ");
						if (listaCotacao!=null) {
							try {
								co = new CotacaoEOpcao(listaCotacao.get(0),opcao);	
								saida.append(listaCotacao.get(0).getValorFormatada());
							} catch (Exception e) {
								
							}
						} 
						if (cotacaoIntra!=null) {
							co.setCotacao(cotacaoIntra);
							saida.append(" - " + cotacaoIntra.getUltFormatada());
						}
						builder.setOpcaoCotacao(co);
						colocaDataFinalMes(saida,mes.getMesAnoData());
						saida.append("\n");
					}
					if (codigoFaixa==1)
						escolha.setOpcaoSisacaoEscolha(builder.getEscolhidaFaixa1());
					if (codigoFaixa==2)
						escolha.setOpcaoSisacaoEscolha(builder.getEscolhidaFaixa2());
					escolha.setFaixaEscolha(codigoFaixa);
					getFiltro().setItemAtualizacao(escolha);
					getFiltro().setListaDiaPregao(listaDia);
					Atualiza();
					if (codigoFaixa==1)
						saida.append("Escolhida(1) -> " + builder.getEscolhidaFaixa1().getCodigoMercado() + "\n");
					if (codigoFaixa==2)
						saida.append("Escolhida(2) -> " + builder.getEscolhidaFaixa2().getCodigoMercado() + "\n");
				}
			} catch (Exception e) {
				saida.append("Erro: " + e.getMessage() + "\n");
				e.printStackTrace();
			}
		}
		
		private void colocaDataFinalMes(JTextArea saida, String data) throws DaoException {
			cotacaoSrv.getFiltro().setDataPesquisa(this.dataFinalMes(data));
			List<CotacaoProcessada> listaCotacao = cotacaoSrv.AnteriorDataPesquisaQuantidadeOpcao();
			if (listaCotacao!=null && listaCotacao.size()> 0 && listaCotacao.get(0)!=null) {
				saida.append(" ( final mes: " + listaCotacao.get(0).getValorFormatada() + " )");
			}
		}
		
		private String ajustaData(String data) {
			// DD-MM-AAAA
			// 0123456789
			String saida = "05" + data.substring(2);
			return saida;
		}
		private String dataFinalMes(String data) {
			String saida = "30" + data.substring(2);
			return saida;
		}
		
		private void carregaListaMeses() throws DaoException {
			saida.append("carregando meses...\n");
			MesAnoRegraColecao mesAnoSrv = FabricaRegra.getInstancia().getMesAnoRegraColecao();
			mesAnoSrv.getFiltro().setAnoPesquisa(ano);
			listaMeses = mesAnoSrv.ListaPorAno();
			if (listaMeses==null) {
				saida.append("listaMeses = null (ano=" + ano + ")\n");
			} else {
				saida.append("lista de meses..." + listaMeses.size() + " posições.\n");
			}
		}
		private void carregaTicker() throws DaoException {
			saida.append("carregando ticker...\n");
			TickerRegraColecao tickerSrv = FabricaRegra.getInstancia().getTickerRegraColecao();
			tickerSrv.getFiltro().setCodigoEmpresa(ticker);
			tickerObj = tickerSrv.ObtemPorCodigo();
			if (tickerObj!=null) {
				saida.append("Ticker ID = " + tickerObj.getIdObj() + "\n");
			} else {
				saida.append("Ticker " + ticker + " não encontrado.\n");
			}
		}

	}
	
	private class BuilderOpcaoCotacao {
		
		private List<CotacaoEOpcao> lista = new LinkedList<CotacaoEOpcao>();
		private CotacaoEOpcao escolhida = null;
		
		public void inicializa() {
			escolhida = null;
			lista.clear();
		}
		
		public void setOpcaoCotacao(CotacaoEOpcao dado) {
			lista.add(dado);
		}
		public OpcaoSisacao getEscolhidaFaixa1() {
			if (escolhida==null) {
				processaFaixa1();
			}
			return escolhida.getOpcao();
		}
		
		private void processaFaixa1() {
			ordenaLista();
			CotacaoEOpcao possivel = null;
			for (CotacaoEOpcao corrente : lista) {
				if (corrente!=null) {
					if (escolhida==null && corrente.getValor()>=1.19) {
						if (corrente.possuiIntra()) {
							escolhida = corrente;
						} else {
							if (possivel==null) {
								possivel = corrente;
							}
						}
					}
				}
			}
			if (escolhida==null && possivel!=null)
				escolhida = possivel;
		}
		public OpcaoSisacao getEscolhidaFaixa2() {
			if (escolhida==null) {
				processaFaixa2();
			}
			return escolhida.getOpcao();
		}
		
		private void processaFaixa2() {
			ordenaLista();
			CotacaoEOpcao possivel = null;
			for (CotacaoEOpcao corrente : lista) {
				if (corrente!=null) {
					System.out.println(corrente.getOpcao().getCodigoMercado() + ": " + corrente.getValor());
					if (escolhida==null && corrente.getValor()>=3.19) {
						if (corrente.possuiIntra()) {
							escolhida = corrente;
						} else {
							if (possivel==null) {
								possivel = corrente;
							}
						}
					}
				}
			}
			if (escolhida==null && possivel!=null)
				escolhida = possivel;
		}
		
		private void ordenaLista() {
			Collections.sort(lista, new Comparator() {
            @Override
			public int compare(Object i1, Object i2) {
            	if ((i1==null) || (i2==null)) return 0;
            	return (((CotacaoEOpcao) i2).getValor() < ((CotacaoEOpcao) i1).getValor()) ? 1 : -1;
			}
			});

		}
	}
	
	private class CotacaoEOpcao {
		private CotacaoProcessada cotacao = null;
		private OpcaoSisacao opcao = null;
		private Cotacao cotacaoIntra;
		
		public CotacaoEOpcao(CotacaoProcessada val1, OpcaoSisacao val2) {
			cotacao = val1;
			opcao = val2;
		}
		public void setCotacao(Cotacao val) {
			cotacaoIntra = val;
		}
		public OpcaoSisacao getOpcao() {
			return opcao;
		}
		public float getValor() {
			if (cotacao==null) {
				System.out.println(opcao.getCodigoMercado() + " sem cotacao");
				return 0;
			}
			return cotacao.getValor();
		}
		public boolean possuiIntra() {
			return (cotacaoIntra!=null);
		}
	}

	@Override
	public EscolhaOpcao Atualiza(DaoConexao conexao) throws DaoException {
		EscolhaOpcao item = this.getFiltro().validaItemAtualizacao();
		List listaDiaPregao = this.getFiltro().validaListaDiaPregao();
		if (item.getTickerReferenteA(false)==null) throw new RuntimeException("Ticker não pode ser nulo.");
		if (item.getOpcaoSisacaoEscolha(false)==null) throw new RuntimeException("Opcao nao pode ser nulo");
		EscolhaOpcaoDao dao = getDao(conexao);
		for (Object obj : listaDiaPregao) {
			DiaPregao dia = (DiaPregao) obj;
			if (!dia.getFeriado()) {
				EscolhaOpcao itemDao = dao.obtemPorTickerDia(item.getTickerReferenteA(false).getIdObj(),dia.getIdObj());
				if (itemDao==null) {
					item.setIdDiaPregaoRa(dia.getIdObj());
					dao.insereItem(item);
				} else {
					if (itemDao.getIdOpcaoSisacaoE()!=item.getIdOpcaoSisacaoE()) {
						itemDao.setIdOpcaoSisacaoE(item.getOpcaoSisacaoEscolha(false).getIdObj());
						dao.alteraItem(itemDao);
					} else {
						itemDao = null;
					}
				}
			}
		}
		return null;
	}
	@Override
	public EscolhaOpcao ObtemPorIdTickerDiaComOpcao(DaoConexao conexao) throws DaoException {
		EscolhaOpcaoDao dao = getDao(conexao);
		return dao.ObtemPorIdTickerDiaComOpcao(getFiltro().getCodigoTickerReferenteA(),getFiltro().getCodigoDiaPregaoReferenteA());
	}
	
}
