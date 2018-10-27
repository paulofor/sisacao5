package coletorjava.modelo;

import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface Usuario extends DCIObjetoDominio , UsuarioAgregadoI , UsuarioDerivadaI
{

	
	public long getIdUsuario();
	public void setIdUsuario(long valor);
	
	
	public String getNomeUsuario();
	public void setNomeUsuario(String valor);
	
	
}

