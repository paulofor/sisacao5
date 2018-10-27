package coletorjava.modelo.derivadas;


import br.com.digicom.lib.*;


import coletorjava.modelo.*;


public  class DispositivoUsuarioDerivada   implements DispositivoUsuarioDerivadaI { 
  private DispositivoUsuario principal;
      public DispositivoUsuarioDerivada( DispositivoUsuario itemPrincipal )
      {
      principal = itemPrincipal;
	}
}
