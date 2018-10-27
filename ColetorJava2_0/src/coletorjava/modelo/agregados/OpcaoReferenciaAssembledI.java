package coletorjava.modelo.agregados;


import coletorjava.modelo.*;

public interface OpcaoReferenciaAssembledI
 { 
	public Ticker getTickerReferenteA();
	public void setTickerReferenteA( Ticker dado );
	public DiaPregao getDiaPregaoReferenteA();
	public void setDiaPregaoReferenteA( DiaPregao dado );
	public OpcaoSisacao getOpcaoSisacaoReferenteA();
	public void setOpcaoSisacaoReferenteA( OpcaoSisacao dado );
}
