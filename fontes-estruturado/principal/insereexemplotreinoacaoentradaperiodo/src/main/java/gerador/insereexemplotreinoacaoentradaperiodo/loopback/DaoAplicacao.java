package gerador.insereexemplotreinoacaoentradaperiodo.loopback;


import com.strongloop.android.loopback.RestAdapter;

import br.com.gersis.daobase.DaoBase;
import br.com.gersis.daobase.IDatasetComum;
import br.com.gersis.daobase.comum.DaoBaseComum;
import br.com.gersis.loopback.repositorio.*;

public abstract class DaoAplicacao extends DaoBase {

	private RestAdapter adapter = new RestAdapter(DaoBaseComum.urlLoopback);
	protected RepositorioAluguelFundoImobiliario repAluguelFundoImobiliario = adapter.createRepository(RepositorioAluguelFundoImobiliario.class);
	protected RepositorioAplicacaoInstituicao repAplicacaoInstituicao = adapter.createRepository(RepositorioAplicacaoInstituicao.class);
	protected RepositorioInstituicaoFinanceira repInstituicaoFinanceira = adapter.createRepository(RepositorioInstituicaoFinanceira.class);
	protected RepositorioTreinoRede repTreinoRede = adapter.createRepository(RepositorioTreinoRede.class);
	protected RepositorioPrevisaoTeste repPrevisaoTeste = adapter.createRepository(RepositorioPrevisaoTeste.class);
	protected RepositorioDiaPregao repDiaPregao = adapter.createRepository(RepositorioDiaPregao.class);
	protected RepositorioPreRedeNeural repPreRedeNeural = adapter.createRepository(RepositorioPreRedeNeural.class);
	protected RepositorioTipoExemploTreino repTipoExemploTreino = adapter.createRepository(RepositorioTipoExemploTreino.class);
	protected RepositorioRegraProjecao repRegraProjecao = adapter.createRepository(RepositorioRegraProjecao.class);
	protected RepositorioPeriodoTreinoRede repPeriodoTreinoRede = adapter.createRepository(RepositorioPeriodoTreinoRede.class);
	protected RepositorioVersaoPreRede repVersaoPreRede = adapter.createRepository(RepositorioVersaoPreRede.class);
	protected RepositorioVersaoPreRedeRegra repVersaoPreRedeRegra = adapter.createRepository(RepositorioVersaoPreRedeRegra.class);
	protected RepositorioExemploTreinoAcaoSaida repExemploTreinoAcaoSaida = adapter.createRepository(RepositorioExemploTreinoAcaoSaida.class);
	protected RepositorioRegraProjecaoReversao repRegraProjecaoReversao = adapter.createRepository(RepositorioRegraProjecaoReversao.class);
	protected RepositorioGrupoAcao repGrupoAcao = adapter.createRepository(RepositorioGrupoAcao.class);
	protected RepositorioAmostraDadoSintetico repAmostraDadoSintetico = adapter.createRepository(RepositorioAmostraDadoSintetico.class);
	protected RepositorioExemploDadoSintetico repExemploDadoSintetico = adapter.createRepository(RepositorioExemploDadoSintetico.class);
	protected RepositorioExperimentoPreRede repExperimentoPreRede = adapter.createRepository(RepositorioExperimentoPreRede.class);
	protected RepositorioFechamentoRegraDia repFechamentoRegraDia = adapter.createRepository(RepositorioFechamentoRegraDia.class);
	protected RepositorioFechamentoRegraDiaQuantidade repFechamentoRegraDiaQuantidade = adapter.createRepository(RepositorioFechamentoRegraDiaQuantidade.class);
	protected RepositorioFechamentoPontoSaida repFechamentoPontoSaida = adapter.createRepository(RepositorioFechamentoPontoSaida.class);
	protected RepositorioCotacaoIntradayAcaoResultado repCotacaoIntradayAcaoResultado = adapter.createRepository(RepositorioCotacaoIntradayAcaoResultado.class);
	protected RepositorioAtivoAcao repAtivoAcao = adapter.createRepository(RepositorioAtivoAcao.class);
	protected RepositorioExperimentoPreRedeTreinada repExperimentoPreRedeTreinada = adapter.createRepository(RepositorioExperimentoPreRedeTreinada.class);
	protected RepositorioExemploTreinoAcaoEntrada repExemploTreinoAcaoEntrada = adapter.createRepository(RepositorioExemploTreinoAcaoEntrada.class);
	protected RepositorioExperimentoPreRedeTreinadaScore repExperimentoPreRedeTreinadaScore = adapter.createRepository(RepositorioExperimentoPreRedeTreinadaScore.class);
	protected RepositorioCotacaoIntradayAcao repCotacaoIntradayAcao = adapter.createRepository(RepositorioCotacaoIntradayAcao.class);
	protected RepositorioCotacaoDiarioAcao repCotacaoDiarioAcao = adapter.createRepository(RepositorioCotacaoDiarioAcao.class);
	protected RepositorioPrevisaoRede repPrevisaoRede = adapter.createRepository(RepositorioPrevisaoRede.class);
	protected RepositorioExperimentoPreRedeTreinadaControle repExperimentoPreRedeTreinadaControle = adapter.createRepository(RepositorioExperimentoPreRedeTreinadaControle.class);
	protected RepositorioAtivoAcaoUsa repAtivoAcaoUsa = adapter.createRepository(RepositorioAtivoAcaoUsa.class);
	protected RepositorioCotacaoDiarioAcaoUsa repCotacaoDiarioAcaoUsa = adapter.createRepository(RepositorioCotacaoDiarioAcaoUsa.class);
	protected RepositorioRedeNeural repRedeNeural = adapter.createRepository(RepositorioRedeNeural.class);
	protected RepositorioGrupoRegra repGrupoRegra = adapter.createRepository(RepositorioGrupoRegra.class);
	protected RepositorioGrupoRegraRel repGrupoRegraRel = adapter.createRepository(RepositorioGrupoRegraRel.class);
	protected RepositorioCotacaoIntradayAcaoResultadoValor repCotacaoIntradayAcaoResultadoValor = adapter.createRepository(RepositorioCotacaoIntradayAcaoResultadoValor.class);
	protected RepositorioTreinoGrupoRede repTreinoGrupoRede = adapter.createRepository(RepositorioTreinoGrupoRede.class);
	protected RepositorioCotacaoIntradayCoinmarketcap repCotacaoIntradayCoinmarketcap = adapter.createRepository(RepositorioCotacaoIntradayCoinmarketcap.class);
	protected RepositorioExperimentoPreRedeResultado repExperimentoPreRedeResultado = adapter.createRepository(RepositorioExperimentoPreRedeResultado.class);
	protected RepositorioExemploDadoSinteticoTeste repExemploDadoSinteticoTeste = adapter.createRepository(RepositorioExemploDadoSinteticoTeste.class);
	protected RepositorioGrupoRede repGrupoRede = adapter.createRepository(RepositorioGrupoRede.class);
	protected RepositorioGrupoRedeRel repGrupoRedeRel = adapter.createRepository(RepositorioGrupoRedeRel.class);
	protected RepositorioExemploTreinoIndiceAcaoEntrada repExemploTreinoIndiceAcaoEntrada = adapter.createRepository(RepositorioExemploTreinoIndiceAcaoEntrada.class);
	protected RepositorioCotacaoIntradayIndice repCotacaoIntradayIndice = adapter.createRepository(RepositorioCotacaoIntradayIndice.class);
	protected RepositorioCotacaoIntradayIndiceResultado repCotacaoIntradayIndiceResultado = adapter.createRepository(RepositorioCotacaoIntradayIndiceResultado.class);
	protected RepositorioCotacaoIntradayCoinmarketcapIndice repCotacaoIntradayCoinmarketcapIndice = adapter.createRepository(RepositorioCotacaoIntradayCoinmarketcapIndice.class);
	protected RepositorioIndiceAcao repIndiceAcao = adapter.createRepository(RepositorioIndiceAcao.class);
	protected RepositorioRegraProjecaoHists repRegraProjecaoHists = adapter.createRepository(RepositorioRegraProjecaoHists.class);


	@Override
	protected long getTempo() {
		return 10000;
	}

	@Override
	protected IDatasetComum criaDataSet() {
		return new DatasetAplicacao();
	}

	@Override
	protected DaoBase getProximo() {
		return null;
	} 

}
