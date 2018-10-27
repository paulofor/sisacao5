package coletorjava.modelo;

import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface Rede extends DCIObjetoDominio , RedeAgregadoI , RedeDerivadaI
{

	
	public long getIdRede();
	public void setIdRede(long valor);
	
	
	public long getQtdeHidden1();
	public void setQtdeHidden1(long valor);
	
	
	public long getQtdeHidden2();
	public void setQtdeHidden2(long valor);
	
	
	public long getQtdeHidden3();
	public void setQtdeHidden3(long valor);
	
	
	public String getUltimaAlteracao();
	public void setUltimaAlteracao(String valor);
	
	
}

