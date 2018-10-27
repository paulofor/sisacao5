package coletorjava.modelo.agregados;


import coletorjava.modelo.agregados.*;
import coletorjava.modelo.*;


public  class DadoTreinoAssembled   implements DadoTreinoAssembledI { 
  private ProjetoDadoTreino _ProjetoDadoTreinoPossui;
	public ProjetoDadoTreino getProjetoDadoTreinoPossui() {
		return _ProjetoDadoTreinoPossui;
	}
	public void setProjetoDadoTreinoPossui( ProjetoDadoTreino dado ) {
		_ProjetoDadoTreinoPossui = dado;
	}
}
