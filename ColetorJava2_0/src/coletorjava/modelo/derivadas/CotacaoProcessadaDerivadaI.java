package coletorjava.modelo.derivadas;


import br.com.digicom.lib.*;
import java.util.List;

public interface CotacaoProcessadaDerivadaI
 { 
	public String getLinhaLog();
	public void setLinhaLog( String dado );

	public String getLinhaTreino();
	public void setLinhaTreino( String dado );

	public DCIObjetoDominio getAnterior();
	public void setAnterior( DCIObjetoDominio dado );

	public DCIObjetoDominio getDiaPregao();
	public void setDiaPregao( DCIObjetoDominio dado );

}
