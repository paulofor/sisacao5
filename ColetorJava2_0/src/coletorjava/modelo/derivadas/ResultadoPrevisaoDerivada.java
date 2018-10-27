package coletorjava.modelo.derivadas;


import br.com.digicom.lib.*;


import coletorjava.modelo.*;


public  class ResultadoPrevisaoDerivada   implements ResultadoPrevisaoDerivadaI { 
  private ResultadoPrevisao principal;
      public ResultadoPrevisaoDerivada( ResultadoPrevisao itemPrincipal )
      {
      principal = itemPrincipal;
	}
}
