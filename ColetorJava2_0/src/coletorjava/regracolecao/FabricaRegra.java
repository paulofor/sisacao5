package coletorjava.regracolecao;


import coletorjava.regracolecao.impl.CotacaoDiarioRegraColecaoImpl;
import coletorjava.regracolecao.impl.CotacaoProcessadaOpcaoResultadoRegraColecaoImpl;
import coletorjava.regracolecao.impl.CotacaoProcessadaRegraColecaoImpl;
import coletorjava.regracolecao.impl.CotacaoRegraColecaoImpl;
import coletorjava.regracolecao.impl.DadoThetaRegraColecaoImpl;
import coletorjava.regracolecao.impl.DadoTreinoRegraColecaoImpl;
import coletorjava.regracolecao.impl.DiaPregaoRegraColecaoImpl;
import coletorjava.regracolecao.impl.DispositivoUsuarioRegraColecaoImpl;
import coletorjava.regracolecao.impl.EscolhaOpcaoRegraColecaoImpl;
import coletorjava.regracolecao.impl.ExperimentoOpcaoCurtoPrazoRegraColecaoImpl;
import coletorjava.regracolecao.impl.MesAnoRegraColecaoImpl;
import coletorjava.regracolecao.impl.OpcaoReferenciaRegraColecaoImpl;
import coletorjava.regracolecao.impl.OpcaoSisacaoGeralRegraColecaoImpl;
import coletorjava.regracolecao.impl.OpcaoSisacaoRegraColecaoImpl;
import coletorjava.regracolecao.impl.OpcaoSisacaoSerieRegraColecaoImpl;
import coletorjava.regracolecao.impl.PeriodoPregaoRegraColecaoImpl;
import coletorjava.regracolecao.impl.ProjetoDadoTreinoRegraColecaoImpl;
import coletorjava.regracolecao.impl.RedeRegraColecaoImpl;
import coletorjava.regracolecao.impl.RegraEntradaRegraColecaoImpl;
import coletorjava.regracolecao.impl.ResultadoMesRegraColecaoImpl;
import coletorjava.regracolecao.impl.ResultadoPrevisaoRegraColecaoImpl;
import coletorjava.regracolecao.impl.TickerRegraColecaoImpl;
import coletorjava.regracolecao.impl.TreinoRedeRegraColecaoImpl;
import coletorjava.regracolecao.impl.UsuarioRegraColecaoImpl;

// versao templates

public  class FabricaRegra  implements FabricaRegraI{

	private static FabricaRegra _instancia =  null;
	public static FabricaRegra getInstancia() {
		if (_instancia==null) _instancia = new FabricaRegra();
		return _instancia;
	}

	private  OpcaoSisacaoGeralRegraColecao _opcaoSisacaoGeralRegraColecao;
	public  OpcaoSisacaoGeralRegraColecao getOpcaoSisacaoGeralRegraColecao() {
		if (_opcaoSisacaoGeralRegraColecao==null) _opcaoSisacaoGeralRegraColecao = new OpcaoSisacaoGeralRegraColecaoImpl();
		return _opcaoSisacaoGeralRegraColecao;
	}
	private  TickerRegraColecao _tickerRegraColecao;
	public  TickerRegraColecao getTickerRegraColecao() {
		if (_tickerRegraColecao==null) _tickerRegraColecao = new TickerRegraColecaoImpl();
		return _tickerRegraColecao;
	}
	private  CotacaoRegraColecao _cotacaoRegraColecao;
	public  CotacaoRegraColecao getCotacaoRegraColecao() {
		if (_cotacaoRegraColecao==null) _cotacaoRegraColecao = new CotacaoRegraColecaoImpl();
		return _cotacaoRegraColecao;
	}
	private  CotacaoDiarioRegraColecao _cotacaoDiarioRegraColecao;
	public  CotacaoDiarioRegraColecao getCotacaoDiarioRegraColecao() {
		if (_cotacaoDiarioRegraColecao==null) _cotacaoDiarioRegraColecao = new CotacaoDiarioRegraColecaoImpl();
		return _cotacaoDiarioRegraColecao;
	}
	private  OpcaoSisacaoSerieRegraColecao _opcaoSisacaoSerieRegraColecao;
	public  OpcaoSisacaoSerieRegraColecao getOpcaoSisacaoSerieRegraColecao() {
		if (_opcaoSisacaoSerieRegraColecao==null) _opcaoSisacaoSerieRegraColecao = new OpcaoSisacaoSerieRegraColecaoImpl();
		return _opcaoSisacaoSerieRegraColecao;
	}
	private  OpcaoSisacaoRegraColecao _opcaoSisacaoRegraColecao;
	public  OpcaoSisacaoRegraColecao getOpcaoSisacaoRegraColecao() {
		if (_opcaoSisacaoRegraColecao==null) _opcaoSisacaoRegraColecao = new OpcaoSisacaoRegraColecaoImpl();
		return _opcaoSisacaoRegraColecao;
	}
	private  CotacaoProcessadaRegraColecao _cotacaoProcessadaRegraColecao;
	public  CotacaoProcessadaRegraColecao getCotacaoProcessadaRegraColecao() {
		if (_cotacaoProcessadaRegraColecao==null) _cotacaoProcessadaRegraColecao = new CotacaoProcessadaRegraColecaoImpl();
		return _cotacaoProcessadaRegraColecao;
	}
	private  DiaPregaoRegraColecao _diaPregaoRegraColecao;
	public  DiaPregaoRegraColecao getDiaPregaoRegraColecao() {
		if (_diaPregaoRegraColecao==null) _diaPregaoRegraColecao = new DiaPregaoRegraColecaoImpl();
		return _diaPregaoRegraColecao;
	}
	private  PeriodoPregaoRegraColecao _periodoPregaoRegraColecao;
	public  PeriodoPregaoRegraColecao getPeriodoPregaoRegraColecao() {
		if (_periodoPregaoRegraColecao==null) _periodoPregaoRegraColecao = new PeriodoPregaoRegraColecaoImpl();
		return _periodoPregaoRegraColecao;
	}
	private  UsuarioRegraColecao _usuarioRegraColecao;
	public  UsuarioRegraColecao getUsuarioRegraColecao() {
		if (_usuarioRegraColecao==null) _usuarioRegraColecao = new UsuarioRegraColecaoImpl();
		return _usuarioRegraColecao;
	}
	private  DispositivoUsuarioRegraColecao _dispositivoUsuarioRegraColecao;
	public  DispositivoUsuarioRegraColecao getDispositivoUsuarioRegraColecao() {
		if (_dispositivoUsuarioRegraColecao==null) _dispositivoUsuarioRegraColecao = new DispositivoUsuarioRegraColecaoImpl();
		return _dispositivoUsuarioRegraColecao;
	}
	private  ExperimentoOpcaoCurtoPrazoRegraColecao _experimentoOpcaoCurtoPrazoRegraColecao;
	public  ExperimentoOpcaoCurtoPrazoRegraColecao getExperimentoOpcaoCurtoPrazoRegraColecao() {
		if (_experimentoOpcaoCurtoPrazoRegraColecao==null) _experimentoOpcaoCurtoPrazoRegraColecao = new ExperimentoOpcaoCurtoPrazoRegraColecaoImpl();
		return _experimentoOpcaoCurtoPrazoRegraColecao;
	}
	private  CotacaoProcessadaOpcaoResultadoRegraColecao _cotacaoProcessadaOpcaoResultadoRegraColecao;
	public  CotacaoProcessadaOpcaoResultadoRegraColecao getCotacaoProcessadaOpcaoResultadoRegraColecao() {
		if (_cotacaoProcessadaOpcaoResultadoRegraColecao==null) _cotacaoProcessadaOpcaoResultadoRegraColecao = new CotacaoProcessadaOpcaoResultadoRegraColecaoImpl();
		return _cotacaoProcessadaOpcaoResultadoRegraColecao;
	}
	private  RegraEntradaRegraColecao _regraEntradaRegraColecao;
	public  RegraEntradaRegraColecao getRegraEntradaRegraColecao() {
		if (_regraEntradaRegraColecao==null) _regraEntradaRegraColecao = new RegraEntradaRegraColecaoImpl();
		return _regraEntradaRegraColecao;
	}
	private  MesAnoRegraColecao _mesAnoRegraColecao;
	public  MesAnoRegraColecao getMesAnoRegraColecao() {
		if (_mesAnoRegraColecao==null) _mesAnoRegraColecao = new MesAnoRegraColecaoImpl();
		return _mesAnoRegraColecao;
	}
	private  EscolhaOpcaoRegraColecao _escolhaOpcaoRegraColecao;
	public  EscolhaOpcaoRegraColecao getEscolhaOpcaoRegraColecao() {
		if (_escolhaOpcaoRegraColecao==null) _escolhaOpcaoRegraColecao = new EscolhaOpcaoRegraColecaoImpl();
		return _escolhaOpcaoRegraColecao;
	}
	private  RedeRegraColecao _redeRegraColecao;
	public  RedeRegraColecao getRedeRegraColecao() {
		if (_redeRegraColecao==null) _redeRegraColecao = new RedeRegraColecaoImpl();
		return _redeRegraColecao;
	}
	private  TreinoRedeRegraColecao _treinoRedeRegraColecao;
	public  TreinoRedeRegraColecao getTreinoRedeRegraColecao() {
		if (_treinoRedeRegraColecao==null) _treinoRedeRegraColecao = new TreinoRedeRegraColecaoImpl();
		return _treinoRedeRegraColecao;
	}
	private  DadoThetaRegraColecao _dadoThetaRegraColecao;
	public  DadoThetaRegraColecao getDadoThetaRegraColecao() {
		if (_dadoThetaRegraColecao==null) _dadoThetaRegraColecao = new DadoThetaRegraColecaoImpl();
		return _dadoThetaRegraColecao;
	}
	private  ProjetoDadoTreinoRegraColecao _projetoDadoTreinoRegraColecao;
	public  ProjetoDadoTreinoRegraColecao getProjetoDadoTreinoRegraColecao() {
		if (_projetoDadoTreinoRegraColecao==null) _projetoDadoTreinoRegraColecao = new ProjetoDadoTreinoRegraColecaoImpl();
		return _projetoDadoTreinoRegraColecao;
	}
	private  DadoTreinoRegraColecao _dadoTreinoRegraColecao;
	public  DadoTreinoRegraColecao getDadoTreinoRegraColecao() {
		if (_dadoTreinoRegraColecao==null) _dadoTreinoRegraColecao = new DadoTreinoRegraColecaoImpl();
		return _dadoTreinoRegraColecao;
	}
	private  ResultadoMesRegraColecao _resultadoMesRegraColecao;
	public  ResultadoMesRegraColecao getResultadoMesRegraColecao() {
		if (_resultadoMesRegraColecao==null) _resultadoMesRegraColecao = new ResultadoMesRegraColecaoImpl();
		return _resultadoMesRegraColecao;
	}
	private  ResultadoPrevisaoRegraColecao _resultadoPrevisaoRegraColecao;
	public  ResultadoPrevisaoRegraColecao getResultadoPrevisaoRegraColecao() {
		if (_resultadoPrevisaoRegraColecao==null) _resultadoPrevisaoRegraColecao = new ResultadoPrevisaoRegraColecaoImpl();
		return _resultadoPrevisaoRegraColecao;
	}
	private  OpcaoReferenciaRegraColecao _opcaoReferenciaRegraColecao;
	public  OpcaoReferenciaRegraColecao getOpcaoReferenciaRegraColecao() {
		if (_opcaoReferenciaRegraColecao==null) _opcaoReferenciaRegraColecao = new OpcaoReferenciaRegraColecaoImpl();
		return _opcaoReferenciaRegraColecao;
	}

}