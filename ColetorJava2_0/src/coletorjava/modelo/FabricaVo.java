package coletorjava.modelo;

import  coletorjava.modelo.vo.*;

// versao templates

public  class FabricaVo   {
	public static OpcaoSisacaoGeral criaOpcaoSisacaoGeral()  {
          return new OpcaoSisacaoGeralVo();
	}
	public static Ticker criaTicker()  {
          return new TickerVo();
	}
	public static Cotacao criaCotacao()  {
          return new CotacaoVo();
	}
	public static CotacaoDiario criaCotacaoDiario()  {
          return new CotacaoDiarioVo();
	}
	public static OpcaoSisacaoSerie criaOpcaoSisacaoSerie()  {
          return new OpcaoSisacaoSerieVo();
	}
	public static OpcaoSisacao criaOpcaoSisacao()  {
          return new OpcaoSisacaoVo();
	}
	public static CotacaoProcessada criaCotacaoProcessada()  {
          return new CotacaoProcessadaVo();
	}
	public static DiaPregao criaDiaPregao()  {
          return new DiaPregaoVo();
	}
	public static PeriodoPregao criaPeriodoPregao()  {
          return new PeriodoPregaoVo();
	}
	public static Usuario criaUsuario()  {
          return new UsuarioVo();
	}
	public static DispositivoUsuario criaDispositivoUsuario()  {
          return new DispositivoUsuarioVo();
	}
	public static ExperimentoOpcaoCurtoPrazo criaExperimentoOpcaoCurtoPrazo()  {
          return new ExperimentoOpcaoCurtoPrazoVo();
	}
	public static CotacaoProcessadaOpcaoResultado criaCotacaoProcessadaOpcaoResultado()  {
          return new CotacaoProcessadaOpcaoResultadoVo();
	}
	public static RegraEntrada criaRegraEntrada()  {
          return new RegraEntradaVo();
	}
	public static MesAno criaMesAno()  {
          return new MesAnoVo();
	}
	public static EscolhaOpcao criaEscolhaOpcao()  {
          return new EscolhaOpcaoVo();
	}
	public static Rede criaRede()  {
          return new RedeVo();
	}
	public static TreinoRede criaTreinoRede()  {
          return new TreinoRedeVo();
	}
	public static DadoTheta criaDadoTheta()  {
          return new DadoThetaVo();
	}
	public static ProjetoDadoTreino criaProjetoDadoTreino()  {
          return new ProjetoDadoTreinoVo();
	}
	public static DadoTreino criaDadoTreino()  {
          return new DadoTreinoVo();
	}
	public static ResultadoMes criaResultadoMes()  {
          return new ResultadoMesVo();
	}
	public static ResultadoPrevisao criaResultadoPrevisao()  {
          return new ResultadoPrevisaoVo();
	}
	public static OpcaoReferencia criaOpcaoReferencia()  {
          return new OpcaoReferenciaVo();
	}

}