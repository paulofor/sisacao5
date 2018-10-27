package coletorjava.modelo.derivadas;


import br.com.digicom.lib.*;


import coletorjava.modelo.*;


public  class OpcaoReferenciaDerivada   implements OpcaoReferenciaDerivadaI { 
  private OpcaoReferencia principal;
      public OpcaoReferenciaDerivada( OpcaoReferencia itemPrincipal )
      {
      principal = itemPrincipal;
	}
}
