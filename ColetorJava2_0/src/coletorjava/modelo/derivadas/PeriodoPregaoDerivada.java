package coletorjava.modelo.derivadas;


import br.com.digicom.lib.*;


import coletorjava.modelo.*;


public  class PeriodoPregaoDerivada   implements PeriodoPregaoDerivadaI { 
  private PeriodoPregao principal;
      public PeriodoPregaoDerivada( PeriodoPregao itemPrincipal )
      {
      principal = itemPrincipal;
	}
}
