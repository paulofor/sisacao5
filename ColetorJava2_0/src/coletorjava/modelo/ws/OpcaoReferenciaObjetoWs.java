package coletorjava.modelo.ws;


import coletorjava.modelo.vo.*;
import coletorjava.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class OpcaoReferenciaObjetoWs   { 
      long _idOpcaoReferencia;
	public long getIdOpcaoReferencia() {
		return _idOpcaoReferencia;
	}
	public void setIdOpcaoReferencia( long dado ) {
		_idOpcaoReferencia = dado;
	}
      long _idTickerRa;
	public long getIdTickerRa() {
		return _idTickerRa;
	}
	public void setIdTickerRa( long dado ) {
		_idTickerRa = dado;
	}
      long _idDiaPregaoRa;
	public long getIdDiaPregaoRa() {
		return _idDiaPregaoRa;
	}
	public void setIdDiaPregaoRa( long dado ) {
		_idDiaPregaoRa = dado;
	}
      long _idOpcaoSisacaoRa;
	public long getIdOpcaoSisacaoRa() {
		return _idOpcaoSisacaoRa;
	}
	public void setIdOpcaoSisacaoRa( long dado ) {
		_idOpcaoSisacaoRa = dado;
	}
  private TickerObjetoWs _TickerReferenteA;
	public TickerObjetoWs getTickerReferenteA() {
		return _TickerReferenteA;
	}
	public void setTickerReferenteA( TickerObjetoWs dado ) {
		_TickerReferenteA = dado;
	}
  private DiaPregaoObjetoWs _DiaPregaoReferenteA;
	public DiaPregaoObjetoWs getDiaPregaoReferenteA() {
		return _DiaPregaoReferenteA;
	}
	public void setDiaPregaoReferenteA( DiaPregaoObjetoWs dado ) {
		_DiaPregaoReferenteA = dado;
	}
  private OpcaoSisacaoObjetoWs _OpcaoSisacaoReferenteA;
	public OpcaoSisacaoObjetoWs getOpcaoSisacaoReferenteA() {
		return _OpcaoSisacaoReferenteA;
	}
	public void setOpcaoSisacaoReferenteA( OpcaoSisacaoObjetoWs dado ) {
		_OpcaoSisacaoReferenteA = dado;
	}
}
