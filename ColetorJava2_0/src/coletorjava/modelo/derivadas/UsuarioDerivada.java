package coletorjava.modelo.derivadas;


import br.com.digicom.lib.*;


import coletorjava.modelo.*;


public  class UsuarioDerivada   implements UsuarioDerivadaI { 
  private Usuario principal;
      public UsuarioDerivada( Usuario itemPrincipal )
      {
      principal = itemPrincipal;
	}
}
