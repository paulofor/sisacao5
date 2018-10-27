package coletorjava.modelo.agregados;


import coletorjava.modelo.*;

public interface EscolhaOpcaoAssembledI
 { 
	public Ticker getTickerReferenteA();
	public void setTickerReferenteA( Ticker dado );
	public OpcaoSisacao getOpcaoSisacaoEscolha();
	public void setOpcaoSisacaoEscolha( OpcaoSisacao dado );
	public DiaPregao getDiaPregaoReferenteA();
	public void setDiaPregaoReferenteA( DiaPregao dado );
}
