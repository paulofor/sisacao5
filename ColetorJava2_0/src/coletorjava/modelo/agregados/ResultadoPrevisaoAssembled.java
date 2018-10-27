package coletorjava.modelo.agregados;


import coletorjava.modelo.agregados.*;
import coletorjava.modelo.*;


public  class ResultadoPrevisaoAssembled   implements ResultadoPrevisaoAssembledI { 
  private DadoTheta _DadoThetaGeradoDe;
	public DadoTheta getDadoThetaGeradoDe() {
		return _DadoThetaGeradoDe;
	}
	public void setDadoThetaGeradoDe( DadoTheta dado ) {
		_DadoThetaGeradoDe = dado;
	}
  private ResultadoMes _ResultadoMesMesmoPeriodo;
	public ResultadoMes getResultadoMesMesmoPeriodo() {
		return _ResultadoMesMesmoPeriodo;
	}
	public void setResultadoMesMesmoPeriodo( ResultadoMes dado ) {
		_ResultadoMesMesmoPeriodo = dado;
	}
  private MesAno _MesAnoReferenteA;
	public MesAno getMesAnoReferenteA() {
		return _MesAnoReferenteA;
	}
	public void setMesAnoReferenteA( MesAno dado ) {
		_MesAnoReferenteA = dado;
	}
}
