package coletorjava.modelo;

import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface OpcaoSisacaoGeral extends DCIObjetoDominio , OpcaoSisacaoGeralAgregadoI , OpcaoSisacaoGeralDerivadaI
{

	
	public long getIdOpcaoSisacaoGeral();
	public void setIdOpcaoSisacaoGeral(long valor);
	
	
	public String getCodigoMercado();
	public void setCodigoMercado(String valor);
	
	
	public float getPrecoExercicio();
	public void setPrecoExercicio(float valor);
	
	public String getPrecoExercicioFormatada();
	
	
	public String getDataInclusao();
	public void setDataInclusao(String valor);
	
	
	public String getMesAno();
	public void setMesAno(String valor);
	
	
	public String getDescricaoBdi();
	public void setDescricaoBdi(String valor);
	
	
	public boolean getColetaDiario();
	public void setColetaDiario(boolean valor);
	
	
	public boolean getPossuiColetaIntraday();
	public void setPossuiColetaIntraday(boolean valor);
	
	
	public boolean getPossui15minutos();
	public void setPossui15minutos(boolean valor);
	
	
	public long getIdTickerRa();
	public void setIdTickerRa(long valor);
	
	
}

