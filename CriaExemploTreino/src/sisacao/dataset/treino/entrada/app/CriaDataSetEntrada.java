package sisacao.dataset.treino.entrada.app;

import java.util.List;

import br.com.digicom.sisacao.modelo.CotacaoIntradayAcaoResultado;
import br.com.digicom.sisacao.modelo.DiaPregao;
import br.inf.digicom.loopback.DaoBase;
import sisacao.dataset.treino.dao.DaoBaseApp;
import sisacao.dataset.treino.dao.DatasetComum;
import sisacao.dataset.treino.entrada.dao.DatasetExemploEntrada;
import sisacao.dataset.treino.proc.DadosTreino;
import sisacao.dataset.treino.proc.EnviaDados;

public class CriaDataSetEntrada extends DaoBaseApp {

	private List<DiaPregao> dias = null;
	private String ticker = null;
	private DadosTreinoX dadosTreino = null;
	private EnviaDados enviaDados = null;
	
	@Override
	protected void executaImpl() {

		DatasetExemploEntrada comum = (DatasetExemploEntrada) getComum();
		this.dias = comum.getListaCotacaoResultado();
		this.ticker = comum.getAtivoAcaoCorrente().getTicker();
		this.dadosTreino = new DadosTreinoX();
		this.dadosTreino.setQtdeDia(comum.getQtdeDia());
		this.enviaDados = new EnviaDados();
		processaDias();
		System.out.println(" !!!!  final de execução !!!!");
	}
	
	
	private void processaDias() {
		DatasetExemploEntrada comum = (DatasetExemploEntrada) getComum();
		int diaReferencia = 0;
		CotacaoIntradayAcaoResultado cotacaoDiaAnterior = null;
		DiaPregao diaOperacao = ;
		try {
			
			
				
		} catch (Exception e) {
			System.out.println("Ticker: " + this.ticker);
			System.out.println("this.procuraPontoSaida:" + this.procuraPontoSaida);
			System.out.println("diaReferencia:" + diaReferencia);
			System.out.println("valorEntrada:" + valorEntrada);
			System.out.println("cotacaoDiaAnterior:" + cotacaoDiaAnterior);
			System.out.println("Dia Operação:" + diaOperacao.getDiaNum());
			for (CotacaoIntradayAcaoResultado cot: diaOperacao.getCotacaoIntradayAcaoResultados()) {
				System.out.println(cot);
			}
			e.printStackTrace();
			System.exit(-1);
		}
		
	}

	@Override
	protected DaoBase getProximo() {
		// TODO Auto-generated method stub
		return null;
	}

}
