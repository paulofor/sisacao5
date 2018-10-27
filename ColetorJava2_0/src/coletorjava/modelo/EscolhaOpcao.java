package coletorjava.modelo;

import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface EscolhaOpcao extends DCIObjetoDominio , EscolhaOpcaoAgregadoI , EscolhaOpcaoDerivadaI
{

	
	public long getIdEscolhaOpcao();
	public void setIdEscolhaOpcao(long valor);
	
	
	public String getDataReferencia();
	public void setDataReferencia(String valor);
	
	
	public String getHoraReferencia();
	public void setHoraReferencia(String valor);
	
	
	public long getFaixaEscolha();
	public void setFaixaEscolha(long valor);
	
	
	public long getIdTickerRa();
	public void setIdTickerRa(long valor);
	
	
	public long getIdOpcaoSisacaoE();
	public void setIdOpcaoSisacaoE(long valor);
	
	
	public long getIdDiaPregaoRa();
	public void setIdDiaPregaoRa(long valor);
	
	
}

