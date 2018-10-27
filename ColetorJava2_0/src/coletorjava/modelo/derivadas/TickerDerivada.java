package coletorjava.modelo.derivadas;


import br.com.digicom.lib.*;


import coletorjava.modelo.*;


public  class TickerDerivada   implements TickerDerivadaI { 
  private Ticker principal;
      public TickerDerivada( Ticker itemPrincipal )
      {
      principal = itemPrincipal;
	}
}
