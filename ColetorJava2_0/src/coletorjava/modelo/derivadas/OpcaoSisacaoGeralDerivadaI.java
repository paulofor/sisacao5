package coletorjava.modelo.derivadas;


import br.com.digicom.lib.*;
import java.util.List;

public interface OpcaoSisacaoGeralDerivadaI
 { 
	public String getDataVencimentoStr();
	public void setDataVencimentoStr( String dado );

	public String getEspecificacao();
	public void setEspecificacao( String dado );

	public String getNomeRes();
	public void setNomeRes( String dado );

	public long getTotalNegocioDiaAnterior();
	public void setTotalNegocioDiaAnterior( long dado );

	public float getValorCotacao();
	public void setValorCotacao( float dado );

	public long getQtdeNegocio();
	public void setQtdeNegocio( long dado );

}
