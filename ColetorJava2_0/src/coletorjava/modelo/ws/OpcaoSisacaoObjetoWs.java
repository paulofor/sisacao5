package coletorjava.modelo.ws;


import coletorjava.modelo.vo.*;
import coletorjava.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class OpcaoSisacaoObjetoWs   { 
      long _idOpcaoSisacao;
	public long getIdOpcaoSisacao() {
		return _idOpcaoSisacao;
	}
	public void setIdOpcaoSisacao( long dado ) {
		_idOpcaoSisacao = dado;
	}
      String _codigoMercado;
	public String getCodigoMercado() {
		return _codigoMercado;
	}
	public void setCodigoMercado( String dado ) {
		_codigoMercado = dado;
	}
      float _precoExercicio;
	public float getPrecoExercicio() {
		return _precoExercicio;
	}
	public void setPrecoExercicio( float dado ) {
		_precoExercicio = dado;
	}
      String _dataInicioColeta;
	public String getDataInicioColeta() {
		return _dataInicioColeta;
	}
	public void setDataInicioColeta( String dado ) {
		_dataInicioColeta = dado;
	}
      long _idOpcaoSisacaoSeriePa;
	public long getIdOpcaoSisacaoSeriePa() {
		return _idOpcaoSisacaoSeriePa;
	}
	public void setIdOpcaoSisacaoSeriePa( long dado ) {
		_idOpcaoSisacaoSeriePa = dado;
	}
      long _idTickerDd;
	public long getIdTickerDd() {
		return _idTickerDd;
	}
	public void setIdTickerDd( long dado ) {
		_idTickerDd = dado;
	}
  private OpcaoSisacaoSerieObjetoWs _OpcaoSisacaoSeriePertenceA;
	public OpcaoSisacaoSerieObjetoWs getOpcaoSisacaoSeriePertenceA() {
		return _OpcaoSisacaoSeriePertenceA;
	}
	public void setOpcaoSisacaoSeriePertenceA( OpcaoSisacaoSerieObjetoWs dado ) {
		_OpcaoSisacaoSeriePertenceA = dado;
	}
  private TickerObjetoWs _TickerDerivativoDe;
	public TickerObjetoWs getTickerDerivativoDe() {
		return _TickerDerivativoDe;
	}
	public void setTickerDerivativoDe( TickerObjetoWs dado ) {
		_TickerDerivativoDe = dado;
	}
      float _valorCotacao;
	public float getValorCotacao() {
		return _valorCotacao;
	}
	public void setValorCotacao( float dado ) {
		_valorCotacao = dado;
	}
      long _qtdeNegocio;
	public long getQtdeNegocio() {
		return _qtdeNegocio;
	}
	public void setQtdeNegocio( long dado ) {
		_qtdeNegocio = dado;
	}
}
