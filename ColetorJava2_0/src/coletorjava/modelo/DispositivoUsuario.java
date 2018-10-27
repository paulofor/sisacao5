package coletorjava.modelo;

import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface DispositivoUsuario extends DCIObjetoDominio , DispositivoUsuarioAgregadoI , DispositivoUsuarioDerivadaI
{

	
	public long getIdDispositivoUsuario();
	public void setIdDispositivoUsuario(long valor);
	
	
	public String getNumeroCelular();
	public void setNumeroCelular(String valor);
	
	
	public String getCodigoDispositivo();
	public void setCodigoDispositivo(String valor);
	
	
	public String getTipoAcesso();
	public void setTipoAcesso(String valor);
	
	
	public String getMelhorPath();
	public void setMelhorPath(String valor);
	
	
	public long getIdUsuarioRa();
	public void setIdUsuarioRa(long valor);
	
	
}

