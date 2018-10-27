package coletorjava.modelo.agregados;


import coletorjava.modelo.*;

public interface ResultadoMesAssembledI
 { 
	public ProjetoDadoTreino getProjetoDadoTreinoGeradoPor();
	public void setProjetoDadoTreinoGeradoPor( ProjetoDadoTreino dado );
	public MesAno getMesAnoReferenteA();
	public void setMesAnoReferenteA( MesAno dado );
}
