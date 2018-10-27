package coletorjava.modelo.agregados;


import coletorjava.modelo.*;

public interface ResultadoPrevisaoAssembledI
 { 
	public DadoTheta getDadoThetaGeradoDe();
	public void setDadoThetaGeradoDe( DadoTheta dado );
	public ResultadoMes getResultadoMesMesmoPeriodo();
	public void setResultadoMesMesmoPeriodo( ResultadoMes dado );
	public MesAno getMesAnoReferenteA();
	public void setMesAnoReferenteA( MesAno dado );
}
