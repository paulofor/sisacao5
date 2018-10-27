package coletorjava.dao;

import  coletorjava.dao.*;

// versao templates

public  class DBB   {


	private static DBB _instancia =  null;
	public static DBB getInstancia() {
		if (_instancia==null) _instancia = new DBB();
		return _instancia;
	}
	public DBB() {
	
		_OpcaoSisacaoGeralDao = null;
	
		_TickerDao = null;
	
		_CotacaoDao = null;
	
		_CotacaoDiarioDao = null;
	
		_OpcaoSisacaoSerieDao = null;
	
		_OpcaoSisacaoDao = null;
	
		_CotacaoProcessadaDao = null;
	
		_DiaPregaoDao = null;
	
		_PeriodoPregaoDao = null;
	
		_UsuarioDao = null;
	
		_DispositivoUsuarioDao = null;
	
		_ExperimentoOpcaoCurtoPrazoDao = null;
	
		_CotacaoProcessadaOpcaoResultadoDao = null;
	
		_RegraEntradaDao = null;
	
		_MesAnoDao = null;
	
		_EscolhaOpcaoDao = null;
	
		_RedeDao = null;
	
		_TreinoRedeDao = null;
	
		_DadoThetaDao = null;
	
		_ProjetoDadoTreinoDao = null;
	
		_DadoTreinoDao = null;
	
		_ResultadoMesDao = null;
	
		_ResultadoPrevisaoDao = null;
	
		_OpcaoReferenciaDao = null;
	
	}


	private  OpcaoSisacaoGeralDao _OpcaoSisacaoGeralDao;
	public  OpcaoSisacaoGeralDao getOpcaoSisacaoGeralDao() {
		if (_OpcaoSisacaoGeralDao==null) _OpcaoSisacaoGeralDao = new OpcaoSisacaoGeralDaoExtendida();
		return _OpcaoSisacaoGeralDao;
	}

	private  TickerDao _TickerDao;
	public  TickerDao getTickerDao() {
		if (_TickerDao==null) _TickerDao = new TickerDaoExtendida();
		return _TickerDao;
	}

	private  CotacaoDao _CotacaoDao;
	public  CotacaoDao getCotacaoDao() {
		if (_CotacaoDao==null) _CotacaoDao = new CotacaoDaoExtendida();
		return _CotacaoDao;
	}

	private  CotacaoDiarioDao _CotacaoDiarioDao;
	public  CotacaoDiarioDao getCotacaoDiarioDao() {
		if (_CotacaoDiarioDao==null) _CotacaoDiarioDao = new CotacaoDiarioDaoExtendida();
		return _CotacaoDiarioDao;
	}

	private  OpcaoSisacaoSerieDao _OpcaoSisacaoSerieDao;
	public  OpcaoSisacaoSerieDao getOpcaoSisacaoSerieDao() {
		if (_OpcaoSisacaoSerieDao==null) _OpcaoSisacaoSerieDao = new OpcaoSisacaoSerieDaoExtendida();
		return _OpcaoSisacaoSerieDao;
	}

	private  OpcaoSisacaoDao _OpcaoSisacaoDao;
	public  OpcaoSisacaoDao getOpcaoSisacaoDao() {
		if (_OpcaoSisacaoDao==null) _OpcaoSisacaoDao = new OpcaoSisacaoDaoExtendida();
		return _OpcaoSisacaoDao;
	}

	private  CotacaoProcessadaDao _CotacaoProcessadaDao;
	public  CotacaoProcessadaDao getCotacaoProcessadaDao() {
		if (_CotacaoProcessadaDao==null) _CotacaoProcessadaDao = new CotacaoProcessadaDaoExtendida();
		return _CotacaoProcessadaDao;
	}

	private  DiaPregaoDao _DiaPregaoDao;
	public  DiaPregaoDao getDiaPregaoDao() {
		if (_DiaPregaoDao==null) _DiaPregaoDao = new DiaPregaoDaoExtendida();
		return _DiaPregaoDao;
	}

	private  PeriodoPregaoDao _PeriodoPregaoDao;
	public  PeriodoPregaoDao getPeriodoPregaoDao() {
		if (_PeriodoPregaoDao==null) _PeriodoPregaoDao = new PeriodoPregaoDaoExtendida();
		return _PeriodoPregaoDao;
	}

	private  UsuarioDao _UsuarioDao;
	public  UsuarioDao getUsuarioDao() {
		if (_UsuarioDao==null) _UsuarioDao = new UsuarioDaoExtendida();
		return _UsuarioDao;
	}

	private  DispositivoUsuarioDao _DispositivoUsuarioDao;
	public  DispositivoUsuarioDao getDispositivoUsuarioDao() {
		if (_DispositivoUsuarioDao==null) _DispositivoUsuarioDao = new DispositivoUsuarioDaoExtendida();
		return _DispositivoUsuarioDao;
	}

	private  ExperimentoOpcaoCurtoPrazoDao _ExperimentoOpcaoCurtoPrazoDao;
	public  ExperimentoOpcaoCurtoPrazoDao getExperimentoOpcaoCurtoPrazoDao() {
		if (_ExperimentoOpcaoCurtoPrazoDao==null) _ExperimentoOpcaoCurtoPrazoDao = new ExperimentoOpcaoCurtoPrazoDaoExtendida();
		return _ExperimentoOpcaoCurtoPrazoDao;
	}

	private  CotacaoProcessadaOpcaoResultadoDao _CotacaoProcessadaOpcaoResultadoDao;
	public  CotacaoProcessadaOpcaoResultadoDao getCotacaoProcessadaOpcaoResultadoDao() {
		if (_CotacaoProcessadaOpcaoResultadoDao==null) _CotacaoProcessadaOpcaoResultadoDao = new CotacaoProcessadaOpcaoResultadoDaoExtendida();
		return _CotacaoProcessadaOpcaoResultadoDao;
	}

	private  RegraEntradaDao _RegraEntradaDao;
	public  RegraEntradaDao getRegraEntradaDao() {
		if (_RegraEntradaDao==null) _RegraEntradaDao = new RegraEntradaDaoExtendida();
		return _RegraEntradaDao;
	}

	private  MesAnoDao _MesAnoDao;
	public  MesAnoDao getMesAnoDao() {
		if (_MesAnoDao==null) _MesAnoDao = new MesAnoDaoExtendida();
		return _MesAnoDao;
	}

	private  EscolhaOpcaoDao _EscolhaOpcaoDao;
	public  EscolhaOpcaoDao getEscolhaOpcaoDao() {
		if (_EscolhaOpcaoDao==null) _EscolhaOpcaoDao = new EscolhaOpcaoDaoExtendida();
		return _EscolhaOpcaoDao;
	}

	private  RedeDao _RedeDao;
	public  RedeDao getRedeDao() {
		if (_RedeDao==null) _RedeDao = new RedeDaoExtendida();
		return _RedeDao;
	}

	private  TreinoRedeDao _TreinoRedeDao;
	public  TreinoRedeDao getTreinoRedeDao() {
		if (_TreinoRedeDao==null) _TreinoRedeDao = new TreinoRedeDaoExtendida();
		return _TreinoRedeDao;
	}

	private  DadoThetaDao _DadoThetaDao;
	public  DadoThetaDao getDadoThetaDao() {
		if (_DadoThetaDao==null) _DadoThetaDao = new DadoThetaDaoExtendida();
		return _DadoThetaDao;
	}

	private  ProjetoDadoTreinoDao _ProjetoDadoTreinoDao;
	public  ProjetoDadoTreinoDao getProjetoDadoTreinoDao() {
		if (_ProjetoDadoTreinoDao==null) _ProjetoDadoTreinoDao = new ProjetoDadoTreinoDaoExtendida();
		return _ProjetoDadoTreinoDao;
	}

	private  DadoTreinoDao _DadoTreinoDao;
	public  DadoTreinoDao getDadoTreinoDao() {
		if (_DadoTreinoDao==null) _DadoTreinoDao = new DadoTreinoDaoExtendida();
		return _DadoTreinoDao;
	}

	private  ResultadoMesDao _ResultadoMesDao;
	public  ResultadoMesDao getResultadoMesDao() {
		if (_ResultadoMesDao==null) _ResultadoMesDao = new ResultadoMesDaoExtendida();
		return _ResultadoMesDao;
	}

	private  ResultadoPrevisaoDao _ResultadoPrevisaoDao;
	public  ResultadoPrevisaoDao getResultadoPrevisaoDao() {
		if (_ResultadoPrevisaoDao==null) _ResultadoPrevisaoDao = new ResultadoPrevisaoDaoExtendida();
		return _ResultadoPrevisaoDao;
	}

	private  OpcaoReferenciaDao _OpcaoReferenciaDao;
	public  OpcaoReferenciaDao getOpcaoReferenciaDao() {
		if (_OpcaoReferenciaDao==null) _OpcaoReferenciaDao = new OpcaoReferenciaDaoExtendida();
		return _OpcaoReferenciaDao;
	}

}