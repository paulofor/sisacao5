package coletorjava.modelo.ws;


import coletorjava.modelo.vo.*;
import coletorjava.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class EscolhaOpcaoObjetoWs   { 
      long _idEscolhaOpcao;
	public long getIdEscolhaOpcao() {
		return _idEscolhaOpcao;
	}
	public void setIdEscolhaOpcao( long dado ) {
		_idEscolhaOpcao = dado;
	}
      String _dataReferencia;
	public String getDataReferencia() {
		return _dataReferencia;
	}
	public void setDataReferencia( String dado ) {
		_dataReferencia = dado;
	}
      String _horaReferencia;
	public String getHoraReferencia() {
		return _horaReferencia;
	}
	public void setHoraReferencia( String dado ) {
		_horaReferencia = dado;
	}
      long _faixaEscolha;
	public long getFaixaEscolha() {
		return _faixaEscolha;
	}
	public void setFaixaEscolha( long dado ) {
		_faixaEscolha = dado;
	}
      long _idTickerRa;
	public long getIdTickerRa() {
		return _idTickerRa;
	}
	public void setIdTickerRa( long dado ) {
		_idTickerRa = dado;
	}
      long _idOpcaoSisacaoE;
	public long getIdOpcaoSisacaoE() {
		return _idOpcaoSisacaoE;
	}
	public void setIdOpcaoSisacaoE( long dado ) {
		_idOpcaoSisacaoE = dado;
	}
      long _idDiaPregaoRa;
	public long getIdDiaPregaoRa() {
		return _idDiaPregaoRa;
	}
	public void setIdDiaPregaoRa( long dado ) {
		_idDiaPregaoRa = dado;
	}
  private TickerObjetoWs _TickerReferenteA;
	public TickerObjetoWs getTickerReferenteA() {
		return _TickerReferenteA;
	}
	public void setTickerReferenteA( TickerObjetoWs dado ) {
		_TickerReferenteA = dado;
	}
  private OpcaoSisacaoObjetoWs _OpcaoSisacaoEscolha;
	public OpcaoSisacaoObjetoWs getOpcaoSisacaoEscolha() {
		return _OpcaoSisacaoEscolha;
	}
	public void setOpcaoSisacaoEscolha( OpcaoSisacaoObjetoWs dado ) {
		_OpcaoSisacaoEscolha = dado;
	}
  private DiaPregaoObjetoWs _DiaPregaoReferenteA;
	public DiaPregaoObjetoWs getDiaPregaoReferenteA() {
		return _DiaPregaoReferenteA;
	}
	public void setDiaPregaoReferenteA( DiaPregaoObjetoWs dado ) {
		_DiaPregaoReferenteA = dado;
	}
}
