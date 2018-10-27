package coletorjava.modelo.agregados;


import coletorjava.modelo.agregados.*;
import coletorjava.modelo.*;


public  class ResultadoMesAssembled   implements ResultadoMesAssembledI { 
  private ProjetoDadoTreino _ProjetoDadoTreinoGeradoPor;
	public ProjetoDadoTreino getProjetoDadoTreinoGeradoPor() {
		return _ProjetoDadoTreinoGeradoPor;
	}
	public void setProjetoDadoTreinoGeradoPor( ProjetoDadoTreino dado ) {
		_ProjetoDadoTreinoGeradoPor = dado;
	}
  private MesAno _MesAnoReferenteA;
	public MesAno getMesAnoReferenteA() {
		return _MesAnoReferenteA;
	}
	public void setMesAnoReferenteA( MesAno dado ) {
		_MesAnoReferenteA = dado;
	}
}
