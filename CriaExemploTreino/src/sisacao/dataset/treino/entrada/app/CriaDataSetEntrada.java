package sisacao.dataset.treino.entrada.app;

import java.util.List;

import br.com.digicom.sisacao.modelo.CotacaoIntradayAcaoResultado;
import br.com.digicom.sisacao.modelo.DiaPregao;
import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.DummyDaoBase;
import sisacao.dataset.treino.dao.DaoBaseApp;
import sisacao.dataset.treino.dao.DatasetExemplo;

public class CriaDataSetEntrada extends DaoBaseApp {

	private List<DiaPregao> dias = null;
	private String ticker = null;
	private DadosTreinoX dadosTreino = new DadosTreinoX();;
	private EnviaDadosX enviaDados = new EnviaDadosX();;
	private DummyDaoBase dummy = null;
	
	public CriaDataSetEntrada() {
		super();
		this.dummy = new DummyDaoBase();
	}
	
	@Override
	protected void executaImpl() {

		DatasetExemplo comum = (DatasetExemplo) getComum();
		this.dias = comum.getListaCotacaoResultado();
		this.ticker = comum.getAtivoAcaoCorrente().getTicker();
		this.dadosTreino.setQtdeDia(comum.getQtdeDia());
		processaDias();
		System.out.println(" !!!!  final de execução !!!!");
		this.executaProximo();
	}
	
	
	private void processaDias() {
		DatasetExemplo comum = (DatasetExemplo) getComum();
		
		CotacaoIntradayAcaoResultado cotacaoDiaReferencia = null;
		DiaPregao diaPrevisao = null; 
		DiaPregao diaReferencia = null; 
		int indiceDia = 0;
		try {
			diaPrevisao = dias.get(dias.size()-1);
			diaReferencia = dias.get(dias.size()-2);
			indiceDia = dias.get(0).getCotacaoIntradayAcaoResultados().size() + comum.getPosicaoDia() - 1;
			cotacaoDiaReferencia = diaReferencia.getCotacaoIntradayAcaoResultados().get(indiceDia);
			
			dadosTreino.calcula(dias, cotacaoDiaReferencia.getValor());
			enviaDados.enviaDia(comum.getAtivoAcaoCorrente().getTicker(), dadosTreino, cotacaoDiaReferencia.getValor(), comum.getQtdeDia(), comum.getPosicaoDia());

				
		} catch (Exception e) {
			System.out.println("Ticker: " + this.ticker);
			System.out.println("Indice Referencia: " + indiceDia);
			System.out.println("Data Previsao:" + diaPrevisao.getDiaNum());
			System.out.println("cotacaoDiaAnterior:" + cotacaoDiaReferencia);
			System.out.println("Data Referencia:" + diaReferencia.getDiaNum());
			int i = 0;
			for (CotacaoIntradayAcaoResultado cot: diaReferencia.getCotacaoIntradayAcaoResultados()) {
				System.out.println((i++) + " " +cot);
			}
			e.printStackTrace();
			System.exit(-1);
		}
		
	}

	@Override
	protected DaoBase getProximo() {
		return dummy;
	}

}
