package coletorjava.regracolecao.custom.calcprocessadas;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import coletorjava.modelo.Cotacao;
import coletorjava.modelo.CotacaoDiario;
import coletorjava.modelo.CotacaoProcessada;
import coletorjava.modelo.DiaPregao;
import coletorjava.modelo.FabricaVo;
import coletorjava.modelo.PeriodoPregao;
import coletorjava.modelo.Ticker;
import coletorjava.regracolecao.CotacaoDiarioRegraColecao;
import coletorjava.regracolecao.DiaPregaoRegraColecao;
import coletorjava.regracolecao.FabricaRegra;

public class MontadorPontos {

	private int intervalo = 15; // 15 minutos
	private int intervaloFinal = 20;
	private List listaPontos;
	
	private CotacaoDiarioRegraColecao cotacaoDiarioSrv = FabricaRegra.getInstancia().getCotacaoDiarioRegraColecao();
	private DiaPregaoRegraColecao diaPregaoSrv = FabricaRegra.getInstancia().getDiaPregaoRegraColecao();
	
	/*
	private DiaPregaoWSSoap diaPregaoWs = null;
	private DiaPregaoWSLocator diaPregaoLoc = null;
	private CotacaoDiarioWSSoap cotacaoDiarioWs = null;
	private CotacaoDiarioWSLocator cotacaoDiarioLoc = null;
	
	private CotacaoDiarioWSSoap getCotacaoDiarioWS() throws ServiceException{
		if (cotacaoDiarioWs==null) {
			cotacaoDiarioLoc = new CotacaoDiarioWSLocator();
			cotacaoDiarioWs = cotacaoDiarioLoc.getCotacaoDiarioWSSoap();
		}
		return cotacaoDiarioWs;
	}
	private DiaPregaoWSSoap getDiaPregaoWS() throws ServiceException{
		if (diaPregaoWs==null) {
			diaPregaoLoc = new DiaPregaoWSLocator();
			diaPregaoWs = diaPregaoLoc.getDiaPregaoWSSoap();
		}
		return diaPregaoWs;
	}

	public CotacaoProcessadaObjetoWs[] cotacaoDia(String data) {
		CotacaoProcessadaObjetoWs[] lista = null;
		try {
		    CotacaoProcessadaWSLocator locator = new CotacaoProcessadaWSLocator();
		    CotacaoProcessadaWSSoap ws = locator.getCotacaoProcessadaWSSoap();
		    converteserie.ws.CotacaoProcessadaFiltro filtroWS = new converteserie.ws.CotacaoProcessadaFiltro();
		    filtroWS.setDataPregao(data);
		    lista = ws.listaSemResultado(filtroWS);
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException r) {
			r.printStackTrace();
		}
		return lista;
	}
	*/
	
	
	
	
	public List<CotacaoProcessada> montaCotacaoProcessada(String dia, PeriodoPregao periodo, List cotacoesDia, String ticker)
		throws DaoException{
		List listaTempos = tempos(periodo.getHoraInicio(),periodo.getHoraTermino(),intervalo);
		
		
		
		listaPontos = new LinkedList();
		if (cotacoesDia.size()==1) {
			//processaDia1Cotacao(listaTempos,(Cotacao)cotacoesDia.iterator().next(), dia);
			System.out.println(" ***  DIA COM UMA COTACAO :" + dia + " *** ");
		} else {
			if (cotacoesDia.isEmpty()) {
				//processaDia0Cotacao(listaTempos,cotacoesDia, dia);
				System.out.println(" ***  DIA SEM COTACOES :" + dia + " *** ");
				((CotacaoProcessada)listaTempos.get(0)).setData(dia);
				corrigeZeros(listaTempos, ticker);
				preencheOutrosCampos(listaTempos, dia);
			} else {
				System.out.println("Corrigindo dia " + dia);
				processaDia(listaTempos,cotacoesDia, dia);
				Iterator itTempos = listaTempos.iterator();
				while (itTempos.hasNext()) {
					CotacaoProcessada cotProc = (CotacaoProcessada) itTempos.next();
					System.out.println(cotProc.getHoraSerieTemporal() + ":" + cotProc.getValor());
				}
				corrigeZeros(listaTempos, ticker);
			}
		}
		return listaTempos;
	}
	
	private void preencheOutrosCampos(List listaTempos, String dia) {
		Iterator<CotacaoProcessada> it = listaTempos.iterator();
		CotacaoProcessada cot = null;
		while (it.hasNext()) {
			cot = it.next();
			cot.setHoraCotacao(cot.getHoraSerieTemporal());
			cot.setHoraCotacaoTempoReal(cot.getHoraSerieTemporal());
			cot.setValorCorrigido(cot.getValor());
			cot.setValorTempoReal(cot.getValor());
			cot.setData(dia);
		}
	}

	
	/*
	private void processaDia1Cotacao(ArrayList tempos, Cotacao cotacaoDia, DiaPregao dia) {
		FabricaRegra.getInstancia().getDiaPregaoRegraColecao().getFiltro().setQuantidadeDeslocada(1);
		FabricaRegra.getInstancia().getDiaPregaoRegraColecao().getFiltro().setDiaReferencia(dia);
		DiaPregao diaProximo = FabricaRegra.getInstancia().getDiaPregaoRegraColecao().DeslocaDias();
		
		FabricaRegra.getInstancia().getDiaPregaoRegraColecao().getFiltro().setQuantidadeDeslocada(-1);
		FabricaRegra.getInstancia().getDiaPregaoRegraColecao().getFiltro().setDiaReferencia(dia);
		DiaPregao diaAnterior = FabricaRegra.getInstancia().getDiaPregaoRegraColecao().DeslocaDias();
		
		FabricaRegra.getInstancia().getCotacaoRegraColecao().getFiltro().setDia(diaAnterior);
		Collection cotacoesDiaAnterior = FabricaRegra.getInstancia().getCotacaoRegraColecao().ListaOrdenadaPorDia();
		Iterator iterador = cotacoesDiaAnterior.iterator();
		
		Cotacao cotacaoUltimaAnterior = null;
		while (iterador.hasNext()) {
			cotacaoUltimaAnterior = (Cotacao) iterador.next();
		}
		if (cotacaoUltimaAnterior==null) {
			cotacaoUltimaAnterior = new Cotacao();
			CotacaoProcessada cotProc = (CotacaoProcessada) ((LinkedList)listaPontos).get(listaPontos.size()-1);
			cotacaoUltimaAnterior.setUlt(cotProc.getValor());
		}
		
		float passo = (cotacaoDia.getUlt() - cotacaoUltimaAnterior.getUlt()) / tempos.size();
		float valorCorrente = cotacaoUltimaAnterior.getUlt();
		
		for (int i=0;i<tempos.size();i++) {
			String tempoAtual = (String) tempos.get(i);
			valorCorrente += passo;
			CotacaoProcessada cotacaoProcessada = new CotacaoProcessada();
			cotacaoProcessada.setData(cotacaoDia.getData());
			cotacaoProcessada.setHoraCotacao(cotacaoDia.getHoraNeg());
			cotacaoProcessada.setHoraSerieTemporal(tempoAtual);
			cotacaoProcessada.setNegocios(cotacaoDia.getNeg());
			cotacaoProcessada.setValor(valorCorrente);
			cotacaoProcessada.setContador(i+1);
			listaPontos.add(cotacaoProcessada);
		}
	}
	*/
	
	/*
	private void processaDia0Cotacao(ArrayList tempos, Collection cotacoesDia, DiaPregao dia) {
		
		DiaPregaoObjetoWs diaProximo = this.obtemProximo(dia.getData());
		DiaPregaoObjetoWs diaAnterior = this.obtemAnterior(dia.getData());
		
		CotacaoProcessadaObjetoWs[] cotacoesDiaAnterior = this.cotacaoDia(diaAnterior.getData());
		CotacaoProcessadaObjetoWs cotacaoUltimaAnterior = cotacoesDiaAnterior[cotacoesDiaAnterior.length-1];
		
		if (cotacaoUltimaAnterior==null) {
			cotacaoUltimaAnterior = new Cotacao();
			CotacaoProcessada cotProc = (CotacaoProcessada) ((LinkedList)listaPontos).get(listaPontos.size()-1);
			cotacaoUltimaAnterior.setUlt(cotProc.getValor());
		}
		
		FabricaRegra.getInstancia().getCotacaoRegraColecao().getFiltro().setDia(diaProximo);
		Collection cotacoesDiaProximo = FabricaRegra.getInstancia().getCotacaoRegraColecao().ListaOrdenadaPorDia();
		Cotacao cotacaoPrimeiraProxima = null;
		if (!cotacoesDiaProximo.isEmpty())
			cotacaoPrimeiraProxima = (Cotacao) cotacoesDiaProximo.iterator().next();
	
		int dias = 1;
		while (cotacaoPrimeiraProxima==null) {
			FabricaRegra.getInstancia().getDiaPregaoRegraColecao().getFiltro().setDiaReferencia(diaProximo);
			FabricaRegra.getInstancia().getDiaPregaoRegraColecao().getFiltro().setQuantidadeDeslocada(1);
			diaProximo = FabricaRegra.getInstancia().getDiaPregaoRegraColecao().DeslocaDias();
			dias++;
			FabricaRegra.getInstancia().getCotacaoRegraColecao().getFiltro().setDia(diaProximo);
			cotacoesDiaProximo = FabricaRegra.getInstancia().getCotacaoRegraColecao().ListaOrdenadaPorDia();
			if (!cotacoesDiaProximo.isEmpty())
				cotacaoPrimeiraProxima = (Cotacao) cotacoesDiaProximo.iterator().next();
		}
		
		float passo = (cotacaoPrimeiraProxima.getUlt() - cotacaoUltimaAnterior.getUlt()) / (tempos.size()*dias) ;
		float valorCorrente = cotacaoUltimaAnterior.getUlt();
		
		for (int i=0;i<tempos.size();i++) {
			String tempoAtual = (String) tempos.get(i);
			valorCorrente += passo;
			CotacaoProcessada cotacaoProcessada = new CotacaoProcessada();
			cotacaoProcessada.setData(dia.getData());
			cotacaoProcessada.setHoraCotacao("00:00:00");
			cotacaoProcessada.setHoraSerieTemporal(tempoAtual);
			cotacaoProcessada.setNegocios(0);
			cotacaoProcessada.setValor(valorCorrente);
			cotacaoProcessada.setContador(i+1);
			listaPontos.add(cotacaoProcessada);
		}
	}
	*/
	
	
	private void corrigeZeros(List listaCotacaoProcessada, String ticker) throws  DaoException {
		if (ticker.length()>5) {
			corrigeZerosOpcao(listaCotacaoProcessada, ticker);
		} else {
			corrigeZerosAcao(listaCotacaoProcessada, ticker);
		}
	}
	
	private void corrigeZerosOpcao(List listaCotacaoProcessada, String ticker) throws DaoException{
		Iterator it = listaCotacaoProcessada.iterator();
		boolean possuiZeros = false;
		while (it.hasNext()) {
			CotacaoProcessada cot = (CotacaoProcessada) it.next();
			if (cot.getValor()==0) {
				possuiZeros = true;
				break;
			}
		}
		if (!possuiZeros) return;
		CotacaoProcessada cot = (CotacaoProcessada) listaCotacaoProcessada.get(0);
		String dataAtual = cot.getData();

		DiaPregao diaPosterior = this.obtemProximo(dataAtual);
		//CotacaoDiarioOpcaoDaoExtendida daoDiarioOpcao = new CotacaoDiarioOpcaoDaoExtendida();
		//DaoConexao conexao = daoDiarioOpcao.criaConexao();
		//daoDiarioOpcao.setConexao(conexao);
		//CotacaoDiarioOpcao cotDiaOp = daoDiarioOpcao.obtemPorOpcaoData(ticker, dataAtual);
		
		cotacaoDiarioSrv.getFiltro().setData(dataAtual);
		Ticker tickerObj = FabricaVo.criaTicker();
		tickerObj.setNome(ticker);
		cotacaoDiarioSrv.getFiltro().setTicker(tickerObj);
		CotacaoDiario cotDiaOp = cotacaoDiarioSrv.ObtemPorNomeTickerData();
		if (cotDiaOp==null) {
			System.out.println("Dados diarios de " + ticker + " na data " + dataAtual + " nao encontrada, cotacao 15 minutos vai ficar com valores 0");
			return;
		}
		//CotacaoDiarioFiltro filtro = new CotacaoDiarioFiltro();
		//filtro.setNomeTicker(dataAtual);
		//filtro.setData(dataAtual);
		//CotacaoDiarioObjetoWs cotDia = this.getCotacaoDiarioWS().obtemCotacaoDia(filtro);
		//if (cotDia==null) {
		//	System.out.println("Dados diarios de " + dataAtual + " nao encontrada, corrigir com CotacaJava2 CorrigeDiaApp");
		//}
		float valorAnterior = (cotDiaOp.getAberturaCorrigido()>0?cotDiaOp.getAberturaCorrigido():cotDiaOp.getAberturaOriginal());
		System.out.println("Abertura:" + valorAnterior);
		int posIni = 0, posFim = 0;
		boolean intervalo = false;
		for (int cont=0;cont<listaCotacaoProcessada.size();cont++) {
			CotacaoProcessada cotacao = (CotacaoProcessada) listaCotacaoProcessada.get(cont);
			if (cotacao.getValor()==0) {
				if (!intervalo) {
					intervalo = true;
					posIni = cont;
				} else {
					
				}
			} else {
				if (!intervalo) {
					valorAnterior = cotacao.getValor();
					intervalo = false;
				} else {
					calculaIntervalo(listaCotacaoProcessada,posIni,cont-1,valorAnterior,cotacao.getValor());
					intervalo = false;
				}
			}
		}
		if (intervalo) {
			CotacaoProcessada cota = (CotacaoProcessada) listaCotacaoProcessada.get(listaCotacaoProcessada.size()-1);
			cota.setValor(cotDiaOp.getFechamentoCorrigido());
			calculaIntervalo(listaCotacaoProcessada,posIni,(listaCotacaoProcessada.size()-2),valorAnterior,cotDiaOp.getFechamentoCorrigido());
		}
	}
	
	
	private void corrigeZerosAcao(List listaCotacaoProcessada, String ticker) throws DaoException{
		Iterator it = listaCotacaoProcessada.iterator();
		boolean possuiZeros = false;
		while (it.hasNext()) {
			CotacaoProcessada cot = (CotacaoProcessada) it.next();
			if (cot.getValor()==0) {
				possuiZeros = true;
				break;
			}
		}
		if (!possuiZeros) return;
		CotacaoProcessada cot = (CotacaoProcessada) listaCotacaoProcessada.get(0);
		String dataAtual = cot.getData();
		DiaPregao diaPosterior = this.obtemProximo(dataAtual);
		//CotacaoDiarioFiltro filtro = new CotacaoDiarioFiltro();
		//filtro.setNomeTicker(ticker);
		//filtro.setData(dataAtual);
		//CotacaoDiarioObjetoWs cotDia = this.getCotacaoDiarioWS().obtemCotacaoDia(filtro);
		
		cotacaoDiarioSrv.getFiltro().setData(dataAtual);
		Ticker tickerObj = FabricaVo.criaTicker();
		tickerObj.setNome(ticker);
		cotacaoDiarioSrv.getFiltro().setTicker(tickerObj);
		CotacaoDiario cotDia = cotacaoDiarioSrv.ObtemPorNomeTickerData();
		
		
		if (cotDia==null) {
			System.out.println("Dados diarios de " + dataAtual + " nao encontrada, corrigir com CotacaJava2 CorrigeDiaApp");
		}
		float valorAnterior = cotDia.getAberturaCorrigido();
		System.out.println("Abertura:" + valorAnterior);
		int posIni = 0, posFim = 0;
		boolean intervalo = false;
		for (int cont=0;cont<listaCotacaoProcessada.size();cont++) {
			CotacaoProcessada cotacao = (CotacaoProcessada) listaCotacaoProcessada.get(cont);
			if (cotacao.getValor()==0) {
				if (!intervalo) {
					intervalo = true;
					posIni = cont;
				} else {
					
				}
			} else {
				if (!intervalo) {
					valorAnterior = cotacao.getValor();
					intervalo = false;
				} else {
					calculaIntervalo(listaCotacaoProcessada,posIni,cont-1,valorAnterior,cotacao.getValor());
					intervalo = false;
				}
			}
		}
		if (intervalo) {
			CotacaoProcessada cota = (CotacaoProcessada) listaCotacaoProcessada.get(listaCotacaoProcessada.size()-1);
			cota.setValor(cotDia.getFechamentoCorrigido());
			calculaIntervalo(listaCotacaoProcessada,posIni,(listaCotacaoProcessada.size()-2),valorAnterior,cotDia.getFechamentoCorrigido());
		}
	}
	
	private void calculaIntervalo(List listaCotacaoProcessada, int posIni, int posFinal, float valAnterior, float valPosterior)  {
		// posIni e posFinal = primeira e última posição sem valor
		// valAnterior = valor antes da primeira
		// valPosterior = valor apos a final
		float diferenca = valPosterior - valAnterior;
		int total = posFinal - posIni + 2;
		float passo = diferenca / total;
		for (int cont=posIni;cont<=posFinal;cont++) {
			float novoValor = valAnterior + passo;
			((CotacaoProcessada)listaCotacaoProcessada.get(cont)).setValor(novoValor);
			valAnterior = novoValor;
		}
		
		
	}
	
	
	private void processaDia(List listaCotacaoProcessada, List listaCotacaoBruta, String dia) {
		int posicaoBruta = 0;
		Cotacao brutaAnterior = null;
		CotacaoProcessada processadaCorrente = null;
		Cotacao brutaCorrente = null;
		brutaCorrente = (Cotacao) listaCotacaoBruta.get(posicaoBruta++);
		boolean girouBruta;
		for (int posicaoProcessada=0;posicaoProcessada<listaCotacaoProcessada.size()-1;posicaoProcessada++) {
			processadaCorrente = (CotacaoProcessada)listaCotacaoProcessada.get(posicaoProcessada);
			// enquanto a hora bruta esta inferior a hora processada corrente fique no loop
			girouBruta = false;
			//System.out.println("Hora corrente:" + processadaCorrente.getHoraSerieTemporal() + "(" + posicaoProcessada + ")");
			while (posicaoBruta<listaCotacaoBruta.size() && processadaCorrente.getHoraSerieTemporal().compareTo(brutaCorrente.getHoraReal()+":00")>=0) {
				girouBruta = true;
				brutaCorrente = (Cotacao) listaCotacaoBruta.get(posicaoBruta++);
			}
			// Atualiza processada
			processadaCorrente.setData(dia);
			if (girouBruta){
				brutaAnterior = (Cotacao) listaCotacaoBruta.get(posicaoBruta-2);
				processadaCorrente.setValor(brutaAnterior.getUlt());
				processadaCorrente.setHoraCotacaoTempoReal(brutaAnterior.getHoraReal());
				processadaCorrente.setHoraCotacao(brutaAnterior.getHoraNeg());
			} else {
				if ((posicaoProcessada==28 || posicaoProcessada==29) && brutaAnterior!=null) {
					float valor = brutaAnterior.getUlt();
					processadaCorrente.setValor(valor);
					processadaCorrente.setHoraCotacaoTempoReal(brutaAnterior.getHoraReal());
					processadaCorrente.setHoraCotacao(brutaAnterior.getHoraNeg());
				}
				else {
					processadaCorrente.setValor(0);
					processadaCorrente.setHoraCotacaoTempoReal(processadaCorrente.getHoraSerieTemporal());
					processadaCorrente.setHoraCotacao(processadaCorrente.getHoraSerieTemporal());
				}
			}
		}
		// Atualiza última
		processadaCorrente = (CotacaoProcessada) listaCotacaoProcessada.get(listaCotacaoProcessada.size()-1);
		processadaCorrente.setData(dia);
		brutaAnterior = (Cotacao) listaCotacaoBruta.get(listaCotacaoBruta.size()-1);
		processadaCorrente.setValor(brutaAnterior.getUlt());
		processadaCorrente.setHoraCotacaoTempoReal(brutaAnterior.getHoraReal());
		processadaCorrente.setHoraCotacao(brutaAnterior.getHoraNeg());
	}
	
	
	/*
	 * the value 0 if the argument string is equal to this string; 
	 * a value less than 0 if this string is lexicographically less than the string argument; 
	 * and a value greater than 0 if this string is lexicographically greater than the string argument.
	 */
	private void processaDiaOld(List tempos,Collection cotacoesDia, String dia) {
		Cotacao cotacaoCorrente = null;
		Cotacao cotacaoAnterior = null;
		//Collection saida = new ArrayList();
		boolean periodoAberto = true;
		Iterator itCotacoes = cotacoesDia.iterator();
		Iterator itTempos = tempos.iterator();
		cotacaoCorrente = (Cotacao) itCotacoes.next();
		long contador=0;
		while (itTempos.hasNext()) {
			periodoAberto = true;
			String periodoCorrente = (String) itTempos.next();
			if (periodoCorrente.compareTo(cotacaoCorrente.getHoraReal())<0)  {
			} else {
				processaItem(cotacaoCorrente);
				//cotacaoAnterior = cotacaoCorrente;
			}
			while (itCotacoes.hasNext() && periodoAberto) {
				cotacaoCorrente = (Cotacao) itCotacoes.next();
				if (periodoCorrente.compareTo(cotacaoCorrente.getHoraReal())<0) {
					periodoAberto = false;
					adicionaItem(periodoCorrente,++contador, dia);
					//saida.add(cotacaoAnterior);
				} else {
					processaItem(cotacaoCorrente);
					//cotacaoAnterior = cotacaoCorrente;
				}
			}
			if (periodoAberto) {
				adicionaItem(periodoCorrente, ++contador, dia);
			}
		}
		//return saida;
	}
	private Cotacao cotacaoAnterior = null;
	private void processaItem(Cotacao cotacao) {
		cotacaoAnterior = cotacao;
	}
	private void adicionaItem(String periodoCorrente, long posicao, String dia) {
		
		CotacaoProcessada cotacaoProcessada = FabricaVo.criaCotacaoProcessada();
		cotacaoProcessada.setData(dia);
		cotacaoProcessada.setHoraCotacao(cotacaoAnterior.getHoraReal());
		cotacaoProcessada.setHoraSerieTemporal(periodoCorrente);
		boolean mesmaData = (cotacaoAnterior.getData().compareTo(dia)==0);
		cotacaoProcessada.setNegocios(mesmaData?cotacaoAnterior.getNeg():0);
		cotacaoProcessada.setValor(cotacaoAnterior.getUlt());
		cotacaoProcessada.setContadorDia(posicao);
		listaPontos.add(cotacaoProcessada);
	}
	public DiaPregao obtemProximo(String dataAtual) throws DaoException {
		diaPregaoSrv.getFiltro().setDataDeslocamento(dataAtual);
		diaPregaoSrv.getFiltro().setDiasDeslocamento(1);
		return diaPregaoSrv.DeslocaDias();
	}
	public DiaPregao obtemAnterior(String dataAtual) throws DaoException {
		diaPregaoSrv.getFiltro().setDataDeslocamento(dataAtual);
		diaPregaoSrv.getFiltro().setDiasDeslocamento(-1);
		return diaPregaoSrv.DeslocaDias();
	}
	
	public ArrayList tempos(String horarioInicial, String horarioFinal, int intervaloTempo) {
		ArrayList tempoSaida = new ArrayList();
		Calendar dataCorrente = converteStringParaData(horarioInicial);
		Calendar dataFinal = converteStringParaData(horarioFinal);
		CotacaoProcessada cotProc = null;
		long cont = 1;
		dataFinal.add(Calendar.MINUTE, 1);
		while (dataCorrente.before(dataFinal)) {
			cotProc = FabricaVo.criaCotacaoProcessada();
			cotProc.setContadorDia(cont++);
			cotProc.setHoraSerieTemporal(converteDataParaString(dataCorrente));
			tempoSaida.add(cotProc);
			dataCorrente.add(Calendar.MINUTE, intervaloTempo);
		}
		dataCorrente.add(Calendar.MINUTE, -intervaloTempo); // retorna anterior
		dataCorrente.add(Calendar.MINUTE, this.intervaloFinal); // soma intervalo final
		cotProc = FabricaVo.criaCotacaoProcessada();
		cotProc.setContadorDia(cont++);
		cotProc.setHoraSerieTemporal(converteDataParaString(dataCorrente));
		tempoSaida.add(cotProc);
		return tempoSaida;
	}
	private Calendar converteStringParaData(String horario) {
		Calendar data = Calendar.getInstance();
		int hora = Integer.parseInt(horario.substring(0, 2));
		int minuto = Integer.parseInt(horario.substring(3,5));
		data.set(0,0,0,hora,minuto);
		return data;
	}
	private String converteDataParaString(Calendar data) {
		String horaStr = ""  + data.get(Calendar.HOUR_OF_DAY);
		String minutoStr = "" + data.get(Calendar.MINUTE);
		if (horaStr.length()<2) horaStr = "0" + horaStr;
		if (minutoStr.length()<2) minutoStr = "0" + minutoStr;
		return horaStr + ":" + minutoStr + ":00";
	}
}
