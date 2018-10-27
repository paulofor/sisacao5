package coletorjava.modelo.derivadas;


import br.com.digicom.lib.*;
import java.util.List;

public interface DiaPregaoDerivadaI
 { 
	public DCIObjetoDominio getAnterior();
	public void setAnterior( DCIObjetoDominio dado );

	public long getDataInteiro();
	public void setDataInteiro( long dado );

	public DCIObjetoDominio getUltimaCotacaoProcessada();
	public void setUltimaCotacaoProcessada( DCIObjetoDominio dado );

	public List getListaCotacaoProcessada();
	public void setListaCotacaoProcessada( List dado );

}
