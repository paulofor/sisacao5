package coletorjava.modelo.derivadas;


import br.com.digicom.lib.*;
import java.util.List;

public interface OpcaoSisacaoDerivadaI
 { 
	public float getValorCotacao();
	public void setValorCotacao( float dado );

	public long getQtdeNegocio();
	public void setQtdeNegocio( long dado );

}
